package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ProximityAlertTriggered implements Serializable {
    private static final long serialVersionUID = 0;
    private Integer distance;
    private User traveler;
    private User watcher;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ProximityAlertTriggered proximityAlertTriggered = (ProximityAlertTriggered) obj;
            if (Objects.equals(this.traveler, proximityAlertTriggered.traveler) && Objects.equals(this.watcher, proximityAlertTriggered.watcher) && Objects.equals(this.distance, proximityAlertTriggered.distance)) {
                return true;
            }
        }
        return false;
    }

    public Integer distance() {
        return this.distance;
    }

    public int hashCode() {
        return Objects.hash(this.traveler, this.watcher, this.distance);
    }

    public String toString() {
        return "ProximityAlertTriggered{traveler=" + this.traveler + ", watcher=" + this.watcher + ", distance=" + this.distance + '}';
    }

    public User traveler() {
        return this.traveler;
    }

    public User watcher() {
        return this.watcher;
    }
}
