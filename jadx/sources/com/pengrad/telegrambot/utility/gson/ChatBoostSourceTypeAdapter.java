package com.pengrad.telegrambot.utility.gson;

import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.n;
import com.google.gson.p;
import com.pengrad.telegrambot.model.chatboost.source.ChatBoostSource;
import com.pengrad.telegrambot.model.chatboost.source.ChatBoostSourceGiftCode;
import com.pengrad.telegrambot.model.chatboost.source.ChatBoostSourceGiveaway;
import com.pengrad.telegrambot.model.chatboost.source.ChatBoostSourcePremium;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ChatBoostSourceTypeAdapter implements j<ChatBoostSource> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.j
    public ChatBoostSource deserialize(k kVar, Type type, i iVar) {
        n nVarF = kVar.f();
        p pVarQ = nVarF.q("source");
        String strT = pVarQ != null ? pVarQ.t() : "unknown";
        if (ChatBoostSourceGiftCode.CHAT_BOOST_TYPE.equals(strT)) {
            return (ChatBoostSource) iVar.a(nVarF, ChatBoostSourceGiftCode.class);
        }
        if (ChatBoostSourceGiveaway.CHAT_BOOST_TYPE.equals(strT)) {
            return (ChatBoostSource) iVar.a(nVarF, ChatBoostSourceGiveaway.class);
        }
        return ChatBoostSourcePremium.CHAT_BOOST_TYPE.equals(strT) ? (ChatBoostSource) iVar.a(nVarF, ChatBoostSourcePremium.class) : new ChatBoostSource(strT);
    }
}
