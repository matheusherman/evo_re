package com.live.evo.fragment

import android.content.DialogInterface
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.foxivid.baselib.network.HttpClientFactory
import com.live.evo.util.AnimUtils
import com.live.evo.util.CommonUtils
import com.live.evo.util.TextStyleUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import org.slf4j.LoggerFactory
import java.lang.ref.SoftReference
import java.util.Timer

/**
 * Diálogo "Teste de rede" (layout `network_status_dialog`): três etapas — caixa→roteador (`imgBoxToHub*`, usa
 * conectividade local), roteador→internet (HTTP HEAD/GET com User-Agent "stagefright" via OkHttp do SDK) e
 * internet→servidor — cada uma com ícones `pass`/`fail`/`detected` e animação [com.live.evo.widget.VodLoadAnimation].
 * Sucesso total: mensagem (`test_ok`), `retryIntervalSeconds = 6` e callback(true);
 * falha: `network_not_connect` e novo teste por timer. Botões Check/Cancel.
 * Só abre se não houver outro aberto (flag estática [isShowing]) e se `d0.j()` do SDK (modo "ocupado") for falso.
 *
 * Original: com/live/evo/fragment/t1.java (nome real NetworkStatusDialogFragment, tag "NetworkStatusDialogFragment")
 */
class NetworkStatusDialogFragment : BaseDialogFragment(), View.OnFocusChangeListener {
    private val logger = LoggerFactory.getLogger(NetworkStatusDialogFragment::class.java)
    private var tester: NetworkTester? = null
    private var callback: ((Boolean) -> Unit)? = null
    private var isConnected = false
    private var timer: Timer? = null
    private var activityRef: SoftReference<AppCompatActivity>? = null
    private var retryIntervalSeconds = 0

    /** Original: t1.b — testes de cada etapa e se a live está tocando. */
    interface NetworkTester {
        fun boxToRouter(): Flow<Boolean>        // a()
        fun routerToInternet(): Flow<Boolean>   // b()
        fun internetToServer(): Flow<Boolean>   // c()
        fun isPlaying(): Boolean
    }

    // --- views (ids `networkstatusdlg_*`) ---
    private var tvNetwork: TextView? = null
    private var imgBoxToHubL1: ImageView? = null; private var imgBoxToHubL2: ImageView? = null
    private var imgHubToInternetL1: ImageView? = null; private var imgHubToInternetL2: ImageView? = null
    private var imgInternetToServerL1: ImageView? = null; private var imgInternetToServerL2: ImageView? = null
    private var imgBoxToHubStatus: ImageView? = null; private var aniBoxToHubLoading: com.live.evo.widget.VodLoadAnimation? = null
    private var imgHubToInternetStatus: ImageView? = null; private var aniHubToInternetLoading: com.live.evo.widget.VodLoadAnimation? = null
    private var imgInternetToServerStatus: ImageView? = null; private var aniInternetToServerLoading: com.live.evo.widget.VodLoadAnimation? = null
    private var txtTestResult: TextView? = null
    private var btnCheck: com.live.evo.widget.BaseButton? = null
    private var btnCancel: com.live.evo.widget.BaseButton? = null

    override fun onCreate(savedInstanceState: android.os.Bundle?) { super.onCreate(savedInstanceState); setStyle(1, 0) }

