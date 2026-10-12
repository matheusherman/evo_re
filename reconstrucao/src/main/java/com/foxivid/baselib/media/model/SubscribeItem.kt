package com.foxivid.baselib.media.model

import androidx.annotation.Keep

/**
 * Original: x1/f1/lb/media/model/SubscribeItem.java
 *
 * Lembrete ("subscribe") de um jogo/programa esportivo. Persistido em [com.foxivid.baselib.media.SubscribeCache]
 * com a chave `<epgId>.<streamId>.<start>` (ver `ChannelManager.subscribeKey`).
 * `isAvailable` é o único campo mutável (Original: `g(boolean)`).
 */
@Keep
data class SubscribeItem(
    val sportId: String,
    val start: Long,
    val stop: Long,
    val title: String,
    val desc: String,
    var isAvailable: Boolean,
)
