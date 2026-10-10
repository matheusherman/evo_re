package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class PollAnswer implements Serializable {
    private static final long serialVersionUID = 0;
    private Integer[] option_ids;
    private String poll_id;
    private User user;
    private Chat voter_chat;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PollAnswer pollAnswer = (PollAnswer) obj;
            if (Objects.equals(this.poll_id, pollAnswer.poll_id) && Objects.equals(this.voter_chat, pollAnswer.voter_chat) && Objects.equals(this.user, pollAnswer.user) && Arrays.equals(this.option_ids, pollAnswer.option_ids)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (Objects.hash(this.poll_id, this.voter_chat, this.user) * 31) + Arrays.hashCode(this.option_ids);
    }

    public Integer[] optionIds() {
        return this.option_ids;
    }

    public String pollId() {
        return this.poll_id;
    }

    public String toString() {
        return "PollAnswer{poll_id='" + this.poll_id + "', voter_chat=" + this.voter_chat + ", user=" + this.user + ", option_ids=" + Arrays.toString(this.option_ids) + '}';
    }

    public User user() {
        return this.user;
    }

    public Chat voterChat() {
        return this.voter_chat;
    }
}
