package com.pengrad.telegrambot.model.message.origin;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class MessageOriginHiddenUser extends MessageOrigin {
    public static final String MESSAGE_ORIGIN_TYPE = "hidden_user";
    private String sender_user_name;

    @Override // com.pengrad.telegrambot.model.message.origin.MessageOrigin
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            MessageOriginHiddenUser messageOriginHiddenUser = (MessageOriginHiddenUser) obj;
            if (Objects.equals(this.type, messageOriginHiddenUser.type) && Objects.equals(this.date, messageOriginHiddenUser.date) && Objects.equals(this.sender_user_name, messageOriginHiddenUser.sender_user_name)) {
                return true;
            }
        }
        return false;
    }

    public MessageOriginHiddenUser() {
        super(MESSAGE_ORIGIN_TYPE);
    }

    @Override // com.pengrad.telegrambot.model.message.origin.MessageOrigin
    public int hashCode() {
        return Objects.hash(this.type, this.date, this.sender_user_name);
    }

    public String senderUserName() {
        return this.sender_user_name;
    }

    @Override // com.pengrad.telegrambot.model.message.origin.MessageOrigin
    public String toString() {
        return "MessageOriginHiddenUser{type='" + this.type + "',date='" + this.date + "',sender_user_name='" + this.sender_user_name + "'}";
    }
}
