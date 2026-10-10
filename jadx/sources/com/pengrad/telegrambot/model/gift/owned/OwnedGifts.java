package com.pengrad.telegrambot.model.gift.owned;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J4\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\t\u0010\u001d\u001a\u00020\bHÖ\u0001R$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0004\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0002\u001a\u00020\u00038\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/pengrad/telegrambot/model/gift/owned/OwnedGifts;", "", "totalAmount", "", "gifts", "", "Lcom/pengrad/telegrambot/model/gift/owned/OwnedGift;", "nextOffset", "", "(I[Lcom/pengrad/telegrambot/model/gift/owned/OwnedGift;Ljava/lang/String;)V", "()[Lcom/pengrad/telegrambot/model/gift/owned/OwnedGift;", "setGifts", "([Lcom/pengrad/telegrambot/model/gift/owned/OwnedGift;)V", "[Lcom/pengrad/telegrambot/model/gift/owned/OwnedGift;", "()Ljava/lang/String;", "setNextOffset", "(Ljava/lang/String;)V", "()I", "setTotalAmount", "(I)V", "component1", "component2", "component3", "copy", "(I[Lcom/pengrad/telegrambot/model/gift/owned/OwnedGift;Ljava/lang/String;)Lcom/pengrad/telegrambot/model/gift/owned/OwnedGifts;", "equals", "", TransactionPartnerType.OTHER, "hashCode", "toString", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class OwnedGifts {
    private OwnedGift[] gifts;
    private String nextOffset;
    private int totalAmount;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OwnedGifts)) {
            return false;
        }
        OwnedGifts ownedGifts = (OwnedGifts) other;
        return this.totalAmount == ownedGifts.totalAmount && Arrays.equals(this.gifts, ownedGifts.gifts) && m.a(this.nextOffset, ownedGifts.nextOffset);
    }

    public OwnedGifts(int i10, OwnedGift[] gifts, String str) {
        m.f(gifts, "gifts");
        this.totalAmount = i10;
        this.gifts = gifts;
        this.nextOffset = str;
    }

    public static /* synthetic */ OwnedGifts copy$default(OwnedGifts ownedGifts, int i10, OwnedGift[] ownedGiftArr, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = ownedGifts.totalAmount;
        }
        if ((i11 & 2) != 0) {
            ownedGiftArr = ownedGifts.gifts;
        }
        if ((i11 & 4) != 0) {
            str = ownedGifts.nextOffset;
        }
        return ownedGifts.copy(i10, ownedGiftArr, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTotalAmount() {
        return this.totalAmount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final OwnedGift[] getGifts() {
        return this.gifts;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNextOffset() {
        return this.nextOffset;
    }

    public final OwnedGifts copy(int totalAmount, OwnedGift[] gifts, String nextOffset) {
        m.f(gifts, "gifts");
        return new OwnedGifts(totalAmount, gifts, nextOffset);
    }

    public final OwnedGift[] gifts() {
        return this.gifts;
    }

    public int hashCode() {
        int iHashCode = ((this.totalAmount * 31) + Arrays.hashCode(this.gifts)) * 31;
        String str = this.nextOffset;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final String nextOffset() {
        return this.nextOffset;
    }

    public final void setGifts(OwnedGift[] ownedGiftArr) {
        m.f(ownedGiftArr, "<set-?>");
        this.gifts = ownedGiftArr;
    }

    public final void setNextOffset(String str) {
        this.nextOffset = str;
    }

    public final void setTotalAmount(int i10) {
        this.totalAmount = i10;
    }

    public String toString() {
        return "OwnedGifts(totalAmount=" + this.totalAmount + ", gifts=" + Arrays.toString(this.gifts) + ", nextOffset=" + this.nextOffset + ')';
    }

    public final int totalAmount() {
        return this.totalAmount;
    }
}
