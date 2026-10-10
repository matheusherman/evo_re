package com.pengrad.telegrambot.model.shared;

import com.pengrad.telegrambot.model.PhotoSize;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class SharedUser implements Serializable {
    private static final long serialVersionUID = 0;
    private String first_name;
    private String last_name;
    private PhotoSize[] photo;
    private Long user_id;
    private String username;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            SharedUser sharedUser = (SharedUser) obj;
            if (Objects.equals(this.user_id, sharedUser.user_id) && Objects.equals(this.first_name, sharedUser.first_name) && Objects.equals(this.last_name, sharedUser.last_name) && Objects.equals(this.username, sharedUser.username) && Objects.deepEquals(this.photo, sharedUser.photo)) {
                return true;
            }
        }
        return false;
    }

    public String firstName() {
        return this.first_name;
    }

    public int hashCode() {
        return Objects.hash(this.user_id, this.first_name, this.last_name, this.username, Integer.valueOf(Arrays.hashCode(this.photo)));
    }

    public String lastName() {
        return this.last_name;
    }

    public PhotoSize[] photo() {
        return this.photo;
    }

    public String toString() {
        return "SharedUser{user_id=" + this.user_id + ", first_name='" + this.first_name + "', last_name='" + this.last_name + "', username='" + this.username + "', photo=" + Arrays.toString(this.photo) + '}';
    }

    public Long userId() {
        return this.user_id;
    }

    public String username() {
        return this.username;
    }
}
