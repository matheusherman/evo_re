package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InlineQueryResultCachedGif extends InlineQueryResult<InlineQueryResultCachedGif> implements Serializable {
    private static final long serialVersionUID = 0;
    private String caption;
    private String gif_file_id;
    private String parse_mode;
    private String title;

    public InlineQueryResultCachedGif(String str, String str2) {
        super("gif", str);
        this.gif_file_id = str2;
    }

    public InlineQueryResultCachedGif caption(String str) {
        this.caption = str;
        return this;
    }

    public InlineQueryResultCachedGif title(String str) {
        this.title = str;
        return this;
    }

    public InlineQueryResultCachedGif parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode.name();
        return this;
    }
}
