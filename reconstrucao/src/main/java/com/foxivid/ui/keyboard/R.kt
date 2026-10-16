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
    object layout { const val key_key_view = 2131624147 }
    object id { const val tv_key = 2131429706; const val iv_key = 2131428315 }
    object drawable {
        const val key_keyboard_background_shape = 2131231301
        const val key_normal_focus = 2131231305
        const val key_normal_unfocus = 2131231309
        const val key_icon_close = 2131231296
        const val key_icon_del = 2131231297
        const val key_icon_lower_case = 2131231298
        const val key_icon_upper_case = 2131231300
    }
    object color { const val keyTextColor = 2131100441; const val keyNextColor = 2131100440 }
    object styleable {
        /** attrs: keyWidth, keyHeight, keyHorizontalSpace, keyVerticalSpace, keyboardType (0 ninePalace, 1 letter, 2 letterNumber, 3 symbol) */
        val KeyboardView = intArrayOf(2130969518, 2130969519, 2130969521, 2130969522, 2130969524)
        const val KeyboardView_keyWidth = 3
        const val KeyboardView_keyHeight = 0
        const val KeyboardView_keyHorizontalSpace = 1
        const val KeyboardView_keyVerticalSpace = 2
        const val KeyboardView_keyboardType = 4
    }
}
