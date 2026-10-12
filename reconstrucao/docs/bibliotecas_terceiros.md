# Bibliotecas de terceiros no APK com.live.evo

Fonte: `/Users/matheus/evo_re/jadx/sources/`. O R8 jogou boa parte das bibliotecas em pacotes de
1 a 2 letras (`a/`, `b0/`, `c9/` ...). Muitas outras continuam com o nome original. As
identificações abaixo saíram de amostragem: strings literais, mensagens de exceção, arrays `d2` do
metadata Kotlin e imports. A coluna "confiança" diz quanto confio em cada uma.

> Pacotes curtos ganham nomes de forma independente em cada dex. Por isso uma mesma biblioteca
> pode aparecer espalhada por vários pacotes (ex.: Glide em `s/`, `p/`, `l/`, `w/`, `b0/`, `a0/`).
> E um mesmo pacote curto pode juntar classes de origens diferentes (o R8 faz merge de classes
> sintéticas).

## Pacotes ofuscados identificados

| pacote ofuscado | biblioteca real | evidência | confiança |
|---|---|---|---|
| `r8/` | Kotlin stdlib (núcleo: `r8.z` = `Unit`, `r8.p` = `Pair`, `r8.u` = `Triple`, `r8.r` = `ResultKt`/`Result`) | `d2` com "kotlin-stdlib", `first/second/third`, `initializer` (Lazy) | alta |
| `c9/` | Kotlin stdlib `kotlin.jvm.functions` (`c9.a` = Function0, `c9.l` = Function1, `c9.p` = Function2, `c9.q` = Function3) | interfaces só com `invoke`, "kotlin-stdlib" | alta |
| `v8/` | Kotlin stdlib `kotlin.coroutines` (`v8.f` = `Continuation`, `v8.j` = `CoroutineContext`) | "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext", `baseKey`, `safeCast` | alta |
| `ua/` | Kotlin stdlib `kotlin.text` (`ua.n` = StringsKt, `ua.d` = Charsets, `ua.l` = Regex) | assinaturas de `split/replace/StringBuilder`, "kotlin-stdlib" | alta |
| `i9/` | Kotlin stdlib reflexão leve (`kotlin.jvm.internal`/`TypesJVM`) | `typeToString`, `getClassifier`, `getSetter` | média |
| `a/` | kotlinx-coroutines-core (debug: `ARTIFICIAL_FRAME_PACKAGE_NAME`, `_COROUTINE`) | strings "kotlinx-coroutines-core", "_COROUTINE" | alta |
| `wa/` | kotlinx-coroutines-core `scheduling` (`CoroutineScheduler`, `DefaultDispatcher`) | "should not exceed maximal supported number of threads 2097150", "kotlinx.coroutines.scheduler.core.pool.size" | alta |
| `tb/`, `ub/` | Okio (`tb.d` = Buffer, `tb.g` = ByteString; `ub` = `-Util`/hex de ByteString) | "okio", `source/sink`, "Unexpected hex digit:", `HEX_DIGIT_CHARS` | alta |
| `hb/` | OkHttp `okhttp3.internal.Util` (`hb.d.m` = `closeQuietly`) | `asFactory`, `(Ljava/io/Closeable;)V` | alta |
| `kb/` | OkHttp `internal.concurrent` (TaskRunner/TaskQueue) | `java.util.logging.Logger`, `Thread.currentThread().getName()` | média |
| `lb/` | OkHttp `internal.http` (RealInterceptorChain, BridgeInterceptor, RetryAndFollowUp) | `d2`: `userRequest`, `cookieJar`, `client` | alta |
| `mb/` | OkHttp `internal.http1` (Http1ExchangeCodec) | "Cannot stream a request body without chunked encoding or a known content length!" | alta |
| `nb/` | OkHttp `internal.http2` | `d2` com source/sink, frames | média |
| `ob/`, `pb/` | OkHttp `internal.platform` (AndroidPlatform, Conscrypt/BouncyCastle socket adapters) | "ALPN callback dropped: HTTP/2 is disabled", `sslSocket`, `clientProviderClass` | alta |
| `b3/`, `e3/`, `f3/` | Gson internals (`internal.bind`, adapters SQL Date/Time; `f3.a` = `TypeToken`) | "Register a TypeAdapter for this type or adjust the access filter", "as SQL Time; at path" | alta |
| `s/`, `p/`, `l/`, `w/`, `b0/`, `a0/` (mais `u/`, `q/`, `k/`, `z/`) | Glide 4 (`load.resource.bitmap`, `load.model`, engine, `gif`, `request.target`, `RequestOptions`) | "com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", "You must not call setTag() on a view Glide is targeting", "Glide request origin trace" | alta |
| `h3/`, `h4/`, `y5/`, `v5/`, `w5/`, `b4/` (parte) | ZXing core (`y5.a` = `QRCodeWriter`, `v5.a` = `BarcodeFormat`, `v5.b` = `EncodeHintType`, `w5.b` = `BitMatrix`; `h3` = LuminanceSource/Binarizer; `b4` = decoder QR) | "Can only encode QR_CODE, but got", "Binarizer must be non-null.", "Decoding invalid alphanumeric value:" | alta |
| `xe/` | greenrobot EventBus 3 (`xe.c` = `EventBus`) | "Please consider using EventBus annotation processor", "Subscriber to unregister was not registered before:" | alta |
| `wb/` | Apache commons-codec (`wb.a` = `Base64`) | "lineSeparator must not contain base64 characters", "codecPolicy" | alta |
| `yb/` | Apache commons-io (`yb.c` = `FileUtils`, `yb.e` = `IOUtils`) | "Destination must not be null", "Failed to copy full contents from '" | alta |
| `ac/` | Apache commons-lang3 (`ac.g` = `StringUtils`, `SystemUtils`, `Validate`) | "the SystemUtils property value will default to null.", "Cannot get the toString of a null identity" | alta |
| `dd/` | BouncyCastle provider (`dd.a` = `BouncyCastleProvider`) | lista de `org.bouncycastle.jce.provider.BrokenJCEBlockCipher$...` | alta |
| `xd/` | Provavelmente BouncyCastle PQC (parâmetros XMSS/SPHINCS) ligado ao Sophix | "size of secretKeySeed needs to be equal to size of digest", "length of publicSeed must be equal to length of digest"; importa `com.taobao.sophix` | média/baixa |
| `m6/`, `k6/`, `l6/` | skydoves Sandwich (extensões de `ApiResponse`: `suspendOnError/Exception`, mappers) | `d2` "apiResponse", "sandwich"; assinaturas com `com/skydoves/sandwich/a$b$a` | alta |
| `we/` | Eclipse Paho MQTT v3 (mensagens/NLS) | "org.eclipse.paho.client.mqttv3.internal.nls.messages", "MqttException" | alta |
| `q4/`, `r4/`, `s4/`, `t4/`, `o4/`, `p4/`, `u4/` | AndroidAsync (koushikdutta): servidor HTTP, multipart | "No boundary found for multipart/form-data"; importam `com.koushikdutta.async` | alta |
| `l4/` | Toaster (com.hjq.toast): estilos/validação | "You must set the ID value of TextView to android.R.id.message" | alta |
| `l7/`, `k7/`, `o7/` | UTDID / Aliyun (audid, `UtExtendTrustManager`) | "https://mpush-api.aliyun.com/v2.0/a/audid/req/", "UtExtendTrustManager" | alta |
| `m2/` | Firebase Components (`ComponentRuntime`, registrars) | "Components are not allowed to depend on interfaces they themselves provide" | alta |
| `b2/` (e `j2/`, `v2/`, `x2/`, `z2/`, `u2/`) | Google Play Services Measurement (Firebase Analytics) | "com.google.android.gms.measurement.internal.IUploadBatchesCallback" | alta |
| `d8/` | Netty util (fragmento) | importa só `io.netty.util` | média |
| `org/slf4j/impl` + `df/` | Binding slf4j-log4j12 (`df.a` = `LocationAwareLogger`) | "This version of SLF4J requires log4j version 1.2.12 or later" | alta |

