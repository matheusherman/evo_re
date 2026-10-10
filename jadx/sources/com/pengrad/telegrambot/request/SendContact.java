package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegate;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegateKt;
import i9.k;
import kotlin.Metadata;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.w;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0013\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\tB\u001f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\n\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bB/\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0005R\u001b\u0010\u0006\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR/\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0017\u0010\u000eR/\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/pengrad/telegrambot/request/SendContact;", "Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "chatId", "", "phoneNumber", "", "firstName", "(JLjava/lang/String;Ljava/lang/String;)V", "channelUsername", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFirstName", "()Ljava/lang/String;", "firstName$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "<set-?>", "lastName", "getLastName", "setLastName", "(Ljava/lang/String;)V", "lastName$delegate", "getPhoneNumber", "phoneNumber$delegate", "vcard", "getVcard", "setVcard", "vcard$delegate", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SendContact extends AbstractSendRequest<SendContact> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(SendContact.class, "phoneNumber", "getPhoneNumber()Ljava/lang/String;", 0)), c0.g(new w(SendContact.class, "firstName", "getFirstName()Ljava/lang/String;", 0)), c0.e(new q(SendContact.class, "lastName", "getLastName()Ljava/lang/String;", 0)), c0.e(new q(SendContact.class, "vcard", "getVcard()Ljava/lang/String;", 0))};

    /* JADX INFO: renamed from: firstName$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate firstName;

    /* JADX INFO: renamed from: lastName$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate lastName;

    /* JADX INFO: renamed from: phoneNumber$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate phoneNumber;

    /* JADX INFO: renamed from: vcard$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate vcard;

    /* synthetic */ SendContact(Long l10, String str, String str2, String str3, int i10, g gVar) {
        this((i10 & 1) != 0 ? null : l10, (i10 & 2) != 0 ? null : str, str2, str3);
    }

    private SendContact(Long l10, String str, String str2, String str3) {
        super(l10, str);
        RequestParameterDelegate requestParameterDelegateRequestParameter$default = RequestParameterDelegateKt.requestParameter$default(str2, null, 2, null);
        k<?>[] kVarArr = $$delegatedProperties;
        this.phoneNumber = requestParameterDelegateRequestParameter$default.provideDelegate(this, kVarArr[0]);
        this.firstName = RequestParameterDelegateKt.requestParameter$default(str3, null, 2, null).provideDelegate(this, kVarArr[1]);
        this.lastName = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[2]);
        this.vcard = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[3]);
    }

    public final String getFirstName() {
        return (String) this.firstName.getValue(this, $$delegatedProperties[1]);
    }

    public final String getLastName() {
        return (String) this.lastName.getValue(this, $$delegatedProperties[2]);
    }

    public final String getPhoneNumber() {
        return (String) this.phoneNumber.getValue(this, $$delegatedProperties[0]);
    }

    public final String getVcard() {
        return (String) this.vcard.getValue(this, $$delegatedProperties[3]);
    }

    public final SendContact lastName(String lastName) {
        m.f(lastName, "lastName");
        setLastName(lastName);
        return this;
    }

    public final void setLastName(String str) {
        this.lastName.setValue(this, $$delegatedProperties[2], str);
    }

    public final void setVcard(String str) {
        this.vcard.setValue(this, $$delegatedProperties[3], str);
    }

    public final SendContact vcard(String vcard) {
        m.f(vcard, "vcard");
        setVcard(vcard);
        return this;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendContact(long j10, String phoneNumber, String firstName) {
        this(Long.valueOf(j10), null, phoneNumber, firstName);
        m.f(phoneNumber, "phoneNumber");
        m.f(firstName, "firstName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendContact(String channelUsername, String phoneNumber, String firstName) {
        this(null, channelUsername, phoneNumber, firstName);
        m.f(channelUsername, "channelUsername");
        m.f(phoneNumber, "phoneNumber");
        m.f(firstName, "firstName");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendContact(Object chatId, String phoneNumber, String firstName) {
        m.f(chatId, "chatId");
        m.f(phoneNumber, "phoneNumber");
        m.f(firstName, "firstName");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null, phoneNumber, firstName);
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }
}
