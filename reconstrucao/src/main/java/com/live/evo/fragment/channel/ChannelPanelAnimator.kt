package com.live.evo.fragment.channel

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.live.evo.R
import org.slf4j.LoggerFactory

/**
 * As quatro animações de largura que abrem/fecham as colunas do painel de canais:
 *
 * - `categoryAnimClose` / `categoryAnimOpen`: largura da coluna de categorias (valor `0..dimen/10`, multiplicado por 10).
 * - `epgAnimOpen` / `epgAnimClose`: largura da coluna de EPG (`0..epg_width_2`).
 *
 * Todas duram 100 ms. Os valores iniciais de largura vêm dos dimens `classify_width_2` e `epg_width_2`.
 *
 * Original: com/live/evo/fragment/x.java — `e2()`, `f2()`, `g2()`, `h2()`, `i2()` e as classes internas
 * `x$b` (fim do close de categorias: `mIsCategoryOpen = false`), `x$c`, `x$d` (início do open da EPG: torna visível),
 * `x$e` (fim do close da EPG: esconde).
 */
class ChannelPanelAnimator(
    private val context: Context?,
    private val views: ChannelViews,
    private val state: ChannelMenuState,
) {
    private val logger = LoggerFactory.getLogger(ChannelPanelAnimator::class.java)

    var categoryAnimClose: ValueAnimator? = null
        private set
    var categoryAnimOpen: ValueAnimator? = null
        private set
    var epgAnimOpen: ValueAnimator? = null
        private set
    var epgAnimClose: ValueAnimator? = null
        private set

    /** Original: `x.e2()` */
    fun build() {
        val categoryWidth = context?.resources?.getDimension(R.dimen.classify_width_2)?.toInt() ?: 0
        val epgWidth = context?.resources?.getDimension(R.dimen.epg_width_2)?.toInt() ?: 0

        // fecha a coluna de categorias: largura = W - valor*10
        if (categoryAnimClose == null) categoryAnimClose = ValueAnimator.ofInt(0, categoryWidth / 10).apply { duration = 100L }
        categoryAnimClose!!.addUpdateListener { animation ->
            val value = animation.animatedValue as Int
            views.categoryParent?.layoutParams?.width = categoryWidth - value * 10
            views.categoryParent?.requestLayout()
        }
        categoryAnimClose!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationEnd(animation: Animator) { state.isCategoryOpen = false }            // x$b
            override fun onAnimationRepeat(animation: Animator) {}
            override fun onAnimationStart(animation: Animator) { logger.debug("categoryAnimClose start") }
        })

        // abre a coluna de categorias: largura = valor*10
        if (categoryAnimOpen == null) categoryAnimOpen = ValueAnimator.ofInt(0, categoryWidth / 10).apply { duration = 100L }
        categoryAnimOpen!!.addUpdateListener { animation ->
            val value = animation.animatedValue as Int
            views.categoryParent?.layoutParams?.width = value * 10
            views.categoryParent?.requestLayout()
        }
        categoryAnimOpen!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationEnd(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
            override fun onAnimationStart(animation: Animator) { logger.debug("categoryAnimOpen") }        // x$c
        })

        // abre a coluna de EPG: largura = valor
        if (epgAnimOpen == null) epgAnimOpen = ValueAnimator.ofInt(0, epgWidth).apply { duration = 100L }
        epgAnimOpen!!.addUpdateListener { animation ->
            views.epgParent?.layoutParams?.width = animation.animatedValue as Int
            views.epgParent?.requestLayout()
        }
        epgAnimOpen!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationEnd(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
            override fun onAnimationStart(animation: Animator) { views.epgParent?.visibility = View.VISIBLE }   // x$d
        })

        // fecha a coluna de EPG: largura = W - valor
        if (epgAnimClose == null) epgAnimClose = ValueAnimator.ofInt(0, epgWidth).apply { duration = 100L }
        epgAnimClose!!.addUpdateListener { animation ->
            views.epgParent?.layoutParams?.width = epgWidth - animation.animatedValue as Int
            views.epgParent?.requestLayout()
        }
        epgAnimClose!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationEnd(animation: Animator) { views.epgParent?.visibility = View.GONE }       // x$e
            override fun onAnimationRepeat(animation: Animator) {}
            override fun onAnimationStart(animation: Animator) {}
        })
    }

    /** Inicia a abertura da coluna de categorias e marca `isCategoryOpen` (padrão repetido em `x.onKey/onHiddenChanged`). */
    fun openCategories() {
        categoryAnimOpen?.start()
        state.isCategoryOpen = true
    }

    /** Inicia o fechamento da coluna de categorias (o fim da animação marca `isCategoryOpen = false`). */
    fun closeCategories() {
        categoryAnimClose?.start()
        state.isCategoryOpen = false
    }

    /** Cancela [animator] se estiver rodando (padrão `if (isRunning) cancel()` espalhado em `x.onKey`). */
    fun cancelIfRunning(animator: ValueAnimator?) {
        if (animator != null && animator.isRunning) animator.cancel()
    }

    /** Largura atual da coluna de EPG > 0 e visível (usado em `onKey` DPAD_LEFT da lista de canais). */
    fun isEpgColumnShown(): Boolean {
        val parent = views.epgParent ?: return false
        if (parent.visibility != View.VISIBLE) return false
        val params: ViewGroup.LayoutParams? = parent.layoutParams
        return (params?.width ?: 0) > 0
    }
}
