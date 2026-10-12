package com.foxivid.baselib.model.notice

import com.foxivid.baselib.model.extra.ApiRequestBasic
import com.google.gson.annotations.SerializedName

/* Central de mensagens. Pacote original: z1/b1/lb/m/notice. A interface de API correspondente
 * (api/g, MessageApi) está vazia no APK — estes modelos parecem não ser usados em rede. */

/** Original: NotificationData.java (campos ofuscados). */
class NotificationData {
    @SerializedName("a") var id: Int = 0
    @SerializedName("b") var seq: Int = 0
    @SerializedName("c") var lang: String? = null
    @SerializedName("d") var title: String? = null
    @SerializedName("e") var content: String? = null
    @SerializedName("f") var createTime: Long = 0
    @SerializedName("g") var state: Int = 0
}

/** Original: NotificationListRequest.java. */
class NotificationListRequest : ApiRequestBasic() {
    var accountId: String? = null
    var username: String? = null
}

/** Original: NotificationResponse.java (campos ofuscados). */
class NotificationResponse {
    @SerializedName("a") var notificationList: List<NotificationData>? = null
    @SerializedName("b") var notificationState: Map<Int, Int>? = null
}

/** Original: NotificationStateRequest.java. */
class NotificationStateRequest : ApiRequestBasic() {
    var accountId: String? = null
    var notificationId: Int = 0
    var state: Int = 0
}

/** Original: NotificationStateResponse.java (campo ofuscado; getter `isUpdateRes`). */
class NotificationStateResponse {
    @SerializedName("a") var isUpdateRes: Boolean = false
}
