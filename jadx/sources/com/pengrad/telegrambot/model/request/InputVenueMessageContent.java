package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InputVenueMessageContent extends InputMessageContent implements Serializable {
    private static final long serialVersionUID = 0;
    private String address;
    private String foursquare_id;
    private String foursquare_type;
    private String google_place_id;
    private String google_place_type;
    private Float latitude;
    private Float longitude;
    private String title;

    public InputVenueMessageContent foursquareId(String str) {
        this.foursquare_id = str;
        return this;
    }

    public InputVenueMessageContent foursquareType(String str) {
        this.foursquare_type = str;
        return this;
    }

    public InputVenueMessageContent googlePlaceId(String str) {
        this.google_place_id = str;
        return this;
    }

    public InputVenueMessageContent googlePlaceType(String str) {
        this.google_place_type = str;
        return this;
    }

    public InputVenueMessageContent(Float f10, Float f11, String str, String str2) {
        this.latitude = f10;
        this.longitude = f11;
        this.title = str;
        this.address = str2;
    }
}
