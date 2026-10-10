package com.pengrad.telegrambot.model.chatboost.source;

import com.pengrad.telegrambot.model.User;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ChatBoostSource implements Serializable {
    private static final long serialVersionUID = 0;
    protected String source;
    protected User user;

    ChatBoostSource() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ChatBoostSource chatBoostSource = (ChatBoostSource) obj;
            if (Objects.equals(this.source, chatBoostSource.source) && Objects.equals(this.user, chatBoostSource.user)) {
                return true;
            }
        }
        return false;
    }

    public ChatBoostSource(String str) {
        this.source = str;
    }

    public int hashCode() {
        return Objects.hash(this.source, this.user);
    }

    public String toString() {
        return "ChatBoostSource{source='" + this.source + "',user='" + this.user + "'}";
    }
}
