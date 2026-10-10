# Engenharia reversa: evo.apk (com.live.evo 1.3.52)

Os caminhos de código são relativos a `jadx/sources/`.

## 1. Identificação

| Campo | Valor |
|---|---|
| Pacote / versão | `com.live.evo` 1.3.52 (versionCode 1010452), minSdk 21, targetSdk 35 |
| SHA1 | `ec21b011b0009a517782a3dfce22b7383fb7cb76` |
| Tipo | App de IPTV para STB/Android TV (leanback) e celular. Ao vivo, catch-up, VOD, esportes |
| Plataforma white-label | TENANT_ID 1002, BRAND_ID 100201, APP_ID 10020101, canal "evo". Headers `X-Foxivid-*` (backend "Foxivid") |
| Proteção | **360 Jiagu**: `com.stub.StubApp` + `assets/libjiagu*.so`. Os `onCreate` das Activities foram convertidos para nativo (dex2c) |
| Bibliotecas | ijkplayer/ffmpeg, OkHttp/Retrofit, Netty, AndroidAsync, Sophix (hotfix Alibaba), Bugly, Firebase, zxing, Paho MQTT (sem uso) |

## 2. Desempacotamento

O dex real fica cifrado depois do stub, dentro do `classes.dex` (marcador `qh\x00\x01` em 0x4090, com 5 entradas cifradas por RC4/custom em `libjiagu`).

1. Desempacotei dinamicamente, no aparelho root `192.168.1.19` (E10, Android 9), onde o mesmo APK já estava instalado e rodando.
2. Li `/proc/<pid>/mem` do `[heap]` e localizei headers dex pelo endian tag `0x12345678`.
3. Encontrei 4 dex completos, num total de 33 MB e 22.043 classes. Estão em `dex_desempacotado/`.

Os arquivos temporários no aparelho foram apagados.

## 3. Backend (hardcoded em `com/live/load/InitActivity.java` → `w()`)

| Servidor | Uso |
|---|---|
| `https://user.aleatorio.website:2053` | Conta: login, registro, refresh, recarga e upgrade |
| `http://user.aleatorio.website:2052` | Anúncios, canais e feedback (**HTTP sem TLS**) |
| `http://user.aleatorio.website:20528` | Central de mensagens / marquee |
| `https://meta.aleatorio.website:2096` | Lista de canais, URL de catch-up, VOD, índice de EPG |
| `https://emetrics.aleatorio.website:2083` | Métricas: `POST /api/metric/batch/v1` |
| `ulog.aleatorio.website:51000` | Log remoto por **UDP em texto claro** |
| `https://image.aleatorio.website` | Imagens |
| `https://sports.aleatorio.website:2053` | API de esportes |

O servidor pode trocar esses pools remotamente pelo "app properties" (`x1/f1/lb/host/b.java` `p()`).

### Endpoints principais

- **Conta (`x1/f1/lb/api/h.java`, `d.java`, `m.java`):**
  - `POST /api/v1/account/{login,guest/login,register,reset-password,captcha/send,recharge,code/recharge}`
  - `GET /api/v1/account/loginByToken?token=`
  - `GET /api/v1/account/token/refresh?refreshToken=`
  - `GET /api/v1/account/logout`
  - `GET /api/v1/upgrade/config`
  - `GET /api/v1/referral/summary`
- **Stream (`api/l.java`):**
  - `GET /api/live/channel/list/v1`
  - `GET /api/catchup/getPlayUrl/v1`
  - `GET /api/vod/videoDetail/get/v1`
  - `GET /api/meta/channel/list/v1`
- **Esportes (`api/j.java`):** `/api/v1/sports/home`, `/sports/{id}/tournaments`, `/tournaments/{id}/matches`
- **Feedback:** `POST /api/feedback/upload/v1`

### Autenticação

- O login usa usuário e **MD5(senha)**. Também há login de convidado e recarga por código de ativação.
- A sessão (access, refresh e stream token, além do digest da senha) fica em SharedPreferences, na chave `local_session`.
- Header `X-Foxivid-Authorization` = accessToken.

## 4. Protocolo criptográfico (`lf/b.java`, `pf/a.java`, `pf/b.java`)

**Requisição:**
1. A cada requisição o app gera `aesKey` e `iv` aleatórios de 16 bytes.
2. O corpo (POST) ou o JSON dos query params (GET, enviado no header `X-Data`) vai como `Base64(AES-128-CBC-PKCS5)`.
3. Headers enviados:
   - `X-Key` = RSA-PKCS1(chave pública embutida, aesKey)
   - `X-V` = Base64(iv)
   - `X-Timestamp`, `X-Nonce`
   - `X-Version: 1001`
   - `X-Sign` = `sha256hex(cipher + ts + nonce + "myQeN2Ql7NNL7I14DG2rGZ7dvR6TGNK2")`

