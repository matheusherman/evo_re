package com.pengrad.telegrambot.model;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class File implements Serializable {
    private static final long serialVersionUID = 0;
    private String file_id;
    private String file_path;
    private Long file_size;
    private String file_unique_id;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            File file = (File) obj;
            String str = this.file_id;
            if (str == null ? file.file_id != null : !str.equals(file.file_id)) {
                return false;
            }
            String str2 = this.file_unique_id;
            if (str2 == null ? file.file_unique_id != null : !str2.equals(file.file_unique_id)) {
                return false;
            }
            Long l10 = this.file_size;
            if (l10 == null ? file.file_size != null : !l10.equals(file.file_size)) {
                return false;
            }
            String str3 = this.file_path;
            String str4 = file.file_path;
            if (str3 != null) {
                return str3.equals(str4);
            }
            if (str4 == null) {
                return true;
            }
        }
        return false;
    }

    public String fileId() {
        return this.file_id;
    }

    public String filePath() {
        return this.file_path;
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
        return "File{file_id='" + this.file_id + "', file_unique_id='" + this.file_unique_id + "', file_size=" + this.file_size + ", file_path='" + this.file_path + "'}";
    }
}
