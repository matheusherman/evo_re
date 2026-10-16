package com.live.load

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.foxivid.baselib.config.InteractionUtils
import com.foxivid.baselib.network.AppParams
import com.foxivid.baselib.util.AppInfo
import com.foxivid.baselib.util.KvStore
import com.foxivid.ui.LoadingViewController
import com.foxivid.ui.mobile.ext.setActivityBackground
import com.live.evo.BuildConfig
import com.live.evo.MyApplication
import com.live.evo.R
import com.live.evo.activity.LiveLoadActivity
import com.live.evo.databinding.ActivityInitBinding
import com.live.evo_mobile.media.activity.SplashActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.jessyan.autosize.AutoSizeCompat
import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Activity de entrada (LAUNCHER + LEANBACK_LAUNCHER) do app.
 *
 * Original: com/live/load/InitActivity.java (nome real; Kotlin, arquivo InitActivity.kt)
 *
 * Responsabilidades:
 * 1. Inicializar o SDK do fornecedor ([InteractionUtils.init], ofuscado `b0`) com os endpoints de produção
 *    (`*.aleatorio.website`), chave de app e chave pública RSA.
 * 2. Descobrir o tipo de aplicação ("stb" ou "mobile") — cacheado no [KvStore] em [APP_TYPE_KEY] —
 *    e aplicar o fundo correspondente.
 * 3. Quando o SDK terminou de inicializar **e** a Activity já passou por `onResume` (latch de 2),
 *    abrir [LiveLoadActivity] (STB/TV) ou [SplashActivity] (mobile) e encerrar-se 500 ms depois.
 */
class InitActivity : AppCompatActivity() {

    /** Original: campo `binding` (z4.h). */
    private lateinit var binding: ActivityInitBinding

    /** Dois "sinais": fim da inicialização do SDK e onResume. Original: `latch`. */
    private val latch = CountDownLatch(2)

    /** Garante que o fundo seja aplicado só uma vez. Original: `isBgSet`. */
    private val isBgSet = AtomicBoolean(false)

    /** Tipo de app cacheado ("stb"/"mobile"); vazio se ainda desconhecido. Original: `appType`. */
    private var appType: String = ""

    /**
     * Inferência: o corpo real é `native` (360 Jiagu dex2c). Pelos campos e helpers, provavelmente:
     * infla [ActivityInitBinding] e chama setContentView; chama [loadCachedAppType] (t()) e
     * [showInitLoading] (x()) e lança a corrotina original `InitActivity$onCreate$1`, reconstruída em
     * [initializeAndRoute] (essa corrotina existe no dex, então o encadeamento abaixo é fiel a ela).
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // INFERIDO (onCreate nativo)
        binding = ActivityInitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadCachedAppType()
        showInitLoading()
        lifecycleScope.launch { initializeAndRoute() }
    }

    /**
     * Corpo da corrotina `InitActivity$onCreate$1`.
     * Original: InitActivity$a.invokeSuspend()
     */
    private suspend fun initializeAndRoute() {
        // Original: StubApp.getOrigApplicationContext(applicationContext) — artefato do packer Jiagu.
        initSdk(applicationContext)
        if (appType.isEmpty()) {
            val detected = AppInfo.appType()            // x1.f1.lb.util.k.r()
            KvStore.put(APP_TYPE_KEY, detected)         // w0.t(key, value)
            withContext(Dispatchers.Main) { applyBackground(detected) }
        }
        onReadySignal()
    }

    /**
     * Lê o tipo de app salvo e aplica o fundo se não vazio.
     * Original: InitActivity.t() / u() / v()
     */
    private fun loadCachedAppType() {
        KvStore.get(APP_TYPE_KEY, KvStore.Callback<String> { value ->
            if (value.isNotEmpty()) {
                appType = value
                runOnUiThread { applyBackground(value) }
            }
        }, "")
    }

