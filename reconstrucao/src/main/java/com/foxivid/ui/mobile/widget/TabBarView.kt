package com.foxivid.ui.mobile.widget

import com.foxivid.ui.mobile.R

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.foxivid.ui.mobile.ext.downloadFile
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Barra de abas inferior (2 a 5 itens) com ícones locais ou CDN (baixados com Glide) e texto, cores
 * de normal/selecionado e linha de borda branca/preta. Usa o layout `common_view_tab_bar` (binding
 * `p7.a`: TabLayout em `f17362a` e a linha de borda em `f17363b`).
 *
 * Original: com/tvc/lib/mobile/ui/widget/TabBarView.java (classe interna b = [TabBarItemView],
 * c = listener de seleção)
 */
class TabBarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private lateinit var tabBarConfig: TabBarBean
    private var binding: TabBarBinding? = null
    private var onSelected: ((TabBarBean.ItemBean) -> Unit)? = null

    /** Stub do binding gerado `p7.a` (layout common_view_tab_bar). */
    abstract class TabBarBinding : ViewDataBinding(null, null, 0) {
        abstract val tabLayout: TabLayout   // f17362a
        abstract val borderLine: View       // f17363b
    }

    init {
        @Suppress("UNCHECKED_CAST")
        binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(context), R.layout.common_view_tab_bar, this, true
        ) as TabBarBinding
        gravity = 80
        binding!!.tabLayout.setTabRippleColorResource(R.color.transparent)
        binding!!.tabLayout.tabGravity = 0
        binding!!.tabLayout.tabMode = 1
        binding!!.tabLayout.addOnTabSelectedListener(SelectionListener())
    }

    /** Item (RelativeLayout `common_view_tab_item`: iv_tab_icon + tv_tab_name). Original: TabBarView$b */
    class TabBarItemView(context: Context, attrs: AttributeSet?) : RelativeLayout(context, attrs) {
        private val ivTabIcon: AppCompatImageView by lazy { findViewById(R.id.iv_tab_icon) }
        private val tvTabName: AppCompatTextView by lazy { findViewById(R.id.tv_tab_name) }

        init {
            LayoutInflater.from(context).inflate(R.layout.common_view_tab_item, this)
            gravity = 17
        }

        /** Só baixa se for URL ("[a-zA-z]+://\\S*"). Original: d(String) */
        private fun isUrl(url: String?): Boolean = url != null && Regex("[a-zA-z]+://\\S*").containsMatchIn(url)

        /** Baixa o ícone da CDN em IO e entrega o Drawable no Main; null se URL inválida. Original: f(String, l) */
        private fun requestDrawable(url: String?, block: ((Drawable?) -> Unit)?) {
            if (url != null && url.isNotEmpty() && isUrl(url)) {
                CoroutineScope(Dispatchers.IO).launch {
                    val file = downloadFile(context, url)
                    withContext(Dispatchers.Main) {
                        block?.invoke(Drawable.createFromPath(file?.absolutePath))
                    }
                }
            } else {
                block?.invoke(null)
            }
        }

        /** Preenche ícone/nome/cor conforme [selectId] == tab.id. Original: g(TabBarBean, ItemBean, String) */
        fun bind(config: TabBarBean, tab: TabBarBean.ItemBean, selectId: String) {
            val selected = selectId == tab.id
            if (tab.isCdn) {
                requestDrawable(if (selected) tab.selectedIconPath else tab.iconPath) { ivTabIcon.setImageDrawable(it) }
            } else {
                ivTabIcon.setImageResource(if (selected) tab.selectedIconId else tab.iconId)
            }
            tvTabName.text = tab.text
            tvTabName.setTextColor(if (selected) config.selectedColor else config.color)
        }

        /** Sem corpo no original. */
        fun setUnreadVisible(visible: Boolean) {}
    }

    /** Original: TabBarView$c */
    private inner class SelectionListener : TabLayout.OnTabSelectedListener {
        private var firstSelected = true

        override fun onTabSelected(tab: TabLayout.Tab?) {
            if (tab == null) return
            val view = tab.customView as TabBarItemView
            val item = tab.tag as? TabBarBean.ItemBean ?: return
            view.bind(tabBarConfig, item, item.id)
            firstSelected = false
            onSelected?.invoke(item)
        }

        override fun onTabUnselected(tab: TabLayout.Tab?) {
            if (tab == null) return
            val view = tab.customView as TabBarItemView
            val item = tab.tag as? TabBarBean.ItemBean ?: return
            view.bind(tabBarConfig, item, "")
        }

        override fun onTabReselected(tab: TabLayout.Tab?) {}
    }

    /** Monta as abas (só se houver entre 2 e 5 itens). Original: d(TabBarBean, l) */
    fun setConfig(config: TabBarBean, onSelected: (TabBarBean.ItemBean) -> Unit) {
        tabBarConfig = config
        this.onSelected = onSelected
        binding!!.tabLayout.removeAllTabs()
        val items = config.items
        val size = items.size
        if (2 > size || size >= 6) return
        for (item in items) {
            val itemView = TabBarItemView(context, null)
            itemView.bind(config, item, items[0].id)
            val tab = binding!!.tabLayout.newTab().setCustomView(itemView)
            tab.tag = item
            binding!!.tabLayout.addTab(tab)
        }
        binding!!.tabLayout.setBackgroundColor(config.backgroundColor)
        binding!!.borderLine.setBackgroundColor(if (config.borderStyle == "white") -1 else -16777216)
    }

    /** Seleciona a aba na posição. Original: e(int) */
    fun selectTab(position: Int) {
        val layout = binding!!.tabLayout
        if (layout.tabCount <= position) return
        layout.getTabAt(position)?.select()
    }

    fun setSelectListener(onSelected: (TabBarBean.ItemBean) -> Unit) { this.onSelected = onSelected }
}
