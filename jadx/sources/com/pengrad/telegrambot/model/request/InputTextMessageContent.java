package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.model.LinkPreviewOptions;
import com.pengrad.telegrambot.model.MessageEntity;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InputTextMessageContent extends InputMessageContent implements Serializable {
    private static final long serialVersionUID = 0;
    private Boolean disable_web_page_preview;
    private MessageEntity[] entities;
    private LinkPreviewOptions link_preview_options;
    private String message_text;
    private String parse_mode;

    public InputTextMessageContent entities(MessageEntity... messageEntityArr) {
        this.entities = messageEntityArr;
        return this;
    }

    public InputTextMessageContent linkPreviewOptions(LinkPreviewOptions linkPreviewOptions) {
        this.link_preview_options = linkPreviewOptions;
        return this;
    }

    public InputTextMessageContent(String str) {
        this.message_text = str;
    }

    public InputTextMessageContent parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode.name();
        return this;
    }
}
