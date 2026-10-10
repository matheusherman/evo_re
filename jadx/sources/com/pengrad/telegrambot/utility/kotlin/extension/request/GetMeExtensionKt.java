package com.pengrad.telegrambot.utility.kotlin.extension.request;

import c9.l;
import com.pengrad.telegrambot.TelegramAware;
import com.pengrad.telegrambot.request.GetMe;
import com.pengrad.telegrambot.response.GetMeResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a5\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005*\u00020\u00002\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"Lcom/pengrad/telegrambot/TelegramAware;", "Lkotlin/Function1;", "Lcom/pengrad/telegrambot/request/GetMe;", "Lr8/z;", "modifier", "Lcom/pengrad/telegrambot/response/GetMeResponse;", "kotlin.jvm.PlatformType", "getMe", "(Lcom/pengrad/telegrambot/TelegramAware;Lc9/l;)Lcom/pengrad/telegrambot/response/GetMeResponse;", "library"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class GetMeExtensionKt {

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.GetMeExtensionKt$getMe$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/GetMe;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/GetMe;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass1 extends o implements l<GetMe, z> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GetMe getMe) {
            m.f(getMe, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(GetMe getMe) {
            invoke2(getMe);
            return z.f17874a;
        }
    }

    public static final GetMeResponse getMe(TelegramAware telegramAware, l<? super GetMe, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(modifier, "modifier");
        GetMe getMe = new GetMe();
        modifier.invoke(getMe);
        return (GetMeResponse) telegramAware.execute(getMe);
    }

    public static /* synthetic */ GetMeResponse getMe$default(TelegramAware telegramAware, l modifier, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            modifier = AnonymousClass1.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(modifier, "modifier");
        GetMe getMe = new GetMe();
        modifier.invoke(getMe);
        return (GetMeResponse) telegramAware.execute(getMe);
    }
}
