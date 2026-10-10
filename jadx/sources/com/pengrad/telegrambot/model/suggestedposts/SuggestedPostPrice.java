package com.pengrad.telegrambot.model.suggestedposts;

import androidx.collection.a;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostPrice;", "", "currency", "", "amount", "", "(Ljava/lang/String;J)V", "()J", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", TransactionPartnerType.OTHER, "hashCode", "", "toString", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class SuggestedPostPrice {
    private final long amount;
    private final String currency;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuggestedPostPrice)) {
            return false;
        }
        SuggestedPostPrice suggestedPostPrice = (SuggestedPostPrice) other;
        return m.a(this.currency, suggestedPostPrice.currency) && this.amount == suggestedPostPrice.amount;
    }

    public SuggestedPostPrice(String currency, long j10) {
        m.f(currency, "currency");
        this.currency = currency;
        this.amount = j10;
    }

    public static /* synthetic */ SuggestedPostPrice copy$default(SuggestedPostPrice suggestedPostPrice, String str, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = suggestedPostPrice.currency;
        }
        if ((i10 & 2) != 0) {
            j10 = suggestedPostPrice.amount;
        }
        return suggestedPostPrice.copy(str, j10);
    }

    /* JADX INFO: renamed from: amount, reason: from getter */
    public final long getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    public final long component2() {
        return this.amount;
    }

    public final SuggestedPostPrice copy(String currency, long amount) {
        m.f(currency, "currency");
        return new SuggestedPostPrice(currency, amount);
    }

    public final String currency() {
        return this.currency;
    }

    public int hashCode() {
        return (this.currency.hashCode() * 31) + a.a(this.amount);
    }

    public String toString() {
        return "SuggestedPostPrice(currency=" + this.currency + ", amount=" + this.amount + ')';
    }
}
