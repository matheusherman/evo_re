package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InlineQueryResultAudio extends InlineQueryResult<InlineQueryResultAudio> implements Serializable {
    private static final long serialVersionUID = 0;
    private Integer audio_duration;
    private String audio_url;
    private String caption;
    private String parse_mode;
    private String performer;
    private String title;

    public InlineQueryResultAudio(String str, String str2, String str3) {
        super("audio", str);
        this.audio_url = str2;
        this.title = str3;
    }

    public InlineQueryResultAudio audioDuration(Integer num) {
        this.audio_duration = num;
        return this;
    }

    public InlineQueryResultAudio caption(String str) {
        this.caption = str;
        return this;
    }

    public InlineQueryResultAudio performer(String str) {
        this.performer = str;
        return this;
    }

    public InlineQueryResultAudio parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode.name();
        return this;
    }
}