### `q6/`: fachada de log própria do SDK (não é SLF4J)

`q6/` não é SLF4J nem logback. São três classes mínimas no estilo SLF4J:

- `q6.b`: interface `Logger` com `a` (= info), `debug`, `warn`, `error`;
- `q6.c`: `LoggerFactory`, onde `d(Class)` faz o papel de `getLogger`, `e(q6.a)` instala o
  backend e `b/c` substituem os placeholders `{}`. Um `Throwable` passado como argumento extra
  vira a exceção do log;
- `q6.a`: interface de backend. O backend padrão imprime em `System.out` com
  `"yyyy-MM-dd HH:mm:ss.SSS [ L ] tag msg"`.

O app instala o backend real em `BaseLibConfig.s()` com `q6.c.e(new b$g())`. Esse backend manda
para o logcat (só em debug) e envia os níveis I/W/E também ao `RemoteLogger`. Na reconstrução,
essa fachada aparece representada pela API `org.slf4j`.

## Bibliotecas com nome original (não ofuscadas)

| raiz | biblioteca |
|---|---|
| `kotlin/`, `kotlinx/` (parcial) | Kotlin stdlib / kotlinx.coroutines (o restante está nos pacotes curtos acima) |
| `androidx/`, `android/support/v4` | AndroidX (Room/Paging/Lifecycle/DataBinding/ConstraintLayout/ExifInterface...) e support v4 antigo |
| `okhttp3/` | OkHttp 4 (API pública; os internals estão em `hb`..`pb`) |
| `retrofit2/` | Retrofit 2 |
| `com/google/gson` | Gson (API pública; os internals estão em `b3/e3/f3`) |
| `com/google/zxing` | ZXing (parte; o resto está em `h3/h4/y5/v5/w5/b4`) |
| `com/google/firebase`, `com/google/android` | Firebase (Analytics, Installations, Common) / GMS |
| `com/bumptech/glide` | Glide 4 (API pública; o core está em `s/p/l/w/b0/a0`) |
| `com/journeyapps/barcodescanner` | zxing-android-embedded |
| `com/blankj/utilcode` | AndroidUtilCode (Blankj) |
| `com/hjq/toast` | Toaster (getActivity) |
| `com/koushikdutta/async` | AndroidAsync |
| `com/pengrad/telegrambot` | java-telegram-bot-api (pengrad), usado pelo `TelegramBot` do baselib |
| `com/skydoves/sandwich` | Sandwich |
| `com/taobao/sophix` | Alibaba Sophix (hotfix) |
| `com/tencent/bugly` | Tencent Bugly (crash report) |
| `com/ta/utdid2` | UTDID (Alibaba) |
| `com/franmontiel/persistentcookiejar` | PersistentCookieJar |
| `com/dianping/logan` | Logan (Meituan): log em arquivo |
| `com/scwang/smart` | SmartRefreshLayout |
| `com/chad/library` | BaseRecyclerViewAdapterHelper |
| `com/youth/banner` | youth5201314 Banner (o app também tem um fork próprio em `t/v/c/widget/banner`) |
| `com/purple/crane/speedtest` | módulo de speedtest (só recursos/R; origem não identificada, provavelmente de fornecedor) |
| `io/netty` | Netty 4 (bootstrap, buffer, channel, handler, resolver), usado pelo proxy TS (`TsProxyServer`) |
| `io/reactivex/rxjava3` | RxJava 3 (fragmento: internal/subjects) |
| `org/apache/log4j` | log4j 1.2 (o jadx mostra constantes como `Priority.WARN_INT` = 30000 e `FileWatchdog.DEFAULT_DELAY` = 60000 onde o código só usa números) |
| `org/slf4j` | SLF4J API + binding log4j12 |
| `org/eclipse/paho` | Eclipse Paho MQTT v3 |
| `org/greenrobot/eventbus` | EventBus (anotações; o core está em `xe/`) |
| `me/jessyan/autosize` | AndroidAutoSize |
| `tv/danmaku/ijk` | ijkplayer (Bilibili): `IjkMediaPlayer`, `IjkMediaMeta` (detalhes na seção "ijkplayer" abaixo) |
| `com.stub.StubApp` (só referenciado, a classe não está no dex) | Shell de proteção Jiagu (360), injetado em runtime: `StubApp.getOrigApplicationContext`; partes do código são nativas (dex2c) |

