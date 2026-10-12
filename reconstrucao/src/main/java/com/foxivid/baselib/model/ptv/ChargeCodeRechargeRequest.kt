package com.foxivid.baselib.model.ptv.subscription

import com.foxivid.baselib.model.extra.ApiRequestBasic

/** Recarga por código (POST /api/v1/account/recharge). Original: z1/b1/lb/m/ptv/subscription/ChargeCodeRechargeRequest.java. */
class ChargeCodeRechargeRequest(var chargeCode: String) : ApiRequestBasic()
