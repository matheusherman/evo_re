package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InlineQueryResultCachedMpeg4Gif extends InlineQueryResult<InlineQueryResultCachedMpeg4Gif> implements Serializable {
    private static final long serialVersionUID = 0;
    private String caption;
    private String mpeg4_file_id;
    private String parse_mode;
    private String title;

    public InlineQueryResultCachedMpeg4Gif(String str, String str2) {
        super("mpeg4_gif", str);
        this.mpeg4_file_id = str2;
    }

    public InlineQueryResultCachedMpeg4Gif caption(String str) {
        this.caption = str;
        return this;
    }

    public InlineQueryResultCachedMpeg4Gif title(String str) {
        this.title = str;
        return this;
    }

    public InlineQueryResultCachedMpeg4Gif parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode.name();
        return this;
    }
}
