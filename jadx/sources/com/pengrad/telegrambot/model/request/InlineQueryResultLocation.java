package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InlineQueryResultLocation extends InlineQueryResult<InlineQueryResultLocation> implements Serializable {
    private static final long serialVersionUID = 0;
    private Integer heading;
    private Float horizontal_accuracy;
    private float latitude;
    private Integer live_period;
    private float longitude;
    private Integer proximity_alert_radius;
    private Integer thumbnail_height;
    private String thumbnail_url;
    private Integer thumbnail_width;
    private String title;

    public InlineQueryResultLocation(String str, float f10, float f11, String str2) {
        super("location", str);
        this.latitude = f10;
        this.longitude = f11;
        this.title = str2;
    }

    public InlineQueryResultLocation livePeriod(Integer num) {
        this.live_period = num;
        return this;
    }

    public InlineQueryResultLocation thumbnailHeight(Integer num) {
        this.thumbnail_height = num;
        return this;
    }

    public InlineQueryResultLocation thumbnailUrl(String str) {
        this.thumbnail_url = str;
        return this;
    }

    public InlineQueryResultLocation thumbnailWidth(Integer num) {
        this.thumbnail_width = num;
        return this;
    }

    public InlineQueryResultLocation heading(int i10) {
        this.heading = Integer.valueOf(i10);
        return this;
    }

    public InlineQueryResultLocation horizontalAccuracy(float f10) {
        this.horizontal_accuracy = Float.valueOf(f10);
        return this;
    }

    public InlineQueryResultLocation proximityAlertRadius(int i10) {
        this.proximity_alert_radius = Integer.valueOf(i10);
        return this;
    }
}
