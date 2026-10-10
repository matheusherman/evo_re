package com.pengrad.telegrambot.model.business;

import com.pengrad.telegrambot.model.Location;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class BusinessLocation {
    private String address;
    private Location location;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BusinessLocation businessLocation = (BusinessLocation) obj;
            if (Objects.equals(this.address, businessLocation.address) && Objects.equals(this.location, businessLocation.location)) {
                return true;
            }
        }
        return false;
    }

    public String address() {
        return this.address;
    }

    public int hashCode() {
        return Objects.hash(this.address, this.location);
    }

    public Location location() {
        return this.location;
    }

    public String toString() {
        return "BusinessLocation{address='" + this.address + "', location=" + this.location + '}';
    }
}
