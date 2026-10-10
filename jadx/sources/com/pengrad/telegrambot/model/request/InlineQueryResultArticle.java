package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InlineQueryResultArticle extends InlineQueryResult<InlineQueryResultArticle> implements Serializable {
    private static final long serialVersionUID = 0;
    private String description;
    private Boolean hide_url;
    private Integer thumbnail_height;
    private String thumbnail_url;
    private Integer thumbnail_width;
    private String title;
    private String url;

    public InlineQueryResultArticle(String str, String str2, String str3) {
        this(str, str2, new InputTextMessageContent(str3));
    }

    public InlineQueryResultArticle(String str, String str2, InputMessageContent inputMessageContent) {
        super("article", str);
        this.title = str2;
        inputMessageContent(inputMessageContent);
    }

    public InlineQueryResultArticle description(String str) {
        this.description = str;
        return this;
    }

    @Deprecated
    public InlineQueryResultArticle hideUrl(Boolean bool) {
        this.url = "";
        return this;
    }

    public InlineQueryResultArticle thumbnailHeight(Integer num) {
        this.thumbnail_height = num;
        return this;
    }

    public InlineQueryResultArticle thumbnailUrl(String str) {
        this.thumbnail_url = str;
        return this;
    }

    public InlineQueryResultArticle thumbnailWidth(Integer num) {
        this.thumbnail_width = num;
        return this;
    }

    public InlineQueryResultArticle url(String str) {
        this.url = str;
        return this;
    }
}
