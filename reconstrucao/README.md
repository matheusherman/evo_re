# evo.apk reconstruído (material de estudo)

Reconstrução em Kotlin, com nomes legíveis, do app `com.live.evo` 1.3.52 (IPTV para TV box e celular). O código original estava ofuscado (R8) e protegido com 360 Jiagu. O relatório da análise está em `../RELATORIO.md`.

**Aviso:** nada aqui foi compilado. O código serve para ler e estudar. Onde o jadx falhou, ou onde o código é nativo (os `onCreate` das Activities), há `TODO` e a indicação de que o trecho é inferido.

Números: 260 arquivos Kotlin, cerca de 35 mil linhas, 379 `TODO` em 91 arquivos, 758 classes no índice de mapeamento.

## Como ler

1. `docs/fluxo_telas.md`: como o app abre e navega.
2. `docs/fluxo_autenticacao.md`: login, token, refresh e sessão.
3. `docs/pipeline_streaming.md`: da lista de canais até o vídeo na tela.
4. `docs/propriedades_remotas.md`: as 71 chaves que o servidor pode mudar remotamente.
5. `docs/bibliotecas_terceiros.md`: bibliotecas embutidas e onde estão no código ofuscado.
6. `mapeamento/INDICE_COMPLETO.tsv`: nome ofuscado → nome real (também separado por módulo em `mapeamento/*.tsv`).

Cada classe Kotlin tem no KDoc a linha `Original: <caminho ofuscado>`, que aponta para `../jadx/sources/`.

## Arquitetura

```
com.live.evo (app)                 telas de TV (Live, OSD, catch-up) e mobile
  │  usa
  ▼
com.foxivid.ui                     widgets de TV/mobile, teclado virtual, banner
  │
com.foxivid.baselib  (SDK "Foxivid", base do white-label)
  ├─ config      inicialização (InteractionUtils.b0, BaseLibConfig)
  ├─ crypto      AES-CBC por requisição + RSA + assinatura SHA-256
  ├─ network     OkHttp (TrustAll), interceptors, headers X-Foxivid-*
  ├─ host        pools de servidores (ACCOUNT, CHANNEL, STREAM_META, ...)
  ├─ api / model Retrofit + modelos
  ├─ user        UserManager, PTV3AAdapter (login, guest, recarga, refresh)
  ├─ device      DeviceInfoCollector, Installation (did)
  ├─ media       canais, EPG, catch-up, VOD, esportes
  ├─ streaming   proxy Netty de segmentos .ts, tracker
  ├─ player      PlayerView sobre ijkplayer
  ├─ heartbeat   propriedades remotas, verificação de atualização
  ├─ upgrade     download e instalação do APK
  ├─ feedback    captura de logcat e envio
  ├─ log / bot   log UDP remoto, bot do Telegram (desligado)
  ├─ metric      métricas em lote
  └─ ad / marquee / cache / util
```

## Pontos de estudo

- **Proteção:** o stub `StubApp` carrega o dex real, cifrado. Veja `../RELATORIO.md`, seção 2.
- **Protocolo cripto:** `crypto/ApiCrypto.kt` e `crypto/ApiCryptoDemo.kt` (demonstração em JVM puro, não executada).
- **Comportamentos de segurança notáveis:** TLS que aceita qualquer certificado (`network/HttpClientFactory.kt`), captura remota de logcat por `feedback_exe_did` (`heartbeat/AppPropertyHandlers.kt`), proxy HTTP em todas as interfaces (`streaming/server`).
- **Bugs preservados de propósito:** por exemplo, o logger UDP nunca limpa o buffer e `promotion_trial_days` é registrado duas vezes. Estão comentados nas respectivas classes.

## Lacunas conhecidas

- Corpos dos `onCreate` das Activities (código nativo do Jiagu): só inferidos.
- Funções que o jadx não decompilou: `EpgManager.updateAll`, `VoDManager.loadLocalPlaylist`, parte da API de esportes, `BaseChannelListFragment.coverStoryList`.
- `ChannelFragment` (cerca de 5 mil linhas) está como esqueleto documentado. Vários fragmentos de login, recarga e menu são stubs.
- Referências entre módulos usam nomes deduzidos e podem não bater entre si.
