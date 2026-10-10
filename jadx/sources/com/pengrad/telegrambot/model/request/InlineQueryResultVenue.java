package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InlineQueryResultVenue extends InlineQueryResult<InlineQueryResultVenue> implements Serializable {
    private static final long serialVersionUID = 0;
    private String address;
    private String foursquare_id;
    private String foursquare_type;
    private String google_place_id;
    private String google_place_type;
    private float latitude;
    private float longitude;
    private Integer thumbnail_height;
    private String thumbnail_url;
    private Integer thumbnail_width;
    private String title;

    public InlineQueryResultVenue(String str, float f10, float f11, String str2, String str3) {
        super("venue", str);
        this.latitude = f10;
        this.longitude = f11;
        this.title = str2;
        this.address = str3;
    }

    public InlineQueryResultVenue foursquareId(String str) {
        this.foursquare_id = str;
        return this;
    }

    public InlineQueryResultVenue foursquareType(String str) {
        this.foursquare_type = str;
        return this;
    }

    public InlineQueryResultVenue googlePlaceId(String str) {
        this.google_place_id = str;
        return this;
    }

    public InlineQueryResultVenue googlePlaceType(String str) {
        this.google_place_type = str;
        return this;
    }

    public InlineQueryResultVenue thumbnailHeight(Integer num) {
        this.thumbnail_height = num;
        return this;
    }

    public InlineQueryResultVenue thumbnailUrl(String str) {
        this.thumbnail_url = str;
        return this;
    }

    public InlineQueryResultVenue thumbnailWidth(Integer num) {
        this.thumbnail_width = num;
        return this;
    }
}
