package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ChatPermissions implements Serializable {
    private static final long serialVersionUID = 0;
    private Boolean can_add_web_page_previews;
    private Boolean can_change_info;
    private Boolean can_delete_stories;
    private Boolean can_edit_stories;
    private Boolean can_invite_users;
    private Boolean can_manage_topics;
    private Boolean can_pin_messages;
    private Boolean can_post_stories;
    private Boolean can_send_audios;
    private Boolean can_send_documents;
    private Boolean can_send_messages;
    private Boolean can_send_other_messages;
    private Boolean can_send_photos;
    private Boolean can_send_polls;
    private Boolean can_send_video_notes;
    private Boolean can_send_videos;
    private Boolean can_send_voice_notes;

    public Boolean canAddWebPagePreviews() {
        Boolean bool = this.can_add_web_page_previews;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canChangeInfo() {
        Boolean bool = this.can_change_info;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canDeleteStories() {
        Boolean bool = this.can_delete_stories;
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

    public Boolean canManageTopics() {
        Boolean bool = this.can_manage_topics;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canPinMessages() {
        Boolean bool = this.can_pin_messages;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canPostStories() {
        Boolean bool = this.can_post_stories;
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

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ChatPermissions chatPermissions = (ChatPermissions) obj;
            if (Objects.equals(this.can_send_messages, chatPermissions.can_send_messages) && Objects.equals(this.can_send_audios, chatPermissions.can_send_audios) && Objects.equals(this.can_send_documents, chatPermissions.can_send_documents) && Objects.equals(this.can_send_photos, chatPermissions.can_send_photos) && Objects.equals(this.can_send_videos, chatPermissions.can_send_videos) && Objects.equals(this.can_send_video_notes, chatPermissions.can_send_video_notes) && Objects.equals(this.can_send_voice_notes, chatPermissions.can_send_voice_notes) && Objects.equals(this.can_send_polls, chatPermissions.can_send_polls) && Objects.equals(this.can_send_other_messages, chatPermissions.can_send_other_messages) && Objects.equals(this.can_add_web_page_previews, chatPermissions.can_add_web_page_previews) && Objects.equals(this.can_change_info, chatPermissions.can_change_info) && Objects.equals(this.can_invite_users, chatPermissions.can_invite_users) && Objects.equals(this.can_pin_messages, chatPermissions.can_pin_messages) && Objects.equals(this.can_manage_topics, chatPermissions.can_manage_topics) && Objects.equals(this.can_post_stories, chatPermissions.can_post_stories) && Objects.equals(this.can_edit_stories, chatPermissions.can_edit_stories) && Objects.equals(this.can_delete_stories, chatPermissions.can_delete_stories)) {
                return true;
            }
        }
        return false;
    }

    public ChatPermissions canAddWebPagePreviews(boolean z10) {
        this.can_add_web_page_previews = Boolean.valueOf(z10);
        return this;
    }

    public ChatPermissions canChangeInfo(boolean z10) {
        this.can_change_info = Boolean.valueOf(z10);
        return this;
    }

    public ChatPermissions canDeleteStories(Boolean bool) {
        this.can_delete_stories = bool;
        return this;
    }

    public ChatPermissions canEditStories(Boolean bool) {
        this.can_edit_stories = bool;
        return this;
    }

    public ChatPermissions canInviteUsers(boolean z10) {
        this.can_invite_users = Boolean.valueOf(z10);
        return this;
    }

    public ChatPermissions canManageTopics(boolean z10) {
        this.can_manage_topics = Boolean.valueOf(z10);
        return this;
    }

    public ChatPermissions canPinMessages(boolean z10) {
        this.can_pin_messages = Boolean.valueOf(z10);
        return this;
    }

    public ChatPermissions canPostStories(Boolean bool) {
        this.can_post_stories = bool;
        return this;
    }

    public ChatPermissions canSendAudios(boolean z10) {
        this.can_send_audios = Boolean.valueOf(z10);
        return this;
    }

    public ChatPermissions canSendDocuments(boolean z10) {
        this.can_send_documents = Boolean.valueOf(z10);
        return this;
    }

    public ChatPermissions canSendMessages(boolean z10) {
        this.can_send_messages = Boolean.valueOf(z10);
        return this;
    }

    public ChatPermissions canSendOtherMessages(boolean z10) {
        this.can_send_other_messages = Boolean.valueOf(z10);
        return this;
    }

    public ChatPermissions canSendPhotos(boolean z10) {
        this.can_send_photos = Boolean.valueOf(z10);
        return this;
    }

    public ChatPermissions canSendPolls(boolean z10) {
        this.can_send_polls = Boolean.valueOf(z10);
        return this;
    }

    public ChatPermissions canSendVideoNotes(boolean z10) {
        this.can_send_video_notes = Boolean.valueOf(z10);
        return this;
    }

    public ChatPermissions canSendVideos(boolean z10) {
        this.can_send_videos = Boolean.valueOf(z10);
        return this;
    }

    public ChatPermissions canSendVoiceNotes(boolean z10) {
        this.can_send_voice_notes = Boolean.valueOf(z10);
        return this;
    }

    public int hashCode() {
        return Objects.hash(this.can_send_messages, this.can_send_audios, this.can_send_documents, this.can_send_photos, this.can_send_videos, this.can_send_video_notes, this.can_send_voice_notes, this.can_send_polls, this.can_send_other_messages, this.can_add_web_page_previews, this.can_change_info, this.can_invite_users, this.can_pin_messages, this.can_manage_topics, this.can_post_stories, this.can_edit_stories, this.can_delete_stories);
    }

    public String toString() {
        return "ChatPermissions{can_send_messages=" + this.can_send_messages + ", can_send_audios=" + this.can_send_audios + ", can_send_documents=" + this.can_send_documents + ", can_send_photos=" + this.can_send_photos + ", can_send_videos=" + this.can_send_videos + ", can_send_video_notes=" + this.can_send_video_notes + ", can_send_voice_notes=" + this.can_send_voice_notes + ", can_send_polls=" + this.can_send_polls + ", can_send_other_messages=" + this.can_send_other_messages + ", can_add_web_page_previews=" + this.can_add_web_page_previews + ", can_change_info=" + this.can_change_info + ", can_invite_users=" + this.can_invite_users + ", can_pin_messages=" + this.can_pin_messages + ", can_manage_topics=" + this.can_manage_topics + ", can_post_stories=" + this.can_post_stories + ", can_edit_stories=" + this.can_edit_stories + ", can_delete_stories=" + this.can_delete_stories + '}';
    }
}
