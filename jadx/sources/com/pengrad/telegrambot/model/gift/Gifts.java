package com.pengrad.telegrambot.model.gift;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001b\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0007¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/pengrad/telegrambot/model/gift/Gifts;", "", "gifts", "", "Lcom/pengrad/telegrambot/model/gift/Gift;", "([Lcom/pengrad/telegrambot/model/gift/Gift;)V", "()[Lcom/pengrad/telegrambot/model/gift/Gift;", "[Lcom/pengrad/telegrambot/model/gift/Gift;", "component1", "copy", "([Lcom/pengrad/telegrambot/model/gift/Gift;)Lcom/pengrad/telegrambot/model/gift/Gifts;", "equals", "", TransactionPartnerType.OTHER, "hashCode", "", "toString", "", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class Gifts {
    private final Gift[] gifts;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Gifts) && Arrays.equals(this.gifts, ((Gifts) other).gifts);
    }

    public Gifts(Gift[] gifts) {
        m.f(gifts, "gifts");
        this.gifts = gifts;
    }

    public static /* synthetic */ Gifts copy$default(Gifts gifts, Gift[] giftArr, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            giftArr = gifts.gifts;
        }
        return gifts.copy(giftArr);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Gift[] getGifts() {
        return this.gifts;
    }

    public final Gifts copy(Gift[] gifts) {
        m.f(gifts, "gifts");
        return new Gifts(gifts);
    }

    public final Gift[] gifts() {
        return this.gifts;
    }

    public int hashCode() {
        return Arrays.hashCode(this.gifts);
    }

    public String toString() {
        return "Gifts(gifts=" + Arrays.toString(this.gifts) + ')';
    }
}
