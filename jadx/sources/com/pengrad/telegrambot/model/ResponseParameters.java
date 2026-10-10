package com.pengrad.telegrambot.model;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ResponseParameters implements Serializable {
    private static final long serialVersionUID = 0;
    private Long migrate_to_chat_id;
    private Integer retry_after;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ResponseParameters responseParameters = (ResponseParameters) obj;
            Long l10 = this.migrate_to_chat_id;
            if (l10 == null ? responseParameters.migrate_to_chat_id != null : !l10.equals(responseParameters.migrate_to_chat_id)) {
                return false;
            }
            Integer num = this.retry_after;
            Integer num2 = responseParameters.retry_after;
            if (num != null) {
                return num.equals(num2);
            }
            if (num2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Long l10 = this.migrate_to_chat_id;
        int iHashCode = (l10 != null ? l10.hashCode() : 0) * 31;
        Integer num = this.retry_after;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public Long migrateToChatId() {
        return this.migrate_to_chat_id;
    }

    public Integer retryAfter() {
        return this.retry_after;
    }

    public String toString() {
        return "ResponseParameters{migrate_to_chat_id=" + this.migrate_to_chat_id + ", retry_after=" + this.retry_after + '}';
    }
}
