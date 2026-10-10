package com.pengrad.telegrambot.model;

import com.pengrad.telegrambot.model.shared.SharedUser;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class UsersShared implements Serializable {
    private static final long serialVersionUID = 0;
    private Integer request_id;
    private SharedUser[] users;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            UsersShared usersShared = (UsersShared) obj;
            if (Objects.equals(this.request_id, usersShared.request_id) && Arrays.equals(this.users, usersShared.users)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (Objects.hash(this.request_id) * 31) + Arrays.hashCode(this.users);
    }

    public Integer requestId() {
        return this.request_id;
    }

    public String toString() {
        return "UsersShared{request_id=" + this.request_id + ", users=" + Arrays.toString(this.users) + '}';
    }

    public SharedUser[] users() {
        return this.users;
    }
}
