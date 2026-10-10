package com.pengrad.telegrambot.utility.kotlin.extension.request;

import c9.l;
import com.pengrad.telegrambot.TelegramAware;
import com.pengrad.telegrambot.model.request.LabeledPrice;
import com.pengrad.telegrambot.request.SendInvoice;
import com.pengrad.telegrambot.response.SendResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.j;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a]\u0010\u0010\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u0010\u0010\u0011\u001ac\u0010\u0010\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0012\"\u00020\t2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u0010\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/pengrad/telegrambot/TelegramAware;", "", "chatId", "", "title", "description", "payload", "currency", "", "Lcom/pengrad/telegrambot/model/request/LabeledPrice;", "items", "Lkotlin/Function1;", "Lcom/pengrad/telegrambot/request/SendInvoice;", "Lr8/z;", "modifier", "Lcom/pengrad/telegrambot/response/SendResponse;", "sendInvoice", "(Lcom/pengrad/telegrambot/TelegramAware;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lc9/l;)Lcom/pengrad/telegrambot/response/SendResponse;", "", "(Lcom/pengrad/telegrambot/TelegramAware;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Lcom/pengrad/telegrambot/model/request/LabeledPrice;Lc9/l;)Lcom/pengrad/telegrambot/response/SendResponse;", "library"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class SendInvoiceExtensionKt {

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendInvoiceExtensionKt$sendInvoice$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendInvoice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendInvoice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass1 extends o implements l<SendInvoice, z> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendInvoice sendInvoice) {
            m.f(sendInvoice, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendInvoice sendInvoice) {
            invoke2(sendInvoice);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendInvoiceExtensionKt$sendInvoice$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendInvoice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendInvoice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass2 extends o implements l<SendInvoice, z> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendInvoice sendInvoice) {
            m.f(sendInvoice, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendInvoice sendInvoice) {
            invoke2(sendInvoice);
            return z.f17874a;
        }
    }

    public static final SendResponse sendInvoice(TelegramAware telegramAware, long j10, String title, String description, String payload, String currency, List<? extends LabeledPrice> items, l<? super SendInvoice, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(title, "title");
        m.f(description, "description");
        m.f(payload, "payload");
        m.f(currency, "currency");
        m.f(items, "items");
        m.f(modifier, "modifier");
        SendInvoice sendInvoice = new SendInvoice(j10, title, description, payload, currency, items);
        modifier.invoke(sendInvoice);
        return (SendResponse) telegramAware.execute(sendInvoice);
    }

    public static final SendResponse sendInvoice(TelegramAware telegramAware, long j10, String title, String description, String payload, String currency, LabeledPrice[] items, l<? super SendInvoice, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(title, "title");
        m.f(description, "description");
        m.f(payload, "payload");
        m.f(currency, "currency");
        m.f(items, "items");
        m.f(modifier, "modifier");
        return sendInvoice(telegramAware, j10, title, description, payload, currency, (List<? extends LabeledPrice>) j.E0(items), modifier);
    }
}
