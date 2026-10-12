package com.live.evo.osd.presenter

import android.view.View
import androidx.fragment.app.FragmentManager
import com.live.evo.model.ChannelData
import com.live.evo.model.ProgramBean

/**
 * Contrato MVP do menu OSD (lista de categorias/canais/EPG), `k5.a<b>` / `k5.b<a>` no original.
 * Original: com/live/evo/osd/persenter/a.java (Presenter) e persenter/b.java (View).
 * (O pacote original tem o typo "persenter".)
 */
interface OSDListProgramPresenterContract {
    fun onTypeIndex(type: Int, index: Int)                                  // a(int,int)
    fun onCatchUp(catchupType: String, bean: ProgramBean, channelId: String) // b(String, p, String)
    fun onTagIndex(tag: String, index: Int)                                  // c(String,int)
    fun onClose()                                                            // d()
    fun onTag(tag: String)                                                   // e(String)
    fun onEvent()                                                            // f()
    fun currentValue(): Int                                                  // g()
    fun onContainer(tag: String, container: View)                            // h(String, View)
    fun hide()
    fun channelData(): ChannelData?                                          // i()
    fun onItemSelected(position: Int)                                        // k(int)
    fun onMenu()                                                             // m()
    fun onSelection(categorySelect: Int, programSelect: Int, inAllProgramPos: Int, playType: String) // o
    fun start()                                                              // v()
    fun onOther()                                                            // w()
}

/** Original: com/live/evo/osd/persenter/b.java */
interface OSDListProgramView {
    fun onDestroyView()                                      // E()
    fun onHistorySaved(event: com.live.evo.event.SavePlayHistoryEvent) // F(b5.h)
    fun hideView()                                           // I()
    fun showEpgList(list: List<ProgramBean>, channelId: String) // L(List<p>, String)
    fun onId(id: String)                                     // M(String)
    fun show(fragmentManager: FragmentManager, menuTag: String) // N(FragmentManager,String)
    val isShowing: Boolean
    fun resetFocus()                                         // m()
    val programSelect: Int                                   // o()
    fun setInAllProgramPos(pos: Int)                         // p(int)
    fun onEpgError(error: Throwable, channelId: String)      // q(Throwable,String)
    fun setInListSelectPos(pos: Int)                         // r(int)
    fun onS()                                                // s()
    fun onT()                                                // t()
    fun setProgramPosition(position: Int)                    // u(int)
}
