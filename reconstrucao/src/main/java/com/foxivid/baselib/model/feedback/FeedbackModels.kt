package com.foxivid.baselib.model.feedback

import androidx.annotation.Keep
import com.foxivid.baselib.model.extra.ApiRequestBasic
import com.google.gson.annotations.SerializedName

/** Original: z1/b1/lb/m/feedback/FeedbackData.java (campos ofuscados). */
class FeedbackData {
    @SerializedName("a") var issueId: String? = null
    @SerializedName("b") var issueDesc: String? = null
    @SerializedName("c") var seq: String? = null
}

/** Original: z1/b1/lb/m/feedback/FeedbackUpdateRequest.java. */
class FeedbackUpdateRequest : ApiRequestBasic() {
    var channelId: String? = null
    var issueId: String? = null
    var reportInfo: String? = null
}

/** Resposta do upload de feedback. Original: z1/b1/lb/m/feedback/FeedbackUploadResponse.java (data class). */
data class FeedbackUploadResponse(
    @Keep val code: String,
    @Keep val message: String?,
    @Keep val data: Any?,
)
