package com.foxivid.ui.mobile.base

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * FragmentPagerAdapter base: o construtor chama [createFragments] (abstract `a`) para preencher a
 * lista; mantém o fragment primário atual.
 *
 * Original: com/tvc/lib/mobile/ui/base/f.java
 */
@Suppress("DEPRECATION")
abstract class BaseFragmentPagerAdapter<T : Fragment, D>(fm: FragmentManager, behavior: Int = 0) :
    FragmentPagerAdapter(fm) {

    private var fragments: List<T> = ArrayList()
    private var currentFragment: T? = null

    init {
        val list = ArrayList<T>()
        fragments = list
        createFragments(fm, list)
    }

    constructor(activity: FragmentActivity) : this(activity.supportFragmentManager, 0)

    /** Preenche a lista de fragments. Original: a(FragmentManager, List) */
    protected abstract fun createFragments(fm: FragmentManager, list: MutableList<T>)

    protected fun setFragments(list: List<T>) { fragments = list }

    override fun getCount(): Int = fragments.size
    override fun getItem(position: Int): T = fragments[position]

    @Suppress("UNCHECKED_CAST")
    override fun setPrimaryItem(container: ViewGroup, position: Int, obj: Any) {
        if (currentFragment != obj) currentFragment = obj as T
        super.setPrimaryItem(container, position, obj)
    }
}
