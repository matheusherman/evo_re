package com.live.evo.fragment.channel

import android.text.TextUtils
import android.view.View
import com.live.evo.R
import com.live.evo.catchup.player.CatchUpBannerAdapter
import com.live.evo.util.CommonUtils
import com.live.evo.util.GlideImageLoader
import com.live.evo.util.ScreenUtils
import org.slf4j.LoggerFactory

/**
 * Banners do painel de canais:
 *
 * - **banner de canais** (`programviewl_bn_channel_banner`, [loadChannelBanner]): anúncio do slot "2", dimensionado
 *   para caber na altura da tela mantendo a proporção; só aparece se [isChannelBannerActive].
 * - **banner da categoria** (`programviewl_bn_banner` + imagem frontal + descrição, [updateCategoryBanner]):
 *   conteúdo vindo do `i5.i` da categoria selecionada; escondido nas categorias adultas, em "favorite" e sem dados.
 *
 * Original: com/live/evo/fragment/x.java — `j2()`, `S1()`, `a2()`, `V2()`, `Y1()`
 */
class ChannelBannerController(private val ctx: ChannelMenuContext) {
    private val logger = LoggerFactory.getLogger(ChannelBannerController::class.java)
    private val views get() = ctx.views
    private val state get() = ctx.state

    /** Banner de canal habilitado e com dados? Original: `S1()` = `v4.g.e().c() && mShowBanner`. */
    fun isChannelBannerActive(): Boolean = ChannelBannerAds.isEnabled() && state.showBanner

    /** Zera os contadores de navegação/métrica ao mostrar o menu. Original: `a2()` */
    fun resetBrowseMetrics() {
        state.browseCount = 1
        state.clickCount = 0
        state.browseDuration = com.live.evo.util.ServerClock.get().now()
    }

    /**
     * Carrega o banner de canais do slot "2". Se o primeiro criativo tem proporção (largura/dimen `banner_bg_width`)
     * ≥ (altura/alturaDaTela), a altura do banner vira `dimen/largura * altura`; senão a largura vira
     * `alturaDaTela/altura * largura`. Original: `j2()`
     */
    fun loadChannelBanner() {
        state.showBanner = false
        try {
            val slot = ChannelBannerAds.slot(2.toString())
            val creatives = slot?.creatives
            if (slot != null && creatives != null) {
                val urls = ArrayList<String>()
                var screenHeight = ScreenUtils.height()
                var bannerWidth = ctx.fragment.resources.getDimension(R.dimen.banner_bg_width).toInt()
                for (creative in creatives) {
                    if (!TextUtils.isEmpty(creative.imageUrl)) urls.add(creative.imageUrl!!)
                }
                val first = creatives[0]
                val w = first.width.toFloat()
                val dimen = bannerWidth.toFloat()
                val h = first.height.toFloat()
                val screen = screenHeight.toFloat()
                if (w / dimen >= h / screen) {
                    screenHeight = ((dimen / w) * h).toInt()
                } else {
                    bannerWidth = ((screen / h) * w).toInt()
                }
                state.showBanner = urls.isNotEmpty()
                if (state.showBanner) {
                    views.layoutBanner?.visibility = View.GONE
                    views.banner?.layoutParams?.height = screenHeight
                    views.banner?.layoutParams?.width = bannerWidth
                    views.banner?.setDatas(urls)
                    views.banner?.setAdapter(CatchUpBannerAdapter(urls))
                    views.banner?.start()
                    if (ChannelBannerAds.isEnabled()) views.banner?.start()
                }
            }
        } catch (e: Exception) {
            logger.error("get ad failure", e)
        }
    }

    /** Esconde o banner da categoria (para o carrossel, some a imagem frontal e a descrição). Original: `Y1()` */
    fun hideCategoryBanner() {
        if (views.categoryBannerParent?.visibility != View.GONE) {
            views.categoryBanner?.stop()
            views.categoryBannerParent?.visibility = View.GONE
        }
        views.categoryBannerFrontPic?.visibility = View.INVISIBLE
        views.categoryBannerDesc?.visibility = View.INVISIBLE
    }

    /** Atualiza o banner da coluna de categorias para a categoria selecionada. Original: `V2()` */
    fun updateCategoryBanner() {
        if (ctx.adult.needsAdultKey()) {
            hideCategoryBanner()
            return
        }
        val info = (ChannelMenuData.categoryInfo ?: ChannelSdkBridge.categoryInfo())[ChannelMenuData.visibleCategories[state.categorySelect]]
        if (info == null) {
            hideCategoryBanner()
            return
        }
        val frontUrl = info.bannerFrontUrl
        val description = info.bannerDescription
        val images = info.bannerImages
        if (TextUtils.isEmpty(frontUrl) && TextUtils.isEmpty(description) && images.isEmpty()) {
            hideCategoryBanner()
            return
        }
        views.categoryBannerParent?.visibility = View.VISIBLE
        if (TextUtils.isEmpty(frontUrl)) {
            views.categoryBannerFrontPic?.visibility = View.INVISIBLE
        } else {
            views.categoryBannerFrontPic?.visibility = View.VISIBLE
            GlideImageLoader.load(ctx.context!!, frontUrl, R.drawable.icon_transport, views.categoryBannerFrontPic!!)
        }
        views.categoryBannerDesc?.text = description
        views.categoryBannerDesc?.visibility = View.VISIBLE
        val categoryName = ChannelMenuData.visibleCategories[state.categorySelect]
        if (!categoryName.equals(CommonUtils.string(R.string.favorite_list), ignoreCase = true) && images.isNotEmpty()) {
            views.categoryBanner?.visibility = View.VISIBLE
            views.categoryBanner?.setAdapter(CatchUpBannerAdapter(images))
            views.categoryBanner?.start()
            return
        }
        if (views.categoryBannerParent?.visibility != View.GONE) {
            views.categoryBanner?.stop()
            views.categoryBanner?.visibility = View.GONE
        }
    }
}
