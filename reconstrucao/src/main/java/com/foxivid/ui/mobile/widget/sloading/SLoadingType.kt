package com.foxivid.ui.mobile.widget.sloading

/**
 * Tipos de animação de loading; cada valor instancia (por reflexão) um [SLoadingBuilder].
 * A ordem do enum é o índice usado no atributo `s_type` de [SLoadingView].
 * Classes dos builders no original: CIRCLE=x7/b, CIRCLE_CLOCK=x7/c, STAR_LOADING=p, LEAF_ROTATE=i,
 * DOUBLE_CIRCLE=d, PAC_MAN=j, ELASTIC_BALL=e, INFECTION_BALL=g, INTERTWINE=h, TEXT=q, SEARCH_PATH=m,
 * ROTATE_CIRCLE=k, SINGLE_CIRCLE=n, SNAKE_CIRCLE=o, TRANSLATE_CIRCLE=r, FADING_CIRCLE=f,
 * ROTATE_SAMECIRCLE=l (reconstruídas em SLoadingBuilders.kt, com nomes derivados do valor do enum).
 *
 * Original: com/tvc/lib/mobile/ui/widget/sloading/c.java
 */
enum class SLoadingType(private val builderClass: Class<*>?) {
    CIRCLE(CircleLoadingBuilder::class.java),
    CIRCLE_CLOCK(CircleClockLoadingBuilder::class.java),
    STAR_LOADING(StarLoadingBuilder::class.java),
    LEAF_ROTATE(LeafRotateLoadingBuilder::class.java),
    DOUBLE_CIRCLE(DoubleCircleLoadingBuilder::class.java),
    PAC_MAN(PacManLoadingBuilder::class.java),
    ELASTIC_BALL(ElasticBallLoadingBuilder::class.java),
    INFECTION_BALL(InfectionBallLoadingBuilder::class.java),
    INTERTWINE(IntertwineLoadingBuilder::class.java),
    TEXT(TextLoadingBuilder::class.java),
    SEARCH_PATH(SearchPathLoadingBuilder::class.java),
    ROTATE_CIRCLE(RotateCircleLoadingBuilder::class.java),
    SINGLE_CIRCLE(SingleCircleLoadingBuilder::class.java),
    SNAKE_CIRCLE(SnakeCircleLoadingBuilder::class.java),
    TRANSLATE_CIRCLE(TranslateCircleLoadingBuilder::class.java),
    FADING_CIRCLE(FadingCircleLoadingBuilder::class.java),
    ROTATE_SAMECIRCLE(RotateSameCircleLoadingBuilder::class.java);


    /** Original: c.f() */
    fun createBuilder(): SLoadingBuilder? = try {
        builderClass?.getDeclaredConstructor()?.newInstance() as SLoadingBuilder?
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}
