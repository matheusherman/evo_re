package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.business.BusinessConnection;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class GetBusinessConnectionResponse extends BaseResponse {
    private BusinessConnection result;

    public BusinessConnection businessConnection() {
        return this.result;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GetBusinessConnectionResponse) {
            return Objects.equals(this.result, ((GetBusinessConnectionResponse) obj).result);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.result);
    }

    @Override // com.pengrad.telegrambot.response.BaseResponse
    public String toString() {
        return "GetBusinessConnectionResponse{result=" + this.result + '}';
    }
}
