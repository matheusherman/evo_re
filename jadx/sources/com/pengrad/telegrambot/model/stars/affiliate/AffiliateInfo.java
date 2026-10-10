package com.pengrad.telegrambot.model.stars.affiliate;

import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.User;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJF\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0013\u0010\b\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\rR\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0017\u0010\t\u001a\u0004\u0018\u00010\u00078\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\t\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/pengrad/telegrambot/model/stars/affiliate/AffiliateInfo;", "", "affiliateUser", "Lcom/pengrad/telegrambot/model/User;", "affiliateChat", "Lcom/pengrad/telegrambot/model/Chat;", "commissionPerMille", "", "amount", "nanostarAmount", "(Lcom/pengrad/telegrambot/model/User;Lcom/pengrad/telegrambot/model/Chat;IILjava/lang/Integer;)V", "()Lcom/pengrad/telegrambot/model/Chat;", "()Lcom/pengrad/telegrambot/model/User;", "()I", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/pengrad/telegrambot/model/User;Lcom/pengrad/telegrambot/model/Chat;IILjava/lang/Integer;)Lcom/pengrad/telegrambot/model/stars/affiliate/AffiliateInfo;", "equals", "", TransactionPartnerType.OTHER, "hashCode", "toString", "", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class AffiliateInfo {
    private final Chat affiliateChat;
    private final User affiliateUser;
    private final int amount;
    private final int commissionPerMille;
    private final Integer nanostarAmount;

    public AffiliateInfo(User user, Chat chat, int i10, int i11, Integer num) {
        this.affiliateUser = user;
        this.affiliateChat = chat;
        this.commissionPerMille = i10;
        this.amount = i11;
        this.nanostarAmount = num;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AffiliateInfo)) {
            return false;
        }
        AffiliateInfo affiliateInfo = (AffiliateInfo) other;
        return m.a(this.affiliateUser, affiliateInfo.affiliateUser) && m.a(this.affiliateChat, affiliateInfo.affiliateChat) && this.commissionPerMille == affiliateInfo.commissionPerMille && this.amount == affiliateInfo.amount && m.a(this.nanostarAmount, affiliateInfo.nanostarAmount);
    }

    public static /* synthetic */ AffiliateInfo copy$default(AffiliateInfo affiliateInfo, User user, Chat chat, int i10, int i11, Integer num, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            user = affiliateInfo.affiliateUser;
        }
        if ((i12 & 2) != 0) {
            chat = affiliateInfo.affiliateChat;
        }
        if ((i12 & 4) != 0) {
            i10 = affiliateInfo.commissionPerMille;
        }
        if ((i12 & 8) != 0) {
            i11 = affiliateInfo.amount;
        }
        if ((i12 & 16) != 0) {
            num = affiliateInfo.nanostarAmount;
        }
        Integer num2 = num;
        int i13 = i10;
        return affiliateInfo.copy(user, chat, i13, i11, num2);
    }

    /* JADX INFO: renamed from: affiliateChat, reason: from getter */
    public final Chat getAffiliateChat() {
        return this.affiliateChat;
    }

    /* JADX INFO: renamed from: affiliateUser, reason: from getter */
    public final User getAffiliateUser() {
        return this.affiliateUser;
    }

    /* JADX INFO: renamed from: amount, reason: from getter */
    public final int getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: commissionPerMille, reason: from getter */
    public final int getCommissionPerMille() {
        return this.commissionPerMille;
    }

    public final User component1() {
        return this.affiliateUser;
    }

    public final Chat component2() {
        return this.affiliateChat;
    }

    public final int component3() {
        return this.commissionPerMille;
    }

    public final int component4() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getNanostarAmount() {
        return this.nanostarAmount;
    }

    public final AffiliateInfo copy(User affiliateUser, Chat affiliateChat, int commissionPerMille, int amount, Integer nanostarAmount) {
        return new AffiliateInfo(affiliateUser, affiliateChat, commissionPerMille, amount, nanostarAmount);
    }

    public int hashCode() {
        User user = this.affiliateUser;
        int iHashCode = (user == null ? 0 : user.hashCode()) * 31;
        Chat chat = this.affiliateChat;
        int iHashCode2 = (((((iHashCode + (chat == null ? 0 : chat.hashCode())) * 31) + this.commissionPerMille) * 31) + this.amount) * 31;
        Integer num = this.nanostarAmount;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public final Integer nanostarAmount() {
        return this.nanostarAmount;
    }

    public String toString() {
        return "AffiliateInfo(affiliateUser=" + this.affiliateUser + ", affiliateChat=" + this.affiliateChat + ", commissionPerMille=" + this.commissionPerMille + ", amount=" + this.amount + ", nanostarAmount=" + this.nanostarAmount + ')';
    }

    public /* synthetic */ AffiliateInfo(User user, Chat chat, int i10, int i11, Integer num, int i12, g gVar) {
        this((i12 & 1) != 0 ? null : user, (i12 & 2) != 0 ? null : chat, i10, i11, (i12 & 16) != 0 ? null : num);
    }
}
