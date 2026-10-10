package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InlineQueryResultContact extends InlineQueryResult<InlineQueryResultContact> implements Serializable {
    private static final long serialVersionUID = 0;
    private String first_name;
    private String last_name;
    private String phone_number;
    private Integer thumbnail_height;
    private String thumbnail_url;
    private Integer thumbnail_width;
    private String vcard;

    public InlineQueryResultContact(String str, String str2, String str3) {
        super("contact", str);
        this.phone_number = str2;
        this.first_name = str3;
    }

    public InlineQueryResultContact lastName(String str) {
        this.last_name = str;
        return this;
    }

    public InlineQueryResultContact thumbnailHeight(Integer num) {
        this.thumbnail_height = num;
        return this;
    }

    public InlineQueryResultContact thumbnailUrl(String str) {
        this.thumbnail_url = str;
        return this;
    }

    public InlineQueryResultContact thumbnailWidth(Integer num) {
        this.thumbnail_width = num;
        return this;
    }

    public InlineQueryResultContact vcard(String str) {
        this.vcard = str;
        return this;
    }
}
