package com.pengrad.telegrambot.model.suggestedposts;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostDeclined;", "", "suggestedPostMessage", "Lcom/pengrad/telegrambot/model/Message;", "comment", "", "(Lcom/pengrad/telegrambot/model/Message;Ljava/lang/String;)V", "()Ljava/lang/String;", "()Lcom/pengrad/telegrambot/model/Message;", "component1", "component2", "copy", "equals", "", TransactionPartnerType.OTHER, "hashCode", "", "toString", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class SuggestedPostDeclined {
    private final String comment;
    private final Message suggestedPostMessage;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuggestedPostDeclined)) {
            return false;
        }
        SuggestedPostDeclined suggestedPostDeclined = (SuggestedPostDeclined) other;
        return m.a(this.suggestedPostMessage, suggestedPostDeclined.suggestedPostMessage) && m.a(this.comment, suggestedPostDeclined.comment);
    }

    public static /* synthetic */ SuggestedPostDeclined copy$default(SuggestedPostDeclined suggestedPostDeclined, Message message, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            message = suggestedPostDeclined.suggestedPostMessage;
        }
        if ((i10 & 2) != 0) {
            str = suggestedPostDeclined.comment;
        }
        return suggestedPostDeclined.copy(message, str);
    }

    /* JADX INFO: renamed from: comment, reason: from getter */
    public final String getComment() {
        return this.comment;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Message getSuggestedPostMessage() {
        return this.suggestedPostMessage;
    }

    public final String component2() {
        return this.comment;
    }

    public final SuggestedPostDeclined copy(Message suggestedPostMessage, String comment) {
        return new SuggestedPostDeclined(suggestedPostMessage, comment);
    }

    public int hashCode() {
        Message message = this.suggestedPostMessage;
        int iHashCode = (message == null ? 0 : message.hashCode()) * 31;
        String str = this.comment;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final Message suggestedPostMessage() {
        return this.suggestedPostMessage;
    }

    public String toString() {
        return "SuggestedPostDeclined(suggestedPostMessage=" + this.suggestedPostMessage + ", comment=" + this.comment + ')';
    }

    public SuggestedPostDeclined(Message message, String str) {
        this.suggestedPostMessage = message;
        this.comment = str;
    }
}
