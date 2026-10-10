package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class RefundedPayment implements Serializable {
    private static final long serialVersionUID = 0;
    private String currency;
    private String invoice_payload;
    private String provider_payment_charge_id;
    private String telegram_payment_charge_id;
    private Integer total_amount;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            RefundedPayment refundedPayment = (RefundedPayment) obj;
            if (Objects.equals(this.currency, refundedPayment.currency) && Objects.equals(this.total_amount, refundedPayment.total_amount) && Objects.equals(this.invoice_payload, refundedPayment.invoice_payload) && Objects.equals(this.telegram_payment_charge_id, refundedPayment.telegram_payment_charge_id) && Objects.equals(this.provider_payment_charge_id, refundedPayment.provider_payment_charge_id)) {
                return true;
            }
        }
        return false;
    }

    public String currency() {
        return this.currency;
    }

    public int hashCode() {
        return Objects.hash(this.currency, this.total_amount, this.invoice_payload, this.telegram_payment_charge_id, this.provider_payment_charge_id);
    }

    public String invoicePayload() {
        return this.invoice_payload;
    }

    public String providerPaymentChargeId() {
        return this.provider_payment_charge_id;
    }

    public String telegramPaymentChargeId() {
        return this.telegram_payment_charge_id;
    }

    public String toString() {
        return "RefundedPayment{currency='" + this.currency + "',total_amount='" + this.total_amount + "',invoice_payload='" + this.invoice_payload + "',telegram_payment_charge_id='" + this.telegram_payment_charge_id + "',provider_payment_charge_id='" + this.provider_payment_charge_id + "'}";
    }

    public Integer totalAmount() {
        return this.total_amount;
    }
}
