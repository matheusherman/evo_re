package com.pengrad.telegrambot.model.suggestedposts;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.stars.StarAmount;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\tHÆ\u0003J<\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0007¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0006\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000eR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostPaid;", "", "suggestedPostMessage", "Lcom/pengrad/telegrambot/model/Message;", "currency", "", "amount", "", "starAmount", "Lcom/pengrad/telegrambot/model/stars/StarAmount;", "(Lcom/pengrad/telegrambot/model/Message;Ljava/lang/String;Ljava/lang/Long;Lcom/pengrad/telegrambot/model/stars/StarAmount;)V", "()Ljava/lang/Long;", "Ljava/lang/Long;", "()Ljava/lang/String;", "()Lcom/pengrad/telegrambot/model/stars/StarAmount;", "()Lcom/pengrad/telegrambot/model/Message;", "component1", "component2", "component3", "component4", "copy", "(Lcom/pengrad/telegrambot/model/Message;Ljava/lang/String;Ljava/lang/Long;Lcom/pengrad/telegrambot/model/stars/StarAmount;)Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostPaid;", "equals", "", TransactionPartnerType.OTHER, "hashCode", "", "toString", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class SuggestedPostPaid {
    private final Long amount;
    private final String currency;
    private final StarAmount starAmount;
    private final Message suggestedPostMessage;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuggestedPostPaid)) {
            return false;
        }
        SuggestedPostPaid suggestedPostPaid = (SuggestedPostPaid) other;
        return m.a(this.suggestedPostMessage, suggestedPostPaid.suggestedPostMessage) && m.a(this.currency, suggestedPostPaid.currency) && m.a(this.amount, suggestedPostPaid.amount) && m.a(this.starAmount, suggestedPostPaid.starAmount);
    }

    public SuggestedPostPaid(Message message, String currency, Long l10, StarAmount starAmount) {
        m.f(currency, "currency");
        this.suggestedPostMessage = message;
        this.currency = currency;
        this.amount = l10;
        this.starAmount = starAmount;
    }

    public static /* synthetic */ SuggestedPostPaid copy$default(SuggestedPostPaid suggestedPostPaid, Message message, String str, Long l10, StarAmount starAmount, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            message = suggestedPostPaid.suggestedPostMessage;
        }
        if ((i10 & 2) != 0) {
            str = suggestedPostPaid.currency;
        }
        if ((i10 & 4) != 0) {
            l10 = suggestedPostPaid.amount;
        }
        if ((i10 & 8) != 0) {
            starAmount = suggestedPostPaid.starAmount;
        }
        return suggestedPostPaid.copy(message, str, l10, starAmount);
    }

    /* JADX INFO: renamed from: amount, reason: from getter */
    public final Long getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Message getSuggestedPostMessage() {
        return this.suggestedPostMessage;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    public final Long component3() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final StarAmount getStarAmount() {
        return this.starAmount;
    }

    public final SuggestedPostPaid copy(Message suggestedPostMessage, String currency, Long amount, StarAmount starAmount) {
        m.f(currency, "currency");
        return new SuggestedPostPaid(suggestedPostMessage, currency, amount, starAmount);
    }

    public final String currency() {
        return this.currency;
    }

    public int hashCode() {
        Message message = this.suggestedPostMessage;
        int iHashCode = (((message == null ? 0 : message.hashCode()) * 31) + this.currency.hashCode()) * 31;
        Long l10 = this.amount;
        int iHashCode2 = (iHashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
        StarAmount starAmount = this.starAmount;
        return iHashCode2 + (starAmount != null ? starAmount.hashCode() : 0);
    }

    public final StarAmount starAmount() {
        return this.starAmount;
    }

    public final Message suggestedPostMessage() {
        return this.suggestedPostMessage;
    }

    public String toString() {
        return "SuggestedPostPaid(suggestedPostMessage=" + this.suggestedPostMessage + ", currency=" + this.currency + ", amount=" + this.amount + ", starAmount=" + this.starAmount + ')';
    }
}
