package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.model.paidmedia.PaidMediaPhoto;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InlineQueryResultCachedPhoto extends InlineQueryResult<InlineQueryResultCachedPhoto> implements Serializable {
    private static final long serialVersionUID = 0;
    private String caption;
    private String description;
    private String parse_mode;
    private String photo_file_id;
    private String title;

    public InlineQueryResultCachedPhoto(String str, String str2) {
        super(PaidMediaPhoto.TYPE, str);
        this.photo_file_id = str2;
    }

    public InlineQueryResultCachedPhoto caption(String str) {
        this.caption = str;
        return this;
    }

    public InlineQueryResultCachedPhoto description(String str) {
        this.description = str;
        return this;
    }

    public InlineQueryResultCachedPhoto title(String str) {
        this.title = str;
        return this;
    }

    public InlineQueryResultCachedPhoto parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode.name();
        return this;
    }
}
