package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class BotDescription implements Serializable {
    private static final long serialVersionUID = 0;
    private String description;

    public String description() {
        return this.description;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.description, ((BotDescription) obj).description);
    }

    public int hashCode() {
        String str = this.description;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "BotDescription{, description='" + this.description + "'}";
    }

    BotDescription() {
    }
}
