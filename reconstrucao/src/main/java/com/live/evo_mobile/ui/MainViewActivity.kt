package com.live.evo_mobile.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.Fragment
import com.foxivid.ui.mobile.base.BaseDataBindActivity
import com.live.evo_mobile.ui.login.LoginTypeActivity
import java.util.Timer
import java.util.TimerTask

/**
 * Tela principal da versão MOBILE: container `frame_content` + barra de abas (`TabBarBean.ItemBean`):
 * TV ao vivo ([MainTVFragment]), canais/EPG ([EpgListFragment], guia "tv_guide"), lembretes ([SubscribeListFragment])
 * e perfil ([ProfileFragment]). Troca fragments com hide/show/add por tag ([switchFragment]).
 *
 * Comportamento:
 * - `onCreate` é `native` (Jiagu) — inferência: infla o DataBinding `z4.u`, cria os fragments, registra EventBus,
 *   pede permissão de instalação (`upgrade_permission_dlg_title/desc/btn`), inicia [startSubscriptionTimer].
 * - [startSubscriptionTimer] (original `e0()`): `Timer` que a cada 3 s (primeira em 50 ms) verifica lembretes
 *   (`S()` — mostra popup de lembrete se algum programa agendado está para começar).
 * - Evento `nf.z` (UpgradeEvent do SDK): mostra diálogo de atualização (`v7.c`) com título `<upgrade>:<versionName>`;
 *   `forceUpgrade == 1` impede cancelar; confirma → baixa/instala (`g0()`: se há APK baixado → [installApk] (Z), senão pede permissão).
 * - [openRenew] (original `c0()`): abre [RenewActivity] via `jumpForResult` (ActivityResult, `a0`).
 * - [playChannel] (original `T(channelId)`): seleciona a aba TV e chama `MainTVFragment.Q0(channelId)`.
 * - `OnEvent(nf.g)`: evento de navegação do SDK. Back: duplo toque para sair.
 *
 * Original: com/live/evo_mobile/ui/MainViewActivity.java (nome real MainViewActivity.kt)
 */
class MainViewActivity : BaseDataBindActivity() {
    private var currentFragment: Fragment? = null
    private var tvFragment: Any? = null
    private var timer: Timer? = null
    private lateinit var jumpForResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // INFERIDO (onCreate nativo): launcher de resultado (usado por openRenew) e timer de lembretes; a criação do DataBinding
        // `z4.u`, dos fragments e do EventBus não é reconstruída (fragments mobile resumidos; ver KDoc da classe).
        jumpForResult = registerForActivityResult(androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult()) { }
        startSubscriptionTimer()
    }

    /** Original: f0(Fragment from, Fragment to, String tag) */
    private fun switchFragment(from: Fragment?, to: Fragment?, tag: String) {
        val tx = supportFragmentManager.beginTransaction()
        if (to != null && to.isAdded) { from?.let { tx.hide(it) }; tx.show(to).commit() }
        else { from?.let { tx.hide(it) }; to?.let { tx.add(com.live.evo.R.id.frame_content, it, tag).commit() } }
    }

    /** Cancela o timer de atualização da lista de lembretes. Original: S() */
    fun stopSubscriptionTimer() {
        if (timer == null) return
        timer?.purge()
        timer?.cancel()
        timer = null
    }

    /**
     * Reinicia o timer: a cada 3 s (primeira em 50 ms) atualiza a lista de lembretes (tarefa `e`).
     * Original: e0() — S(); `InteractionUtils.I()`; Timer.schedule(e(), 50, 3000)
     */
    fun startSubscriptionTimer() {
        stopSubscriptionTimer()
        com.foxivid.baselib.config.InteractionUtils.I()  // t.v.c.i.a.I()
        timer = Timer().also { it.schedule(object : TimerTask() { override fun run() { /* e.run(): atualização da lista (não reconstruída) */ } }, 50L, 3000L) }
    }

    /** Original: c0() */
    fun openRenew() { jumpForResult.launch(Intent(this, RenewActivity::class.java)) }

    /**
     * Mostra a aba TV e seleciona o canal. Original: T(String): `t().f22987c.e(0)` (barra de abas: item 0) e, se o fragment atual não
     * é o de TV, `e(1)`; depois `MainTVFragment.Q0(channelId)`.
     * NÃO RECUPERÁVEL parcialmente: a barra de abas (`z4.u`) e os fragments mobile não estão reconstruídos; delega ao [MainTVFragment].
     */
    fun playChannel(channelId: String) { tvFragment?.let { (it as? MainTVFragment)?.playChannel(channelId) } }

    /**
     * Instala o APK baixado. Original: Z() — se há evento de upgrade pendente reaplica-o (OnEvent(nf.z)); senão, com o APK
     * conhecido, pede ao SDK a instalação (`InteractionUtils.E0(this, título, descrição, botão, logo, apkFile)`; logo = `V()` ou, se 0,
     * o drawable 2131231256).
     * NÃO RECUPERÁVEL: o tratamento OnEvent(nf.z) (diálogo `v7.c`, ver KDoc da classe) não está reconstruído; só o ramo do APK.
     */
    fun installApk() {
        val file = apkFileForInstall() ?: return
        com.foxivid.baselib.config.InteractionUtils.installApk(
            this, com.live.evo.R.string.upgrade_permission_dlg_title, com.live.evo.R.string.upgrade_permission_dlg_desc,
            com.live.evo.R.string.upgrade_permission_dlg_btn, 2131231256, file)
    }

    private fun apkFileForInstall(): String? = apkFile
}
