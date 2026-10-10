package com.pengrad.telegrambot.passport;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class Credentials implements Serializable {
    private static final long serialVersionUID = 0;
    private String nonce;
    private SecureData secure_data;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Credentials credentials = (Credentials) obj;
            SecureData secureData = this.secure_data;
            if (secureData == null ? credentials.secure_data != null : !secureData.equals(credentials.secure_data)) {
                return false;
            }
            String str = this.nonce;
            String str2 = credentials.nonce;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        SecureData secureData = this.secure_data;
        int iHashCode = (secureData != null ? secureData.hashCode() : 0) * 31;
        String str = this.nonce;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String nonce() {
        return this.nonce;
    }

    public SecureData secureData() {
        return this.secure_data;
    }

    public String toString() {
        return "Credentials{secure_data=" + this.secure_data + ", nonce='" + this.nonce + "'}";
    }
}
