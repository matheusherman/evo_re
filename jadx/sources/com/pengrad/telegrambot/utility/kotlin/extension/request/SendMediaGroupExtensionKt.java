package com.pengrad.telegrambot.utility.kotlin.extension.request;

import c9.l;
import com.pengrad.telegrambot.TelegramAware;
import com.pengrad.telegrambot.model.request.InputMedia;
import com.pengrad.telegrambot.request.SendMediaGroup;
import com.pengrad.telegrambot.response.MessagesResponse;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u001aO\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00032\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001aO\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000e2\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00032\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"Lcom/pengrad/telegrambot/TelegramAware;", "", "chatId", "", "Lcom/pengrad/telegrambot/model/request/InputMedia;", "media", "Lkotlin/Function1;", "Lcom/pengrad/telegrambot/request/SendMediaGroup;", "Lr8/z;", "modifier", "Lcom/pengrad/telegrambot/response/MessagesResponse;", "kotlin.jvm.PlatformType", "sendMediaGroup", "(Lcom/pengrad/telegrambot/TelegramAware;JLjava/util/List;Lc9/l;)Lcom/pengrad/telegrambot/response/MessagesResponse;", "", "(Lcom/pengrad/telegrambot/TelegramAware;Ljava/lang/String;Ljava/util/List;Lc9/l;)Lcom/pengrad/telegrambot/response/MessagesResponse;", "library"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class SendMediaGroupExtensionKt {

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendMediaGroupExtensionKt$sendMediaGroup$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendMediaGroup;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendMediaGroup;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass1 extends o implements l<SendMediaGroup, z> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendMediaGroup sendMediaGroup) {
            m.f(sendMediaGroup, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendMediaGroup sendMediaGroup) {
            invoke2(sendMediaGroup);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendMediaGroupExtensionKt$sendMediaGroup$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendMediaGroup;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendMediaGroup;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass2 extends o implements l<SendMediaGroup, z> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendMediaGroup sendMediaGroup) {
            m.f(sendMediaGroup, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendMediaGroup sendMediaGroup) {
            invoke2(sendMediaGroup);
            return z.f17874a;
        }
    }

    public static final MessagesResponse sendMediaGroup(TelegramAware telegramAware, long j10, List<? extends InputMedia<?>> media, l<? super SendMediaGroup, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(media, "media");
        m.f(modifier, "modifier");
        Long lValueOf = Long.valueOf(j10);
        InputMedia[] inputMediaArr = (InputMedia[]) media.toArray(new InputMedia[0]);
        SendMediaGroup sendMediaGroup = new SendMediaGroup(lValueOf, (InputMedia[]) Arrays.copyOf(inputMediaArr, inputMediaArr.length));
        modifier.invoke(sendMediaGroup);
        return (MessagesResponse) telegramAware.execute(sendMediaGroup);
    }

    public static /* synthetic */ MessagesResponse sendMediaGroup$default(TelegramAware telegramAware, long j10, List media, l modifier, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            modifier = AnonymousClass1.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(media, "media");
        m.f(modifier, "modifier");
        Long lValueOf = Long.valueOf(j10);
        InputMedia[] inputMediaArr = (InputMedia[]) media.toArray(new InputMedia[0]);
        SendMediaGroup sendMediaGroup = new SendMediaGroup(lValueOf, (InputMedia[]) Arrays.copyOf(inputMediaArr, inputMediaArr.length));
        modifier.invoke(sendMediaGroup);
        return (MessagesResponse) telegramAware.execute(sendMediaGroup);
    }

    public static final MessagesResponse sendMediaGroup(TelegramAware telegramAware, String chatId, List<? extends InputMedia<?>> media, l<? super SendMediaGroup, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(chatId, "chatId");
        m.f(media, "media");
        m.f(modifier, "modifier");
        InputMedia[] inputMediaArr = (InputMedia[]) media.toArray(new InputMedia[0]);
        SendMediaGroup sendMediaGroup = new SendMediaGroup(chatId, (InputMedia[]) Arrays.copyOf(inputMediaArr, inputMediaArr.length));
        modifier.invoke(sendMediaGroup);
        return (MessagesResponse) telegramAware.execute(sendMediaGroup);
    }

    public static /* synthetic */ MessagesResponse sendMediaGroup$default(TelegramAware telegramAware, String chatId, List media, l modifier, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            modifier = AnonymousClass2.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(chatId, "chatId");
        m.f(media, "media");
        m.f(modifier, "modifier");
        InputMedia[] inputMediaArr = (InputMedia[]) media.toArray(new InputMedia[0]);
        SendMediaGroup sendMediaGroup = new SendMediaGroup(chatId, (InputMedia[]) Arrays.copyOf(inputMediaArr, inputMediaArr.length));
        modifier.invoke(sendMediaGroup);
        return (MessagesResponse) telegramAware.execute(sendMediaGroup);
    }
}
