package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ChatLocation implements Serializable {
    private static final long serialVersionUID = 0;
    private String address;
    private Location location;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ChatLocation chatLocation = (ChatLocation) obj;
            if (Objects.equals(this.location, chatLocation.location) && Objects.equals(this.address, chatLocation.address)) {
                return true;
            }
        }
        return false;
    }

    public String address() {
        return this.address;
    }

    public int hashCode() {
        return Objects.hash(this.location, this.address);
    }

    public Location location() {
        return this.location;
    }

    public String toString() {
        return "ChatLocation{location=" + this.location + ", address='" + this.address + "'}";
    }
}
