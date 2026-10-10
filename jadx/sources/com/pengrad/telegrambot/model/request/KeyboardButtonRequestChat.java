package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.model.ChatAdministratorRights;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class KeyboardButtonRequestChat implements Serializable {
    private static final long serialVersionUID = 0;
    private ChatAdministratorRights bot_administrator_rights;
    private Boolean bot_is_member;
    private Boolean chat_has_username;
    private Boolean chat_is_channel;
    private Boolean chat_is_created;
    private Boolean chat_is_forum;
    private Integer request_id;
    private Boolean request_photo;
    private Boolean request_title;
    private Boolean request_username;
    private ChatAdministratorRights user_administrator_rights;

    public KeyboardButtonRequestChat botAdministratorRights(ChatAdministratorRights chatAdministratorRights) {
        this.bot_administrator_rights = chatAdministratorRights;
        return this;
    }

    public KeyboardButtonRequestChat botIsMember(Boolean bool) {
        this.bot_is_member = bool;
        return this;
    }

    public KeyboardButtonRequestChat chatHasUsername(Boolean bool) {
        this.chat_has_username = bool;
        return this;
    }

    public KeyboardButtonRequestChat chatIsCreated(Boolean bool) {
        this.chat_is_created = bool;
        return this;
    }

    public KeyboardButtonRequestChat chatIsForum(Boolean bool) {
        this.chat_is_forum = bool;
        return this;
    }

    public KeyboardButtonRequestChat requestPhoto(Boolean bool) {
        this.request_photo = bool;
        return this;
    }

    public KeyboardButtonRequestChat requestTitle(Boolean bool) {
        this.request_title = bool;
        return this;
    }

    public KeyboardButtonRequestChat requestUsername(Boolean bool) {
        this.request_username = bool;
        return this;
    }

    public KeyboardButtonRequestChat userAdministratorRights(ChatAdministratorRights chatAdministratorRights) {
        this.user_administrator_rights = chatAdministratorRights;
        return this;
    }

    public KeyboardButtonRequestChat(Integer num, Boolean bool) {
        this.request_id = num;
        this.chat_is_channel = bool;
    }
}
