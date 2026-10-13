package com.live.evo.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.View.OnAttachStateChangeListener
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.live.evo.R
import me.jessyan.autosize.internal.CustomAdapt

/** Notificação de visibilidade do fragment para o pai. Original: fragment/z1.java */
interface VisibilityListener { /* onVisibilityChanged(...) */ }
/** Original: fragment/y1.java (listener de eventos entre menu e abas: `a`/`b`/`c`… ver MenuParent) */
interface OnTabEventListener { fun b() {}; fun c() {}; fun a(pos: Int) {} }
/** Original: fragment/a2.java */
interface OnMenuCallback {
    /** Devolve o foco ao menu lateral (chamado quando o usuário pressiona ESQUERDA no fragment filho). Original: D(Fragment) */
    fun D(fragment: Fragment)
}

/**
 * Base de fragments com AutoSize (`CustomAdapt`: baseOnWidth, sizeInDp 0), ciclo de visibilidade (`O`, `V/W`) e
 * hooks `onAttach/onDetach/onHiddenChanged` que repassam visibilidade ao [VisibilityListener].
 * Original: com/live/evo/fragment/c.java (nome sugerido BaseFragment); d.java = subclasse vazia (BaseMenuFragment)
 */
open class BaseFragment : Fragment(), CustomAdapt, OnAttachStateChangeListener, VisibilityListener {
    override fun getSizeInDp(): Float = 0f
    override fun isBaseOnWidth(): Boolean = true
    protected open fun onVisible(visible: Boolean) {}                  // W(boolean)
    protected open fun onUserVisible(visible: Boolean) {}              // V(boolean)
    open fun onVisibleToUser(visible: Boolean) {}                      // O(boolean)
    override fun onViewAttachedToWindow(v: View) {}
    override fun onViewDetachedFromWindow(v: View) {}
    /** Contrato de presenter genérico usado pelas telas de login (setPresenter). */
    open fun setPresenter(presenter: Any?) {}
}
/** Original: com/live/evo/fragment/d.java */
open class BaseMenuFragment : BaseFragment()

/**
 * Fragment "preguiçoso" para telas da TV: `b0()` = layout, `c0(Bundle)` = init de dados, `d0()` = depois de init,
 * `f0(View)` = ligar views, `h0(visible)` = visível ao usuário. Reaproveita a view raiz entre onCreateView
 * (`f15202f`); anima setas com `R.anim.arrow_shake` ([shake]).
 * Original: l5/b.java (nome sugerido LazyFragment)
 */
abstract class LazyFragment : BaseFragment() {
    private var cachedView: View? = null
    protected abstract fun layoutId(): Int             // b0
    protected abstract fun initData(savedInstanceState: Bundle?) // c0
    protected abstract fun bindViews(root: View)       // f0
    protected open fun afterInit() {}                  // d0
    protected open fun onVisibleChanged(visible: Boolean) {} // h0
    protected fun shake(view: View?) { view?.startAnimation(AnimationUtils.loadAnimation(context, R.anim.arrow_shake)) } // i0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(layoutId(), container, false)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { cachedView = cachedView ?: view; bindViews(cachedView!!) }
    override fun onActivityCreated(savedInstanceState: Bundle?) { super.onActivityCreated(savedInstanceState); initData(savedInstanceState); afterInit() }
}

/**
 * Fragment base dos menus: `R()` layout, `S(Bundle)` dados, `T()` pós-dados, `V(View)` views, `W(hasFocus)`,
 * `X(isVisible)` (disparado em `onHiddenChanged`). Guarda um `a2` callback (`Y`).
 * Original: com/live/evo/fragment/f0.java (nome sugerido LazyMenuFragment)
 */
abstract class LazyMenuFragment : Fragment() {
    protected var menuCallback: OnMenuCallback? = null
    /** Original: Y(a2) */ fun setMenuCallback(cb: OnMenuCallback?) { menuCallback = cb }
    protected abstract fun layoutId(): Int               // R
    protected abstract fun initData(savedInstanceState: Bundle?) // S
    protected abstract fun bindViews(root: View)         // V
    protected open fun afterInit() {}                    // T
    open fun onFocusChanged(hasFocus: Boolean) {}        // W
    open fun onVisibilityChanged(isVisible: Boolean) {}  // X
    protected fun shake(view: View?) { view?.startAnimation(AnimationUtils.loadAnimation(context, R.anim.arrow_shake)) } // Z
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        if (layoutId() != 0) inflater.inflate(layoutId(), container, false) else null
    override fun onHiddenChanged(hidden: Boolean) { super.onHiddenChanged(hidden); if (view != null && isAdded) onVisibilityChanged(!hidden) }
}

/** DialogFragment base (onStart/onDismiss, registra z1). Original: com/live/evo/fragment/b.java */
open class BaseDialogFragment : DialogFragment()
