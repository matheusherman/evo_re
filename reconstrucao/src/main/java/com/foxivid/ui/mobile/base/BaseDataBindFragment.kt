package com.foxivid.ui.mobile.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.foxivid.baselib.util.LocaleManager
import com.foxivid.ui.mobile.R
import com.foxivid.ui.mobile.widget.sloading.SLoadingDialog
import com.foxivid.ui.mobile.widget.sloading.SLoadingType

/**
 * Fragment com DataBinding: infla [layoutId], guarda a activity e o binding e cria um diálogo de
 * loading (`y7.a`, criado por `j.f23105a.l(activity, color)`). Reaplica o locale em onAttach/onResume.
 *
 * Original: com/tvc/lib/mobile/ui/base/d.java (BaseDataBindFragment; S()=activity, T()=binding,
 * U()=dismissLoading, Z()=showLoading, R()=cor do loading (padrão branco), V()=initView, W()=layoutId)
 */
abstract class BaseDataBindFragment<DB : ViewDataBinding> : Fragment() {

    lateinit var mActivity: FragmentActivity
    lateinit var mDataBinding: DB
    private var rootView: View? = null
    private var loadingDialog: LoadingViewDialog? = null

    abstract fun initView()                 // V()
    @LayoutRes abstract fun layoutId(): Int // W()

    /** Cor de fundo do loading. Original: R() */
    open fun loadingColor(): Int = R.color.white

    fun dismissLoading() { loadingDialog?.dismiss() }

    fun showLoading() {
        if (!mActivity.isFinishing && !mActivity.isDestroyed) loadingDialog?.show()
    }

    override fun onAttach(context: Context) {
        super.onAttach(LocaleManager.attach(context, null))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mDataBinding = DataBindingUtil.inflate(inflater, layoutId(), container, false)
        mActivity = requireActivity()
        rootView = mDataBinding.root
        // original: j.f23105a.l(S(), R()) — fábrica do diálogo de loading (classe j de outro módulo)
        loadingDialog = LoadingViewDialog.create(mActivity, loadingColor())
        return rootView
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        initObservers()
    }

    open fun initObservers() {}  // y()

    override fun onDestroy() {
        dismissLoading()
        loadingDialog = null
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        context?.let { LocaleManager.attach(it, null) }
    }
}

/**
 * Diálogo de loading (`y7.a`): `d()` = dismiss, `h()` = show; implementado por [SLoadingDialog].
 * Original: y7/a.java
 */
interface LoadingViewDialog {
    fun dismiss()
    fun show()

    companion object {
        fun create(activity: FragmentActivity, color: Int): LoadingViewDialog =
            SLoadingDialog(activity).apply {                       // Original: z7.j.l(context, colorFocused)
                setType(SLoadingType.TRANSLATE_CIRCLE)
                setColor(androidx.core.content.ContextCompat.getColor(activity, color))
            }
    }
}
