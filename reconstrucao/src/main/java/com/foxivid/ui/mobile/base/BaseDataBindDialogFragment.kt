package com.foxivid.ui.mobile.base

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.FloatRange
import androidx.annotation.GravityInt
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.foxivid.ui.mobile.R

/**
 * DialogFragment com DataBinding: infla `layoutId()`, configura cancelável, chama
 * initView/initData/initObservers e, em onStart, aplica largura/altura/gravity e dim (0.5) à janela.
 * Estilo `common_dialog_style`.
 *
 * Original: com/tvc/lib/mobile/ui/base/g.java (interface interna g$a vazia; método R() retorna null)
 */
abstract class BaseDataBindDialogFragment<VB : ViewDataBinding> : DialogFragment(), BaseDialogContract {

    private var dataBinding: VB? = null
    private var ctx: Context? = null
    private var hostActivity: AppCompatActivity? = null
    private var isCancelableDefault = true

    protected fun binding(): VB? = dataBinding

    /** Dim da janela atrás do diálogo (0..1). Original: V() */
    @FloatRange(from = 0.0, to = 1.0)
    open fun dimAmount(): Float = 0.5f

    fun setCancelableDefault(cancelable: Boolean) { isCancelableDefault = cancelable }

    /** Mostra usando o nome simples da classe como tag. Original: X(FragmentManager) */
    fun showDialog(manager: FragmentManager) = super.show(manager, javaClass.simpleName)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ctx = activity
        hostActivity = activity as AppCompatActivity
        dialog?.setCanceledOnTouchOutside(isCancelableDefault)
        dialog?.setCancelable(isCancelableDefault)
        val vb = DataBindingUtil.inflate<VB>(inflater, layoutId(), container, false)
        dataBinding = vb
        vb.lifecycleOwner = this
        initView()
        initData()
        initObservers()
        return dataBinding!!.root
    }

    override fun onDismiss(dialog: DialogInterface) { super.onDismiss(dialog) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(0, R.style.common_dialog_style)
    }

    override fun onStart() {
        super.onStart()
        val window = dialog?.window
        val attributes = window?.attributes
        attributes?.width = dialogWidth()
        attributes?.height = dialogHeight()
        attributes?.gravity = dialogGravity()
        window?.attributes = attributes
        window?.setDimAmount(dimAmount())
    }
}
