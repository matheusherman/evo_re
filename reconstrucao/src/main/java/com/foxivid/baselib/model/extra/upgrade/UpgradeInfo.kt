package com.foxivid.baselib.model.extra.upgrade

import com.foxivid.baselib.model.common.BaseModel

/**
 * Configuração de atualização do APK (GET /api/v1/upgrade/config).
 * Original: z1/b1/lb/m/extra/upgrade/UpgradeInfo.java.
 */
class UpgradeInfo : BaseModel() {
    var checksum: String? = null
    var delayTime: Int = 0
    var digestAlgorithm: String? = null
    var forceUpgrade: Int = 0
    var message: String? = null
    var size: Long = 0
    var upgradeStatus: Int = 0
    var url: String? = null
    var versionName: String? = null
}
