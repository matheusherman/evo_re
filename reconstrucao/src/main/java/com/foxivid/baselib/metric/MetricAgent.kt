package com.foxivid.baselib.metric

import android.util.Base64
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.metric.model.MetricEvent
import com.foxivid.baselib.util.Clock
import com.foxivid.baselib.util.LoggerFactory
import com.google.gson.Gson
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.io.ByteArrayOutputStream
import java.util.concurrent.LinkedBlockingQueue
import java.util.zip.Deflater

/**
 * Agente de envio em lote de métricas.
 *
 * Original: uf/b.java (thread "metric-agent-thread")
 *
 * - Fila de até 10000 [MetricEvent]; só enfileira se `BaseLibConfig.isReportMetric` (propriedade
 *   remota `is_report_metric`, default false).
 * - Lote: envia quando acumula 100 eventos **ou** `now - lastSendTime > 10 s`. Como `lastSendTime`
 *   é `final` (definido só no construtor), passados 10 s do start cada evento é enviado sozinho.
 * - Corpo: form-urlencoded `data=<Base64( Deflate nível 9 ( JSON da lista ) )>` (p6.b + p6.a,
 *   Base64 padrão RFC4648 sem quebra de linha).
 * - POST `<url>/api/metric/batch/v1`, até 4 tentativas fazendo rodízio entre as URLs.
 */
class MetricAgent(urls: Array<String>, private val okHttpClient: OkHttpClient) : com.foxivid.baselib.host.MetricClientRef(urls, okHttpClient) {
    private val logger = LoggerFactory.getLogger(MetricAgent::class.java)
    private val METRIC_URI = "/api/metric/batch/v1"
    private val urls: Array<String> = urls
    private var index = 0
    private val batchSize = 100
    private val batchInterval = 10000L
    private val queue = LinkedBlockingQueue<MetricEvent>(10000)
    private val lastSendTime = Clock.elapsed()
    @Volatile private var stopped = true
    private val gson = Gson()

    init {
        stopped = false
        Thread({ loop() }, "metric-agent-thread").start()
    }

    /** Original: uf.b.g() */
    fun stop() { stopped = true }

    override fun close() = stop()

    /** Original: uf.b.c() */
    private fun loop() {
        val batch = ArrayList<MetricEvent>()
        while (!stopped) {
            try {
                val e = queue.take() ?: continue
                batch.add(e)
                if (batch.size >= batchSize || Clock.elapsed() - lastSendTime > batchInterval) {
                    if (batch.isNotEmpty()) sendBatch(batch)
                }
            } catch (ex: Exception) {
                logger.error("send metric loop failure", ex)
            }
        }
    }

    /** Original: uf.b.d(String, Map) */
    fun report(eventName: String, values: Map<String, Any?>) {
        if (BaseLibConfig.isReportMetric && !stopped) {
            queue.offer(MetricEvent().apply { name = eventName; this.values = values })
        }
    }

    /** Original: uf.b.e(RequestBody, String) */
    fun post(body: RequestBody, url: String): Boolean {
        return try {
            okHttpClient.newCall(Request.Builder().url(url).post(body).build()).execute().use { it.isSuccessful }
        } catch (e: Exception) {
            logger.error("send metric failure", e)
            false
        }
    }

    /** Original: uf.b.f(List) */
    private fun sendBatch(list: MutableList<MetricEvent>) {
        val data = Base64.encodeToString(deflate(gson.toJson(list)), Base64.NO_WRAP)
        try {
            val body = FormBody.Builder().add("data", data).build()
            for (i in 0 until 4) {
                if (post(body, urls[index] + METRIC_URI)) break
                index++
                if (index >= urls.size) index = 0
            }
        } catch (e: Exception) {
            logger.error("send metric failure", e)
        }
        list.clear()
    }

    /** Original: p6/b.a(String) — Deflater(9). */
    private fun deflate(s: String): ByteArray {
        val deflater = Deflater(9)
        deflater.setInput(s.toByteArray(Charsets.UTF_8))
        deflater.finish()
        val buf = ByteArray(1024)
        val out = ByteArrayOutputStream()
        while (!deflater.finished()) out.write(buf, 0, deflater.deflate(buf))
        deflater.end()
        out.close()
        return out.toByteArray()
    }
}
