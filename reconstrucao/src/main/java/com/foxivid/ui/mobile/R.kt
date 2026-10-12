package com.foxivid.ui.mobile

/**
 * Recursos da biblioteca mobile (com.tvc.lib.mobile usa os recursos do módulo `tvcbaselib`, ou seja,
 * `t.v.c.R`). Apenas os IDs referenciados pelos widgets reconstruídos; valores gerados no build.
 *
 * Original: t/v/c/R$*.java (layouts layout_fullscreen_menu, common_view_tab_bar, common_view_tab_item,
 * spinner_edit_text; ids name/icon/item_layout/iv_tab_icon/tv_tab_name/list_item; mipmap delete_input;
 * styleables SLoadingView/SLoadingTextView; drawables brand_logo/toast_img_success; strings no_epg, ...)
 */
object R {
    object layout {
        const val layout_fullscreen_menu = 0
        const val common_view_tab_bar = 0
        const val common_view_tab_item = 0
        const val spinner_edit_text = 0
    }
    object id {
        const val name = 0; const val icon = 0; const val item_layout = 0
        const val iv_tab_icon = 0; const val tv_tab_name = 0; const val list_item = 0
    }
    object mipmap { const val delete_input = 0 }
    object color { const val transparent = 0; const val white = 0 }
    object drawable { const val brand_logo = 0; const val toast_img_success = 0 }
    object string {
        const val no_epg = 0; const val no_epg_program = 0; const val request_failure = 0
        const val no_version_update = 0; const val update_msg = 0; const val version = 0
        const val share_via = 0; const val app_not_installed = 0
    }
    object style { const val common_dialog_style = 0 }
    object styleable {
        val SLoadingView = IntArray(0)
        const val SLoadingView_s_type = 0
        const val SLoadingView_s_color = 0
        const val SLoadingView_s_color_extra = 0
        val SLoadingTextView = IntArray(0)
        const val SLoadingTextView_z_text = 0
    }
}
