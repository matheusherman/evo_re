package com.pengrad.telegrambot.model.business;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class BusinessOpeningHours {
    private BusinessOpeningHoursInterval[] opening_hours;
    private String time_zone_name;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BusinessOpeningHours businessOpeningHours = (BusinessOpeningHours) obj;
            if (Objects.equals(this.time_zone_name, businessOpeningHours.time_zone_name) && Objects.deepEquals(this.opening_hours, businessOpeningHours.opening_hours)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.time_zone_name, Integer.valueOf(Arrays.hashCode(this.opening_hours)));
    }

    public BusinessOpeningHoursInterval[] openingHours() {
        return this.opening_hours;
    }

    public String timeZoneName() {
        return this.time_zone_name;
    }

    public String toString() {
        return "BusinessOpeningHours{time_zone_name='" + this.time_zone_name + "', opening_hours=" + Arrays.toString(this.opening_hours) + '}';
    }
}
