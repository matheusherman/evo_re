package com.pengrad.telegrambot.model.gift;

import androidx.paging.a;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J1\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0013\u0010\u0006\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\bR\u0013\u0010\u0005\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/pengrad/telegrambot/model/gift/AcceptedGiftTypes;", "", "unlimitedGifts", "", "limitedGifts", "uniqueGifts", "premiumSubscription", "(ZZZZ)V", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", TransactionPartnerType.OTHER, "hashCode", "", "toString", "", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class AcceptedGiftTypes {
    private final boolean limitedGifts;
    private final boolean premiumSubscription;
    private final boolean uniqueGifts;
    private final boolean unlimitedGifts;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AcceptedGiftTypes)) {
            return false;
        }
        AcceptedGiftTypes acceptedGiftTypes = (AcceptedGiftTypes) other;
        return this.unlimitedGifts == acceptedGiftTypes.unlimitedGifts && this.limitedGifts == acceptedGiftTypes.limitedGifts && this.uniqueGifts == acceptedGiftTypes.uniqueGifts && this.premiumSubscription == acceptedGiftTypes.premiumSubscription;
    }

    public static /* synthetic */ AcceptedGiftTypes copy$default(AcceptedGiftTypes acceptedGiftTypes, boolean z10, boolean z11, boolean z12, boolean z13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = acceptedGiftTypes.unlimitedGifts;
        }
        if ((i10 & 2) != 0) {
            z11 = acceptedGiftTypes.limitedGifts;
        }
        if ((i10 & 4) != 0) {
            z12 = acceptedGiftTypes.uniqueGifts;
        }
        if ((i10 & 8) != 0) {
            z13 = acceptedGiftTypes.premiumSubscription;
        }
        return acceptedGiftTypes.copy(z10, z11, z12, z13);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getUnlimitedGifts() {
        return this.unlimitedGifts;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getLimitedGifts() {
        return this.limitedGifts;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getUniqueGifts() {
        return this.uniqueGifts;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getPremiumSubscription() {
        return this.premiumSubscription;
    }

    public final AcceptedGiftTypes copy(boolean unlimitedGifts, boolean limitedGifts, boolean uniqueGifts, boolean premiumSubscription) {
        return new AcceptedGiftTypes(unlimitedGifts, limitedGifts, uniqueGifts, premiumSubscription);
    }

    public int hashCode() {
        return (((((a.a(this.unlimitedGifts) * 31) + a.a(this.limitedGifts)) * 31) + a.a(this.uniqueGifts)) * 31) + a.a(this.premiumSubscription);
    }

    public final boolean limitedGifts() {
        return this.limitedGifts;
    }

    public final boolean premiumSubscription() {
        return this.premiumSubscription;
    }

    public String toString() {
        return "AcceptedGiftTypes(unlimitedGifts=" + this.unlimitedGifts + ", limitedGifts=" + this.limitedGifts + ", uniqueGifts=" + this.uniqueGifts + ", premiumSubscription=" + this.premiumSubscription + ')';
    }

    public final boolean uniqueGifts() {
        return this.uniqueGifts;
    }

    public final boolean unlimitedGifts() {
        return this.unlimitedGifts;
    }

    public AcceptedGiftTypes(boolean z10, boolean z11, boolean z12, boolean z13) {
        this.unlimitedGifts = z10;
        this.limitedGifts = z11;
        this.uniqueGifts = z12;
        this.premiumSubscription = z13;
    }
}
