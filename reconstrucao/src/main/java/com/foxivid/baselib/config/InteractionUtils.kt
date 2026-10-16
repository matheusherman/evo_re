package com.foxivid.baselib.config

import android.content.Context
import androidx.lifecycle.Lifecycle
import com.foxivid.baselib.heartbeat.HeartbeatManager
import com.foxivid.baselib.heartbeat.UpgradeFailureEvent
import com.foxivid.baselib.media.ChannelManager
import com.foxivid.baselib.media.EpgManager
import com.foxivid.baselib.model.extra.upgrade.UpgradeInfo
import com.foxivid.baselib.model.meta.ChannelStreamResponse
import com.foxivid.baselib.model.meta.EPGProgramme
import kotlinx.coroutines.flow.Flow

/**
 * Fachada pública da UI para a baselib (canais, EPG, login, upgrade...). Aqui só é reconstruído
 * o ponto de entrada de inicialização do SDK; o restante pertence ao módulo `com.foxivid.ui`.
 *
 * Original: t/v/c/i/a.java (InteractionUtils) — b0() e os delegadores usados pelo módulo `ui`
 * (os demais ~100 métodos são encaminhamentos de uma linha para [ChannelManager], [EpgManager], [HeartbeatManager], etc.).
 */
object InteractionUtils {

    /**
     * Inicializa a baselib repassando tudo para [BaseLibConfig.init].
     *
     * Original: t/v/c/i/a.b0(...).
     *
     * Chamada real (com.live.load.InitActivity.w):
     * ```
     * b0(appContext, "prod_", "com.live.evo", BuildConfig.IS_DEBUG,
     *    authEndPoint        = "https://user.aleatorio.website:2053",   // ACCOUNT_SERVERS
     *    adEndPoint          = "http://user.aleatorio.website:2052",    // AD_SERVERS
     *    channelEndPoint     = "http://user.aleatorio.website:2052",    // CHANNEL_SERVERS
     *    feedbackEndPoint    = "http://user.aleatorio.website:2052",    // FEEDBACK_SERVERS
     *    upgradeEndPoint     = "https://user.aleatorio.website:2053",   // UPGRADE_SERVERS
     *    messageEndPoint     = "http://user.aleatorio.website:20528",   // MESSAGE_CENTER_SERVERS
     *    metricEndPoint      = "https://emetrics.aleatorio.website:2083", // APP_METRIC_SERVERS
     *    streamMediaEndPoint = "https://meta.aleatorio.website:2096",   // STREAM_META_SERVERS
     *    loggerEndPoint      = "ulog.aleatorio.website:51000",          // RemoteLogger (UDP)
     *    imgEndPoint         = "https://image.aleatorio.website",       // IMG_SERVERS
     *    clientSecret        = CLIENT_SECRET,
     *    serverPublicKeyPem  = SERVER_PUBLIC_KEY_PEM,
     *    sportsEndPoint      = "https://sports.aleatorio.website:2053", // SPORTS_SERVERS
     *    historyName = getString(channel_column_history), favoritesName = getString(channel_column_favorites),
     *    allName = getString(channel_column_all))
     * ```
     */
    suspend fun initSdk(
        appContext: Context, env: String, applicationId: String, isDebug: Boolean,
        authEndPoint: String, adEndPoint: String, channelEndPoint: String, feedbackEndPoint: String,
        upgradeEndPoint: String, messageEndPoint: String, metricEndPoint: String,
        streamMediaEndPoint: String, loggerEndPoint: String, imgEndPoint: String,
        clientSecret: String, serverPublicKeyPem: String, sportsEndPoint: String,
        historyName: String, favoritesName: String, allName: String,
    ) = BaseLibConfig.init(
        appContext, env, applicationId, isDebug, authEndPoint, adEndPoint, channelEndPoint,
        feedbackEndPoint, upgradeEndPoint, messageEndPoint, metricEndPoint, streamMediaEndPoint,
        loggerEndPoint, imgEndPoint, clientSecret, serverPublicKeyPem, sportsEndPoint,
        historyName, favoritesName, allName,
    )

