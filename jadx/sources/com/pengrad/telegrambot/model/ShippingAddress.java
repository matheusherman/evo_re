package com.pengrad.telegrambot.model;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ShippingAddress implements Serializable {
    private static final long serialVersionUID = 0;
    private String city;
    private String country_code;
    private String post_code;
    private String state;
    private String street_line1;
    private String street_line2;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ShippingAddress shippingAddress = (ShippingAddress) obj;
            String str = this.country_code;
            if (str == null ? shippingAddress.country_code != null : !str.equals(shippingAddress.country_code)) {
                return false;
            }
            String str2 = this.state;
            if (str2 == null ? shippingAddress.state != null : !str2.equals(shippingAddress.state)) {
                return false;
            }
            String str3 = this.city;
            if (str3 == null ? shippingAddress.city != null : !str3.equals(shippingAddress.city)) {
                return false;
            }
            String str4 = this.street_line1;
            if (str4 == null ? shippingAddress.street_line1 != null : !str4.equals(shippingAddress.street_line1)) {
                return false;
            }
            String str5 = this.street_line2;
            if (str5 == null ? shippingAddress.street_line2 != null : !str5.equals(shippingAddress.street_line2)) {
                return false;
            }
            String str6 = this.post_code;
            String str7 = shippingAddress.post_code;
            if (str6 != null) {
                return str6.equals(str7);
            }
            if (str7 == null) {
                return true;
            }
        }
        return false;
    }

    public String city() {
        return this.city;
    }

    public String countryCode() {
        return this.country_code;
    }

    public int hashCode() {
        String str = this.country_code;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.state;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.city;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.street_line1;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.street_line2;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.post_code;
        return iHashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public String postCode() {
        return this.post_code;
    }

    public String state() {
        return this.state;
    }

    public String streetLine1() {
        return this.street_line1;
    }

    public String streetLine2() {
        return this.street_line2;
    }

    public String toString() {
        return "ShippingAddress{country_code='" + this.country_code + "', state='" + this.state + "', city='" + this.city + "', street_line1='" + this.street_line1 + "', street_line2='" + this.street_line2 + "', post_code='" + this.post_code + "'}";
    }
}
