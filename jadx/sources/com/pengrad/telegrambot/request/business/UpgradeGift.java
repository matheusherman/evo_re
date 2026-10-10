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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006B+\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nR\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR/\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0005\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0016\u0010\rR/\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/pengrad/telegrambot/request/business/UpgradeGift;", "Lcom/pengrad/telegrambot/request/KBaseRequest;", "Lcom/pengrad/telegrambot/response/BaseResponse;", "businessConnectionId", "", "ownedGiftId", "(Ljava/lang/String;Ljava/lang/String;)V", "keepOriginalDetails", "", "starCount", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getBusinessConnectionId", "()Ljava/lang/String;", "businessConnectionId$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "<set-?>", "getKeepOriginalDetails", "()Ljava/lang/Boolean;", "setKeepOriginalDetails", "(Ljava/lang/Boolean;)V", "keepOriginalDetails$delegate", "getOwnedGiftId", "ownedGiftId$delegate", "getStarCount", "()Ljava/lang/Integer;", "setStarCount", "(Ljava/lang/Integer;)V", "starCount$delegate", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UpgradeGift extends KBaseRequest<UpgradeGift, BaseResponse> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(UpgradeGift.class, "businessConnectionId", "getBusinessConnectionId()Ljava/lang/String;", 0)), c0.g(new w(UpgradeGift.class, "ownedGiftId", "getOwnedGiftId()Ljava/lang/String;", 0)), c0.e(new q(UpgradeGift.class, "keepOriginalDetails", "getKeepOriginalDetails()Ljava/lang/Boolean;", 0)), c0.e(new q(UpgradeGift.class, "starCount", "getStarCount()Ljava/lang/Integer;", 0))};

    /* JADX INFO: renamed from: businessConnectionId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate businessConnectionId;

    /* JADX INFO: renamed from: keepOriginalDetails$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate keepOriginalDetails;

    /* JADX INFO: renamed from: ownedGiftId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate ownedGiftId;

    /* JADX INFO: renamed from: starCount$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate starCount;

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.business.UpgradeGift$keepOriginalDetails$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/business/UpgradeGift;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/business/UpgradeGift;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass5 extends o implements l<UpgradeGift, z> {
        final /* synthetic */ boolean $keepOriginalDetails;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(UpgradeGift upgradeGift) {
            invoke2(upgradeGift);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(boolean z10) {
            super(1);
            this.$keepOriginalDetails = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(UpgradeGift applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setKeepOriginalDetails(Boolean.valueOf(this.$keepOriginalDetails));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.business.UpgradeGift$starCount$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/business/UpgradeGift;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/business/UpgradeGift;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06845 extends o implements l<UpgradeGift, z> {
        final /* synthetic */ int $starCount;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(UpgradeGift upgradeGift) {
            invoke2(upgradeGift);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06845(int i10) {
            super(1);
            this.$starCount = i10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(UpgradeGift applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setStarCount(Integer.valueOf(this.$starCount));
        }
    }

    private UpgradeGift(String str, String str2, Boolean bool, Integer num) {
        super(c0.b(BaseResponse.class));
        RequestParameterDelegate requestParameterDelegateRequestParameter = RequestParameterDelegateKt.requestParameter(str, "business_connection_id");
        k<?>[] kVarArr = $$delegatedProperties;
        this.businessConnectionId = requestParameterDelegateRequestParameter.provideDelegate(this, kVarArr[0]);
        this.ownedGiftId = RequestParameterDelegateKt.requestParameter(str2, "owned_gift_id").provideDelegate(this, kVarArr[1]);
        this.keepOriginalDetails = RequestParameterDelegateKt.optionalRequestParameter$default(bool, "keep_original_details", null, 4, null).provideDelegate(this, kVarArr[2]);
        this.starCount = RequestParameterDelegateKt.optionalRequestParameter$default(num, "star_count", null, 4, null).provideDelegate(this, kVarArr[3]);
    }

    public final String getBusinessConnectionId() {
        return (String) this.businessConnectionId.getValue(this, $$delegatedProperties[0]);
    }

    public final Boolean getKeepOriginalDetails() {
        return (Boolean) this.keepOriginalDetails.getValue(this, $$delegatedProperties[2]);
    }

    public final String getOwnedGiftId() {
        return (String) this.ownedGiftId.getValue(this, $$delegatedProperties[1]);
    }

    public final Integer getStarCount() {
        return (Integer) this.starCount.getValue(this, $$delegatedProperties[3]);
    }

    public final UpgradeGift keepOriginalDetails(boolean keepOriginalDetails) {
        return applySelf(new AnonymousClass5(keepOriginalDetails));
    }

    public final void setKeepOriginalDetails(Boolean bool) {
        this.keepOriginalDetails.setValue(this, $$delegatedProperties[2], bool);
    }

    public final void setStarCount(Integer num) {
        this.starCount.setValue(this, $$delegatedProperties[3], num);
    }

    public final UpgradeGift starCount(int starCount) {
        return applySelf(new C06845(starCount));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UpgradeGift(String businessConnectionId, String ownedGiftId) {
        this(businessConnectionId, ownedGiftId, null, null);
        m.f(businessConnectionId, "businessConnectionId");
        m.f(ownedGiftId, "ownedGiftId");
    }
}
