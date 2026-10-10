package com.pengrad.telegrambot.model.business;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class BusinessOpeningHoursInterval {
    private Integer closing_minute;
    private Integer opening_minute;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BusinessOpeningHoursInterval businessOpeningHoursInterval = (BusinessOpeningHoursInterval) obj;
            if (Objects.equals(this.opening_minute, businessOpeningHoursInterval.opening_minute) && Objects.equals(this.closing_minute, businessOpeningHoursInterval.closing_minute)) {
                return true;
            }
        }
        return false;
    }

    public Integer closing_minute() {
        return this.closing_minute;
    }

    public int hashCode() {
        return Objects.hash(this.opening_minute, this.closing_minute);
    }

    public Integer opening_minute() {
        return this.opening_minute;
    }

    public String toString() {
        return "BusinessOpeningHoursInterval{opening_minute=" + this.opening_minute + ", closing_minute=" + this.closing_minute + '}';
    }
}
