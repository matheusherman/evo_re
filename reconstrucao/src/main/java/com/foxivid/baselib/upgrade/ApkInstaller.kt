package com.foxivid.baselib.upgrade

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.text.TextUtils
import androidx.annotation.RequiresApi
import androidx.core.content.FileProvider
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.util.AppAttrUtils
import com.foxivid.baselib.util.StoragePaths
import com.foxivid.baselib.util.Toasts
import com.foxivid.baselib.util.LoggerFactory
import java.io.ByteArrayInputStream
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory
import x.l1.b2.R

/**
 * Verificação e instalação do APK de upgrade.
 *
 * Original: x1/f1/lb/util/m0.java
 *
 * Estratégias de instalação ([install]):
 * 1. App **não** é de sistema (uid != 1000): `chmod 777 <apk>` via `sh` e Intent ACTION_VIEW
 *    (FileProvider `<pkg>.fileProvider` em API >= 24).
 * 2. App de sistema (uid 1000) em API < 26: `pm install -r -i <pkg> [--user 0] <apk>` via `sh` (sem su).
 * 3. App de sistema em API >= 26: [PackageInstallManager] (sessão silenciosa).
 */
object ApkInstaller {
    private val logger = LoggerFactory.getLogger(ApkInstaller::class.java)

    /**
     * Lê o AndroidManifest binário do APK (biblioteca `ya.b` = apk-parser, `ApkFile.getManifestXml()`)
     * e confere meta-data. Retorna `null` se OK, ou `Pair(código, valorEncontrado)`:
     * 4 = DISTRIBUTION_CHANNEL diferente (só se `isVerifyDistributionChannelBeforeUpgradeInstall`),
     * 5 = APP_TYPE incompatível ("mobile" vs não-mobile).
     *
     * Original: m0.l(File)
     */
    fun verifyApkMeta(file: File): Pair<Int, String?>? {
        return try {
            net.dongliu.apk.parser.ApkFile(file).use { apk ->
                val manifest = apk.manifestXml
                if (BaseLibConfig.isVerifyDistributionChannelBeforeUpgradeInstall) {
                    val ch = getMetaData(manifest, "DISTRIBUTION_CHANNEL")
                    if (ch != AppAttrUtils.distributionChannel()) {
                        logger.warn("apk distribution channel mismatch [{} vs {}]", ch, AppAttrUtils.distributionChannel())
                        return Pair(4, ch)
                    }
                }
                val myType = AppAttrUtils.appType()
                val apkType = getMetaData(manifest, "APP_TYPE")
                if (myType == "mobile") {
                    if (apkType != "mobile") {
                        logger.warn("apk type mismatch [{} vs {}]", apkType, myType)
                        return Pair(5, apkType)
                    }
                } else if (apkType == "mobile") {
                    logger.warn("apk type mismatch [{} vs {}]", apkType, myType)
                    return Pair(5, apkType)
                }
                null
            }
        } catch (t: Throwable) {
            logger.error("verify app failure", t)
            null
        }
    }

    /** Original: m0.h(String, String) — procura `<meta-data android:name=key android:value=...>` */
    private fun getMetaData(manifestXml: String?, key: String): String? {
        if (manifestXml == null) return ""
        val factory = DocumentBuilderFactory.newInstance().apply { isIgnoringElementContentWhitespace = false }
        val doc = factory.newDocumentBuilder().parse(ByteArrayInputStream(manifestXml.toByteArray(Charsets.UTF_8)))
        val nodes = doc.getElementsByTagName("meta-data")
        for (i in 0 until nodes.length) {
            val attrs = nodes.item(i).attributes
            val name = attrs.getNamedItem("android:name")
            if (name != null && TextUtils.equals(key, name.nodeValue)) {
                attrs.getNamedItem("android:value")?.let { return it.nodeValue }
            }
        }
        return ""
    }

