package com.live.evo.event

/**
 * Eventos publicados no EventBus (greenrobot) e no [com.live.evo.util.RxBus]. Pacote original: `b5`.
 * Nomes legíveis inferidos pelos assinantes `@Subscribe` de LiveNewActivity (onXxxEvent).
 */
// ATENÇÃO: b5/a,d,e,g,j,l,m são classes VAZIAS no original; a atribuição de nomes abaixo (exceto b, c, h, i, k, que têm campos)
// é inferida do método assinante em LiveNewActivity (onForceLogoutEvent(b5.e), onClearHistory(b5.d), onTokenChange(b5.l)).

/** Troca de canal/menu. Campos: tag de menu e ids (4 strings; construtor de 1 String = só canal). Original: b5/b.java */
class ChangeChannelEvent(val menuTag: String = "", val a: String = "", val b: String = "", val channelId: String = "") {
    constructor(channelId: String) : this("", "", "", channelId)
}

/** Canais atualizados (carrega novo tipo `a()`). Original: b5/c.java */
class ChannelUpdateEvent(val type: Int) { fun type() = type }

/** Limpar histórico. Original: b5/d.java */ class ClearHistoryEvent
/** Logout forçado pelo servidor. Original: b5/e.java */ class ForceLogoutEvent
/** Original: b5/f.java (data class vazia, MessageEvent) */ class MessageEvent
/** Original: b5/g.java */ class NoticeEvent
/** Posição de reprodução salva. Campos: categoria, canal, posição global. Original: b5/h.java */
class SavePlayHistoryEvent(@JvmField val category: Int, @JvmField val channel: Int, @JvmField val allPosition: Int)
/** Serviço expirado. Original: b5/i.java (campo f915a = 0) */ class ServiceExpiredEvent { @JvmField var code: Int = 0 }
/** Original: b5/j.java */ class WindowFocusRegainedEvent
/** Lembrete de assinatura de programa. Original: b5/k.java */
class SubscribeRemindEvent(@JvmField val bean: SubscribeBeanRef)
/** Troca de token (`onTokenChange`). Original: b5/l.java */ class TokenChangeEvent
/** Original: b5/m.java */ class ReopenFragmentEvent

/** Marcador do tipo i5.c0 (SubscribeBean) para evitar dependência circular. */
typealias SubscribeBeanRef = com.live.evo.model.SubscribeBean