    override fun onCreateView(inflater: android.view.LayoutInflater, container: android.view.ViewGroup?, savedInstanceState: android.os.Bundle?): View {
        val root = inflater.inflate(com.live.evo.R.layout.network_status_dialog, container, false)
        val id = com.live.evo.R.id
        tvNetwork = root.findViewById(id.networkstatusdlg_tv_diagnostics)
        imgBoxToHubL1 = root.findViewById(id.networkstatusdlg_iv_box_to_hub_l1); imgBoxToHubL2 = root.findViewById(id.networkstatusdlg_iv_box_to_hub_l2)
        imgHubToInternetL1 = root.findViewById(id.networkstatusdlg_iv_hub_to_internet_l1); imgHubToInternetL2 = root.findViewById(id.networkstatusdlg_iv_hub_to_internet_l2)
        imgInternetToServerL1 = root.findViewById(id.networkstatusdlg_iv_internet_to_server_l1); imgInternetToServerL2 = root.findViewById(id.networkstatusdlg_iv_internet_to_server_l2)
        imgBoxToHubStatus = root.findViewById(id.networkstatusdlg_iv_box_to_hub_status)
        imgHubToInternetStatus = root.findViewById(id.networkstatusdlg_iv_hub_to_internet_status)
        imgInternetToServerStatus = root.findViewById(id.networkstatusdlg_iv_internet_to_server_status)
        aniBoxToHubLoading = root.findViewById(id.networkstatusdlg_vla_box_to_hub_loading)
        aniHubToInternetLoading = root.findViewById(id.networkstatusdlg_vla_hub_to_internet_loading)
        aniInternetToServerLoading = root.findViewById(id.networkstatusdlg_vla_internet_to_server_loading)
        txtTestResult = root.findViewById(id.networkstatusdlg_tv_test_result)
        btnCheck = root.findViewById(id.networkstatusdlg_btn_check)
        btnCancel = root.findViewById(id.networkstatusdlg_btn_cancel)
        btnCancel?.onFocusChangeListener = this
        btnCheck?.onFocusChangeListener = this
        btnCheck?.setOnClickListener { stopRetryTimer(); runTests() }       // t1.K0: M0() + G0()
        btnCancel?.setOnClickListener { cancel() }                           // t1.L0: F0()
        btnCheck?.inputType = 0
        btnCancel?.inputType = 0
        TextStyleUtils.c(tvNetwork); TextStyleUtils.b(txtTestResult); TextStyleUtils.d(btnCheck); TextStyleUtils.d(btnCancel)
        return root
    }

    /** Executa [action] na UI thread da Activity (ignora erros). Original: Q0(Runnable) */
    private fun onUi(action: Runnable) { try { activity?.runOnUiThread(action) } catch (_: Throwable) {} }

    /** Volta todos os ícones ao estado "não testado" e esconde as animações. Original: O0() */
    private fun resetIcons() {
        val R = com.live.evo.R.drawable
        listOf(imgBoxToHubL1, imgBoxToHubL2, imgHubToInternetL1, imgHubToInternetL2, imgInternetToServerL1, imgInternetToServerL2).forEach { it?.setImageResource(R.undetect) }
        for ((status, ani) in listOf(imgBoxToHubStatus to aniBoxToHubLoading, imgHubToInternetStatus to aniHubToInternetLoading, imgInternetToServerStatus to aniInternetToServerLoading)) {
            status?.visibility = View.VISIBLE
            ani?.visibility = View.GONE
            status?.setImageResource(R.unknown)
        }
        txtTestResult?.text = ""
    }

    /** Mostra o início do teste: ícones "não testado", 1º trecho detectado, animação 1 ligada e botão Check desabilitado. Original: G0() (parte UI) / H0 */
    private fun showInitialState() {
        try {
            resetIcons()
            imgBoxToHubL1?.setImageResource(com.live.evo.R.drawable.detected)
            imgBoxToHubStatus?.visibility = View.GONE
            aniBoxToHubLoading?.visibility = View.VISIBLE
            txtTestResult?.text = "......"
            btnCheck?.isEnabled = false
        } catch (e: Exception) { logger.error("show init status error", e) }
    }

    /**
     * Executa as 3 etapas em sequência (corrotina `NetworkStatusDialogFragment$c`): caixa→roteador, roteador→internet,
     * internet→servidor. Cada resultado atualiza ícones; uma falha habilita o botão Check e liga o timer de repetição ([startRetryTimer]);
     * o sucesso final mostra `test_ok`, zera o intervalo para 6 s e guarda [isConnected]. Erros de fluxo vão a [onResult].
     * Original: G0()
     */
    fun runTests() {
        onUi { showInitialState() }
        CoroutineScope(Dispatchers.IO).launch {
            val t = tester ?: return@launch
            t.boxToRouter().catch { onResult(it) }.collect { ok1 ->
                onUi { showBoxToHub(ok1) }
                if (!ok1) return@collect
                t.routerToInternet().catch { onResult(it) }.collect { ok2 ->
                    onUi { showHubToInternet(ok2) }
                    if (!ok2) return@collect
                    t.internetToServer().catch { onResult(it) }.collect { ok3 -> onUi { showFinal(ok3) } }
                }
            }
        }
    }

