package com.pengrad.telegrambot.model.stars.partner;

import com.pengrad.telegrambot.model.User;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/pengrad/telegrambot/model/stars/partner/TransactionPartnerAffiliateProgram;", "Lcom/pengrad/telegrambot/model/stars/partner/TransactionPartner;", "sponsorUser", "Lcom/pengrad/telegrambot/model/User;", "commissionPerMille", "", "(Lcom/pengrad/telegrambot/model/User;I)V", "()I", "()Lcom/pengrad/telegrambot/model/User;", IjkMediaMeta.IJKM_KEY_TYPE, "", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", TransactionPartnerType.OTHER, "", "hashCode", "toString", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class TransactionPartnerAffiliateProgram implements TransactionPartner {
    private final int commissionPerMille;
    private final User sponsorUser;

    public TransactionPartnerAffiliateProgram(User user, int i10) {
        this.sponsorUser = user;
        this.commissionPerMille = i10;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransactionPartnerAffiliateProgram)) {
            return false;
        }
        TransactionPartnerAffiliateProgram transactionPartnerAffiliateProgram = (TransactionPartnerAffiliateProgram) other;
        return m.a(this.sponsorUser, transactionPartnerAffiliateProgram.sponsorUser) && this.commissionPerMille == transactionPartnerAffiliateProgram.commissionPerMille;
    }

    public static /* synthetic */ TransactionPartnerAffiliateProgram copy$default(TransactionPartnerAffiliateProgram transactionPartnerAffiliateProgram, User user, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            user = transactionPartnerAffiliateProgram.sponsorUser;
        }
        if ((i11 & 2) != 0) {
            i10 = transactionPartnerAffiliateProgram.commissionPerMille;
        }
        return transactionPartnerAffiliateProgram.copy(user, i10);
    }

    /* JADX INFO: renamed from: commissionPerMille, reason: from getter */
    public final int getCommissionPerMille() {
        return this.commissionPerMille;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getSponsorUser() {
        return this.sponsorUser;
    }

    public final int component2() {
        return this.commissionPerMille;
    }

    public final TransactionPartnerAffiliateProgram copy(User sponsorUser, int commissionPerMille) {
        return new TransactionPartnerAffiliateProgram(sponsorUser, commissionPerMille);
    }

    @Override // com.pengrad.telegrambot.model.stars.partner.TransactionPartner
    public String getType() {
        return TransactionPartnerType.AFFILIATE_PROGRAM;
    }

    public int hashCode() {
        User user = this.sponsorUser;
        return ((user == null ? 0 : user.hashCode()) * 31) + this.commissionPerMille;
    }

    public final User sponsorUser() {
        return this.sponsorUser;
    }

    public String toString() {
        return "TransactionPartnerAffiliateProgram(sponsorUser=" + this.sponsorUser + ", commissionPerMille=" + this.commissionPerMille + ')';
    }

    public /* synthetic */ TransactionPartnerAffiliateProgram(User user, int i10, int i11, g gVar) {
        this((i11 & 1) != 0 ? null : user, i10);
    }
}
