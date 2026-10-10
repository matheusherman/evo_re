package com.pengrad.telegrambot.model;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/pengrad/telegrambot/model/PreparedInlineMessage;", "", IjkMediaMeta.IJKM_KEY_TRACK_ID, "", "expirationDate", "", "(Ljava/lang/String;I)V", "()I", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", TransactionPartnerType.OTHER, "hashCode", "toString", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class PreparedInlineMessage {
    private final int expirationDate;
    private final String id;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreparedInlineMessage)) {
            return false;
        }
        PreparedInlineMessage preparedInlineMessage = (PreparedInlineMessage) other;
        return m.a(this.id, preparedInlineMessage.id) && this.expirationDate == preparedInlineMessage.expirationDate;
    }

    public PreparedInlineMessage(String id2, int i10) {
        m.f(id2, "id");
        this.id = id2;
        this.expirationDate = i10;
    }

    public static /* synthetic */ PreparedInlineMessage copy$default(PreparedInlineMessage preparedInlineMessage, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = preparedInlineMessage.id;
        }
        if ((i11 & 2) != 0) {
            i10 = preparedInlineMessage.expirationDate;
        }
        return preparedInlineMessage.copy(str, i10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getExpirationDate() {
        return this.expirationDate;
    }

    public final PreparedInlineMessage copy(String id2, int expirationDate) {
        m.f(id2, "id");
        return new PreparedInlineMessage(id2, expirationDate);
    }

    public final int expirationDate() {
        return this.expirationDate;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.expirationDate;
    }

    public final String id() {
        return this.id;
    }

    public String toString() {
        return "PreparedInlineMessage(id=" + this.id + ", expirationDate=" + this.expirationDate + ')';
    }
}
