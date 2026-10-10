package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class BotShortDescription implements Serializable {
    private static final long serialVersionUID = 0;
    private String short_description;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.short_description, ((BotShortDescription) obj).short_description);
    }

    public int hashCode() {
        String str = this.short_description;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String shortDescription() {
        return this.short_description;
    }

    public String toString() {
        return "BotShortDescription{, short_description='" + this.short_description + "'}";
    }

    BotShortDescription() {
    }
}
