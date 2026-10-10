package com.pengrad.telegrambot.utility.gson;

import b9.a;
import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.n;
import com.google.gson.p;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartner;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerAffiliateProgram;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerChat;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerFragment;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerOther;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerTelegramAds;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerTelegramApi;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerUnknown;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerUser;
import i9.d;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.n0;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;
import r8.v;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR(\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000f0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/pengrad/telegrambot/utility/gson/TransactionPartnerTypeAdapter;", "Lcom/google/gson/j;", "Lcom/pengrad/telegrambot/model/stars/partner/TransactionPartner;", "<init>", "()V", "Lcom/google/gson/k;", "element", "Ljava/lang/reflect/Type;", IjkMediaMeta.IJKM_KEY_TYPE, "Lcom/google/gson/i;", "context", "deserialize", "(Lcom/google/gson/k;Ljava/lang/reflect/Type;Lcom/google/gson/i;)Lcom/pengrad/telegrambot/model/stars/partner/TransactionPartner;", "", "", "Li9/d;", "typeMapping", "Ljava/util/Map;", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TransactionPartnerTypeAdapter implements j<TransactionPartner> {
    public static final TransactionPartnerTypeAdapter INSTANCE = new TransactionPartnerTypeAdapter();
    private static final Map<String, d<? extends TransactionPartner>> typeMapping = n0.l(v.a("user", c0.b(TransactionPartnerUser.class)), v.a("chat", c0.b(TransactionPartnerChat.class)), v.a(TransactionPartnerType.AFFILIATE_PROGRAM, c0.b(TransactionPartnerAffiliateProgram.class)), v.a(TransactionPartnerType.FRAGMENT, c0.b(TransactionPartnerFragment.class)), v.a(TransactionPartnerType.TELEGRAM_ADS, c0.b(TransactionPartnerTelegramAds.class)), v.a(TransactionPartnerType.TELEGRAM_API, c0.b(TransactionPartnerTelegramApi.class)), v.a(TransactionPartnerType.OTHER, c0.b(TransactionPartnerOther.class)));

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.j
    public TransactionPartner deserialize(k element, Type type, i context) {
        m.f(element, "element");
        m.f(type, "type");
        m.f(context, "context");
        n nVarF = element.f();
        p pVarQ = nVarF.q(IjkMediaMeta.IJKM_KEY_TYPE);
        String strT = pVarQ != null ? pVarQ.t() : null;
        if (strT == null) {
            strT = "unknown";
        }
        d<? extends TransactionPartner> dVar = typeMapping.get(strT);
        TransactionPartner transactionPartner = dVar != null ? (TransactionPartner) context.a(nVarF, a.b(dVar)) : null;
        return transactionPartner == null ? new TransactionPartnerUnknown(strT) : transactionPartner;
    }

    private TransactionPartnerTypeAdapter() {
    }
}
