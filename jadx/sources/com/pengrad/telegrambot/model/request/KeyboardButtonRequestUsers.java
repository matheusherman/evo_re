package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class KeyboardButtonRequestUsers implements Serializable {
    private static final long serialVersionUID = 0;
    private Integer max_quantity;
    private Integer request_id;
    private Boolean request_name;
    private Boolean request_photo;
    private Boolean request_username;
    private Boolean user_is_bot;
    private Boolean user_is_premium;

    public KeyboardButtonRequestUsers maxQuantity(Integer num) {
        this.max_quantity = num;
        return this;
    }

    public KeyboardButtonRequestUsers requestName(Boolean bool) {
        this.request_name = bool;
        return this;
    }

    public KeyboardButtonRequestUsers requestPhoto(Boolean bool) {
        this.request_photo = bool;
        return this;
    }

    public KeyboardButtonRequestUsers requestUsername(Boolean bool) {
        this.request_username = bool;
        return this;
    }

    public KeyboardButtonRequestUsers userIsBot(Boolean bool) {
        this.user_is_bot = bool;
        return this;
    }

    public KeyboardButtonRequestUsers userIsPremium(Boolean bool) {
        this.user_is_premium = bool;
        return this;
    }

    public KeyboardButtonRequestUsers(Integer num) {
        this.request_id = num;
    }
}
