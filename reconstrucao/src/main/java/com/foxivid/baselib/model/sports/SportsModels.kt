package com.foxivid.baselib.model.sports

import androidx.annotation.Keep

/*
 * Agenda esportiva (SportsApi). No original são data classes Kotlin com campos @Keep e
 * todos os valores anuláveis. Pacote original: z1/b1/lb/m/sports.
 */

/** Original: Sports.java. Getter ofuscado c() = sports. */
data class Sports(
    @Keep val defaultSportId: Int?,
    @Keep val defaultTournamentId: Int?,
    @Keep val todayDate: String?,
    @Keep val sports: List<Sport>?,
    @Keep val version: Int?,
)

/** Original: Sport.java. Getter ofuscado f() = tournaments. */
data class Sport(
    @Keep val sportId: Int?,
    @Keep val slug: String?,
    @Keep val name: String?,
    @Keep val iconUrl: String?,
    @Keep val tournaments: List<Tournament>?,
    @Keep val default: Boolean?,
)

/** Original: Tournament.java. Getter ofuscado b() = matchList. */
data class Tournament(
    @Keep val tournamentId: Int?,
    @Keep val name: String?,
    @Keep val seasonCode: String?,
    @Keep val matchList: List<Match>?,
    @Keep val default: Boolean?,
)

/** Original: Tournaments.java. Getter ofuscado a() = tournaments. */
data class Tournaments(
    @Keep val sportId: Int?,
    @Keep val tournaments: List<Tournament>?,
)

/** Original: Matches.java. Getter ofuscado b() = matches. */
data class Matches(
    @Keep val tournamentId: Int?,
    @Keep val date: String?,
    @Keep val matches: List<Match>?,
)

/** Original: Match.java. Getter ofuscado c() = channels. */
data class Match(
    @Keep val matchId: Int?,
    @Keep val tournamentId: Int?,
    @Keep val status: String?,
    @Keep val title: String?,
    @Keep val subtitle: String?,
    @Keep val description: String?,
    @Keep val venue: String?,
    @Keep val city: String?,
    @Keep val countryCode: String?,
    @Keep val homeTeam: Team?,
    @Keep val awayTeam: Team?,
    @Keep val channels: List<Channel>?,
    @Keep val startAt: Long?,
    @Keep val endAt: Long?,
    @Keep val homeScore: Int?,
    @Keep val awayScore: Int?,
)

/** Original: Team.java. */
data class Team(
    @Keep val teamId: Int?,
    @Keep val name: String?,
    @Keep val logoUrl: String?,
    @Keep val countryCode: String?,
)

/** Canal que transmite a partida (liga com o EPG via epgId). Original: Channel.java. */
data class Channel(
    @Keep val channelId: String?,
    @Keep val name: String?,
    @Keep val channelType: String?,
    @Keep val platform: String?,
    @Keep val geoScope: String?,
    @Keep val priority: Int?,
    @Keep val effectiveStart: String?,
    @Keep val effectiveEnd: String?,
    @Keep val epgId: String?,
    @Keep val epgProgram: Program?,
)

/** Original: Program.java. */
data class Program(
    @Keep val programId: String?,
    @Keep val title: String?,
    @Keep val description: String?,
    @Keep val epgId: String?,
    @Keep val startAt: String?,
    @Keep val endAt: String?,
)

/** Original: DataVersion.java. */
data class DataVersion(
    @Keep val changed: Boolean?,
    @Keep val version: Int?,
    @Keep val updatedAtEpochMs: Long?,
)
