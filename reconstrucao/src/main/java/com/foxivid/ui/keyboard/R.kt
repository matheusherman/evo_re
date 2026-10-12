package com.foxivid.ui.keyboard

/**
 * IDs de recursos do módulo do teclado (ziyi.kit.keyboard.R*). As classes R$* originais (anim, animator,
 * attr, bool, color, dimen, drawable, fraction, id, integer, interpolator, layout, raw, string, style,
 * styleable, transition) são geradas pelo AAPT e só contêm constantes numéricas; não são reconstruídas
 * uma a uma. Os recursos usados pelo código do teclado são listados abaixo.
 *
 * Original: ziyi/kit/keyboard/R$*.java e DataBinderMapperImpl.java (mapper vazio do DataBinding: sem layouts
 * com binding, apenas delega a androidx.databinding.library.baseAdapters.DataBinderMapperImpl)
 */
object R {
    object layout { const val key_key_view = 0 /* TODO: id gerado no build */ }
    object id { const val tv_key = 0; const val iv_key = 0 }
    object drawable {
        const val key_keyboard_background_shape = 0
        const val key_normal_focus = 0
        const val key_normal_unfocus = 0
        const val key_icon_close = 0
        const val key_icon_del = 0
        const val key_icon_lower_case = 0
        const val key_icon_upper_case = 0
    }
    object color { const val keyTextColor = 0; const val keyNextColor = 0 }
    object styleable {
        /** attrs: keyWidth, keyHeight, keyHorizontalSpace, keyVerticalSpace, keyboardType (0 ninePalace, 1 letter, 2 letterNumber, 3 symbol) */
        val KeyboardView = IntArray(0)
        const val KeyboardView_keyWidth = 0
        const val KeyboardView_keyHeight = 0
        const val KeyboardView_keyHorizontalSpace = 0
        const val KeyboardView_keyVerticalSpace = 0
        const val KeyboardView_keyboardType = 0
    }
}
