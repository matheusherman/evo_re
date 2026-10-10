package com.pengrad.telegrambot.model.suggestedposts;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ0\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0006\u0010\nR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostInfo;", "", "state", "", "price", "Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostPrice;", "sendDate", "", "(Ljava/lang/String;Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostPrice;Ljava/lang/Long;)V", "()Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostPrice;", "()Ljava/lang/Long;", "Ljava/lang/Long;", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostPrice;Ljava/lang/Long;)Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostInfo;", "equals", "", TransactionPartnerType.OTHER, "hashCode", "", "toString", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class SuggestedPostInfo {
    private final SuggestedPostPrice price;
    private final Long sendDate;
    private final String state;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuggestedPostInfo)) {
            return false;
        }
        SuggestedPostInfo suggestedPostInfo = (SuggestedPostInfo) other;
        return m.a(this.state, suggestedPostInfo.state) && m.a(this.price, suggestedPostInfo.price) && m.a(this.sendDate, suggestedPostInfo.sendDate);
    }

    public SuggestedPostInfo(String state, SuggestedPostPrice suggestedPostPrice, Long l10) {
        m.f(state, "state");
        this.state = state;
        this.price = suggestedPostPrice;
        this.sendDate = l10;
    }

    public static /* synthetic */ SuggestedPostInfo copy$default(SuggestedPostInfo suggestedPostInfo, String str, SuggestedPostPrice suggestedPostPrice, Long l10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = suggestedPostInfo.state;
        }
        if ((i10 & 2) != 0) {
            suggestedPostPrice = suggestedPostInfo.price;
        }
        if ((i10 & 4) != 0) {
            l10 = suggestedPostInfo.sendDate;
        }
        return suggestedPostInfo.copy(str, suggestedPostPrice, l10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SuggestedPostPrice getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getSendDate() {
        return this.sendDate;
    }

    public final SuggestedPostInfo copy(String state, SuggestedPostPrice price, Long sendDate) {
        m.f(state, "state");
        return new SuggestedPostInfo(state, price, sendDate);
    }

    public int hashCode() {
        int iHashCode = this.state.hashCode() * 31;
        SuggestedPostPrice suggestedPostPrice = this.price;
        int iHashCode2 = (iHashCode + (suggestedPostPrice == null ? 0 : suggestedPostPrice.hashCode())) * 31;
        Long l10 = this.sendDate;
        return iHashCode2 + (l10 != null ? l10.hashCode() : 0);
    }

    public final SuggestedPostPrice price() {
        return this.price;
    }

    public final Long sendDate() {
        return this.sendDate;
    }

    public final String state() {
        return this.state;
    }

    public String toString() {
        return "SuggestedPostInfo(state=" + this.state + ", price=" + this.price + ", sendDate=" + this.sendDate + ')';
    }
}
