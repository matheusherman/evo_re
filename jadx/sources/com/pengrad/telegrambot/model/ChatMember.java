package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ChatMember implements Serializable {
    private static final long serialVersionUID = 0;
    private Boolean can_add_web_page_previews;
    private Boolean can_be_edited;
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
    private Boolean can_send_audios;
    private Boolean can_send_documents;
    private Boolean can_send_messages;
    private Boolean can_send_other_messages;
    private Boolean can_send_photos;
    private Boolean can_send_polls;
    private Boolean can_send_video_notes;
    private Boolean can_send_videos;
    private Boolean can_send_voice_notes;
    private String custom_title;
    private Boolean is_anonymous;
    private Boolean is_member;
    private Status status;
    private Integer until_date;
    private User user;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum Status {
        creator,
        administrator,
        member,
        restricted,
        left,
        kicked
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ChatMember chatMember = (ChatMember) obj;
            if (Objects.equals(this.user, chatMember.user) && this.status == chatMember.status && Objects.equals(this.custom_title, chatMember.custom_title) && Objects.equals(this.is_anonymous, chatMember.is_anonymous) && Objects.equals(this.until_date, chatMember.until_date) && Objects.equals(this.can_be_edited, chatMember.can_be_edited) && Objects.equals(this.can_manage_chat, chatMember.can_manage_chat) && Objects.equals(this.can_post_messages, chatMember.can_post_messages) && Objects.equals(this.can_edit_messages, chatMember.can_edit_messages) && Objects.equals(this.can_delete_messages, chatMember.can_delete_messages) && Objects.equals(this.can_manage_video_chats, chatMember.can_manage_video_chats) && Objects.equals(this.can_restrict_members, chatMember.can_restrict_members) && Objects.equals(this.can_promote_members, chatMember.can_promote_members) && Objects.equals(this.can_change_info, chatMember.can_change_info) && Objects.equals(this.can_invite_users, chatMember.can_invite_users) && Objects.equals(this.can_pin_messages, chatMember.can_pin_messages) && Objects.equals(this.can_post_stories, chatMember.can_post_stories) && Objects.equals(this.can_edit_stories, chatMember.can_edit_stories) && Objects.equals(this.can_delete_stories, chatMember.can_delete_stories) && Objects.equals(this.can_manage_topics, chatMember.can_manage_topics) && Objects.equals(this.can_manage_direct_messages, chatMember.can_manage_direct_messages) && Objects.equals(this.is_member, chatMember.is_member) && Objects.equals(this.can_send_messages, chatMember.can_send_messages) && Objects.equals(this.can_send_audios, chatMember.can_send_audios) && Objects.equals(this.can_send_documents, chatMember.can_send_documents) && Objects.equals(this.can_send_photos, chatMember.can_send_photos) && Objects.equals(this.can_send_videos, chatMember.can_send_videos) && Objects.equals(this.can_send_video_notes, chatMember.can_send_video_notes) && Objects.equals(this.can_send_voice_notes, chatMember.can_send_voice_notes) && Objects.equals(this.can_send_polls, chatMember.can_send_polls) && Objects.equals(this.can_send_other_messages, chatMember.can_send_other_messages) && Objects.equals(this.can_add_web_page_previews, chatMember.can_add_web_page_previews)) {
                return true;
            }
        }
        return false;
    }

    public Boolean canAddWebPagePreviews() {
        Boolean bool = this.can_add_web_page_previews;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canBeEdited() {
        Boolean bool = this.can_be_edited;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

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

    public Boolean canSendAudios() {
        Boolean bool = this.can_send_audios;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canSendDocuments() {
        Boolean bool = this.can_send_documents;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canSendMessages() {
        Boolean bool = this.can_send_messages;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canSendOtherMessages() {
        Boolean bool = this.can_send_other_messages;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canSendPhotos() {
        Boolean bool = this.can_send_photos;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canSendPolls() {
        Boolean bool = this.can_send_polls;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canSendVideoNotes() {
        Boolean bool = this.can_send_video_notes;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canSendVideos() {
        Boolean bool = this.can_send_videos;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canSendVoiceNotes() {
        Boolean bool = this.can_send_voice_notes;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public String customTitle() {
        return this.custom_title;
    }

    public int hashCode() {
        return Objects.hash(this.user, this.status, this.custom_title, this.is_anonymous, this.until_date, this.can_be_edited, this.can_manage_chat, this.can_post_messages, this.can_edit_messages, this.can_delete_messages, this.can_manage_video_chats, this.can_restrict_members, this.can_promote_members, this.can_change_info, this.can_invite_users, this.can_pin_messages, this.can_post_stories, this.can_edit_stories, this.can_delete_stories, this.can_manage_topics, this.can_manage_direct_messages, this.is_member, this.can_send_messages, this.can_send_audios, this.can_send_documents, this.can_send_photos, this.can_send_videos, this.can_send_video_notes, this.can_send_voice_notes, this.can_send_polls, this.can_send_other_messages, this.can_add_web_page_previews);
    }

    public Boolean isAnonymous() {
        Boolean bool = this.is_anonymous;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean isMember() {
        Boolean bool = this.is_member;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Status status() {
        return this.status;
    }

    public String toString() {
        return "ChatMember{user=" + this.user + ", status=" + this.status + ", custom_title='" + this.custom_title + "', is_anonymous=" + this.is_anonymous + ", until_date=" + this.until_date + ", can_be_edited=" + this.can_be_edited + ", can_manage_chat=" + this.can_manage_chat + ", can_post_messages=" + this.can_post_messages + ", can_edit_messages=" + this.can_edit_messages + ", can_delete_messages=" + this.can_delete_messages + ", can_manage_video_chats=" + this.can_manage_video_chats + ", can_restrict_members=" + this.can_restrict_members + ", can_promote_members=" + this.can_promote_members + ", can_change_info=" + this.can_change_info + ", can_invite_users=" + this.can_invite_users + ", can_pin_messages=" + this.can_pin_messages + ", can_post_stories=" + this.can_post_stories + ", can_edit_stories=" + this.can_edit_stories + ", can_delete_stories=" + this.can_delete_stories + ", can_manage_topics=" + this.can_manage_topics + ", can_manage_direct_messages=" + this.can_manage_direct_messages + ", is_member=" + this.is_member + ", can_send_messages=" + this.can_send_messages + ", can_send_audios=" + this.can_send_audios + ", can_send_documents=" + this.can_send_documents + ", can_send_photos=" + this.can_send_photos + ", can_send_videos=" + this.can_send_videos + ", can_send_video_notes=" + this.can_send_video_notes + ", can_send_voice_notes=" + this.can_send_voice_notes + ", can_send_polls=" + this.can_send_polls + ", can_send_other_messages=" + this.can_send_other_messages + ", can_add_web_page_previews=" + this.can_add_web_page_previews + '}';
    }

    public Integer untilDate() {
        return this.until_date;
    }

    public User user() {
        return this.user;
    }
}
