package com.foxivid.baselib.util

/**
 * Utilitários de stack trace: nome do chamador (usado nas mensagens ao bot/log) e formatação de exceções.
 * Original: x1/f1/lb/util/q.java
 */
object StackTraceUtils {
    /** Anexa cada frame como "Classe.metodo(Arquivo:linha)\n". Original: a(StackTraceElement[], StringBuilder) */
    fun appendFrames(elements: Array<StackTraceElement>, builder: StringBuilder) {
        for (e in elements) {
            builder.append(e.className).append(".").append(e.methodName).append("(").append(e.fileName).append(":").append(e.lineNumber).append(")\n")
        }
    }

    /**
     * Frame [idx] da pilha atual como "Classe.metodo()@linha:arquivo"; "" se a pilha é curta demais. O padrão em `c(...)` é idx = 2.
     * Original: b(int)
     */
    fun callerName(idx: Int = 2): String {
        val stack = Exception().stackTrace
        if (stack.size <= idx + 1) return ""
        val e = stack[idx]
        return e.className + "." + e.methodName + "()@" + e.lineNumber + ":" + e.fileName
    }

    /** "ClasseCanônica:mensagem\n" seguido dos frames. Original: d(Throwable) */
    fun format(t: Throwable): String {
        val sb = StringBuilder()
        sb.append(t.javaClass.canonicalName).append(":").append(t.message).append("\n")
        appendFrames(t.stackTrace, sb)
        return sb.toString()
    }
}
