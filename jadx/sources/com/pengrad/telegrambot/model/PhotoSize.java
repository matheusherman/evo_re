package com.pengrad.telegrambot.model;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class PhotoSize implements Serializable {
    private static final long serialVersionUID = 0;
    private String file_id;
    private Long file_size;
    private String file_unique_id;
    private Integer height;
    private Integer width;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PhotoSize photoSize = (PhotoSize) obj;
            String str = this.file_id;
            if (str == null ? photoSize.file_id != null : !str.equals(photoSize.file_id)) {
                return false;
            }
            String str2 = this.file_unique_id;
            if (str2 == null ? photoSize.file_unique_id != null : !str2.equals(photoSize.file_unique_id)) {
                return false;
            }
            Integer num = this.width;
            if (num == null ? photoSize.width != null : !num.equals(photoSize.width)) {
                return false;
            }
            Integer num2 = this.height;
            if (num2 == null ? photoSize.height != null : !num2.equals(photoSize.height)) {
                return false;
            }
            Long l10 = this.file_size;
            Long l11 = photoSize.file_size;
            if (l10 != null) {
                return l10.equals(l11);
            }
            if (l11 == null) {
                return true;
            }
        }
        return false;
    }

    public String fileId() {
        return this.file_id;
    }

    public Long fileSize() {
        return this.file_size;
    }

    public String fileUniqueId() {
        return this.file_unique_id;
    }

    public int hashCode() {
        String str = this.file_id;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public Integer height() {
        return this.height;
    }

    public String toString() {
        return "PhotoSize{file_id='" + this.file_id + "', file_unique_id='" + this.file_unique_id + "', width=" + this.width + ", height=" + this.height + ", file_size=" + this.file_size + '}';
    }

    public Integer width() {
        return this.width;
    }
}
