package com.foxivid.baselib.user

import com.foxivid.baselib.bot.TelegramBot
import com.foxivid.baselib.heartbeat.HeartbeatManager
import com.foxivid.baselib.host.ServerProviderUtils
import com.foxivid.baselib.model.extra.user.LoginInfo
import com.foxivid.baselib.model.ptv.ApiResponse
import org.slf4j.LoggerFactory

/**
 * Fábrica/seleção do adapter de autenticação e utilitários comuns.
 *
 * Original: x1/f1/lb/user/b.java (Kotlin: AAAAdapterFactory.kt)
 *
 * - Instancia os dois adapters; [getAdapter] devolve **sempre** o [PTV3AAdapter]
 *   (o [Extra3AAdapter] é criado mas não é selecionado no código decompilado).
 * - [reportIfFailure]: gancho do bot do Telegram — toda falha de autenticação vira mensagem
 *   `"[auth] failure\nerr_code:..\nerror:..\nparam:..\nat:<caller>"`.
 * - [applyProperties]: propriedades remotas (meta-info) repassadas ao heartbeat e ao host provider.
 */
object AAAAdapterFactory {

    private val logger = LoggerFactory.getLogger(AAAAdapterFactory::class.java)

    /** Original: campo `ptvAAAAdapter`. */
    private val ptvAAAAdapter = PTV3AAdapter()

    /** Original: campo `extraAAAAdapter`. */
    private val extraAAAAdapter = Extra3AAdapter()

    /**
     * Conversor de payload de resposta em [AuthResult].
     * Original: x1/f1/lb/user/b$a (interface `a<X, Y>`)
     */
    interface Convertor<X, Y> {
        /** Original: a() — descrição para log/bot. */
        fun describe(): String

        /** Original: b(errCode, errMsg, data) — null = "não consegui converter" (o chamador gera falha). */
        suspend fun convert(errCode: Int, errMsg: String?, data: X?): Y?
    }

    /**
     * Envia ao bot do Telegram as falhas de autenticação; devolve o próprio triple.
     * Original: b.b(String caller, u triple, String botDesc)
     */
    fun reportIfFailure(caller: String, triple: AuthResult, botDesc: String = ""): AuthResult {
        if (!triple.first) {
            TelegramBot.send("[auth] failure\nerr_code:${triple.second}\nerror:${triple.third}\nparam:$botDesc\nat:$caller")
        }
        return triple
    }

    /** Original: b.d(). */
    fun getAdapter(): AccountAdapter<ApiResponse<*>> = ptvAAAAdapter

    /** Original: b.e(Map) — heartbeat.K0(map) + host.b.p(map). */
    fun applyProperties(map: Map<*, *>) {
        HeartbeatManager.applyProperties(map)      // Original: x1.f1.lb.heartbeat.f.K0(map)
        ServerProviderUtils.applyProperties(map)   // Original: x1.f1.lb.host.b.p(map)
    }

    /**
     * Cria o conversor padrão de "resposta de login -> sessão local".
     * Original: b.f(...) (e b.g(...) com defaults) -> classe interna b$b ("updateLocalSession").
     *
     * Regras de [Convertor.convert]:
     *  - data nula: loga e retorna `(false, errCode, errMsg)` se `retFalseIfNull`, senão null;
     *  - errCode == 0: chama `updateCallback(SessionWrapper(...))` e, se `isLogin`,
     *    `UserManager.fireLoginComplete(oldUid)` (oldUid capturado antes da atualização); retorna `(true, 0, null)`;
     *  - errCode == 10100035: se data for [LoginInfo], `SessionConverter.updateContact(data)`;
     *    retorna `(false, -8, errMsg)` (precisa de ação do usuário);
     *  - outros: `(false, errCode, errMsg)`.
     *
     * [Convertor.describe] = `"l[isLogin], r[isRefresh], f[from], u[username], p[*|null], c[codigoMascarado]"`.
     */
    fun <X> createSessionConvertor(
        isLogin: Boolean,
        isRefreshAccessToken: Boolean,
        updateCallback: (SessionWrapper<X>) -> Unit,
        from: String = "",
        username: String? = null,
        password: String? = null,
        loginByCode: String? = null,
        retFalseIfNull: Boolean = false,
    ): Convertor<X, AuthResult> = object : Convertor<X, AuthResult> {
        override fun describe(): String =
            "l[$isLogin], r[$isRefreshAccessToken], f[$from], u[$username], p[" +
                (if (password.isNullOrEmpty()) "null" else "*") + "], c[" +
                com.foxivid.baselib.util.MaskUtils.mask(loginByCode) + "]"

        override suspend fun convert(errCode: Int, errMsg: String?, data: X?): AuthResult? {
            if (data == null) {
                logger.warn("update local session failure, response null object, $errMsg($errCode)")
                return if (retFalseIfNull) Triple(false, errCode, errMsg) else null
            }
            val oldUid = UserManager.getAccountIdString()
            if (errCode != 0) {
                if (errCode != 10100035) return Triple(false, errCode, errMsg)
                if (data is LoginInfo) SessionConverter.updateContact(data)
                return Triple(false, -8, errMsg)
            }
            updateCallback(SessionWrapper(data, isRefreshAccessToken, from, loginByCode, username, password))
            if (isLogin) UserManager.fireLoginComplete(oldUid)
            return Triple(true, errCode, null)
        }
    }
}
