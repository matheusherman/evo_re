package com.pengrad.telegrambot.passport;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class SecureValue implements Serializable {
    private static final long serialVersionUID = 0;
    private DataCredentials data;
    private FileCredentials[] files;
    private FileCredentials front_side;
    private FileCredentials reverse_side;
    private FileCredentials selfie;
    private FileCredentials[] translation;

    public DataCredentials data() {
        return this.data;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SecureValue secureValue = (SecureValue) obj;
        DataCredentials dataCredentials = this.data;
        if (dataCredentials == null ? secureValue.data != null : !dataCredentials.equals(secureValue.data)) {
            return false;
        }
        FileCredentials fileCredentials = this.front_side;
        if (fileCredentials == null ? secureValue.front_side != null : !fileCredentials.equals(secureValue.front_side)) {
            return false;
        }
        FileCredentials fileCredentials2 = this.reverse_side;
        if (fileCredentials2 == null ? secureValue.reverse_side != null : !fileCredentials2.equals(secureValue.reverse_side)) {
            return false;
        }
        FileCredentials fileCredentials3 = this.selfie;
        if (fileCredentials3 == null ? secureValue.selfie != null : !fileCredentials3.equals(secureValue.selfie)) {
            return false;
        }
        if (Arrays.equals(this.translation, secureValue.translation)) {
            return Arrays.equals(this.files, secureValue.files);
        }
        return false;
    }

    public FileCredentials[] files() {
        return this.files;
    }

    public FileCredentials frontSide() {
        return this.front_side;
    }

    public int hashCode() {
        DataCredentials dataCredentials = this.data;
        int iHashCode = (dataCredentials != null ? dataCredentials.hashCode() : 0) * 31;
        FileCredentials fileCredentials = this.front_side;
        int iHashCode2 = (iHashCode + (fileCredentials != null ? fileCredentials.hashCode() : 0)) * 31;
        FileCredentials fileCredentials2 = this.reverse_side;
        int iHashCode3 = (iHashCode2 + (fileCredentials2 != null ? fileCredentials2.hashCode() : 0)) * 31;
        FileCredentials fileCredentials3 = this.selfie;
        return ((((iHashCode3 + (fileCredentials3 != null ? fileCredentials3.hashCode() : 0)) * 31) + Arrays.hashCode(this.translation)) * 31) + Arrays.hashCode(this.files);
    }

    public FileCredentials reverseSide() {
        return this.reverse_side;
    }

    public FileCredentials selfie() {
        return this.selfie;
    }

    public String toString() {
        return "SecureValue{data=" + this.data + ", front_side=" + this.front_side + ", reverse_side=" + this.reverse_side + ", selfie=" + this.selfie + ", translation=" + Arrays.toString(this.translation) + ", files=" + Arrays.toString(this.files) + '}';
    }

    public FileCredentials[] translation() {
        return this.translation;
    }
}
