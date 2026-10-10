package com.pengrad.telegrambot.model;

import com.pengrad.telegrambot.model.chatbackground.ChatBackground;
import com.pengrad.telegrambot.model.chatboost.ChatBoostAdded;
import com.pengrad.telegrambot.model.checklist.Checklist;
import com.pengrad.telegrambot.model.checklist.ChecklistTasksAdded;
import com.pengrad.telegrambot.model.checklist.ChecklistTasksDone;
import com.pengrad.telegrambot.model.gift.GiftInfo;
import com.pengrad.telegrambot.model.gift.unique.UniqueGiftInfo;
import com.pengrad.telegrambot.model.giveaway.Giveaway;
import com.pengrad.telegrambot.model.giveaway.GiveawayCompleted;
import com.pengrad.telegrambot.model.giveaway.GiveawayCreated;
import com.pengrad.telegrambot.model.giveaway.GiveawayWinners;
import com.pengrad.telegrambot.model.message.MaybeInaccessibleMessage;
import com.pengrad.telegrambot.model.message.origin.MessageOrigin;
import com.pengrad.telegrambot.model.paidmedia.PaidMediaInfo;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.stars.DirectMessagePriceChanged;
import com.pengrad.telegrambot.model.stars.PaidMessagePriceChanged;
import com.pengrad.telegrambot.model.suggestedposts.SuggestedPostApprovalFailed;
import com.pengrad.telegrambot.model.suggestedposts.SuggestedPostApproved;
import com.pengrad.telegrambot.model.suggestedposts.SuggestedPostDeclined;
import com.pengrad.telegrambot.model.suggestedposts.SuggestedPostInfo;
import com.pengrad.telegrambot.model.suggestedposts.SuggestedPostPaid;
import com.pengrad.telegrambot.model.suggestedposts.SuggestedPostRefunded;
import com.pengrad.telegrambot.passport.PassportData;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class Message extends MaybeInaccessibleMessage implements Serializable {
    private static final long serialVersionUID = 0;
    private Animation animation;
    private Audio audio;
    private String author_signature;
    private ChatBoostAdded boost_added;
    private String business_connection_id;
    private String caption;
    private MessageEntity[] caption_entities;
    private Boolean channel_chat_created;
    private ChatBackground chat_background_set;
    private ChatShared chat_shared;
    private Checklist checklist;
    private ChecklistTasksAdded checklist_tasks_added;
    private ChecklistTasksDone checklist_tasks_done;
    private String connected_website;
    private Contact contact;
    private Boolean delete_chat_photo;
    private Dice dice;
    private DirectMessagePriceChanged direct_message_price_changed;
    private DirectMessagesTopic direct_messages_topic;
    private Document document;
    private Integer edit_date;
    private String effect_id;
    private MessageEntity[] entities;
    private ExternalReplyInfo external_reply;
    private ForumTopicClosed forum_topic_closed;
    private ForumTopicCreated forum_topic_created;
    private ForumTopicEdited forum_topic_edited;
    private ForumTopicReopened forum_topic_reopened;
    private MessageOrigin forward_origin;
    private User from;
    private Game game;
    private GeneralForumTopicHidden general_forum_topic_hidden;
    private GeneralForumTopicUnhidden general_forum_topic_unhidden;
    private GiftInfo gift;
    private Giveaway giveaway;
    private GiveawayCompleted giveaway_completed;
    private GiveawayCreated giveaway_created;
    private GiveawayWinners giveaway_winners;
    private Boolean group_chat_created;
    private Boolean has_media_spoiler;
    private Boolean has_protected_content;
    private Invoice invoice;
    private Boolean is_automatic_forward;
    private Boolean is_from_offline;
    private Boolean is_paid_post;
    private Boolean is_topic_message;
    private User left_chat_member;
    private LinkPreviewOptions link_preview_options;
    private Location location;
    private String media_group_id;
    private MessageAutoDeleteTimerChanged message_auto_delete_timer_changed;
    private Integer message_thread_id;
    private Long migrate_from_chat_id;
    private Long migrate_to_chat_id;
    private User[] new_chat_members;
    private PhotoSize[] new_chat_photo;
    private String new_chat_title;
    private PaidMediaInfo paid_media;
    private PaidMessagePriceChanged paid_message_price_changed;
    private Integer paid_star_count;
    private PassportData passport_data;
    private PhotoSize[] photo;
    private MaybeInaccessibleMessage pinned_message;
    private Poll poll;
    private ProximityAlertTriggered proximity_alert_triggered;
    private TextQuote quote;
    private RefundedPayment refunded_payment;
    private InlineKeyboardMarkup reply_markup;
    private Integer reply_to_checklist_task_id;
    private Message reply_to_message;
    private Story reply_to_story;
    private Integer sender_boost_count;
    private User sender_business_bot;
    private Chat sender_chat;
    private Boolean show_caption_above_media;
    private Sticker sticker;
    private Story story;
    private SuccessfulPayment successful_payment;
    private SuggestedPostApprovalFailed suggested_post_approval_failed;
    private SuggestedPostApproved suggested_post_approved;
    private SuggestedPostDeclined suggested_post_declined;
    private SuggestedPostInfo suggested_post_info;
    private SuggestedPostPaid suggested_post_paid;
    private SuggestedPostRefunded suggested_post_refunded;
    private Boolean supergroup_chat_created;
    private String text;
    private UniqueGiftInfo unique_gift;
    private UsersShared users_shared;
    private Venue venue;
    private User via_bot;
    private Video video;
    private VideoChatEnded video_chat_ended;
    private VideoChatParticipantsInvited video_chat_participants_invited;
    private VideoChatScheduled video_chat_scheduled;
    private VideoChatStarted video_chat_started;
    private VideoNote video_note;
    private Voice voice;
    private WebAppData web_app_data;
    private WriteAccessAllowed write_access_allowed;

    @Override // com.pengrad.telegrambot.model.message.MaybeInaccessibleMessage
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Message message = (Message) obj;
            if (Objects.equals(this.message_id, message.message_id) && Objects.equals(this.message_thread_id, message.message_thread_id) && Objects.equals(this.direct_messages_topic, message.direct_messages_topic) && Objects.equals(this.from, message.from) && Objects.equals(this.sender_chat, message.sender_chat) && Objects.equals(this.sender_boost_count, message.sender_boost_count) && Objects.equals(this.date, message.date) && Objects.equals(this.sender_business_bot, message.sender_business_bot) && Objects.equals(this.business_connection_id, message.business_connection_id) && Objects.equals(this.chat, message.chat) && Objects.equals(this.forward_origin, message.forward_origin) && Objects.equals(this.is_topic_message, message.is_topic_message) && Objects.equals(this.is_automatic_forward, message.is_automatic_forward) && Objects.equals(this.reply_to_message, message.reply_to_message) && Objects.equals(this.external_reply, message.external_reply) && Objects.equals(this.quote, message.quote) && Objects.equals(this.reply_to_story, message.reply_to_story) && Objects.equals(this.reply_to_checklist_task_id, message.reply_to_checklist_task_id) && Objects.equals(this.via_bot, message.via_bot) && Objects.equals(this.edit_date, message.edit_date) && Objects.equals(this.has_protected_content, message.has_protected_content) && Objects.equals(this.is_from_offline, message.is_from_offline) && Objects.equals(this.is_paid_post, message.is_paid_post) && Objects.equals(this.has_media_spoiler, message.has_media_spoiler) && Objects.equals(this.media_group_id, message.media_group_id) && Objects.equals(this.author_signature, message.author_signature) && Objects.equals(this.text, message.text) && Arrays.equals(this.entities, message.entities) && Arrays.equals(this.caption_entities, message.caption_entities) && Objects.equals(this.show_caption_above_media, message.show_caption_above_media) && Objects.equals(this.link_preview_options, message.link_preview_options) && Objects.equals(this.suggested_post_info, message.suggested_post_info) && Objects.equals(this.effect_id, message.effect_id) && Objects.equals(this.audio, message.audio) && Objects.equals(this.paid_media, message.paid_media) && Objects.equals(this.document, message.document) && Objects.equals(this.animation, message.animation) && Objects.equals(this.game, message.game) && Arrays.equals(this.photo, message.photo) && Objects.equals(this.sticker, message.sticker) && Objects.equals(this.video, message.video) && Objects.equals(this.voice, message.voice) && Objects.equals(this.video_note, message.video_note) && Objects.equals(this.caption, message.caption) && Objects.equals(this.checklist, message.checklist) && Objects.equals(this.checklist_tasks_done, message.checklist_tasks_done) && Objects.equals(this.checklist_tasks_added, message.checklist_tasks_added) && Objects.equals(this.contact, message.contact) && Objects.equals(this.location, message.location) && Objects.equals(this.venue, message.venue) && Objects.equals(this.poll, message.poll) && Objects.equals(this.dice, message.dice) && Arrays.equals(this.new_chat_members, message.new_chat_members) && Objects.equals(this.left_chat_member, message.left_chat_member) && Objects.equals(this.new_chat_title, message.new_chat_title) && Arrays.equals(this.new_chat_photo, message.new_chat_photo) && Objects.equals(this.delete_chat_photo, message.delete_chat_photo) && Objects.equals(this.group_chat_created, message.group_chat_created) && Objects.equals(this.supergroup_chat_created, message.supergroup_chat_created) && Objects.equals(this.channel_chat_created, message.channel_chat_created) && Objects.equals(this.message_auto_delete_timer_changed, message.message_auto_delete_timer_changed) && Objects.equals(this.migrate_to_chat_id, message.migrate_to_chat_id) && Objects.equals(this.migrate_from_chat_id, message.migrate_from_chat_id) && Objects.equals(this.pinned_message, message.pinned_message) && Objects.equals(this.invoice, message.invoice) && Objects.equals(this.successful_payment, message.successful_payment) && Objects.equals(this.refunded_payment, message.refunded_payment) && Objects.equals(this.story, message.story) && Objects.equals(this.users_shared, message.users_shared) && Objects.equals(this.chat_shared, message.chat_shared) && Objects.equals(this.connected_website, message.connected_website) && Objects.equals(this.passport_data, message.passport_data) && Objects.equals(this.proximity_alert_triggered, message.proximity_alert_triggered) && Objects.equals(this.boost_added, message.boost_added) && Objects.equals(this.chat_background_set, message.chat_background_set) && Objects.equals(this.forum_topic_created, message.forum_topic_created) && Objects.equals(this.forum_topic_edited, message.forum_topic_edited) && Objects.equals(this.forum_topic_closed, message.forum_topic_closed) && Objects.equals(this.forum_topic_reopened, message.forum_topic_reopened) && Objects.equals(this.general_forum_topic_hidden, message.general_forum_topic_hidden) && Objects.equals(this.general_forum_topic_unhidden, message.general_forum_topic_unhidden) && Objects.equals(this.giveaway_created, message.giveaway_created) && Objects.equals(this.giveaway, message.giveaway) && Objects.equals(this.giveaway_winners, message.giveaway_winners) && Objects.equals(this.giveaway_completed, message.giveaway_completed) && Objects.equals(this.write_access_allowed, message.write_access_allowed) && Objects.equals(this.video_chat_started, message.video_chat_started) && Objects.equals(this.video_chat_ended, message.video_chat_ended) && Objects.equals(this.video_chat_participants_invited, message.video_chat_participants_invited) && Objects.equals(this.video_chat_scheduled, message.video_chat_scheduled) && Objects.equals(this.reply_markup, message.reply_markup) && Objects.equals(this.web_app_data, message.web_app_data) && Objects.equals(this.gift, message.gift) && Objects.equals(this.unique_gift, message.unique_gift) && Objects.equals(this.paid_message_price_changed, message.paid_message_price_changed) && Objects.equals(this.suggested_post_approved, message.suggested_post_approved) && Objects.equals(this.suggested_post_approval_failed, message.suggested_post_approval_failed) && Objects.equals(this.suggested_post_declined, message.suggested_post_declined) && Objects.equals(this.suggested_post_paid, message.suggested_post_paid) && Objects.equals(this.suggested_post_refunded, message.suggested_post_refunded) && Objects.equals(this.direct_message_price_changed, message.direct_message_price_changed) && Objects.equals(this.paid_star_count, message.paid_star_count)) {
                return true;
            }
        }
        return false;
    }

    public Animation animation() {
        return this.animation;
    }

    public Audio audio() {
        return this.audio;
    }

    public String authorSignature() {
        return this.author_signature;
    }

    public ChatBoostAdded boostAdded() {
        return this.boost_added;
    }

    public String businessConnectionId() {
        return this.business_connection_id;
    }

    public String caption() {
        return this.caption;
    }

    public MessageEntity[] captionEntities() {
        return this.caption_entities;
    }

    public Boolean channelChatCreated() {
        return this.channel_chat_created;
    }

    public ChatBackground chatBackgroundSet() {
        return this.chat_background_set;
    }

    public ChatShared chatShared() {
        return this.chat_shared;
    }

    public Checklist checklist() {
        return this.checklist;
    }

    public ChecklistTasksAdded checklistTasksAdded() {
        return this.checklist_tasks_added;
    }

    public ChecklistTasksDone checklistTasksDone() {
        return this.checklist_tasks_done;
    }

    public String connectedWebsite() {
        return this.connected_website;
    }

    public Contact contact() {
        return this.contact;
    }

    public Boolean deleteChatPhoto() {
        return this.delete_chat_photo;
    }

    public Dice dice() {
        return this.dice;
    }

    public DirectMessagePriceChanged directMessagePriceChanged() {
        return this.direct_message_price_changed;
    }

    public DirectMessagesTopic directMessagesTopic() {
        return this.direct_messages_topic;
    }

    public Document document() {
        return this.document;
    }

    public Integer editDate() {
        return this.edit_date;
    }

    public String effectId() {
        return this.effect_id;
    }

    public MessageEntity[] entities() {
        return this.entities;
    }

    public ExternalReplyInfo externalReply() {
        return this.external_reply;
    }

    public ForumTopicClosed forumTopicClosed() {
        return this.forum_topic_closed;
    }

    public ForumTopicCreated forumTopicCreated() {
        return this.forum_topic_created;
    }

    public ForumTopicEdited forumTopicEdited() {
        return this.forum_topic_edited;
    }

    public ForumTopicReopened forumTopicReopened() {
        return this.forum_topic_reopened;
    }

    public MessageOrigin forwardOrigin() {
        return this.forward_origin;
    }

    public User from() {
        return this.from;
    }

    public Game game() {
        return this.game;
    }

    public GeneralForumTopicHidden generalForumTopicHidden() {
        return this.general_forum_topic_hidden;
    }

    public GeneralForumTopicUnhidden generalForumTopicUnhidden() {
        return this.general_forum_topic_unhidden;
    }

    public GiftInfo gift() {
        return this.gift;
    }

    public Giveaway giveaway() {
        return this.giveaway;
    }

    public GiveawayCompleted giveawayCompleted() {
        return this.giveaway_completed;
    }

    public GiveawayCreated giveawayCreated() {
        return this.giveaway_created;
    }

    public GiveawayWinners giveawayWinners() {
        return this.giveaway_winners;
    }

    public Boolean groupChatCreated() {
        return this.group_chat_created;
    }

    public Boolean hasMediaSpoiler() {
        Boolean bool = this.has_media_spoiler;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean hasProtectedContent() {
        Boolean bool = this.has_protected_content;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    @Override // com.pengrad.telegrambot.model.message.MaybeInaccessibleMessage
    public int hashCode() {
        Integer num = this.message_id;
        if (num != null) {
            return num.hashCode();
        }
        return 0;
    }

    public Invoice invoice() {
        return this.invoice;
    }

    public Boolean isAutomaticForward() {
        return this.is_automatic_forward;
    }

    public Boolean isFromOffline() {
        Boolean bool = this.is_from_offline;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean isPaidPost() {
        Boolean bool = this.is_paid_post;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean isTopicMessage() {
        Boolean bool = this.is_topic_message;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public User leftChatMember() {
        return this.left_chat_member;
    }

    public LinkPreviewOptions linkPreviewOptions() {
        return this.link_preview_options;
    }

    public Location location() {
        return this.location;
    }

    public String mediaGroupId() {
        return this.media_group_id;
    }

    public MessageAutoDeleteTimerChanged messageAutoDeleteTimerChanged() {
        return this.message_auto_delete_timer_changed;
    }

    public Integer messageThreadId() {
        return this.message_thread_id;
    }

    public Long migrateFromChatId() {
        return this.migrate_from_chat_id;
    }

    public Long migrateToChatId() {
        return this.migrate_to_chat_id;
    }

    public User[] newChatMembers() {
        return this.new_chat_members;
    }

    public PhotoSize[] newChatPhoto() {
        return this.new_chat_photo;
    }

    public String newChatTitle() {
        return this.new_chat_title;
    }

    public PaidMediaInfo paidMedia() {
        return this.paid_media;
    }

    public PaidMessagePriceChanged paidMessagePriceChanged() {
        return this.paid_message_price_changed;
    }

    public Integer paidStarCount() {
        return this.paid_star_count;
    }

    public PassportData passportData() {
        return this.passport_data;
    }

    public PhotoSize[] photo() {
        return this.photo;
    }

    public MaybeInaccessibleMessage pinnedMessage() {
        return this.pinned_message;
    }

    public Poll poll() {
        return this.poll;
    }

    public ProximityAlertTriggered proximityAlertTriggered() {
        return this.proximity_alert_triggered;
    }

    public TextQuote quote() {
        return this.quote;
    }

    public RefundedPayment refundedPayment() {
        return this.refunded_payment;
    }

    public InlineKeyboardMarkup replyMarkup() {
        return this.reply_markup;
    }

    public Integer replyToChecklistTaskId() {
        return this.reply_to_checklist_task_id;
    }

    public Message replyToMessage() {
        return this.reply_to_message;
    }

    public Story replyToStory() {
        return this.reply_to_story;
    }

    public Integer senderBoostCount() {
        return this.sender_boost_count;
    }

    public User senderBusinessBot() {
        return this.sender_business_bot;
    }

    public Chat senderChat() {
        return this.sender_chat;
    }

    void setChat(Chat chat) {
        this.chat = chat;
    }

    void setDate(Integer num) {
        this.date = num;
    }

    void setMessageId(Integer num) {
        this.message_id = num;
    }

    public Boolean showCaptionAboveMedia() {
        return this.show_caption_above_media;
    }

    public Sticker sticker() {
        return this.sticker;
    }

    public Story story() {
        return this.story;
    }

    public SuccessfulPayment successfulPayment() {
        return this.successful_payment;
    }

    public SuggestedPostApprovalFailed suggestedPostApprovalFailed() {
        return this.suggested_post_approval_failed;
    }

    public SuggestedPostApproved suggestedPostApproved() {
        return this.suggested_post_approved;
    }

    public SuggestedPostDeclined suggestedPostDeclined() {
        return this.suggested_post_declined;
    }

    public SuggestedPostInfo suggestedPostInfo() {
        return this.suggested_post_info;
    }

    public SuggestedPostPaid suggestedPostPaid() {
        return this.suggested_post_paid;
    }

    public SuggestedPostRefunded suggestedPostRefunded() {
        return this.suggested_post_refunded;
    }

    public Boolean supergroupChatCreated() {
        return this.supergroup_chat_created;
    }

    public String text() {
        return this.text;
    }

    @Override // com.pengrad.telegrambot.model.message.MaybeInaccessibleMessage
    public String toString() {
        return "Message{message_id=" + this.message_id + ", message_thread_id=" + this.message_thread_id + ", direct_messages_topic=" + this.direct_messages_topic + ", from=" + this.from + ", sender_chat=" + this.sender_chat + ", sender_boost_count=" + this.sender_boost_count + ", date=" + this.date + ", sender_business_bot=" + this.sender_business_bot + ", business_connection_id=" + this.business_connection_id + ", chat=" + this.chat + ", forward_origin=" + this.forward_origin + ", is_topic_message=" + this.is_topic_message + ", is_automatic_forward=" + this.is_automatic_forward + ", reply_to_message=" + this.reply_to_message + ", external_reply=" + this.external_reply + ", quote=" + this.quote + ", reply_to_story=" + this.reply_to_story + ", reply_to_checklist_task_id=" + this.reply_to_checklist_task_id + ", via_bot=" + this.via_bot + ", edit_date=" + this.edit_date + ", has_protected_content=" + this.has_protected_content + ", is_from_offline=" + this.is_from_offline + ", is_paid_post=" + this.is_paid_post + ", has_media_spoiler=" + this.has_media_spoiler + ", media_group_id='" + this.media_group_id + "', author_signature='" + this.author_signature + "', text='" + this.text + "', entities=" + Arrays.toString(this.entities) + ", caption_entities=" + Arrays.toString(this.caption_entities) + ", show_caption_above_media=" + this.show_caption_above_media + ", link_preview_options=" + this.link_preview_options + ", suggested_post_info=" + this.suggested_post_info + ", effect_id=" + this.effect_id + ", audio=" + this.audio + ", paid_media=" + this.paid_media + ", document=" + this.document + ", animation=" + this.animation + ", game=" + this.game + ", photo=" + Arrays.toString(this.photo) + ", sticker=" + this.sticker + ", video=" + this.video + ", voice=" + this.voice + ", video_note=" + this.video_note + ", caption='" + this.caption + "', checklist=" + this.checklist + ", checklist_tasks_done=" + this.checklist_tasks_done + ", checklist_tasks_added=" + this.checklist_tasks_added + ", contact=" + this.contact + ", location=" + this.location + ", venue=" + this.venue + ", poll=" + this.poll + ", dice=" + this.dice + ", new_chat_members=" + Arrays.toString(this.new_chat_members) + ", left_chat_member=" + this.left_chat_member + ", new_chat_title='" + this.new_chat_title + "', new_chat_photo=" + Arrays.toString(this.new_chat_photo) + ", delete_chat_photo=" + this.delete_chat_photo + ", group_chat_created=" + this.group_chat_created + ", supergroup_chat_created=" + this.supergroup_chat_created + ", channel_chat_created=" + this.channel_chat_created + ", message_auto_delete_timer_changed=" + this.message_auto_delete_timer_changed + ", migrate_to_chat_id=" + this.migrate_to_chat_id + ", migrate_from_chat_id=" + this.migrate_from_chat_id + ", pinned_message=" + this.pinned_message + ", invoice=" + this.invoice + ", successful_payment=" + this.successful_payment + ", refunded_payment=" + this.refunded_payment + ", story=" + this.story + ", users_shared=" + this.users_shared + ", chat_shared=" + this.chat_shared + ", connected_website='" + this.connected_website + "', passport_data=" + this.passport_data + ", proximity_alert_triggered=" + this.proximity_alert_triggered + ", boost_added=" + this.boost_added + ", chat_background_set=" + this.chat_background_set + ", forum_topic_created=" + this.forum_topic_created + ", forum_topic_edited=" + this.forum_topic_edited + ", forum_topic_closed=" + this.forum_topic_closed + ", forum_topic_reopened=" + this.forum_topic_reopened + ", general_forum_topic_hidden=" + this.general_forum_topic_hidden + ", general_forum_topic_unhidden=" + this.general_forum_topic_unhidden + ", giveaway_created=" + this.giveaway_created + ", giveaway=" + this.giveaway + ", giveaway_winners=" + this.giveaway_winners + ", giveaway_completed=" + this.giveaway_completed + ", write_access_allowed=" + this.write_access_allowed + ", video_chat_started=" + this.video_chat_started + ", video_chat_ended=" + this.video_chat_ended + ", video_chat_participants_invited=" + this.video_chat_participants_invited + ", video_chat_scheduled=" + this.video_chat_scheduled + ", reply_markup=" + this.reply_markup + ", web_app_data=" + this.web_app_data + ", gift=" + this.gift + ", unique_gift=" + this.unique_gift + ", paid_message_price_changed=" + this.paid_message_price_changed + ", suggested_post_approved=" + this.suggested_post_approved + ", suggested_post_approval_failed=" + this.suggested_post_approval_failed + ", suggested_post_declined=" + this.suggested_post_declined + ", suggested_post_paid=" + this.suggested_post_paid + ", suggested_post_refunded=" + this.suggested_post_refunded + ", direct_message_price_changed=" + this.direct_message_price_changed + ", paid_star_count=" + this.paid_star_count + '}';
    }

    public UniqueGiftInfo uniqueGift() {
        return this.unique_gift;
    }

    public UsersShared usersShared() {
        return this.users_shared;
    }

    public Venue venue() {
        return this.venue;
    }

    public User viaBot() {
        return this.via_bot;
    }

    public Video video() {
        return this.video;
    }

    public VideoChatEnded videoChatEnded() {
        return this.video_chat_ended;
    }

    public VideoChatParticipantsInvited videoChatParticipantsInvited() {
        return this.video_chat_participants_invited;
    }

    public VideoChatScheduled videoChatScheduled() {
        return this.video_chat_scheduled;
    }

    public VideoChatStarted videoChatStarted() {
        return this.video_chat_started;
    }

    public VideoNote videoNote() {
        return this.video_note;
    }

    public Voice voice() {
        return this.voice;
    }

    public WebAppData webAppData() {
        return this.web_app_data;
    }

    public WriteAccessAllowed writeAccessAllowed() {
        return this.write_access_allowed;
    }
}
