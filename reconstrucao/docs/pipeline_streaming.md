# Pipeline de streaming: da lista de canais aos pixels

Este documento descreve, de ponta a ponta, como o app transforma uma lista de canais (API REST) em vídeo na tela.
Os nomes são os da reconstrução (`com.foxivid.baselib.*`); o arquivo original (R8) está no KDoc de cada classe e em
`mapeamento/midia.tsv`.

## Visão geral

```
 ┌────────────────────────────── REDE (HTTPS, corpo cifrado: ApiCrypto) ──────────────────────────────┐
 │  GET /api/live/channel/list/v1   (pageId=1, pageSize=2000, checksum, token = stream token)         │
 │  GET <indexAddress>  → epg-index.json  → <channelId>.<pos> (um arquivo por canal/data, MD5)        │
 └───────────────┬────────────────────────────────────────────────────────────────────┬──────────────┘
                 │ ChannelListResponse                                                │ EpgIndex
                 ▼                                                                    ▼
        ┌──────────────────┐   channelEPGIndexResponse    ┌──────────────┐
        │  ChannelManager  │ ───────────────────────────► │  EpgManager  │  (cache em disco + LRU de 30)
        │ (a.java)         │                               │  (c.java)    │
        └────────┬─────────┘                               └──────┬───────┘
                 │ ChannelStreamResponse (streamId, route, catchup*, playerArgs)
                 ▼                                                │ EPGProgramme (start/stop) → catch-up
        ┌──────────────────┐                                      │
        │   PlayerView     │ startLive(channel) / startCatchup(channel, programme)
        │ → PlayerViewHandler (c0)  ── trial? (MediaPlayManager) ── sessão ──┐
        └────────┬─────────┘                                                 │
                 ▼                                                           │
        ┌──────────────────┐ params cifrados (AES + Base64):                 │
        │  StreamHelper    │ mediaId, routeId, mediaMode  / catch-up: streamId,
        │  (streaming/a)   │ catchupStreamId, route, start, stop             │
        └────────┬─────────┘                                                 │
                 │ (1) startEngine  (2) startPlay / startCatchup             │
                 ▼  HTTP GET, rotas ALEATÓRIAS (StreamingKeys), só 127.0.0.1 │
        ┌──────────────────┐                                                 │
        │  EngineHelper    │ ──────────► NioHttpServer (AndroidAsync, 127.0.0.1:<porta aleatória>)
        │  (client/a)      │                  │ HttpServiceWrapper (d) – rotas de controle + HLS local
        └────────┬─────────┘                  ▼
                 │ devolve a URL de play  EngineService (b) ⇄ StreamEngine (x6.c, motor proprietário
                 │                        UDP/tracker/PR, blocos TS)   ◄── trackers/peers (UDP)
                 │                                  │ PipedInputStream de blocos TS
                 │                                  ▼
                 │             NettyHttpServer (m) 0.0.0.0:<1024..51023> → LiveTsHandler (k)
                 │             GET /<liveTs>/<mediaId>.ts  → chunked video/mp2ts  (ao vivo, modo TS)
                 ▼
        URL final para o player:
          LIVE + proxyType=TS (padrão) → http://127.0.0.1:<portaNetty>/<liveTs>/<mediaId>.ts?<sessão>&<params>
          LIVE+HLS / VOD / CATCHUP     → http://127.0.0.1:<portaNio>/<liveM3u8>.m3u8?<sessão>&<params>
                 │
                 ▼
        ┌──────────────────┐  + "&<playerKey>=<player.hashCode()>"  (o proxy só atende players registrados
        │ VideoViewHandler │    via EngineHelper.addPlayer)
        │ (z0)             │  PlayerManager.create → IjkMediaPlayer (ou AndroidMediaPlayer se decodeMode=3)
        └────────┬─────────┘  setDataSource(url) + prepareAsync()
                 ▼
        SurfaceRenderView (SurfaceView, setDisplay) ─► VideoView (loading/erros) ─► PlayerView ─► PIXELS
```

## Etapas

### 1. Lista de canais (`ChannelManager.loadChannelList`)
- Exige **stream token** (`UserManager.A0()`); sem token não carrega.
- `GET /api/live/channel/list/v1` com `pageId=1`, `pageSize=2000`, `checksum` da resposta anterior, `token`,
  `did`, `uid`, `tenantId`, `appId`, `appVer`, `requestTime`. Se HTTP 404, cai para a API antiga
  `/api/meta/channel/list/v1`.
- **Cache por checksum**: o servidor devolve `ApiResult.checkSum`. Se vier `data == null` com o mesmo checksum,
  nada mudou. Próxima checagem: 12 h após sucesso, 5 min após falha, 15 s antes da 1ª carga (retry 15 s).
- `ChannelListResponse` traz `channelStreams` (cada `ChannelStreamResponse` com `streamId`, `route`, `type`,
  `catchup`, `catchupStreamId`, `catchupRoute`, `epgId`, `playerArgs`...), `categorySorts`, `playerArgs` globais e
  `channelEPGIndexResponse` (`indexAddress` + `checksum`). A chave interna do canal é `Objects.hash(streamId, route)`.
