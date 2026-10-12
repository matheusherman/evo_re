package com.live.evo_mobile.media.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.foxivid.baselib.ad.AdItem
import com.foxivid.baselib.config.InteractionUtils
import com.foxivid.baselib.media.MediaRepository
import com.foxivid.baselib.util.ToastHelper
import com.foxivid.ui.mobile.base.BaseActivity
import com.live.evo.R
import com.live.evo.util.ModelHelper
import com.live.evo_mobile.ui.MainViewActivity
import com.live.evo_mobile.ui.login.LoginTypeActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.slf4j.LoggerFactory

/**
 * Splash da versão MOBILE (aberta por [com.live.load.InitActivity] quando o tipo de app é "mobile").
 *
 * Fluxo (inferido de `loginFlow`/`launchMainActivity`; `onCreate` é `native` — Jiagu dex2c):
 * 1. (inferência de onCreate) infla o layout com `adImageView`, `countdownView` e um loading (`iLoading`, baselib `config.c`).
 * 2. [initAds]: lê a propriedade remota `startup_ad_list` ([com.foxivid.baselib.util.KvStore]/`w0.p`), converte em
 *    `List<AdItem>` (`z7.a.b(json)`); se vazia segue direto para [startLogin]; senão mostra [showAd] em sequência
 *    (cada anúncio dura `adItem.duration`; texto "countdown_text" = "%ds, Touch the screen to cancel"; tocar na imagem
 *    cancela: `isAdComplete = true`).
 * 3. [startLogin]: coleta `MediaRepository.x0()` (login automático com o dispositivo; Flow<Triple<ok, código, msg>>
 *    em Dispatchers.IO). Erro → toast com a mensagem (ou "Unknown error"). Resultado: aguarda o fim dos anúncios
 *    (poll 200 ms em `isAdComplete`); se falhou e código == -3 (rede) → toast + diálogo de retry (`network_not_connect`);
 *    se falhou por outro motivo → [goToLogin]; se ok → [launchMain].
 * 4. [launchMain]: se ainda não há canais (`MediaRepository.o(null,null,3)` vazio) mostra "Loading data…" e espera
 *    (poll 500 ms); depois `ModelHelper.Q()` + `MediaRepository.I0()` e abre [MainViewActivity] + finish.
 * 5. [goToLogin]: abre [LoginTypeActivity] com extra `loginFrom = 0` e finish.
 * Eventos EventBus: `OnEvent(s)` guarda `lastEvent`; `onEvent(nf.i)` (SDK) trata mensagens.
 *
 * Original: com/live/evo_mobile/media/activity/SplashActivity.java (nome real SplashActivity.kt)
 */
class SplashActivity : BaseActivity() {
    private val logger = LoggerFactory.getLogger(SplashActivity::class.java)
    private var countdownView: TextView? = null
    private var adIndex = 0
    private var isAdComplete = true
    private var retryDialog: Any? = null          // v7.c (diálogo de retry do ui lib)

    /** `native` no original (Jiagu): TODO inferido de campos e helpers. */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TODO("nativo/não decompilado: SplashActivity.onCreate — provável setContentView + countdownView + initAds()")
    }

    /** Original: coroutine `SplashActivity$initAd$1` (b): lê startup_ad_list e mostra ou segue. */
    private suspend fun initAds() {
        try {
            withContext(Dispatchers.Main) {
                // KvStore.get("startup_ad_list") { value ->
                //   if (value.isEmpty()) startLogin()
                //   ads = AdParser.parse(value)            // z7.a.b
                //   if (ads.isNotEmpty()) { countdownView.visibility = VISIBLE; isAdComplete = false; showAd(ads, adImageView) }
                //   startLogin() }
            }
        } catch (e: Exception) {
            logger.error("Error initializing ad: " + e.message, e)
            withContext(Dispatchers.Main) { startLogin() }
        }
    }

    /** Mostra o anúncio seguinte com Glide e contagem regressiva. Original: F(List<AdItem>, ImageView) */
    fun showAd(ads: List<AdItem>, imageView: ImageView) {
        if (isAdComplete) return
        if (adIndex >= ads.size) { isAdComplete = true; return }
        try {
            val item = ads[adIndex++]
            com.bumptech.glide.Glide.with(this).load(item.source).into(imageView)
            // countdown(item.duration, onTick = { s -> if (s > 0) countdownView.text = getString(R.string.countdown_text, s) },
            //           onFinish = { showAd(ads, imageView) })
        } catch (e: Exception) { logger.error("Error loading ad image: " + e.message, e) }
    }

    /** Dispara o login automático. Original: O() → coroutine `loginFlow` (e) */
    fun startLogin() {
        showLoading(null)
        kotlinx.coroutines.GlobalScope.launch(Dispatchers.IO) {
            MediaRepository.autoLogin()                                  // x0()
                .flowOn(Dispatchers.IO)
                .catch { th ->
                    hideLoadingSuspend()                                 // K()
                    logger.error("loginFlow error", th)
                    toast(th.message ?: getString(R.string.unknown_error_code))
                }
                .collect { r ->
                    hideLoadingSuspend()
                    if (!r.success) {
                        if (r.code == -3) {
                            showRetry(getString(R.string.network_not_connect))   // Q()
                            goToLogin()                                          // V()
                            logger.error("loginFlow error:{}", r)
                            return@collect
                        }
                    }
                    while (!isAdComplete) delay(200L)
                    launchMain()
                }
        }
    }

    /** Espera canais e abre a Main. Original: N(Continuation) `launchMainActivity` */
    private suspend fun launchMain() {
        if (MediaRepository.channels().isEmpty()) {
            showLoading(R.string.loading_data)
            while (MediaRepository.channels().isEmpty()) delay(500L)
            hideLoadingSuspend()
        }
        ModelHelper.afterLogin()           // s0.Q()
        MediaRepository.startServices()    // I0()
        withContext(Dispatchers.Main) { startActivity(Intent(this@SplashActivity, MainViewActivity::class.java)); finish() }
    }

    /** Vai para a tela de login/cadastro. Original: V() → coroutine h → a */
    fun goToLogin() {
        startActivity(Intent(this, LoginTypeActivity::class.java).putExtra("loginFrom", 0))
        finish()
    }

    private fun toast(msg: String) = ToastHelper.show(msg)                       // P(String)
    private fun showRetry(msg: String) { /* Q(): v7.c(msg, ::startLogin) com botões (2131951817 / 2131952019) */ }
    private fun showLoading(txtResId: Int?) { /* S(Integer): runOnUiThread { iLoading.setText(res) }; iLoading.show() */ }
    private suspend fun hideLoadingSuspend() { /* K(): iLoading.a() na main */ }
    /** Placeholder sem lógica. Original: M(Context) */
    suspend fun m(context: Context) {}
}
