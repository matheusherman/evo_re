package com.live.evo.fragment

import com.live.evo.AppUserManager
import com.live.evo.util.WorkHandler

/**
 * "Central de mensagens" (stub do build): todos os métodos retornam nulo/vazio. `e()` apenas chama `f(0)`, que não faz nada.
 * Usado pelas abas de recarga/conta para "atualizar mensagens" depois de login/recarga.
 * Original: com/live/evo/fragment/v0.java
 */
class MessageCenter private constructor() {
    /** Original: a(int) — sempre null */ fun detailAt(index: Int): Any? = null
    /** Original: c() — sempre null */ fun current(): Any? = null
    /** Original: d() — sempre null */ fun items(): List<Any>? = null
    /** Atualiza as mensagens (chama [refresh] com 0). Original: e() */ fun refresh() = refresh(0L)
    /** Original: f(long) — corpo vazio */ fun refresh(delayMs: Long) {}

    companion object {
        private var instance: MessageCenter? = null
        /** Original: b() */ fun get(): MessageCenter = instance ?: MessageCenter().also { instance = it }
    }
}

/**
 * Agendador do pedido de banners/BFF ("back for frontend") das abas de conta: `d()` cancela e reagenda `requestBff` a cada
 * `bff_request_time` ms (mínimo 5 s quando o valor configurado é menor que 60 s — `CoroutineLiveDataKt.DEFAULT_TIMEOUT`).
 * O pedido em si (`b(a5.a)`) tem corpo vazio no build.
 * Original: com/live/evo/fragment/a.java
 */
class BffRequestScheduler private constructor() {
    private val requestRunnable = Runnable { request(null) }
    /** Original: b(a5.a) — corpo vazio */ fun request(callback: Any?) {}
    /** Original: c() — lista de banners (campo f5832b), sempre null neste build */ fun banners(): List<Any>? = null

    /** Reagenda o pedido periódico. Original: d() */
    fun reschedule() {
        WorkHandler.get().remove(requestRunnable)
        var delay = AppUserManager.get().getLong("bff_request_time", 60000L)
        if (delay < 60_000L) delay = 5000L
        WorkHandler.get().postDelayed(requestRunnable, delay)
    }

    companion object {
        private var instance: BffRequestScheduler? = null
        /** Original: a() */ fun get(): BffRequestScheduler = instance ?: BffRequestScheduler().also { instance = it }
    }
}
