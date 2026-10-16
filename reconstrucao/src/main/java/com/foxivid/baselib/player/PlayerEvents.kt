package com.foxivid.baselib.player

import com.foxivid.baselib.streaming.engine.PlayType

/**
 * Eventos do player publicados no EventBus pelo [VideoViewHandler] (e consumidos por [PlayerViewHandler], monitores e telas).
 */

/**
 * Pedido de reinício do player: [code] 1 = buffering prolongado; 2..7 = códigos do watchdog ("player no playlist request",
 * "streaming no playlist response", ...); [cnt] = quantas vezes o mesmo código se repetiu; [from] = descrição.
 * Original: nf/q.java
 */
class PlayerRestartEvent(val session: Long, val code: Int, val cnt: Int, val from: String)

/** Início de buffering (classe vazia). Original: nf/p.java */
class BufferingStartEvent

/** Fim de buffering (classe vazia). Original: nf/o.java */
class BufferingEndEvent

/** Player voltou a reproduzir depois de travar (classe vazia, enviado logo após [BufferingEndEvent]). Original: nf/w.java */
class PlayerResumedEvent

/** Mídia gratuita inválida (código 1000 do motor): nome do vídeo, tipo e sessão. Original: nf/x.java */
class NoFreeMediaEvent(val videoName: String?, val playType: PlayType, val session: Long?)

/** Modo eco ligado/desligado (consumido por PlayerMonitor). Original: nf/f.java */
class EcoModeEvent
