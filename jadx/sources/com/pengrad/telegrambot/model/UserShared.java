package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class UserShared implements Serializable {
    private static final long serialVersionUID = 0;
    private Integer request_id;
    private Long user_id;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            UserShared userShared = (UserShared) obj;
            if (Objects.equals(this.request_id, userShared.request_id) && Objects.equals(this.user_id, userShared.user_id)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.request_id, this.user_id);
    }

    public Integer requestId() {
        return this.request_id;
    }

    public String toString() {
        return "UserShared{request_id='" + this.request_id + "', user_id='" + this.user_id + "'}";
    }

    public Long userId() {
        return this.user_id;
    }
}
