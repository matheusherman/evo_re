package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.stars.StarTransactions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class GetStarTransactionsResponse extends BaseResponse {
    private StarTransactions result;

    public StarTransactions result() {
        return this.result;
    }

    @Override // com.pengrad.telegrambot.response.BaseResponse
    public String toString() {
        return "GetStarTransactionsResponse{result=" + Objects.toString(this.result) + '}';
    }
}
