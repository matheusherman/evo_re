package com.pengrad.telegrambot.utility.kotlin.extension.request;

import c9.l;
import com.pengrad.telegrambot.TelegramAware;
import com.pengrad.telegrambot.request.RemoveChatVerification;
import com.pengrad.telegrambot.response.BaseResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a5\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a5\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lcom/pengrad/telegrambot/TelegramAware;", "", "chatId", "Lkotlin/Function1;", "Lcom/pengrad/telegrambot/request/RemoveChatVerification;", "Lr8/z;", "modifier", "Lcom/pengrad/telegrambot/response/BaseResponse;", "removeChatVerification", "(Lcom/pengrad/telegrambot/TelegramAware;JLc9/l;)Lcom/pengrad/telegrambot/response/BaseResponse;", "", "channelUsername", "(Lcom/pengrad/telegrambot/TelegramAware;Ljava/lang/String;Lc9/l;)Lcom/pengrad/telegrambot/response/BaseResponse;", "library"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class RemoveChatVerificationExtensionKt {

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.RemoveChatVerificationExtensionKt$removeChatVerification$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/RemoveChatVerification;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/RemoveChatVerification;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass1 extends o implements l<RemoveChatVerification, z> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RemoveChatVerification removeChatVerification) {
            m.f(removeChatVerification, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(RemoveChatVerification removeChatVerification) {
            invoke2(removeChatVerification);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.RemoveChatVerificationExtensionKt$removeChatVerification$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/RemoveChatVerification;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/RemoveChatVerification;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass2 extends o implements l<RemoveChatVerification, z> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RemoveChatVerification removeChatVerification) {
            m.f(removeChatVerification, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(RemoveChatVerification removeChatVerification) {
            invoke2(removeChatVerification);
            return z.f17874a;
        }
    }

    public static final BaseResponse removeChatVerification(TelegramAware telegramAware, long j10, l<? super RemoveChatVerification, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(modifier, "modifier");
        RemoveChatVerification removeChatVerification = new RemoveChatVerification(j10);
        modifier.invoke(removeChatVerification);
        return telegramAware.execute(removeChatVerification);
    }

    public static /* synthetic */ BaseResponse removeChatVerification$default(TelegramAware telegramAware, long j10, l modifier, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            modifier = AnonymousClass1.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(modifier, "modifier");
        RemoveChatVerification removeChatVerification = new RemoveChatVerification(j10);
        modifier.invoke(removeChatVerification);
        return telegramAware.execute(removeChatVerification);
    }

    public static final BaseResponse removeChatVerification(TelegramAware telegramAware, String channelUsername, l<? super RemoveChatVerification, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(modifier, "modifier");
        RemoveChatVerification removeChatVerification = new RemoveChatVerification(channelUsername);
        modifier.invoke(removeChatVerification);
        return telegramAware.execute(removeChatVerification);
    }

    public static /* synthetic */ BaseResponse removeChatVerification$default(TelegramAware telegramAware, String channelUsername, l modifier, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            modifier = AnonymousClass2.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(modifier, "modifier");
        RemoveChatVerification removeChatVerification = new RemoveChatVerification(channelUsername);
        modifier.invoke(removeChatVerification);
        return telegramAware.execute(removeChatVerification);
    }
}
