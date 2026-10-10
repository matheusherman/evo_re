package com.pengrad.telegrambot.utility.kotlin.extension.request;

import c9.l;
import com.pengrad.telegrambot.TelegramAware;
import com.pengrad.telegrambot.request.EditMessageText;
import com.pengrad.telegrambot.response.BaseResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aG\u0010\r\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\r\u0010\u000e\u001aG\u0010\r\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\r\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/pengrad/telegrambot/TelegramAware;", "", "chatId", "", "messageId", "", "text", "Lkotlin/Function1;", "Lcom/pengrad/telegrambot/request/EditMessageText;", "Lr8/z;", "modifier", "Lcom/pengrad/telegrambot/response/BaseResponse;", "kotlin.jvm.PlatformType", "editMessageText", "(Lcom/pengrad/telegrambot/TelegramAware;JILjava/lang/String;Lc9/l;)Lcom/pengrad/telegrambot/response/BaseResponse;", "(Lcom/pengrad/telegrambot/TelegramAware;Ljava/lang/String;ILjava/lang/String;Lc9/l;)Lcom/pengrad/telegrambot/response/BaseResponse;", "library"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class EditMessageTextExtensionKt {

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.EditMessageTextExtensionKt$editMessageText$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/EditMessageText;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/EditMessageText;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass1 extends o implements l<EditMessageText, z> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EditMessageText editMessageText) {
            m.f(editMessageText, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(EditMessageText editMessageText) {
            invoke2(editMessageText);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.EditMessageTextExtensionKt$editMessageText$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/EditMessageText;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/EditMessageText;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass2 extends o implements l<EditMessageText, z> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EditMessageText editMessageText) {
            m.f(editMessageText, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(EditMessageText editMessageText) {
            invoke2(editMessageText);
            return z.f17874a;
        }
    }

    public static final BaseResponse editMessageText(TelegramAware telegramAware, long j10, int i10, String text, l<? super EditMessageText, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(text, "text");
        m.f(modifier, "modifier");
        EditMessageText editMessageText = new EditMessageText(Long.valueOf(j10), i10, text);
        modifier.invoke(editMessageText);
        return telegramAware.execute(editMessageText);
    }

    public static /* synthetic */ BaseResponse editMessageText$default(TelegramAware telegramAware, long j10, int i10, String str, l lVar, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            lVar = AnonymousClass1.INSTANCE;
        }
        return editMessageText(telegramAware, j10, i10, str, (l<? super EditMessageText, z>) lVar);
    }

    public static final BaseResponse editMessageText(TelegramAware telegramAware, String chatId, int i10, String text, l<? super EditMessageText, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(chatId, "chatId");
        m.f(text, "text");
        m.f(modifier, "modifier");
        EditMessageText editMessageText = new EditMessageText(chatId, i10, text);
        modifier.invoke(editMessageText);
        return telegramAware.execute(editMessageText);
    }

    public static /* synthetic */ BaseResponse editMessageText$default(TelegramAware telegramAware, String str, int i10, String str2, l lVar, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            lVar = AnonymousClass2.INSTANCE;
        }
        return editMessageText(telegramAware, str, i10, str2, (l<? super EditMessageText, z>) lVar);
    }
}
