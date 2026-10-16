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
        const val layout_fullscreen_menu = 2131624158
        const val common_view_tab_bar = 2131624010
        const val common_view_tab_item = 2131624011
        const val spinner_edit_text = 2131624428
    }
    object id {
        const val name = 2131428789; const val icon = 2131428230; const val item_layout = 2131428295
        const val iv_tab_icon = 2131428349; const val tv_tab_name = 2131429759; const val list_item = 2131428436
    }
    object mipmap { const val delete_input = 2131755011 }
    object color { const val transparent = 2131102158; const val white = 2131102208 }
    object drawable { const val brand_logo = 2131230923; const val toast_img_success = 2131232015 }
    object string {
        const val no_epg = 2131952564; const val no_epg_program = 2131952565; const val request_failure = 2131952850
        const val no_version_update = 2131952596; const val update_msg = 2131953107; const val version = 2131953169
        const val share_via = 2131952956; const val app_not_installed = 2131951744
    }
    object style { const val common_dialog_style = 2132018688 }
    object styleable {
        val SLoadingView = intArrayOf(2130970011, 2130970012, 2130970013)
        const val SLoadingView_s_type = 2
        const val SLoadingView_s_color = 0
        const val SLoadingView_s_color_extra = 1
        val SLoadingTextView = intArrayOf(2130970529)
        const val SLoadingTextView_z_text = 0
    }
}
