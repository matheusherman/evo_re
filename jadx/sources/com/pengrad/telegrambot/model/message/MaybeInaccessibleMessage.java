package com.pengrad.telegrambot.model.message;

import com.pengrad.telegrambot.model.Chat;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class MaybeInaccessibleMessage {
    protected Chat chat;
    protected Integer date;
    protected Integer message_id;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            MaybeInaccessibleMessage maybeInaccessibleMessage = (MaybeInaccessibleMessage) obj;
            if (Objects.equals(this.chat, maybeInaccessibleMessage.chat) && Objects.equals(this.message_id, maybeInaccessibleMessage.message_id) && Objects.equals(this.date, maybeInaccessibleMessage.date)) {
                return true;
            }
        }
        return false;
    }

    public Chat chat() {
        return this.chat;
    }

    public Integer date() {
        return this.date;
    }

    public int hashCode() {
        return Objects.hash(this.chat, this.message_id);
    }

    public Integer messageId() {
        return this.message_id;
    }

    public String toString() {
        return "MaybeInaccessibleMessage{chat=" + this.chat + ", message_id=" + this.message_id + ", date=" + this.date + '}';
    }
}
