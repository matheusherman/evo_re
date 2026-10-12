package com.foxivid.ui.widget.banner.util

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.foxivid.ui.widget.banner.Banner
import org.slf4j.LoggerFactory

/**
 * LayoutManager do ViewPager2 que usa a duração de scroll configurada no [Banner]
 * (`scrollTime`). Substitui por reflexão o layout manager interno do ViewPager2.
 *
 * Original: t/v/c/widget/banner/util/ScrollSpeedManger.java (método estático n = reflectLayoutManager)
 */
class ScrollSpeedManger(
    private val banner: Banner<*, *>,
    layoutManager: LinearLayoutManager
) : LinearLayoutManager(banner.context, layoutManager.orientation, false) {

    override fun smoothScrollToPosition(recyclerView: RecyclerView, state: RecyclerView.State, position: Int) {
        val scroller = object : LinearSmoothScroller(recyclerView.context) {
            override fun calculateTimeForDeceleration(dx: Int): Int = banner.scrollTime
        }
        scroller.targetPosition = position
        startSmoothScroll(scroller)
    }

    companion object {
        private val log = LoggerFactory.getLogger(ScrollSpeedManger::class.java)

        /** Original: ScrollSpeedManger.n(Banner) */
        @JvmStatic
        fun reflectLayoutManager(banner: Banner<*, *>) {
            if (banner.scrollTime < 100) return
            try {
                val viewPager2 = banner.viewPager2!!
                val recyclerView = viewPager2.getChildAt(0) as RecyclerView
                recyclerView.overScrollMode = 2
                val manager = ScrollSpeedManger(banner, recyclerView.layoutManager as LinearLayoutManager)
                recyclerView.layoutManager = manager
                setField(ViewPager2::class.java, viewPager2, "mLayoutManager", manager)
                val transformerAdapter = ViewPager2::class.java.getDeclaredField("mPageTransformerAdapter")
                    .apply { isAccessible = true }.get(viewPager2)
                if (transformerAdapter != null) setField(transformerAdapter.javaClass, transformerAdapter, "mLayoutManager", manager)
                val scrollEventAdapter = ViewPager2::class.java.getDeclaredField("mScrollEventAdapter")
                    .apply { isAccessible = true }.get(viewPager2)
                if (scrollEventAdapter != null) setField(scrollEventAdapter.javaClass, scrollEventAdapter, "mLayoutManager", manager)
            } catch (e: Exception) {
                log.error("reflect layout failure", e)
            }
        }

        private fun setField(cls: Class<*>, target: Any, name: String, value: Any) {
            cls.getDeclaredField(name).apply { isAccessible = true }.set(target, value)
        }
    }
}
