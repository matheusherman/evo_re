package com.pengrad.telegrambot.request.business;

import com.pengrad.telegrambot.model.gift.AcceptedGiftTypes;
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
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/pengrad/telegrambot/request/business/SetBusinessAccountGiftSettings;", "Lcom/pengrad/telegrambot/request/KBaseRequest;", "Lcom/pengrad/telegrambot/response/BaseResponse;", "businessConnectionId", "", "showGiftButton", "", "acceptedGiftTypes", "Lcom/pengrad/telegrambot/model/gift/AcceptedGiftTypes;", "(Ljava/lang/String;ZLcom/pengrad/telegrambot/model/gift/AcceptedGiftTypes;)V", "getAcceptedGiftTypes", "()Lcom/pengrad/telegrambot/model/gift/AcceptedGiftTypes;", "acceptedGiftTypes$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "getBusinessConnectionId", "()Ljava/lang/String;", "businessConnectionId$delegate", "getShowGiftButton", "()Z", "showGiftButton$delegate", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SetBusinessAccountGiftSettings extends KBaseRequest<SetBusinessAccountGiftSettings, BaseResponse> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(SetBusinessAccountGiftSettings.class, "businessConnectionId", "getBusinessConnectionId()Ljava/lang/String;", 0)), c0.g(new w(SetBusinessAccountGiftSettings.class, "showGiftButton", "getShowGiftButton()Z", 0)), c0.g(new w(SetBusinessAccountGiftSettings.class, "acceptedGiftTypes", "getAcceptedGiftTypes()Lcom/pengrad/telegrambot/model/gift/AcceptedGiftTypes;", 0))};

    /* JADX INFO: renamed from: acceptedGiftTypes$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate acceptedGiftTypes;

    /* JADX INFO: renamed from: businessConnectionId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate businessConnectionId;

    /* JADX INFO: renamed from: showGiftButton$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate showGiftButton;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetBusinessAccountGiftSettings(String businessConnectionId, boolean z10, AcceptedGiftTypes acceptedGiftTypes) {
        super(c0.b(BaseResponse.class));
        m.f(businessConnectionId, "businessConnectionId");
        m.f(acceptedGiftTypes, "acceptedGiftTypes");
        RequestParameterDelegate requestParameterDelegateRequestParameter = RequestParameterDelegateKt.requestParameter(businessConnectionId, "business_connection_id");
        k<?>[] kVarArr = $$delegatedProperties;
        this.businessConnectionId = requestParameterDelegateRequestParameter.provideDelegate(this, kVarArr[0]);
        this.showGiftButton = RequestParameterDelegateKt.requestParameter(Boolean.valueOf(z10), "show_gift_button").provideDelegate(this, kVarArr[1]);
        this.acceptedGiftTypes = RequestParameterDelegateKt.requestParameter(acceptedGiftTypes, "accepted_gift_types").provideDelegate(this, kVarArr[2]);
    }

    public final AcceptedGiftTypes getAcceptedGiftTypes() {
        return (AcceptedGiftTypes) this.acceptedGiftTypes.getValue(this, $$delegatedProperties[2]);
    }

    public final String getBusinessConnectionId() {
        return (String) this.businessConnectionId.getValue(this, $$delegatedProperties[0]);
    }

    public final boolean getShowGiftButton() {
        return ((Boolean) this.showGiftButton.getValue(this, $$delegatedProperties[1])).booleanValue();
    }
}
