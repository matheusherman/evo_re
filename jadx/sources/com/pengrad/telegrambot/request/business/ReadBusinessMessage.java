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
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/pengrad/telegrambot/request/business/ReadBusinessMessage;", "Lcom/pengrad/telegrambot/request/KBaseRequest;", "Lcom/pengrad/telegrambot/response/BaseResponse;", "businessConnectionId", "", "chatId", "", "messageId", "", "(Ljava/lang/String;JI)V", "getBusinessConnectionId", "()Ljava/lang/String;", "businessConnectionId$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "getChatId", "()J", "chatId$delegate", "getMessageId", "()I", "messageId$delegate", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ReadBusinessMessage extends KBaseRequest<ReadBusinessMessage, BaseResponse> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(ReadBusinessMessage.class, "businessConnectionId", "getBusinessConnectionId()Ljava/lang/String;", 0)), c0.g(new w(ReadBusinessMessage.class, "chatId", "getChatId()J", 0)), c0.g(new w(ReadBusinessMessage.class, "messageId", "getMessageId()I", 0))};

    /* JADX INFO: renamed from: businessConnectionId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate businessConnectionId;

    /* JADX INFO: renamed from: chatId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate chatId;

    /* JADX INFO: renamed from: messageId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate messageId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadBusinessMessage(String businessConnectionId, long j10, int i10) {
        super(c0.b(BaseResponse.class));
        m.f(businessConnectionId, "businessConnectionId");
        RequestParameterDelegate requestParameterDelegateRequestParameter = RequestParameterDelegateKt.requestParameter(businessConnectionId, "business_connection_id");
        k<?>[] kVarArr = $$delegatedProperties;
        this.businessConnectionId = requestParameterDelegateRequestParameter.provideDelegate(this, kVarArr[0]);
        this.chatId = RequestParameterDelegateKt.requestParameter(Long.valueOf(j10), "chat_id").provideDelegate(this, kVarArr[1]);
        this.messageId = RequestParameterDelegateKt.requestParameter(Integer.valueOf(i10), "message_id").provideDelegate(this, kVarArr[2]);
    }

    public final String getBusinessConnectionId() {
        return (String) this.businessConnectionId.getValue(this, $$delegatedProperties[0]);
    }

    public final long getChatId() {
        return ((Number) this.chatId.getValue(this, $$delegatedProperties[1])).longValue();
    }

    public final int getMessageId() {
        return ((Number) this.messageId.getValue(this, $$delegatedProperties[2])).intValue();
    }
}
