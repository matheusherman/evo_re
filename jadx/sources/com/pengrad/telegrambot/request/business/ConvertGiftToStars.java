package com.pengrad.telegrambot.request.business;

import com.pengrad.telegrambot.request.KBaseRequest;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegate;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegateKt;
import i9.k;
import kotlin.Metadata;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.w;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u0005\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\n\u001a\u0004\b\u000b\u0010\b¨\u0006\r"}, d2 = {"Lcom/pengrad/telegrambot/request/business/ConvertGiftToStars;", "Lcom/pengrad/telegrambot/request/KBaseRequest;", "Lcom/pengrad/telegrambot/response/BaseResponse;", "businessConnectionId", "", "ownedGiftId", "(Ljava/lang/String;Ljava/lang/String;)V", "getBusinessConnectionId", "()Ljava/lang/String;", "businessConnectionId$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "getOwnedGiftId", "ownedGiftId$delegate", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ConvertGiftToStars extends KBaseRequest<ConvertGiftToStars, BaseResponse> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(ConvertGiftToStars.class, "businessConnectionId", "getBusinessConnectionId()Ljava/lang/String;", 0)), c0.g(new w(ConvertGiftToStars.class, "ownedGiftId", "getOwnedGiftId()Ljava/lang/String;", 0))};

    /* JADX INFO: renamed from: businessConnectionId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate businessConnectionId;

    /* JADX INFO: renamed from: ownedGiftId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate ownedGiftId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConvertGiftToStars(String businessConnectionId, String ownedGiftId) {
        super(c0.b(BaseResponse.class));
        m.f(businessConnectionId, "businessConnectionId");
        m.f(ownedGiftId, "ownedGiftId");
        RequestParameterDelegate requestParameterDelegateRequestParameter = RequestParameterDelegateKt.requestParameter(businessConnectionId, "business_connection_id");
        k<?>[] kVarArr = $$delegatedProperties;
        this.businessConnectionId = requestParameterDelegateRequestParameter.provideDelegate(this, kVarArr[0]);
        this.ownedGiftId = RequestParameterDelegateKt.requestParameter(ownedGiftId, "owned_gift_id").provideDelegate(this, kVarArr[1]);
    }

    public final String getBusinessConnectionId() {
        return (String) this.businessConnectionId.getValue(this, $$delegatedProperties[0]);
    }

    public final String getOwnedGiftId() {
        return (String) this.ownedGiftId.getValue(this, $$delegatedProperties[1]);
    }
}
