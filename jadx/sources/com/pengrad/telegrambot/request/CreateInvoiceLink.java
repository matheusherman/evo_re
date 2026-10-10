package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.request.LabeledPrice;
import com.pengrad.telegrambot.response.StringResponse;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegate;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegateKt;
import i9.k;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.w;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\bI\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001eJ\u000e\u0010%\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0018J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0018J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u0018J\u000e\u00101\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0018J\u000e\u00107\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u001eJ\u000e\u0010;\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u001eJ\u000e\u0010?\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\u0004J\u000e\u0010C\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\u001eJ\u000e\u0010J\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0004J\u000e\u0010N\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u0004J\u000e\u0010R\u001a\u00020\u00002\u0006\u0010R\u001a\u00020\u0018J\u000e\u0010V\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0018J\u000e\u0010Z\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020\u001eJ\u0019\u0010^\u001a\u00020\u00002\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u001e0\t¢\u0006\u0002\u0010fR/\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0007\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0014\u0010\u000fR\u001b\u0010\u0005\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0016\u0010\u000fR/\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\f\u001a\u0004\u0018\u00010\u00188F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR/\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\f\u001a\u0004\u0018\u00010\u001e8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b$\u0010\u0013\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R/\u0010%\u001a\u0004\u0018\u00010\u00182\b\u0010\f\u001a\u0004\u0018\u00010\u00188F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010\u0013\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010\u001cR/\u0010)\u001a\u0004\u0018\u00010\u00182\b\u0010\f\u001a\u0004\u0018\u00010\u00188F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010\u0013\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR/\u0010-\u001a\u0004\u0018\u00010\u00182\b\u0010\f\u001a\u0004\u0018\u00010\u00188F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b0\u0010\u0013\u001a\u0004\b.\u0010\u001a\"\u0004\b/\u0010\u001cR/\u00101\u001a\u0004\u0018\u00010\u00182\b\u0010\f\u001a\u0004\u0018\u00010\u00188F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0013\u001a\u0004\b2\u0010\u001a\"\u0004\b3\u0010\u001cR\u001b\u0010\u0006\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u0013\u001a\u0004\b5\u0010\u000fR/\u00107\u001a\u0004\u0018\u00010\u001e2\b\u0010\f\u001a\u0004\u0018\u00010\u001e8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b:\u0010\u0013\u001a\u0004\b8\u0010!\"\u0004\b9\u0010#R/\u0010;\u001a\u0004\u0018\u00010\u001e2\b\u0010\f\u001a\u0004\u0018\u00010\u001e8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b>\u0010\u0013\u001a\u0004\b<\u0010!\"\u0004\b=\u0010#R/\u0010?\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bB\u0010\u0013\u001a\u0004\b@\u0010\u000f\"\u0004\bA\u0010\u0011R/\u0010C\u001a\u0004\u0018\u00010\u001e2\b\u0010\f\u001a\u0004\u0018\u00010\u001e8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bF\u0010\u0013\u001a\u0004\bD\u0010!\"\u0004\bE\u0010#R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\u0013\u001a\u0004\bG\u0010HR/\u0010J\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bM\u0010\u0013\u001a\u0004\bK\u0010\u000f\"\u0004\bL\u0010\u0011R/\u0010N\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bQ\u0010\u0013\u001a\u0004\bO\u0010\u000f\"\u0004\bP\u0010\u0011R/\u0010R\u001a\u0004\u0018\u00010\u00182\b\u0010\f\u001a\u0004\u0018\u00010\u00188F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bU\u0010\u0013\u001a\u0004\bS\u0010\u001a\"\u0004\bT\u0010\u001cR/\u0010V\u001a\u0004\u0018\u00010\u00182\b\u0010\f\u001a\u0004\u0018\u00010\u00188F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bY\u0010\u0013\u001a\u0004\bW\u0010\u001a\"\u0004\bX\u0010\u001cR/\u0010Z\u001a\u0004\u0018\u00010\u001e2\b\u0010\f\u001a\u0004\u0018\u00010\u001e8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b]\u0010\u0013\u001a\u0004\b[\u0010!\"\u0004\b\\\u0010#R;\u0010^\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\t2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bc\u0010\u0013\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\be\u0010\u0013\u001a\u0004\bd\u0010\u000f¨\u0006g"}, d2 = {"Lcom/pengrad/telegrambot/request/CreateInvoiceLink;", "Lcom/pengrad/telegrambot/request/KBaseRequest;", "Lcom/pengrad/telegrambot/response/StringResponse;", "title", "", "description", "payload", "currency", "prices", "", "Lcom/pengrad/telegrambot/model/request/LabeledPrice;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Lcom/pengrad/telegrambot/model/request/LabeledPrice;)V", "<set-?>", "businessConnectionId", "getBusinessConnectionId", "()Ljava/lang/String;", "setBusinessConnectionId", "(Ljava/lang/String;)V", "businessConnectionId$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "getCurrency", "currency$delegate", "getDescription", "description$delegate", "", "isFlexible", "()Ljava/lang/Boolean;", "setFlexible", "(Ljava/lang/Boolean;)V", "isFlexible$delegate", "", "maxTipAmount", "getMaxTipAmount", "()Ljava/lang/Integer;", "setMaxTipAmount", "(Ljava/lang/Integer;)V", "maxTipAmount$delegate", "needEmail", "getNeedEmail", "setNeedEmail", "needEmail$delegate", "needName", "getNeedName", "setNeedName", "needName$delegate", "needPhoneNumber", "getNeedPhoneNumber", "setNeedPhoneNumber", "needPhoneNumber$delegate", "needShippingAddress", "getNeedShippingAddress", "setNeedShippingAddress", "needShippingAddress$delegate", "getPayload", "payload$delegate", "photoHeight", "getPhotoHeight", "setPhotoHeight", "photoHeight$delegate", "photoSize", "getPhotoSize", "setPhotoSize", "photoSize$delegate", "photoUrl", "getPhotoUrl", "setPhotoUrl", "photoUrl$delegate", "photoWidth", "getPhotoWidth", "setPhotoWidth", "photoWidth$delegate", "getPrices", "()[Lcom/pengrad/telegrambot/model/request/LabeledPrice;", "prices$delegate", "providerData", "getProviderData", "setProviderData", "providerData$delegate", "providerToken", "getProviderToken", "setProviderToken", "providerToken$delegate", "sendEmailToProvider", "getSendEmailToProvider", "setSendEmailToProvider", "sendEmailToProvider$delegate", "sendPhoneNumberToProvider", "getSendPhoneNumberToProvider", "setSendPhoneNumberToProvider", "sendPhoneNumberToProvider$delegate", "subscriptionPeriod", "getSubscriptionPeriod", "setSubscriptionPeriod", "subscriptionPeriod$delegate", "suggestedTipAmounts", "getSuggestedTipAmounts", "()[Ljava/lang/Integer;", "setSuggestedTipAmounts", "([Ljava/lang/Integer;)V", "suggestedTipAmounts$delegate", "getTitle", "title$delegate", "([Ljava/lang/Integer;)Lcom/pengrad/telegrambot/request/CreateInvoiceLink;", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CreateInvoiceLink extends KBaseRequest<CreateInvoiceLink, StringResponse> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(CreateInvoiceLink.class, "title", "getTitle()Ljava/lang/String;", 0)), c0.g(new w(CreateInvoiceLink.class, "description", "getDescription()Ljava/lang/String;", 0)), c0.g(new w(CreateInvoiceLink.class, "payload", "getPayload()Ljava/lang/String;", 0)), c0.g(new w(CreateInvoiceLink.class, "currency", "getCurrency()Ljava/lang/String;", 0)), c0.g(new w(CreateInvoiceLink.class, "prices", "getPrices()[Lcom/pengrad/telegrambot/model/request/LabeledPrice;", 0)), c0.e(new q(CreateInvoiceLink.class, "providerToken", "getProviderToken()Ljava/lang/String;", 0)), c0.e(new q(CreateInvoiceLink.class, "subscriptionPeriod", "getSubscriptionPeriod()Ljava/lang/Integer;", 0)), c0.e(new q(CreateInvoiceLink.class, "businessConnectionId", "getBusinessConnectionId()Ljava/lang/String;", 0)), c0.e(new q(CreateInvoiceLink.class, "maxTipAmount", "getMaxTipAmount()Ljava/lang/Integer;", 0)), c0.e(new q(CreateInvoiceLink.class, "suggestedTipAmounts", "getSuggestedTipAmounts()[Ljava/lang/Integer;", 0)), c0.e(new q(CreateInvoiceLink.class, "providerData", "getProviderData()Ljava/lang/String;", 0)), c0.e(new q(CreateInvoiceLink.class, "photoUrl", "getPhotoUrl()Ljava/lang/String;", 0)), c0.e(new q(CreateInvoiceLink.class, "photoSize", "getPhotoSize()Ljava/lang/Integer;", 0)), c0.e(new q(CreateInvoiceLink.class, "photoWidth", "getPhotoWidth()Ljava/lang/Integer;", 0)), c0.e(new q(CreateInvoiceLink.class, "photoHeight", "getPhotoHeight()Ljava/lang/Integer;", 0)), c0.e(new q(CreateInvoiceLink.class, "needName", "getNeedName()Ljava/lang/Boolean;", 0)), c0.e(new q(CreateInvoiceLink.class, "needPhoneNumber", "getNeedPhoneNumber()Ljava/lang/Boolean;", 0)), c0.e(new q(CreateInvoiceLink.class, "needEmail", "getNeedEmail()Ljava/lang/Boolean;", 0)), c0.e(new q(CreateInvoiceLink.class, "needShippingAddress", "getNeedShippingAddress()Ljava/lang/Boolean;", 0)), c0.e(new q(CreateInvoiceLink.class, "sendEmailToProvider", "getSendEmailToProvider()Ljava/lang/Boolean;", 0)), c0.e(new q(CreateInvoiceLink.class, "sendPhoneNumberToProvider", "getSendPhoneNumberToProvider()Ljava/lang/Boolean;", 0)), c0.e(new q(CreateInvoiceLink.class, "isFlexible", "isFlexible()Ljava/lang/Boolean;", 0))};

    /* JADX INFO: renamed from: businessConnectionId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate businessConnectionId;

    /* JADX INFO: renamed from: currency$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate currency;

    /* JADX INFO: renamed from: description$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate description;

    /* JADX INFO: renamed from: isFlexible$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate isFlexible;

    /* JADX INFO: renamed from: maxTipAmount$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate maxTipAmount;

    /* JADX INFO: renamed from: needEmail$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate needEmail;

    /* JADX INFO: renamed from: needName$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate needName;

    /* JADX INFO: renamed from: needPhoneNumber$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate needPhoneNumber;

    /* JADX INFO: renamed from: needShippingAddress$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate needShippingAddress;

    /* JADX INFO: renamed from: payload$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate payload;

    /* JADX INFO: renamed from: photoHeight$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate photoHeight;

    /* JADX INFO: renamed from: photoSize$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate photoSize;

    /* JADX INFO: renamed from: photoUrl$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate photoUrl;

    /* JADX INFO: renamed from: photoWidth$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate photoWidth;

    /* JADX INFO: renamed from: prices$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate prices;

    /* JADX INFO: renamed from: providerData$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate providerData;

    /* JADX INFO: renamed from: providerToken$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate providerToken;

    /* JADX INFO: renamed from: sendEmailToProvider$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate sendEmailToProvider;

    /* JADX INFO: renamed from: sendPhoneNumberToProvider$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate sendPhoneNumberToProvider;

    /* JADX INFO: renamed from: subscriptionPeriod$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate subscriptionPeriod;

    /* JADX INFO: renamed from: suggestedTipAmounts$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate suggestedTipAmounts;

    /* JADX INFO: renamed from: title$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate title;

    public final Boolean isFlexible() {
        return (Boolean) this.isFlexible.getValue(this, $$delegatedProperties[21]);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateInvoiceLink(String title, String description, String payload, String currency, LabeledPrice... prices) {
        super(c0.b(StringResponse.class));
        m.f(title, "title");
        m.f(description, "description");
        m.f(payload, "payload");
        m.f(currency, "currency");
        m.f(prices, "prices");
        RequestParameterDelegate requestParameterDelegateRequestParameter$default = RequestParameterDelegateKt.requestParameter$default(title, null, 2, null);
        k<?>[] kVarArr = $$delegatedProperties;
        this.title = requestParameterDelegateRequestParameter$default.provideDelegate(this, kVarArr[0]);
        this.description = RequestParameterDelegateKt.requestParameter$default(description, null, 2, null).provideDelegate(this, kVarArr[1]);
        this.payload = RequestParameterDelegateKt.requestParameter$default(payload, null, 2, null).provideDelegate(this, kVarArr[2]);
        this.currency = RequestParameterDelegateKt.requestParameter$default(currency, null, 2, null).provideDelegate(this, kVarArr[3]);
        this.prices = RequestParameterDelegateKt.requestParameter$default(Arrays.copyOf(prices, prices.length), null, 2, null).provideDelegate(this, kVarArr[4]);
        this.providerToken = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[5]);
        this.subscriptionPeriod = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[6]);
        this.businessConnectionId = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[7]);
        this.maxTipAmount = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[8]);
        this.suggestedTipAmounts = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[9]);
        this.providerData = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[10]);
        this.photoUrl = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[11]);
        this.photoSize = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[12]);
        this.photoWidth = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[13]);
        this.photoHeight = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[14]);
        this.needName = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[15]);
        this.needPhoneNumber = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[16]);
        this.needEmail = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[17]);
        this.needShippingAddress = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[18]);
        this.sendEmailToProvider = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[19]);
        this.sendPhoneNumberToProvider = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[20]);
        this.isFlexible = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[21]);
    }

    public final CreateInvoiceLink businessConnectionId(String businessConnectionId) {
        m.f(businessConnectionId, "businessConnectionId");
        setBusinessConnectionId(businessConnectionId);
        return this;
    }

    public final String getBusinessConnectionId() {
        return (String) this.businessConnectionId.getValue(this, $$delegatedProperties[7]);
    }

    public final String getCurrency() {
        return (String) this.currency.getValue(this, $$delegatedProperties[3]);
    }

    public final String getDescription() {
        return (String) this.description.getValue(this, $$delegatedProperties[1]);
    }

    public final Integer getMaxTipAmount() {
        return (Integer) this.maxTipAmount.getValue(this, $$delegatedProperties[8]);
    }

    public final Boolean getNeedEmail() {
        return (Boolean) this.needEmail.getValue(this, $$delegatedProperties[17]);
    }

    public final Boolean getNeedName() {
        return (Boolean) this.needName.getValue(this, $$delegatedProperties[15]);
    }

    public final Boolean getNeedPhoneNumber() {
        return (Boolean) this.needPhoneNumber.getValue(this, $$delegatedProperties[16]);
    }

    public final Boolean getNeedShippingAddress() {
        return (Boolean) this.needShippingAddress.getValue(this, $$delegatedProperties[18]);
    }

    public final String getPayload() {
        return (String) this.payload.getValue(this, $$delegatedProperties[2]);
    }

    public final Integer getPhotoHeight() {
        return (Integer) this.photoHeight.getValue(this, $$delegatedProperties[14]);
    }

    public final Integer getPhotoSize() {
        return (Integer) this.photoSize.getValue(this, $$delegatedProperties[12]);
    }

    public final String getPhotoUrl() {
        return (String) this.photoUrl.getValue(this, $$delegatedProperties[11]);
    }

    public final Integer getPhotoWidth() {
        return (Integer) this.photoWidth.getValue(this, $$delegatedProperties[13]);
    }

    public final LabeledPrice[] getPrices() {
        return (LabeledPrice[]) this.prices.getValue(this, $$delegatedProperties[4]);
    }

    public final String getProviderData() {
        return (String) this.providerData.getValue(this, $$delegatedProperties[10]);
    }

    public final String getProviderToken() {
        return (String) this.providerToken.getValue(this, $$delegatedProperties[5]);
    }

    public final Boolean getSendEmailToProvider() {
        return (Boolean) this.sendEmailToProvider.getValue(this, $$delegatedProperties[19]);
    }

    public final Boolean getSendPhoneNumberToProvider() {
        return (Boolean) this.sendPhoneNumberToProvider.getValue(this, $$delegatedProperties[20]);
    }

    public final Integer getSubscriptionPeriod() {
        return (Integer) this.subscriptionPeriod.getValue(this, $$delegatedProperties[6]);
    }

    public final Integer[] getSuggestedTipAmounts() {
        return (Integer[]) this.suggestedTipAmounts.getValue(this, $$delegatedProperties[9]);
    }

    public final String getTitle() {
        return (String) this.title.getValue(this, $$delegatedProperties[0]);
    }

    public final CreateInvoiceLink isFlexible(boolean isFlexible) {
        setFlexible(Boolean.valueOf(isFlexible));
        return this;
    }

    public final CreateInvoiceLink photoUrl(String photoUrl) {
        m.f(photoUrl, "photoUrl");
        setPhotoUrl(photoUrl);
        return this;
    }

    public final CreateInvoiceLink providerData(String providerData) {
        m.f(providerData, "providerData");
        setProviderData(providerData);
        return this;
    }

    public final CreateInvoiceLink providerToken(String providerToken) {
        m.f(providerToken, "providerToken");
        setProviderToken(providerToken);
        return this;
    }

    public final void setBusinessConnectionId(String str) {
        this.businessConnectionId.setValue(this, $$delegatedProperties[7], str);
    }

    public final void setFlexible(Boolean bool) {
        this.isFlexible.setValue(this, $$delegatedProperties[21], bool);
    }

    public final void setMaxTipAmount(Integer num) {
        this.maxTipAmount.setValue(this, $$delegatedProperties[8], num);
    }

    public final void setNeedEmail(Boolean bool) {
        this.needEmail.setValue(this, $$delegatedProperties[17], bool);
    }

    public final void setNeedName(Boolean bool) {
        this.needName.setValue(this, $$delegatedProperties[15], bool);
    }

    public final void setNeedPhoneNumber(Boolean bool) {
        this.needPhoneNumber.setValue(this, $$delegatedProperties[16], bool);
    }

    public final void setNeedShippingAddress(Boolean bool) {
        this.needShippingAddress.setValue(this, $$delegatedProperties[18], bool);
    }

    public final void setPhotoHeight(Integer num) {
        this.photoHeight.setValue(this, $$delegatedProperties[14], num);
    }

    public final void setPhotoSize(Integer num) {
        this.photoSize.setValue(this, $$delegatedProperties[12], num);
    }

    public final void setPhotoUrl(String str) {
        this.photoUrl.setValue(this, $$delegatedProperties[11], str);
    }

    public final void setPhotoWidth(Integer num) {
        this.photoWidth.setValue(this, $$delegatedProperties[13], num);
    }

    public final void setProviderData(String str) {
        this.providerData.setValue(this, $$delegatedProperties[10], str);
    }

    public final void setProviderToken(String str) {
        this.providerToken.setValue(this, $$delegatedProperties[5], str);
    }

    public final void setSendEmailToProvider(Boolean bool) {
        this.sendEmailToProvider.setValue(this, $$delegatedProperties[19], bool);
    }

    public final void setSendPhoneNumberToProvider(Boolean bool) {
        this.sendPhoneNumberToProvider.setValue(this, $$delegatedProperties[20], bool);
    }

    public final void setSubscriptionPeriod(Integer num) {
        this.subscriptionPeriod.setValue(this, $$delegatedProperties[6], num);
    }

    public final void setSuggestedTipAmounts(Integer[] numArr) {
        this.suggestedTipAmounts.setValue(this, $$delegatedProperties[9], numArr);
    }

    public final CreateInvoiceLink suggestedTipAmounts(Integer[] suggestedTipAmounts) {
        m.f(suggestedTipAmounts, "suggestedTipAmounts");
        setSuggestedTipAmounts(suggestedTipAmounts);
        return this;
    }

    public final CreateInvoiceLink maxTipAmount(int maxTipAmount) {
        setMaxTipAmount(Integer.valueOf(maxTipAmount));
        return this;
    }

    public final CreateInvoiceLink needEmail(boolean needEmail) {
        setNeedEmail(Boolean.valueOf(needEmail));
        return this;
    }

    public final CreateInvoiceLink needName(boolean needName) {
        setNeedName(Boolean.valueOf(needName));
        return this;
    }

    public final CreateInvoiceLink needPhoneNumber(boolean needPhoneNumber) {
        setNeedPhoneNumber(Boolean.valueOf(needPhoneNumber));
        return this;
    }

    public final CreateInvoiceLink needShippingAddress(boolean needShippingAddress) {
        setNeedShippingAddress(Boolean.valueOf(needShippingAddress));
        return this;
    }

    public final CreateInvoiceLink photoHeight(int photoHeight) {
        setPhotoHeight(Integer.valueOf(photoHeight));
        return this;
    }

    public final CreateInvoiceLink photoSize(int photoSize) {
        setPhotoSize(Integer.valueOf(photoSize));
        return this;
    }

    public final CreateInvoiceLink photoWidth(int photoWidth) {
        setPhotoWidth(Integer.valueOf(photoWidth));
        return this;
    }

    public final CreateInvoiceLink sendEmailToProvider(boolean sendEmailToProvider) {
        setSendEmailToProvider(Boolean.valueOf(sendEmailToProvider));
        return this;
    }

    public final CreateInvoiceLink sendPhoneNumberToProvider(boolean sendPhoneNumberToProvider) {
        setSendPhoneNumberToProvider(Boolean.valueOf(sendPhoneNumberToProvider));
        return this;
    }

    public final CreateInvoiceLink subscriptionPeriod(int subscriptionPeriod) {
        setSubscriptionPeriod(Integer.valueOf(subscriptionPeriod));
        return this;
    }
}
