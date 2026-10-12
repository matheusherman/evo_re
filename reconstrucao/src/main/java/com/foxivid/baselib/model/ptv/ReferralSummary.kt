package com.foxivid.baselib.model.ptv.referral

import com.google.gson.annotations.SerializedName

/**
 * Resumo do programa de indicação (GET /api/v1/referral/summary).
 * Original: z1/b1/lb/m/ptv/referral/ReferralSummary.java — campos ofuscados pelo R8, portanto o
 * Gson espera as chaves "a".."h" (o JSON real do servidor provavelmente usa os nomes legíveis,
 * o que deixaria o objeto vazio no app — achado da análise).
 */
data class ReferralSummary(
    @SerializedName("a") var invitationCode: String? = null,
    @SerializedName("b") var invitationLink: String? = null,
    @SerializedName("c") var invitationQrCodeUrl: String? = null,
    @SerializedName("d") var availableBalance: Double = 0.0,
    @SerializedName("e") var pendingBalance: Double = 0.0,
    @SerializedName("f") var frozenBalance: Double = 0.0,
    @SerializedName("g") var withdrawMinAmount: Double = 0.0,
    @SerializedName("h") var activityEnabled: Boolean = false,
)
