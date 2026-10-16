package com.live.evo.fragment.channel

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.live.evo.AppUserManager
import com.live.evo.R
import com.live.evo.catchup.player.CatchUpBannerAdapter
import com.live.evo.util.TextStyleUtils
import com.live.evo.widget.ProgramListView
import com.live.evo.widget.RemoveKeyCodeEnterEditText
import com.youth.banner.Banner

/**
 * Referências às views do layout `program_view_layout3` (3 colunas: categorias | canais | EPG) e do painel de
 * senha adulta. Equivale a `x.f0(View)` (+ `x.d2(View)` para os campos `adultkeyl_*`).
 *
 * Original: com/live/evo/fragment/x.java — `f0()` e `d2()`
 */
class ChannelViews(val root: View) {
    // --- coluna 1: categorias ---
    val categoryListView: ProgramListView? = root.findViewById(R.id.programviewl_lv_main_program_listview_classify)
    val categoryLayout: LinearLayout? = root.findViewById(R.id.programviewl_ll_clssify_layout)
    val categoryParent: View? = root.findViewById(R.id.programviewl_rly_classify_parent)
    val categoryNameLabel: TextView? = root.findViewById(R.id.programviewl_tv_clssify_name)
    private val categoryNameNoClassify: TextView? = root.findViewById(R.id.programviewl_tv_clssify_name_no_classify)
    val categoryBannerParent: RelativeLayout? = root.findViewById(R.id.programviewl_rl_banner_parent)
    val categoryBanner: Banner<String, CatchUpBannerAdapter>? = root.findViewById(R.id.programviewl_bn_banner)
    val categoryBannerFrontPic: ImageView? = root.findViewById(R.id.programviewl_categoryly_iv_front)
    val categoryBannerDesc: TextView? = root.findViewById(R.id.programviewl_categoryly_tv_desc)

    // --- coluna 2: canais ---
    val programListView: ProgramListView? = root.findViewById(R.id.programviewl_lv_main_program_listview)
    val channelParent: RelativeLayout? = root.findViewById(R.id.programviewl_rl_program)
    val totalProgramsLabel: TextView? = root.findViewById(R.id.programviewl_tv_program_all_num)
    val textPosition: TextView? = root.findViewById(R.id.programviewl_tv_program_position)
    val textProgramTotal: TextView? = root.findViewById(R.id.programviewl_tv_program_position_total)
    val textCurrentPos: TextView? = root.findViewById(R.id.programviewl_tv_program_current_position)
    val sessionId: TextView? = root.findViewById(R.id.programviewl_tv_sessionid)
    val textPipTip: TextView? = root.findViewById(R.id.programviewl_tv_piptip)
    val layoutBanner: RelativeLayout? = root.findViewById(R.id.programviewl_ll_layout_channel_banner)
    val banner: Banner<String, CatchUpBannerAdapter>? = root.findViewById(R.id.programviewl_bn_channel_banner)
    val ivRightLayout: LinearLayout? = root.findViewById(R.id.programviewl_ll_layout_arrowright)
    val ivRight: ImageView? = root.findViewById(R.id.programviewl_iv_right)

    /** Container do PIP dentro do menu; só existe se a propriedade remota `pip_on_channel` (padrão true) estiver ligada. */
    val previewContainer: RelativeLayout? =
        if (AppUserManager.get().getBoolean("pip_on_channel", true)) root.findViewById(R.id.programviewl_preview_container) else null

    // --- coluna 3: EPG ---
    val epgParent: LinearLayout? = root.findViewById(R.id.programviewl_ll_epg_parent)
    val epgListParent: RelativeLayout? = root.findViewById(R.id.programviewl_rl_epg_list)
    val epgListView: ProgramListView? = root.findViewById(R.id.programviewl_lv_epg_listview)
    val lvEpgDate: ProgramListView? = root.findViewById(R.id.programviewl_lv_epg_date)
    val tvMonth: TextView? = root.findViewById(R.id.programviewl_tv_month)
    val ivUp: ImageView? = root.findViewById(R.id.programviewl_iv_dateup)
    val ivDown: ImageView? = root.findViewById(R.id.programviewl_iv_image_datedown)
    val tvNotData: TextView? = root.findViewById(R.id.programviewl_tv_not_data)
    val epgDesc: TextView? = root.findViewById(R.id.epgdesc_tv_epg_desc)
    val epgTime: TextView? = root.findViewById(R.id.epgdesc_tv_epg_time)
    val epgProgramName: TextView? = root.findViewById(R.id.epgdesc_tv_epg_channel_name)
    val epgChannel: TextView? = root.findViewById(R.id.programviewl_tv_epg_channel)
    val epgDuration: TextView? = root.findViewById(R.id.programviewl_tv_epg_duration)
    val epgProgram: TextView? = root.findViewById(R.id.programviewl_tv_epg_program)
    val epgDescription: TextView? = root.findViewById(R.id.programviewl_tv_epg_description)
    val tvDuration: TextView? = root.findViewById(R.id.programviewl_tv_duration)
    val tvProgram: TextView? = root.findViewById(R.id.programviewl_tv_program)

