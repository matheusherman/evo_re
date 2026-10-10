package com.pengrad.telegrambot.model;

import com.pengrad.telegrambot.model.business.BusinessConnection;
import com.pengrad.telegrambot.model.business.BusinessMessageDeleted;
import com.pengrad.telegrambot.model.chatboost.ChatBoostRemoved;
import com.pengrad.telegrambot.model.chatboost.ChatBoostUpdated;
import com.pengrad.telegrambot.model.paidmedia.PaidMediaPurchased;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class Update implements Serializable {
    private static final long serialVersionUID = 0;
    private BusinessConnection business_connection;
    private Message business_message;
    private CallbackQuery callback_query;
    private Message channel_post;
    private ChatBoostUpdated chat_boost;
    private ChatJoinRequest chat_join_request;
    private ChatMemberUpdated chat_member;
    private ChosenInlineResult chosen_inline_result;
    private BusinessMessageDeleted deleted_business_messages;
    private Message edited_business_message;
    private Message edited_channel_post;
    private Message edited_message;
    private InlineQuery inline_query;
    private Message message;
    private MessageReactionUpdated message_reaction;
    private MessageReactionCountUpdated message_reaction_count;
    private ChatMemberUpdated my_chat_member;
    private Poll poll;
    private PollAnswer poll_answer;
    private PreCheckoutQuery pre_checkout_query;
    private PaidMediaPurchased purchased_paid_media;
    private ChatBoostRemoved removed_chat_boost;
    private ShippingQuery shipping_query;
    private Integer update_id;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Update update = (Update) obj;
            if (Objects.equals(this.update_id, update.update_id) && Objects.equals(this.message, update.message) && Objects.equals(this.edited_message, update.edited_message) && Objects.equals(this.channel_post, update.channel_post) && Objects.equals(this.edited_channel_post, update.edited_channel_post) && Objects.equals(this.business_connection, update.business_connection) && Objects.equals(this.business_message, update.business_message) && Objects.equals(this.edited_business_message, update.edited_business_message) && Objects.equals(this.deleted_business_messages, update.deleted_business_messages) && Objects.equals(this.inline_query, update.inline_query) && Objects.equals(this.chosen_inline_result, update.chosen_inline_result) && Objects.equals(this.callback_query, update.callback_query) && Objects.equals(this.shipping_query, update.shipping_query) && Objects.equals(this.pre_checkout_query, update.pre_checkout_query) && Objects.equals(this.poll, update.poll) && Objects.equals(this.poll_answer, update.poll_answer) && Objects.equals(this.my_chat_member, update.my_chat_member) && Objects.equals(this.chat_member, update.chat_member) && Objects.equals(this.chat_join_request, update.chat_join_request) && Objects.equals(this.message_reaction, update.message_reaction) && Objects.equals(this.message_reaction_count, update.message_reaction_count) && Objects.equals(this.chat_boost, update.chat_boost) && Objects.equals(this.removed_chat_boost, update.removed_chat_boost) && Objects.equals(this.purchased_paid_media, update.purchased_paid_media)) {
                return true;
            }
        }
        return false;
    }

    public BusinessConnection businessConnection() {
        return this.business_connection;
    }

    public Message businessMessage() {
        return this.business_message;
    }

    public CallbackQuery callbackQuery() {
        return this.callback_query;
    }

    public Message channelPost() {
        return this.channel_post;
    }

    public ChatBoostUpdated chatBoost() {
        return this.chat_boost;
    }

    public ChatJoinRequest chatJoinRequest() {
        return this.chat_join_request;
    }

    public ChatMemberUpdated chatMember() {
        return this.chat_member;
    }

    public ChosenInlineResult chosenInlineResult() {
        return this.chosen_inline_result;
    }

    public BusinessMessageDeleted deletedBusinessMessages() {
        return this.deleted_business_messages;
    }

    public Message editedBusinessMessage() {
        return this.edited_business_message;
    }

    public Message editedChannelPost() {
        return this.edited_channel_post;
    }

    public Message editedMessage() {
        return this.edited_message;
    }

    public int hashCode() {
        Integer num = this.update_id;
        if (num != null) {
            return num.hashCode();
        }
        return 0;
    }

    public InlineQuery inlineQuery() {
        return this.inline_query;
    }

    public Message message() {
        return this.message;
    }

    public MessageReactionUpdated messageReaction() {
        return this.message_reaction;
    }

    public MessageReactionCountUpdated messageReactionCount() {
        return this.message_reaction_count;
    }

    public ChatMemberUpdated myChatMember() {
        return this.my_chat_member;
    }

    public Poll poll() {
        return this.poll;
    }

    public PollAnswer pollAnswer() {
        return this.poll_answer;
    }

    public PreCheckoutQuery preCheckoutQuery() {
        return this.pre_checkout_query;
    }

    public PaidMediaPurchased purchasedPaidMedia() {
        return this.purchased_paid_media;
    }

    public ChatBoostRemoved removedChatBoost() {
        return this.removed_chat_boost;
    }

    public ShippingQuery shippingQuery() {
        return this.shipping_query;
    }

    public String toString() {
        return "Update{update_id=" + this.update_id + ", message=" + this.message + ", edited_message=" + this.edited_message + ", channel_post=" + this.channel_post + ", edited_channel_post=" + this.edited_channel_post + ", business_connection=" + this.business_connection + ", business_message=" + this.business_message + ", edited_business_message=" + this.edited_business_message + ", deleted_business_messages=" + this.deleted_business_messages + ", inline_query=" + this.inline_query + ", chosen_inline_result=" + this.chosen_inline_result + ", callback_query=" + this.callback_query + ", shipping_query=" + this.shipping_query + ", pre_checkout_query=" + this.pre_checkout_query + ", poll=" + this.poll + ", poll_answer=" + this.poll_answer + ", my_chat_member=" + this.my_chat_member + ", chat_member=" + this.chat_member + ", chat_join_request=" + this.chat_join_request + ", message_reaction=" + this.message_reaction + ", message_reaction_count=" + this.message_reaction_count + ", chat_boost=" + this.chat_boost + ", removed_chat_boost=" + this.removed_chat_boost + ", purchased_paid_media=" + this.purchased_paid_media + '}';
    }

    public Integer updateId() {
        return this.update_id;
    }
}
