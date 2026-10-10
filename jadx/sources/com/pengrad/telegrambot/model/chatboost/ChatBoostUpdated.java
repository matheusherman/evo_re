package com.pengrad.telegrambot.model.chatboost;

import com.pengrad.telegrambot.model.Chat;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ChatBoostUpdated {
    private ChatBoost boost;
    private Chat chat;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ChatBoostUpdated chatBoostUpdated = (ChatBoostUpdated) obj;
            if (Objects.equals(this.chat, chatBoostUpdated.chat) && Objects.equals(this.boost, chatBoostUpdated.boost)) {
                return true;
            }
        }
        return false;
    }

    public ChatBoost boost() {
        return this.boost;
    }

    public Chat chat() {
        return this.chat;
    }

    public int hashCode() {
        return Objects.hash(this.chat, this.boost);
    }

    public String toString() {
        return "ChatBoostUpdated{chat=" + this.chat + ", boost=" + this.boost + '}';
    }
}
