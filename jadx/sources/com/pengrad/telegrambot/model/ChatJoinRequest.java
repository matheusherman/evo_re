package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ChatJoinRequest implements Serializable {
    private static final long serialVersionUID = 0;
    private String bio;
    private Chat chat;
    private Integer date;
    private User from;
    private ChatInviteLink invite_link;
    private Long user_chat_id;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ChatJoinRequest chatJoinRequest = (ChatJoinRequest) obj;
            if (Objects.equals(this.chat, chatJoinRequest.chat) && Objects.equals(this.from, chatJoinRequest.from) && Objects.equals(this.user_chat_id, chatJoinRequest.user_chat_id) && Objects.equals(this.date, chatJoinRequest.date) && Objects.equals(this.bio, chatJoinRequest.bio) && Objects.equals(this.invite_link, chatJoinRequest.invite_link)) {
                return true;
            }
        }
        return false;
    }

    public String bio() {
        return this.bio;
    }

    public Chat chat() {
        return this.chat;
    }

    public Integer date() {
        return this.date;
    }

    public User from() {
        return this.from;
    }

    public int hashCode() {
        return Objects.hash(this.chat, this.from, this.user_chat_id, this.date, this.bio, this.invite_link);
    }

    public ChatInviteLink inviteLink() {
        return this.invite_link;
    }

    public String toString() {
        return "ChatJoinRequest{chat=" + this.chat + ", from=" + this.from + ", user_chat_id=" + this.user_chat_id + ", date=" + this.date + ", bio=" + this.bio + ", invite_link=" + this.invite_link + '}';
    }

    public Long userChatId() {
        return this.user_chat_id;
    }
}
