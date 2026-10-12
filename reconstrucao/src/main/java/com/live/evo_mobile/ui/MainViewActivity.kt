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
    private var tvFragment: Fragment? = null
    private var timer: Timer? = null
    private lateinit var jumpForResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TODO("nativo/não decompilado: MainViewActivity.onCreate — ver KDoc (inferência)")
    }

    /** Original: f0(Fragment from, Fragment to, String tag) */
    private fun switchFragment(from: Fragment?, to: Fragment?, tag: String) {
        val tx = supportFragmentManager.beginTransaction()
        if (to != null && to.isAdded) { from?.let { tx.hide(it) }; tx.show(to).commit() }
        else { from?.let { tx.hide(it) }; to?.let { tx.add(com.live.evo.R.id.frame_content, it, tag).commit() } }
    }

    /** Original: e0() — 3 s */
    fun startSubscriptionTimer() {
        checkReminders()
        com.foxivid.baselib.media.MediaRepository.refreshSubscriptions()  // t.v.c.i.a.I()
        timer = Timer().also { it.schedule(object : TimerTask() { override fun run() { checkReminders() } }, 50L, 3000L) }
    }
    fun checkReminders() { /* S() */ }
    fun openRenew() { jumpForResult.launch(Intent(this, RenewActivity::class.java)) }
    fun playChannel(channelId: String) { /* T(): tab TV + MainTVFragment.playChannel(channelId) */ }
    fun installApk() { /* Z() */ }
}
