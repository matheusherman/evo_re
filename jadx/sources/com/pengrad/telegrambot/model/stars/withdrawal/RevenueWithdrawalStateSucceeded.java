package com.pengrad.telegrambot.model.stars.withdrawal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class RevenueWithdrawalStateSucceeded extends RevenueWithdrawalState {
    public static final String TYPE = "succeeded";
    private Integer date;
    private String url;

    @Override // com.pengrad.telegrambot.model.stars.withdrawal.RevenueWithdrawalState
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            RevenueWithdrawalStateSucceeded revenueWithdrawalStateSucceeded = (RevenueWithdrawalStateSucceeded) obj;
            if (Objects.equals(type(), revenueWithdrawalStateSucceeded.type()) && Objects.equals(this.date, revenueWithdrawalStateSucceeded.date) && Objects.equals(this.url, revenueWithdrawalStateSucceeded.url)) {
                return true;
            }
        }
        return false;
    }

    public RevenueWithdrawalStateSucceeded() {
        super(TYPE);
    }

    public Integer date() {
        return this.date;
    }

    @Override // com.pengrad.telegrambot.model.stars.withdrawal.RevenueWithdrawalState
    public String toString() {
        return "RevenueWithdrawalStateSucceeded{date=" + this.date + ", url='" + this.url + "'}";
    }

    public String url() {
        return this.url;
    }

    @Override // com.pengrad.telegrambot.model.stars.withdrawal.RevenueWithdrawalState
    public int hashCode() {
        return Objects.hash(type(), this.date, this.url);
    }
}
