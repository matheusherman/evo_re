package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InlineQueryResultCachedVideo extends InlineQueryResult<InlineQueryResultCachedVideo> implements Serializable {
    private static final long serialVersionUID = 0;
    private String caption;
    private String description;
    private String parse_mode;
    private String title;
    private String video_file_id;

    public InlineQueryResultCachedVideo(String str, String str2, String str3) {
        super("video", str);
        this.video_file_id = str2;
        this.title = str3;
    }

    public InlineQueryResultCachedVideo caption(String str) {
        this.caption = str;
        return this;
    }

    public InlineQueryResultCachedVideo description(String str) {
        this.description = str;
        return this;
    }

    public InlineQueryResultCachedVideo parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode.name();
        return this;
    }
}
