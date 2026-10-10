package com.pengrad.telegrambot.model.message.origin;

import com.pengrad.telegrambot.model.Chat;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class MessageOriginChat extends MessageOrigin {
    public static final String MESSAGE_ORIGIN_TYPE = "chat";
    private String author_signature;
    private Chat sender_chat;

    @Override // com.pengrad.telegrambot.model.message.origin.MessageOrigin
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            MessageOriginChat messageOriginChat = (MessageOriginChat) obj;
            if (Objects.equals(this.type, messageOriginChat.type) && Objects.equals(this.date, messageOriginChat.date) && Objects.equals(this.sender_chat, messageOriginChat.sender_chat) && Objects.equals(this.author_signature, messageOriginChat.author_signature)) {
                return true;
            }
        }
        return false;
    }

    public MessageOriginChat() {
        super("chat");
    }

    public String authorSignature() {
        return this.author_signature;
    }

    @Override // com.pengrad.telegrambot.model.message.origin.MessageOrigin
    public int hashCode() {
        return Objects.hash(this.type, this.date, this.sender_chat, this.author_signature);
    }

    public Chat senderChat() {
        return this.sender_chat;
    }

    @Override // com.pengrad.telegrambot.model.message.origin.MessageOrigin
    public String toString() {
        return "MessageOriginChat{type='" + this.type + "',date='" + this.date + "',sender_chat='" + this.sender_chat + "',author_signature='" + this.author_signature + "'}";
    }
}
