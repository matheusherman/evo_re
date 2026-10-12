# Fluxo de telas (com.live.evo)

Reconstruído de `com/live/load`, `com/live/evo/**` e `com/live/evo_mobile/**`. Quase todos os `onCreate` das Activities
são `native` (empacotador 360 Jiagu / dex2c); o que está abaixo vem dos métodos Java restantes, dos handlers/corrotinas e
dos metadados Kotlin — as partes inferidas estão marcadas como **(inferência)**.
O manifest limpo está em `src/main/AndroidManifest.xml` (Application real = `SophixStubApplication`, que delega a `MyApplication`).

## 1. Partida do processo

```
Zygote → SophixStubApplication (Sophix: busca patch; @SophixEntry → MyApplication)
       → MyApplication.onCreate : LogInit, AppUserManager.init, Toaster, Bugly, Sophix, etc.
       → InitActivity (LAUNCHER + LEANBACK_LAUNCHER, singleTask)
```

`InitActivity` (tema `Theme.WhitePageDemoSplash`):
1. inicializa o SDK do fornecedor (`InteractionUtils.init`: hosts `*.aleatorio.website`, appkey, chave pública RSA);
2. resolve o **tipo de app** — meta-data `APP_TYPE` do manifest (`"stb"`) ou o valor cacheado no KvStore;
3. espera **dois sinais** (latch): SDK pronto **e** `onResume`; então abre a próxima tela e se fecha 500 ms depois.

## 2. Bifurcação STB x mobile

| `APP_TYPE` | Tela seguinte | Orientação |
|---|---|---|
| `stb` (TV/box; padrão desta build) | `LiveLoadActivity` | landscape fixa |
| `mobile` | `SplashActivity` (evo_mobile) | livre / portrait no login |

O app inteiro é um único APK com duas UIs; `design_width_in_dp=1280` / `design_height_in_dp=720` (AutoSize) valem para a UI de TV.

## 3. STB — carregamento e login (`LiveLoadActivity`)

Máquina de estados dirigida por `Handler` (`MSG_*`):

```
onCreate (nativo) → setupViews + initSplashAds + startLoad   (inferência)
  startType == 1  → mostra login direto com a mensagem recebida (logout forçado / erro vindo de LiveNewActivity)
  senão: MSG_WAIT_APP_READY → permissões (MSG_REQUEST_PERMISSION) → MSG_INIT_RUNTIME_ENV (rede ok?)
         → MSG_NETWORK_OK → checkUpdate(silencioso) + MSG_QUERY_LOGIN
MSG_QUERY_LOGIN:
   · primeira abertura → MSG_SHOW_WELCOME  → WelcomeFragment → MSG_LOGIN
   · aviso adulto exigido → MSG_ADULT_WARNING → AdultWarningFragment (Entrar → MSG_LOGIN | Sair → exit)
   · logout forçado: versão não suportada → UpgradePromptDialog; senão login manual
   · senão → MSG_LOGIN
MSG_LOGIN  → login automático do SDK (MediaRepository.x0)
   ok               → MSG_REMIND
   código -3 (rede) → NetworkStatusDialogFragment e nova tentativa
   outro erro       → tela de login (AccountUserLoginFragment)
MSG_REMIND → lembrete de expiração/recarga (RechargeRemindFragment) ou direto MSG_FIX_DST
MSG_FIX_DST → ajuste de fuso (TimeZoneHelper) + "Loading data…" → carrega canais → LiveNewActivity
```

### 3.1 Telas de login/recarga (fragments em `fragment/login`, hospedados em `R.id.root` ou em `RechargeDialogFragment`)

Navegação feita por `LoginNavigator` (original `e5/*`), com callbacks:

```
RechargeRemindFragment ──recarregar──> ScanedRechargeFragment ──pago──> LoginFinishFragment(tipo 9|0) ──> MSG_FIX_DST
        │ pular ──> MSG_FIX_DST            │ voltar ──> RechargeRemind (ou login)
        └ entrar ──> AccountUserLoginFragment (abas 1=e-mail/usuário, 2=telefone, 3=renew code)
AccountUserLoginFragment
   ├─ login ok ───────────────> MSG_ACTIVATE (carrega dados)  [LoginPresenter → MediaRepository.y0 / w0]
   ├─ "Registrar" ────────────> RegisterEmailFragment ──ok──> LoginFinishFragment(10 | 7 | 3)
   ├─ "Esqueci a senha" ──────> ResetAccountPasswordFragment ──ok──> LoginFinishFragment(6)
   └─ renew code ─────────────> RenewCodeLoginSupportFragment(tipo 40/41/42)
                                    ├─ recarregar depois ──> RechargeDialogFragment(25)
                                    └─ ok ──> MSG_ACTIVATE
```

Tipos de `LoginFinishFragment` (`arg_remind_type`): 0 recarga ok · 3/5 cadastro · 6 reset de senha · 7/10 cadastro com
recarga (contagem 120 s) · 8 código vinculado · 9 primeiro login por renew code.

