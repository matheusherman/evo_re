package com.foxivid.baselib.ad

import java.io.File

/**
 * Item de anúncio de abertura (startup) já baixado para o disco.
 *
 * Original: x1/f1/lb/ad/AdItem.java (no metadata Kotlin o nome interno é `x1/f1/lb/ad/a`;
 * o R8 preservou o nome `AdItem`).
 *
 * @property id índice sequencial do item na lista (0, 1, 2...), não um id de servidor.
 * @property isVideo `true` quando a URL de origem termina em .mp4/.mov/.ts/.mpegts.
 * @property file arquivo local em cache (baixado pelo cache de arquivos da API).
 */
data class AdItem(
    val id: Int,
    val isVideo: Boolean,
    val file: File,
)
