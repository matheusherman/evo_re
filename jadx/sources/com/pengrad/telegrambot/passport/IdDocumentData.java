package com.pengrad.telegrambot.passport;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class IdDocumentData extends DecryptedData implements Serializable {
    private static final long serialVersionUID = 0;
    private String document_no;
    private String expiry_date;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            IdDocumentData idDocumentData = (IdDocumentData) obj;
            String str = this.document_no;
            if (str == null ? idDocumentData.document_no != null : !str.equals(idDocumentData.document_no)) {
                return false;
            }
            String str2 = this.expiry_date;
            String str3 = idDocumentData.expiry_date;
            if (str2 != null) {
                return str2.equals(str3);
            }
            if (str3 == null) {
                return true;
            }
        }
        return false;
    }

    public String documentNo() {
        return this.document_no;
    }

    public String expiryDate() {
        return this.expiry_date;
    }

    public int hashCode() {
        String str = this.document_no;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.expiry_date;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "IdDocumentData{document_no='" + this.document_no + "', expiry_date='" + this.expiry_date + "'}";
    }
}