`RechargeDialogFragment` (também usado de dentro da live) escolhe a tela inicial pelo `type`:
21/23 recarga mini · 22 login · 24 lembrete de expiração · 25 verificar conta · 26 dica de vínculo · 40–42 renew code ·
49 conclusão mini · 50/51 BFF · 53 compartilhar código · 54 aba de recarga.

## 4. STB — live (`LiveNewActivity`, singleTask, tema `PlayLoad`)

* Reprodução: `startPlay → playStream` (TsProxyServer/ijk do baselib), OSD com camadas `OsdLayerManager`
  (rede, número/nome, "otimizando", "carregando", sinal fraco).
* Teclas do controle remoto:
  * **OK/ENTER** → menu de canais (`OSDListProgramPresenter` → `ChannelFragment`, tag "Channel List");
  * **MENU** → `PopupMenuC` lateral (EPG, versão/update) ou `ProgramMenuDialogFragment` ("program_menu");
  * **←** → banner do canal atual (`PopupCurrentEpgWindow`); **→** e demais → `EpgDialog` (grande EPG por dia);
  * **0–9** → troca por número; **↑/↓** → canal anterior/seguinte; **SEARCH** → `SearchFragment`.
* `ProgramMenuDialogFragment`: abas CHANNEL, FUNCTION (`FunctionMenuFragment`: Favoritos, Histórico, Busca, Mensagens,
  Info, PIP, Bloqueio), HOME/RECOMMEND, SUBJECT_n (esportes), PHONESCAN, "My Account", "Renew".
* Falta de plano / sessão expirada → `RechargeDialogFragment` (22 = login, 54 = recarga); logout forçado → volta a `LiveLoadActivity`.
* Falhas de rede → `NetworkStatusDialogFragment` (teste caixa → roteador → internet → servidor).
* Lembretes de programação → `SubscribePopup` (assistir/ignorar) / `SubscribeSwitchDialog`.
* Atualização do app → `UpgradePromptDialog` (obrigatória ou opcional).
* Teste de velocidade → `SpeedTestActivity` (aberta a partir do `ChannelFragment`).

### 4.1 Catch-up

```
EpgDialog / ChannelFragment (lista EPG) / SubjectMatchFragment
   └─ LiveCatchUpClickHandler.onCatchUpClick(tipo, programa, canal)
         valida (fim > início, fim <= agora, ModelHelper.isCatchUpAvailable)
         └─ CatchUpPlayerActivity.start(...)   (startActivityForResult, requestCode 3)
               player LiveCatchUpVideoView + CatchUpMediaController (←/→ seek, OK play/pause, ↑ foco)
               resultado = índice do canal + 1  → LiveNewActivity volta a esse canal
```

## 5. Mobile (`evo_mobile`)

```
InitActivity ──(APP_TYPE=mobile)──> SplashActivity
   anúncios de abertura (startup_ad_list, contagem; toque cancela)
   login automático MediaRepository.x0()
      ok               → aguarda canais → MainViewActivity
      -3 (rede)        → diálogo de retry (network_not_connect)
      outro erro       → LoginTypeActivity(loginFrom=0)

LoginTypeActivity (ViewPager sem swipe; pilha stepRecord)
   0 LoginEntryFragment → 1 LoginAccountFragment (e-mail/telefone) / 2 CreateAccountFragment / 3 ResetPasswordFragment
   fim → MainViewActivity (se loginFrom == START) ; senão finish()
   loginFrom: 0 START, 1 ACCOUNT, 2 ME_ICON (Perfil), 3 PLAYER

MainViewActivity (frame_content + barra de abas)
   TV (MainTVFragment: player + gestos) · Guia (EpgListFragment) · Lembretes (SubscribeListFragment) · Perfil (ProfileFragment)
   timer de 3 s verifica lembretes; evento de upgrade → diálogo (forçado se forceUpgrade == 1)
   busca → SearchLiveActivity · Perfil → Favoritos/Histórico (FavoriteListActivity/HistoryListActivity),
   Conta (sem conta → LoginTypeActivity loginFrom=2; com conta → AccountManageActivity → AccountLinkActivity),
   Renovar → RenewActivity, Configurações → SettingsActivity → AboutUsActivity, Compartilhar → ShareActivity
```

## 6. Tabela rápida de Activities do manifest

| Activity | Versão | Papel |
|---|---|---|
| `load.InitActivity` | ambas | entrada, init do SDK, roteamento |
| `activity.LiveLoadActivity` | STB | carregamento/login |
| `activity.LiveNewActivity` | STB | player + OSD |
| `activity.CatchUpPlayerActivity` | STB | catch-up |
| `activity.SpeedTestActivity` | STB | teste de rede |
| `media.activity.SplashActivity` | mobile | splash/login automático |
| `ui.login.LoginTypeActivity` | mobile | login/cadastro |
| `ui.MainViewActivity` | mobile | home |
| `ui.SearchLiveActivity`, `HistoryListActivity`, `favorite.FavoriteListActivity`, `SettingsActivity`, `SettingsDetailActivity`, `AboutUsActivity`, `ShareActivity`, `AccountManageActivity`, `AccountLinkActivity`, `RenewActivity` | mobile | telas secundárias |
