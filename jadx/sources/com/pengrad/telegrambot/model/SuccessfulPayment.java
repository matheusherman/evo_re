package com.pengrad.telegrambot.model;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J|\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0011R\u0013\u0010\u0006\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0011R\u0017\u0010\n\u001a\u0004\u0018\u00010\t8\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\n\u0010\u0012R\u0017\u0010\b\u001a\u0004\u0018\u00010\t8\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\b\u0010\u0012R\u0015\u0010\f\u001a\u0004\u0018\u00010\r8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0014R\u0013\u0010\u000f\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0011R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0011R\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0007\u0010\u0015R\u0013\u0010\u000e\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0011R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0017¨\u0006("}, d2 = {"Lcom/pengrad/telegrambot/model/SuccessfulPayment;", "", "currency", "", "totalAmount", "", "invoicePayload", "subscriptionExpirationDate", "isRecurring", "", "isFirstRecurring", "shippingOptionId", "orderInfo", "Lcom/pengrad/telegrambot/model/OrderInfo;", "telegramPaymentChargeId", "providerPaymentChargeId", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/pengrad/telegrambot/model/OrderInfo;Ljava/lang/String;Ljava/lang/String;)V", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "()Lcom/pengrad/telegrambot/model/OrderInfo;", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()I", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/pengrad/telegrambot/model/OrderInfo;Ljava/lang/String;Ljava/lang/String;)Lcom/pengrad/telegrambot/model/SuccessfulPayment;", "equals", TransactionPartnerType.OTHER, "hashCode", "toString", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class SuccessfulPayment {
    private final String currency;
    private final String invoicePayload;
    private final Boolean isFirstRecurring;
    private final Boolean isRecurring;
    private final OrderInfo orderInfo;
    private final String providerPaymentChargeId;
    private final String shippingOptionId;
    private final Integer subscriptionExpirationDate;
    private final String telegramPaymentChargeId;
    private final int totalAmount;

    public SuccessfulPayment(String currency, int i10, String invoicePayload, Integer num, Boolean bool, Boolean bool2, String str, OrderInfo orderInfo, String telegramPaymentChargeId, String providerPaymentChargeId) {
        m.f(currency, "currency");
        m.f(invoicePayload, "invoicePayload");
        m.f(telegramPaymentChargeId, "telegramPaymentChargeId");
        m.f(providerPaymentChargeId, "providerPaymentChargeId");
        this.currency = currency;
        this.totalAmount = i10;
        this.invoicePayload = invoicePayload;
        this.subscriptionExpirationDate = num;
        this.isRecurring = bool;
        this.isFirstRecurring = bool2;
        this.shippingOptionId = str;
        this.orderInfo = orderInfo;
        this.telegramPaymentChargeId = telegramPaymentChargeId;
        this.providerPaymentChargeId = providerPaymentChargeId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuccessfulPayment)) {
            return false;
        }
        SuccessfulPayment successfulPayment = (SuccessfulPayment) other;
        return m.a(this.currency, successfulPayment.currency) && this.totalAmount == successfulPayment.totalAmount && m.a(this.invoicePayload, successfulPayment.invoicePayload) && m.a(this.subscriptionExpirationDate, successfulPayment.subscriptionExpirationDate) && m.a(this.isRecurring, successfulPayment.isRecurring) && m.a(this.isFirstRecurring, successfulPayment.isFirstRecurring) && m.a(this.shippingOptionId, successfulPayment.shippingOptionId) && m.a(this.orderInfo, successfulPayment.orderInfo) && m.a(this.telegramPaymentChargeId, successfulPayment.telegramPaymentChargeId) && m.a(this.providerPaymentChargeId, successfulPayment.providerPaymentChargeId);
    }

    public static /* synthetic */ SuccessfulPayment copy$default(SuccessfulPayment successfulPayment, String str, int i10, String str2, Integer num, Boolean bool, Boolean bool2, String str3, OrderInfo orderInfo, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = successfulPayment.currency;
        }
        if ((i11 & 2) != 0) {
            i10 = successfulPayment.totalAmount;
        }
        if ((i11 & 4) != 0) {
            str2 = successfulPayment.invoicePayload;
        }
        if ((i11 & 8) != 0) {
            num = successfulPayment.subscriptionExpirationDate;
        }
        if ((i11 & 16) != 0) {
            bool = successfulPayment.isRecurring;
        }
        if ((i11 & 32) != 0) {
            bool2 = successfulPayment.isFirstRecurring;
        }
        if ((i11 & 64) != 0) {
            str3 = successfulPayment.shippingOptionId;
        }
        if ((i11 & 128) != 0) {
            orderInfo = successfulPayment.orderInfo;
        }
        if ((i11 & 256) != 0) {
            str4 = successfulPayment.telegramPaymentChargeId;
        }
        if ((i11 & 512) != 0) {
            str5 = successfulPayment.providerPaymentChargeId;
        }
        String str6 = str4;
        String str7 = str5;
        String str8 = str3;
        OrderInfo orderInfo2 = orderInfo;
        Boolean bool3 = bool;
        Boolean bool4 = bool2;
        return successfulPayment.copy(str, i10, str2, num, bool3, bool4, str8, orderInfo2, str6, str7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getProviderPaymentChargeId() {
        return this.providerPaymentChargeId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTotalAmount() {
        return this.totalAmount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getInvoicePayload() {
        return this.invoicePayload;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getSubscriptionExpirationDate() {
        return this.subscriptionExpirationDate;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getIsRecurring() {
        return this.isRecurring;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Boolean getIsFirstRecurring() {
        return this.isFirstRecurring;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getShippingOptionId() {
        return this.shippingOptionId;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final OrderInfo getOrderInfo() {
        return this.orderInfo;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getTelegramPaymentChargeId() {
        return this.telegramPaymentChargeId;
    }

    public final SuccessfulPayment copy(String currency, int totalAmount, String invoicePayload, Integer subscriptionExpirationDate, Boolean isRecurring, Boolean isFirstRecurring, String shippingOptionId, OrderInfo orderInfo, String telegramPaymentChargeId, String providerPaymentChargeId) {
        m.f(currency, "currency");
        m.f(invoicePayload, "invoicePayload");
        m.f(telegramPaymentChargeId, "telegramPaymentChargeId");
        m.f(providerPaymentChargeId, "providerPaymentChargeId");
        return new SuccessfulPayment(currency, totalAmount, invoicePayload, subscriptionExpirationDate, isRecurring, isFirstRecurring, shippingOptionId, orderInfo, telegramPaymentChargeId, providerPaymentChargeId);
    }

    public final String currency() {
        return this.currency;
    }

    public int hashCode() {
        int iHashCode = ((((this.currency.hashCode() * 31) + this.totalAmount) * 31) + this.invoicePayload.hashCode()) * 31;
        Integer num = this.subscriptionExpirationDate;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.isRecurring;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isFirstRecurring;
        int iHashCode4 = (iHashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str = this.shippingOptionId;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        OrderInfo orderInfo = this.orderInfo;
        return ((((iHashCode5 + (orderInfo != null ? orderInfo.hashCode() : 0)) * 31) + this.telegramPaymentChargeId.hashCode()) * 31) + this.providerPaymentChargeId.hashCode();
    }

    public final String invoicePayload() {
        return this.invoicePayload;
    }

    public final Boolean isFirstRecurring() {
        return this.isFirstRecurring;
    }

    public final Boolean isRecurring() {
        return this.isRecurring;
    }

    public final OrderInfo orderInfo() {
        return this.orderInfo;
    }

    public final String providerPaymentChargeId() {
        return this.providerPaymentChargeId;
    }

    public final String shippingOptionId() {
        return this.shippingOptionId;
    }

    public final Integer subscriptionExpirationDate() {
        return this.subscriptionExpirationDate;
    }

    public final String telegramPaymentChargeId() {
        return this.telegramPaymentChargeId;
    }

    public String toString() {
        return "SuccessfulPayment(currency=" + this.currency + ", totalAmount=" + this.totalAmount + ", invoicePayload=" + this.invoicePayload + ", subscriptionExpirationDate=" + this.subscriptionExpirationDate + ", isRecurring=" + this.isRecurring + ", isFirstRecurring=" + this.isFirstRecurring + ", shippingOptionId=" + this.shippingOptionId + ", orderInfo=" + this.orderInfo + ", telegramPaymentChargeId=" + this.telegramPaymentChargeId + ", providerPaymentChargeId=" + this.providerPaymentChargeId + ')';
    }

    public final int totalAmount() {
        return this.totalAmount;
    }

    public /* synthetic */ SuccessfulPayment(String str, int i10, String str2, Integer num, Boolean bool, Boolean bool2, String str3, OrderInfo orderInfo, String str4, String str5, int i11, g gVar) {
        this(str, i10, str2, (i11 & 8) != 0 ? null : num, (i11 & 16) != 0 ? null : bool, (i11 & 32) != 0 ? null : bool2, (i11 & 64) != 0 ? null : str3, (i11 & 128) != 0 ? null : orderInfo, str4, str5);
    }
}
