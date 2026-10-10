package com.pengrad.telegrambot.passport;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class FileCredentials implements Serializable {
    private static final long serialVersionUID = 0;
    private String file_hash;
    private String secret;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            FileCredentials fileCredentials = (FileCredentials) obj;
            String str = this.file_hash;
            if (str == null ? fileCredentials.file_hash != null : !str.equals(fileCredentials.file_hash)) {
                return false;
            }
            String str2 = this.secret;
            String str3 = fileCredentials.secret;
            if (str2 != null) {
                return str2.equals(str3);
            }
            if (str3 == null) {
                return true;
            }
        }
        return false;
    }

    public String fileHash() {
        return this.file_hash;
    }

    public int hashCode() {
        String str = this.file_hash;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.secret;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String secret() {
        return this.secret;
    }

    public String toString() {
        return "FileCredentials{file_hash='" + this.file_hash + "', secret='" + this.secret + "'}";
    }
}
