package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ChatAdministratorRights implements Serializable {
    private static final long serialVersionUID = 0;
    private Boolean can_change_info;
    private Boolean can_delete_messages;
    private Boolean can_delete_stories;
    private Boolean can_edit_messages;
    private Boolean can_edit_stories;
    private Boolean can_invite_users;
    private Boolean can_manage_chat;
    private Boolean can_manage_direct_messages;
    private Boolean can_manage_topics;
    private Boolean can_manage_video_chats;
    private Boolean can_pin_messages;
    private Boolean can_post_messages;
    private Boolean can_post_stories;
    private Boolean can_promote_members;
    private Boolean can_restrict_members;
    private Boolean is_anonymous;

    public Boolean canChangeInfo() {
        Boolean bool = this.can_change_info;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canDeleteMessages() {
        Boolean bool = this.can_delete_messages;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canDeleteStories() {
        Boolean bool = this.can_delete_stories;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canEditMessages() {
        Boolean bool = this.can_edit_messages;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canEditStories() {
        Boolean bool = this.can_edit_stories;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canInviteUsers() {
        Boolean bool = this.can_invite_users;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canManageChat() {
        Boolean bool = this.can_manage_chat;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canManageDirectMessages() {
        Boolean bool = this.can_manage_direct_messages;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canManageTopics() {
        Boolean bool = this.can_manage_topics;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canManageVideoChats() {
        Boolean bool = this.can_manage_video_chats;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canPinMessages() {
        Boolean bool = this.can_pin_messages;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canPostMessages() {
        Boolean bool = this.can_post_messages;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canPostStories() {
        Boolean bool = this.can_post_stories;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canPromoteMembers() {
        Boolean bool = this.can_promote_members;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canRestrictMembers() {
        Boolean bool = this.can_restrict_members;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ChatAdministratorRights chatAdministratorRights = (ChatAdministratorRights) obj;
            if (Objects.equals(this.is_anonymous, chatAdministratorRights.is_anonymous) && Objects.equals(this.can_manage_chat, chatAdministratorRights.can_manage_chat) && Objects.equals(this.can_delete_messages, chatAdministratorRights.can_delete_messages) && Objects.equals(this.can_manage_video_chats, chatAdministratorRights.can_manage_video_chats) && Objects.equals(this.can_restrict_members, chatAdministratorRights.can_restrict_members) && Objects.equals(this.can_promote_members, chatAdministratorRights.can_promote_members) && Objects.equals(this.can_change_info, chatAdministratorRights.can_change_info) && Objects.equals(this.can_invite_users, chatAdministratorRights.can_invite_users) && Objects.equals(this.can_post_messages, chatAdministratorRights.can_post_messages) && Objects.equals(this.can_edit_messages, chatAdministratorRights.can_edit_messages) && Objects.equals(this.can_pin_messages, chatAdministratorRights.can_pin_messages) && Objects.equals(this.can_post_stories, chatAdministratorRights.can_post_stories) && Objects.equals(this.can_edit_stories, chatAdministratorRights.can_edit_stories) && Objects.equals(this.can_delete_stories, chatAdministratorRights.can_delete_stories) && Objects.equals(this.can_manage_topics, chatAdministratorRights.can_manage_topics) && Objects.equals(this.can_manage_direct_messages, chatAdministratorRights.can_manage_direct_messages)) {
                return true;
            }
        }
        return false;
    }

    public ChatAdministratorRights canChangeInfo(boolean z10) {
        this.can_change_info = Boolean.valueOf(z10);
        return this;
    }

    public ChatAdministratorRights canDeleteMessages(boolean z10) {
        this.can_delete_messages = Boolean.valueOf(z10);
        return this;
    }

    public ChatAdministratorRights canDeleteStories(boolean z10) {
        this.can_delete_stories = Boolean.valueOf(z10);
        return this;
    }

    public ChatAdministratorRights canEditMessages(boolean z10) {
        this.can_edit_messages = Boolean.valueOf(z10);
        return this;
    }

    public ChatAdministratorRights canEditStories(boolean z10) {
        this.can_edit_stories = Boolean.valueOf(z10);
        return this;
    }

    public ChatAdministratorRights canInviteUsers(boolean z10) {
        this.can_invite_users = Boolean.valueOf(z10);
        return this;
    }

    public ChatAdministratorRights canManageChat(boolean z10) {
        this.can_manage_chat = Boolean.valueOf(z10);
        return this;
    }

    public ChatAdministratorRights canManageDirectMessages(boolean z10) {
        this.can_manage_direct_messages = Boolean.valueOf(z10);
        return this;
    }

    public ChatAdministratorRights canManageTopics(boolean z10) {
        this.can_manage_topics = Boolean.valueOf(z10);
        return this;
    }

    public ChatAdministratorRights canManageVideoChats(boolean z10) {
        this.can_manage_video_chats = Boolean.valueOf(z10);
        return this;
    }

    public ChatAdministratorRights canPinMessages(boolean z10) {
        this.can_pin_messages = Boolean.valueOf(z10);
        return this;
    }

    public ChatAdministratorRights canPostMessages(boolean z10) {
        this.can_post_messages = Boolean.valueOf(z10);
        return this;
    }

    public ChatAdministratorRights canPostStories(boolean z10) {
        this.can_post_stories = Boolean.valueOf(z10);
        return this;
    }

    public ChatAdministratorRights canPromoteMembers(boolean z10) {
        this.can_promote_members = Boolean.valueOf(z10);
        return this;
    }

    public ChatAdministratorRights canRestrictMembers(boolean z10) {
        this.can_restrict_members = Boolean.valueOf(z10);
        return this;
    }

    public int hashCode() {
        return Objects.hash(this.is_anonymous, this.can_manage_chat, this.can_delete_messages, this.can_manage_video_chats, this.can_restrict_members, this.can_promote_members, this.can_change_info, this.can_invite_users, this.can_post_messages, this.can_edit_messages, this.can_pin_messages, this.can_post_stories, this.can_edit_stories, this.can_delete_stories, this.can_manage_topics, this.can_manage_direct_messages);
    }

    public Boolean isAnonymous() {
        Boolean bool = this.is_anonymous;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public String toString() {
        return "ChatAdministratorRights{is_anonymous=" + this.is_anonymous + ", can_manage_chat=" + this.can_manage_chat + ", can_delete_messages='" + this.can_delete_messages + "', can_manage_video_chats=" + this.can_manage_video_chats + ", can_restrict_members=" + this.can_restrict_members + ", can_promote_members=" + this.can_promote_members + ", can_change_info=" + this.can_change_info + ", can_invite_users=" + this.can_invite_users + ", can_post_messages=" + this.can_post_messages + ", can_edit_messages=" + this.can_edit_messages + ", can_pin_messages=" + this.can_pin_messages + ", can_post_stories=" + this.can_post_stories + ", can_edit_stories=" + this.can_edit_stories + ", can_delete_stories=" + this.can_delete_stories + ", can_manage_topics=" + this.can_manage_topics + ", can_manage_direct_messages=" + this.can_manage_direct_messages + '}';
    }
}
