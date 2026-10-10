package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InputLocationMessageContent extends InputMessageContent implements Serializable {
    private static final long serialVersionUID = 0;
    private Integer heading;
    private Float horizontal_accuracy;
    private Float latitude;
    private Integer live_period;
    private Float longitude;
    private Integer proximity_alert_radius;

    public InputLocationMessageContent livePeriod(Integer num) {
        this.live_period = num;
        return this;
    }

    public InputLocationMessageContent(Float f10, Float f11) {
        this.latitude = f10;
        this.longitude = f11;
    }

    public InputLocationMessageContent heading(int i10) {
        this.heading = Integer.valueOf(i10);
        return this;
    }

    public InputLocationMessageContent horizontalAccuracy(float f10) {
        this.horizontal_accuracy = Float.valueOf(f10);
        return this;
    }

    public InputLocationMessageContent proximityAlertRadius(int i10) {
        this.proximity_alert_radius = Integer.valueOf(i10);
        return this;
    }
}
