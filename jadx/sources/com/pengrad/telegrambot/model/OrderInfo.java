package com.pengrad.telegrambot.model;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class OrderInfo implements Serializable {
    private static final long serialVersionUID = 0;
    private String email;
    private String name;
    private String phone_number;
    private ShippingAddress shipping_address;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            OrderInfo orderInfo = (OrderInfo) obj;
            String str = this.name;
            if (str == null ? orderInfo.name != null : !str.equals(orderInfo.name)) {
                return false;
            }
            String str2 = this.phone_number;
            if (str2 == null ? orderInfo.phone_number != null : !str2.equals(orderInfo.phone_number)) {
                return false;
            }
            String str3 = this.email;
            if (str3 == null ? orderInfo.email != null : !str3.equals(orderInfo.email)) {
                return false;
            }
            ShippingAddress shippingAddress = this.shipping_address;
            ShippingAddress shippingAddress2 = orderInfo.shipping_address;
            if (shippingAddress != null) {
                return shippingAddress.equals(shippingAddress2);
            }
            if (shippingAddress2 == null) {
                return true;
            }
        }
        return false;
    }

    public String email() {
        return this.email;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.phone_number;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.email;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        ShippingAddress shippingAddress = this.shipping_address;
        return iHashCode3 + (shippingAddress != null ? shippingAddress.hashCode() : 0);
    }

    public String name() {
        return this.name;
    }

    public String phoneNumber() {
        return this.phone_number;
    }

    public ShippingAddress shippingAddress() {
        return this.shipping_address;
    }

    public String toString() {
        return "OrderInfo{name='" + this.name + "', phone_number='" + this.phone_number + "', email='" + this.email + "', shipping_address=" + this.shipping_address + '}';
    }
}
