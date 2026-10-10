package com.pengrad.telegrambot.model.stars;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartner;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003JP\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0013\u0010\u0007\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\rR\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0006\u0010\u000eR\u0015\u0010\n\u001a\u0004\u0018\u00010\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0010R\u0015\u0010\b\u001a\u0004\u0018\u00010\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/pengrad/telegrambot/model/stars/StarTransaction;", "", IjkMediaMeta.IJKM_KEY_TRACK_ID, "", "amount", "", "nanostarAmount", "date", "source", "Lcom/pengrad/telegrambot/model/stars/partner/TransactionPartner;", "receiver", "(Ljava/lang/String;ILjava/lang/Integer;ILcom/pengrad/telegrambot/model/stars/partner/TransactionPartner;Lcom/pengrad/telegrambot/model/stars/partner/TransactionPartner;)V", "()I", "()Ljava/lang/String;", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Lcom/pengrad/telegrambot/model/stars/partner/TransactionPartner;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;ILjava/lang/Integer;ILcom/pengrad/telegrambot/model/stars/partner/TransactionPartner;Lcom/pengrad/telegrambot/model/stars/partner/TransactionPartner;)Lcom/pengrad/telegrambot/model/stars/StarTransaction;", "equals", "", TransactionPartnerType.OTHER, "hashCode", "toString", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class StarTransaction {
    private final int amount;
    private final int date;
    private final String id;
    private final Integer nanostarAmount;
    private final TransactionPartner receiver;
    private final TransactionPartner source;

    public StarTransaction(String id2, int i10, Integer num, int i11, TransactionPartner transactionPartner, TransactionPartner transactionPartner2) {
        m.f(id2, "id");
        this.id = id2;
        this.amount = i10;
        this.nanostarAmount = num;
        this.date = i11;
        this.source = transactionPartner;
        this.receiver = transactionPartner2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StarTransaction)) {
            return false;
        }
        StarTransaction starTransaction = (StarTransaction) other;
        return m.a(this.id, starTransaction.id) && this.amount == starTransaction.amount && m.a(this.nanostarAmount, starTransaction.nanostarAmount) && this.date == starTransaction.date && m.a(this.source, starTransaction.source) && m.a(this.receiver, starTransaction.receiver);
    }

    public static /* synthetic */ StarTransaction copy$default(StarTransaction starTransaction, String str, int i10, Integer num, int i11, TransactionPartner transactionPartner, TransactionPartner transactionPartner2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = starTransaction.id;
        }
        if ((i12 & 2) != 0) {
            i10 = starTransaction.amount;
        }
        if ((i12 & 4) != 0) {
            num = starTransaction.nanostarAmount;
        }
        if ((i12 & 8) != 0) {
            i11 = starTransaction.date;
        }
        if ((i12 & 16) != 0) {
            transactionPartner = starTransaction.source;
        }
        if ((i12 & 32) != 0) {
            transactionPartner2 = starTransaction.receiver;
        }
        TransactionPartner transactionPartner3 = transactionPartner;
        TransactionPartner transactionPartner4 = transactionPartner2;
        return starTransaction.copy(str, i10, num, i11, transactionPartner3, transactionPartner4);
    }

    /* JADX INFO: renamed from: amount, reason: from getter */
    public final int getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final int component2() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getNanostarAmount() {
        return this.nanostarAmount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final TransactionPartner getSource() {
        return this.source;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final TransactionPartner getReceiver() {
        return this.receiver;
    }

    public final StarTransaction copy(String id2, int amount, Integer nanostarAmount, int date, TransactionPartner source, TransactionPartner receiver) {
        m.f(id2, "id");
        return new StarTransaction(id2, amount, nanostarAmount, date, source, receiver);
    }

    public final int date() {
        return this.date;
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.amount) * 31;
        Integer num = this.nanostarAmount;
        int iHashCode2 = (((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.date) * 31;
        TransactionPartner transactionPartner = this.source;
        int iHashCode3 = (iHashCode2 + (transactionPartner == null ? 0 : transactionPartner.hashCode())) * 31;
        TransactionPartner transactionPartner2 = this.receiver;
        return iHashCode3 + (transactionPartner2 != null ? transactionPartner2.hashCode() : 0);
    }

    public final String id() {
        return this.id;
    }

    public final Integer nanostarAmount() {
        return this.nanostarAmount;
    }

    public final TransactionPartner receiver() {
        return this.receiver;
    }

    public final TransactionPartner source() {
        return this.source;
    }

    public String toString() {
        return "StarTransaction(id=" + this.id + ", amount=" + this.amount + ", nanostarAmount=" + this.nanostarAmount + ", date=" + this.date + ", source=" + this.source + ", receiver=" + this.receiver + ')';
    }

    public /* synthetic */ StarTransaction(String str, int i10, Integer num, int i11, TransactionPartner transactionPartner, TransactionPartner transactionPartner2, int i12, g gVar) {
        this(str, i10, (i12 & 4) != 0 ? null : num, i11, (i12 & 16) != 0 ? null : transactionPartner, (i12 & 32) != 0 ? null : transactionPartner2);
    }
}