    /**
     * Inicializa o SDK com URLs/segredos de produção.
     * Original: InitActivity.w(Context, Continuation)
     *
     * Os três últimos argumentos são as strings `channel_column_history`, `channel_column_favorites`
     * e `channel_column_all` (ids 2131951854/53/52), usadas pelo SDK como nomes de colunas virtuais.
     */
    private suspend fun initSdk(context: Context) {
        MyApplication.appContext = context
        val all = getString(R.string.channel_column_all)
        val favorites = getString(R.string.channel_column_favorites)
        val history = getString(R.string.channel_column_history)
        InteractionUtils.init(
            context,
            "prod_",
            "com.live.evo",
            BuildConfig.IS_DEBUG,
            "https://user.aleatorio.website:2053",
            "http://user.aleatorio.website:2052",
            "http://user.aleatorio.website:2052",
            "http://user.aleatorio.website:2052",
            "https://user.aleatorio.website:2053",
            "http://user.aleatorio.website:20528",
            "https://emetrics.aleatorio.website:2083",
            "https://meta.aleatorio.website:2096",
            "ulog.aleatorio.website:51000",
            "https://image.aleatorio.website",
            "myQeN2Ql7NNL7I14DG2rGZ7dvR6TGNK2",
            RSA_PUBLIC_KEY,
            "https://sports.aleatorio.website:2053",
            history,
            favorites,
            all,
        )
    }

    /**
     * Mostra o overlay "Initializing…" (R.string.init_env) no layout `loading_layout`.
     * Original: InitActivity.x() — usa z7.j (controlador de loading) com cor R.color.white.
     */
    private fun showInitLoading() {
        val loading = LoadingViewController.create(R.id.loading_layout, R.color.white, window.decorView.rootView)
        loading.setText(getString(R.string.init_env))
        loading.show()
    }

    /**
     * Aplica o fundo da tela conforme o tipo de app (uma única vez).
     * Original: InitActivity.y(String)
     */
    private fun applyBackground(appType: String) {
        if (appType == "stb") {
            if (isBgSet.compareAndSet(false, true)) setActivityBackground(R.drawable.load_bg)
        } else if (appType == "mobile" && isBgSet.compareAndSet(false, true)) {
            setActivityBackground(R.drawable.load_bg_mb)
        }
    }

    /**
     * Decrementa o latch; quando chega a zero decide o destino pelo `AppParams.appType` ("stb" → TV).
     * Original: InitActivity.z()
     */
    private fun onReadySignal() {
        latch.countDown()
        if (latch.count > 0) return
        val isStb = AppParams.appType() == "stb"   // of.a.c()
        runOnUiThread { routeTo(isStb) }
    }

    /**
     * Abre a tela seguinte e finaliza esta 500 ms depois.
     * Original: InitActivity.A(boolean, InitActivity) / B()
     */
    private fun routeTo(isStb: Boolean) {
        startActivity(Intent(this, if (isStb) LiveLoadActivity::class.java else SplashActivity::class.java))
        binding.root.postDelayed({ if (!isFinishing) finish() }, 500L)
    }

    /** Original: InitActivity.getResources() — ajuste de densidade AutoSize na main thread. */
    override fun getResources(): Resources {
        val resources = super.getResources()
        if (Looper.myLooper() == Looper.getMainLooper()) AutoSizeCompat.autoConvertDensityOfGlobal(resources)
        return resources
    }

    /** Segundo sinal do latch. Original: InitActivity.onResume() */
    override fun onResume() {
        super.onResume()
        onReadySignal()
    }

    companion object {
        /** Original: campo `appTypeKey`. */
        private const val APP_TYPE_KEY = "init_activity_app_type"

        /** Chave pública RSA passada ao SDK (valor literal do original, inclusive indentação). */
        private const val RSA_PUBLIC_KEY =
            "        -----BEGIN PUBLIC KEY-----\n" +
            "        MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlpjMh6Qf9uYlo0Yq7xai\n" +
            "        ANvpM5gmE3WRN9y0pubPzKeMt6yJBcd3KyaWy8fDppeEAX8vEAFEalCDAIN/2Gsu\n" +
            "        8GsrJRu6cipnLM3MfcY/pQDt63rlpQUCF3LZu8tmit8kns2Jvt+SV+I78vPToG2/\n" +
            "        qKliDVquv5krf54MbjJeR4/7r8odi0TOaDstAo6616DR6xHKcwW1UF5DE20hMTGi\n" +
            "        Bp4k+vpzCO+RcHzLfWqR/8aROa3NCYQ/4Z2EbNo8yVtattzyCLVAZ4Z82kD+iC6Q\n" +
            "        gHH8U63BgjrKQUGrs3KvVZruUFNYgTp8tx8AUy2H2Zagkn0aUIWO+/iM+0xgtyJo\n" +
            "        RwIDAQAB\n" +
            "        -----END PUBLIC KEY-----\n"
    }
}