## Pacotes do próprio app (não são terceiros)

| pacote | conteúdo |
|---|---|
| `x1/f1/lb/**` | baselib (SDK do fornecedor: config, api, user, host, heartbeat, media, streaming, ad, marquee, util...) |
| `z1/b1/lb/m/**` | modelos de dados (nomes reais preservados) |
| `t/v/c/**` | biblioteca de UI compartilhada para TV (widgets `My*`, `GlobalMarqueeTextView`, fork do banner, ratingbar, legendas) |
| `com/tvc/lib/**` | biblioteca de UI mobile (`BaseDataBindActivity`, `MyVideoView`, `TabBarView`, cópia do flexbox) |
| `ziyi/kit/keyboard/**` | teclado virtual próprio para TV (usado nas telas de login) |
| `com/live/evo`, `com/live/load`, `com/live/evo_mobile` | o app em si |
| `of/` | rede: `HeaderInterceptor` (of/a), parâmetros (of/b), `HttpClientFactory` (of/e) |
| `lf/`, `pf/` | criptografia da API e interceptors |
| `uf/`, `tf/` | métricas/monitores de reprodução (`uf.c` = monitor de métricas; `tf.c/tf.d` = estado de servidor/stream) |
| `nf/` | classes de evento do EventBus (`nf.a` anúncios atualizados, `nf.f` eco mode, `nf.u` erro de sessão da API, `nf.y` crash log...) |
| `d7/` | envio de log via UDP |
| `q6/` | fachada de log própria (ver acima) |
| `o6/` | cliente DNS próprio sobre Netty ("[DNS]DNS UDP ChannelHandler initChannel ok", threads `dns-task-thread`) |
| `x4/`, `u5/`, `u7/` | código do app com nome curto (diálogos, utilitários de `com.live.evo`, OSD/canais com `ChannelStreamResponse`) |

