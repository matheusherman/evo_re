package com.pengrad.telegrambot.model.suggestedposts;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostApprovalFailed;", "", "suggestedPostMessage", "Lcom/pengrad/telegrambot/model/Message;", "price", "Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostPrice;", "(Lcom/pengrad/telegrambot/model/Message;Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostPrice;)V", "()Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostPrice;", "()Lcom/pengrad/telegrambot/model/Message;", "component1", "component2", "copy", "equals", "", TransactionPartnerType.OTHER, "hashCode", "", "toString", "", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class SuggestedPostApprovalFailed {
    private final SuggestedPostPrice price;
    private final Message suggestedPostMessage;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuggestedPostApprovalFailed)) {
            return false;
        }
        SuggestedPostApprovalFailed suggestedPostApprovalFailed = (SuggestedPostApprovalFailed) other;
        return m.a(this.suggestedPostMessage, suggestedPostApprovalFailed.suggestedPostMessage) && m.a(this.price, suggestedPostApprovalFailed.price);
    }

    public SuggestedPostApprovalFailed(Message message, SuggestedPostPrice price) {
        m.f(price, "price");
        this.suggestedPostMessage = message;
        this.price = price;
    }

    public static /* synthetic */ SuggestedPostApprovalFailed copy$default(SuggestedPostApprovalFailed suggestedPostApprovalFailed, Message message, SuggestedPostPrice suggestedPostPrice, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            message = suggestedPostApprovalFailed.suggestedPostMessage;
        }
        if ((i10 & 2) != 0) {
            suggestedPostPrice = suggestedPostApprovalFailed.price;
        }
        return suggestedPostApprovalFailed.copy(message, suggestedPostPrice);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Message getSuggestedPostMessage() {
        return this.suggestedPostMessage;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SuggestedPostPrice getPrice() {
        return this.price;
    }

    public final SuggestedPostApprovalFailed copy(Message suggestedPostMessage, SuggestedPostPrice price) {
        m.f(price, "price");
        return new SuggestedPostApprovalFailed(suggestedPostMessage, price);
    }

    public int hashCode() {
        Message message = this.suggestedPostMessage;
        return ((message == null ? 0 : message.hashCode()) * 31) + this.price.hashCode();
    }

    public final SuggestedPostPrice price() {
        return this.price;
    }

    public final Message suggestedPostMessage() {
        return this.suggestedPostMessage;
    }

    public String toString() {
        return "SuggestedPostApprovalFailed(suggestedPostMessage=" + this.suggestedPostMessage + ", price=" + this.price + ')';
    }
}
