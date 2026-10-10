package com.pengrad.telegrambot.utility.kotlin.extension.request;

import c9.l;
import com.pengrad.telegrambot.TelegramAware;
import com.pengrad.telegrambot.request.SendContact;
import com.pengrad.telegrambot.response.SendResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aQ\u0010\f\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001aQ\u0010\f\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"Lcom/pengrad/telegrambot/TelegramAware;", "", "chatId", "", "phoneNumber", "firstName", "lastName", "Lkotlin/Function1;", "Lcom/pengrad/telegrambot/request/SendContact;", "Lr8/z;", "modifier", "Lcom/pengrad/telegrambot/response/SendResponse;", "sendContact", "(Lcom/pengrad/telegrambot/TelegramAware;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lc9/l;)Lcom/pengrad/telegrambot/response/SendResponse;", "channelUsername", "(Lcom/pengrad/telegrambot/TelegramAware;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lc9/l;)Lcom/pengrad/telegrambot/response/SendResponse;", "library"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class SendContactExtensionKt {

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendContactExtensionKt$sendContact$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendContact;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendContact;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass1 extends o implements l<SendContact, z> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendContact sendContact) {
            m.f(sendContact, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendContact sendContact) {
            invoke2(sendContact);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendContactExtensionKt$sendContact$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendContact;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendContact;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass3 extends o implements l<SendContact, z> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendContact sendContact) {
            m.f(sendContact, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendContact sendContact) {
            invoke2(sendContact);
            return z.f17874a;
        }
    }

    public static final SendResponse sendContact(TelegramAware telegramAware, long j10, String phoneNumber, String firstName, String str, l<? super SendContact, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(phoneNumber, "phoneNumber");
        m.f(firstName, "firstName");
        m.f(modifier, "modifier");
        SendContact sendContact = new SendContact(j10, phoneNumber, firstName);
        sendContact.setLastName(str);
        modifier.invoke(sendContact);
        return (SendResponse) telegramAware.execute(sendContact);
    }

    public static /* synthetic */ SendResponse sendContact$default(TelegramAware telegramAware, long j10, String phoneNumber, String firstName, String str, l modifier, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str = null;
        }
        if ((i10 & 16) != 0) {
            modifier = AnonymousClass1.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(phoneNumber, "phoneNumber");
        m.f(firstName, "firstName");
        m.f(modifier, "modifier");
        SendContact sendContact = new SendContact(j10, phoneNumber, firstName);
        sendContact.setLastName(str);
        modifier.invoke(sendContact);
        return (SendResponse) telegramAware.execute(sendContact);
    }

    public static final SendResponse sendContact(TelegramAware telegramAware, String channelUsername, String phoneNumber, String firstName, String str, l<? super SendContact, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(phoneNumber, "phoneNumber");
        m.f(firstName, "firstName");
        m.f(modifier, "modifier");
        SendContact sendContact = new SendContact(channelUsername, phoneNumber, firstName);
        sendContact.setLastName(str);
        modifier.invoke(sendContact);
        return (SendResponse) telegramAware.execute(sendContact);
    }

    public static /* synthetic */ SendResponse sendContact$default(TelegramAware telegramAware, String channelUsername, String phoneNumber, String firstName, String str, l modifier, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str = null;
        }
        if ((i10 & 16) != 0) {
            modifier = AnonymousClass3.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(phoneNumber, "phoneNumber");
        m.f(firstName, "firstName");
        m.f(modifier, "modifier");
        SendContact sendContact = new SendContact(channelUsername, phoneNumber, firstName);
        sendContact.setLastName(str);
        modifier.invoke(sendContact);
        return (SendResponse) telegramAware.execute(sendContact);
    }
}
