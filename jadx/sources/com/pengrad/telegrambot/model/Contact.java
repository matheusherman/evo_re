package com.pengrad.telegrambot.model;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class Contact implements Serializable {
    private static final long serialVersionUID = 0;
    private String first_name;
    private String last_name;
    private String phone_number;
    private Long user_id;
    private String vcard;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Contact contact = (Contact) obj;
            String str = this.phone_number;
            if (str == null ? contact.phone_number != null : !str.equals(contact.phone_number)) {
                return false;
            }
            String str2 = this.first_name;
            if (str2 == null ? contact.first_name != null : !str2.equals(contact.first_name)) {
                return false;
            }
            String str3 = this.last_name;
            if (str3 == null ? contact.last_name != null : !str3.equals(contact.last_name)) {
                return false;
            }
            Long l10 = this.user_id;
            if (l10 == null ? contact.user_id != null : !l10.equals(contact.user_id)) {
                return false;
            }
            String str4 = this.vcard;
            String str5 = contact.vcard;
            if (str4 != null) {
                return str4.equals(str5);
            }
            if (str5 == null) {
                return true;
            }
        }
        return false;
    }

    public String firstName() {
        return this.first_name;
    }

    public int hashCode() {
        String str = this.phone_number;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String lastName() {
        return this.last_name;
    }

    public String phoneNumber() {
        return this.phone_number;
    }

    public String toString() {
        return "Contact{phone_number='" + this.phone_number + "', first_name='" + this.first_name + "', last_name='" + this.last_name + "', user_id=" + this.user_id + ", vcard='" + this.vcard + "'}";
    }

    public Long userId() {
        return this.user_id;
    }

    public String vcard() {
        return this.vcard;
    }
}
