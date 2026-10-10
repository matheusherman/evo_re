package com.pengrad.telegrambot.model.chatboost;

import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.chatboost.source.ChatBoostSource;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ChatBoostRemoved {
    private String boost_id;
    private Chat chat;
    private Integer remove_date;
    private ChatBoostSource source;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ChatBoostRemoved chatBoostRemoved = (ChatBoostRemoved) obj;
            if (Objects.equals(this.chat, chatBoostRemoved.chat) && Objects.equals(this.boost_id, chatBoostRemoved.boost_id) && Objects.equals(this.remove_date, chatBoostRemoved.remove_date) && Objects.equals(this.source, chatBoostRemoved.source)) {
                return true;
            }
        }
        return false;
    }

    public String boostId() {
        return this.boost_id;
    }

    public Chat chat() {
        return this.chat;
    }

    public int hashCode() {
        String str = this.boost_id;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public Integer removeDate() {
        return this.remove_date;
    }

    public ChatBoostSource source() {
        return this.source;
    }

    public String toString() {
        return "ChatBoostRemoved{chat=" + this.chat + ", boost_id='" + this.boost_id + "', remove_date=" + this.remove_date + ", source=" + this.source + '}';
    }
}
