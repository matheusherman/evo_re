package com.pengrad.telegrambot.utility.gson;

import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.n;
import com.google.gson.p;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.message.InaccessibleMessage;
import com.pengrad.telegrambot.model.message.MaybeInaccessibleMessage;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class MaybeInaccessibleMessageTypeAdapter implements j<MaybeInaccessibleMessage> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.j
    public MaybeInaccessibleMessage deserialize(k kVar, Type type, i iVar) {
        n nVarF = kVar.f();
        p pVarQ = nVarF.q("date");
        return (pVarQ == null || pVarQ.i() || pVarQ.q() == InaccessibleMessage.INACCESSIBLE_MESSAGE_DATE.intValue()) ? (MaybeInaccessibleMessage) iVar.a(nVarF, InaccessibleMessage.class) : (MaybeInaccessibleMessage) iVar.a(nVarF, Message.class);
    }
}
