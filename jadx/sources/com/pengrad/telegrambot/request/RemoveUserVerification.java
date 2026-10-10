package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegate;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegateKt;
import i9.k;
import kotlin.Metadata;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.w;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/pengrad/telegrambot/request/RemoveUserVerification;", "Lcom/pengrad/telegrambot/request/KBaseRequest;", "Lcom/pengrad/telegrambot/response/BaseResponse;", "userId", "", "(J)V", "getUserId", "()J", "userId$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RemoveUserVerification extends KBaseRequest<RemoveUserVerification, BaseResponse> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(RemoveUserVerification.class, "userId", "getUserId()J", 0))};

    /* JADX INFO: renamed from: userId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate userId;

    public RemoveUserVerification(long j10) {
        super(c0.b(BaseResponse.class));
        this.userId = RequestParameterDelegateKt.requestParameter$default(Long.valueOf(j10), null, 2, null).provideDelegate(this, $$delegatedProperties[0]);
    }

    public final long getUserId() {
        return ((Number) this.userId.getValue(this, $$delegatedProperties[0])).longValue();
    }
}
