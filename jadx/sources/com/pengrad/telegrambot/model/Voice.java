package com.pengrad.telegrambot.model;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class Voice implements Serializable {
    private static final long serialVersionUID = 0;
    private Integer duration;
    private String file_id;
    private Long file_size;
    private String file_unique_id;
    private String mime_type;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Voice voice = (Voice) obj;
            String str = this.file_id;
            if (str == null ? voice.file_id != null : !str.equals(voice.file_id)) {
                return false;
            }
            String str2 = this.file_unique_id;
            if (str2 == null ? voice.file_unique_id != null : !str2.equals(voice.file_unique_id)) {
                return false;
            }
            Integer num = this.duration;
            if (num == null ? voice.duration != null : !num.equals(voice.duration)) {
                return false;
            }
            String str3 = this.mime_type;
            if (str3 == null ? voice.mime_type != null : !str3.equals(voice.mime_type)) {
                return false;
            }
            Long l10 = this.file_size;
            Long l11 = voice.file_size;
            if (l10 != null) {
                return l10.equals(l11);
            }
            if (l11 == null) {
                return true;
            }
        }
        return false;
    }

    public Integer duration() {
        return this.duration;
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

    public String mimeType() {
        return this.mime_type;
    }

    public String toString() {
        return "Voice{file_id='" + this.file_id + "', file_unique_id='" + this.file_unique_id + "', duration=" + this.duration + ", mime_type='" + this.mime_type + "', file_size=" + this.file_size + '}';
    }
}
