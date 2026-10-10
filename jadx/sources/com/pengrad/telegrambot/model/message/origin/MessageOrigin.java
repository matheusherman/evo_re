package com.pengrad.telegrambot.model.message.origin;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class MessageOrigin implements Serializable {
    private static final long serialVersionUID = 0;
    protected Integer date;
    protected String type;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            MessageOrigin messageOrigin = (MessageOrigin) obj;
            if (Objects.equals(this.type, messageOrigin.type) && Objects.equals(this.date, messageOrigin.date)) {
                return true;
            }
        }
        return false;
    }

    public Integer date() {
        return this.date;
    }

    public int hashCode() {
        return Objects.hash(this.type, this.date);
    }

    public String toString() {
        return "MessageOrigin{type='" + this.type + "',date='" + this.date + "'}";
    }

    public String type() {
        return this.type;
    }

    public MessageOrigin(String str) {
        this.type = str;
    }
}
