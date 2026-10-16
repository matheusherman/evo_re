package com.live.evo.model

/**
 * Modelos do "Subject" (esportes/partidas) devolvidos pela API de esportes. Os nomes originais são os do pacote `j5` do APK.
 * Getters/Setters obfuscados (a(), b()...) viram propriedades.
 */

/** Time/equipe de uma partida: nome e URL do ícone. Original: j5/d.java */
class SubjectTeam {
    var name: String? = null      // f11628a (a()/c())
    var icon: String? = null      // f11629b (b()/d())
}

/**
 * Partida. Original: j5/c.java
 * Em [MatchAdapter]: `channelId` identifica o canal que transmite; `epgId` + `startTime` consultam catch-up/agenda.
 */
class SubjectMatch {
    var type: Int = 0                 // f11616a (m(int))
    var startTime: Long = 0           // f11617b — g()/s()
    var endTime: Long = 0             // f11618c — h()/t()
    var epgId: String? = null         // f11619d — c()/l()
    var title: String? = null         // f11620e — f()/q()
    var matchId: String? = null       // f11621f — b()/k()
    var channelId: String? = null     // f11622g — a()/j()
    var f11623h: String? = null       // p(String) (sem getter)
    var f11624i: String? = null       // r(String) (sem getter)
    var homeScore: String? = null     // f11625j — e()/o()
    var awayScore: String? = null     // f11626k — d()/n()
    var teams: List<SubjectTeam>? = null  // f11627l — i()/u()
}

/** Classificação/liga com suas partidas. Original: j5/b.java */
class SubjectClassification {
    var id: String? = null            // f11612a — b()/f()
    var name: String? = null          // f11613b — a()/e()
    var icon: String? = null          // f11614c — c()/g()
    var matches: List<SubjectMatch>? = null   // f11615d — d()/h()
}

/** Tipo de subject (id + nome). Original: j5/g.java */
class SubjectType {
    var id: String? = null            // f11633a — a()/c()
    var name: String? = null          // f11634b — b()/d()
}

/** Dia com as classificações e o tipo. Original: j5/e.java */
class SubjectDay {
    var classifications: List<SubjectClassification>? = null  // f11630a
    var type: SubjectType? = null                              // f11631b
}

/** Resposta base de API (código/mensagem); usada por [SubjectMatchResponse] e [SubjectTypeResponse]. Original: i5/g.java */
open class ApiBaseResponse

/** Lista de tipos de subject. Original: j5/h.java */
class SubjectTypeResponse : ApiBaseResponse() {
    var types: List<SubjectType>? = null     // f11635k — k()/l()
}

/** Partidas por dia com datas disponíveis. Original: j5/a.java */
class SubjectMatchResponse : ApiBaseResponse() {
    var days: List<SubjectDay>? = null       // f11609k — l()/o()
    var dates: List<String>? = null          // f11610l — k()/m()
    var timestamp: Long = 0                  // f11611m — n()
}

/** Envelope da resposta de partidas. Original: j5/f.java */
class SubjectMatchEnvelope : ApiBaseResponse() {
    var data: SubjectMatchResponse? = null   // f11632k — k()/l()
}
