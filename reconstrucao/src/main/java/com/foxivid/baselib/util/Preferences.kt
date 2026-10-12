package com.foxivid.baselib.util

import com.foxivid.baselib.config.BaseLibConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Armazenamento chave/valor da baselib (nome original no Kotlin: `SPUtils`, arquivo `SPUtils.kt`).
 *
 * Não acessa SharedPreferences diretamente: delega para um [Editor] (normalmente uma
 * implementação sobre DataStore, injetada pelo app via [setEditor]).
 *
 * Detalhes importantes:
 * - **Ofuscação das chaves**: cada chave lógica é gravada como o MD5 hex dela
 *   (ver [obfuscateKey], que usa [LegacyTvUtils.md5Hex]). Resultado é cacheado em [keyMap].
 * - **Fallback legado**: na leitura, se o valor da chave ofuscada vier igual ao default
 *   (ou vazio, para strings), tenta-se ler a chave em texto puro (formato antigo).
 * - **Strings cifradas**: valores string são cifrados com [TextCipher.encrypt] (chave fixa,
 *   `isRandomKey = false`) antes de gravar e decifrados na leitura.
 * - Escritas são "fire and forget" no [puckScope] (IO).
 *
 * Original: x1/f1/lb/util/w0.java (e classes internas w0$a..w0$m).
 */
object Preferences {

    private val logger: Logger = LoggerFactory.getLogger(Preferences::class.java)

    /** Escopo de IO para leituras/escritas assíncronas. Original: campo `puckScope`. */
    private val puckScope: CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    /** Cache chave lógica -> chave ofuscada (MD5). Original: campo `keyMap`. */
    private val keyMap = HashMap<String, String>()

    /** Backend de armazenamento injetado. Original: campo `editor`. */
    private var editor: Editor? = null

    /**
     * Callback de resultado de leitura assíncrona.
     * Original: x1/f1/lb/util/w0$a
     */
    fun interface Callback<V> {
        fun onValue(value: V)
    }

    /**
     * Backend de armazenamento (implementado fora da baselib, ex.: DataStore).
     * Original: x1/f1/lb/util/w0$b
     */
    interface Editor {
        /** Original: w0$b.a() */
        suspend fun putInt(key: String, int: Int)
        /** Original: w0$b.e() */
        suspend fun getInt(key: String, dft: Int): Int
        /** Original: w0$b.c() */
        suspend fun putLong(key: String, long: Long)
        /** Original: w0$b.b() */
        suspend fun getLong(key: String, dft: Long): Long
        /** Original: w0$b.d() */
        suspend fun putString(key: String, string: String)
        /** Original: w0$b.f() */
        suspend fun getString(key: String, dft: String): String
    }

    /**
     * Entrega o valor ao callback na thread principal.
     * Original: w0.e() (corrotina w0$c "SPUtils$callCallback$1")
     */
    private fun <T> callCallback(callback: Callback<T>?, value: T) {
        if (callback == null) return
        CoroutineScope(Dispatchers.Main).launch { callback.onValue(value) }
    }

    /**
     * Converte a chave lógica na chave gravada (MD5 hex da chave), com cache e double-check.
     * Original: w0.f()
     */
    private fun obfuscateKey(key: String): String {
        val cached = keyMap[key].orEmpty()
        if (cached.isNotEmpty()) return cached
        synchronized(this) {
            var obfuscated = keyMap[key].orEmpty()
            if (obfuscated.isEmpty()) {
                obfuscated = LegacyTvUtils.getInstance().md5Hex(key) ?: key
                keyMap[key] = obfuscated
            }
            return obfuscated
        }
    }

    /**
     * Fluxo frio que emite um único valor lido, conforme o tipo do default
     * (String, Int ou Long). Para outros tipos emite o próprio default.
     * Original: w0.g() (corrotina w0$d "SPUtils$get$1")
     */
    @Suppress("UNCHECKED_CAST")
    fun <T> get(key: String, dft: T): Flow<T> = flow {
        val value: Any? = when (dft) {
            is String -> getString(key, dft)
            is Int -> getInt(key, dft)
            is Long -> getLong(key, dft)
            else -> dft
        }
        emit(value as T)
    }

    /**
     * Lê um inteiro. Tenta primeiro a chave ofuscada; se vier o default, tenta a chave em texto puro.
     * Original: w0.h() (continuação w0$e)
     */
    suspend fun getInt(key: String, dft: Int = 0): Int {
        val e = editor ?: return dft
        return try {
            val value = e.getInt(obfuscateKey(key), dft)
            if (value != dft) value else editor?.getInt(key, dft) ?: dft
        } catch (ex: Exception) {
            logger.error("get [{}] from sp failure", key, ex)
            dft
        }
    }

