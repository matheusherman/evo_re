package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class UserProfilePhotos implements Serializable {
    private static final long serialVersionUID = 0;
    private PhotoSize[][] photos;
    private Integer total_count;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserProfilePhotos userProfilePhotos = (UserProfilePhotos) obj;
        Integer num = this.total_count;
        if (num == null ? userProfilePhotos.total_count == null : num.equals(userProfilePhotos.total_count)) {
            return Arrays.deepEquals(this.photos, userProfilePhotos.photos);
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.total_count;
        return ((num != null ? num.hashCode() : 0) * 31) + Arrays.deepHashCode(this.photos);
    }

    public PhotoSize[][] photos() {
        return this.photos;
    }

    public String toString() {
        return "UserProfilePhotos{total_count=" + this.total_count + ", photos=" + Arrays.deepToString(this.photos) + '}';
    }

    public Integer totalCount() {
        return this.total_count;
    }
}
