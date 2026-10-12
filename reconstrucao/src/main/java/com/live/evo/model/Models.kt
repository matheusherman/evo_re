package com.live.evo.model

/**
 * Modelos de UI (pacote original `i5`, não-ofuscado só no nome do pacote). Campos mantidos como no original
 * (nomes legíveis inferidos pelo uso nas classes de `util/ModelHelper`).
 */

/** Canal exibido na UI. Original: i5/h.java (ChannelData; também referenciado como ChannelBean). */
class ChannelData {
    var channelId: String? = null     // v(String)  = key do canal
    var number: Int = 0               // B(int)
    var numberOneBased: Int = 0       // x(int)
    var name: String? = null          // w/u(String) = streamName
    var epgId: String? = null         // z(String)
    var iconUrl: String? = null       // A(String)
    var isCatchup: Boolean = false    // t(boolean)
    var isAdult: Boolean = false      // s(boolean) = channel.c()
    var isFavorite: Int = 0           // C(int)
    var playerArgs: String? = null    // D(String)
    fun b(): String? = channelId
    fun f(): String? = channelId
}
typealias ChannelBean = ChannelData

/** Programa de EPG. Original: i5/p.java (ProgramBean; start/end em millis). */
class ProgramBean(
    var id: Long? = null,
    var channel: String? = null,
    var startTime: Long = 0,
    var title: String? = null,
    var endTime: Long = 0,
    var epgId: String? = null,
    var description: String? = null,
) {
    fun f(): Long = startTime
    fun g(): Long = endTime
    fun e(): String? = title
    fun d(): String? = epgId
    fun b(): String? = channel
}

/** Lembrete/assinatura de programa. Original: i5/c0.java */
class SubscribeBean(
    var id: Long? = null,
    var epgId: String? = null,
    var title: String? = null,
    var channelIndex: Int = 0,
    var channelName: String? = null,
    var channelId: String? = null,
    var startTime: Long = 0,
) {
    fun a(): String? = channelId
    fun h(): Long = startTime
    fun d(): String? = epgId
    fun f(): Int = channelIndex
    /** Fim do programa (j()). */ fun endTime(): Long = endTimeMs
    /** Ícone do canal (e()). */ fun channelIcon(): String? = iconUrl
    var endTimeMs: Long = 0
    var iconUrl: String? = null
}

/** Categoria/coluna de canais. Original: i5/i.java */
class CategoryBean(var seq: Int = 0, var name: String? = null, var id: String? = null, var isAdultColumn: Int = 0)

/** Pergunta/resposta (FAQ). Original: i5/r.java */
class QuestionBean(val question: String, val answer: String)

/** Item de propriedade remota (id, grupo, chave, valor). Original: i5/a0.java */
class AppProperty(val id: Long?, val group: String?, val key: String?, val value: String?)