    private fun showBoxToHub(ok: Boolean) {      // t1$c$b.d
        try {
            aniBoxToHubLoading?.visibility = View.GONE
            imgBoxToHubStatus?.visibility = View.VISIBLE
            imgBoxToHubStatus?.setImageResource(if (ok) com.live.evo.R.drawable.pass else com.live.evo.R.drawable.fail)
            if (ok) {
                imgBoxToHubL2?.setImageResource(com.live.evo.R.drawable.detected)
                imgHubToInternetL1?.setImageResource(com.live.evo.R.drawable.detected)
            } else { btnCheck?.isEnabled = true; startRetryTimer() }
            imgHubToInternetStatus?.visibility = View.GONE
            aniHubToInternetLoading?.visibility = View.VISIBLE
        } catch (e: Exception) { logger.error("show boxToHubStatus error", e) }
    }

    private fun showHubToInternet(ok: Boolean) {   // t1$c$b$b.d
        try {
            aniHubToInternetLoading?.visibility = View.GONE
            imgHubToInternetStatus?.visibility = View.VISIBLE
            imgHubToInternetStatus?.setImageResource(if (ok) com.live.evo.R.drawable.pass else com.live.evo.R.drawable.fail)
            if (ok) {
                imgHubToInternetL2?.setImageResource(com.live.evo.R.drawable.detected)
                imgInternetToServerL1?.setImageResource(com.live.evo.R.drawable.detected)
            } else { btnCheck?.isEnabled = true; startRetryTimer() }
            imgInternetToServerStatus?.visibility = View.GONE
            aniInternetToServerLoading?.visibility = View.VISIBLE
        } catch (e: Exception) { logger.error("show hubToInternetStatus error", e) }
    }

    private fun showFinal(ok: Boolean) {            // t1$c$b$b$b.d
        try {
            aniInternetToServerLoading?.visibility = View.GONE
            imgInternetToServerStatus?.visibility = View.VISIBLE
            imgInternetToServerStatus?.setImageResource(if (ok) com.live.evo.R.drawable.pass else com.live.evo.R.drawable.fail)
            if (ok) {
                txtTestResult?.setText(com.live.evo.R.string.test_ok)
                retryIntervalSeconds = 6
            } else {
                txtTestResult?.text = String.format("%s", CommonUtils.string(com.live.evo.R.string.network_not_connect))
                startRetryTimer()
            }
            btnCheck?.isEnabled = true
            isConnected = ok
        } catch (e: Exception) { logger.error("show check result error", e) }
    }

    /** Erro no fluxo de testes: marca o último trecho como falha, mostra "<msg>:network_not_connect" e liga a repetição. Original: S0(Throwable) + T0 */
    fun onResult(error: Throwable) {
        onUi {
            try {
                imgInternetToServerStatus?.visibility = View.VISIBLE
                aniInternetToServerLoading?.visibility = View.GONE
                imgInternetToServerStatus?.setImageResource(com.live.evo.R.drawable.fail)
                txtTestResult?.text = String.format("%s:%s", error.message, CommonUtils.string(com.live.evo.R.string.network_not_connect))
                btnCheck?.isEnabled = true
                isConnected = false
                startRetryTimer()
            } catch (e: Exception) { logger.error("show check result error", e) }
        }
        logger.error("failed in network test", error)
    }

    /** Fecha o diálogo (some da tela, limpa a flag e, se a live parou, avisa a LiveNewActivity), e entrega o resultado. Original: I0() + J0 + E0(boolean) */
    private fun closeDialog() {
        onUi {
            try {
                dismiss()
                showing = false
                val activity = activityRef?.get()
                if (activity != null) {
                    try {
                        if (!activity.isFinishing && !activity.isDestroyed && activity is com.live.evo.activity.LiveNewActivity) activity.onNetworkDialogClosed()   // Q3()
                    } catch (t: Throwable) { logger.error(t.message, t); return@onUi }
                }
                deliverResult(isConnected)
            } catch (e: Exception) { logger.error("close speed test dlg failure", e) }
        }
    }

    /** Entrega o resultado ao callback, a menos que o app esteja em modo eco (então só fecha). Original: E0(boolean) */
    @Synchronized
    private fun deliverResult(ok: Boolean) {
        if (com.foxivid.baselib.util.EcoModeHelper.isInEcoMode()) { closeDialog(); return }
        callback?.invoke(ok)
    }

