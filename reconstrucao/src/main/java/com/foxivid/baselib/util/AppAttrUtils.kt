package com.foxivid.baselib.util

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build
import com.foxivid.baselib.config.BaseLibConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Atributos do app lidos do `<meta-data>` do manifest e do PackageInfo:
 * `DISTRIBUTION_CHANNEL`, `APP_TYPE` (padrão "stb"), `TENANT_ID`, `BRAND_ID`, `APP_ID`,
 * versionCode/versionName e packageName. É o "resolvedor de tipo de app".
 * Original: x1/f1/lb/util/k.java (nome Kotlin original `AppAttrUtils`, arquivo `AppAttrUtils.kt`).
 */
object AppAttrUtils {
    private val logger: Logger = LoggerFactory.getLogger(AppAttrUtils::class.java)

    private var appDistributionChannel = ""
    private var appType = ""
    private var appId = 0
    private var appVersion = 0L
    private var appVersionName = ""
    private var brandId = 0
    private var tenantId = 0
    private var packageName = ""

    /** Lê os atributos em IO. Original: `k.w(Context, Continuation)` (corrotina `AppAttrUtils$init$2`). */
    suspend fun init(context: Context) = withContext(Dispatchers.IO) {
        try {
            val sdk = Build.VERSION.SDK_INT
            val ai: ApplicationInfo = if (sdk >= 33) {
                context.packageManager.getApplicationInfo(context.packageName, PackageManager.ApplicationInfoFlags.of(128L))
            } else {
                context.packageManager.getApplicationInfo(context.packageName, PackageManager.GET_META_DATA)
            }
            appDistributionChannel = ai.metaData.getString("DISTRIBUTION_CHANNEL") ?: appDistributionChannel
            appType = ai.metaData.getString("APP_TYPE") ?: "stb"
            tenantId = ai.metaData.getInt("TENANT_ID")
            brandId = ai.metaData.getInt("BRAND_ID")
            appId = ai.metaData.getInt("APP_ID")
            packageName = context.packageName
            val pi: PackageInfo = if (sdk >= 33) {
                context.packageManager.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(0L))
            } else {
                context.packageManager.getPackageInfo(packageName, 0)
            }
            appVersion = if (sdk >= 28) pi.longVersionCode else @Suppress("DEPRECATION") pi.versionCode.toLong()
            appVersionName = pi.versionName ?: ""
            if (BaseLibConfig.isDebug) {
                logger.debug(
                    "App attr init, [ {} - {} - {} - {} - {} - {} - {} ]",
                    appDistributionChannel, tenantId, brandId, appId, appType, appVersion, appVersionName,
                ) // ordem confirmada no decompile em modo fallback: canal, tenant, brand, appId, appType, versionCode, versionName
            }
        } catch (e: PackageManager.NameNotFoundException) {
            logger.error("get app distribution channel failure", e)
        }
    }

    /** Original: `k.q()`. */ fun appId(): Int = appId
    /** Ex.: "stb", "mobile". Original: `k.r()`. */ fun appType(): String = appType
    /** Original: `k.s()`. */ fun appVersion(): Long = appVersion
    /** Original: `k.t()`. */ fun appVersionName(): String = appVersionName
    /** Original: `k.u()`. */ fun brandId(): Int = brandId
    /** Original: `k.v()`. */ fun distributionChannel(): String = appDistributionChannel
    /** Original: `k.x()`. */ fun packageName(): String = packageName
    /** Original: `k.y()`. */ fun tenantId(): Int = tenantId
}
