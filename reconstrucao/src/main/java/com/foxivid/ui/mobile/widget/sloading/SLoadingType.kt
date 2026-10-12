package com.foxivid.ui.mobile.widget.sloading

/**
 * Tipos de animação de loading; cada valor instancia (por reflexão) um [SLoadingBuilder].
 * A ordem do enum é o índice usado no atributo `s_type` de [SLoadingView].
 * Classes dos builders no original: CIRCLE=x7/b, CIRCLE_CLOCK=x7/c, STAR_LOADING=p, LEAF_ROTATE=i,
 * DOUBLE_CIRCLE=d, PAC_MAN=j, ELASTIC_BALL=e, INFECTION_BALL=g, INTERTWINE=h, TEXT=q, SEARCH_PATH=m,
 * ROTATE_CIRCLE=k, SINGLE_CIRCLE=n, SNAKE_CIRCLE=o, TRANSLATE_CIRCLE=r, FADING_CIRCLE=f,
 * ROTATE_SAMECIRCLE=l (todas no pacote do módulo; não reconstruídas aqui).
 *
 * Original: com/tvc/lib/mobile/ui/widget/sloading/c.java
 */
enum class SLoadingType(private val builderClass: Class<*>?) {
    CIRCLE(null),
    CIRCLE_CLOCK(null),
    STAR_LOADING(null),
    LEAF_ROTATE(null),
    DOUBLE_CIRCLE(null),
    PAC_MAN(null),
    ELASTIC_BALL(null),
    INFECTION_BALL(null),
    INTERTWINE(null),
    TEXT(null),
    SEARCH_PATH(null),
    ROTATE_CIRCLE(null),
    SINGLE_CIRCLE(null),
    SNAKE_CIRCLE(null),
    TRANSLATE_CIRCLE(null),
    FADING_CIRCLE(null),
    ROTATE_SAMECIRCLE(null);

    // TODO("builderClass: Class literal de cada builder (x7/b, x7/c, p, i, d, j, e, g, h, q, m, k, n, o, r, f, l) — classes fora deste módulo")

    /** Original: c.f() */
    fun createBuilder(): SLoadingBuilder? = try {
        builderClass?.getDeclaredConstructor()?.newInstance() as SLoadingBuilder?
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}
