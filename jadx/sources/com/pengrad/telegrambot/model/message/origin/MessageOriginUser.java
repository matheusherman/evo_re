package com.pengrad.telegrambot.model.message.origin;

import com.pengrad.telegrambot.model.User;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class MessageOriginUser extends MessageOrigin {
    public static final String MESSAGE_ORIGIN_TYPE = "user";
    private User sender_user;

    @Override // com.pengrad.telegrambot.model.message.origin.MessageOrigin
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            MessageOriginUser messageOriginUser = (MessageOriginUser) obj;
            if (Objects.equals(this.type, messageOriginUser.type) && Objects.equals(this.date, messageOriginUser.date) && Objects.equals(this.sender_user, messageOriginUser.sender_user)) {
                return true;
            }
        }
        return false;
    }

    public MessageOriginUser() {
        super("user");
    }

    @Override // com.pengrad.telegrambot.model.message.origin.MessageOrigin
    public int hashCode() {
        return Objects.hash(this.type, this.date, this.sender_user);
    }

    public User senderUser() {
        return this.sender_user;
    }

    @Override // com.pengrad.telegrambot.model.message.origin.MessageOrigin
    public String toString() {
        return "MessageOriginUser{type='" + this.type + "',date='" + this.date + "',sender_user='" + this.sender_user + "'}";
    }
}
