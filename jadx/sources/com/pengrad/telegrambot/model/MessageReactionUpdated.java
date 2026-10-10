package com.pengrad.telegrambot.model;

import com.pengrad.telegrambot.model.reaction.ReactionType;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class MessageReactionUpdated {
    private Chat actor_chat;
    private Chat chat;
    private Integer date;
    private Integer message_id;
    private ReactionType[] new_reaction;
    private ReactionType[] old_reaction;
    private User user;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            MessageReactionUpdated messageReactionUpdated = (MessageReactionUpdated) obj;
            if (Objects.equals(this.chat, messageReactionUpdated.chat) && Objects.equals(this.message_id, messageReactionUpdated.message_id) && Objects.equals(this.user, messageReactionUpdated.user) && Objects.equals(this.actor_chat, messageReactionUpdated.actor_chat) && Objects.equals(this.date, messageReactionUpdated.date) && Arrays.equals(this.old_reaction, messageReactionUpdated.old_reaction) && Arrays.equals(this.new_reaction, messageReactionUpdated.new_reaction)) {
                return true;
            }
        }
        return false;
    }

    public Chat actorChat() {
        return this.actor_chat;
    }

    public Chat chat() {
        return this.chat;
    }

    public Integer date() {
        return this.date;
    }

    public int hashCode() {
        return (((Objects.hash(this.chat, this.message_id, this.user, this.actor_chat, this.date) * 31) + Arrays.hashCode(this.old_reaction)) * 31) + Arrays.hashCode(this.new_reaction);
    }

    public Integer messageId() {
        return this.message_id;
    }

    public ReactionType[] newReaction() {
        return this.new_reaction;
    }

    public ReactionType[] oldReaction() {
        return this.old_reaction;
    }

    public String toString() {
        return "MessageReactionUpdated{chat=" + this.chat + ", message_id=" + this.message_id + ", user=" + this.user + ", actor_chat=" + this.actor_chat + ", date=" + this.date + ", old_reaction=" + Arrays.toString(this.old_reaction) + ", new_reaction=" + Arrays.toString(this.new_reaction) + '}';
    }

    public User user() {
        return this.user;
    }
}
