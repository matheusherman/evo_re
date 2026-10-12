# Convenções da reconstrução

Fonte descompilada (jadx, R8-ofuscada): `/Users/matheus/evo_re/jadx/sources/`
Destino: `/Users/matheus/evo_re/reconstrucao/src/main/java/`

## Regras
- Kotlin. Nomes de classes/métodos/campos em inglês, legíveis (estilo Android). Comentários/KDoc em **português**.
- **Fidelidade**: reproduzir a lógica que existe no código descompilado. Não inventar comportamento.
  Quando algo não decompilou ou é nativo (Jiagu dex2c), escrever `TODO("nativo/não decompilado: ...")` e explicar.
- Cada classe começa com KDoc contendo `Original: <caminho/ofuscado.java>` (vários, se fundir classes) e o que ela faz.
- Métodos importantes: KDoc com `Original: <classe>.<metodoOfuscado>()`.
- Constantes/strings/segredos/URLs: manter os valores reais do código (é material de estudo).
- Remover ruído de corrotinas/state machines do Kotlin: reescrever como `suspend fun` limpa.
- Bibliotecas de terceiros (OkHttp, Retrofit, Gson, Netty, ijkplayer, Glide...): usar a API real delas, não reconstruir.
- O código não precisa compilar contra o projeto inteiro, mas deve ser coerente: use os nomes de tipos da tabela abaixo para referências entre módulos.
- Classes de modelo (data classes) já têm nomes reais no original (z1/b1/lb/m/...): manter nomes e `@SerializedName`.

## Pacotes (raiz legível)
| Pacote reconstruído | Original | Conteúdo |
|---|---|---|
| `com.foxivid.baselib.config` | x1/f1/lb/config, t/v/c/i/a (InteractionUtils) | inicialização do SDK, `BaseLibConfig` |
| `com.foxivid.baselib.crypto` | lf/b, pf/a, pf/b | `ApiCrypto`, `CryptoRequestInterceptor`, `CryptoResponseInterceptor` |
| `com.foxivid.baselib.network` | of/*, x1/f1/lb/streaming/client/d | `HttpClientFactory`, `HeaderInterceptor`, `TrustAllCerts` |
| `com.foxivid.baselib.host` | x1/f1/lb/host | `ServerProviderUtils`, `ServerPool` (enum) |
| `com.foxivid.baselib.api` | x1/f1/lb/api | interfaces Retrofit (`AccountApi`, `PtvAccountApi`, `StreamMetaApi`, `SportsApi`, `FeedbackApi`, `MetricApi`, `UpgradeApi`, `MessageApi`, `RechargeApi`), `PTVApi3AClient` |
| `com.foxivid.baselib.model.*` | z1/b1/lb/m/* | modelos (`ApiRequestBasic`, `LoginRequest`, `PTVLoginInfo`, ...) |
| `com.foxivid.baselib.user` | x1/f1/lb/user | `UserManager` (user/f), `PTV3AAdapter` (user/d), `AccountAdapter` (interface), `LocalSessionInfo` |
| `com.foxivid.baselib.device` | x1/f1/lb/util/z, x1/f1/lb/id | `DeviceInfoCollector`, `Installation` (did) |
| `com.foxivid.baselib.heartbeat` | x1/f1/lb/heartbeat | `HeartbeatManager`, `AppPropertyHandlers` |
| `com.foxivid.baselib.upgrade` | util/m0, util/PackageInstallManager, util/p | `ApkInstaller`, `PackageInstallManager`, `ShellUtils` |
| `com.foxivid.baselib.feedback` | x1/f1/lb/feedback | `LogCatHelper`, `FeedbackUploader` |
| `com.foxivid.baselib.log` | x1/f1/lb/log, d7/* | `RemoteLogger`, `UdpLogSender` |
| `com.foxivid.baselib.bot` | x1/f1/lb/bot | `TelegramBot` |
| `com.foxivid.baselib.metric` | x1/f1/lb/metric, uf/* | `MetricReporter`, monitores |
| `com.foxivid.baselib.media` | x1/f1/lb/media | `MediaRepository` (canais, EPG, catch-up, VOD) |
| `com.foxivid.baselib.streaming` | x1/f1/lb/streaming | `TsProxyServer` (netty), `StreamingClient`, tracker |
| `com.foxivid.baselib.player` | x1/f1/lb/widget/videoview, t/v/c/widget/videoview | `PlayerView` e wrappers ijkplayer |
| `com.foxivid.baselib.ad` / `.marquee` / `.cache` / `.util` | x1/f1/lb/ad, marquee, cache, util | `AdManager`, `MarqueeManager`, `BaseCache`, `FileDiskCacheUtil` |
| `com.foxivid.ui` | t/v/c/*, com/tvc/lib/mobile/* | biblioteca de UI compartilhada (TV e mobile) |
| `com.live.evo` | com/live/evo, com/live/load, com/live/evo_mobile | app: activities, fragments, OSD, login, catch-up |

## Mapeamento
Cada agente escreve `reconstrucao/mapeamento/<modulo>.tsv` com colunas TAB:
`original_path	nome_reconstruido_FQN	descricao_curta`
(uma linha por classe original relevante; inclua classes internas importantes como `arquivo.java$X`).
