package com.foxivid.baselib.device

import com.foxivid.baselib.util.Preferences
import org.slf4j.LoggerFactory
import java.io.File
import java.io.FileOutputStream
import java.io.RandomAccessFile
import java.util.UUID

/**
 * Identificador estável do dispositivo ("did").
 *
 * Original: x1/f1/lb/id/a.java (Kotlin original: `x1.f1.lb.id.Installation`, arquivo Installation.kt)
 *
 * O did é derivado do hardware, não aleatório:
 * `did = UUID.nameUUIDFromBytes((cpuSerialOuMac + mac).toByteArray(UTF_8))` (UUID v3 = MD5).
 *  - `cpuSerialOuMac` = [DeviceInfoCollector.getCpuSerialOrMac] (cpu_serial; se vazio, MAC)
 *  - `mac`            = [DeviceInfoCollector.getMac] (eth_mac; se vazio, wifi_mac)
 * Se ambos forem vazios cai para `UUID.randomUUID()`.
 *
 * Persistência: arquivo `<fileInstallDir>/INSTALLATION`; se a leitura falhar ou vier vazia,
 * usa a chave `INSTALLATION` no SPUtils (SharedPreferences "config", chave = md5("INSTALLATION")),
 * gerando e gravando um novo valor se também estiver vazia.
 * Por ser determinístico, reinstalar o app no mesmo aparelho produz o mesmo did.
 */
object Installation {

    private val logger = LoggerFactory.getLogger(Installation::class.java)

    /** Original: campo `sID` (cache em memória). */
    private var sID: String? = null

    /** Original: campo `isFirstLogin` — setado em [generateDid], nunca lido no código decompilado. */
    private var isFirstLogin = false

    /**
     * Retorna o did (com cache em memória).
     * Original: a.c(File, Continuation) — "id".
     */
    suspend fun id(idFileInstallDir: File?): String {
        sID?.takeIf { it.isNotEmpty() }?.let { return it }
        val installation = File(idFileInstallDir, "INSTALLATION")
        var id = try {
            if (!installation.exists()) writeInstallationFile(installation)
            readInstallationFile(installation)
        } catch (t: Throwable) {
            logger.warn("generate id from file failure", t)
            ""
        }
        if (id.isEmpty()) {
            id = Preferences.getString("INSTALLATION", "").ifEmpty { generateAndSaveToPrefs() }
        }
        sID = id
        return id
    }

    /** Original: a.a() — gera o did a partir do hardware. */
    private fun generateDid(): String {
        var result = ""
        isFirstLogin = true
        val cpuSerialOrMac = DeviceInfoCollector.getCpuSerialOrMac() // z.s()
        val mac = DeviceInfoCollector.getMac()                      // z.o()
        try {
            val seed = cpuSerialOrMac + mac
            val uuid: String? = if (seed.isEmpty()) {
                UUID.randomUUID()?.toString()
            } else {
                UUID.nameUUIDFromBytes(seed.toByteArray(Charsets.UTF_8))?.toString()
            }
            if (uuid.isNullOrEmpty()) {
                logger.error("did:[$cpuSerialOrMac][$mac]->[$uuid] is empty")
            }
            if (uuid != null) result = uuid
        } catch (t: Throwable) {
            logger.error("generate did failure", t)
        }
        if (result.isEmpty()) result = if (mac.isEmpty()) cpuSerialOrMac else mac
        logger.info("did:[$cpuSerialOrMac][$mac]->[$result]")
        return result
    }

    /** Original: a.d(File). */
    private fun readInstallationFile(installation: File): String {
        RandomAccessFile(installation, "r").use { f ->
            val bytes = ByteArray(f.length().toInt())
            f.readFully(bytes)
            return String(bytes, Charsets.UTF_8)
        }
    }

    /** Original: a.e(File). */
    private fun writeInstallationFile(installation: File) {
        FileOutputStream(installation).use { it.write(generateDid().toByteArray(Charsets.UTF_8)) }
    }

    /** Original: a.b() — gera e grava em SPUtils("INSTALLATION"). */
    private fun generateAndSaveToPrefs(): String {
        val did = generateDid()
        Preferences.putString("INSTALLATION", did)
        return did
    }
}
