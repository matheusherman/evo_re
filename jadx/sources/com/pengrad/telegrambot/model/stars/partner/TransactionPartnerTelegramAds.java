package com.pengrad.telegrambot.model.stars.partner;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/pengrad/telegrambot/model/stars/partner/TransactionPartnerTelegramAds;", "Lcom/pengrad/telegrambot/model/stars/partner/TransactionPartner;", "()V", IjkMediaMeta.IJKM_KEY_TYPE, "", "getType", "()Ljava/lang/String;", "equals", "", TransactionPartnerType.OTHER, "", "hashCode", "", "toString", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TransactionPartnerTelegramAds implements TransactionPartner {
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!m.a(TransactionPartnerTelegramAds.class, other != null ? other.getClass() : null)) {
            return false;
        }
        m.d(other, "null cannot be cast to non-null type com.pengrad.telegrambot.model.stars.partner.TransactionPartnerTelegramAds");
        return m.a(getType(), ((TransactionPartnerTelegramAds) other).getType());
    }

    @Override // com.pengrad.telegrambot.model.stars.partner.TransactionPartner
    public String getType() {
        return TransactionPartnerType.TELEGRAM_ADS;
    }

    public String toString() {
        return "TransactionPartnerTelegramAds(type='" + getType() + "')";
    }

    public int hashCode() {
        return getType().hashCode();
    }
}
