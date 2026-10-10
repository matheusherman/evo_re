package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class SwitchInlineQueryChosenChat implements Serializable {
    private static final long serialVersionUID = 0;
    private Boolean allow_bot_chats;
    private Boolean allow_channel_chats;
    private Boolean allow_group_chats;
    private Boolean allow_user_chats;
    private String query;

    public SwitchInlineQueryChosenChat allowBotChats(Boolean bool) {
        this.allow_bot_chats = bool;
        return this;
    }

    public SwitchInlineQueryChosenChat allowChannelChats(Boolean bool) {
        this.allow_channel_chats = bool;
        return this;
    }

    public SwitchInlineQueryChosenChat allowGroupChats(Boolean bool) {
        this.allow_group_chats = bool;
        return this;
    }

    public SwitchInlineQueryChosenChat allowUserChats(Boolean bool) {
        this.allow_user_chats = bool;
        return this;
    }

    public SwitchInlineQueryChosenChat query(String str) {
        this.query = str;
        return this;
    }
}
