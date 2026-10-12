package com.foxivid.baselib.model.extra

import androidx.annotation.Keep
import com.foxivid.baselib.config.DeviceInfoRef
import com.foxivid.baselib.config.TimeUtilsRef
import com.foxivid.baselib.model.common.BaseModel
import com.foxivid.baselib.network.HeaderInterceptor
import com.google.gson.annotations.SerializedName

/**
 * Contrato comum de resposta.
 * Original: z1/b1/lb/m/IApiResponse.java.
 */
interface IApiResponse {
    @Keep fun getErrCode(): Int
    @Keep fun getErrMsg(): String?
    @Keep fun isSuccess(): Boolean
}

/**
 * Campos comuns de toda requisição JSON, preenchidos no construtor a partir do HeaderInterceptor.
 * Original: z1/b1/lb/m/extra/ApiRequestBasic.java.
 */
open class ApiRequestBasic : BaseModel() {
    val appId: Int = HeaderInterceptor.appId()
    val appVersion: Long = HeaderInterceptor.appVersion()
    val distributionChannel: String = HeaderInterceptor.distributionChannel()
    val brandId: Int = HeaderInterceptor.brandId()
    val tenantId: Int = HeaderInterceptor.tenantId()
    val lang: String = HeaderInterceptor.language()
    val mac: String = HeaderInterceptor.mac()
    val did: String = HeaderInterceptor.deviceId()
    val sn: String = HeaderInterceptor.serialNumber()
    /** Timestamp (ms, relógio ajustado ao servidor) como string. Original: d1.d(). */
    val reqTs: String = TimeUtilsRef.now().toString()
    /** Mapa de informações do aparelho. Original: util/z.i(). */
    val deviceInfo: Map<String, String> = DeviceInfoRef.deviceInfo()
}

/**
 * Resposta "extra" (errCode numérico). Sucesso: errCode 0 ou 10100035.
 * Original: z1/b1/lb/m/extra/ApiResponseBasic.java.
 */
open class ApiResponseBasic : BaseModel(), IApiResponse {
    // privados para não colidir com os getters da interface (no Java há getter/setter @Keep)
    private var errCode: Int = 0
    private var errMsg: String? = null
    override fun getErrCode(): Int = errCode
    /** Formato "errCode:errMsg". */
    override fun getErrMsg(): String = "$errCode:$errMsg"
    override fun isSuccess(): Boolean = errCode == 0 || errCode == 10100035
}

/** Original: z1/b1/lb/m/extra/ApiResponse.java. */
open class ApiResponse<T> : ApiResponseBasic() {
    var data: T? = null
}

/** Corpo vazio do logout extra. Original: eg/a.java (nome inventado). */
class LogoutRequest : ApiRequestBasic()

/** Corpo vazio da consulta de propriedades. Original: eg/b.java (nome inventado). */
class QueryPropertyRequest : ApiRequestBasic()

/** Original: z1/b1/lb/m/extra/heartbeat/HeartbeatInfo.java (campo ofuscado). */
class HeartbeatInfo {
    @SerializedName("a") var properties: Map<*, *>? = null
}

/** Original: z1/b1/lb/m/extra/marquee/MarqueeInfo.java. equals/hashCode sobre todos os campos. */
data class MarqueeInfo(
    var id: Long = 0,
    var lang: String? = null,
    var seq: Int = 0,
    var content: String? = null,
    var updateTime: Long = 0,
    var properties: Map<String, String> = HashMap(),
    var displayInterval: Int = 0,
    var displayTimes: Int = 0,
) : BaseModel()

/** Original: z1/b1/lb/m/extra/marquee/MarqueeList.java. */
class MarqueeList : BaseModel() {
    var marqueeList: List<MarqueeInfo> = ArrayList()
}