- `buildChannels` indexa por categoria/coluna (Todos, Histórico, Favoritos, Catch-up) em dois modos
  (sem/ com canais adultos, protegidos por PIN em `MediaConfigUtils`).

### 2. EPG (`EpgManager`)
- O índice vem do `channelEPGIndexResponse`; só é baixado depois que o player está pronto
  (`allowStart()` é chamado quando a 1ª URL de play fica pronta).
- `epg-index.json` (`Map<yyyyMMdd, List<EpgIndex>>`) é salvo em `AppPaths.epgCachePath()`; reaproveitado se o checksum
  salvo (`epg_index_last_checksum`) for igual. Cada `EpgIndex` = `{channelId, date, file(URL), checksum(MD5)}`.
- Cada canal/data vira um arquivo `<channelId>.<pos>` validado por MD5 (`DownloadUtils`, gzip). O parse do XMLTV/JSON
  é injetado pela app (`EpgFileParser`). Cache em memória: LRU de 30 arquivos. Reatualiza a cada 6 h.
- Consultas: programa atual/próximo por instante (`getProgrammeAt`, `getTwoProgrammesAt`), lista de datas, lista do dia.

### 3. Pedido de reprodução
- `PlayerView.startLive(channel)` → `PlayerViewHandler.startLive`; registra no histórico e verifica **trial**
  (`MediaPlayManager.trialOf`: assinante, privilégio free, ou tempo de teste restante).
- **Catch-up**: `startCatchup(channel, programme)` exige canal com `catchup=true`, usuário logado e tempo de
  assinatura ≥ duração do programa. O `mediaId` vira `<catchupRoute>#<streamId>#<startSeg>#<durSeg>` e
  `StreamHelper.createCatchupPlayFlow` envia `streamId, catchupStreamId, route, start, stop` (ms).
- `StreamHelper` reaproveita a sessão se mediaId/route/modo/usuário forem os mesmos e o motor estiver conectado;
  senão cria nova `session` (relógio monotônico) e, se mudou o usuário ou o tipo (LIVE/VOD/CATCHUP), **reinicia o motor**
  (`startEngine` com `streamServers`, stream token, uid, did, tenantId).

### 4. Proxy local (`streaming`)
- Os parâmetros (`mediaId`, `routeId`, ...) vão **cifrados** (AES/ECB/ZeroBytePadding + Base64 URL-safe) em query strings
  cujos nomes são **aleatórios a cada execução** (`StreamingKeys`).
- **AndroidAsync** (`NioHttpServer`): escuta só em `127.0.0.1`, porta aleatória; recebe as rotas de controle
  (`startEngine`, `stopEngine`, `startPlay`, `startCatchup`, `addPlayer`, `removePlayer`, `isConnected`,
  `refreshToken`, `getSubtitle`...) e serve **HLS local** (playlist + blocos) para VOD/catch-up e live em modo HLS.
- **Netty** (`NettyHttpServer`): porta aleatória em 1024..51023 (incrementa em `BindException`), `bind(port)` sem
  endereço, portanto **em todas as interfaces (0.0.0.0)**. Entrega o TS ao vivo contínuo em chunked
  (`video/mp2ts`); um único stream ativo por processo; valida sessão e params.
- `EngineService` fala com o motor proprietário (`StreamEngine`, nativo/dex2c): tracker (UDP), servidores PR,
  blocos TS; trata logout do tracker (sessão fora/versão/token expirado → `UserManager`), manda alertas ao bot e métricas.

### 5. Player e pixels
- `VideoViewHandler.setVideoPath` guarda URL/sessão/tipo (timeout de gateway 90 s em catch-up, 30 s no resto) e abre o
  vídeo: `PlayerManager.create` cria **IjkMediaPlayer** (decodeMode 3 = `AndroidMediaPlayer`), registra o player no
  proxy (`EngineHelper.addPlayer(session, player.hashCode())`) e anexa `&<playerKey>=<hashCode>` à URL.
- `setDataSource` + `prepareAsync`; falha → erro 405. Erros 404/404 = "sem sinal"; 405/406/407/504 ⇒ reinício.
- A superfície vem do `SurfaceRenderView` (`player.setDisplay(holder)`); o `VideoView` mostra loading/mensagens e o
  `PlayerView` é a fachada usada pelas telas (TV e mobile).

## Pontos de atenção (estudo)
- O servidor Netty fica exposto na rede local; a única barreira é a sessão + nomes/parâmetros aleatórios.
- Trechos não decompilados: `EpgManager.updateAll` (c.K), fluxos `programmesFlow`, `VoDManager.loadLocalPlaylist`,
  `ChannelManager.loadLocalColumns` e o motor `StreamEngine` (nativo). Estão marcados com `TODO` no código.
