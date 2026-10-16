package com.live.evo.osd.presenter

import android.view.View
import androidx.fragment.app.FragmentManager
import com.live.evo.event.SavePlayHistoryEvent
import com.live.evo.util.RxBus
import com.live.evo.model.ChannelData
import com.live.evo.model.ProgramBean
import com.live.evo.util.EpgRepository
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.slf4j.LoggerFactory

/**
 * Presenter do menu OSD lateral/inferior. Quase todos os métodos apenas encaminham para a
 * [OSDListProgramView] (`mView`) ou para o callback `mCallback` (a Activity de live).
 * Os eventos reais: [getEpgList] (EPG por canal via Flow) e a assinatura do Rx bus para
 * [SavePlayHistoryEvent] (b5.h), que atualiza categoria/canal/posição atuais.
 *
 * Original: com/live/evo/osd/persenter/c.java (nome real: OSDListProgramPresenter, do metadata Kotlin)
 */
class OSDListProgramPresenter(
    private var mView: OSDListProgramView?,
    private val mCallback: OSDListProgramPresenterContract?,
) : OSDListProgramPresenterContract {
    private val logger = LoggerFactory.getLogger(OSDListProgramPresenter::class.java)
    private var playCategory = 0
    private var playChannel = 0
    private var playAllPos = 0
    private var mSaveHistorySubscription: Disposable? = null
    private var mEpgAllSubscription: Disposable? = null
    private var getEpgSubscribe: Disposable? = null

    init {
        // Original: mView.K(this); G() — registra o presenter na view; G() é vazio (a assinatura ocorre em start() = v()).
    }

    /** Original: C() */ fun programSelect(): Int = mView?.programSelect ?: 0
    /** Original: D() */ fun isShowing(): Boolean = mView?.isShowing ?: false

    /** Assina [SavePlayHistoryEvent] no RxBus (`j1.a()`, original). Original: v()/G() */
    private fun subscribeHistory() {
        // Original: j1.a().c(b5.h.class).s(new C0110c(), d) — o consumidor de erro (d) é vazio.
        mSaveHistorySubscription = RxBus.get().observe(SavePlayHistoryEvent::class.java).subscribe({ onHistoryEvent(it) }, { })
    }

    private fun onHistoryEvent(e: SavePlayHistoryEvent) {
        playCategory = e.category
        playChannel = e.channel
        playAllPos = e.allPosition
        mView?.onHistorySaved(e)
    }

    /**
     * Carrega a EPG do canal: `EpgRepository.A(channelId, epgId)` (Flow<List<p>>); em erro posta
     * `view.q(throwable, channelId)` na main; em sucesso `view.L(list, channelId)` na main.
     * Original: q(String epgId, int pastDays, String currentChannelId)
     */
    fun getEpgList(epgId: String, pastDays: Int, currentChannelId: String, scope: CoroutineScope) {
        scope.launch(Dispatchers.IO) {
            EpgRepository.epgFlow(currentChannelId, epgId)
                .catch { e -> withContext(Dispatchers.Main) { mView?.onEpgError(e, currentChannelId) } }
                .collect { list -> withContext(Dispatchers.Main) { mView?.showEpgList(list, currentChannelId) } }
        }
    }

    fun show(fragmentManager: FragmentManager, menuTag: String) {
        if (!isShowing()) mView?.show(fragmentManager, menuTag)
    }

    /** Libera view e cancela as 3 assinaturas Rx. Original: u() */
    fun detach() {
        mView?.onDestroyView()
        mView = null
        listOf(mSaveHistorySubscription, mEpgAllSubscription, getEpgSubscribe).forEach {
            if (it != null && !it.isDisposed) it.dispose()
        }
    }

    // --- encaminhamentos para a view (mView) ---
    override fun hide() { mView?.hideView() }
    fun resetFocus() { mView?.resetFocus() }
    fun onS() { mView?.onS() }
    fun onT() { mView?.onT() }
    fun setProgramPosition(p: Int) { mView?.setProgramPosition(p) }
    fun setInListSelectPos(p: Int) { mView?.setInListSelectPos(p) }
    fun onId(id: String) { mView?.onId(id) }
    fun setInAllProgramPos(p: Int) { mView?.setInAllProgramPos(p) }

    // --- encaminhamentos para o callback (mCallback) ---
    override fun onTypeIndex(type: Int, index: Int) { mCallback?.onTypeIndex(type, index) }
    override fun onCatchUp(catchupType: String, bean: ProgramBean, channelId: String) { mCallback?.onCatchUp(catchupType, bean, channelId) }
    override fun onTagIndex(tag: String, index: Int) { mCallback?.onTagIndex(tag, index) }
    override fun onClose() { mCallback?.onClose() }
    override fun onTag(tag: String) { mCallback?.onTag(tag) }
    override fun onEvent() { mCallback?.onEvent() }
    override fun currentValue(): Int = mCallback?.currentValue() ?: 0
    override fun onContainer(tag: String, container: View) { mCallback?.onContainer(tag, container) }
    override fun channelData(): ChannelData? = mCallback?.channelData()
    override fun onItemSelected(position: Int) { mCallback?.onItemSelected(position) }
    override fun onMenu() { mCallback?.onMenu() }
    override fun onSelection(categorySelect: Int, programSelect: Int, inAllProgramPos: Int, playType: String) {
        mCallback?.onSelection(categorySelect, programSelect, inAllProgramPos, playType)
    }
    override fun start() { /* original v(): assina histórico */ subscribeHistory() }
    override fun onOther() { mCallback?.onOther() }
}
