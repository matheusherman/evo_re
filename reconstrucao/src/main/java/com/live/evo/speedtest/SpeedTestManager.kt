package com.live.evo.speedtest

import android.content.Context

/**
 * Gerenciador de teste de velocidade — stub (sem implementação no APK).
 *
 * Original: d6/a.java (+ d6/b.java vazio = [SpeedTestResult])
 */
class SpeedTestManager private constructor(context: Context) {
    private val appContext: Context = context.applicationContext  // orig: StubApp.getOrigApplicationContext
    private val result = SpeedTestResult()
    private var listener: Listener? = null

    /** Original: d6.a$a — interface sem métodos. */
    interface Listener

    /** Original: b(Listener) */
    fun setListener(l: Listener?) { listener = l }

    /** Original: c() — vazio. */
    fun stop() {}

    companion object {
        private var instance: SpeedTestManager? = null
        /** Original: a(Context) */
        fun get(context: Context): SpeedTestManager = instance ?: SpeedTestManager(context).also { instance = it }
    }
}

/** Original: d6/b.java — classe vazia. */
class SpeedTestResult
