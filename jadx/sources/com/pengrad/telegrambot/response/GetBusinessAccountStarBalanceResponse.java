package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.stars.StarAmount;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/pengrad/telegrambot/response/GetBusinessAccountStarBalanceResponse;", "Lcom/pengrad/telegrambot/response/BaseResponse;", "result", "Lcom/pengrad/telegrambot/model/stars/StarAmount;", "(Lcom/pengrad/telegrambot/model/stars/StarAmount;)V", "getResult", "()Lcom/pengrad/telegrambot/model/stars/StarAmount;", "component1", "copy", "equals", "", TransactionPartnerType.OTHER, "", "hashCode", "", "toString", "", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class GetBusinessAccountStarBalanceResponse extends BaseResponse {
    private final StarAmount result;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GetBusinessAccountStarBalanceResponse) && m.a(this.result, ((GetBusinessAccountStarBalanceResponse) other).result);
    }

    public GetBusinessAccountStarBalanceResponse(StarAmount result) {
        m.f(result, "result");
        this.result = result;
    }

    public static /* synthetic */ GetBusinessAccountStarBalanceResponse copy$default(GetBusinessAccountStarBalanceResponse getBusinessAccountStarBalanceResponse, StarAmount starAmount, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            starAmount = getBusinessAccountStarBalanceResponse.result;
        }
        return getBusinessAccountStarBalanceResponse.copy(starAmount);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StarAmount getResult() {
        return this.result;
    }

    public final GetBusinessAccountStarBalanceResponse copy(StarAmount result) {
        m.f(result, "result");
        return new GetBusinessAccountStarBalanceResponse(result);
    }

    public final StarAmount getResult() {
        return this.result;
    }

    public int hashCode() {
        return this.result.hashCode();
    }

    @Override // com.pengrad.telegrambot.response.BaseResponse
    public String toString() {
        return "GetBusinessAccountStarBalanceResponse(result=" + this.result + ')';
    }
}
