package com.live.evo.util

import java.util.regex.Pattern

/**
 * Validação de e-mail/telefone usada nas telas de login/cadastro/recarga.
 * Reúne `o5/a.java` (singleton com a regra `^\+\d{5,20}$`, país padrão "+55"/"BR") e os métodos estáticos `a`/`b` de `o5/c.java`.
 * Nota: `o5/c.f16460d` guarda uma tabela de regex por país (não usada nas rotas reconstruídas).
 *
 * Original: o5/a.java, o5/c.java
 */
object AccountValidators {
    private const val DEFAULT_PHONE_REGEX = "^\\+\\d{5,20}$"

    /** Original: o5.c.a(String) / o5.a.f(String) */
    fun isEmail(s: String): Boolean = s.contains("@") && s.contains(".") && !s.startsWith("@") && !s.endsWith("@")

    /** Original: o5.c.b(String) — começa com "+" e só dígitos depois. */
    fun isPhoneWithPlus(s: String): Boolean {
        if (s.isEmpty()) return false
        val t = s.trim()
        if (t.indexOf("+") != 0) return false
        return t.substring(1).all { it.isDigit() } && t.length > 1
    }

    /** Países disponíveis (apenas "+55"/BR por padrão), ordenados por `order` decrescente. Original: o5.a.e()/b() */
    val countries: List<com.live.evo.model.PhoneCountry> by lazy {
        mutableListOf(com.live.evo.model.PhoneCountry("+55", "BR", "BR", 1, "")).apply { sortByDescending { it.order }; forEach { if (it.regex.isEmpty()) it.regex = DEFAULT_PHONE_REGEX } }
    }

    /**
     * Valida telefone: remove espaços e compara com a regex padrão; se [preCode] casa (ignorando caixa) com o DDI de um país,
     * a "regex" passa a ser o próprio DDI (comportamento literal do original, que usa `c()` em vez de `d()`).
     * Original: o5.a.h(String, String)
     */
    fun isPhone(s: String?, preCode: String?): Boolean {
        if (s.isNullOrEmpty()) return false
        var regex = DEFAULT_PHONE_REGEX
        if (!preCode.isNullOrEmpty()) for (c in countries) if (c.preCode.equals(preCode, ignoreCase = true)) regex = c.preCode
        return try { Pattern.matches(regex, s.replace(" ", "")) } catch (e: java.util.regex.PatternSyntaxException) { false }
    }

    /** Original: o5.a.a(String) — 0 = e-mail, 1 = telefone, -1 = inválido. */
    fun accountType(s: String): Int = if (isEmail(s)) 0 else if (isPhone(s, "")) 1 else -1

    /** Original: o5.a.d(String) — trim e remove "-" e espaços. */
    fun normalizePhone(s: String?): String = (s ?: "").trim().replace("-", "").replace(" ", "")
}
