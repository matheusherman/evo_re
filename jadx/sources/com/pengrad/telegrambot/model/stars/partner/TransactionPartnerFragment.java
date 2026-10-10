package com.pengrad.telegrambot.model.stars.partner;

import com.pengrad.telegrambot.model.stars.withdrawal.RevenueWithdrawalState;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0006HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/pengrad/telegrambot/model/stars/partner/TransactionPartnerFragment;", "Lcom/pengrad/telegrambot/model/stars/partner/TransactionPartner;", "withdrawalState", "Lcom/pengrad/telegrambot/model/stars/withdrawal/RevenueWithdrawalState;", "(Lcom/pengrad/telegrambot/model/stars/withdrawal/RevenueWithdrawalState;)V", IjkMediaMeta.IJKM_KEY_TYPE, "", "getType", "()Ljava/lang/String;", "()Lcom/pengrad/telegrambot/model/stars/withdrawal/RevenueWithdrawalState;", "component1", "copy", "equals", "", TransactionPartnerType.OTHER, "", "hashCode", "", "toString", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class TransactionPartnerFragment implements TransactionPartner {
    private final RevenueWithdrawalState withdrawalState;

    /* JADX WARN: Multi-variable type inference failed */
    public TransactionPartnerFragment() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TransactionPartnerFragment) && m.a(this.withdrawalState, ((TransactionPartnerFragment) other).withdrawalState);
    }

    public TransactionPartnerFragment(RevenueWithdrawalState revenueWithdrawalState) {
        this.withdrawalState = revenueWithdrawalState;
    }

    public static /* synthetic */ TransactionPartnerFragment copy$default(TransactionPartnerFragment transactionPartnerFragment, RevenueWithdrawalState revenueWithdrawalState, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            revenueWithdrawalState = transactionPartnerFragment.withdrawalState;
        }
        return transactionPartnerFragment.copy(revenueWithdrawalState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final RevenueWithdrawalState getWithdrawalState() {
        return this.withdrawalState;
    }

    public final TransactionPartnerFragment copy(RevenueWithdrawalState withdrawalState) {
        return new TransactionPartnerFragment(withdrawalState);
    }

    @Override // com.pengrad.telegrambot.model.stars.partner.TransactionPartner
    public String getType() {
        return TransactionPartnerType.FRAGMENT;
    }

    public int hashCode() {
        RevenueWithdrawalState revenueWithdrawalState = this.withdrawalState;
        if (revenueWithdrawalState == null) {
            return 0;
        }
        return revenueWithdrawalState.hashCode();
    }

    public String toString() {
        return "TransactionPartnerFragment(withdrawalState=" + this.withdrawalState + ')';
    }

    public final RevenueWithdrawalState withdrawalState() {
        return this.withdrawalState;
    }

    public /* synthetic */ TransactionPartnerFragment(RevenueWithdrawalState revenueWithdrawalState, int i10, g gVar) {
        this((i10 & 1) != 0 ? null : revenueWithdrawalState);
    }
}
