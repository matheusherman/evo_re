package com.pengrad.telegrambot.model.suggestedposts;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0004\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostParameters;", "", "price", "Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostPrice;", "sendDate", "", "(Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostPrice;Ljava/lang/Long;)V", "()Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostPrice;", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostPrice;Ljava/lang/Long;)Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostParameters;", "equals", "", TransactionPartnerType.OTHER, "hashCode", "", "toString", "", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class SuggestedPostParameters {
    private final SuggestedPostPrice price;
    private final Long sendDate;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuggestedPostParameters)) {
            return false;
        }
        SuggestedPostParameters suggestedPostParameters = (SuggestedPostParameters) other;
        return m.a(this.price, suggestedPostParameters.price) && m.a(this.sendDate, suggestedPostParameters.sendDate);
    }

    public static /* synthetic */ SuggestedPostParameters copy$default(SuggestedPostParameters suggestedPostParameters, SuggestedPostPrice suggestedPostPrice, Long l10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            suggestedPostPrice = suggestedPostParameters.price;
        }
        if ((i10 & 2) != 0) {
            l10 = suggestedPostParameters.sendDate;
        }
        return suggestedPostParameters.copy(suggestedPostPrice, l10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SuggestedPostPrice getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getSendDate() {
        return this.sendDate;
    }

    public final SuggestedPostParameters copy(SuggestedPostPrice price, Long sendDate) {
        return new SuggestedPostParameters(price, sendDate);
    }

    public int hashCode() {
        SuggestedPostPrice suggestedPostPrice = this.price;
        int iHashCode = (suggestedPostPrice == null ? 0 : suggestedPostPrice.hashCode()) * 31;
        Long l10 = this.sendDate;
        return iHashCode + (l10 != null ? l10.hashCode() : 0);
    }

    public final SuggestedPostPrice price() {
        return this.price;
    }

    public final Long sendDate() {
        return this.sendDate;
    }

    public String toString() {
        return "SuggestedPostParameters(price=" + this.price + ", sendDate=" + this.sendDate + ')';
    }

    public SuggestedPostParameters(SuggestedPostPrice suggestedPostPrice, Long l10) {
        this.price = suggestedPostPrice;
        this.sendDate = l10;
    }
}
