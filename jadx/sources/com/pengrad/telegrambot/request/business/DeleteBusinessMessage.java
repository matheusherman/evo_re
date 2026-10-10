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
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bR\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/pengrad/telegrambot/request/business/DeleteBusinessMessage;", "Lcom/pengrad/telegrambot/request/KBaseRequest;", "Lcom/pengrad/telegrambot/response/BaseResponse;", "businessConnectionId", "", "messageIds", "", "", "(Ljava/lang/String;[Ljava/lang/Integer;)V", "getBusinessConnectionId", "()Ljava/lang/String;", "businessConnectionId$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "getMessageIds", "()[Ljava/lang/Integer;", "messageIds$delegate", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DeleteBusinessMessage extends KBaseRequest<DeleteBusinessMessage, BaseResponse> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(DeleteBusinessMessage.class, "businessConnectionId", "getBusinessConnectionId()Ljava/lang/String;", 0)), c0.g(new w(DeleteBusinessMessage.class, "messageIds", "getMessageIds()[Ljava/lang/Integer;", 0))};

    /* JADX INFO: renamed from: businessConnectionId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate businessConnectionId;

    /* JADX INFO: renamed from: messageIds$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate messageIds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeleteBusinessMessage(String businessConnectionId, Integer[] messageIds) {
        super(c0.b(BaseResponse.class));
        m.f(businessConnectionId, "businessConnectionId");
        m.f(messageIds, "messageIds");
        RequestParameterDelegate requestParameterDelegateRequestParameter = RequestParameterDelegateKt.requestParameter(businessConnectionId, "business_connection_id");
        k<?>[] kVarArr = $$delegatedProperties;
        this.businessConnectionId = requestParameterDelegateRequestParameter.provideDelegate(this, kVarArr[0]);
        this.messageIds = RequestParameterDelegateKt.requestParameter(messageIds, "message_ids").provideDelegate(this, kVarArr[1]);
    }

    public final String getBusinessConnectionId() {
        return (String) this.businessConnectionId.getValue(this, $$delegatedProperties[0]);
    }

    public final Integer[] getMessageIds() {
        return (Integer[]) this.messageIds.getValue(this, $$delegatedProperties[1]);
    }
}
