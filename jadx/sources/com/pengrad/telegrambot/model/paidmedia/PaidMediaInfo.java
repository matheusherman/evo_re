package com.pengrad.telegrambot.model.paidmedia;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class PaidMediaInfo implements Serializable {
    private static final long serialVersionUID = 0;
    private PaidMedia[] paid_media;
    private Integer star_count;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PaidMediaInfo paidMediaInfo = (PaidMediaInfo) obj;
            if (Objects.equals(this.star_count, paidMediaInfo.star_count) && Objects.deepEquals(this.paid_media, paidMediaInfo.paid_media)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.star_count, Integer.valueOf(Arrays.hashCode(this.paid_media)));
    }

    public PaidMedia[] paidMedia() {
        return this.paid_media;
    }

    public Integer starCount() {
        return this.star_count;
    }

    public String toString() {
        return "PaidMediaInfo{star_count='" + this.star_count + "',paid_media='" + Arrays.toString(this.paid_media) + "'}";
    }
}
