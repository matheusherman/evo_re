package com.foxivid.ui.mobile.ext

import com.foxivid.baselib.model.meta.ChannelStreamResponse

/** Item selecionável de lista (marca de seleção). Original: u7/a.java */
interface SelectableData {
    /** Original: a(boolean) */
    fun setSelected(selected: Boolean)
    /** Original: b() (no StoryListData original a implementação é `getSelected()`) */
    val selected: Boolean
}

/**
 * Item da lista de canais "stories": nome do canal (número + nome), texto do EPG (programa atual ou "sem EPG"),
 * o canal e se está selecionado (o primeiro item nasce selecionado).
 * Original: u7/StoryListData.java
 */
data class StoryListData(
    val column: String,
    val videoTitle: String,
    val epgContent: String,
    val response: ChannelStreamResponse,
    override var selected: Boolean,
) : SelectableData {
    override fun setSelected(selected: Boolean) { this.selected = selected }
}