## ijkplayer (`tv/danmaku/ijk/**`, 64 arquivos, ~9.600 linhas)

Cópia sem modificações visíveis do ijkplayer (Bilibili), usada pelo `PlayerView`/`VideoView` do
baselib e pelo `MyVideoView` mobile. Não é reconstruída (API real: `tv.danmaku.ijk.media.player.*`).

| subpacote | conteúdo |
|---|---|
| `media/player` | `IMediaPlayer` (interface + listeners `OnInfo/OnError/OnPrepared/OnCompletion/OnSeekComplete...`), `AbstractMediaPlayer`, `IjkMediaPlayer` (1.149 linhas, JNI; carrega `ijkffmpeg`, `ijksdl`, `ijkplayer` via `IjkLibLoader`), `AndroidMediaPlayer` (wrapper de `android.media.MediaPlayer`), `MediaPlayerProxy`, `TextureMediaPlayer`, `IjkMediaMeta`, `IjkMediaCodecInfo`, `IjkTimedText`, `MediaInfo` (`mMediaPlayerName = "ijkplayer"`), `ISurfaceTextureHolder/Host`, `BuildConfig` |
| `media/player/misc` | `IMediaDataSource`, `IAndroidIO`, `ITrackInfo`/`IjkTrackInfo`/`AndroidTrackInfo`, `IMediaFormat`/`IjkMediaFormat`/`AndroidMediaFormat` |
| `media/player/ffmpeg` | `FFmpegApi` (JNI de utilitários do FFmpeg) |
| `media/player/pragma`, `exceptions`, `annotations` | `DebugLog`, `Pragma`, `IjkMediaException`, `@CalledByNative`, `@AccessedByNative` |
| `media/player/a.java`, `b.java` | classes sintéticas vazias do R8 |
| `media/common`, `media/exo`, `media/player_arm64`, `media/player_armv7a` | só classes `R$*` geradas (IDs de recursos) e `R$string.ijkplayer_dummy`; as bibliotecas nativas por ABI (`libijkplayer.so` etc.) ficam fora do dex |

Confiança: alta (nomes originais preservados, pacote não ofuscado).

## Biblioteca de UI compartilhada e módulos auxiliares (módulos de UI)

| origem no APK | o que é | reconstrução |
|---|---|---|
| `t/v/c/widget/banner/**` | fork do youth5201314 Banner (ViewPager2, loop, indicadores). Os tipos `bg.a/bg.b` (IndicatorConfig), `cg.a` (OnPageChangeListener), `hf.a` (BannerAdapter) e `dg.a` (BannerUtils) vêm da própria `com.youth.banner` (nomes R8) | `com.foxivid.ui.widget.banner` |
| `t/v/c/widget/ratingbar/MyRatingBar` | RatingBar customizado; usa `jf.e`/`jf.c` (drawable de estrelas, ofuscados, fora do módulo) | `com.foxivid.ui.widget.ratingbar` |
| `com/tvc/lib/mobile/ui/widget/flexbox/**` | cópia reempacotada do Google **FlexboxLayout** (`com.google.android.flexbox`), mais `FlexboxLayoutManagerWrap` (variante local) | aliases em `com.foxivid.ui.mobile.widget.flexbox` |
| `com/tvc/lib/mobile/ui/widget/sloading/**` | SLoading (spinners): `a` = builder base, `b` = drawable, `c` = enum de tipos; os 17 builders concretos estão em `x7/*` e em classes curtas (`p, i, d, j, e, g, h, q, m, k, n, o, r, f, l`) | `com.foxivid.ui.mobile.widget.sloading` |
| `w7/a` | observador de volume do sistema (VolumeChangeObserver, padrão comum em apps chineses) | referenciado em `MyVideoView` |
| `p7/*` | classes do **DataBinding** geradas (`p7.a` = tab bar, `p7.g` = `layout_my_video_view`) | stubs em `TabBarView`/`MyVideoView` |
| `ziyi/kit/keyboard/**` | teclado virtual de TV de fornecedor "ziyi" (código próprio, sem dependências de terceiros além de AndroidX); `R$*` e `DataBinderMapperImpl` são gerados | `com.foxivid.ui.keyboard` |
| `t/v/c/R$*`, `ziyi/.../R$*` | classes R geradas pelo AAPT (≈8.800 + ≈4.500 linhas de constantes) | resumidas em `R.kt` de cada módulo |
