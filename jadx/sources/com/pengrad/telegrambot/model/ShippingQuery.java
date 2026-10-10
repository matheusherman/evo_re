package com.pengrad.telegrambot.model;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ShippingQuery implements Serializable {
    private static final long serialVersionUID = 0;
    private User from;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f8238id;
    private String invoice_payload;
    private ShippingAddress shipping_address;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ShippingQuery shippingQuery = (ShippingQuery) obj;
            String str = this.f8238id;
            if (str == null ? shippingQuery.f8238id != null : !str.equals(shippingQuery.f8238id)) {
                return false;
            }
            User user = this.from;
            if (user == null ? shippingQuery.from != null : !user.equals(shippingQuery.from)) {
                return false;
            }
            String str2 = this.invoice_payload;
            if (str2 == null ? shippingQuery.invoice_payload != null : !str2.equals(shippingQuery.invoice_payload)) {
                return false;
            }
            ShippingAddress shippingAddress = this.shipping_address;
            ShippingAddress shippingAddress2 = shippingQuery.shipping_address;
            if (shippingAddress != null) {
                return shippingAddress.equals(shippingAddress2);
            }
            if (shippingAddress2 == null) {
                return true;
            }
        }
        return false;
    }

    public User from() {
        return this.from;
    }

    public int hashCode() {
        String str = this.f8238id;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String id() {
        return this.f8238id;
    }

    public String invoicePayload() {
        return this.invoice_payload;
    }

    public ShippingAddress shippingAddress() {
        return this.shipping_address;
    }

    public String toString() {
        return "ShippingQuery{id='" + this.f8238id + "', from=" + this.from + ", invoice_payload='" + this.invoice_payload + "', shipping_address=" + this.shipping_address + '}';
    }
}
