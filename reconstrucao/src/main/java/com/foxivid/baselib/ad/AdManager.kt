package com.foxivid.baselib.ad

import com.foxivid.baselib.api.cache.ApiFileCache
import com.foxivid.baselib.event.AdExtContentUpdatedEvent
import com.foxivid.baselib.network.HeaderInterceptor
import com.foxivid.baselib.util.Preferences
import com.foxivid.baselib.util.ResultCallback
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.greenrobot.eventbus.EventBus
import java.io.File
import java.util.Locale

/**
 * Gerenciador de anúncios.
 *
 * Original: x1/f1/lb/ad/b.java (nome Kotlin original `AdManager`, arquivo `AdManager.kt`,
 * conforme as anotações `@DebugMetadata` das corrotinas).
 *
 * Não há regra de exibição (frequência, horário etc.) aqui: o gerenciador apenas
 *  - monta a lista de anúncios de abertura a partir da preferência `startup_ad_list`
 *    (URLs separadas por vírgula, enviadas pelo servidor via propriedade de heartbeat
 *    `startup_ad_list` — ver `AppPropertyHandlers`), baixando-as para o cache de arquivos;
 *  - mantém em memória o "conteúdo estendido" de anúncios (`ad_list_ext`, JSON de lista
 *    genérica) e avisa a UI via EventBus quando ele muda.
 *
 * Em builds do canal de distribuição `"code"` os anúncios estendidos são ignorados.
 */
object AdManager {

    /**
     * Conteúdo estendido de anúncios (lista JSON desserializada como `List<Any>`).
     * Lido pela UI do app; aqui só é escrito.
     *
     * Original: campo `adExtContent` / `getAdExtContent()` / `g(List)`.
     */
    var adExtContent: List<Any> = ArrayList()

    /**
     * Indica se o app foi distribuído pelo canal `"code"` (ativação por código),
     * no qual os anúncios estendidos são desativados.
     *
     * Original: `b.b()` — compara `of.a.f()` (canal de distribuição, o mesmo enviado no header
     * `X-Distribution-Channel`) com `"code"`.
     */
    fun isCodeChannel(): Boolean = HeaderInterceptor.distributionChannel() == "code"

    /**
     * Carrega a lista de anúncios de abertura.
     *
     * Lê a preferência `startup_ad_list` (Flow), separa as URLs por `,`, baixa/obtém do cache
     * com a chave `start_up_img_list` e entrega uma lista de [AdItem] no thread principal.
     * Erros (de leitura ou de download) são entregues via [ResultCallback.onFailure],
     * também no thread principal.
     *
     * Original: `b.c(g0)` (corrotina `AdManager$getStartupAdList$1`).
     */
    fun getStartupAdList(callback: ResultCallback<List<AdItem>>) {
        CoroutineScope(Dispatchers.IO).launch {
            Preferences.get("startup_ad_list", "")
                .catch { e -> MainScope().launch { callback.onFailure(e) } }
                .collect { value ->
                    val files: Map<String, File>
                    try {
                        val urls = value.split(",")
                        files = ApiFileCache.getFiles("start_up_img_list", urls)
                    } catch (e: Throwable) {
                        callback.onFailure(e)
                        // Nota de fidelidade: o código original, após entregar a falha, continua
                        // e tenta iterar o resultado (o que só funciona se o download retornou).
                        return@collect
                    }
                    val adItemList = ArrayList<AdItem>()
                    var index = 0
                    for ((url, file) in files) {
                        adItemList.add(AdItem(index, isVideo(url), file))
                        index++
                    }
                    MainScope().launch { callback.onResult(adItemList) }
                }
        }
    }

    /**
     * Decide se a URL é de vídeo pela extensão (.mp4, .mov, .ts, .mpegts — note que é um
     * `endsWith` em minúsculas).
     *
     * Original: `b.d(String)`.
     */
    private fun isVideo(url: String): Boolean {
        val lower = url.lowercase(Locale.getDefault())
        return lower.endsWith(".mp4") || lower.endsWith(".mov") ||
            lower.endsWith(".ts") || lower.endsWith(".mpegts")
    }

    /**
     * Recarrega o conteúdo estendido a partir da preferência `ad_list_ext`
     * (exceto no canal `"code"`). Chamado na inicialização (LiveLoadActivity).
     *
     * Original: `b.e()` (corrotina `AdManager$loadAdExtContent$1`).
     */
    fun loadAdExtContent() {
        if (isCodeChannel()) return
        CoroutineScope(Dispatchers.IO).launch {
            Preferences.get("ad_list_ext", "")
                .catch { /* erro ignorado (o original lança uma corrotina vazia no Main) */ }
                .collect { value -> updateAdExtContent(value) }
        }
    }

    /**
     * Desserializa o JSON de `ad_list_ext` com Gson (`List<Any>`), atualiza [adExtContent]
     * no thread principal e publica o evento [AdExtContentUpdatedEvent] (original `nf.a`).
     * Exceções são engolidas. Também chamado pelo handler da propriedade de heartbeat
     * `ad_list_ext` (que antes grava o valor nas preferências).
     *
     * Original: `b.f(String)` (corrotina `AdManager$loadAdExtContent$2`).
     */
    fun updateAdExtContent(value: String) {
        if (isCodeChannel()) return
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val contentList: List<Any> =
                    Gson().fromJson(value, object : TypeToken<List<Any>>() {}.type)
                withContext(Dispatchers.Main) {
                    adExtContent = contentList
                    EventBus.getDefault().post(AdExtContentUpdatedEvent())
                }
            } catch (_: Throwable) {
            }
        }
    }
}
