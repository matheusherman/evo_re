package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ChatMemberUpdated implements Serializable {
    private static final long serialVersionUID = 0;
    private Chat chat;
    private Integer date;
    private User from;
    private ChatInviteLink invite_link;
    private ChatMember new_chat_member;
    private ChatMember old_chat_member;
    private Boolean via_chat_folder_invite_link;
    private Boolean via_join_request;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ChatMemberUpdated chatMemberUpdated = (ChatMemberUpdated) obj;
            if (Objects.equals(this.chat, chatMemberUpdated.chat) && Objects.equals(this.from, chatMemberUpdated.from) && Objects.equals(this.date, chatMemberUpdated.date) && Objects.equals(this.old_chat_member, chatMemberUpdated.old_chat_member) && Objects.equals(this.new_chat_member, chatMemberUpdated.new_chat_member) && Objects.equals(this.invite_link, chatMemberUpdated.invite_link) && Objects.equals(this.via_chat_folder_invite_link, chatMemberUpdated.via_chat_folder_invite_link) && Objects.equals(this.via_join_request, chatMemberUpdated.via_join_request)) {
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

    public User from() {
        return this.from;
    }

    public int hashCode() {
        return Objects.hash(this.chat, this.from, this.date, this.old_chat_member, this.new_chat_member, this.invite_link, this.via_chat_folder_invite_link, this.via_join_request);
    }

    public ChatInviteLink inviteLink() {
        return this.invite_link;
    }

    public ChatMember newChatMember() {
        return this.new_chat_member;
    }

    public ChatMember oldChatMember() {
        return this.old_chat_member;
    }

    public String toString() {
        return "ChatMemberUpdated{chat=" + this.chat + ", from=" + this.from + ", date=" + this.date + ", old_chat_member=" + this.old_chat_member + ", new_chat_member=" + this.new_chat_member + ", invite_link=" + this.invite_link + ", via_chat_folder_invite_link=" + this.via_chat_folder_invite_link + ", via_join_request=" + this.via_join_request + '}';
    }

    public Boolean viaChatFolderInviteLink() {
        return this.via_chat_folder_invite_link;
    }

    public Boolean viaJoinRequest() {
        return this.via_join_request;
    }
}
