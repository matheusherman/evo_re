package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class LoginUrl implements Serializable {
    private static final long serialVersionUID = 0;
    private String bot_username;
    private String forward_text;
    private Boolean request_write_access;
    private String url;

    public LoginUrl botUsername(String str) {
        this.bot_username = str;
        return this;
    }

    public LoginUrl forwardText(String str) {
        this.forward_text = str;
        return this;
    }

    public LoginUrl(String str) {
        this.url = str;
    }

    public LoginUrl requestWriteAccess(boolean z10) {
        this.request_write_access = Boolean.valueOf(z10);
        return this;
    }
}
