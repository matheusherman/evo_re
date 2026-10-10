package com.pengrad.telegrambot.passport;

import com.pengrad.telegrambot.passport.decrypt.Decrypt;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class EncryptedCredentials implements Serializable {
    private static final long serialVersionUID = 0;
    private String data;
    private String hash;
    private String secret;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            EncryptedCredentials encryptedCredentials = (EncryptedCredentials) obj;
            String str = this.data;
            if (str == null ? encryptedCredentials.data != null : !str.equals(encryptedCredentials.data)) {
                return false;
            }
            String str2 = this.hash;
            if (str2 == null ? encryptedCredentials.hash != null : !str2.equals(encryptedCredentials.hash)) {
                return false;
            }
            String str3 = this.secret;
            String str4 = encryptedCredentials.secret;
            if (str3 != null) {
                return str3.equals(str4);
            }
            if (str4 == null) {
                return true;
            }
        }
        return false;
    }

    public String data() {
        return this.data;
    }

    public Credentials decrypt(String str) {
        return Decrypt.decryptCredentials(str, this.data, this.hash, this.secret);
    }

    public String hash() {
        return this.hash;
    }

    public int hashCode() {
        String str = this.data;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.hash;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.secret;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String secret() {
        return this.secret;
    }

    public String toString() {
        return "EncryptedCredentials{data='" + this.data + "', hash='" + this.hash + "', secret='" + this.secret + "'}";
    }
}