    // --- painel de senha adulta (x.d2) ---
    val adultKeyParent: RelativeLayout? = root.findViewById(R.id.programviewl_rl_adult)
    val layoutPwd: RelativeLayout? = root.findViewById(R.id.adultkeyl_rl_pwd_layout)
    val etPassword: RemoveKeyCodeEnterEditText? = root.findViewById(R.id.adultkeyl_et_pwd)
    val goAhead: Button? = root.findViewById(R.id.adultkeyl_btn_go)
    val adultTitle: TextView? = root.findViewById(R.id.adultkeyl_tv_title)
    val adultHint: TextView? = root.findViewById(R.id.adultkeyl_tv_hint)

    /** Visibilidade inicial da coluna de categorias e rótulo alternativo (quando `AppConstants.f5181a` é falso). */
    fun applyCategoryColumnVisibility(showCategories: Boolean) {
        if (showCategories) {
            categoryListView?.visibility = View.VISIBLE
            categoryLayout?.visibility = View.VISIBLE
        } else {
            categoryNameNoClassify?.visibility = View.VISIBLE
        }
    }

    /**
     * Encadeia o foco D-pad entre as colunas (`setNextFocus*Id`) — bloco no meio de `x.f0()`.
     */
    fun wireNextFocus() {
        lvEpgDate?.setNextFocusLeftId(R.id.programviewl_lv_main_program_listview)
        lvEpgDate?.setNextFocusRightId(R.id.programviewl_lv_epg_listview)
        lvEpgDate?.setNextFocusUpId(R.id.programviewl_lv_epg_date)
        lvEpgDate?.setNextFocusDownId(R.id.programviewl_lv_epg_date)
        programListView?.setNextFocusRightId(R.id.programviewl_lv_epg_listview)
        programListView?.setNextFocusLeftId(R.id.programviewl_lv_main_program_listview_classify)
        programListView?.setNextFocusUpId(R.id.programviewl_lv_main_program_listview)
        programListView?.setNextFocusDownId(R.id.programviewl_lv_main_program_listview)
        categoryListView?.setNextFocusRightId(R.id.programviewl_lv_main_program_listview)
        categoryListView?.setNextFocusUpId(R.id.programviewl_lv_main_program_listview_classify)
        categoryListView?.setNextFocusDownId(R.id.programviewl_lv_main_program_listview_classify)
        epgListView?.setNextFocusLeftId(R.id.programviewl_lv_epg_date)
        epgListView?.setNextFocusUpId(R.id.programviewl_lv_epg_listview)
        epgListView?.setNextFocusDownId(R.id.programviewl_lv_epg_listview)
        adultKeyParent?.setNextFocusLeftId(R.id.programviewl_lv_main_program_listview_classify)
    }

    /**
     * Fontes: `LoginConfig.get().a()` (flag de fonte alternativa) escolhe entre dois conjuntos de typefaces
     * (`TextStyleUtils.a/b/c/d` = typeface0/2/3/1). Original: bloco `com.live.evo.util.e.b().a()` em `x.f0()`.
     */
    fun applyFonts(alternateFont: Boolean) {
        if (alternateFont) {
            TextStyleUtils.b(categoryNameLabel); TextStyleUtils.b(textPosition); TextStyleUtils.b(textProgramTotal)
            TextStyleUtils.b(sessionId); TextStyleUtils.b(tvMonth); TextStyleUtils.c(tvDuration); TextStyleUtils.c(tvProgram)
            TextStyleUtils.b(epgDesc); TextStyleUtils.b(epgDesc); TextStyleUtils.b(epgTime); TextStyleUtils.b(epgProgramName)
            TextStyleUtils.b(epgChannel); TextStyleUtils.b(epgDuration); TextStyleUtils.b(epgProgram)
            TextStyleUtils.b(epgDescription); TextStyleUtils.b(tvNotData)
        } else {
            TextStyleUtils.a(categoryNameLabel); TextStyleUtils.a(textPosition); TextStyleUtils.b(textProgramTotal)
            TextStyleUtils.b(sessionId); TextStyleUtils.b(tvMonth); TextStyleUtils.b(epgDesc); TextStyleUtils.b(epgTime)
            TextStyleUtils.b(epgProgramName); TextStyleUtils.b(epgChannel); TextStyleUtils.b(epgDuration)
            TextStyleUtils.b(epgProgram); TextStyleUtils.b(epgDescription); TextStyleUtils.d(tvNotData)
        }
    }

    /** Fontes do painel de senha adulta (`x.d2`). */
    fun applyAdultFonts(alternateFont: Boolean) {
        if (alternateFont) {
            TextStyleUtils.b(goAhead); TextStyleUtils.b(etPassword); TextStyleUtils.b(adultHint)
        } else {
            TextStyleUtils.c(goAhead); TextStyleUtils.c(etPassword); TextStyleUtils.c(adultHint)
        }
    }
}
