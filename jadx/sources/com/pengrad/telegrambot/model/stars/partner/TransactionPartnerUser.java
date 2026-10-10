package com.pengrad.telegrambot.model.stars.partner;

import com.pengrad.telegrambot.model.User;
import com.pengrad.telegrambot.model.gift.Gift;
import com.pengrad.telegrambot.model.paidmedia.PaidMedia;
import com.pengrad.telegrambot.model.stars.affiliate.AffiliateInfo;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0012J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0016\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010$\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u0018Jz\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0096\u0002J\b\u0010,\u001a\u00020\u000eH\u0016J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0013R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0014R\u0015\u0010\b\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0015R\u001d\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0007¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\t\u0010\u0016R\u0015\u0010\f\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0015R\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0011\u0010\u0018R\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\r\u0010\u0018R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u001c¨\u0006."}, d2 = {"Lcom/pengrad/telegrambot/model/stars/partner/TransactionPartnerUser;", "Lcom/pengrad/telegrambot/model/stars/partner/TransactionPartner;", "transactionType", "", "user", "Lcom/pengrad/telegrambot/model/User;", "affiliate", "Lcom/pengrad/telegrambot/model/stars/affiliate/AffiliateInfo;", "invoicePayload", "paidMedia", "", "Lcom/pengrad/telegrambot/model/paidmedia/PaidMedia;", "paidMediaPayload", "subscriptionPeriod", "", "gift", "Lcom/pengrad/telegrambot/model/gift/Gift;", "premiumSubscriptionDuration", "(Ljava/lang/String;Lcom/pengrad/telegrambot/model/User;Lcom/pengrad/telegrambot/model/stars/affiliate/AffiliateInfo;Ljava/lang/String;[Lcom/pengrad/telegrambot/model/paidmedia/PaidMedia;Ljava/lang/String;Ljava/lang/Integer;Lcom/pengrad/telegrambot/model/gift/Gift;Ljava/lang/Integer;)V", "()Lcom/pengrad/telegrambot/model/stars/affiliate/AffiliateInfo;", "()Lcom/pengrad/telegrambot/model/gift/Gift;", "()Ljava/lang/String;", "()[Lcom/pengrad/telegrambot/model/paidmedia/PaidMedia;", "[Lcom/pengrad/telegrambot/model/paidmedia/PaidMedia;", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", IjkMediaMeta.IJKM_KEY_TYPE, "getType", "()Lcom/pengrad/telegrambot/model/User;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lcom/pengrad/telegrambot/model/User;Lcom/pengrad/telegrambot/model/stars/affiliate/AffiliateInfo;Ljava/lang/String;[Lcom/pengrad/telegrambot/model/paidmedia/PaidMedia;Ljava/lang/String;Ljava/lang/Integer;Lcom/pengrad/telegrambot/model/gift/Gift;Ljava/lang/Integer;)Lcom/pengrad/telegrambot/model/stars/partner/TransactionPartnerUser;", "equals", "", TransactionPartnerType.OTHER, "", "hashCode", "toString", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class TransactionPartnerUser implements TransactionPartner {
    private final AffiliateInfo affiliate;
    private final Gift gift;
    private final String invoicePayload;
    private final PaidMedia[] paidMedia;
    private final String paidMediaPayload;
    private final Integer premiumSubscriptionDuration;
    private final Integer subscriptionPeriod;
    private final String transactionType;
    private final User user;

    public TransactionPartnerUser(String transactionType, User user, AffiliateInfo affiliate, String str, PaidMedia[] paidMediaArr, String str2, Integer num, Gift gift, Integer num2) {
        m.f(transactionType, "transactionType");
        m.f(user, "user");
        m.f(affiliate, "affiliate");
        this.transactionType = transactionType;
        this.user = user;
        this.affiliate = affiliate;
        this.invoicePayload = str;
        this.paidMedia = paidMediaArr;
        this.paidMediaPayload = str2;
        this.subscriptionPeriod = num;
        this.gift = gift;
        this.premiumSubscriptionDuration = num2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!m.a(TransactionPartnerUser.class, other != null ? other.getClass() : null)) {
            return false;
        }
        m.d(other, "null cannot be cast to non-null type com.pengrad.telegrambot.model.stars.partner.TransactionPartnerUser");
        TransactionPartnerUser transactionPartnerUser = (TransactionPartnerUser) other;
        if (!m.a(this.subscriptionPeriod, transactionPartnerUser.subscriptionPeriod) || !m.a(this.transactionType, transactionPartnerUser.transactionType) || !m.a(this.user, transactionPartnerUser.user) || !m.a(this.affiliate, transactionPartnerUser.affiliate) || !m.a(this.invoicePayload, transactionPartnerUser.invoicePayload)) {
            return false;
        }
        PaidMedia[] paidMediaArr = this.paidMedia;
        if (paidMediaArr != null) {
            PaidMedia[] paidMediaArr2 = transactionPartnerUser.paidMedia;
            if (paidMediaArr2 == null || !Arrays.equals(paidMediaArr, paidMediaArr2)) {
                return false;
            }
        } else if (transactionPartnerUser.paidMedia != null) {
            return false;
        }
        return m.a(this.paidMediaPayload, transactionPartnerUser.paidMediaPayload) && m.a(this.gift, transactionPartnerUser.gift) && m.a(this.premiumSubscriptionDuration, transactionPartnerUser.premiumSubscriptionDuration) && m.a(getType(), transactionPartnerUser.getType());
    }

    public static /* synthetic */ TransactionPartnerUser copy$default(TransactionPartnerUser transactionPartnerUser, String str, User user, AffiliateInfo affiliateInfo, String str2, PaidMedia[] paidMediaArr, String str3, Integer num, Gift gift, Integer num2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = transactionPartnerUser.transactionType;
        }
        if ((i10 & 2) != 0) {
            user = transactionPartnerUser.user;
        }
        if ((i10 & 4) != 0) {
            affiliateInfo = transactionPartnerUser.affiliate;
        }
        if ((i10 & 8) != 0) {
            str2 = transactionPartnerUser.invoicePayload;
        }
        if ((i10 & 16) != 0) {
            paidMediaArr = transactionPartnerUser.paidMedia;
        }
        if ((i10 & 32) != 0) {
            str3 = transactionPartnerUser.paidMediaPayload;
        }
        if ((i10 & 64) != 0) {
            num = transactionPartnerUser.subscriptionPeriod;
        }
        if ((i10 & 128) != 0) {
            gift = transactionPartnerUser.gift;
        }
        if ((i10 & 256) != 0) {
            num2 = transactionPartnerUser.premiumSubscriptionDuration;
        }
        Gift gift2 = gift;
        Integer num3 = num2;
        String str4 = str3;
        Integer num4 = num;
        PaidMedia[] paidMediaArr2 = paidMediaArr;
        AffiliateInfo affiliateInfo2 = affiliateInfo;
        return transactionPartnerUser.copy(str, user, affiliateInfo2, str2, paidMediaArr2, str4, num4, gift2, num3);
    }

    /* JADX INFO: renamed from: affiliate, reason: from getter */
    public final AffiliateInfo getAffiliate() {
        return this.affiliate;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTransactionType() {
        return this.transactionType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    public final AffiliateInfo component3() {
        return this.affiliate;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getInvoicePayload() {
        return this.invoicePayload;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final PaidMedia[] getPaidMedia() {
        return this.paidMedia;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPaidMediaPayload() {
        return this.paidMediaPayload;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getSubscriptionPeriod() {
        return this.subscriptionPeriod;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Gift getGift() {
        return this.gift;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getPremiumSubscriptionDuration() {
        return this.premiumSubscriptionDuration;
    }

    public final TransactionPartnerUser copy(String transactionType, User user, AffiliateInfo affiliate, String invoicePayload, PaidMedia[] paidMedia, String paidMediaPayload, Integer subscriptionPeriod, Gift gift, Integer premiumSubscriptionDuration) {
        m.f(transactionType, "transactionType");
        m.f(user, "user");
        m.f(affiliate, "affiliate");
        return new TransactionPartnerUser(transactionType, user, affiliate, invoicePayload, paidMedia, paidMediaPayload, subscriptionPeriod, gift, premiumSubscriptionDuration);
    }

    @Override // com.pengrad.telegrambot.model.stars.partner.TransactionPartner
    public String getType() {
        return "user";
    }

    public final Gift gift() {
        return this.gift;
    }

    public int hashCode() {
        Integer num = this.subscriptionPeriod;
        int iIntValue = (((((((num != null ? num.intValue() : 0) * 31) + this.transactionType.hashCode()) * 31) + this.user.hashCode()) * 31) + this.affiliate.hashCode()) * 31;
        String str = this.invoicePayload;
        int iHashCode = (iIntValue + (str != null ? str.hashCode() : 0)) * 31;
        PaidMedia[] paidMediaArr = this.paidMedia;
        int iHashCode2 = (iHashCode + (paidMediaArr != null ? Arrays.hashCode(paidMediaArr) : 0)) * 31;
        String str2 = this.paidMediaPayload;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Gift gift = this.gift;
        int iHashCode4 = (iHashCode3 + (gift != null ? gift.hashCode() : 0)) * 31;
        Integer num2 = this.premiumSubscriptionDuration;
        return ((iHashCode4 + (num2 != null ? num2.hashCode() : 0)) * 31) + getType().hashCode();
    }

    public final String invoicePayload() {
        return this.invoicePayload;
    }

    public final PaidMedia[] paidMedia() {
        return this.paidMedia;
    }

    public final String paidMediaPayload() {
        return this.paidMediaPayload;
    }

    public final Integer premiumSubscriptionDuration() {
        return this.premiumSubscriptionDuration;
    }

    public final Integer subscriptionPeriod() {
        return this.subscriptionPeriod;
    }

    public String toString() {
        return "TransactionPartnerUser(transactionType=" + this.transactionType + ", user=" + this.user + ", affiliate=" + this.affiliate + ", invoicePayload=" + this.invoicePayload + ", paidMedia=" + Arrays.toString(this.paidMedia) + ", paidMediaPayload=" + this.paidMediaPayload + ", subscriptionPeriod=" + this.subscriptionPeriod + ", gift=" + this.gift + ", premiumSubscriptionDuration=" + this.premiumSubscriptionDuration + ')';
    }

    public final String transactionType() {
        return this.transactionType;
    }

    public final User user() {
        return this.user;
    }

    public /* synthetic */ TransactionPartnerUser(String str, User user, AffiliateInfo affiliateInfo, String str2, PaidMedia[] paidMediaArr, String str3, Integer num, Gift gift, Integer num2, int i10, g gVar) {
        this(str, user, affiliateInfo, (i10 & 8) != 0 ? null : str2, (i10 & 16) != 0 ? null : paidMediaArr, (i10 & 32) != 0 ? null : str3, (i10 & 64) != 0 ? null : num, (i10 & 128) != 0 ? null : gift, (i10 & 256) != 0 ? null : num2);
    }
}
