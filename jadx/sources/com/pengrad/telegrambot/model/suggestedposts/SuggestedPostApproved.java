package com.pengrad.telegrambot.model.suggestedposts;

import androidx.collection.a;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0007HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\nR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostApproved;", "", "suggestedPostMessage", "Lcom/pengrad/telegrambot/model/Message;", "price", "Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostPrice;", "sendDate", "", "(Lcom/pengrad/telegrambot/model/Message;Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostPrice;J)V", "()Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostPrice;", "()J", "()Lcom/pengrad/telegrambot/model/Message;", "component1", "component2", "component3", "copy", "equals", "", TransactionPartnerType.OTHER, "hashCode", "", "toString", "", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class SuggestedPostApproved {
    private final SuggestedPostPrice price;
    private final long sendDate;
    private final Message suggestedPostMessage;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuggestedPostApproved)) {
            return false;
        }
        SuggestedPostApproved suggestedPostApproved = (SuggestedPostApproved) other;
        return m.a(this.suggestedPostMessage, suggestedPostApproved.suggestedPostMessage) && m.a(this.price, suggestedPostApproved.price) && this.sendDate == suggestedPostApproved.sendDate;
    }

    public static /* synthetic */ SuggestedPostApproved copy$default(SuggestedPostApproved suggestedPostApproved, Message message, SuggestedPostPrice suggestedPostPrice, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            message = suggestedPostApproved.suggestedPostMessage;
        }
        if ((i10 & 2) != 0) {
            suggestedPostPrice = suggestedPostApproved.price;
        }
        if ((i10 & 4) != 0) {
            j10 = suggestedPostApproved.sendDate;
        }
        return suggestedPostApproved.copy(message, suggestedPostPrice, j10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Message getSuggestedPostMessage() {
        return this.suggestedPostMessage;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SuggestedPostPrice getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getSendDate() {
        return this.sendDate;
    }

    public final SuggestedPostApproved copy(Message suggestedPostMessage, SuggestedPostPrice price, long sendDate) {
        return new SuggestedPostApproved(suggestedPostMessage, price, sendDate);
    }

    public int hashCode() {
        Message message = this.suggestedPostMessage;
        int iHashCode = (message == null ? 0 : message.hashCode()) * 31;
        SuggestedPostPrice suggestedPostPrice = this.price;
        return ((iHashCode + (suggestedPostPrice != null ? suggestedPostPrice.hashCode() : 0)) * 31) + a.a(this.sendDate);
    }

    public final SuggestedPostPrice price() {
        return this.price;
    }

    public final long sendDate() {
        return this.sendDate;
    }

    public final Message suggestedPostMessage() {
        return this.suggestedPostMessage;
    }

    public String toString() {
        return "SuggestedPostApproved(suggestedPostMessage=" + this.suggestedPostMessage + ", price=" + this.price + ", sendDate=" + this.sendDate + ')';
    }

    public SuggestedPostApproved(Message message, SuggestedPostPrice suggestedPostPrice, long j10) {
        this.suggestedPostMessage = message;
        this.price = suggestedPostPrice;
        this.sendDate = j10;
    }
}
