package com.pengrad.telegrambot.model.chatboost;

import com.pengrad.telegrambot.model.chatboost.source.ChatBoostSource;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ChatBoost {
    private Integer add_date;
    private String boost_id;
    private Integer expiration_date;
    private ChatBoostSource source;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ChatBoost chatBoost = (ChatBoost) obj;
            if (Objects.equals(this.boost_id, chatBoost.boost_id) && Objects.equals(this.add_date, chatBoost.add_date) && Objects.equals(this.expiration_date, chatBoost.expiration_date) && Objects.equals(this.source, chatBoost.source)) {
                return true;
            }
        }
        return false;
    }

    public Integer addDate() {
        return this.add_date;
    }

    public String boostId() {
        return this.boost_id;
    }

    public Integer expirationDate() {
        return this.expiration_date;
    }

    public int hashCode() {
        String str = this.boost_id;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public ChatBoostSource source() {
        return this.source;
    }

    public String toString() {
        return "ChatBoost{boost_id='" + this.boost_id + "', add_date=" + this.add_date + ", expiration_date=" + this.expiration_date + ", source=" + this.source + '}';
    }
}
