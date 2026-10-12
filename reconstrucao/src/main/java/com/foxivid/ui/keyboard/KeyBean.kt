package com.foxivid.ui.keyboard

/**
 * Modelo de uma tecla do teclado virtual: código, rótulo exibido, texto inserido, ícone, peso de
 * largura (weight do LinearLayout) e flag (true para "1", "t" e "@": teclas com o rótulo-guia).
 *
 * Códigos usados em [KeyUtils]: 0-9 dígitos, 16-53 letras a-z, 64-104 símbolos, 112 espaço,
 * 144 fechar, 145 "@", 146 "ABC", 147 apagar, 148 próximo/concluir, 149 "123?", 150 "Aa",
 * 151 mostrar/ocultar números, 152 enter, 153 símbolos, 256 voltar, 294-295 teclas invisíveis.
 *
 * Original: ziyi/kit/keyboard/a.java (campos a=code, b=label, c=input, d=iconRes, e=weight, f=flag)
 */
class KeyBean(
    /** Original: a.c() */
    val code: Int,
    /** Rótulo exibido. Original: a.d() / i() */
    var label: CharSequence,
    /** Texto inserido no EditText ao pressionar. Original: a.e() / j() */
    var input: CharSequence,
    /** Recurso de ícone (-1 = sem ícone). Original: a.a() / g() */
    var iconRes: Int = -1,
    /** Peso (largura relativa) da tecla na linha. Original: a.b() / h() */
    var weight: Float = 1.0f,
    /** Original: a.f() */
    val flag: Boolean = false
) {
    constructor(code: Int, label: CharSequence) : this(code, label, label, -1)
    constructor(code: Int, label: CharSequence, input: CharSequence) : this(code, label, input, -1)
    constructor(code: Int, label: CharSequence, flag: Boolean) : this(code, label, label, -1, 1.0f, flag)
}
