package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InlineQueryResultMpeg4Gif extends InlineQueryResult<InlineQueryResultMpeg4Gif> implements Serializable {
    private static final long serialVersionUID = 0;
    private String caption;
    private Integer mpeg4_duration;
    private Integer mpeg4_height;
    private String mpeg4_url;
    private Integer mpeg4_width;
    private String parse_mode;
    private String thumbnail_mime_type;
    private String thumbnail_url;
    private String title;

    public InlineQueryResultMpeg4Gif(String str, String str2, String str3) {
        super("mpeg4_gif", str);
        this.mpeg4_url = str2;
        this.thumbnail_url = str3;
    }

    public InlineQueryResultMpeg4Gif caption(String str) {
        this.caption = str;
        return this;
    }

    public InlineQueryResultMpeg4Gif mpeg4Duration(Integer num) {
        this.mpeg4_duration = num;
        return this;
    }

    public InlineQueryResultMpeg4Gif mpeg4Height(Integer num) {
        this.mpeg4_height = num;
        return this;
    }

    public InlineQueryResultMpeg4Gif mpeg4Width(Integer num) {
        this.mpeg4_width = num;
        return this;
    }

    public InlineQueryResultMpeg4Gif thumbnailMimeType(String str) {
        this.thumbnail_mime_type = str;
        return this;
    }

    public InlineQueryResultMpeg4Gif title(String str) {
        this.title = str;
        return this;
    }

    public InlineQueryResultMpeg4Gif parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode.name();
        return this;
    }
}
