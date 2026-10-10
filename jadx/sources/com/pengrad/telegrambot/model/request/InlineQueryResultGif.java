package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InlineQueryResultGif extends InlineQueryResult<InlineQueryResultGif> implements Serializable {
    private static final long serialVersionUID = 0;
    private String caption;
    private Integer gif_duration;
    private Integer gif_height;
    private String gif_url;
    private Integer gif_width;
    private String parse_mode;
    private String thumbnail_mime_type;
    private String thumbnail_url;
    private String title;

    public InlineQueryResultGif(String str, String str2, String str3) {
        super("gif", str);
        this.gif_url = str2;
        this.thumbnail_url = str3;
    }

    public InlineQueryResultGif caption(String str) {
        this.caption = str;
        return this;
    }

    public InlineQueryResultGif gifDuration(Integer num) {
        this.gif_duration = num;
        return this;
    }

    public InlineQueryResultGif gifHeight(Integer num) {
        this.gif_height = num;
        return this;
    }

    public InlineQueryResultGif gifWidth(Integer num) {
        this.gif_width = num;
        return this;
    }

    public InlineQueryResultGif thumbnailMimeType(String str) {
        this.thumbnail_mime_type = str;
        return this;
    }

    public InlineQueryResultGif title(String str) {
        this.title = str;
        return this;
    }

    public InlineQueryResultGif parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode.name();
        return this;
    }
}
