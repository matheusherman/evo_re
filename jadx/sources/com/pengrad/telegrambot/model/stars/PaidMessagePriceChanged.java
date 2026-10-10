package com.pengrad.telegrambot.model.stars;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/pengrad/telegrambot/model/stars/PaidMessagePriceChanged;", "", "prizeStarCount", "", "(I)V", "()I", "component1", "copy", "equals", "", TransactionPartnerType.OTHER, "hashCode", "toString", "", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class PaidMessagePriceChanged {
    private final int prizeStarCount;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PaidMessagePriceChanged) && this.prizeStarCount == ((PaidMessagePriceChanged) other).prizeStarCount;
    }

    public static /* synthetic */ PaidMessagePriceChanged copy$default(PaidMessagePriceChanged paidMessagePriceChanged, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = paidMessagePriceChanged.prizeStarCount;
        }
        return paidMessagePriceChanged.copy(i10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getPrizeStarCount() {
        return this.prizeStarCount;
    }

    public final PaidMessagePriceChanged copy(int prizeStarCount) {
        return new PaidMessagePriceChanged(prizeStarCount);
    }

    public int hashCode() {
        return this.prizeStarCount;
    }

    public final int prizeStarCount() {
        return this.prizeStarCount;
    }

    public String toString() {
        return "PaidMessagePriceChanged(prizeStarCount=" + this.prizeStarCount + ')';
    }

    public PaidMessagePriceChanged(int i10) {
        this.prizeStarCount = i10;
    }
}
