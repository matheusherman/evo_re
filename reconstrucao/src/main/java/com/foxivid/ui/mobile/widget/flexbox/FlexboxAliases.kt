package com.foxivid.ui.mobile.widget.flexbox

/*
 * Cópia reempacotada (sem alterações visíveis de API) da biblioteca Google FlexboxLayout
 * (com.google.android.flexbox). Conforme CONVENCOES.md, bibliotecas de terceiros usam a API real e
 * não são reconstruídas: aqui ficam apenas aliases com o mapeamento original -> biblioteca.
 *
 *   com/tvc/lib/mobile/ui/widget/flexbox/FlexboxLayout.java            -> com.google.android.flexbox.FlexboxLayout
 *   .../flexbox/FlexboxLayoutManager.java                              -> com.google.android.flexbox.FlexboxLayoutManager
 *   .../flexbox/FlexboxLayoutManagerWrap.java                          -> variante local de FlexboxLayoutManager (2387 vs 2462 linhas; ver nota ao final)
 *   .../flexbox/FlexItem.java (interface Parcelable)                   -> com.google.android.flexbox.FlexItem
 *   .../flexbox/a.java  (interface do container, implementada por FlexboxLayout) -> com.google.android.flexbox.FlexContainer
 *   .../flexbox/b.java  (helper estático)                              -> com.google.android.flexbox.FlexboxHelper (parte)
 *   .../flexbox/c.java  (1315 linhas; classe interna b = Order, a = FlexLinesResult) -> com.google.android.flexbox.FlexboxHelper
 *   .../flexbox/d.java, e.java, f.java (classes sintéticas vazias, R8)  -> sem equivalente
 */
typealias FlexboxLayout = com.google.android.flexbox.FlexboxLayout
typealias FlexboxLayoutManager = com.google.android.flexbox.FlexboxLayoutManager
typealias FlexItem = com.google.android.flexbox.FlexItem
typealias FlexContainer = com.google.android.flexbox.FlexContainer

/*
 * FlexboxLayoutManagerWrap: variante da FlexboxLayoutManager da biblioteca (2387 linhas contra 2462 da original; código de
 * biblioteca de terceiros). INFERIDO: sem diferença de API observável, então usa-se a classe da biblioteca como alias.
 * NÃO RECUPERÁVEL linha a linha: a variante local com as linhas removidas não foi comparada (ver docs/pendencias_finais.md).
 */
typealias FlexboxLayoutManagerWrap = com.google.android.flexbox.FlexboxLayoutManager
