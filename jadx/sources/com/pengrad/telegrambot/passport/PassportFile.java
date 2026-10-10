package com.pengrad.telegrambot.passport;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class PassportFile implements Serializable {
    private static final long serialVersionUID = 0;
    private Integer file_date;
    private String file_id;
    private Long file_size;
    private String file_unique_id;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PassportFile passportFile = (PassportFile) obj;
            String str = this.file_id;
            if (str == null ? passportFile.file_id != null : !str.equals(passportFile.file_id)) {
                return false;
            }
            String str2 = this.file_unique_id;
            if (str2 == null ? passportFile.file_unique_id != null : !str2.equals(passportFile.file_unique_id)) {
                return false;
            }
            Long l10 = this.file_size;
            if (l10 == null ? passportFile.file_size != null : !l10.equals(passportFile.file_size)) {
                return false;
            }
            Integer num = this.file_date;
            Integer num2 = passportFile.file_date;
            if (num != null) {
                return num.equals(num2);
            }
            if (num2 == null) {
                return true;
            }
        }
        return false;
    }

    public Integer fileDate() {
        return this.file_date;
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

    public String toString() {
        return "PassportFile{file_id='" + this.file_id + "', file_unique_id='" + this.file_unique_id + "', file_size=" + this.file_size + ", file_date=" + this.file_date + '}';
    }
}
