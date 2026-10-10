package com.pengrad.telegrambot.model.message.origin;

import com.pengrad.telegrambot.model.Chat;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class MessageOriginChannel extends MessageOrigin {
    public static final String MESSAGE_ORIGIN_TYPE = "channel";
    private String author_signature;
    private Chat chat;
    private Integer message_id;

    @Override // com.pengrad.telegrambot.model.message.origin.MessageOrigin
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            MessageOriginChannel messageOriginChannel = (MessageOriginChannel) obj;
            if (Objects.equals(this.type, messageOriginChannel.type) && Objects.equals(this.date, messageOriginChannel.date) && Objects.equals(this.chat, messageOriginChannel.chat) && Objects.equals(this.message_id, messageOriginChannel.message_id) && Objects.equals(this.author_signature, messageOriginChannel.author_signature)) {
                return true;
            }
        }
        return false;
    }

    public MessageOriginChannel() {
        super(MESSAGE_ORIGIN_TYPE);
    }

    public String authorSignature() {
        return this.author_signature;
    }

    public Chat chat() {
        return this.chat;
    }

    @Override // com.pengrad.telegrambot.model.message.origin.MessageOrigin
    public int hashCode() {
        return Objects.hash(this.type, this.date, this.chat, this.message_id, this.author_signature);
    }

    public Integer messageId() {
        return this.message_id;
    }

    @Override // com.pengrad.telegrambot.model.message.origin.MessageOrigin
    public String toString() {
        return "MessageOriginChannel{type='" + this.type + "',date='" + this.date + "',chat='" + this.chat + "',message_id='" + this.message_id + "',author_signature='" + this.author_signature + "'}";
    }
}
