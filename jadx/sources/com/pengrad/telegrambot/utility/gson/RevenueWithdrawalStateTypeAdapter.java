package com.pengrad.telegrambot.utility.gson;

import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.n;
import com.google.gson.p;
import com.pengrad.telegrambot.model.stars.withdrawal.RevenueWithdrawalState;
import com.pengrad.telegrambot.model.stars.withdrawal.RevenueWithdrawalStateFailed;
import com.pengrad.telegrambot.model.stars.withdrawal.RevenueWithdrawalStatePending;
import com.pengrad.telegrambot.model.stars.withdrawal.RevenueWithdrawalStateSucceeded;
import java.lang.reflect.Type;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class RevenueWithdrawalStateTypeAdapter implements j<RevenueWithdrawalState> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.j
    public RevenueWithdrawalState deserialize(k kVar, Type type, i iVar) {
        n nVarF = kVar.f();
        p pVarQ = nVarF.q(IjkMediaMeta.IJKM_KEY_TYPE);
        String strT = pVarQ != null ? pVarQ.t() : "unknown";
        if (RevenueWithdrawalStatePending.TYPE.equals(strT)) {
            return (RevenueWithdrawalState) iVar.a(nVarF, RevenueWithdrawalStatePending.class);
        }
        if (RevenueWithdrawalStateSucceeded.TYPE.equals(strT)) {
            return (RevenueWithdrawalState) iVar.a(nVarF, RevenueWithdrawalStateSucceeded.class);
        }
        return RevenueWithdrawalStateFailed.TYPE.equals(strT) ? (RevenueWithdrawalState) iVar.a(nVarF, RevenueWithdrawalStateFailed.class) : new RevenueWithdrawalState(strT);
    }
}
