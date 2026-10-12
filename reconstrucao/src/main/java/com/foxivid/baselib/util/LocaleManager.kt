package com.foxivid.baselib.util

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.LocaleList
import android.text.TextUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.Locale

/**
 * Idioma do app: lista de idiomas (`R.array.language_array`) ↔ locales (`R.array.locale_array`),
 * índice escolhido salvo em SharedPreferences `language_sp` / `language_key` (-1 = nunca escolhido).
 * Original: x1/f1/lb/util/n0.java
 */
object LocaleManager {
    private val logger: Logger = LoggerFactory.getLogger(LocaleManager::class.java)

    private var defLanguage = "Follow the system"
    private var languageList: List<String> = listOf("Follow the system", "English", "Portuguese")
    private val languageMap = HashMap<String, String>()

    /**
     * Idioma padrão quando nada foi escolhido: Portuguese (índice 2) se o sistema for "pt",
     * senão English (índice 1). Original: `n0.l(Context, Configuration)`.
     */
    private fun applyDefault(context: Context, config: Configuration? = null): Context = try {
        val lang = languageMap[languageList[if (getSystemLanguage(context).startsWith("pt", true)) 2 else 1]]
        if (lang == null) context else updateResources(context, parseLocale(lang), config)
    } catch (t: Throwable) {
        logger.error("dft lang failure", t)
        context
    }

    /** Carrega os arrays de recursos e aplica o idioma salvo. Original: `n0.f(Context)` (static). */
    @JvmStatic
    fun init(context: Context) {
        loadArrays(context)
        reload(context)
    }

    private fun loadArrays(context: Context) {
        languageList = context.resources.getStringArray(R.array.language_array).toList()
        val locales = context.resources.getStringArray(R.array.locale_array).toList()
        defLanguage = languageList[0]
        for (i in languageList.indices) {
            if (i < locales.size && !TextUtils.isEmpty(locales[i])) languageMap[languageList[i]] = locales[i]
        }
    }

    /**
     * Aplica o idioma salvo no contexto (usado em `attachBaseContext`). Índice fora da faixa →
     * aplica o padrão mas devolve o contexto original (fiel ao original).
     * Original: `n0.n(Context, Configuration)` (static).
     */
    @JvmStatic
    fun attach(context: Context, config: Configuration? = null): Context {
        val idx = getSavedIndex(context, -1)
        if (idx < 0 || idx > languageList.size) {
            applyDefault(context, config)
            return context
        }
        val lang = languageMap[languageList[idx]] ?: return applyDefault(context, config)
        return try {
            updateResources(context, parseLocale(lang), config)
        } catch (t: Throwable) {
            logger.error("updateLocal failure", t)
            context
        }
    }

    /** Locale atual da configuração. Original: `n0.a(Context)`. */
    fun currentLocale(context: Context): Locale =
        if (Build.VERSION.SDK_INT >= 24) context.resources.configuration.locales[0]
        else @Suppress("DEPRECATION") context.resources.configuration.locale

    /** Original: `n0.c(Context, int)`. */
    fun getSavedIndex(context: Context, def: Int): Int =
        context.getSharedPreferences("language_sp", Context.MODE_PRIVATE).getInt("language_key", def)

    /** Código de idioma efetivo (locale salvo ou do sistema). Original: `n0.d(Context)`. */
    fun getLanguage(context: Context): String {
        val idx = getSavedIndex(context, -1)
        val name = if (idx < 0 || idx >= languageList.size) "" else languageList[idx]
        val code = if (languageMap.containsKey(name)) languageMap[name] ?: "" else ""
        return code.ifEmpty { getSystemLanguage(context) }
    }

    /** Original: `n0.e()`. */
    fun getLanguageList(): List<String> = languageList

    /** Reaplica o idioma e recarrega os arrays já traduzidos. Original: `n0.g(Context)`. */
    fun reload(context: Context) {
        if (getSavedIndex(context, -1) == -1) {
            applyDefault(context)
            return
        }
        val ctx = attach(context)
        if (ctx == context) return
        loadArrays(ctx)
    }

    /** "pt-BR" / "pt_BR" → Locale("pt","BR"); sem separador → Locale(lang). Original: `n0.h(String)`. */
    fun parseLocale(langStr: String): Locale {
        val sep = when {
            langStr.contains("-") -> "-"
            langStr.contains("_") -> "_"
            else -> return Locale(langStr)
        }
        val parts = langStr.split(sep).dropLastWhile { it.isEmpty() }
        // Fiel ao original: acessa [1] sem checar (ex.: "pt-" lançaria exceção).
        return Locale(parts[0], parts[1])
    }

    /** Se o locale novo difere do atual. Original: `n0.i(Context, Locale)`. */
    fun needUpdate(context: Context, newLocale: Locale?): Boolean {
        if (newLocale == null) return false
        @Suppress("DEPRECATION")
        return !(currentLocale(context) == newLocale &&
            context.resources.configuration.locale.language == newLocale.language)
    }

    /** Original: `n0.j(Context, int)` / `k(Context, int)`. */
    fun saveIndex(context: Context, pos: Int) {
        context.getSharedPreferences("language_sp", Context.MODE_PRIVATE).edit()
            .putInt("language_key", pos).commit()
    }

    /** Aplica o locale em resources, `Locale.setDefault` e cria contexto configurado. Original: `n0.o(...)`. */
    @Suppress("DEPRECATION")
    fun updateResources(context: Context, newLocale: Locale?, config: Configuration? = null): Context {
        val configuration = context.resources.configuration
        if (Build.VERSION.SDK_INT >= 24) {
            configuration.setLocale(newLocale)
            configuration.setLocales(LocaleList(newLocale))
            config?.setLocale(newLocale)
            config?.setLocales(LocaleList(newLocale))
        } else {
            configuration.locale = newLocale
            config?.locale = newLocale
        }
        if (newLocale != null) Locale.setDefault(newLocale)
        context.resources.updateConfiguration(configuration, context.resources.displayMetrics)
        return context.createConfigurationContext(configuration)
    }

    /** Troca de idioma pela UI (nome da lista + posição). Original: `n0.q(String, Context, int)`. */
    fun changeLanguage(lang: String, context: Context, pos: Int) {
        if (lang == defLanguage) {
            switchLocale(context, null, true, pos)
            return
        }
        val code = languageMap[lang] ?: return
        switchLocale(context, parseLocale(code), false, pos)
    }

    /** Idioma do sistema; zh-HK/zh-TW viram "zh-hk". Original: `n0.b(Context)`. */
    private fun getSystemLanguage(context: Context): String {
        val l = currentLocale(context)
        var language = l.language
        if (language == "zh" && (l.country.equals("hk", true) || l.country.equals("tw", true))) language += "-hk"
        return language
    }

    /**
     * Aplica um locale (ou o do sistema se "seguir sistema", ou "en") e salva a posição.
     * Original: `n0.p(Context, Locale, boolean, int)`.
     */
    private fun switchLocale(context: Context, newUserLocale: Locale?, isFollowSystem: Boolean, pos: Int): Context {
        var result = context
        try {
            val locale = newUserLocale ?: parseLocale(if (isFollowSystem) getSystemLanguage(context) else "en")
            result = if (needUpdate(context, locale)) {
                updateResources(context, locale)
            } else {
                @Suppress("DEPRECATION")
                context.resources.updateConfiguration(context.resources.configuration, context.resources.displayMetrics)
                context
            }
            saveIndex(context, pos)
        } catch (t: Throwable) {
            logger.info("updateLocale failure", t)
        }
        return result
    }
}
