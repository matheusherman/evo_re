package com.pengrad.telegrambot.model;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class PreCheckoutQuery implements Serializable {
    private static final long serialVersionUID = 0;
    private String currency;
    private User from;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f8236id;
    private String invoice_payload;
    private OrderInfo order_info;
    private String shipping_option_id;
    private Integer total_amount;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PreCheckoutQuery preCheckoutQuery = (PreCheckoutQuery) obj;
            String str = this.f8236id;
            if (str == null ? preCheckoutQuery.f8236id != null : !str.equals(preCheckoutQuery.f8236id)) {
                return false;
            }
            User user = this.from;
            if (user == null ? preCheckoutQuery.from != null : !user.equals(preCheckoutQuery.from)) {
                return false;
            }
            String str2 = this.currency;
            if (str2 == null ? preCheckoutQuery.currency != null : !str2.equals(preCheckoutQuery.currency)) {
                return false;
            }
            Integer num = this.total_amount;
            if (num == null ? preCheckoutQuery.total_amount != null : !num.equals(preCheckoutQuery.total_amount)) {
                return false;
            }
            String str3 = this.invoice_payload;
            if (str3 == null ? preCheckoutQuery.invoice_payload != null : !str3.equals(preCheckoutQuery.invoice_payload)) {
                return false;
            }
            String str4 = this.shipping_option_id;
            if (str4 == null ? preCheckoutQuery.shipping_option_id != null : !str4.equals(preCheckoutQuery.shipping_option_id)) {
                return false;
            }
            OrderInfo orderInfo = this.order_info;
            OrderInfo orderInfo2 = preCheckoutQuery.order_info;
            if (orderInfo != null) {
                return orderInfo.equals(orderInfo2);
            }
            if (orderInfo2 == null) {
                return true;
            }
        }
        return false;
    }

    public String currency() {
        return this.currency;
    }

    public User from() {
        return this.from;
    }

    public int hashCode() {
        String str = this.f8236id;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String id() {
        return this.f8236id;
    }

    public String invoicePayload() {
        return this.invoice_payload;
    }

    public OrderInfo orderInfo() {
        return this.order_info;
    }

    public String shippingOptionId() {
        return this.shipping_option_id;
    }

    public String toString() {
        return "PreCheckoutQuery{id='" + this.f8236id + "', from=" + this.from + ", currency='" + this.currency + "', total_amount=" + this.total_amount + ", invoice_payload='" + this.invoice_payload + "', shipping_option_id='" + this.shipping_option_id + "', order_info=" + this.order_info + '}';
    }

    public Integer totalAmount() {
        return this.total_amount;
    }
}