**Resposta:**
1. Assinatura: `sha256hex(body + ts + nonce + "MDYcfn10w0SRglN87LkxGC3E13xLMgKN")`.
2. Decifragem: AES-CBC com **a mesma aesKey/iv gerada pelo cliente**.

**Consequência:** quem controla o cliente (hook ou MITM do próprio app) lê tudo. A chave privada RSA do servidor não é necessária, e os dois segredos de assinatura estão hardcoded.

## 5. Coleta de dados do dispositivo (`x1/f1/lb/util/z.java:273-345`)

O app coleta:
- todos os campos `Build.*`
- MAC eth0/wlan0 e `android_id`
- CID do eMMC
- serial de CPU (`/proc/cpuinfo`, sunxi, `cpu_chipid`)
- usid Amlogic (`/sys/class/unifykeys`)
- gateway (`ip route`), IPs, SSID/RSSI do Wi-Fi e bateria
- assinatura do sistema e flag de system app

Tudo isso vai em **todas** as requisições (`ApiRequestBasic.deviceInfo`). O `did` é `UUID.nameUUIDFromBytes(cpuSerial|MAC + MAC)`.

## 6. Achados de segurança / comportamento

| # | Achado | Onde |
|---|---|---|
| 1 | **TLS desabilitado**: TrustManager aceita tudo, HostnameVerifier retorna `true`, sem pinning. Vale para todo Retrofit, Glide e downloads. Há ainda `cleartextTrafficPermitted=true` | `of/e.java:42-74`, `util/r0.java`, `res/xml/network_security_config.xml` |
| 2 | **Chave privada RSA (PKCS#8) no manifest** (`com.taobao.android.hotfix.RSASECRET`), junto com IDSECRET/APPSECRET do Sophix. Qualquer pessoa consegue decifrar os patches de hotfix | Manifest; `com/taobao/sophix/e.java:47`, `v.java:150` |
| 3 | **Hotfix Sophix carregado a cada inicialização**, o que permite ao operador trocar código remotamente. `DownloadService` é exportado sem permissão | `MyApplication.java:73`; Manifest |
| 4 | **Servidor HTTP Netty escutando em todas as interfaces** (porta aleatória entre 1024 e 51023) para servir segmentos `.ts`. Fica acessível pela LAN | `x1/f1/lb/streaming/server/m.java:114`, `r.java:259` |
| 5 | **Captura silenciosa de logcat**: se o `did` do aparelho aparece na propriedade remota `feedback_exe_did`, o app grava o logcat (com `su`, se disponível) e envia ao servidor | `x1/f1/lb/heartbeat/f.java:2238`, `feedback/c.java:276-357` |
| 6 | **Todo log do app vai por UDP em claro** para `ulog...:51000`, com uid, did e MAC. Alguns logs imprimem access/refresh token | `x1/f1/lb/log/a.java`, `user/f.java:4714,4986` |
| 7 | **Instalação silenciosa** com `pm install -r` / PackageInstaller quando o app roda como uid 1000. A validação do APK baixado só compara meta-data, sem hash. Há helper que executa comandos via `su` | `x1/f1/lb/util/m0.java:158-176`, `util/p.java:41` |
| 8 | Notificação por "Telegram bot" (novo cliente com MAC/modelo, falhas de login). **Está vazia neste build** (`log.a.g()` é stub), mas pode ser ligada pela flag remota `is_telegram_bot_enable` | `x1/f1/lb/bot/a.java` |
| 9 | Permissões declaradas sem uso: WRITE_CONTACTS, READ_PHONE_STATE, location, SYSTEM_ALERT_WINDOW, KILL_BACKGROUND_PROCESSES, REQUEST_DELETE_PACKAGES, BOOT_COMPLETED (não há receiver). READ_CONTACTS só aparece em código zxing residual | — |
| 10 | Nenhuma detecção de root, emulador ou Frida em Java. Se existir, está no `libjiagu` nativo | — |

Outros identificadores: Bugly app id `b1897f2807` e Firebase Analytics (eventos `user_add_plan` e `user_version`).

## 7. Limitações

- O corpo dos `onCreate` protegidos por dex2c está em código nativo no `libjiagu` e não foi analisado.
- `x1/f1/lb/host/b.java` `g()` não decompilou. O mapeamento endpoint→pool foi deduzido dos parâmetros e dos metadados Kotlin.
- O cabeçalho do payload Jiagu indicava 5 entradas, mas só 4 dex estavam no heap. A quinta provavelmente não é dex.
