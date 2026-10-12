package com.foxivid.baselib.upgrade

import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.util.LoggerFactory
import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader

/**
 * Executa comandos num shell (`su` ou `sh`) escrevendo-os no stdin do processo.
 *
 * Original: x1/f1/lb/util/p.java
 *
 * Observação: a saída (stdout) é aberta mas nunca lida; o retorno é apenas "não houve exceção",
 * não o exit code do comando.
 */
object ShellUtils {
    private val logger = LoggerFactory.getLogger(ShellUtils::class.java)

    /** Original: p.a(String, boolean, boolean) / p.b(...) (defaults withSu=false, waitProcess=false) */
    fun exec(cmd: String, withSu: Boolean = false, waitProcess: Boolean = false): Boolean =
        exec(listOf(cmd), withSu, waitProcess)

    /** Original: p.c(List, boolean, boolean) */
    fun exec(cmds: List<String>?, withSu: Boolean, waitProcess: Boolean): Boolean {
        if (cmds.isNullOrEmpty()) return false
        if (BaseLibConfig.isDebug) logger.debug("start")
        var ok = true
        var out: DataOutputStream? = null
        var reader: BufferedReader? = null
        try {
            val process = Runtime.getRuntime().exec(if (withSu) "su" else "sh") ?: return false
            out = DataOutputStream(process.outputStream)
            reader = BufferedReader(InputStreamReader(process.inputStream))
            for (c in cmds) {
                out.write(c.toByteArray(Charsets.UTF_8))
                out.writeBytes("\n")
            }
            out.writeBytes("exit\n")
            out.flush()
            if (waitProcess) {
                process.waitFor()
                process.destroy()
            }
        } catch (e: Exception) {
            logger.error("exec cmd failure", e)
            ok = false
        } finally {
            try { out?.close() } catch (e: Exception) { e.printStackTrace() }
            try { reader?.close() } catch (e: Exception) { e.printStackTrace() }
        }
        if (BaseLibConfig.isDebug) logger.debug("end normal ret =$ok")
        return ok
    }
}
