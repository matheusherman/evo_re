package com.pengrad.telegrambot.model;

import com.pengrad.telegrambot.model.reaction.ReactionCount;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class MessageReactionCountUpdated {
    private Chat chat;
    private Integer date;
    private Integer message_id;
    private ReactionCount[] reactions;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            MessageReactionCountUpdated messageReactionCountUpdated = (MessageReactionCountUpdated) obj;
            if (Objects.equals(this.chat, messageReactionCountUpdated.chat) && Objects.equals(this.message_id, messageReactionCountUpdated.message_id) && Objects.equals(this.date, messageReactionCountUpdated.date) && Arrays.equals(this.reactions, messageReactionCountUpdated.reactions)) {
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
        return (Objects.hash(this.chat, this.message_id, this.date) * 31) + Arrays.hashCode(this.reactions);
    }

    public Integer messageId() {
        return this.message_id;
    }

    public ReactionCount[] reactions() {
        return this.reactions;
    }

    public String toString() {
        return "MessageReactionCountUpdated{chat=" + this.chat + ", message_id=" + this.message_id + ", date=" + this.date + ", reactions=" + Arrays.toString(this.reactions) + '}';
    }
}
