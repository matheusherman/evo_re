package com.foxivid.ui.mobile.ext

/**
 * Mensagem genérica de EventBus (código, mensagem, payload).
 * Original: u7/MessageEventData.java
 */
data class MessageEventData(val code: Int, val msg: String?, val data: Any?)
