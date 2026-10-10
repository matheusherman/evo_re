package com.pengrad.telegrambot.model.stars;

import androidx.collection.a;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/pengrad/telegrambot/model/stars/StarAmount;", "", "amount", "", "nanostarAmount", "", "(IJ)V", "()I", "()J", "component1", "component2", "copy", "equals", "", TransactionPartnerType.OTHER, "hashCode", "toString", "", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class StarAmount {
    private final int amount;
    private final long nanostarAmount;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StarAmount)) {
            return false;
        }
        StarAmount starAmount = (StarAmount) other;
        return this.amount == starAmount.amount && this.nanostarAmount == starAmount.nanostarAmount;
    }

    public static /* synthetic */ StarAmount copy$default(StarAmount starAmount, int i10, long j10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = starAmount.amount;
        }
        if ((i11 & 2) != 0) {
            j10 = starAmount.nanostarAmount;
        }
        return starAmount.copy(i10, j10);
    }

    /* JADX INFO: renamed from: amount, reason: from getter */
    public final int getAmount() {
        return this.amount;
    }

    public final int component1() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getNanostarAmount() {
        return this.nanostarAmount;
    }

    public final StarAmount copy(int amount, long nanostarAmount) {
        return new StarAmount(amount, nanostarAmount);
    }

    public int hashCode() {
        return (this.amount * 31) + a.a(this.nanostarAmount);
    }

    public final long nanostarAmount() {
        return this.nanostarAmount;
    }

    public String toString() {
        return "StarAmount(amount=" + this.amount + ", nanostarAmount=" + this.nanostarAmount + ')';
    }

    public StarAmount(int i10, long j10) {
        this.amount = i10;
        this.nanostarAmount = j10;
    }
}
