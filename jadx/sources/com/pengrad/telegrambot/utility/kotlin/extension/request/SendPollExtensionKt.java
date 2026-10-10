package com.pengrad.telegrambot.utility.kotlin.extension.request;

import c9.l;
import com.pengrad.telegrambot.TelegramAware;
import com.pengrad.telegrambot.model.request.InputPollOption;
import com.pengrad.telegrambot.request.SendPoll;
import com.pengrad.telegrambot.response.SendResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.j;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\u001aK\u0010\r\u001a\u00020\f*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001aQ\u0010\r\u001a\u00020\f*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000f\"\u00020\u00062\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0010\u001aK\u0010\r\u001a\u00020\f*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0012\u001aQ\u0010\r\u001a\u00020\f*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000f\"\u00020\u00062\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014"}, d2 = {"Lcom/pengrad/telegrambot/TelegramAware;", "", "chatId", "", "question", "", "Lcom/pengrad/telegrambot/model/request/InputPollOption;", "options", "Lkotlin/Function1;", "Lcom/pengrad/telegrambot/request/SendPoll;", "Lr8/z;", "modifier", "Lcom/pengrad/telegrambot/response/SendResponse;", "sendPoll", "(Lcom/pengrad/telegrambot/TelegramAware;JLjava/lang/String;Ljava/util/List;Lc9/l;)Lcom/pengrad/telegrambot/response/SendResponse;", "", "(Lcom/pengrad/telegrambot/TelegramAware;JLjava/lang/String;[Lcom/pengrad/telegrambot/model/request/InputPollOption;Lc9/l;)Lcom/pengrad/telegrambot/response/SendResponse;", "channelUsername", "(Lcom/pengrad/telegrambot/TelegramAware;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lc9/l;)Lcom/pengrad/telegrambot/response/SendResponse;", "(Lcom/pengrad/telegrambot/TelegramAware;Ljava/lang/String;Ljava/lang/String;[Lcom/pengrad/telegrambot/model/request/InputPollOption;Lc9/l;)Lcom/pengrad/telegrambot/response/SendResponse;", "library"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class SendPollExtensionKt {

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendPollExtensionKt$sendPoll$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendPoll;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendPoll;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass1 extends o implements l<SendPoll, z> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendPoll sendPoll) {
            m.f(sendPoll, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendPoll sendPoll) {
            invoke2(sendPoll);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendPollExtensionKt$sendPoll$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendPoll;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendPoll;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass2 extends o implements l<SendPoll, z> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendPoll sendPoll) {
            m.f(sendPoll, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendPoll sendPoll) {
            invoke2(sendPoll);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendPollExtensionKt$sendPoll$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendPoll;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendPoll;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass3 extends o implements l<SendPoll, z> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendPoll sendPoll) {
            m.f(sendPoll, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendPoll sendPoll) {
            invoke2(sendPoll);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendPollExtensionKt$sendPoll$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendPoll;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendPoll;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass4 extends o implements l<SendPoll, z> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendPoll sendPoll) {
            m.f(sendPoll, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendPoll sendPoll) {
            invoke2(sendPoll);
            return z.f17874a;
        }
    }

    public static final SendResponse sendPoll(TelegramAware telegramAware, long j10, String question, List<? extends InputPollOption> options, l<? super SendPoll, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(question, "question");
        m.f(options, "options");
        m.f(modifier, "modifier");
        SendPoll sendPoll = new SendPoll(j10, question, options);
        modifier.invoke(sendPoll);
        return (SendResponse) telegramAware.execute(sendPoll);
    }

    public static /* synthetic */ SendResponse sendPoll$default(TelegramAware telegramAware, long j10, String question, List options, l modifier, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            modifier = AnonymousClass1.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(question, "question");
        m.f(options, "options");
        m.f(modifier, "modifier");
        SendPoll sendPoll = new SendPoll(j10, question, (List<? extends InputPollOption>) options);
        modifier.invoke(sendPoll);
        return (SendResponse) telegramAware.execute(sendPoll);
    }

    public static final SendResponse sendPoll(TelegramAware telegramAware, long j10, String question, InputPollOption[] options, l<? super SendPoll, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(question, "question");
        m.f(options, "options");
        m.f(modifier, "modifier");
        SendPoll sendPoll = new SendPoll(j10, question, (List<? extends InputPollOption>) j.E0(options));
        modifier.invoke(sendPoll);
        return (SendResponse) telegramAware.execute(sendPoll);
    }

    public static /* synthetic */ SendResponse sendPoll$default(TelegramAware telegramAware, long j10, String question, InputPollOption[] options, l modifier, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            modifier = AnonymousClass2.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(question, "question");
        m.f(options, "options");
        m.f(modifier, "modifier");
        SendPoll sendPoll = new SendPoll(j10, question, (List<? extends InputPollOption>) j.E0(options));
        modifier.invoke(sendPoll);
        return (SendResponse) telegramAware.execute(sendPoll);
    }

    public static final SendResponse sendPoll(TelegramAware telegramAware, String channelUsername, String question, List<? extends InputPollOption> options, l<? super SendPoll, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(question, "question");
        m.f(options, "options");
        m.f(modifier, "modifier");
        SendPoll sendPoll = new SendPoll(channelUsername, question, options);
        modifier.invoke(sendPoll);
        return (SendResponse) telegramAware.execute(sendPoll);
    }

    public static final SendResponse sendPoll(TelegramAware telegramAware, String channelUsername, String question, InputPollOption[] options, l<? super SendPoll, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(question, "question");
        m.f(options, "options");
        m.f(modifier, "modifier");
        SendPoll sendPoll = new SendPoll(channelUsername, question, (List<? extends InputPollOption>) j.E0(options));
        modifier.invoke(sendPoll);
        return (SendResponse) telegramAware.execute(sendPoll);
    }

    public static /* synthetic */ SendResponse sendPoll$default(TelegramAware telegramAware, String channelUsername, String question, List options, l modifier, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            modifier = AnonymousClass3.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(question, "question");
        m.f(options, "options");
        m.f(modifier, "modifier");
        SendPoll sendPoll = new SendPoll(channelUsername, question, (List<? extends InputPollOption>) options);
        modifier.invoke(sendPoll);
        return (SendResponse) telegramAware.execute(sendPoll);
    }

    public static /* synthetic */ SendResponse sendPoll$default(TelegramAware telegramAware, String channelUsername, String question, InputPollOption[] options, l modifier, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            modifier = AnonymousClass4.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(question, "question");
        m.f(options, "options");
        m.f(modifier, "modifier");
        SendPoll sendPoll = new SendPoll(channelUsername, question, (List<? extends InputPollOption>) j.E0(options));
        modifier.invoke(sendPoll);
        return (SendResponse) telegramAware.execute(sendPoll);
    }
}
