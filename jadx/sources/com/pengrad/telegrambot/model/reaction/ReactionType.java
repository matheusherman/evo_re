package com.pengrad.telegrambot.model.reaction;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ReactionType implements Serializable {
    private static final long serialVersionUID = 0;
    private final String type;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.type, ((ReactionType) obj).type);
    }

    public int hashCode() {
        return Objects.hash(this.type);
    }

    public String toString() {
        return "ReactionType{type='" + this.type + "'}";
    }

    public String type() {
        return this.type;
    }

    public ReactionType(String str) {
        this.type = str;
    }
}
