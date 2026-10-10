package com.pengrad.telegrambot.utility.kotlin.extension.request;

import c9.l;
import com.pengrad.telegrambot.TelegramAware;
import com.pengrad.telegrambot.model.request.InputMedia;
import com.pengrad.telegrambot.request.EditMessageMedia;
import com.pengrad.telegrambot.response.BaseResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u001aQ\u0010\r\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001aQ\u0010\r\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0011"}, d2 = {"Lcom/pengrad/telegrambot/TelegramAware;", "", "chatId", "", "messageId", "Lcom/pengrad/telegrambot/model/request/InputMedia;", "media", "Lkotlin/Function1;", "Lcom/pengrad/telegrambot/request/EditMessageMedia;", "Lr8/z;", "modifier", "Lcom/pengrad/telegrambot/response/BaseResponse;", "kotlin.jvm.PlatformType", "editMessageMedia", "(Lcom/pengrad/telegrambot/TelegramAware;JILcom/pengrad/telegrambot/model/request/InputMedia;Lc9/l;)Lcom/pengrad/telegrambot/response/BaseResponse;", "", "(Lcom/pengrad/telegrambot/TelegramAware;Ljava/lang/String;ILcom/pengrad/telegrambot/model/request/InputMedia;Lc9/l;)Lcom/pengrad/telegrambot/response/BaseResponse;", "library"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class EditMessageMediaExtensionKt {

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.EditMessageMediaExtensionKt$editMessageMedia$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/EditMessageMedia;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/EditMessageMedia;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass1 extends o implements l<EditMessageMedia, z> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EditMessageMedia editMessageMedia) {
            m.f(editMessageMedia, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(EditMessageMedia editMessageMedia) {
            invoke2(editMessageMedia);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.EditMessageMediaExtensionKt$editMessageMedia$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/EditMessageMedia;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/EditMessageMedia;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass2 extends o implements l<EditMessageMedia, z> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EditMessageMedia editMessageMedia) {
            m.f(editMessageMedia, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(EditMessageMedia editMessageMedia) {
            invoke2(editMessageMedia);
            return z.f17874a;
        }
    }

    public static final BaseResponse editMessageMedia(TelegramAware telegramAware, long j10, int i10, InputMedia<?> media, l<? super EditMessageMedia, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(media, "media");
        m.f(modifier, "modifier");
        EditMessageMedia editMessageMedia = new EditMessageMedia(Long.valueOf(j10), i10, media);
        modifier.invoke(editMessageMedia);
        return telegramAware.execute(editMessageMedia);
    }

    public static /* synthetic */ BaseResponse editMessageMedia$default(TelegramAware telegramAware, long j10, int i10, InputMedia media, l modifier, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            modifier = AnonymousClass1.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(media, "media");
        m.f(modifier, "modifier");
        EditMessageMedia editMessageMedia = new EditMessageMedia(Long.valueOf(j10), i10, media);
        modifier.invoke(editMessageMedia);
        return telegramAware.execute(editMessageMedia);
    }

    public static final BaseResponse editMessageMedia(TelegramAware telegramAware, String chatId, int i10, InputMedia<?> media, l<? super EditMessageMedia, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(chatId, "chatId");
        m.f(media, "media");
        m.f(modifier, "modifier");
        EditMessageMedia editMessageMedia = new EditMessageMedia(chatId, i10, media);
        modifier.invoke(editMessageMedia);
        return telegramAware.execute(editMessageMedia);
    }

    public static /* synthetic */ BaseResponse editMessageMedia$default(TelegramAware telegramAware, String chatId, int i10, InputMedia media, l modifier, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            modifier = AnonymousClass2.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(chatId, "chatId");
        m.f(media, "media");
        m.f(modifier, "modifier");
        EditMessageMedia editMessageMedia = new EditMessageMedia(chatId, i10, media);
        modifier.invoke(editMessageMedia);
        return telegramAware.execute(editMessageMedia);
    }
}
