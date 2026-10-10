package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.model.paidmedia.PaidMediaPhoto;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InlineQueryResultPhoto extends InlineQueryResult<InlineQueryResultPhoto> implements Serializable {
    private static final long serialVersionUID = 0;
    private String caption;
    private String description;
    private String parse_mode;
    private Integer photo_height;
    private String photo_url;
    private Integer photo_width;
    private String thumbnail_url;
    private String title;

    public InlineQueryResultPhoto(String str, String str2, String str3) {
        super(PaidMediaPhoto.TYPE, str);
        this.photo_url = str2;
        this.thumbnail_url = str3;
    }

    public InlineQueryResultPhoto caption(String str) {
        this.caption = str;
        return this;
    }

    public InlineQueryResultPhoto description(String str) {
        this.description = str;
        return this;
    }

    public InlineQueryResultPhoto photoHeight(Integer num) {
        this.photo_height = num;
        return this;
    }

    public InlineQueryResultPhoto photoWidth(Integer num) {
        this.photo_width = num;
        return this;
    }

    public InlineQueryResultPhoto title(String str) {
        this.title = str;
        return this;
    }

    public InlineQueryResultPhoto parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode.name();
        return this;
    }
}