    /** Original: m0.c(Context, File) */
    private fun buildInstallIntent(context: Context, file: File): Intent = when {
        Build.VERSION.SDK_INT >= 26 -> buildIntentO(context, file)
        Build.VERSION.SDK_INT >= 24 -> buildIntentN(context, file)
        else -> Intent("android.intent.action.VIEW").apply {               // m0.d
            setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive")
        }
    }

    /** Original: m0.e */
    private fun buildIntentN(context: Context, file: File): Intent {
        val uri = FileProvider.getUriForFile(context, context.packageName + ".fileProvider", file)
        return Intent("android.intent.action.VIEW").apply {
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            setDataAndType(uri, "application/vnd.android.package-archive")
        }
    }

    /** Original: m0.f (idêntico a m0.e) */
    @RequiresApi(26)
    private fun buildIntentO(context: Context, file: File): Intent = buildIntentN(context, file)

    /** Original: m0.a(Context) — app instalado como sistema (FLAG_SYSTEM)? */
    fun isSelfSystemApp(context: Context): Boolean = isSystemApp(context, context.packageName)

    /** Original: m0.j(Context, String) — usa StubApp.getOrigApplicationContext (packer Jiagu). */
    fun isSystemApp(context: Context, packageName: String): Boolean = try {
        val ctx = com.stub.StubApp.getOrigApplicationContext(context.applicationContext)
        val ai = ctx.packageManager.getPackageInfo(packageName, 0).applicationInfo
        ((ai?.flags ?: 0) and 1) != 0
    } catch (e: PackageManager.NameNotFoundException) {
        logger.error("can't find package $packageName", e)
        false
    }

    /** Original: m0.k(Context) — uid == 1000 (android.uid.system)? */
    fun isSystemUid(context: Context): Boolean = try {
        1000 == context.packageManager.getApplicationInfo(BaseLibConfig.applicationId, 0).uid
    } catch (_: Exception) {
        false // TODO: o jadx omitiu o retorno do catch; assumido false
    }

    /** Original: m0.b(Context, File) — avisa (toast) se espaço livre < 3× tamanho do APK. */
    fun checkSpace(context: Context, file: File) {
        try {
            val available = StoragePaths.availableBytes()
            val need = file.length() * 3
            if (available < need) {
                logger.warn("Storage space is running low! apk size[{}] * 3 > available[{}] of total[{}]", need, available, StoragePaths.totalBytes())
                Toasts.show(context.getString(R.string.not_enough_space_to_upgrade))
            }
        } catch (t: Throwable) {
            logger.error("check upgrade space failure", t)
        }
    }

    /** Original: m0.g(Context, String) */
    fun pmInstallCommand(context: Context, apkPath: String): String =
        if (Build.VERSION.SDK_INT == 24) "pm install -r -i ${context.packageName} --user 0 $apkPath"
        else "pm install -r -i ${context.packageName} $apkPath"

    /** Original: m0.i(Context, String) */
    fun install(context: Context, filePath: String): Boolean {
        val file = File(filePath)
        if (verifyApkMeta(file) != null) {
            Toasts.show(context.getString(R.string.upgrade_file_mismatch))
            return false
        }
        checkSpace(context, file)
        if (!isSystemUid(context)) {
            ShellUtils.exec("chmod 777 $filePath")
            return try {
                context.startActivity(buildInstallIntent(context, File(filePath)).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
                true
            } catch (e: Exception) {
                logger.warn("install failure", e)
                false
            }
        }
        if (Build.VERSION.SDK_INT < 26) {
            val ok = ShellUtils.exec(pmInstallCommand(context, filePath), withSu = false)
            if (BaseLibConfig.isDebug) logger.debug("install $filePath by command ret $ok")
            return ok
        }
        val pim = PackageInstallManager(context)
        val ok = pim.silentInstallByPackageName(filePath, "")
        pim.destroy()
        if (BaseLibConfig.isDebug) logger.debug("install $filePath by install session ret $ok")
        return ok
    }
}
