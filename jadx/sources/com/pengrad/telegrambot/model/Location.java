package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class Location implements Serializable {
    private static final long serialVersionUID = 0;
    private Integer heading;
    private Float horizontal_accuracy;
    private Float latitude;
    private Integer live_period;
    private Float longitude;
    private Integer proximity_alert_radius;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Location location = (Location) obj;
            if (Objects.equals(this.longitude, location.longitude) && Objects.equals(this.latitude, location.latitude) && Objects.equals(this.horizontal_accuracy, location.horizontal_accuracy) && Objects.equals(this.live_period, location.live_period) && Objects.equals(this.heading, location.heading) && Objects.equals(this.proximity_alert_radius, location.proximity_alert_radius)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.longitude, this.latitude, this.horizontal_accuracy, this.live_period, this.heading, this.proximity_alert_radius);
    }

    public Integer heading() {
        return this.heading;
    }

    public Float horizontalAccuracy() {
        return this.horizontal_accuracy;
    }

    public Float latitude() {
        return this.latitude;
    }

    public Integer livePeriod() {
        return this.live_period;
    }

    public Float longitude() {
        return this.longitude;
    }

    public Integer proximityAlertRadius() {
        return this.proximity_alert_radius;
    }

    public String toString() {
        return "Location{longitude=" + this.longitude + ", latitude=" + this.latitude + ", horizontal_accuracy=" + this.horizontal_accuracy + ", live_period=" + this.live_period + ", heading=" + this.heading + ", proximity_alert_radius=" + this.proximity_alert_radius + '}';
    }
}
