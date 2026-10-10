package com.pengrad.telegrambot.model.paidmedia;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.pengrad.telegrambot.model.User;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/pengrad/telegrambot/model/paidmedia/PaidMediaPurchased;", "", TypedValues.TransitionType.S_FROM, "Lcom/pengrad/telegrambot/model/User;", "paidMediaPayload", "", "(Lcom/pengrad/telegrambot/model/User;Ljava/lang/String;)V", "user", "()Lcom/pengrad/telegrambot/model/User;", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", TransactionPartnerType.OTHER, "hashCode", "", "toString", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class PaidMediaPurchased {
    private final User from;
    private final String paidMediaPayload;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaidMediaPurchased)) {
            return false;
        }
        PaidMediaPurchased paidMediaPurchased = (PaidMediaPurchased) other;
        return m.a(this.from, paidMediaPurchased.from) && m.a(this.paidMediaPayload, paidMediaPurchased.paidMediaPayload);
    }

    public PaidMediaPurchased(User from, String paidMediaPayload) {
        m.f(from, "from");
        m.f(paidMediaPayload, "paidMediaPayload");
        this.from = from;
        this.paidMediaPayload = paidMediaPayload;
    }

    public static /* synthetic */ PaidMediaPurchased copy$default(PaidMediaPurchased paidMediaPurchased, User user, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            user = paidMediaPurchased.from;
        }
        if ((i10 & 2) != 0) {
            str = paidMediaPurchased.paidMediaPayload;
        }
        return paidMediaPurchased.copy(user, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getFrom() {
        return this.from;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPaidMediaPayload() {
        return this.paidMediaPayload;
    }

    public final PaidMediaPurchased copy(User from, String paidMediaPayload) {
        m.f(from, "from");
        m.f(paidMediaPayload, "paidMediaPayload");
        return new PaidMediaPurchased(from, paidMediaPayload);
    }

    public int hashCode() {
        return (this.from.hashCode() * 31) + this.paidMediaPayload.hashCode();
    }

    public final String paidMediaPayload() {
        return this.paidMediaPayload;
    }

    public String toString() {
        return "PaidMediaPurchased(from=" + this.from + ", paidMediaPayload=" + this.paidMediaPayload + ')';
    }

    public final User user() {
        return this.from;
    }
}
