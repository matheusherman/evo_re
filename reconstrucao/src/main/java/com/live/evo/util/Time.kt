package com.live.evo.util

import android.content.Context
import com.live.evo.MyApplication
import com.live.evo.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

/**
 * Relógio do servidor: `now()` = `d1.d()` do SDK (tempo corrigido pelo servidor).
 * Original: com/live/evo/util/u1.java (ServerClock)
 */
class ServerClock private constructor() {
    /** Original: a() → x1.f1.lb.util.d1.d() */
    fun now(): Long = TODO("nativo/ofuscado: x1.f1.lb.util.d1.d() — relógio do SDK baselib (com.foxivid.baselib.util)")
    companion object { private val instance = ServerClock(); /** Original: b() */ fun get() = instance }
}

/** Cria SimpleDateFormat (padrão "dd/MM"-like) do pattern. Original: com/live/evo/util/o1.java */
object DateFormatFactory { fun create(pattern: String): SimpleDateFormat = SimpleDateFormat(pattern) }

/** mm:ss ou hh:mm:ss a partir de milissegundos. Original: com/live/evo/util/c1.java */
object DurationFormatter {
    fun format(ms: Long): String {
        val s = (ms / 1000).toInt().toLong()
        val sec = s % 60; val min = (s / 60) % 60; val h = s / 3600
        return if (h > 0) String.format(Locale.ENGLISH, "%02d:%02d:%02d", h, min, sec)
        else String.format(Locale.ENGLISH, "%02d:%02d", min, sec)
    }
}

/**
 * Funções de data usadas na EPG e OSD.
 * Original: com/live/evo/util/q1.java (nome sugerido DateUtils)
 */
object DateUtils {
    /** Hora atual do servidor. Original: b() */
    fun now(): Long = ServerClock.get().now()

    /** Formata [millis] com [pattern]. Original: m(long, String) */
    fun format(millis: Long, pattern: String): String = DateFormatFactory.create(pattern).format(Date(millis))

    /** Parse "ddMMyyyy" -> millis (0 se falhar). Original: n(String) */
    fun dayStart(ddMMyyyy: String): Long = try { DateFormatFactory.create(CommonUtils.string(R.string.ddMMyyyy)).parse(ddMMyyyy)!!.time } catch (e: Exception) { 0L }

    /** Arredonda para 00:00 do dia de [millis]. Original: g(long)/i(long) */
    fun startOfDay(millis: Long): Long = try {
        val f = DateFormatFactory.create(CommonUtils.string(R.string.yyyymmdd)); f.parse(f.format(Date(millis)))!!.time
    } catch (e: Exception) { 0L }

    /** Reinicia o cache de formatadores (inferido; no original `o1` cria novo SimpleDateFormat a cada chamada). */
    fun resetCache() {}

    /** Meia-noite de hoje. Original: h() */ fun today(): Long = startOfDay(now())

    /** Horas (arredondadas para cima) entre dois instantes. Original: j(long,long) */
    fun hoursBetween(a: Long, b: Long): Int = Math.ceil(((b - a) * 1.0) / TimeUnit.HOURS.toMillis(1L)).toInt()
    // Demais (a,c,d,e,f,k,l,o) — mês+ano por extenso, Calendar ± dias, nomes de dia da semana a partir de R.array.*:
    // TODO("parcial: q1.c/d/e/f somam [i10] dias a um Calendar; q1.l/o retornam nome do dia da semana")
}

/**
 * Ajuste de fuso horário (menu "set_sys"): lê configuração remota ("has_stz_p", "t_sys_id", "set_sys_prompt")
 * e pergunta ao usuário se deseja ajustar o fuso do sistema (diálogo ok/cancel).
 * Original: com/live/evo/util/l.java (nome sugerido TimeZoneHelper)
 */
class TimeZoneHelper private constructor() {
    /** Entrada de fuso do servidor (@SerializedName o_id, t_id, set_sys, t_sys_id, set_sys_prompt, message). Original: l.f */
    data class Entry(
        @com.google.gson.annotations.SerializedName("o_id") val originId: String? = null,
        @com.google.gson.annotations.SerializedName("t_id") val targetId: String? = null,
        @com.google.gson.annotations.SerializedName("set_sys") val setSystem: Boolean = false,
        @com.google.gson.annotations.SerializedName("t_sys_id") val targetSystemId: String? = null,
        @com.google.gson.annotations.SerializedName("set_sys_prompt") val prompt: Boolean = false,
        @com.google.gson.annotations.SerializedName("message") val message: String? = null,
    )
    /** Original: h(Activity, Runnable) */
    fun promptIfNeeded(activity: android.app.Activity, onDone: Runnable): Unit =
        TODO("não detalhado: lógica completa de comparação de fuso (l.g()/l.f()) — ver util/l.java")
    /** Original: c() */ fun timeZone(): java.util.TimeZone = TODO("ver util/l.c()")
    companion object {
        private var instance: TimeZoneHelper? = null
        /** Original: d() */ fun get(): TimeZoneHelper = instance ?: TimeZoneHelper().also { instance = it }
    }
}
