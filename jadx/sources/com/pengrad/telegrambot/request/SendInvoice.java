package com.pengrad.telegrambot.request;

import c9.l;
import com.pengrad.telegrambot.model.request.LabeledPrice;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegate;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegateKt;
import i9.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.j;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.w;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\bL\n\u0002\u0010\u0015\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B=\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fB=\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\u000eBC\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u0010\"\u00020\u000b¢\u0006\u0002\u0010\u0011BM\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\u0012J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010!\u001a\u00020 J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u001aJ\u000e\u0010+\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u001aJ\u000e\u0010/\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u001aJ\u000e\u00103\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u001aJ\u000e\u00109\u001a\u00020\u00002\u0006\u00109\u001a\u00020 J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010=\u001a\u00020 J\u000e\u0010A\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\u0005J\u000e\u0010F\u001a\u00020\u00002\u0006\u0010F\u001a\u00020 J\u000e\u0010M\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u0005J\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u0005J\u000e\u0010U\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u001aJ\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\u001aJ\u000e\u0010]\u001a\u00020\u00002\u0006\u0010]\u001a\u00020\u0005J\u0019\u0010e\u001a\u00020\u00002\f\u0010e\u001a\b\u0012\u0004\u0012\u00020 0\u0010¢\u0006\u0002\u0010lJ\u0012\u0010e\u001a\u00020\u00002\n\u0010e\u001a\u00020m\"\u00020 J\u0014\u0010e\u001a\u00020\u00002\f\u0010e\u001a\b\u0012\u0004\u0012\u00020 0\nR\u001b\u0010\b\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0006\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0017\u0010\u0014R/\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR/\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010 8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010\u0016\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R/\u0010'\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b*\u0010\u0016\u001a\u0004\b(\u0010\u001c\"\u0004\b)\u0010\u001eR/\u0010+\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010\u0016\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010\u001eR/\u0010/\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b2\u0010\u0016\u001a\u0004\b0\u0010\u001c\"\u0004\b1\u0010\u001eR/\u00103\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b6\u0010\u0016\u001a\u0004\b4\u0010\u001c\"\u0004\b5\u0010\u001eR\u001b\u0010\u0007\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0016\u001a\u0004\b7\u0010\u0014R/\u00109\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010 8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b<\u0010\u0016\u001a\u0004\b:\u0010#\"\u0004\b;\u0010%R/\u0010=\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010 8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b@\u0010\u0016\u001a\u0004\b>\u0010#\"\u0004\b?\u0010%R/\u0010A\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010\u0016\u001a\u0004\bB\u0010\u0014\"\u0004\bC\u0010DR/\u0010F\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010 8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bI\u0010\u0016\u001a\u0004\bG\u0010#\"\u0004\bH\u0010%R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\u0016\u001a\u0004\bJ\u0010KR/\u0010M\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bP\u0010\u0016\u001a\u0004\bN\u0010\u0014\"\u0004\bO\u0010DR/\u0010Q\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bT\u0010\u0016\u001a\u0004\bR\u0010\u0014\"\u0004\bS\u0010DR/\u0010U\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bX\u0010\u0016\u001a\u0004\bV\u0010\u001c\"\u0004\bW\u0010\u001eR/\u0010Y\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\\\u0010\u0016\u001a\u0004\bZ\u0010\u001c\"\u0004\b[\u0010\u001eR/\u0010]\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b`\u0010\u0016\u001a\u0004\b^\u0010\u0014\"\u0004\b_\u0010DR/\u0010a\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010 8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bd\u0010\u0016\u001a\u0004\bb\u0010#\"\u0004\bc\u0010%R;\u0010e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\n2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bi\u0010\u0016\u001a\u0004\bf\u0010K\"\u0004\bg\u0010hR\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bk\u0010\u0016\u001a\u0004\bj\u0010\u0014¨\u0006n"}, d2 = {"Lcom/pengrad/telegrambot/request/SendInvoice;", "Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "chatId", "", "title", "", "description", "payload", "currency", "prices", "", "Lcom/pengrad/telegrambot/model/request/LabeledPrice;", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "channelUsername", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "", "", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Lcom/pengrad/telegrambot/model/request/LabeledPrice;)V", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCurrency", "()Ljava/lang/String;", "currency$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "getDescription", "description$delegate", "<set-?>", "", "isFlexible", "()Ljava/lang/Boolean;", "setFlexible", "(Ljava/lang/Boolean;)V", "isFlexible$delegate", "", "maxTipAmount", "getMaxTipAmount", "()Ljava/lang/Integer;", "setMaxTipAmount", "(Ljava/lang/Integer;)V", "maxTipAmount$delegate", "needEmail", "getNeedEmail", "setNeedEmail", "needEmail$delegate", "needName", "getNeedName", "setNeedName", "needName$delegate", "needPhoneNumber", "getNeedPhoneNumber", "setNeedPhoneNumber", "needPhoneNumber$delegate", "needShippingAddress", "getNeedShippingAddress", "setNeedShippingAddress", "needShippingAddress$delegate", "getPayload", "payload$delegate", "photoHeight", "getPhotoHeight", "setPhotoHeight", "photoHeight$delegate", "photoSize", "getPhotoSize", "setPhotoSize", "photoSize$delegate", "photoUrl", "getPhotoUrl", "setPhotoUrl", "(Ljava/lang/String;)V", "photoUrl$delegate", "photoWidth", "getPhotoWidth", "setPhotoWidth", "photoWidth$delegate", "getPrices", "()Ljava/util/List;", "prices$delegate", "providerData", "getProviderData", "setProviderData", "providerData$delegate", "providerToken", "getProviderToken", "setProviderToken", "providerToken$delegate", "sendEmailToProvider", "getSendEmailToProvider", "setSendEmailToProvider", "sendEmailToProvider$delegate", "sendPhoneNumberToProvider", "getSendPhoneNumberToProvider", "setSendPhoneNumberToProvider", "sendPhoneNumberToProvider$delegate", "startParameter", "getStartParameter", "setStartParameter", "startParameter$delegate", "subscriptionPeriod", "getSubscriptionPeriod", "setSubscriptionPeriod", "subscriptionPeriod$delegate", "suggestedTipAmounts", "getSuggestedTipAmounts", "setSuggestedTipAmounts", "(Ljava/util/List;)V", "suggestedTipAmounts$delegate", "getTitle", "title$delegate", "([Ljava/lang/Integer;)Lcom/pengrad/telegrambot/request/SendInvoice;", "", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SendInvoice extends AbstractSendRequest<SendInvoice> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(SendInvoice.class, "title", "getTitle()Ljava/lang/String;", 0)), c0.g(new w(SendInvoice.class, "description", "getDescription()Ljava/lang/String;", 0)), c0.g(new w(SendInvoice.class, "payload", "getPayload()Ljava/lang/String;", 0)), c0.g(new w(SendInvoice.class, "currency", "getCurrency()Ljava/lang/String;", 0)), c0.g(new w(SendInvoice.class, "prices", "getPrices()Ljava/util/List;", 0)), c0.e(new q(SendInvoice.class, "providerToken", "getProviderToken()Ljava/lang/String;", 0)), c0.e(new q(SendInvoice.class, "providerData", "getProviderData()Ljava/lang/String;", 0)), c0.e(new q(SendInvoice.class, "maxTipAmount", "getMaxTipAmount()Ljava/lang/Integer;", 0)), c0.e(new q(SendInvoice.class, "suggestedTipAmounts", "getSuggestedTipAmounts()Ljava/util/List;", 0)), c0.e(new q(SendInvoice.class, "photoUrl", "getPhotoUrl()Ljava/lang/String;", 0)), c0.e(new q(SendInvoice.class, "photoSize", "getPhotoSize()Ljava/lang/Integer;", 0)), c0.e(new q(SendInvoice.class, "photoWidth", "getPhotoWidth()Ljava/lang/Integer;", 0)), c0.e(new q(SendInvoice.class, "photoHeight", "getPhotoHeight()Ljava/lang/Integer;", 0)), c0.e(new q(SendInvoice.class, "needName", "getNeedName()Ljava/lang/Boolean;", 0)), c0.e(new q(SendInvoice.class, "needPhoneNumber", "getNeedPhoneNumber()Ljava/lang/Boolean;", 0)), c0.e(new q(SendInvoice.class, "needEmail", "getNeedEmail()Ljava/lang/Boolean;", 0)), c0.e(new q(SendInvoice.class, "needShippingAddress", "getNeedShippingAddress()Ljava/lang/Boolean;", 0)), c0.e(new q(SendInvoice.class, "sendEmailToProvider", "getSendEmailToProvider()Ljava/lang/Boolean;", 0)), c0.e(new q(SendInvoice.class, "sendPhoneNumberToProvider", "getSendPhoneNumberToProvider()Ljava/lang/Boolean;", 0)), c0.e(new q(SendInvoice.class, "isFlexible", "isFlexible()Ljava/lang/Boolean;", 0)), c0.e(new q(SendInvoice.class, "subscriptionPeriod", "getSubscriptionPeriod()Ljava/lang/Integer;", 0)), c0.e(new q(SendInvoice.class, "startParameter", "getStartParameter()Ljava/lang/String;", 0))};

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

    /* JADX INFO: renamed from: startParameter$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate startParameter;

    /* JADX INFO: renamed from: subscriptionPeriod$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate subscriptionPeriod;

    /* JADX INFO: renamed from: suggestedTipAmounts$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate suggestedTipAmounts;

    /* JADX INFO: renamed from: title$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate title;

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendInvoice$isFlexible$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendInvoice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendInvoice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass5 extends o implements l<SendInvoice, z> {
        final /* synthetic */ boolean $isFlexible;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendInvoice sendInvoice) {
            invoke2(sendInvoice);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(boolean z10) {
            super(1);
            this.$isFlexible = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendInvoice applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setFlexible(Boolean.valueOf(this.$isFlexible));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendInvoice$maxTipAmount$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendInvoice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendInvoice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06125 extends o implements l<SendInvoice, z> {
        final /* synthetic */ int $maxTipAmount;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendInvoice sendInvoice) {
            invoke2(sendInvoice);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06125(int i10) {
            super(1);
            this.$maxTipAmount = i10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendInvoice applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setMaxTipAmount(Integer.valueOf(this.$maxTipAmount));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendInvoice$needEmail$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendInvoice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendInvoice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06135 extends o implements l<SendInvoice, z> {
        final /* synthetic */ boolean $needEmail;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendInvoice sendInvoice) {
            invoke2(sendInvoice);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06135(boolean z10) {
            super(1);
            this.$needEmail = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendInvoice applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setNeedEmail(Boolean.valueOf(this.$needEmail));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendInvoice$needName$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendInvoice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendInvoice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06145 extends o implements l<SendInvoice, z> {
        final /* synthetic */ boolean $needName;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendInvoice sendInvoice) {
            invoke2(sendInvoice);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06145(boolean z10) {
            super(1);
            this.$needName = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendInvoice applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setNeedName(Boolean.valueOf(this.$needName));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendInvoice$needPhoneNumber$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendInvoice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendInvoice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06155 extends o implements l<SendInvoice, z> {
        final /* synthetic */ boolean $needPhoneNumber;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendInvoice sendInvoice) {
            invoke2(sendInvoice);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06155(boolean z10) {
            super(1);
            this.$needPhoneNumber = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendInvoice applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setNeedPhoneNumber(Boolean.valueOf(this.$needPhoneNumber));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendInvoice$needShippingAddress$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendInvoice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendInvoice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06165 extends o implements l<SendInvoice, z> {
        final /* synthetic */ boolean $needShippingAddress;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendInvoice sendInvoice) {
            invoke2(sendInvoice);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06165(boolean z10) {
            super(1);
            this.$needShippingAddress = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendInvoice applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setNeedShippingAddress(Boolean.valueOf(this.$needShippingAddress));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendInvoice$photoHeight$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendInvoice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendInvoice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06175 extends o implements l<SendInvoice, z> {
        final /* synthetic */ int $photoHeight;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendInvoice sendInvoice) {
            invoke2(sendInvoice);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06175(int i10) {
            super(1);
            this.$photoHeight = i10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendInvoice applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setPhotoHeight(Integer.valueOf(this.$photoHeight));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendInvoice$photoSize$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendInvoice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendInvoice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06185 extends o implements l<SendInvoice, z> {
        final /* synthetic */ int $photoSize;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendInvoice sendInvoice) {
            invoke2(sendInvoice);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06185(int i10) {
            super(1);
            this.$photoSize = i10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendInvoice applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setPhotoSize(Integer.valueOf(this.$photoSize));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendInvoice$photoUrl$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendInvoice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendInvoice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06195 extends o implements l<SendInvoice, z> {
        final /* synthetic */ String $photoUrl;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendInvoice sendInvoice) {
            invoke2(sendInvoice);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06195(String str) {
            super(1);
            this.$photoUrl = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendInvoice applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setPhotoUrl(this.$photoUrl);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendInvoice$photoWidth$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendInvoice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendInvoice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06205 extends o implements l<SendInvoice, z> {
        final /* synthetic */ int $photoWidth;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendInvoice sendInvoice) {
            invoke2(sendInvoice);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06205(int i10) {
            super(1);
            this.$photoWidth = i10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendInvoice applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setPhotoWidth(Integer.valueOf(this.$photoWidth));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendInvoice$providerData$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendInvoice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendInvoice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06215 extends o implements l<SendInvoice, z> {
        final /* synthetic */ String $providerData;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendInvoice sendInvoice) {
            invoke2(sendInvoice);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06215(String str) {
            super(1);
            this.$providerData = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendInvoice applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setProviderData(this.$providerData);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendInvoice$providerToken$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendInvoice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendInvoice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06225 extends o implements l<SendInvoice, z> {
        final /* synthetic */ String $providerToken;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendInvoice sendInvoice) {
            invoke2(sendInvoice);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06225(String str) {
            super(1);
            this.$providerToken = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendInvoice applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setProviderToken(this.$providerToken);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendInvoice$sendEmailToProvider$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendInvoice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendInvoice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06235 extends o implements l<SendInvoice, z> {
        final /* synthetic */ boolean $sendEmailToProvider;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendInvoice sendInvoice) {
            invoke2(sendInvoice);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06235(boolean z10) {
            super(1);
            this.$sendEmailToProvider = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendInvoice applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setSendEmailToProvider(Boolean.valueOf(this.$sendEmailToProvider));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendInvoice$sendPhoneNumberToProvider$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendInvoice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendInvoice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06245 extends o implements l<SendInvoice, z> {
        final /* synthetic */ boolean $sendPhoneNumberToProvider;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendInvoice sendInvoice) {
            invoke2(sendInvoice);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06245(boolean z10) {
            super(1);
            this.$sendPhoneNumberToProvider = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendInvoice applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setSendPhoneNumberToProvider(Boolean.valueOf(this.$sendPhoneNumberToProvider));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendInvoice$startParameter$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendInvoice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendInvoice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06255 extends o implements l<SendInvoice, z> {
        final /* synthetic */ String $startParameter;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendInvoice sendInvoice) {
            invoke2(sendInvoice);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06255(String str) {
            super(1);
            this.$startParameter = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendInvoice applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setStartParameter(this.$startParameter);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendInvoice$suggestedTipAmounts$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendInvoice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendInvoice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06265 extends o implements l<SendInvoice, z> {
        final /* synthetic */ List<Integer> $suggestedTipAmounts;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendInvoice sendInvoice) {
            invoke2(sendInvoice);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06265(List<Integer> list) {
            super(1);
            this.$suggestedTipAmounts = list;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendInvoice applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setSuggestedTipAmounts(this.$suggestedTipAmounts);
        }
    }

    /* synthetic */ SendInvoice(Long l10, String str, String str2, String str3, String str4, String str5, List list, int i10, g gVar) {
        this((i10 & 1) != 0 ? null : l10, (i10 & 2) != 0 ? null : str, str2, str3, str4, str5, list);
    }

    public final Boolean isFlexible() {
        return (Boolean) this.isFlexible.getValue(this, $$delegatedProperties[19]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendInvoice suggestedTipAmounts(List<Integer> suggestedTipAmounts) {
        m.f(suggestedTipAmounts, "suggestedTipAmounts");
        return (SendInvoice) applySelf(new C06265(suggestedTipAmounts));
    }

    private SendInvoice(Long l10, String str, String str2, String str3, String str4, String str5, List<? extends LabeledPrice> list) {
        super(l10, str);
        RequestParameterDelegate requestParameterDelegateRequestParameter$default = RequestParameterDelegateKt.requestParameter$default(str2, null, 2, null);
        k<?>[] kVarArr = $$delegatedProperties;
        this.title = requestParameterDelegateRequestParameter$default.provideDelegate(this, kVarArr[0]);
        this.description = RequestParameterDelegateKt.requestParameter$default(str3, null, 2, null).provideDelegate(this, kVarArr[1]);
        this.payload = RequestParameterDelegateKt.requestParameter$default(str4, null, 2, null).provideDelegate(this, kVarArr[2]);
        this.currency = RequestParameterDelegateKt.requestParameter$default(str5, null, 2, null).provideDelegate(this, kVarArr[3]);
        this.prices = RequestParameterDelegateKt.requestParameter$default(list, null, 2, null).provideDelegate(this, kVarArr[4]);
        this.providerToken = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[5]);
        this.providerData = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[6]);
        this.maxTipAmount = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[7]);
        this.suggestedTipAmounts = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[8]);
        this.photoUrl = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[9]);
        this.photoSize = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[10]);
        this.photoWidth = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[11]);
        this.photoHeight = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[12]);
        this.needName = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[13]);
        this.needPhoneNumber = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[14]);
        this.needEmail = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[15]);
        this.needShippingAddress = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[16]);
        this.sendEmailToProvider = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[17]);
        this.sendPhoneNumberToProvider = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[18]);
        this.isFlexible = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[19]);
        this.subscriptionPeriod = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[20]);
        this.startParameter = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[21]);
    }

    public final String getCurrency() {
        return (String) this.currency.getValue(this, $$delegatedProperties[3]);
    }

    public final String getDescription() {
        return (String) this.description.getValue(this, $$delegatedProperties[1]);
    }

    public final Integer getMaxTipAmount() {
        return (Integer) this.maxTipAmount.getValue(this, $$delegatedProperties[7]);
    }

    public final Boolean getNeedEmail() {
        return (Boolean) this.needEmail.getValue(this, $$delegatedProperties[15]);
    }

    public final Boolean getNeedName() {
        return (Boolean) this.needName.getValue(this, $$delegatedProperties[13]);
    }

    public final Boolean getNeedPhoneNumber() {
        return (Boolean) this.needPhoneNumber.getValue(this, $$delegatedProperties[14]);
    }

    public final Boolean getNeedShippingAddress() {
        return (Boolean) this.needShippingAddress.getValue(this, $$delegatedProperties[16]);
    }

    public final String getPayload() {
        return (String) this.payload.getValue(this, $$delegatedProperties[2]);
    }

    public final Integer getPhotoHeight() {
        return (Integer) this.photoHeight.getValue(this, $$delegatedProperties[12]);
    }

    public final Integer getPhotoSize() {
        return (Integer) this.photoSize.getValue(this, $$delegatedProperties[10]);
    }

    public final String getPhotoUrl() {
        return (String) this.photoUrl.getValue(this, $$delegatedProperties[9]);
    }

    public final Integer getPhotoWidth() {
        return (Integer) this.photoWidth.getValue(this, $$delegatedProperties[11]);
    }

    public final List<LabeledPrice> getPrices() {
        return (List) this.prices.getValue(this, $$delegatedProperties[4]);
    }

    public final String getProviderData() {
        return (String) this.providerData.getValue(this, $$delegatedProperties[6]);
    }

    public final String getProviderToken() {
        return (String) this.providerToken.getValue(this, $$delegatedProperties[5]);
    }

    public final Boolean getSendEmailToProvider() {
        return (Boolean) this.sendEmailToProvider.getValue(this, $$delegatedProperties[17]);
    }

    public final Boolean getSendPhoneNumberToProvider() {
        return (Boolean) this.sendPhoneNumberToProvider.getValue(this, $$delegatedProperties[18]);
    }

    public final String getStartParameter() {
        return (String) this.startParameter.getValue(this, $$delegatedProperties[21]);
    }

    public final Integer getSubscriptionPeriod() {
        return (Integer) this.subscriptionPeriod.getValue(this, $$delegatedProperties[20]);
    }

    public final List<Integer> getSuggestedTipAmounts() {
        return (List) this.suggestedTipAmounts.getValue(this, $$delegatedProperties[8]);
    }

    public final String getTitle() {
        return (String) this.title.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendInvoice isFlexible(boolean isFlexible) {
        return (SendInvoice) applySelf(new AnonymousClass5(isFlexible));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendInvoice maxTipAmount(int maxTipAmount) {
        return (SendInvoice) applySelf(new C06125(maxTipAmount));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendInvoice needEmail(boolean needEmail) {
        return (SendInvoice) applySelf(new C06135(needEmail));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendInvoice needName(boolean needName) {
        return (SendInvoice) applySelf(new C06145(needName));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendInvoice needPhoneNumber(boolean needPhoneNumber) {
        return (SendInvoice) applySelf(new C06155(needPhoneNumber));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendInvoice needShippingAddress(boolean needShippingAddress) {
        return (SendInvoice) applySelf(new C06165(needShippingAddress));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendInvoice photoHeight(int photoHeight) {
        return (SendInvoice) applySelf(new C06175(photoHeight));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendInvoice photoSize(int photoSize) {
        return (SendInvoice) applySelf(new C06185(photoSize));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendInvoice photoUrl(String photoUrl) {
        m.f(photoUrl, "photoUrl");
        return (SendInvoice) applySelf(new C06195(photoUrl));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendInvoice photoWidth(int photoWidth) {
        return (SendInvoice) applySelf(new C06205(photoWidth));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendInvoice providerData(String providerData) {
        m.f(providerData, "providerData");
        return (SendInvoice) applySelf(new C06215(providerData));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendInvoice providerToken(String providerToken) {
        m.f(providerToken, "providerToken");
        return (SendInvoice) applySelf(new C06225(providerToken));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendInvoice sendEmailToProvider(boolean sendEmailToProvider) {
        return (SendInvoice) applySelf(new C06235(sendEmailToProvider));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendInvoice sendPhoneNumberToProvider(boolean sendPhoneNumberToProvider) {
        return (SendInvoice) applySelf(new C06245(sendPhoneNumberToProvider));
    }

    public final void setFlexible(Boolean bool) {
        this.isFlexible.setValue(this, $$delegatedProperties[19], bool);
    }

    public final void setMaxTipAmount(Integer num) {
        this.maxTipAmount.setValue(this, $$delegatedProperties[7], num);
    }

    public final void setNeedEmail(Boolean bool) {
        this.needEmail.setValue(this, $$delegatedProperties[15], bool);
    }

    public final void setNeedName(Boolean bool) {
        this.needName.setValue(this, $$delegatedProperties[13], bool);
    }

    public final void setNeedPhoneNumber(Boolean bool) {
        this.needPhoneNumber.setValue(this, $$delegatedProperties[14], bool);
    }

    public final void setNeedShippingAddress(Boolean bool) {
        this.needShippingAddress.setValue(this, $$delegatedProperties[16], bool);
    }

    public final void setPhotoHeight(Integer num) {
        this.photoHeight.setValue(this, $$delegatedProperties[12], num);
    }

    public final void setPhotoSize(Integer num) {
        this.photoSize.setValue(this, $$delegatedProperties[10], num);
    }

    public final void setPhotoUrl(String str) {
        this.photoUrl.setValue(this, $$delegatedProperties[9], str);
    }

    public final void setPhotoWidth(Integer num) {
        this.photoWidth.setValue(this, $$delegatedProperties[11], num);
    }

    public final void setProviderData(String str) {
        this.providerData.setValue(this, $$delegatedProperties[6], str);
    }

    public final void setProviderToken(String str) {
        this.providerToken.setValue(this, $$delegatedProperties[5], str);
    }

    public final void setSendEmailToProvider(Boolean bool) {
        this.sendEmailToProvider.setValue(this, $$delegatedProperties[17], bool);
    }

    public final void setSendPhoneNumberToProvider(Boolean bool) {
        this.sendPhoneNumberToProvider.setValue(this, $$delegatedProperties[18], bool);
    }

    public final void setStartParameter(String str) {
        this.startParameter.setValue(this, $$delegatedProperties[21], str);
    }

    public final void setSubscriptionPeriod(Integer num) {
        this.subscriptionPeriod.setValue(this, $$delegatedProperties[20], num);
    }

    public final void setSuggestedTipAmounts(List<Integer> list) {
        this.suggestedTipAmounts.setValue(this, $$delegatedProperties[8], list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendInvoice startParameter(String startParameter) {
        m.f(startParameter, "startParameter");
        return (SendInvoice) applySelf(new C06255(startParameter));
    }

    public final SendInvoice suggestedTipAmounts(Integer[] suggestedTipAmounts) {
        m.f(suggestedTipAmounts, "suggestedTipAmounts");
        return suggestedTipAmounts(j.E0(suggestedTipAmounts));
    }

    public final SendInvoice suggestedTipAmounts(int... suggestedTipAmounts) {
        m.f(suggestedTipAmounts, "suggestedTipAmounts");
        return suggestedTipAmounts(j.C0(suggestedTipAmounts));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendInvoice(long j10, String title, String description, String payload, String currency, List<? extends LabeledPrice> prices) {
        this(Long.valueOf(j10), null, title, description, payload, currency, prices);
        m.f(title, "title");
        m.f(description, "description");
        m.f(payload, "payload");
        m.f(currency, "currency");
        m.f(prices, "prices");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendInvoice(String channelUsername, String title, String description, String payload, String currency, List<? extends LabeledPrice> prices) {
        this(null, channelUsername, title, description, payload, currency, prices);
        m.f(channelUsername, "channelUsername");
        m.f(title, "title");
        m.f(description, "description");
        m.f(payload, "payload");
        m.f(currency, "currency");
        m.f(prices, "prices");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendInvoice(Object chatId, String title, String description, String payload, String currency, LabeledPrice... prices) {
        m.f(chatId, "chatId");
        m.f(title, "title");
        m.f(description, "description");
        m.f(payload, "payload");
        m.f(currency, "currency");
        m.f(prices, "prices");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null, title, description, payload, currency, j.E0(prices));
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }
}
