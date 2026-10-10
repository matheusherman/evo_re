package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InlineQueryResultCachedAudio extends InlineQueryResult<InlineQueryResultCachedAudio> implements Serializable {
    private static final long serialVersionUID = 0;
    private String audio_file_id;
    private String caption;
    private String parse_mode;

    public InlineQueryResultCachedAudio(String str, String str2) {
        super("audio", str);
        this.audio_file_id = str2;
    }

    public InlineQueryResultCachedAudio caption(String str) {
        this.caption = str;
        return this;
    }

    public InlineQueryResultCachedAudio parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode.name();
        return this;
    }
}
