package com.pengrad.telegrambot.request;

import c9.l;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegate;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegateKt;
import i9.k;
import kotlin.Metadata;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.w;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b \u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nB/\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\fB/\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\u000eB?\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\bJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\bJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\bR\u001b\u0010\t\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R/\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0018R/\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0018R/\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u0013\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0018R/\u0010\"\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0013\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010\u0018R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0013\u001a\u0004\b&\u0010'R\u001b\u0010\u0006\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0013\u001a\u0004\b)\u0010'R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0013\u001a\u0004\b+\u0010\u0011¨\u0006-"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVenue;", "Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "chatId", "", "latitude", "", "longitude", "title", "", "address", "(JFFLjava/lang/String;Ljava/lang/String;)V", "channelUsername", "(Ljava/lang/String;FFLjava/lang/String;Ljava/lang/String;)V", "", "(Ljava/lang/Object;FFLjava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/Long;Ljava/lang/String;FFLjava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "address$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "<set-?>", "foursquareId", "getFoursquareId", "setFoursquareId", "(Ljava/lang/String;)V", "foursquareId$delegate", "foursquareType", "getFoursquareType", "setFoursquareType", "foursquareType$delegate", "googlePlaceId", "getGooglePlaceId", "setGooglePlaceId", "googlePlaceId$delegate", "googlePlaceType", "getGooglePlaceType", "setGooglePlaceType", "googlePlaceType$delegate", "getLatitude", "()F", "latitude$delegate", "getLongitude", "longitude$delegate", "getTitle", "title$delegate", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SendVenue extends AbstractSendRequest<SendVenue> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(SendVenue.class, "latitude", "getLatitude()F", 0)), c0.g(new w(SendVenue.class, "longitude", "getLongitude()F", 0)), c0.g(new w(SendVenue.class, "title", "getTitle()Ljava/lang/String;", 0)), c0.g(new w(SendVenue.class, "address", "getAddress()Ljava/lang/String;", 0)), c0.e(new q(SendVenue.class, "foursquareId", "getFoursquareId()Ljava/lang/String;", 0)), c0.e(new q(SendVenue.class, "foursquareType", "getFoursquareType()Ljava/lang/String;", 0)), c0.e(new q(SendVenue.class, "googlePlaceId", "getGooglePlaceId()Ljava/lang/String;", 0)), c0.e(new q(SendVenue.class, "googlePlaceType", "getGooglePlaceType()Ljava/lang/String;", 0))};

    /* JADX INFO: renamed from: address$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate address;

    /* JADX INFO: renamed from: foursquareId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate foursquareId;

    /* JADX INFO: renamed from: foursquareType$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate foursquareType;

    /* JADX INFO: renamed from: googlePlaceId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate googlePlaceId;

    /* JADX INFO: renamed from: googlePlaceType$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate googlePlaceType;

    /* JADX INFO: renamed from: latitude$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate latitude;

    /* JADX INFO: renamed from: longitude$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate longitude;

    /* JADX INFO: renamed from: title$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate title;

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendVenue$foursquareId$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVenue;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendVenue;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass5 extends o implements l<SendVenue, z> {
        final /* synthetic */ String $foursquareId;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendVenue sendVenue) {
            invoke2(sendVenue);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(String str) {
            super(1);
            this.$foursquareId = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendVenue applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setFoursquareId(this.$foursquareId);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendVenue$foursquareType$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVenue;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendVenue;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06475 extends o implements l<SendVenue, z> {
        final /* synthetic */ String $foursquareType;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendVenue sendVenue) {
            invoke2(sendVenue);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06475(String str) {
            super(1);
            this.$foursquareType = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendVenue applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setFoursquareType(this.$foursquareType);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendVenue$googlePlaceId$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVenue;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendVenue;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06485 extends o implements l<SendVenue, z> {
        final /* synthetic */ String $googlePlaceId;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendVenue sendVenue) {
            invoke2(sendVenue);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06485(String str) {
            super(1);
            this.$googlePlaceId = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendVenue applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setGooglePlaceId(this.$googlePlaceId);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendVenue$googlePlaceType$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVenue;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendVenue;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06495 extends o implements l<SendVenue, z> {
        final /* synthetic */ String $googlePlaceType;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendVenue sendVenue) {
            invoke2(sendVenue);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06495(String str) {
            super(1);
            this.$googlePlaceType = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendVenue applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setGooglePlaceType(this.$googlePlaceType);
        }
    }

    /* synthetic */ SendVenue(Long l10, String str, float f10, float f11, String str2, String str3, int i10, g gVar) {
        this((i10 & 1) != 0 ? null : l10, (i10 & 2) != 0 ? null : str, f10, f11, str2, str3);
    }

    private SendVenue(Long l10, String str, float f10, float f11, String str2, String str3) {
        super(l10, str);
        RequestParameterDelegate requestParameterDelegateRequestParameter$default = RequestParameterDelegateKt.requestParameter$default(Float.valueOf(f10), null, 2, null);
        k<?>[] kVarArr = $$delegatedProperties;
        this.latitude = requestParameterDelegateRequestParameter$default.provideDelegate(this, kVarArr[0]);
        this.longitude = RequestParameterDelegateKt.requestParameter$default(Float.valueOf(f11), null, 2, null).provideDelegate(this, kVarArr[1]);
        this.title = RequestParameterDelegateKt.requestParameter$default(str2, null, 2, null).provideDelegate(this, kVarArr[2]);
        this.address = RequestParameterDelegateKt.requestParameter$default(str3, null, 2, null).provideDelegate(this, kVarArr[3]);
        this.foursquareId = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[4]);
        this.foursquareType = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[5]);
        this.googlePlaceId = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[6]);
        this.googlePlaceType = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[7]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendVenue foursquareId(String foursquareId) {
        m.f(foursquareId, "foursquareId");
        return (SendVenue) applySelf(new AnonymousClass5(foursquareId));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendVenue foursquareType(String foursquareType) {
        m.f(foursquareType, "foursquareType");
        return (SendVenue) applySelf(new C06475(foursquareType));
    }

    public final String getAddress() {
        return (String) this.address.getValue(this, $$delegatedProperties[3]);
    }

    public final String getFoursquareId() {
        return (String) this.foursquareId.getValue(this, $$delegatedProperties[4]);
    }

    public final String getFoursquareType() {
        return (String) this.foursquareType.getValue(this, $$delegatedProperties[5]);
    }

    public final String getGooglePlaceId() {
        return (String) this.googlePlaceId.getValue(this, $$delegatedProperties[6]);
    }

    public final String getGooglePlaceType() {
        return (String) this.googlePlaceType.getValue(this, $$delegatedProperties[7]);
    }

    public final float getLatitude() {
        return ((Number) this.latitude.getValue(this, $$delegatedProperties[0])).floatValue();
    }

    public final float getLongitude() {
        return ((Number) this.longitude.getValue(this, $$delegatedProperties[1])).floatValue();
    }

    public final String getTitle() {
        return (String) this.title.getValue(this, $$delegatedProperties[2]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendVenue googlePlaceId(String googlePlaceId) {
        m.f(googlePlaceId, "googlePlaceId");
        return (SendVenue) applySelf(new C06485(googlePlaceId));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendVenue googlePlaceType(String googlePlaceType) {
        m.f(googlePlaceType, "googlePlaceType");
        return (SendVenue) applySelf(new C06495(googlePlaceType));
    }

    public final void setFoursquareId(String str) {
        this.foursquareId.setValue(this, $$delegatedProperties[4], str);
    }

    public final void setFoursquareType(String str) {
        this.foursquareType.setValue(this, $$delegatedProperties[5], str);
    }

    public final void setGooglePlaceId(String str) {
        this.googlePlaceId.setValue(this, $$delegatedProperties[6], str);
    }

    public final void setGooglePlaceType(String str) {
        this.googlePlaceType.setValue(this, $$delegatedProperties[7], str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendVenue(long j10, float f10, float f11, String title, String address) {
        this(Long.valueOf(j10), null, f10, f11, title, address);
        m.f(title, "title");
        m.f(address, "address");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendVenue(String channelUsername, float f10, float f11, String title, String address) {
        this(null, channelUsername, f10, f11, title, address);
        m.f(channelUsername, "channelUsername");
        m.f(title, "title");
        m.f(address, "address");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendVenue(Object chatId, float f10, float f11, String title, String address) {
        m.f(chatId, "chatId");
        m.f(title, "title");
        m.f(address, "address");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null, f10, f11, title, address);
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }
}
