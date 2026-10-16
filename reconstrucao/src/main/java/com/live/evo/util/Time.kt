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
    fun now(): Long = com.foxivid.baselib.util.ServerTime.now()   // d1.d() = System.currentTimeMillis() + diferença com o servidor
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

    /** Arredonda para 00:00 do dia de [millis] (formato `ddMMyyyy`). Original: g(long) / i(long) */
    fun startOfDay(millis: Long): Long = try {
        val f = DateFormatFactory.create(CommonUtils.string(R.string.ddMMyyyy)); f.parse(f.format(Date(millis)))!!.time
    } catch (e: Exception) { e.printStackTrace(); 0L }

    /** Meia-noite de hoje (hora do servidor). Original: h() */ fun today(): Long = startOfDay(now())

    /** Horas (arredondadas para cima) entre dois instantes; 0 se [b] <= [a]. Original: j(long,long) */
    fun hoursBetween(a: Long, b: Long): Int {
        val diff = b - a
        if (diff <= 0) return 0
        return Math.ceil((diff * 1.0) / TimeUnit.HOURS.toMillis(1L)).toInt()
    }

    /** Hoje no formato `yyyymmdd` (string R.string.yyyymmdd). Original: k() */
    fun todayString(): String = try {
        DateFormatFactory.create(CommonUtils.string(R.string.yyyymmdd)).format(Date(today()))
    } catch (e: Exception) { e.printStackTrace(); "" }

    /** "yyyymmdd" -> "<mês por extenso> <dia>" (R.array.month); "" se vazio/inválido. Original: a(String) */
    fun monthAndDay(yyyymmdd: String?): String {
        if (yyyymmdd.isNullOrEmpty()) return ""
        val app = MyApplication.get()
        return try {
            val date = DateFormatFactory.create(CommonUtils.string(R.string.yyyymmdd)).parse(yyyymmdd)
            val cal = Calendar.getInstance(); cal.time = date!!
            app.resources.getTextArray(R.array.month)[cal.get(Calendar.MONTH)].toString() + " " + cal.get(Calendar.DAY_OF_MONTH).toString()
        } catch (e: java.text.ParseException) { e.printStackTrace(); "" }
    }

    /** Calendar à 00:00:00 de [millis] + [days] dias (fuso do aparelho); chama [weekdayName] sem usar o resultado. Original: c(long,int) */
    fun calendarPlusDays(millis: Long, days: Int): Calendar {
        val cal = Calendar.getInstance()
        cal.timeInMillis = millis
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH) + days, 0, 0, 0)
        weekdayName(cal.get(Calendar.DAY_OF_WEEK))
        return cal
    }

    /** Millis de 00:00:00 de [millis] + [days] dias (fuso do aparelho). Original: d(long,int) */
    fun startOfDayPlusDays(millis: Long, days: Int): Long = calendarPlusDays0(millis, days).timeInMillis
    private fun calendarPlusDays0(millis: Long, days: Int): Calendar {
        val cal = Calendar.getInstance()
        cal.timeInMillis = millis
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH) + days, 0, 0, 0)
        return cal
    }

    /** Como [calendarPlusDays], mas no fuso de [TimeZoneHelper.timeZone] e sem consultar o nome do dia. Original: e(long,int) */
    fun calendarPlusDaysInServerZone(millis: Long, days: Int): Calendar {
        val cal = Calendar.getInstance()
        cal.timeZone = TimeZoneHelper.get().timeZone()
        cal.timeInMillis = millis
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH) + days, 0, 0, 0)
        return cal
    }

    /** Millis de [millis] + [days] dias mantendo a hora (campos de hora não zerados). Original: f(long,int) */
    fun plusDays(millis: Long, days: Int): Long {
        val cal = Calendar.getInstance()
        cal.timeInMillis = millis
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH) + days)
        return cal.timeInMillis
    }

    /** Abreviação do dia da semana de [millis] (sun..sat, R.string.*). Original: l(long) */
    fun weekdayName(millis: Long): String {
        val cal = Calendar.getInstance(); cal.time = Date(millis)
        var i = cal.get(Calendar.DAY_OF_WEEK) - 1
        if (i < 0) i = 0
        return weekdayNames()[i]
    }

    /** Abreviação do dia da semana para [dayOfWeek] (Calendar: 1 = domingo). Original: o(int) */
    fun weekdayName(dayOfWeek: Int): String {
        var i = dayOfWeek - 1
        if (i < 0) i = 0
        return weekdayNames()[i]
    }

    private fun weekdayNames() = arrayOf(
        CommonUtils.string(R.string.sun), CommonUtils.string(R.string.mon), CommonUtils.string(R.string.tue), CommonUtils.string(R.string.wed),
        CommonUtils.string(R.string.the), CommonUtils.string(R.string.fri), CommonUtils.string(R.string.sat),
    )
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
    fun promptIfNeeded(activity: android.app.Activity, onDone: Runnable) {
        val done = booleanArrayOf(false)       // garante que [onDone] rode uma única vez
        fun finish() { if (!done[0]) { onDone.run(); done[0] = true } }
        try {
            val builder = android.app.AlertDialog.Builder(activity)
            val entry = entryFor(java.util.TimeZone.getDefault().id)
            builder.setMessage(entry?.message)
            // No original o botão "cancel" é o POSITIVE e "ok" é o NEGATIVE.
            builder.setPositiveButton(R.string.cancel) { _, _ -> finish(); activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out) }
            builder.setNegativeButton(R.string.ok) { _, _ ->
                try {
                    try {
                        (activity.getSystemService(Context.ALARM_SERVICE) as android.app.AlarmManager).setTimeZone(entry?.targetSystemId)
                        finish()
                    } catch (_: Throwable) {
                        adjustEnabled = false
                        com.foxivid.baselib.util.Preferences.putString("has_stz_p", "false")
                        finish()
                    }
                    activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                } catch (t: Throwable) { finish(); throw t }
            }
            builder.setOnDismissListener { finish() }
            builder.show()
        } catch (_: Throwable) {
            finish()
        }
    }

    // Tabela de fusos: no original o construtor recebe o JSON da tabela, mas a instância única usa "" (lista vazia).
    private val entries = ArrayList<Entry>()
    private var adjustEnabled = true       // propriedade remota `has_stz_p` (padrão "true")

    init {
        com.foxivid.baselib.util.Preferences.getString("has_stz_p", { adjustEnabled = java.lang.Boolean.getBoolean(it) }, "true")
    }

    private fun entryFor(id: String): Entry? =
        try { entries.firstOrNull { it.originId == id } } catch (_: Throwable) { null }

    /** Entrada válida: origem e destino preenchidos e, se `set_sys`, com `t_sys_id`. Original: f(l.f) */
    private fun isValid(e: Entry): Boolean {
        if (e.originId.isNullOrEmpty() || e.targetId.isNullOrEmpty()) return false
        return !(e.setSystem && e.targetSystemId.isNullOrEmpty())
    }

    /**
     * (precisa ajustar o fuso do sistema?, precisa perguntar ao usuário?) para o fuso atual do aparelho.
     * Original: g()
     */
    fun needsAdjust(): Pair<Boolean, Boolean> {
        return try {
            if (!adjustEnabled) return Pair(false, false)
            val e = entryFor(java.util.TimeZone.getDefault().id) ?: return Pair(false, false)
            val adjust = e.setSystem && !e.targetSystemId!!.startsWith("GMT")
            Pair(adjust, adjust && e.prompt)
        } catch (_: Throwable) { Pair(false, false) }
    }

    /** Fuso da EPG: o mapeado em `t_id` para o fuso atual, ou o padrão do aparelho. Original: c() */
    fun timeZone(): java.util.TimeZone {
        val tz = java.util.TimeZone.getDefault()
        return try {
            val e = entryFor(tz.id) ?: return tz
            java.util.TimeZone.getTimeZone(e.targetId)
        } catch (_: Throwable) { tz }
    }

    /** Aplica o fuso do sistema (`t_sys_id`) sem perguntar. Original: i(Context) */
    fun applySystemTimeZone(context: Context) {
        try { (context.getSystemService(Context.ALARM_SERVICE) as android.app.AlarmManager).setTimeZone(entryFor(java.util.TimeZone.getDefault().id)!!.targetSystemId) } catch (_: Throwable) {}
    }
    companion object {
        private var instance: TimeZoneHelper? = null
        /** Original: d() */ fun get(): TimeZoneHelper = instance ?: TimeZoneHelper().also { instance = it }
    }
}
