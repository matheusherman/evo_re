package com.pengrad.telegrambot.model;

import com.pengrad.telegrambot.model.message.MaybeInaccessibleMessage;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class CallbackQuery implements Serializable {
    private static final long serialVersionUID = 0;
    private String chat_instance;
    private String data;
    private User from;
    private String game_short_name;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f8231id;
    private String inline_message_id;
    private MaybeInaccessibleMessage message;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            CallbackQuery callbackQuery = (CallbackQuery) obj;
            String str = this.f8231id;
            if (str == null ? callbackQuery.f8231id != null : !str.equals(callbackQuery.f8231id)) {
                return false;
            }
            User user = this.from;
            if (user == null ? callbackQuery.from != null : !user.equals(callbackQuery.from)) {
                return false;
            }
            MaybeInaccessibleMessage maybeInaccessibleMessage = this.message;
            if (maybeInaccessibleMessage == null ? callbackQuery.message != null : !maybeInaccessibleMessage.equals(callbackQuery.message)) {
                return false;
            }
            String str2 = this.inline_message_id;
            if (str2 == null ? callbackQuery.inline_message_id != null : !str2.equals(callbackQuery.inline_message_id)) {
                return false;
            }
            String str3 = this.chat_instance;
            if (str3 == null ? callbackQuery.chat_instance != null : !str3.equals(callbackQuery.chat_instance)) {
                return false;
            }
            String str4 = this.data;
            if (str4 == null ? callbackQuery.data != null : !str4.equals(callbackQuery.data)) {
                return false;
            }
            String str5 = this.game_short_name;
            String str6 = callbackQuery.game_short_name;
            if (str5 != null) {
                return str5.equals(str6);
            }
            if (str6 == null) {
                return true;
            }
        }
        return false;
    }

    public String chatInstance() {
        return this.chat_instance;
    }

    public String data() {
        return this.data;
    }

    public User from() {
        return this.from;
    }

    public String gameShortName() {
        return this.game_short_name;
    }

    public int hashCode() {
        String str = this.f8231id;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String id() {
        return this.f8231id;
    }

    public String inlineMessageId() {
        return this.inline_message_id;
    }

    public MaybeInaccessibleMessage maybeInaccessibleMessage() {
        return this.message;
    }

    @Deprecated
    public Message message() {
        MaybeInaccessibleMessage maybeInaccessibleMessage = this.message;
        if (maybeInaccessibleMessage instanceof Message) {
            return (Message) maybeInaccessibleMessage;
        }
        Message message = new Message();
        message.setChat(this.message.chat());
        message.setMessageId(this.message.messageId());
        message.setDate(this.message.date());
        return message;
    }

    public String toString() {
        return "CallbackQuery{id='" + this.f8231id + "', from=" + this.from + ", message=" + this.message + ", inline_message_id='" + this.inline_message_id + "', chat_instance='" + this.chat_instance + "', data='" + this.data + "', game_short_name='" + this.game_short_name + "'}";
    }
}
