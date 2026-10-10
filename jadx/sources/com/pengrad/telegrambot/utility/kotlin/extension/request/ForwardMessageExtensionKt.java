package com.pengrad.telegrambot.utility.kotlin.extension.request;

import c9.l;
import com.pengrad.telegrambot.TelegramAware;
import com.pengrad.telegrambot.request.ForwardMessage;
import com.pengrad.telegrambot.response.SendResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u001aE\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001aE\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u000f\u001aE\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0011\u001aE\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0012\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"Lcom/pengrad/telegrambot/TelegramAware;", "", "chatId", "fromChatId", "", "messageId", "Lkotlin/Function1;", "Lcom/pengrad/telegrambot/request/ForwardMessage;", "Lr8/z;", "modifier", "Lcom/pengrad/telegrambot/response/SendResponse;", "forwardMessage", "(Lcom/pengrad/telegrambot/TelegramAware;JJILc9/l;)Lcom/pengrad/telegrambot/response/SendResponse;", "", "channelUsername", "(Lcom/pengrad/telegrambot/TelegramAware;Ljava/lang/String;JILc9/l;)Lcom/pengrad/telegrambot/response/SendResponse;", "fromChannelUsername", "(Lcom/pengrad/telegrambot/TelegramAware;JLjava/lang/String;ILc9/l;)Lcom/pengrad/telegrambot/response/SendResponse;", "(Lcom/pengrad/telegrambot/TelegramAware;Ljava/lang/String;Ljava/lang/String;ILc9/l;)Lcom/pengrad/telegrambot/response/SendResponse;", "library"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ForwardMessageExtensionKt {

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.ForwardMessageExtensionKt$forwardMessage$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/ForwardMessage;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/ForwardMessage;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass1 extends o implements l<ForwardMessage, z> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ForwardMessage forwardMessage) {
            m.f(forwardMessage, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(ForwardMessage forwardMessage) {
            invoke2(forwardMessage);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.ForwardMessageExtensionKt$forwardMessage$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/ForwardMessage;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/ForwardMessage;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass2 extends o implements l<ForwardMessage, z> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ForwardMessage forwardMessage) {
            m.f(forwardMessage, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(ForwardMessage forwardMessage) {
            invoke2(forwardMessage);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.ForwardMessageExtensionKt$forwardMessage$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/ForwardMessage;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/ForwardMessage;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass3 extends o implements l<ForwardMessage, z> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ForwardMessage forwardMessage) {
            m.f(forwardMessage, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(ForwardMessage forwardMessage) {
            invoke2(forwardMessage);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.ForwardMessageExtensionKt$forwardMessage$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/ForwardMessage;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/ForwardMessage;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass4 extends o implements l<ForwardMessage, z> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ForwardMessage forwardMessage) {
            m.f(forwardMessage, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(ForwardMessage forwardMessage) {
            invoke2(forwardMessage);
            return z.f17874a;
        }
    }

    public static final SendResponse forwardMessage(TelegramAware telegramAware, long j10, long j11, int i10, l<? super ForwardMessage, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(modifier, "modifier");
        ForwardMessage forwardMessage = new ForwardMessage(j10, j11, i10);
        modifier.invoke(forwardMessage);
        return (SendResponse) telegramAware.execute(forwardMessage);
    }

    public static /* synthetic */ SendResponse forwardMessage$default(TelegramAware telegramAware, long j10, long j11, int i10, l modifier, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            modifier = AnonymousClass1.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(modifier, "modifier");
        ForwardMessage forwardMessage = new ForwardMessage(j10, j11, i10);
        modifier.invoke(forwardMessage);
        return (SendResponse) telegramAware.execute(forwardMessage);
    }

    public static final SendResponse forwardMessage(TelegramAware telegramAware, String channelUsername, long j10, int i10, l<? super ForwardMessage, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(modifier, "modifier");
        ForwardMessage forwardMessage = new ForwardMessage(channelUsername, j10, i10);
        modifier.invoke(forwardMessage);
        return (SendResponse) telegramAware.execute(forwardMessage);
    }

    public static final SendResponse forwardMessage(TelegramAware telegramAware, long j10, String fromChannelUsername, int i10, l<? super ForwardMessage, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(fromChannelUsername, "fromChannelUsername");
        m.f(modifier, "modifier");
        ForwardMessage forwardMessage = new ForwardMessage(j10, fromChannelUsername, i10);
        modifier.invoke(forwardMessage);
        return (SendResponse) telegramAware.execute(forwardMessage);
    }

    public static /* synthetic */ SendResponse forwardMessage$default(TelegramAware telegramAware, String channelUsername, long j10, int i10, l modifier, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            modifier = AnonymousClass2.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(modifier, "modifier");
        ForwardMessage forwardMessage = new ForwardMessage(channelUsername, j10, i10);
        modifier.invoke(forwardMessage);
        return (SendResponse) telegramAware.execute(forwardMessage);
    }

    public static final SendResponse forwardMessage(TelegramAware telegramAware, String channelUsername, String fromChannelUsername, int i10, l<? super ForwardMessage, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(fromChannelUsername, "fromChannelUsername");
        m.f(modifier, "modifier");
        ForwardMessage forwardMessage = new ForwardMessage(channelUsername, fromChannelUsername, i10);
        modifier.invoke(forwardMessage);
        return (SendResponse) telegramAware.execute(forwardMessage);
    }

    public static /* synthetic */ SendResponse forwardMessage$default(TelegramAware telegramAware, long j10, String fromChannelUsername, int i10, l modifier, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            modifier = AnonymousClass3.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(fromChannelUsername, "fromChannelUsername");
        m.f(modifier, "modifier");
        ForwardMessage forwardMessage = new ForwardMessage(j10, fromChannelUsername, i10);
        modifier.invoke(forwardMessage);
        return (SendResponse) telegramAware.execute(forwardMessage);
    }

    public static /* synthetic */ SendResponse forwardMessage$default(TelegramAware telegramAware, String channelUsername, String fromChannelUsername, int i10, l modifier, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            modifier = AnonymousClass4.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(fromChannelUsername, "fromChannelUsername");
        m.f(modifier, "modifier");
        ForwardMessage forwardMessage = new ForwardMessage(channelUsername, fromChannelUsername, i10);
        modifier.invoke(forwardMessage);
        return (SendResponse) telegramAware.execute(forwardMessage);
    }
}