    /** Botão Cancel: para o timer e fecha. Original: F0() */
    fun cancel() { stopRetryTimer(); closeDialog() }

    /** Para o timer e remove o contador "(n)" do texto do botão Check. Original: M0() + N0 */
    private fun stopRetryTimer() {
        timer?.let { it.cancel(); it.purge() }
        onUi {
            val text = btnCheck?.text.toString()
            val i = text.indexOf("(")
            if (i > 0) btnCheck?.text = text.substring(0, i)
        }
    }

    /**
     * Repetição automática: a cada 1 s atualiza "Check(<restante>)"; se a live voltou a tocar fecha o diálogo; ao zerar aumenta o intervalo
     * em 6 s (máx. 60) e roda os testes de novo. Original: P0() + classes `t1$d`/`t1$e`
     */
    fun startRetryTimer() {
        timer?.let { it.cancel(); it.purge() }
        val task = object : java.util.TimerTask() {   // t1$e
            private var seconds = 0
            override fun run() {
                if (tester?.isPlaying() == true) { onUi { try { dismissAllowingStateLoss() } catch (_: Throwable) {} }; return }
                if (seconds != retryIntervalSeconds) {
                    onUi {
                        var text = btnCheck?.text.toString()
                        val i = text.indexOf("(")
                        if (i > 0) text = text.substring(0, i)
                        btnCheck?.text = text + "(" + (retryIntervalSeconds - seconds) + ")"
                    }
                    seconds++
                } else {
                    if (retryIntervalSeconds < 60) retryIntervalSeconds += 6
                    runTests()
                    stopRetryTimer()
                }
            }
        }
        timer = java.util.Timer("check_network", false).also { it.schedule(task, 1000L, 1000L) }
    }

    override fun onFocusChange(v: View?, hasFocus: Boolean) { if (hasFocus) AnimUtils.d(v) else AnimUtils.g(v) }
    override fun onDismiss(dialog: DialogInterface) { showing = false; super.onDismiss(dialog) }

    companion object {
        private var showing = false
        private var instance: SoftReference<NetworkStatusDialogFragment>? = null
        fun isShowing() = showing

        /** Testador padrão: etapa 1 = [com.live.evo.util.NetworkUtils.isConnected]; 2 = GET HTTP; 3 = sempre true. Original: a(Activity) */
        fun createTester(activity: android.app.Activity): NetworkTester = object : NetworkTester {
            override fun boxToRouter(): Flow<Boolean> = flowOf(com.live.evo.util.NetworkUtils.isConnected(activity))
            override fun routerToInternet(): Flow<Boolean> = flow {
                // GET https://www.bing.com com User-Agent de Android 4.2.2; "isSuccessful" do OkHttp (cliente "plain" do SDK)
                val req = okhttp3.Request.Builder().addHeader("User-Agent", "stagefright/1.2 (Linux;Android 4.2.2)").url("https://www.bing.com").build()
                emit(HttpClientFactory.plainClient().newCall(req).execute().isSuccessful)
            }
            override fun internetToServer(): Flow<Boolean> = flowOf(true)
            override fun isPlaying(): Boolean = (activity as? com.live.evo.activity.LiveNewActivity)?.isLivePlaying() ?: false // LiveNewActivity.d3()
        }

        /** Original: f(AppCompatActivity, b, callback) */
        fun show(activity: AppCompatActivity, tester: NetworkTester?, callback: (Boolean) -> Unit) {
            if (com.foxivid.baselib.config.InteractionUtils.isBusy() || tester == null || showing) return
            try {
                val fm: FragmentManager = activity.supportFragmentManager
                fm.findFragmentByTag("NetworkStatusDialogFragment")?.let { fm.beginTransaction().remove(it).addToBackStack(null).commitAllowingStateLoss() }
                val f = NetworkStatusDialogFragment().also { it.tester = tester; it.activityRef = SoftReference(activity); it.callback = callback }
                instance = SoftReference(f)
                f.show(fm.beginTransaction(), "NetworkStatusDialogFragment")
                showing = true
                f.runTests()
            } catch (e: Exception) { /* log */ }
        }
    }
}
