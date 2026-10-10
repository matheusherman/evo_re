package com.pengrad.telegrambot.model;

import com.pengrad.telegrambot.model.business.BusinessIntro;
import com.pengrad.telegrambot.model.business.BusinessLocation;
import com.pengrad.telegrambot.model.business.BusinessOpeningHours;
import com.pengrad.telegrambot.model.gift.AcceptedGiftTypes;
import com.pengrad.telegrambot.model.reaction.ReactionType;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ChatFullInfo implements Serializable {
    private static final long serialVersionUID = 0;
    private Integer accent_color_id;
    private AcceptedGiftTypes accepted_gift_types;
    private String[] active_usernames;
    private ReactionType[] available_reactions;
    private String background_custom_emoji_id;
    private String bio;
    private Birthdate birthdate;
    private BusinessIntro business_intro;
    private BusinessLocation business_location;
    private BusinessOpeningHours business_opening_hours;
    private Boolean can_send_gift;
    private Boolean can_send_paid_media;
    private Boolean can_set_sticker_set;
    private String custom_emoji_sticker_set_name;
    private String description;
    private String emoji_status_custom_emoji_id;
    private Integer emoji_status_expiration_date;
    private String first_name;
    private Boolean has_aggressive_anti_spam_enabled;
    private Boolean has_hidden_members;
    private Boolean has_private_forwards;
    private Boolean has_protected_content;
    private Boolean has_restricted_voice_and_video_messages;
    private Boolean has_visible_history;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private Long f8233id;
    private String invite_link;
    private Boolean is_direct_messages;
    private Boolean is_forum;
    private Boolean join_by_request;
    private Boolean join_to_send_messages;
    private String last_name;
    private Long linked_chat_id;
    private ChatLocation location;
    private Integer max_reaction_count;
    private Integer message_auto_delete_time;
    private Chat parent_chat;
    private ChatPermissions permissions;
    private Chat personal_chat;
    private ChatPhoto photo;
    private Message pinned_message;
    private Integer profile_accent_color_id;
    private String profile_background_custom_emoji_id;
    private Integer slow_mode_delay;
    private String sticker_set_name;
    private String title;
    private Type type;
    private Integer unrestrict_boost_count;
    private String username;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum Type {
        Private,
        group,
        supergroup,
        channel
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ChatFullInfo chatFullInfo = (ChatFullInfo) obj;
            if (Objects.equals(this.f8233id, chatFullInfo.f8233id) && this.type == chatFullInfo.type && Objects.equals(this.first_name, chatFullInfo.first_name) && Objects.equals(this.last_name, chatFullInfo.last_name) && Objects.equals(this.is_forum, chatFullInfo.is_forum) && Objects.equals(this.is_direct_messages, chatFullInfo.is_direct_messages) && Objects.equals(this.username, chatFullInfo.username) && Objects.equals(this.title, chatFullInfo.title) && Objects.equals(this.photo, chatFullInfo.photo) && Arrays.equals(this.active_usernames, chatFullInfo.active_usernames) && Objects.equals(this.birthdate, chatFullInfo.birthdate) && Objects.equals(this.business_intro, chatFullInfo.business_intro) && Objects.equals(this.business_location, chatFullInfo.business_location) && Objects.equals(this.business_opening_hours, chatFullInfo.business_opening_hours) && Objects.equals(this.personal_chat, chatFullInfo.personal_chat) && Objects.equals(this.parent_chat, chatFullInfo.parent_chat) && Arrays.equals(this.available_reactions, chatFullInfo.available_reactions) && Objects.equals(this.accent_color_id, chatFullInfo.accent_color_id) && Objects.equals(this.max_reaction_count, chatFullInfo.max_reaction_count) && Objects.equals(this.background_custom_emoji_id, chatFullInfo.background_custom_emoji_id) && Objects.equals(this.profile_accent_color_id, chatFullInfo.profile_accent_color_id) && Objects.equals(this.profile_background_custom_emoji_id, chatFullInfo.profile_background_custom_emoji_id) && Objects.equals(this.emoji_status_custom_emoji_id, chatFullInfo.emoji_status_custom_emoji_id) && Objects.equals(this.emoji_status_expiration_date, chatFullInfo.emoji_status_expiration_date) && Objects.equals(this.bio, chatFullInfo.bio) && Objects.equals(this.has_private_forwards, chatFullInfo.has_private_forwards) && Objects.equals(this.has_restricted_voice_and_video_messages, chatFullInfo.has_restricted_voice_and_video_messages) && Objects.equals(this.has_hidden_members, chatFullInfo.has_hidden_members) && Objects.equals(this.has_aggressive_anti_spam_enabled, chatFullInfo.has_aggressive_anti_spam_enabled) && Objects.equals(this.join_to_send_messages, chatFullInfo.join_to_send_messages) && Objects.equals(this.join_by_request, chatFullInfo.join_by_request) && Objects.equals(this.description, chatFullInfo.description) && Objects.equals(this.invite_link, chatFullInfo.invite_link) && Objects.equals(this.pinned_message, chatFullInfo.pinned_message) && Objects.equals(this.permissions, chatFullInfo.permissions) && Objects.equals(this.can_send_paid_media, chatFullInfo.can_send_paid_media) && Objects.equals(this.slow_mode_delay, chatFullInfo.slow_mode_delay) && Objects.equals(this.unrestrict_boost_count, chatFullInfo.unrestrict_boost_count) && Objects.equals(this.message_auto_delete_time, chatFullInfo.message_auto_delete_time) && Objects.equals(this.has_protected_content, chatFullInfo.has_protected_content) && Objects.equals(this.has_visible_history, chatFullInfo.has_visible_history) && Objects.equals(this.sticker_set_name, chatFullInfo.sticker_set_name) && Objects.equals(this.can_set_sticker_set, chatFullInfo.can_set_sticker_set) && Objects.equals(this.custom_emoji_sticker_set_name, chatFullInfo.custom_emoji_sticker_set_name) && Objects.equals(this.linked_chat_id, chatFullInfo.linked_chat_id) && Objects.equals(this.location, chatFullInfo.location) && Objects.equals(this.accepted_gift_types, chatFullInfo.accepted_gift_types)) {
                return true;
            }
        }
        return false;
    }

    public Integer accentColorId() {
        return this.accent_color_id;
    }

    public AcceptedGiftTypes acceptedGiftTypes() {
        return this.accepted_gift_types;
    }

    public String[] activeUsernames() {
        return this.active_usernames;
    }

    public ReactionType[] availableReactions() {
        return this.available_reactions;
    }

    public String backgroundCustomEmojiId() {
        return this.background_custom_emoji_id;
    }

    public String bio() {
        return this.bio;
    }

    public Birthdate birthdate() {
        return this.birthdate;
    }

    public BusinessIntro businessIntro() {
        return this.business_intro;
    }

    public BusinessLocation businessLocation() {
        return this.business_location;
    }

    public BusinessOpeningHours businessOpeningHours() {
        return this.business_opening_hours;
    }

    @Deprecated
    public Boolean canSendGift() {
        return this.can_send_gift;
    }

    public Boolean canSendPaidMedia() {
        return this.can_send_paid_media;
    }

    public Boolean canSetStickerSet() {
        Boolean bool = this.can_set_sticker_set;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public String customEmojiStickerSetName() {
        return this.custom_emoji_sticker_set_name;
    }

    public String description() {
        return this.description;
    }

    public String emojiStatusCustomEmojiId() {
        return this.emoji_status_custom_emoji_id;
    }

    public Integer emojiStatusExpirationDate() {
        return this.emoji_status_expiration_date;
    }

    public String firstName() {
        return this.first_name;
    }

    public Boolean hasAggressiveAntiSpamEnabled() {
        Boolean bool = this.has_aggressive_anti_spam_enabled;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean hasHiddenMembers() {
        Boolean bool = this.has_hidden_members;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean hasPrivateForwards() {
        Boolean bool = this.has_private_forwards;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean hasProtectedContent() {
        Boolean bool = this.has_protected_content;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean hasRestrictedVoiceAndVideoMessages() {
        Boolean bool = this.has_restricted_voice_and_video_messages;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean hasVisibleHistory() {
        Boolean bool = this.has_visible_history;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public int hashCode() {
        Long l10 = this.f8233id;
        if (l10 != null) {
            return l10.hashCode();
        }
        return 0;
    }

    public Long id() {
        return this.f8233id;
    }

    public String inviteLink() {
        return this.invite_link;
    }

    public Boolean isDirectMessages() {
        Boolean bool = this.is_direct_messages;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean isForum() {
        Boolean bool = this.is_forum;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean joinByRequest() {
        Boolean bool = this.join_by_request;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean joinToSendMessages() {
        Boolean bool = this.join_to_send_messages;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public String lastName() {
        return this.last_name;
    }

    public Long linkedChatId() {
        return this.linked_chat_id;
    }

    public ChatLocation location() {
        return this.location;
    }

    public Integer maxReactionCount() {
        return this.max_reaction_count;
    }

    public Integer messageAutoDeleteTime() {
        return this.message_auto_delete_time;
    }

    public Chat parentChat() {
        return this.parent_chat;
    }

    public ChatPermissions permissions() {
        return this.permissions;
    }

    public Chat personalChat() {
        return this.personal_chat;
    }

    public ChatPhoto photo() {
        return this.photo;
    }

    public Message pinnedMessage() {
        return this.pinned_message;
    }

    public Integer profileAccentColorId() {
        return this.profile_accent_color_id;
    }

    public String profileBackgroundCustomEmojiId() {
        return this.profile_background_custom_emoji_id;
    }

    public Integer slowModeDelay() {
        return this.slow_mode_delay;
    }

    public String stickerSetName() {
        return this.sticker_set_name;
    }

    public String title() {
        return this.title;
    }

    public String toString() {
        return "ChatFullInfo{id=" + this.f8233id + ", type=" + this.type + ", first_name='" + this.first_name + "', last_name='" + this.last_name + "', is_forum=" + this.is_forum + ", is_direct_messages=" + this.is_direct_messages + ", username='" + this.username + "', title='" + this.title + "', photo=" + this.photo + ", active_usernames=" + Arrays.toString(this.active_usernames) + ", birthdate=" + this.birthdate + ", business_intro=" + this.business_intro + ", business_location=" + this.business_location + ", business_opening_hours=" + this.business_opening_hours + ", personal_chat=" + this.personal_chat + ", parent_chat=" + this.parent_chat + ", available_reactions=" + Arrays.toString(this.available_reactions) + ", accent_color_id=" + this.accent_color_id + ", max_reaction_count=" + this.max_reaction_count + ", background_custom_emoji_id='" + this.background_custom_emoji_id + "', profile_accent_color_id=" + this.profile_accent_color_id + ", profile_background_custom_emoji_id='" + this.profile_background_custom_emoji_id + "', emoji_status_custom_emoji_id='" + this.emoji_status_custom_emoji_id + "', emoji_status_expiration_date='" + this.emoji_status_expiration_date + "', bio='" + this.bio + "', has_private_forwards=" + this.has_private_forwards + ", has_restricted_voice_and_video_messages=" + this.has_restricted_voice_and_video_messages + ", has_hidden_members=" + this.has_hidden_members + ", has_aggressive_anti_spam_enabled=" + this.has_aggressive_anti_spam_enabled + ", join_to_send_messages=" + this.join_to_send_messages + ", join_by_request=" + this.join_by_request + ", description='" + this.description + "', invite_link='" + this.invite_link + "', pinned_message=" + this.pinned_message + ", permissions=" + this.permissions + ", can_send_paid_media=" + this.can_send_paid_media + ", slow_mode_delay=" + this.slow_mode_delay + ", unrestrict_boost_count=" + this.unrestrict_boost_count + ", message_auto_delete_time=" + this.message_auto_delete_time + ", has_protected_content=" + this.has_protected_content + ", has_visible_history=" + this.has_visible_history + ", sticker_set_name='" + this.sticker_set_name + "', can_set_sticker_set=" + this.can_set_sticker_set + ", custom_emoji_sticker_set_name=" + this.custom_emoji_sticker_set_name + ", linked_chat_id=" + this.linked_chat_id + ", location=" + this.location + ", accepted_gift_types=" + this.accepted_gift_types + '}';
    }

    public Type type() {
        return this.type;
    }

    public Integer unrestrictBoostCount() {
        return this.unrestrict_boost_count;
    }

    public String username() {
        return this.username;
    }
}
