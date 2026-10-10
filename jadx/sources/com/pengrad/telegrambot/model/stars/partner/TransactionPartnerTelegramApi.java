package com.pengrad.telegrambot.model.stars.partner;

import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/pengrad/telegrambot/model/stars/partner/TransactionPartnerTelegramApi;", "Lcom/pengrad/telegrambot/model/stars/partner/TransactionPartner;", "requestCount", "", "(I)V", "()I", IjkMediaMeta.IJKM_KEY_TYPE, "", "getType", "()Ljava/lang/String;", "component1", "copy", "equals", "", TransactionPartnerType.OTHER, "", "hashCode", "toString", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class TransactionPartnerTelegramApi implements TransactionPartner {
    private final int requestCount;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TransactionPartnerTelegramApi) && this.requestCount == ((TransactionPartnerTelegramApi) other).requestCount;
    }

    public static /* synthetic */ TransactionPartnerTelegramApi copy$default(TransactionPartnerTelegramApi transactionPartnerTelegramApi, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = transactionPartnerTelegramApi.requestCount;
        }
        return transactionPartnerTelegramApi.copy(i10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getRequestCount() {
        return this.requestCount;
    }

    public final TransactionPartnerTelegramApi copy(int requestCount) {
        return new TransactionPartnerTelegramApi(requestCount);
    }

    @Override // com.pengrad.telegrambot.model.stars.partner.TransactionPartner
    public String getType() {
        return TransactionPartnerType.TELEGRAM_API;
    }

    public int hashCode() {
        return this.requestCount;
    }

    public final int requestCount() {
        return this.requestCount;
    }

    public String toString() {
        return "TransactionPartnerTelegramApi(requestCount=" + this.requestCount + ')';
    }

    public TransactionPartnerTelegramApi(int i10) {
        this.requestCount = i10;
    }
}
