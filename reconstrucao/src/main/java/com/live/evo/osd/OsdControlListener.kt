package com.live.evo.osd

/**
 * Callbacks genéricos de controle de OSD (usados por diálogos de recarga etc.).
 * Original: com/live/evo/osd/p.java
 */
interface OsdControlListener {
    /** Original: a() */ fun onPositive()
    /** Original: b() */ fun onNegative()
    /** Original: e() */ fun onDismiss()
}

/**
 * Extensão de [OsdControlListener] com um callback extra. Original: com/live/evo/osd/a.java
 */
interface OsdControlListenerEx : OsdControlListener {
    /** Original: c() */ fun onExtra()
}

/** Original: com/live/evo/osd/q.java */
interface OnStringListener { fun onValue(value: String) }

/** Notifica atualização de assinatura (usado por [SubscribeManager.subscribe]). Original: com/live/evo/osd/v.java */
interface OnUpdateListener { fun onUpdate() }

/**
 * Listener de itens de EPG (OSD de programação).
 * Original: com/live/evo/osd/e.java
 */
interface EpgItemListener {
    /** Original: a(String, String, String) */ fun onCatchUp(type: String, a: String, b: String)
    /** Original: b(i5.p) */ fun isCatchUpAvailable(program: com.live.evo.model.ProgramBean): Boolean
    /** Original: c(i5.p) */ fun onProgramSelected(program: com.live.evo.model.ProgramBean)
    /** Original: d(boolean) */ fun onFocusChanged(focused: Boolean)
}
