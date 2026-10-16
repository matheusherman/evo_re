# Pendências finais da reconstrução

Contagem de `TODO` em `src/main/java`: **0** (eram 246). Isso não quer dizer que tudo foi recuperado: o que não dá para recuperar foi trocado por comentários que explicam o motivo. Para achar cada um:

```bash
grep -rn "NÃO RECUPERÁVEL" src/main/java
grep -rn "INFERIDO" src/main/java
```

A reconstrução **ainda não foi compilada**. A última tentativa deu cerca de 2.400 erros, quase todos nomes que não batem entre módulos e imports faltando. Depois dela, os agentes ainda trocaram nomes em vários arquivos, então o número atual é desconhecido.

## 1. Não recuperável (9 pontos)

| Onde | O que falta | Motivo |
|---|---|---|
| `baselib/streaming/server/EngineService.kt`, `streaming/engine/EngineTypes.kt` | Motor de streaming do tracker: `x6.c` e componentes (`x6/y6/c7/e7/g7/h7`: cliente de tracker, cliente PR, cache de blocos) | Classes ausentes do dex ou sem corpo. O restante do pipeline (proxy Netty, `.ts` locais) está reconstruído |
| `com/live/evo/activity/LiveNewActivity.kt` | Classe `p5.a` (provável monitor de rede/publicidade) | Não existe no APK. No original a chamada é um no-op |
| `com/live/evo/catchup/CatchUp.kt` | Corpo de `x4/g$a.call` | Só o construtor e o campo `channelId` sobraram no APK |
| `com/live/evo_mobile/ui/MainFragments.kt` | Transação de fragment, títulos e adapters da tela principal mobile | Dependem dos bindings gerados `z4.*`, ofuscados, sem layout original |
| `com/live/evo_mobile/ui/MainViewActivity.kt` | Barra de abas (`z4.u`) e tratamento do evento `OnEvent(nf.z)` (diálogo `v7.c`) | Mesmo motivo; só o ramo do APK foi reconstruído |
| `com/foxivid/ui/mobile/widget/flexbox/FlexboxAliases.kt` | Comparação linha a linha da variante local do Flexbox | Mapeado como alias da biblioteca do Google, sem diferença de API observável |

## 2. Inferido (14 pontos)

- **Os `onCreate` nativos do Jiagu:** `InitActivity`, `LiveLoadActivity`, `LiveNewActivity`, `CatchUpPlayerActivity`, `SpeedTestActivity`, `SplashActivity`, `MainViewActivity` e `Login`. O corpo é código nativo que só existe em memória. Foram reconstruídos pela ordem dos helpers que sobraram no dex, pelos campos e pelos layouts. A ordem exata das chamadas é dedução.
- `LiveLoadActivity.onRequestPermissionsResult` (também nativo).
- `KeyboardView`: classe legada e sem uso, delega ao `KeyboardContainer`.
- `CommonModels`: o estilo do `toString` foi inferido (`SHORT_PREFIX_STYLE`).
- `EPG_Dstyle`: altura da linha herdada de `EPG`.

## 3. Bugs do original mantidos de propósito

- ENTER e OK nas grades de EPG lançam `NullPointerException`, porque o listener de clique foi removido do APK.
- `ChannelFragment.onChannelUpdateEvent` tem uma condição aparentemente invertida.
- `RemoteLogger`: o buffer UDP nunca é limpo, então o log remoto fica quebrado.
- `promotion_trial_days` é registrado duas vezes e o segundo handler vence.
- `FileDiskCacheUtil`: o latch nunca é liberado quando já existe mapeamento salvo.

## 4. Como fechar o que sobra

1. **Compilar:** rodar `gradle compileDebugKotlin` em `reconstrucao/` e corrigir os erros por pacote. O build já está montado (`build.gradle.kts`, recursos reais em `src/main/res`).
2. **`onCreate` nativos:** o código real está em `libjiagu.so` (não só no `.so` do APK, que está empacotado). Precisa do aparelho com root para extrair o `.so` descompactado da memória e desmontá-lo. Só vale a pena se for importante a ordem exata de inicialização.
3. **Motor do tracker:** só dá para reconstruir se as classes `x6.*` aparecerem num dump de memória de outra versão ou em execução.
