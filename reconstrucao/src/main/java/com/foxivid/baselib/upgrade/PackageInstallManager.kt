package com.foxivid.baselib.upgrade

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageInstaller
import android.net.Uri
import android.os.Build
import android.text.TextUtils
import android.util.Log
import com.foxivid.baselib.config.BaseLibConfig
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

/**
 * Instalação silenciosa via `PackageInstaller` (só funciona quando o app tem privilégio de sistema /
 * permissão INSTALL_PACKAGES — usado por [ApkInstaller] quando o app roda com uid 1000).
 *
 * Original: x1/f1/lb/util/PackageInstallManager.java (nome não ofuscado)
 *
 * Fluxo: cria sessão MODE_FULL_INSTALL, copia o APK no stream "ZenithHost", espera 1 s, faz commit
 * com PendingIntent de broadcast `<applicationId>.ACTION_INSTALL_COMMIT` e aguarda (até 1 min) o
 * broadcast com `android.content.pm.extra.STATUS`. Sucesso = STATUS_SUCCESS (0).
 */
class PackageInstallManager(private val mContext: Context) {
    private val TAG = "PackageInstallManager"
    private val BROADCAST_ACTION = BaseLibConfig.applicationId + ".ACTION_INSTALL_COMMIT"
    private val BROADCAST_SENDER_PERMISSION = BaseLibConfig.applicationId + ".permission.INSTALL_PACKAGES"
    private val SECTION_NAME = "ZenithHost"
    private val DBG = true

    @Volatile private var mInstallCompleted = false
    private var mInstallStatusCode = 0
    private lateinit var mCountDownLatch: CountDownLatch
    private val mLock = Any()

    /** Original: lambda util/s0 → PackageInstallManager.f() — polling a cada 100 ms até completar. */
    private val mRunnable = Runnable {
        log("mRunnable run")
        var waited = 0
        while (!mInstallCompleted) {
            try {
                log("mRunnable wait $waited")
                Thread.sleep(100)
                waited += 100
            } catch (e: Exception) { e.printStackTrace() }
        }
        mCountDownLatch.countDown()
        log("mRunnable end")
    }

    private val mBroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            onPackageInstalled(intent.getIntExtra("android.content.pm.extra.STATUS", 1))
        }
    }

    init { setup() }

    /** Original: PackageInstallManager.i() */
    private fun setup() {
        val filter = IntentFilter().apply { addAction(BROADCAST_ACTION) }
        mContext.registerReceiver(mBroadcastReceiver, filter, BROADCAST_SENDER_PERMISSION, null)
        log("onSetup")
    }

    /** Original: PackageInstallManager.c() */
    fun destroy() {
        try { mContext.unregisterReceiver(mBroadcastReceiver) } catch (_: Exception) {}
        log("destroy")
    }

    /** Original: PackageInstallManager.d() */
    private fun getInstallResult(): Boolean {
        log("getInstallResult $mInstallCompleted;$mInstallStatusCode")
        return mInstallCompleted && mInstallStatusCode == 0
    }

    /** Original: PackageInstallManager.e() */
    private fun log(message: String) { if (DBG) Log.d(TAG, message) }

    /** Original: PackageInstallManager.g(int) */
    private fun onPackageInstalled(statusCode: Int) {
        mInstallStatusCode = statusCode
        mInstallCompleted = true
        log("onPackageInstalled $statusCode")
    }

    /** Original: PackageInstallManager.h(Context, String, String) */
    private fun parserAndInstall(context: Context, apkPath: String, packageName: String?): Boolean {
        val file = File(apkPath)
        log("parserAndInstall start")
        try {
            val params = PackageInstaller.SessionParams(PackageInstaller.SessionParams.MODE_FULL_INSTALL)
            params.setReferrerUri(Uri.fromFile(file))
            if (!TextUtils.isEmpty(packageName)) params.setAppPackageName(packageName)
            params.setSize(file.length())
            val installer = context.packageManager.packageInstaller
            val sessionId = installer.createSession(params)
            val session = installer.openSession(sessionId)
            log("parserAndInstall params ready")
            session.use {
                try {
                    FileInputStream(file).use { input ->
                        session.openWrite(SECTION_NAME, 0L, file.length()).use { output ->
                            val buf = ByteArray(4096)
                            while (true) {
                                val n = input.read(buf)
                                if (n == -1) break
                                output.write(buf, 0, n)
                            }
                            session.fsync(output)
                        }
                    }
                    Thread.sleep(1000L)
                    val intent = Intent(BROADCAST_ACTION)
                    // 201326592 = FLAG_UPDATE_CURRENT|FLAG_MUTABLE ; 134217728 = FLAG_UPDATE_CURRENT
                    val pi = if (Build.VERSION.SDK_INT >= 31)
                        PendingIntent.getBroadcast(context, sessionId, intent, 201326592)
                    else PendingIntent.getBroadcast(context, sessionId, intent, 134217728)
                    session.commit(pi.intentSender)
                    log("parserAndInstall end")
                    return true
                } catch (e: IOException) {
                    Log.e(TAG, "install error with IOException", e)
                    return false
                } catch (e: SecurityException) {
                    Log.e(TAG, "install error with SecurityException", e)
                    return false
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
            return false
        }
    }

    /**
     * Instala e espera o resultado (máx. 1 min).
     *
     * Original: PackageInstallManager.j(String, String)
     */
    fun silentInstallByPackageName(apkPath: String, packageName: String): Boolean = synchronized(mLock) {
        log("silentInstallByPackageName $apkPath;$packageName")
        if (!parserAndInstall(mContext, apkPath, packageName)) return false
        mInstallCompleted = false
        mInstallStatusCode = 1
        mCountDownLatch = CountDownLatch(1)
        Thread(mRunnable, "apk_installer").apply { isDaemon = true }.start()
        try { mCountDownLatch.await(1L, TimeUnit.MINUTES) } catch (e: Exception) { e.printStackTrace() }
        getInstallResult()
    }
}
