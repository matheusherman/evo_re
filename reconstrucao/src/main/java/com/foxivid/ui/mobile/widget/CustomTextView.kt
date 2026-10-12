package com.foxivid.ui.mobile.widget

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.widget.TextView

/**
 * TextView que trunca o texto para no máximo [maxCharacters] (padrão 13) substituindo o final por "...".
 * Original: com/tvc/lib/mobile/ui/widget/CustomTextView.java
 */
class CustomTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : androidx.appcompat.widget.AppCompatTextView(context, attrs, defStyle) {

    private var maxChars = 13

    init { ellipsize = TextUtils.TruncateAt.END }

    fun setMaxCharacters(max: Int) { maxChars = max }

    override fun onTextChanged(text: CharSequence, start: Int, lengthBefore: Int, lengthAfter: Int) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)
        if (maxChars == 0) maxChars = 13
        if (text.length > maxChars) {
            setText(text.subSequence(0, maxChars - 3).toString() + "...")
        }
    }
}
