package com.foxivid.baselib.event

/**
 * Evento de streaming (tracker/PR/servidor de pares) publicado no EventBus pelo [com.foxivid.baselib.streaming.server.EngineService]
 * e pelo [com.foxivid.baselib.streaming.server.HttpServiceWrapper] (código 1000 = catch-up "não gratuito").
 * Original: nf/v.java
 */
class StreamingEvent(
    val mediaId: String?,      // mediaId
    val playSession: Long,     // d()
    val playerId: Int,         // e()
    val code: Int,             // c()
    val event: String,         // mensagem (campo `event`)
)

/**
 * Aviso do motor (callback `onNotice`), publicado como evento sticky. Original: nf/t.java
 */
class StreamingNoticeEvent(
    val playSession: Long,     // f16409a
    val playerId: Int,         // c()
    val code: Int,             // a()
    val message: String,       // b()
)
