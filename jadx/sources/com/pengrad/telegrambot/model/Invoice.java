package com.pengrad.telegrambot.model;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class Invoice implements Serializable {
    private static final long serialVersionUID = 0;
    private String currency;
    private String description;
    private String start_parameter;
    private String title;
    private Integer total_amount;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Invoice invoice = (Invoice) obj;
            String str = this.title;
            if (str == null ? invoice.title != null : !str.equals(invoice.title)) {
                return false;
            }
            String str2 = this.description;
            if (str2 == null ? invoice.description != null : !str2.equals(invoice.description)) {
                return false;
            }
            String str3 = this.start_parameter;
            if (str3 == null ? invoice.start_parameter != null : !str3.equals(invoice.start_parameter)) {
                return false;
            }
            String str4 = this.currency;
            if (str4 == null ? invoice.currency != null : !str4.equals(invoice.currency)) {
                return false;
            }
            Integer num = this.total_amount;
            Integer num2 = invoice.total_amount;
            if (num != null) {
                return num.equals(num2);
            }
            if (num2 == null) {
                return true;
            }
        }
        return false;
    }

    public String currency() {
        return this.currency;
    }

    public String description() {
        return this.description;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.start_parameter;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.currency;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Integer num = this.total_amount;
        return iHashCode4 + (num != null ? num.hashCode() : 0);
    }

    public String startParameter() {
        return this.start_parameter;
    }

    public String title() {
        return this.title;
    }

    public String toString() {
        return "Invoice{title='" + this.title + "', description='" + this.description + "', start_parameter='" + this.start_parameter + "', currency='" + this.currency + "', total_amount=" + this.total_amount + '}';
    }

    public Integer totalAmount() {
        return this.total_amount;
    }
}
