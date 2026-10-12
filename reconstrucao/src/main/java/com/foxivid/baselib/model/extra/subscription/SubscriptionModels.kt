package com.foxivid.baselib.model.extra.subscription

import com.foxivid.baselib.model.common.BaseModel
import com.foxivid.baselib.model.extra.ApiRequestBasic
import com.foxivid.baselib.model.extra.user.AccountSubscription
import com.google.gson.annotations.SerializedName

/** Original: z1/b1/lb/m/extra/subscription/PurchaseHistoryInfo.java (campos ofuscados). */
class PurchaseHistoryInfo {
    @SerializedName("a") var subscribedName: String? = null
    @SerializedName("b") var actualCurrencyPaid: String? = null
    @SerializedName("c") var actualAmountPaid: String? = null
    @SerializedName("d") var paymentStatus: String? = null
    @SerializedName("e") var createdAt: String? = null
}

/** Original: z1/b1/lb/m/extra/subscription/QueryProductListInfo.java. */
class QueryProductListInfo : BaseModel() {
    var amount: Double = 0.0
    var currency: String? = null
    var description: String? = null
    var discountAmount: Double = 0.0
    var discountCurrency: String? = null
    var grDescription: String? = null
    var name: String? = null
    var purchaseLink: String? = null
    var seqNo: Int = 0
    var subName: String? = null
    var subscriptUrl: String? = null
    var validityPeriod: Int = 0
    var validityUnit: String? = null
}

/** Original: z1/b1/lb/m/extra/subscription/QuerySubscriptionListInfo.java (campos ofuscados). */
class QuerySubscriptionListInfo {
    @SerializedName("a") var productId: String? = null
    @SerializedName("b") var expireTs: String? = null
}

/** Original: z1/b1/lb/m/extra/subscription/RechargeInfo.java. */
class RechargeInfo : BaseModel() {
    var accountId: Long = 0
    var accountSubscriptionList: List<AccountSubscription>? = null
}

/** Original: z1/b1/lb/m/extra/subscription/RechargeRequest.java. */
class RechargeRequest(var code: String) : ApiRequestBasic()
