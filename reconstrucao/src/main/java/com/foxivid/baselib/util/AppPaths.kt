package com.foxivid.baselib.util

import android.os.Build
import android.os.Environment
import android.os.StatFs
import com.foxivid.baselib.config.BaseLibConfig
import java.io.File

/**
 * Diretórios de cache/dados do app (sufixados pelo ambiente `BaseLibConfig.env`) e estatística
 * de armazenamento.
 * Original: x1/f1/lb/util/b1.java
 */
object AppPaths {
    private lateinit var appCachePathM: String
    private lateinit var appCachePathGtM: String
    private lateinit var epgCachePath: String
    private lateinit var tmpCachePath: String
    private lateinit var crashLogPath: String
    private lateinit var videoDataPath: String
    private lateinit var videoFullDataPath: String
    private lateinit var vodPlaylistCachePath: String
    private lateinit var fileDataPath: String
    private lateinit var playPositionHistoryPath: String
    private lateinit var signatureCachePath: String
    private lateinit var subscribeCachePath: String
    private lateinit var sportsCachePath: String
    private lateinit var hostsCachePath: String
    private var totalStorage = 0L
    private var freeStorage = 0L

    /** Apaga os arquivos do diretório temporário. Original: `b1.a()`. */
    private fun clearTmp() {
        File(tmpCachePath).listFiles()?.forEach { it.delete() }
    }

    /** Original: `b1.g(File, String)`. */
    private fun ensureDir(fileDirs: File, subPath: String): String {
        val f = File(fileDirs, subPath)
        if (!f.exists()) f.mkdirs()
        return f.absolutePath
    }

    /**
     * Cria os diretórios e remove `upgrade.apk` antigos. Note `"sports" + env` sem "_" (fiel).
     * Original: `b1.h(File)`.
     */
    private fun initDirs(fileDirs: File) {
        val env = BaseLibConfig.env
        epgCachePath = ensureDir(fileDirs, "epg_$env")
        appCachePathM = fileDirs.absolutePath
        appCachePathGtM = ensureDir(fileDirs, "upgrade")
        tmpCachePath = ensureDir(fileDirs, "_tmp_$env")
        crashLogPath = ensureDir(fileDirs, "log_$env")
        videoDataPath = ensureDir(fileDirs, "v_data_$env")
        videoFullDataPath = ensureDir(fileDirs, "v_f_data_$env")
        fileDataPath = ensureDir(fileDirs, "f_data_$env")
        playPositionHistoryPath = ensureDir(fileDirs, "vod_play_hist_$env")
        vodPlaylistCachePath = ensureDir(fileDirs, "vod_playlist_$env")
        signatureCachePath = ensureDir(fileDirs, "signature_$env")
        subscribeCachePath = ensureDir(fileDirs, "subscribe_$env")
        sportsCachePath = ensureDir(fileDirs, "sports$env")
        hostsCachePath = ensureDir(fileDirs, "hosts_$env")
        File(appCachePathM, "upgrade.apk").takeIf { it.exists() }?.delete()
        File(appCachePathGtM, "upgrade.apk").takeIf { it.exists() }?.delete()
    }

    /** Lê total/livre do armazenamento externo. Original: `b1.q()`. */
    @Suppress("DEPRECATION")
    private fun readStorage() {
        val st = StatFs(Environment.getExternalStorageDirectory().path)
        totalStorage = st.totalBytes
        freeStorage = st.freeBytes
    }

    /** Inicialização: storage, diretórios, limpeza do tmp. Original: `b1.m(File)`. */
    fun init(fileDirs: File) {
        readStorage()
        initDirs(fileDirs)
        clearTmp()
    }

    /** Original: `b1.b()`. */ fun crashLogPath(): String = crashLogPath
    /** Original: `b1.c()`. */ fun epgCachePath(): String = epgCachePath
    /** Original: `b1.d(String, String)`. */ fun join(dir: String, fileName: String): String = dir + File.separator + fileName
    /** Original: `b1.e()`. */ fun tmpCachePath(): String = tmpCachePath
    /** Diretório do APK de upgrade (API ≥ 24 usa "upgrade/"). Original: `b1.f()`. */
    fun upgradePath(): String = if (Build.VERSION.SDK_INT >= 24) appCachePathGtM else appCachePathM
    /** Original: `b1.i()`. */ fun fileDataPath(): String = fileDataPath
    /** Original: `b1.j()`. */ fun freeStorage(): Long = freeStorage
    /** Original: `b1.k()`. */ fun hostsCachePath(): String = hostsCachePath
    /** Original: `b1.l()`. */ fun totalStorage(): Long = totalStorage
    /** Original: `b1.n()`. */ fun playPositionHistoryPath(): String = playPositionHistoryPath
    /** Original: `b1.o()`. */ fun signatureCachePath(): String = signatureCachePath
    /** Original: `b1.p()`. */ fun sportsCachePath(): String = sportsCachePath
    /** Original: `b1.r()`. */ fun subscribeCachePath(): String = subscribeCachePath
    /** Original: `b1.s()`. */ fun videoDataPath(): String = videoDataPath
    /** Original: `b1.t()`. */ fun videoFullDataPath(): String = videoFullDataPath
    /** Original: `b1.u()`. */ fun vodPlaylistCachePath(): String = vodPlaylistCachePath
}
