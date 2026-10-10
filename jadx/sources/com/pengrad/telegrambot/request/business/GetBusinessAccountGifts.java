package com.pengrad.telegrambot.request.business;

import c9.l;
import com.pengrad.telegrambot.request.KBaseRequest;
import com.pengrad.telegrambot.response.GetBusinessAccountGiftsResponse;
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
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b#\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B_\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0007R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R/\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R/\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R/\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u0014\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R/\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0014\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R/\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010\u0014\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R/\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0014\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R/\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010\u0014\u001a\u0004\b,\u0010\u0012\"\u0004\b-\u0010\u0005R/\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0014\u001a\u0004\b/\u0010\u0017\"\u0004\b0\u0010\u0019¨\u00062"}, d2 = {"Lcom/pengrad/telegrambot/request/business/GetBusinessAccountGifts;", "Lcom/pengrad/telegrambot/request/KBaseRequest;", "Lcom/pengrad/telegrambot/response/GetBusinessAccountGiftsResponse;", "businessConnectionId", "", "(Ljava/lang/String;)V", "excludeUnsaved", "", "excludeSaved", "excludeUnlimited", "excludeLimited", "excludeUnique", "sortByPrice", "offset", "limit", "", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)V", "getBusinessConnectionId", "()Ljava/lang/String;", "businessConnectionId$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "<set-?>", "getExcludeLimited", "()Ljava/lang/Boolean;", "setExcludeLimited", "(Ljava/lang/Boolean;)V", "excludeLimited$delegate", "getExcludeSaved", "setExcludeSaved", "excludeSaved$delegate", "getExcludeUnique", "setExcludeUnique", "excludeUnique$delegate", "getExcludeUnlimited", "setExcludeUnlimited", "excludeUnlimited$delegate", "getExcludeUnsaved", "setExcludeUnsaved", "excludeUnsaved$delegate", "getLimit", "()Ljava/lang/Integer;", "setLimit", "(Ljava/lang/Integer;)V", "limit$delegate", "getOffset", "setOffset", "offset$delegate", "getSortByPrice", "setSortByPrice", "sortByPrice$delegate", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetBusinessAccountGifts extends KBaseRequest<GetBusinessAccountGifts, GetBusinessAccountGiftsResponse> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(GetBusinessAccountGifts.class, "businessConnectionId", "getBusinessConnectionId()Ljava/lang/String;", 0)), c0.e(new q(GetBusinessAccountGifts.class, "excludeUnsaved", "getExcludeUnsaved()Ljava/lang/Boolean;", 0)), c0.e(new q(GetBusinessAccountGifts.class, "excludeSaved", "getExcludeSaved()Ljava/lang/Boolean;", 0)), c0.e(new q(GetBusinessAccountGifts.class, "excludeUnlimited", "getExcludeUnlimited()Ljava/lang/Boolean;", 0)), c0.e(new q(GetBusinessAccountGifts.class, "excludeLimited", "getExcludeLimited()Ljava/lang/Boolean;", 0)), c0.e(new q(GetBusinessAccountGifts.class, "excludeUnique", "getExcludeUnique()Ljava/lang/Boolean;", 0)), c0.e(new q(GetBusinessAccountGifts.class, "sortByPrice", "getSortByPrice()Ljava/lang/Boolean;", 0)), c0.e(new q(GetBusinessAccountGifts.class, "offset", "getOffset()Ljava/lang/String;", 0)), c0.e(new q(GetBusinessAccountGifts.class, "limit", "getLimit()Ljava/lang/Integer;", 0))};

    /* JADX INFO: renamed from: businessConnectionId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate businessConnectionId;

    /* JADX INFO: renamed from: excludeLimited$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate excludeLimited;

    /* JADX INFO: renamed from: excludeSaved$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate excludeSaved;

    /* JADX INFO: renamed from: excludeUnique$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate excludeUnique;

    /* JADX INFO: renamed from: excludeUnlimited$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate excludeUnlimited;

    /* JADX INFO: renamed from: excludeUnsaved$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate excludeUnsaved;

    /* JADX INFO: renamed from: limit$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate limit;

    /* JADX INFO: renamed from: offset$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate offset;

    /* JADX INFO: renamed from: sortByPrice$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate sortByPrice;

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.business.GetBusinessAccountGifts$excludeLimited$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/business/GetBusinessAccountGifts;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/business/GetBusinessAccountGifts;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass5 extends o implements l<GetBusinessAccountGifts, z> {
        final /* synthetic */ boolean $excludeLimited;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(GetBusinessAccountGifts getBusinessAccountGifts) {
            invoke2(getBusinessAccountGifts);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(boolean z10) {
            super(1);
            this.$excludeLimited = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GetBusinessAccountGifts applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setExcludeLimited(Boolean.valueOf(this.$excludeLimited));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.business.GetBusinessAccountGifts$excludeSaved$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/business/GetBusinessAccountGifts;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/business/GetBusinessAccountGifts;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06685 extends o implements l<GetBusinessAccountGifts, z> {
        final /* synthetic */ boolean $excludeSaved;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(GetBusinessAccountGifts getBusinessAccountGifts) {
            invoke2(getBusinessAccountGifts);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06685(boolean z10) {
            super(1);
            this.$excludeSaved = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GetBusinessAccountGifts applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setExcludeSaved(Boolean.valueOf(this.$excludeSaved));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.business.GetBusinessAccountGifts$excludeUnique$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/business/GetBusinessAccountGifts;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/business/GetBusinessAccountGifts;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06695 extends o implements l<GetBusinessAccountGifts, z> {
        final /* synthetic */ boolean $excludeUnique;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(GetBusinessAccountGifts getBusinessAccountGifts) {
            invoke2(getBusinessAccountGifts);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06695(boolean z10) {
            super(1);
            this.$excludeUnique = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GetBusinessAccountGifts applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setExcludeUnique(Boolean.valueOf(this.$excludeUnique));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.business.GetBusinessAccountGifts$excludeUnlimited$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/business/GetBusinessAccountGifts;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/business/GetBusinessAccountGifts;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06705 extends o implements l<GetBusinessAccountGifts, z> {
        final /* synthetic */ boolean $excludeUnlimited;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(GetBusinessAccountGifts getBusinessAccountGifts) {
            invoke2(getBusinessAccountGifts);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06705(boolean z10) {
            super(1);
            this.$excludeUnlimited = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GetBusinessAccountGifts applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setExcludeUnlimited(Boolean.valueOf(this.$excludeUnlimited));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.business.GetBusinessAccountGifts$excludeUnsaved$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/business/GetBusinessAccountGifts;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/business/GetBusinessAccountGifts;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06715 extends o implements l<GetBusinessAccountGifts, z> {
        final /* synthetic */ boolean $excludeUnsaved;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(GetBusinessAccountGifts getBusinessAccountGifts) {
            invoke2(getBusinessAccountGifts);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06715(boolean z10) {
            super(1);
            this.$excludeUnsaved = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GetBusinessAccountGifts applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setExcludeUnsaved(Boolean.valueOf(this.$excludeUnsaved));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.business.GetBusinessAccountGifts$limit$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/business/GetBusinessAccountGifts;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/business/GetBusinessAccountGifts;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06725 extends o implements l<GetBusinessAccountGifts, z> {
        final /* synthetic */ int $limit;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(GetBusinessAccountGifts getBusinessAccountGifts) {
            invoke2(getBusinessAccountGifts);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06725(int i10) {
            super(1);
            this.$limit = i10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GetBusinessAccountGifts applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setLimit(Integer.valueOf(this.$limit));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.business.GetBusinessAccountGifts$offset$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/business/GetBusinessAccountGifts;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/business/GetBusinessAccountGifts;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06735 extends o implements l<GetBusinessAccountGifts, z> {
        final /* synthetic */ String $offset;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(GetBusinessAccountGifts getBusinessAccountGifts) {
            invoke2(getBusinessAccountGifts);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06735(String str) {
            super(1);
            this.$offset = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GetBusinessAccountGifts applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setOffset(this.$offset);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.business.GetBusinessAccountGifts$sortByPrice$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/business/GetBusinessAccountGifts;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/business/GetBusinessAccountGifts;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06745 extends o implements l<GetBusinessAccountGifts, z> {
        final /* synthetic */ boolean $sortByPrice;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(GetBusinessAccountGifts getBusinessAccountGifts) {
            invoke2(getBusinessAccountGifts);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06745(boolean z10) {
            super(1);
            this.$sortByPrice = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GetBusinessAccountGifts applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setSortByPrice(Boolean.valueOf(this.$sortByPrice));
        }
    }

    private GetBusinessAccountGifts(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, String str2, Integer num) {
        super(c0.b(GetBusinessAccountGiftsResponse.class));
        RequestParameterDelegate requestParameterDelegateRequestParameter = RequestParameterDelegateKt.requestParameter(str, "business_connection_id");
        k<?>[] kVarArr = $$delegatedProperties;
        this.businessConnectionId = requestParameterDelegateRequestParameter.provideDelegate(this, kVarArr[0]);
        this.excludeUnsaved = RequestParameterDelegateKt.optionalRequestParameter$default(bool, "exclude_unsaved", null, 4, null).provideDelegate(this, kVarArr[1]);
        this.excludeSaved = RequestParameterDelegateKt.optionalRequestParameter$default(bool2, "exclude_saved", null, 4, null).provideDelegate(this, kVarArr[2]);
        this.excludeUnlimited = RequestParameterDelegateKt.optionalRequestParameter$default(bool3, "exclude_unlimited", null, 4, null).provideDelegate(this, kVarArr[3]);
        this.excludeLimited = RequestParameterDelegateKt.optionalRequestParameter$default(bool4, "exclude_limited", null, 4, null).provideDelegate(this, kVarArr[4]);
        this.excludeUnique = RequestParameterDelegateKt.optionalRequestParameter$default(bool5, "exclude_unique", null, 4, null).provideDelegate(this, kVarArr[5]);
        this.sortByPrice = RequestParameterDelegateKt.optionalRequestParameter$default(bool6, "sort_by_price", null, 4, null).provideDelegate(this, kVarArr[6]);
        this.offset = RequestParameterDelegateKt.optionalRequestParameter$default(str2, "offset", null, 4, null).provideDelegate(this, kVarArr[7]);
        this.limit = RequestParameterDelegateKt.optionalRequestParameter$default(num, "limit", null, 4, null).provideDelegate(this, kVarArr[8]);
    }

    public final GetBusinessAccountGifts excludeLimited(boolean excludeLimited) {
        return applySelf(new AnonymousClass5(excludeLimited));
    }

    public final GetBusinessAccountGifts excludeSaved(boolean excludeSaved) {
        return applySelf(new C06685(excludeSaved));
    }

    public final GetBusinessAccountGifts excludeUnique(boolean excludeUnique) {
        return applySelf(new C06695(excludeUnique));
    }

    public final GetBusinessAccountGifts excludeUnlimited(boolean excludeUnlimited) {
        return applySelf(new C06705(excludeUnlimited));
    }

    public final GetBusinessAccountGifts excludeUnsaved(boolean excludeUnsaved) {
        return applySelf(new C06715(excludeUnsaved));
    }

    public final String getBusinessConnectionId() {
        return (String) this.businessConnectionId.getValue(this, $$delegatedProperties[0]);
    }

    public final Boolean getExcludeLimited() {
        return (Boolean) this.excludeLimited.getValue(this, $$delegatedProperties[4]);
    }

    public final Boolean getExcludeSaved() {
        return (Boolean) this.excludeSaved.getValue(this, $$delegatedProperties[2]);
    }

    public final Boolean getExcludeUnique() {
        return (Boolean) this.excludeUnique.getValue(this, $$delegatedProperties[5]);
    }

    public final Boolean getExcludeUnlimited() {
        return (Boolean) this.excludeUnlimited.getValue(this, $$delegatedProperties[3]);
    }

    public final Boolean getExcludeUnsaved() {
        return (Boolean) this.excludeUnsaved.getValue(this, $$delegatedProperties[1]);
    }

    public final Integer getLimit() {
        return (Integer) this.limit.getValue(this, $$delegatedProperties[8]);
    }

    public final String getOffset() {
        return (String) this.offset.getValue(this, $$delegatedProperties[7]);
    }

    public final Boolean getSortByPrice() {
        return (Boolean) this.sortByPrice.getValue(this, $$delegatedProperties[6]);
    }

    public final GetBusinessAccountGifts limit(int limit) {
        return applySelf(new C06725(limit));
    }

    public final GetBusinessAccountGifts offset(String offset) {
        m.f(offset, "offset");
        return applySelf(new C06735(offset));
    }

    public final void setExcludeLimited(Boolean bool) {
        this.excludeLimited.setValue(this, $$delegatedProperties[4], bool);
    }

    public final void setExcludeSaved(Boolean bool) {
        this.excludeSaved.setValue(this, $$delegatedProperties[2], bool);
    }

    public final void setExcludeUnique(Boolean bool) {
        this.excludeUnique.setValue(this, $$delegatedProperties[5], bool);
    }

    public final void setExcludeUnlimited(Boolean bool) {
        this.excludeUnlimited.setValue(this, $$delegatedProperties[3], bool);
    }

    public final void setExcludeUnsaved(Boolean bool) {
        this.excludeUnsaved.setValue(this, $$delegatedProperties[1], bool);
    }

    public final void setLimit(Integer num) {
        this.limit.setValue(this, $$delegatedProperties[8], num);
    }

    public final void setOffset(String str) {
        this.offset.setValue(this, $$delegatedProperties[7], str);
    }

    public final void setSortByPrice(Boolean bool) {
        this.sortByPrice.setValue(this, $$delegatedProperties[6], bool);
    }

    public final GetBusinessAccountGifts sortByPrice(boolean sortByPrice) {
        return applySelf(new C06745(sortByPrice));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetBusinessAccountGifts(String businessConnectionId) {
        this(businessConnectionId, null, null, null, null, null, null, null, null);
        m.f(businessConnectionId, "businessConnectionId");
    }
}
