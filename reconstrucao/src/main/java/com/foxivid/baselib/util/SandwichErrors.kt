package com.foxivid.baselib.util

import com.foxivid.baselib.config.BaseLibConfig
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.net.SocketTimeoutException

/**
 * Converte falhas do Sandwich (`ApiResponse.Failure`) em mensagens curtas para a UI, logando detalhes.
 * Original: x1/f1/lb/util/v0.java (`com.skydoves.sandwich.a$b$a` = Failure.Error, `a$b$b` = Failure.Exception).
 */
object SandwichErrors {
    private val logger: Logger = LoggerFactory.getLogger(SandwichErrors::class.java)

    /** Loga URL/mensagem/headers e retorna "NOME_STATUS(código)". Original: `v0.a(Failure.Error)`. */
    fun <T> describe(error: ApiResponse.Failure.Error<T>): String {
        val raw = error.raw
        logger.error("ApiResponse.Failure.Error: url[${raw.request.url}] message[${error.message()}]")
        logger.error("ApiResponse.Failure.Error: url[${raw.request.url}] request headers[${raw.headers}]")
        logger.error("ApiResponse.Failure.Error: url[${raw.request.url}] response(${raw.code}) headers[${raw.headers}]")
        val statusCode = error.statusCode
        return "${statusCode.name}(${statusCode.code})"
    }

    /** Timeout → `R.string.timeout_error`; senão nome simples da exceção. Original: `v0.b(Failure.Exception)`. */
    fun <T> describe(exception: ApiResponse.Failure.Exception<T>): String {
        logger.error("ApiResponse.Failure.Exception:[${exception.message()}]", exception.exception)
        val msg = if (exception.exception is SocketTimeoutException) {
            BaseLibConfig.appContext?.getString(R.string.timeout_error)
        } else {
            exception.exception.javaClass.simpleName
        }
        return msg ?: "Unknown error"
    }

    /** Genérico: `R.string.request_failure` ou "Request failure". Original: `v0.c(Failure)`. */
    fun <T> describe(failure: ApiResponse.Failure<T>): String {
        logger.error("ApiResponse.Failure:Request failure[${failure.message()}]")
        return BaseLibConfig.appContext?.getString(R.string.request_failure) ?: "Request failure"
    }
}
