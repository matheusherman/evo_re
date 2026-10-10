package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InlineQueryResultDocument extends InlineQueryResult<InlineQueryResultDocument> implements Serializable {
    public static final String MIME_APP_PDFL = "application/pdf";
    public static final String MIME_APP_ZIP = "application/zip";
    private static final long serialVersionUID = 0;
    private String caption;
    private String description;
    private String document_url;
    private String mime_type;
    private String parse_mode;
    private Integer thumbnail_height;
    private String thumbnail_url;
    private Integer thumbnail_width;
    private String title;

    public InlineQueryResultDocument(String str, String str2, String str3, String str4) {
        super("document", str);
        this.document_url = str2;
        this.title = str3;
        this.mime_type = str4;
    }

    public InlineQueryResultDocument caption(String str) {
        this.caption = str;
        return this;
    }

    public InlineQueryResultDocument description(String str) {
        this.description = str;
        return this;
    }

    public InlineQueryResultDocument thumbnailHeight(Integer num) {
        this.thumbnail_height = num;
        return this;
    }

    public InlineQueryResultDocument thumbnailUrl(String str) {
        this.thumbnail_url = str;
        return this;
    }

    public InlineQueryResultDocument thumbnailWidth(Integer num) {
        this.thumbnail_width = num;
        return this;
    }

    public InlineQueryResultDocument parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode.name();
        return this;
    }
}
