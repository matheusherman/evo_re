package com.pengrad.telegrambot.request;

import c9.l;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegate;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegateKt;
import i9.k;
import kotlin.Metadata;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.w;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007R/\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/pengrad/telegrambot/request/VerifyUser;", "Lcom/pengrad/telegrambot/request/KBaseRequest;", "Lcom/pengrad/telegrambot/response/BaseResponse;", "userId", "", "(J)V", "<set-?>", "", "customDescription", "getCustomDescription", "()Ljava/lang/String;", "setCustomDescription", "(Ljava/lang/String;)V", "customDescription$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "getUserId", "()J", "userId$delegate", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VerifyUser extends KBaseRequest<VerifyUser, BaseResponse> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(VerifyUser.class, "userId", "getUserId()J", 0)), c0.e(new q(VerifyUser.class, "customDescription", "getCustomDescription()Ljava/lang/String;", 0))};

    /* JADX INFO: renamed from: customDescription$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate customDescription;

    /* JADX INFO: renamed from: userId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate userId;

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.VerifyUser$customDescription$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/VerifyUser;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/VerifyUser;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass5 extends o implements l<VerifyUser, z> {
        final /* synthetic */ String $customDescription;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(VerifyUser verifyUser) {
            invoke2(verifyUser);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(String str) {
            super(1);
            this.$customDescription = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(VerifyUser applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setCustomDescription(this.$customDescription);
        }
    }

    public VerifyUser(long j10) {
        super(c0.b(BaseResponse.class));
        RequestParameterDelegate requestParameterDelegateRequestParameter$default = RequestParameterDelegateKt.requestParameter$default(Long.valueOf(j10), null, 2, null);
        k<?>[] kVarArr = $$delegatedProperties;
        this.userId = requestParameterDelegateRequestParameter$default.provideDelegate(this, kVarArr[0]);
        this.customDescription = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[1]);
    }

    public final VerifyUser customDescription(String customDescription) {
        m.f(customDescription, "customDescription");
        return applySelf(new AnonymousClass5(customDescription));
    }

    public final String getCustomDescription() {
        return (String) this.customDescription.getValue(this, $$delegatedProperties[1]);
    }

    public final long getUserId() {
        return ((Number) this.userId.getValue(this, $$delegatedProperties[0])).longValue();
    }

    public final void setCustomDescription(String str) {
        this.customDescription.setValue(this, $$delegatedProperties[1], str);
    }
}
