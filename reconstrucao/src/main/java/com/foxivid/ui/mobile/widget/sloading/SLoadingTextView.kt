package com.foxivid.ui.mobile.widget.sloading

import android.content.Context
import android.text.TextUtils
import com.foxivid.ui.mobile.R
import android.util.AttributeSet

/**
 * SLoadingView fixo no tipo TEXT (atributo `z_text`); [setText] repassa o texto ao builder de texto (`q`).
 * Original: com/tvc/lib/mobile/ui/widget/sloading/anim/SLoadingTextView.java
 */
class SLoadingTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = -1
) : SLoadingView(context, attrs, defStyle) {

    private var text = ""

    init {
        super.setLoadingBuilder(SLoadingType.TEXT)
        try {
            val a = context.obtainStyledAttributes(attrs, R.styleable.SLoadingTextView)
            val s = a.getString(R.styleable.SLoadingTextView_z_text)
            a.recycle()
            if (!TextUtils.isEmpty(s)) text = s!!
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onAttachedToWindow() {
        setText(text)
        super.onAttachedToWindow()
    }

    @Deprecated("O tipo é sempre TEXT")
    override fun setLoadingBuilder(type: SLoadingType) {
        super.setLoadingBuilder(SLoadingType.TEXT)
    }

    fun setText(text: String) {
        this.text = text
        // original: if (builder instanceof q) ((q) builder).z(text)
        (builder as? TextLoadingBuilder)?.setLabel(text)
    }
}
