package com.pengrad.telegrambot.request;

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
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\nR\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/pengrad/telegrambot/request/EditUserStarSubscription;", "Lcom/pengrad/telegrambot/request/KBaseRequest;", "Lcom/pengrad/telegrambot/response/BaseResponse;", "userId", "", "telegramPaymentChargeId", "", "isCanceled", "", "(JLjava/lang/String;Z)V", "()Z", "isCanceled$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "getTelegramPaymentChargeId", "()Ljava/lang/String;", "telegramPaymentChargeId$delegate", "getUserId", "()J", "userId$delegate", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EditUserStarSubscription extends KBaseRequest<EditUserStarSubscription, BaseResponse> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(EditUserStarSubscription.class, "userId", "getUserId()J", 0)), c0.g(new w(EditUserStarSubscription.class, "telegramPaymentChargeId", "getTelegramPaymentChargeId()Ljava/lang/String;", 0)), c0.g(new w(EditUserStarSubscription.class, "isCanceled", "isCanceled()Z", 0))};

    /* JADX INFO: renamed from: isCanceled$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate isCanceled;

    /* JADX INFO: renamed from: telegramPaymentChargeId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate telegramPaymentChargeId;

    /* JADX INFO: renamed from: userId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditUserStarSubscription(long j10, String telegramPaymentChargeId, boolean z10) {
        super(c0.b(BaseResponse.class));
        m.f(telegramPaymentChargeId, "telegramPaymentChargeId");
        RequestParameterDelegate requestParameterDelegateRequestParameter$default = RequestParameterDelegateKt.requestParameter$default(Long.valueOf(j10), null, 2, null);
        k<?>[] kVarArr = $$delegatedProperties;
        this.userId = requestParameterDelegateRequestParameter$default.provideDelegate(this, kVarArr[0]);
        this.telegramPaymentChargeId = RequestParameterDelegateKt.requestParameter$default(telegramPaymentChargeId, null, 2, null).provideDelegate(this, kVarArr[1]);
        this.isCanceled = RequestParameterDelegateKt.requestParameter$default(Boolean.valueOf(z10), null, 2, null).provideDelegate(this, kVarArr[2]);
    }

    public final String getTelegramPaymentChargeId() {
        return (String) this.telegramPaymentChargeId.getValue(this, $$delegatedProperties[1]);
    }

    public final long getUserId() {
        return ((Number) this.userId.getValue(this, $$delegatedProperties[0])).longValue();
    }

    public final boolean isCanceled() {
        return ((Boolean) this.isCanceled.getValue(this, $$delegatedProperties[2])).booleanValue();
    }
}
