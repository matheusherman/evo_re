package com.pengrad.telegrambot.utility.kotlin.extension.request;

import c9.l;
import com.pengrad.telegrambot.TelegramAware;
import com.pengrad.telegrambot.request.SendLocation;
import com.pengrad.telegrambot.response.SendResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001aE\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001aE\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"Lcom/pengrad/telegrambot/TelegramAware;", "", "chatId", "", "latitude", "longitude", "Lkotlin/Function1;", "Lcom/pengrad/telegrambot/request/SendLocation;", "Lr8/z;", "modifier", "Lcom/pengrad/telegrambot/response/SendResponse;", "sendLocation", "(Lcom/pengrad/telegrambot/TelegramAware;JFFLc9/l;)Lcom/pengrad/telegrambot/response/SendResponse;", "", "channelUsername", "(Lcom/pengrad/telegrambot/TelegramAware;Ljava/lang/String;FFLc9/l;)Lcom/pengrad/telegrambot/response/SendResponse;", "library"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class SendLocationExtensionKt {

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendLocationExtensionKt$sendLocation$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendLocation;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendLocation;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass1 extends o implements l<SendLocation, z> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendLocation sendLocation) {
            m.f(sendLocation, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendLocation sendLocation) {
            invoke2(sendLocation);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendLocationExtensionKt$sendLocation$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendLocation;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendLocation;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass2 extends o implements l<SendLocation, z> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendLocation sendLocation) {
            m.f(sendLocation, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendLocation sendLocation) {
            invoke2(sendLocation);
            return z.f17874a;
        }
    }

    public static final SendResponse sendLocation(TelegramAware telegramAware, long j10, float f10, float f11, l<? super SendLocation, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(modifier, "modifier");
        SendLocation sendLocation = new SendLocation(j10, f10, f11);
        modifier.invoke(sendLocation);
        return (SendResponse) telegramAware.execute(sendLocation);
    }

    public static /* synthetic */ SendResponse sendLocation$default(TelegramAware telegramAware, long j10, float f10, float f11, l modifier, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            modifier = AnonymousClass1.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(modifier, "modifier");
        SendLocation sendLocation = new SendLocation(j10, f10, f11);
        modifier.invoke(sendLocation);
        return (SendResponse) telegramAware.execute(sendLocation);
    }

    public static final SendResponse sendLocation(TelegramAware telegramAware, String channelUsername, float f10, float f11, l<? super SendLocation, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(modifier, "modifier");
        SendLocation sendLocation = new SendLocation(channelUsername, f10, f11);
        modifier.invoke(sendLocation);
        return (SendResponse) telegramAware.execute(sendLocation);
    }

    public static /* synthetic */ SendResponse sendLocation$default(TelegramAware telegramAware, String channelUsername, float f10, float f11, l modifier, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            modifier = AnonymousClass2.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(modifier, "modifier");
        SendLocation sendLocation = new SendLocation(channelUsername, f10, f11);
        modifier.invoke(sendLocation);
        return (SendResponse) telegramAware.execute(sendLocation);
    }
}