    /**
     * Versão assíncrona de [getInt]. Obs.: aqui o callback é chamado direto na thread de IO
     * (diferente de long/string, que usam [callCallback]).
     * Original: w0.i() (corrotina w0$f "SPUtils$getInt$2")
     */
    fun getInt(key: String, callback: Callback<Int>, dft: Int = 0) {
        puckScope.launch {
            val value = try {
                getInt(key, dft)
            } catch (ex: Exception) {
                logger.error("get [{}] from sp failure", key, ex)
                dft
            }
            callback.onValue(value)
        }
    }

    /**
     * Lê um long (mesma lógica de fallback de [getInt]).
     * Original: w0.j() (continuação w0$g)
     */
    suspend fun getLong(key: String, dft: Long = 0L): Long {
        val e = editor ?: return dft
        return try {
            val value = e.getLong(obfuscateKey(key), dft)
            if (value != dft) value else editor?.getLong(key, dft) ?: dft
        } catch (ex: Exception) {
            logger.error("get [{}] from sp failure", key, ex)
            dft
        }
    }

    /**
     * Versão assíncrona de [getLong]; resultado entregue na main thread.
     * Original: w0.k() (corrotina w0$h "SPUtils$getLong$2")
     */
    fun getLong(key: String, callback: Callback<Long>, dft: Long = 0L) {
        puckScope.launch {
            val value = try {
                getLong(key, dft)
            } catch (ex: Exception) {
                logger.error("get [{}] from sp failure", key, ex)
                dft
            }
            callCallback(callback, value)
        }
    }

    /**
     * Lê uma string cifrada. Tenta a chave ofuscada; se vazio, tenta a chave em texto puro.
     * Se o valor bruto for vazio ou igual ao default, devolve o default; senão decifra com
     * [TextCipher.decrypt] (chave fixa).
     * Original: w0.m() (continuação w0$i)
     *
     * Obs.: o jadx não decompilou corretamente este método; a ordem acima foi inferida da
     * state machine (labels 1 = chave ofuscada, 2 = chave legada).
     */
    suspend fun getString(key: String, dft: String = ""): String {
        val e = editor ?: return dft
        var raw: String? = e.getString(obfuscateKey(key), dft)
        if (raw.isNullOrEmpty()) {
            raw = editor?.getString(key, dft) ?: return dft
        }
        return try {
            if (BaseLibConfig.isDebug) {
                logger.debug("sp_string_get[{}], size[{}]", key, raw.length)
            }
            if (raw.isEmpty() || raw == dft) dft else TextCipher.decrypt(raw, false)
        } catch (th: Throwable) {
            logger.error("get [{}] from sp failure", key, th)
            dft
        }
    }

    /**
     * Versão assíncrona de [getString]; resultado entregue na main thread.
     * Original: w0.n() (corrotina w0$j "SPUtils$getString$2")
     */
    fun getString(key: String, callback: Callback<String>, dft: String = "") {
        puckScope.launch {
            val value = try {
                getString(key, dft)
            } catch (ex: Exception) {
                logger.error("get [{}] from sp failure", key, ex)
                dft
            }
            callCallback(callback, value)
        }
    }

    /** Injeta o backend. Original: w0.q() */
    fun setEditor(editor: Editor) {
        this.editor = editor
    }

    /** Original: w0.r() (corrotina w0$k "SPUtils$putInt$1") */
    fun putInt(key: String, value: Int) {
        puckScope.launch {
            try {
                editor?.putInt(obfuscateKey(key), value)
            } catch (ex: Exception) {
                logger.error("put [{}] into sp failure", key, ex)
            }
        }
    }

    /** Original: w0.s() (corrotina w0$l "SPUtils$putLong$1") */
    fun putLong(key: String, value: Long) {
        puckScope.launch {
            try {
                editor?.putLong(obfuscateKey(key), value)
            } catch (ex: Exception) {
                logger.error("put [{}] into sp failure", key, ex)
            }
        }
    }

    /**
     * Cifra o valor com [TextCipher.encrypt] (chave fixa) e grava na chave ofuscada.
     * Original: w0.t() (corrotina w0$m "SPUtils$putString$1")
     */
    fun putString(key: String, value: String) {
        puckScope.launch {
            try {
                val encrypted = TextCipher.encrypt(value, false)
                if (BaseLibConfig.isDebug) {
                    logger.debug("sp_string_put[{}], size[{}]", key, encrypted.length)
                }
                editor?.putString(obfuscateKey(key), encrypted)
            } catch (ex: Exception) {
                logger.error("put [{}] into sp failure", key, ex)
            }
        }
    }
}
