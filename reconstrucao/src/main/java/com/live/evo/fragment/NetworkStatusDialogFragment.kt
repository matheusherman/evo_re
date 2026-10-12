package com.live.evo.fragment

import android.content.DialogInterface
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import org.slf4j.LoggerFactory
import java.lang.ref.SoftReference
import java.util.Timer

/**
 * Diálogo "Teste de rede" (layout `network_status_dialog`): três etapas — caixa→roteador (`imgBoxToHub*`, usa
 * conectividade local), roteador→internet (HTTP HEAD/GET com User-Agent "stagefright" via OkHttp do SDK) e
 * internet→servidor — cada uma com ícones `pass`/`fail`/`detected` e animação [com.live.evo.widget.VodLoadAnimation].
 * Sucesso total: mensagem (string 2131953047, `test_ok`), `retryIntervalSeconds = 6` e callback(true);
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

    /** Executa as 3 etapas em sequência (corrotina `NetworkStatusDialogFragment$c`). Original: G0() */
    fun runTests() { TODO("coletar tester.a(), b(), c() e atualizar ícones/textos na UI") }
    fun onResult(error: Throwable) { TODO("S0(Throwable)") }
    override fun onFocusChange(v: View?, hasFocus: Boolean) {}
    override fun onDismiss(dialog: DialogInterface) { super.onDismiss(dialog); showing = false; timer?.cancel() }

    companion object {
        private var showing = false
        private var instance: SoftReference<NetworkStatusDialogFragment>? = null
        fun isShowing() = showing

        /** Testador padrão: etapa 1 = [com.live.evo.util.NetworkUtils.isConnected]; 2 = GET HTTP; 3 = sempre true. Original: a(Activity) */
        fun createTester(activity: android.app.Activity): NetworkTester = object : NetworkTester {
            override fun boxToRouter(): Flow<Boolean> = flowOf(com.live.evo.util.NetworkUtils.isConnected(activity))
            override fun routerToInternet(): Flow<Boolean> = flow { emit(TODO("HEAD/GET via HttpClientFactory com User-Agent \"stagefright\"")) }
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
