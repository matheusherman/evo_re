package com.pengrad.telegrambot.request.business;

import c9.l;
import com.pengrad.telegrambot.model.inputprofilephoto.InputProfilePhoto;
import com.pengrad.telegrambot.model.paidmedia.PaidMediaPhoto;
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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tR\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR/\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\b\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/pengrad/telegrambot/request/business/SetBusinessAccountProfilePhoto;", "Lcom/pengrad/telegrambot/request/KBaseRequest;", "Lcom/pengrad/telegrambot/response/BaseResponse;", "businessConnectionId", "", PaidMediaPhoto.TYPE, "Lcom/pengrad/telegrambot/model/inputprofilephoto/InputProfilePhoto;", "(Ljava/lang/String;Lcom/pengrad/telegrambot/model/inputprofilephoto/InputProfilePhoto;)V", "isPublic", "", "(Ljava/lang/String;Lcom/pengrad/telegrambot/model/inputprofilephoto/InputProfilePhoto;Ljava/lang/Boolean;)V", "getBusinessConnectionId", "()Ljava/lang/String;", "businessConnectionId$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "<set-?>", "()Ljava/lang/Boolean;", "setPublic", "(Ljava/lang/Boolean;)V", "isPublic$delegate", "getPhoto", "()Lcom/pengrad/telegrambot/model/inputprofilephoto/InputProfilePhoto;", "photo$delegate", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SetBusinessAccountProfilePhoto extends KBaseRequest<SetBusinessAccountProfilePhoto, BaseResponse> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(SetBusinessAccountProfilePhoto.class, "businessConnectionId", "getBusinessConnectionId()Ljava/lang/String;", 0)), c0.g(new w(SetBusinessAccountProfilePhoto.class, PaidMediaPhoto.TYPE, "getPhoto()Lcom/pengrad/telegrambot/model/inputprofilephoto/InputProfilePhoto;", 0)), c0.e(new q(SetBusinessAccountProfilePhoto.class, "isPublic", "isPublic()Ljava/lang/Boolean;", 0))};

    /* JADX INFO: renamed from: businessConnectionId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate businessConnectionId;

    /* JADX INFO: renamed from: isPublic$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate isPublic;

    /* JADX INFO: renamed from: photo$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate photo;

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.business.SetBusinessAccountProfilePhoto$isPublic$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/business/SetBusinessAccountProfilePhoto;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/business/SetBusinessAccountProfilePhoto;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass5 extends o implements l<SetBusinessAccountProfilePhoto, z> {
        final /* synthetic */ boolean $isPublic;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SetBusinessAccountProfilePhoto setBusinessAccountProfilePhoto) {
            invoke2(setBusinessAccountProfilePhoto);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(boolean z10) {
            super(1);
            this.$isPublic = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SetBusinessAccountProfilePhoto applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setPublic(Boolean.valueOf(this.$isPublic));
        }
    }

    private SetBusinessAccountProfilePhoto(String str, InputProfilePhoto inputProfilePhoto, Boolean bool) {
        super(c0.b(BaseResponse.class));
        RequestParameterDelegate requestParameterDelegateRequestParameter = RequestParameterDelegateKt.requestParameter(str, "business_connection_id");
        k<?>[] kVarArr = $$delegatedProperties;
        this.businessConnectionId = requestParameterDelegateRequestParameter.provideDelegate(this, kVarArr[0]);
        this.photo = RequestParameterDelegateKt.requestParameter(inputProfilePhoto, PaidMediaPhoto.TYPE).provideDelegate(this, kVarArr[1]);
        this.isPublic = RequestParameterDelegateKt.optionalRequestParameter$default(bool, "is_public", null, 4, null).provideDelegate(this, kVarArr[2]);
    }

    public final Boolean isPublic() {
        return (Boolean) this.isPublic.getValue(this, $$delegatedProperties[2]);
    }

    public final String getBusinessConnectionId() {
        return (String) this.businessConnectionId.getValue(this, $$delegatedProperties[0]);
    }

    public final InputProfilePhoto getPhoto() {
        return (InputProfilePhoto) this.photo.getValue(this, $$delegatedProperties[1]);
    }

    public final SetBusinessAccountProfilePhoto isPublic(boolean isPublic) {
        return applySelf(new AnonymousClass5(isPublic));
    }

    public final void setPublic(Boolean bool) {
        this.isPublic.setValue(this, $$delegatedProperties[2], bool);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SetBusinessAccountProfilePhoto(String businessConnectionId, InputProfilePhoto photo) {
        this(businessConnectionId, photo, null);
        m.f(businessConnectionId, "businessConnectionId");
        m.f(photo, "photo");
    }
}
