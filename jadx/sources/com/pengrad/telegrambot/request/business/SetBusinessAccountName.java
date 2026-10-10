package com.pengrad.telegrambot.request.business;

import c9.l;
import com.pengrad.telegrambot.request.KBaseRequest;
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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0004R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\u0005\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\f\u001a\u0004\b\r\u0010\nR/\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/pengrad/telegrambot/request/business/SetBusinessAccountName;", "Lcom/pengrad/telegrambot/request/KBaseRequest;", "Lcom/pengrad/telegrambot/response/BaseResponse;", "businessConnectionId", "", "firstName", "(Ljava/lang/String;Ljava/lang/String;)V", "lastName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBusinessConnectionId", "()Ljava/lang/String;", "businessConnectionId$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "getFirstName", "firstName$delegate", "<set-?>", "getLastName", "setLastName", "(Ljava/lang/String;)V", "lastName$delegate", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SetBusinessAccountName extends KBaseRequest<SetBusinessAccountName, BaseResponse> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(SetBusinessAccountName.class, "businessConnectionId", "getBusinessConnectionId()Ljava/lang/String;", 0)), c0.g(new w(SetBusinessAccountName.class, "firstName", "getFirstName()Ljava/lang/String;", 0)), c0.e(new q(SetBusinessAccountName.class, "lastName", "getLastName()Ljava/lang/String;", 0))};

    /* JADX INFO: renamed from: businessConnectionId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate businessConnectionId;

    /* JADX INFO: renamed from: firstName$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate firstName;

    /* JADX INFO: renamed from: lastName$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate lastName;

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.business.SetBusinessAccountName$lastName$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/business/SetBusinessAccountName;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/business/SetBusinessAccountName;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass5 extends o implements l<SetBusinessAccountName, z> {
        final /* synthetic */ String $lastName;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SetBusinessAccountName setBusinessAccountName) {
            invoke2(setBusinessAccountName);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(String str) {
            super(1);
            this.$lastName = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SetBusinessAccountName applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setLastName(this.$lastName);
        }
    }

    private SetBusinessAccountName(String str, String str2, String str3) {
        super(c0.b(BaseResponse.class));
        RequestParameterDelegate requestParameterDelegateRequestParameter = RequestParameterDelegateKt.requestParameter(str, "business_connection_id");
        k<?>[] kVarArr = $$delegatedProperties;
        this.businessConnectionId = requestParameterDelegateRequestParameter.provideDelegate(this, kVarArr[0]);
        this.firstName = RequestParameterDelegateKt.requestParameter(str2, "first_name").provideDelegate(this, kVarArr[1]);
        this.lastName = RequestParameterDelegateKt.optionalRequestParameter$default(str3, "last_name", null, 4, null).provideDelegate(this, kVarArr[2]);
    }

    public final String getBusinessConnectionId() {
        return (String) this.businessConnectionId.getValue(this, $$delegatedProperties[0]);
    }

    public final String getFirstName() {
        return (String) this.firstName.getValue(this, $$delegatedProperties[1]);
    }

    public final String getLastName() {
        return (String) this.lastName.getValue(this, $$delegatedProperties[2]);
    }

    public final SetBusinessAccountName lastName(String lastName) {
        m.f(lastName, "lastName");
        return applySelf(new AnonymousClass5(lastName));
    }

    public final void setLastName(String str) {
        this.lastName.setValue(this, $$delegatedProperties[2], str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SetBusinessAccountName(String businessConnectionId, String firstName) {
        this(businessConnectionId, firstName, null);
        m.f(businessConnectionId, "businessConnectionId");
        m.f(firstName, "firstName");
    }
}
