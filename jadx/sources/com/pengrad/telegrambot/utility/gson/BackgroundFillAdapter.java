package com.pengrad.telegrambot.utility.gson;

import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.n;
import com.google.gson.p;
import com.pengrad.telegrambot.model.chatbackground.BackgroundFill;
import com.pengrad.telegrambot.model.chatbackground.BackgroundFillFreeformGradient;
import com.pengrad.telegrambot.model.chatbackground.BackgroundFillGradient;
import com.pengrad.telegrambot.model.chatbackground.BackgroundFillSolid;
import java.lang.reflect.Type;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class BackgroundFillAdapter implements j<BackgroundFill> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.j
    public BackgroundFill deserialize(k kVar, Type type, i iVar) {
        n nVarF = kVar.f();
        p pVarQ = nVarF.q(IjkMediaMeta.IJKM_KEY_TYPE);
        String strT = pVarQ != null ? pVarQ.t() : "unknown";
        if (BackgroundFillSolid.TYPE.equals(strT)) {
            return (BackgroundFill) iVar.a(nVarF, BackgroundFillSolid.class);
        }
        if (BackgroundFillGradient.TYPE.equals(strT)) {
            return (BackgroundFill) iVar.a(nVarF, BackgroundFillGradient.class);
        }
        return BackgroundFillFreeformGradient.TYPE.equals(strT) ? (BackgroundFill) iVar.a(nVarF, BackgroundFillFreeformGradient.class) : new BackgroundFill(strT);
    }
}
