package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.model.WebAppInfo;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InlineQueryResultsButton implements Serializable {
    private static final long serialVersionUID = 0;
    private String start_parameter;
    private String text;
    private WebAppInfo web_app;

    public InlineQueryResultsButton(String str, WebAppInfo webAppInfo) {
        this.text = str;
        this.web_app = webAppInfo;
    }

    public String startParameter() {
        return this.start_parameter;
    }

    public String text() {
        return this.text;
    }

    public WebAppInfo webApp() {
        return this.web_app;
    }

    public InlineQueryResultsButton(String str, String str2) {
        this.text = str;
        this.start_parameter = str2;
    }
}
