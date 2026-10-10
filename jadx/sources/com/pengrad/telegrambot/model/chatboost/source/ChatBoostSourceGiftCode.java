package com.pengrad.telegrambot.model.chatboost.source;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ChatBoostSourceGiftCode extends ChatBoostSource implements Serializable {
    public static final String CHAT_BOOST_TYPE = "gift_code";
    private static final long serialVersionUID = 0;

    @Override // com.pengrad.telegrambot.model.chatboost.source.ChatBoostSource
    public int hashCode() {
        return Objects.hash(this.source, this.user);
    }

    @Override // com.pengrad.telegrambot.model.chatboost.source.ChatBoostSource
    public String toString() {
        return "ChatBoostSourceGiftCode{source='" + this.source + "',user='" + this.user + "'}";
    }
}
