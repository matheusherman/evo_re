package com.pengrad.telegrambot.utility.kotlin.extension.request;

import c9.l;
import com.pengrad.telegrambot.TelegramAware;
import com.pengrad.telegrambot.model.reaction.ReactionTypeEmoji;
import com.pengrad.telegrambot.request.SendDice;
import com.pengrad.telegrambot.response.SendResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001aA\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001aA\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\r\u001a5\u0010\u000e\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a5\u0010\u000e\u001a\u00020\t*\u00020\u00002\u0006\u0010\f\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0010\u001a5\u0010\u0011\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000f\u001a5\u0010\u0011\u001a\u00020\t*\u00020\u00002\u0006\u0010\f\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0010\u001a5\u0010\u0012\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u000f\u001a5\u0010\u0012\u001a\u00020\t*\u00020\u00002\u0006\u0010\f\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0010\u001a5\u0010\u0013\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u000f\u001a5\u0010\u0013\u001a\u00020\t*\u00020\u00002\u0006\u0010\f\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0010\u001a5\u0010\u0014\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u000f\u001a5\u0010\u0014\u001a\u00020\t*\u00020\u00002\u0006\u0010\f\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"Lcom/pengrad/telegrambot/TelegramAware;", "", "chatId", "", ReactionTypeEmoji.EMOJI_TYPE, "Lkotlin/Function1;", "Lcom/pengrad/telegrambot/request/SendDice;", "Lr8/z;", "modifier", "Lcom/pengrad/telegrambot/response/SendResponse;", "sendDice", "(Lcom/pengrad/telegrambot/TelegramAware;JLjava/lang/String;Lc9/l;)Lcom/pengrad/telegrambot/response/SendResponse;", "channelUsername", "(Lcom/pengrad/telegrambot/TelegramAware;Ljava/lang/String;Ljava/lang/String;Lc9/l;)Lcom/pengrad/telegrambot/response/SendResponse;", "sendDartsDice", "(Lcom/pengrad/telegrambot/TelegramAware;JLc9/l;)Lcom/pengrad/telegrambot/response/SendResponse;", "(Lcom/pengrad/telegrambot/TelegramAware;Ljava/lang/String;Lc9/l;)Lcom/pengrad/telegrambot/response/SendResponse;", "sendBasketballDice", "sendFootballDice", "sendBowlingDice", "sendSlotMachineDice", "library"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class SendDiceExtensionKt {

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendDiceExtensionKt$sendBasketballDice$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendDice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendDice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass1 extends o implements l<SendDice, z> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendDice sendDice) {
            m.f(sendDice, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendDice sendDice) {
            invoke2(sendDice);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendDiceExtensionKt$sendBasketballDice$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendDice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendDice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass3 extends o implements l<SendDice, z> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendDice sendDice) {
            m.f(sendDice, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendDice sendDice) {
            invoke2(sendDice);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendDiceExtensionKt$sendBowlingDice$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendDice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendDice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class C06861 extends o implements l<SendDice, z> {
        public static final C06861 INSTANCE = new C06861();

        public C06861() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendDice sendDice) {
            m.f(sendDice, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendDice sendDice) {
            invoke2(sendDice);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendDiceExtensionKt$sendBowlingDice$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendDice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendDice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class C06873 extends o implements l<SendDice, z> {
        public static final C06873 INSTANCE = new C06873();

        public C06873() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendDice sendDice) {
            m.f(sendDice, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendDice sendDice) {
            invoke2(sendDice);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendDiceExtensionKt$sendDartsDice$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendDice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendDice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class C06881 extends o implements l<SendDice, z> {
        public static final C06881 INSTANCE = new C06881();

        public C06881() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendDice sendDice) {
            m.f(sendDice, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendDice sendDice) {
            invoke2(sendDice);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendDiceExtensionKt$sendDartsDice$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendDice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendDice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class C06893 extends o implements l<SendDice, z> {
        public static final C06893 INSTANCE = new C06893();

        public C06893() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendDice sendDice) {
            m.f(sendDice, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendDice sendDice) {
            invoke2(sendDice);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendDiceExtensionKt$sendDice$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendDice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendDice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class C06901 extends o implements l<SendDice, z> {
        public static final C06901 INSTANCE = new C06901();

        public C06901() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendDice sendDice) {
            m.f(sendDice, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendDice sendDice) {
            invoke2(sendDice);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendDiceExtensionKt$sendDice$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendDice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendDice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class C06913 extends o implements l<SendDice, z> {
        public static final C06913 INSTANCE = new C06913();

        public C06913() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendDice sendDice) {
            m.f(sendDice, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendDice sendDice) {
            invoke2(sendDice);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendDiceExtensionKt$sendFootballDice$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendDice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendDice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class C06921 extends o implements l<SendDice, z> {
        public static final C06921 INSTANCE = new C06921();

        public C06921() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendDice sendDice) {
            m.f(sendDice, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendDice sendDice) {
            invoke2(sendDice);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendDiceExtensionKt$sendFootballDice$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendDice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendDice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class C06933 extends o implements l<SendDice, z> {
        public static final C06933 INSTANCE = new C06933();

        public C06933() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendDice sendDice) {
            m.f(sendDice, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendDice sendDice) {
            invoke2(sendDice);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendDiceExtensionKt$sendSlotMachineDice$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendDice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendDice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class C06941 extends o implements l<SendDice, z> {
        public static final C06941 INSTANCE = new C06941();

        public C06941() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendDice sendDice) {
            m.f(sendDice, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendDice sendDice) {
            invoke2(sendDice);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendDiceExtensionKt$sendSlotMachineDice$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendDice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendDice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class C06953 extends o implements l<SendDice, z> {
        public static final C06953 INSTANCE = new C06953();

        public C06953() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendDice sendDice) {
            m.f(sendDice, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendDice sendDice) {
            invoke2(sendDice);
            return z.f17874a;
        }
    }

    public static final SendResponse sendBasketballDice(TelegramAware telegramAware, long j10, l<? super SendDice, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(modifier, "modifier");
        SendDice sendDice = new SendDice(j10);
        sendDice.setEmoji(SendDice.BASKETBALL_EMOJI);
        modifier.invoke(sendDice);
        return (SendResponse) telegramAware.execute(sendDice);
    }

    public static /* synthetic */ SendResponse sendBasketballDice$default(TelegramAware telegramAware, long j10, l modifier, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            modifier = AnonymousClass1.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(modifier, "modifier");
        SendDice sendDice = new SendDice(j10);
        sendDice.setEmoji(SendDice.BASKETBALL_EMOJI);
        modifier.invoke(sendDice);
        return (SendResponse) telegramAware.execute(sendDice);
    }

    public static final SendResponse sendBowlingDice(TelegramAware telegramAware, long j10, l<? super SendDice, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(modifier, "modifier");
        SendDice sendDice = new SendDice(j10);
        sendDice.setEmoji(SendDice.BOWLING_EMOJI);
        modifier.invoke(sendDice);
        return (SendResponse) telegramAware.execute(sendDice);
    }

    public static /* synthetic */ SendResponse sendBowlingDice$default(TelegramAware telegramAware, long j10, l modifier, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            modifier = C06861.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(modifier, "modifier");
        SendDice sendDice = new SendDice(j10);
        sendDice.setEmoji(SendDice.BOWLING_EMOJI);
        modifier.invoke(sendDice);
        return (SendResponse) telegramAware.execute(sendDice);
    }

    public static final SendResponse sendDartsDice(TelegramAware telegramAware, long j10, l<? super SendDice, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(modifier, "modifier");
        SendDice sendDice = new SendDice(j10);
        sendDice.setEmoji(SendDice.DARTS_EMOJI);
        modifier.invoke(sendDice);
        return (SendResponse) telegramAware.execute(sendDice);
    }

    public static /* synthetic */ SendResponse sendDartsDice$default(TelegramAware telegramAware, long j10, l modifier, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            modifier = C06881.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(modifier, "modifier");
        SendDice sendDice = new SendDice(j10);
        sendDice.setEmoji(SendDice.DARTS_EMOJI);
        modifier.invoke(sendDice);
        return (SendResponse) telegramAware.execute(sendDice);
    }

    public static final SendResponse sendDice(TelegramAware telegramAware, long j10, String str, l<? super SendDice, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(modifier, "modifier");
        SendDice sendDice = new SendDice(j10);
        sendDice.setEmoji(str);
        modifier.invoke(sendDice);
        return (SendResponse) telegramAware.execute(sendDice);
    }

    public static /* synthetic */ SendResponse sendDice$default(TelegramAware telegramAware, long j10, String str, l modifier, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            modifier = C06901.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(modifier, "modifier");
        SendDice sendDice = new SendDice(j10);
        sendDice.setEmoji(str);
        modifier.invoke(sendDice);
        return (SendResponse) telegramAware.execute(sendDice);
    }

    public static final SendResponse sendFootballDice(TelegramAware telegramAware, long j10, l<? super SendDice, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(modifier, "modifier");
        SendDice sendDice = new SendDice(j10);
        sendDice.setEmoji(SendDice.FOOTBALL_EMOJI);
        modifier.invoke(sendDice);
        return (SendResponse) telegramAware.execute(sendDice);
    }

    public static /* synthetic */ SendResponse sendFootballDice$default(TelegramAware telegramAware, long j10, l modifier, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            modifier = C06921.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(modifier, "modifier");
        SendDice sendDice = new SendDice(j10);
        sendDice.setEmoji(SendDice.FOOTBALL_EMOJI);
        modifier.invoke(sendDice);
        return (SendResponse) telegramAware.execute(sendDice);
    }

    public static final SendResponse sendSlotMachineDice(TelegramAware telegramAware, long j10, l<? super SendDice, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(modifier, "modifier");
        SendDice sendDice = new SendDice(j10);
        sendDice.setEmoji(SendDice.SLOT_MACHINE_EMOJI);
        modifier.invoke(sendDice);
        return (SendResponse) telegramAware.execute(sendDice);
    }

    public static /* synthetic */ SendResponse sendSlotMachineDice$default(TelegramAware telegramAware, long j10, l modifier, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            modifier = C06941.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(modifier, "modifier");
        SendDice sendDice = new SendDice(j10);
        sendDice.setEmoji(SendDice.SLOT_MACHINE_EMOJI);
        modifier.invoke(sendDice);
        return (SendResponse) telegramAware.execute(sendDice);
    }

    public static final SendResponse sendBasketballDice(TelegramAware telegramAware, String channelUsername, l<? super SendDice, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(modifier, "modifier");
        SendDice sendDice = new SendDice(channelUsername);
        sendDice.setEmoji(SendDice.BASKETBALL_EMOJI);
        modifier.invoke(sendDice);
        return (SendResponse) telegramAware.execute(sendDice);
    }

    public static final SendResponse sendBowlingDice(TelegramAware telegramAware, String channelUsername, l<? super SendDice, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(modifier, "modifier");
        SendDice sendDice = new SendDice(channelUsername);
        sendDice.setEmoji(SendDice.BOWLING_EMOJI);
        modifier.invoke(sendDice);
        return (SendResponse) telegramAware.execute(sendDice);
    }

    public static final SendResponse sendDartsDice(TelegramAware telegramAware, String channelUsername, l<? super SendDice, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(modifier, "modifier");
        SendDice sendDice = new SendDice(channelUsername);
        sendDice.setEmoji(SendDice.DARTS_EMOJI);
        modifier.invoke(sendDice);
        return (SendResponse) telegramAware.execute(sendDice);
    }

    public static final SendResponse sendDice(TelegramAware telegramAware, String channelUsername, String str, l<? super SendDice, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(modifier, "modifier");
        SendDice sendDice = new SendDice(channelUsername);
        sendDice.setEmoji(str);
        modifier.invoke(sendDice);
        return (SendResponse) telegramAware.execute(sendDice);
    }

    public static final SendResponse sendFootballDice(TelegramAware telegramAware, String channelUsername, l<? super SendDice, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(modifier, "modifier");
        SendDice sendDice = new SendDice(channelUsername);
        sendDice.setEmoji(SendDice.FOOTBALL_EMOJI);
        modifier.invoke(sendDice);
        return (SendResponse) telegramAware.execute(sendDice);
    }

    public static final SendResponse sendSlotMachineDice(TelegramAware telegramAware, String channelUsername, l<? super SendDice, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(modifier, "modifier");
        SendDice sendDice = new SendDice(channelUsername);
        sendDice.setEmoji(SendDice.SLOT_MACHINE_EMOJI);
        modifier.invoke(sendDice);
        return (SendResponse) telegramAware.execute(sendDice);
    }

    public static /* synthetic */ SendResponse sendBasketballDice$default(TelegramAware telegramAware, String channelUsername, l modifier, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            modifier = AnonymousClass3.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(modifier, "modifier");
        SendDice sendDice = new SendDice(channelUsername);
        sendDice.setEmoji(SendDice.BASKETBALL_EMOJI);
        modifier.invoke(sendDice);
        return (SendResponse) telegramAware.execute(sendDice);
    }

    public static /* synthetic */ SendResponse sendBowlingDice$default(TelegramAware telegramAware, String channelUsername, l modifier, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            modifier = C06873.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(modifier, "modifier");
        SendDice sendDice = new SendDice(channelUsername);
        sendDice.setEmoji(SendDice.BOWLING_EMOJI);
        modifier.invoke(sendDice);
        return (SendResponse) telegramAware.execute(sendDice);
    }

    public static /* synthetic */ SendResponse sendDartsDice$default(TelegramAware telegramAware, String channelUsername, l modifier, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            modifier = C06893.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(modifier, "modifier");
        SendDice sendDice = new SendDice(channelUsername);
        sendDice.setEmoji(SendDice.DARTS_EMOJI);
        modifier.invoke(sendDice);
        return (SendResponse) telegramAware.execute(sendDice);
    }

    public static /* synthetic */ SendResponse sendDice$default(TelegramAware telegramAware, String channelUsername, String str, l modifier, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            modifier = C06913.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(modifier, "modifier");
        SendDice sendDice = new SendDice(channelUsername);
        sendDice.setEmoji(str);
        modifier.invoke(sendDice);
        return (SendResponse) telegramAware.execute(sendDice);
    }

    public static /* synthetic */ SendResponse sendFootballDice$default(TelegramAware telegramAware, String channelUsername, l modifier, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            modifier = C06933.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(modifier, "modifier");
        SendDice sendDice = new SendDice(channelUsername);
        sendDice.setEmoji(SendDice.FOOTBALL_EMOJI);
        modifier.invoke(sendDice);
        return (SendResponse) telegramAware.execute(sendDice);
    }

    public static /* synthetic */ SendResponse sendSlotMachineDice$default(TelegramAware telegramAware, String channelUsername, l modifier, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            modifier = C06953.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(modifier, "modifier");
        SendDice sendDice = new SendDice(channelUsername);
        sendDice.setEmoji(SendDice.SLOT_MACHINE_EMOJI);
        modifier.invoke(sendDice);
        return (SendResponse) telegramAware.execute(sendDice);
    }
}
