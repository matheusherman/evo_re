package com.pengrad.telegrambot.utility.kotlin.extension.request;

import c9.l;
import com.pengrad.telegrambot.TelegramAware;
import com.pengrad.telegrambot.request.GetChat;
import com.pengrad.telegrambot.response.GetChatResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a=\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a=\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000b2\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lcom/pengrad/telegrambot/TelegramAware;", "", "chatId", "Lkotlin/Function1;", "Lcom/pengrad/telegrambot/request/GetChat;", "Lr8/z;", "modifier", "Lcom/pengrad/telegrambot/response/GetChatResponse;", "kotlin.jvm.PlatformType", "getChat", "(Lcom/pengrad/telegrambot/TelegramAware;JLc9/l;)Lcom/pengrad/telegrambot/response/GetChatResponse;", "", "(Lcom/pengrad/telegrambot/TelegramAware;Ljava/lang/String;Lc9/l;)Lcom/pengrad/telegrambot/response/GetChatResponse;", "library"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class GetChatExtensionKt {

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.GetChatExtensionKt$getChat$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/GetChat;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/GetChat;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass1 extends o implements l<GetChat, z> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GetChat getChat) {
            m.f(getChat, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(GetChat getChat) {
            invoke2(getChat);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.GetChatExtensionKt$getChat$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/GetChat;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/GetChat;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass2 extends o implements l<GetChat, z> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GetChat getChat) {
            m.f(getChat, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(GetChat getChat) {
            invoke2(getChat);
            return z.f17874a;
        }
    }

    public static final GetChatResponse getChat(TelegramAware telegramAware, long j10, l<? super GetChat, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(modifier, "modifier");
        GetChat getChat = new GetChat(Long.valueOf(j10));
        modifier.invoke(getChat);
        return (GetChatResponse) telegramAware.execute(getChat);
    }

    public static /* synthetic */ GetChatResponse getChat$default(TelegramAware telegramAware, long j10, l modifier, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            modifier = AnonymousClass1.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(modifier, "modifier");
        GetChat getChat = new GetChat(Long.valueOf(j10));
        modifier.invoke(getChat);
        return (GetChatResponse) telegramAware.execute(getChat);
    }

    public static final GetChatResponse getChat(TelegramAware telegramAware, String chatId, l<? super GetChat, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(chatId, "chatId");
        m.f(modifier, "modifier");
        GetChat getChat = new GetChat(chatId);
        modifier.invoke(getChat);
        return (GetChatResponse) telegramAware.execute(getChat);
    }

    public static /* synthetic */ GetChatResponse getChat$default(TelegramAware telegramAware, String chatId, l modifier, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            modifier = AnonymousClass2.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(chatId, "chatId");
        m.f(modifier, "modifier");
        GetChat getChat = new GetChat(chatId);
        modifier.invoke(getChat);
        return (GetChatResponse) telegramAware.execute(getChat);
    }
}
