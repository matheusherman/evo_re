package com.pengrad.telegrambot.passport;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class PassportData implements Serializable {
    private static final long serialVersionUID = 0;
    private EncryptedCredentials credentials;
    private EncryptedPassportElement[] data;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PassportData passportData = (PassportData) obj;
            if (!Arrays.equals(this.data, passportData.data)) {
                return false;
            }
            EncryptedCredentials encryptedCredentials = this.credentials;
            EncryptedCredentials encryptedCredentials2 = passportData.credentials;
            if (encryptedCredentials != null) {
                return encryptedCredentials.equals(encryptedCredentials2);
            }
            if (encryptedCredentials2 == null) {
                return true;
            }
        }
        return false;
    }

    public EncryptedCredentials credentials() {
        return this.credentials;
    }

    public EncryptedPassportElement[] data() {
        return this.data;
    }

    public int hashCode() {
        int iHashCode = Arrays.hashCode(this.data) * 31;
        EncryptedCredentials encryptedCredentials = this.credentials;
        return iHashCode + (encryptedCredentials != null ? encryptedCredentials.hashCode() : 0);
    }

    public String toString() {
        return "PassportData{data=" + Arrays.toString(this.data) + ", credentials=" + this.credentials + '}';
    }
}