    // ---- Delegadores usados pelo módulo ui (cada um é um encaminhamento de uma linha no original) ----

    /** Pede/executa a instalação do APK. Original: a.E0(context, título, descrição, botão, logo, apkFile) -> HeartbeatManager.D0 */
    fun installApk(context: Context, titleRes: Int, descRes: Int, btnRes: Int, logoRes: Int, apkFile: String?) {
        HeartbeatManager.requestInstall(context, titleRes, descRes, btnRes, logoRes, apkFile ?: return)
    }

    /** Instante de expiração do plano (ms). Original: a.I() -> user.f.m0 */
    fun I(): Long = com.foxivid.baselib.user.UserManager.getExpireTs()

    /** Número de exibição do canal (ou "NA"). Original: a.b(response) -> media.a.p */
    fun b(response: ChannelStreamResponse): String = ChannelManager.channelNumber(response)

    /** Lista de datas de EPG disponíveis (padrão "" = todas). Original: a.B(String)/C(...) -> media.c.w */
    suspend fun C(channelId: String = ""): List<String> = EpgManager.getDateList(channelId)

    /** Programa em exibição em [timeMs]. Original: a.G(epgId, ts) -> media.c.C(epgId, ts, false) */
    suspend fun G(epgId: String, timeMs: Long): EPGProgramme? = EpgManager.getProgrammeAt(epgId, timeMs, false)

    /** Canais da coluna (padrão: coluna "todos"). Original: a.n(column, isIncludeAdult) -> media.a.w */
    fun n(column: String?, isIncludeAdult: Boolean?): List<ChannelStreamResponse> =
        ChannelManager.channelsOf(column ?: ChannelManager.columnAll(), isIncludeAdult)

    /** A coluna só existe no modo adulto? Original: a.d0(column) -> media.a.G */
    fun d0(column: String): Boolean = ChannelManager.isAdultColumn(column)

    /** Modo adulto ativo? Original: a.e0() -> media.a.H */
    fun e0(): Boolean = ChannelManager.isAdultMode()

    /** Liga o modo adulto. Original: a.H0() -> media.a.d0 */
    fun H0() = ChannelManager.enableAdultMode()

    /** Desliga o modo adulto. Original: a.I0() -> media.a.e0 */
    fun I0() = ChannelManager.disableAdultMode()

    /** Fluxo de checagem de upgrade. Original: a.c(lifecycle, onProgress) -> HeartbeatManager.Y */
    fun checkUpgradeFlow(
        lifecycle: Lifecycle?,
        onProgress: ((String, Int, String?, UpgradeFailureEvent?) -> Unit)?,
    ): Flow<UpgradeInfo?> = HeartbeatManager.checkUpgrade(lifecycle, onProgress)

    /** clientSecret usado na assinatura X-Sign das requisições (valor real de InitActivity). */
    const val CLIENT_SECRET = "myQeN2Ql7NNL7I14DG2rGZ7dvR6TGNK2"

    /** Chave pública RSA-2048 do servidor (cifra a chave AES por requisição, cabeçalho X-Key). */
    const val SERVER_PUBLIC_KEY_PEM = """-----BEGIN PUBLIC KEY-----
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlpjMh6Qf9uYlo0Yq7xai
ANvpM5gmE3WRN9y0pubPzKeMt6yJBcd3KyaWy8fDppeEAX8vEAFEalCDAIN/2Gsu
8GsrJRu6cipnLM3MfcY/pQDt63rlpQUCF3LZu8tmit8kns2Jvt+SV+I78vPToG2/
qKliDVquv5krf54MbjJeR4/7r8odi0TOaDstAo6616DR6xHKcwW1UF5DE20hMTGi
Bp4k+vpzCO+RcHzLfWqR/8aROa3NCYQ/4Z2EbNo8yVtattzyCLVAZ4Z82kD+iC6Q
gHH8U63BgjrKQUGrs3KvVZruUFNYgTp8tx8AUy2H2Zagkn0aUIWO+/iM+0xgtyJo
RwIDAQAB
-----END PUBLIC KEY-----"""
}
