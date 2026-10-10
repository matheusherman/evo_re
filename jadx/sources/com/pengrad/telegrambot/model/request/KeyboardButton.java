package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.model.WebAppInfo;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class KeyboardButton implements Serializable {
    private static final long serialVersionUID = 0;
    private KeyboardButtonRequestChat request_chat;
    private boolean request_contact;
    private boolean request_location;
    private KeyboardButtonPollType request_poll;
    private KeyboardButtonRequestUsers request_users;
    private String text;
    private WebAppInfo web_app;

    public KeyboardButton requestChat(KeyboardButtonRequestChat keyboardButtonRequestChat) {
        this.request_chat = keyboardButtonRequestChat;
        return this;
    }

    public KeyboardButton requestContact(boolean z10) {
        this.request_contact = z10;
        return this;
    }

    public KeyboardButton requestLocation(boolean z10) {
        this.request_location = z10;
        return this;
    }

    public KeyboardButton requestPoll(KeyboardButtonPollType keyboardButtonPollType) {
        this.request_poll = keyboardButtonPollType;
        return this;
    }

    public KeyboardButton requestUsers(KeyboardButtonRequestUsers keyboardButtonRequestUsers) {
        this.request_users = keyboardButtonRequestUsers;
        return this;
    }

    public KeyboardButton webAppInfo(WebAppInfo webAppInfo) {
        this.web_app = webAppInfo;
        return this;
    }

    public KeyboardButton(String str) {
        this.text = str;
    }
}
