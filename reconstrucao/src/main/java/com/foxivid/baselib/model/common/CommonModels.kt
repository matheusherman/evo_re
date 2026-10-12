package com.foxivid.baselib.model.common

import java.io.Serializable
import org.apache.commons.lang3.builder.ReflectionToStringBuilder
import org.apache.commons.lang3.builder.ToStringStyle

/*
 * Observação geral sobre os modelos: o original NÃO usa @SerializedName; o Gson padrão
 * (GsonConverterFactory.create()) usa o nome do campo Java. Classes @Keep / subclasses de
 * BaseModel mantêm os nomes reais. Nas classes não protegidas o R8 renomeou os campos para
 * "a", "b", ... — então o JSON trafega com essas chaves. Nesses casos, o campo aqui tem nome
 * legível (vindo do getter @Keep) mas `@SerializedName("a")` documenta a chave real em runtime.
 */

/**
 * Base serializável de quase todos os modelos; toString por reflexão.
 * Original: n6/a.java (lib compartilhada; nome original ofuscado).
 * TODO: estilo exato (`commons-lang ToStringStyle` em `d.f1063g`) não identificado.
 */
abstract class BaseModel : Serializable {
    override fun toString(): String = ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE)
}

/**
 * Resposta genérica dos servidores de metadados (STREAM_META).
 * Original: n6/b.java — `@ApiModel("通用API返回结构")` ("estrutura genérica de retorno da API").
 */
open class ApiResult<T> : BaseModel() {
    /** "checksum". Original getter: c(). */
    var checkSum: String? = null
    /** Código de status; "0" = sucesso. */
    var code: String = "0"
    /** Dados de sucesso. */
    var data: T? = null
    /** Descrição do erro. Original getter: d(). */
    var msg: String? = null
    /** Duração da resposta (ms). */
    var timeMs: Long = 0
}
