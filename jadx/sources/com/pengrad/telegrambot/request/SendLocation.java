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
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\nB\u001f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u000b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\fB/\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\rJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0005J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u000fJ\u000e\u0010&\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u000fR/\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R/\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b\u001d\u0010\u001eR/\u0010 \u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0016\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001b\u0010\u0006\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0016\u001a\u0004\b$\u0010\u001eR/\u0010&\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b)\u0010\u0016\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010\u0014¨\u0006*"}, d2 = {"Lcom/pengrad/telegrambot/request/SendLocation;", "Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "chatId", "", "latitude", "", "longitude", "(JFF)V", "channelUsername", "", "(Ljava/lang/String;FF)V", "", "(Ljava/lang/Object;FF)V", "(Ljava/lang/Long;Ljava/lang/String;FF)V", "<set-?>", "", "heading", "getHeading", "()Ljava/lang/Integer;", "setHeading", "(Ljava/lang/Integer;)V", "heading$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "horizontalAccuracy", "getHorizontalAccuracy", "()Ljava/lang/Float;", "setHorizontalAccuracy", "(Ljava/lang/Float;)V", "horizontalAccuracy$delegate", "getLatitude", "()F", "latitude$delegate", "livePeriod", "getLivePeriod", "setLivePeriod", "livePeriod$delegate", "getLongitude", "longitude$delegate", "proximityAlertRadius", "getProximityAlertRadius", "setProximityAlertRadius", "proximityAlertRadius$delegate", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SendLocation extends AbstractSendRequest<SendLocation> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(SendLocation.class, "latitude", "getLatitude()F", 0)), c0.g(new w(SendLocation.class, "longitude", "getLongitude()F", 0)), c0.e(new q(SendLocation.class, "horizontalAccuracy", "getHorizontalAccuracy()Ljava/lang/Float;", 0)), c0.e(new q(SendLocation.class, "livePeriod", "getLivePeriod()Ljava/lang/Integer;", 0)), c0.e(new q(SendLocation.class, "heading", "getHeading()Ljava/lang/Integer;", 0)), c0.e(new q(SendLocation.class, "proximityAlertRadius", "getProximityAlertRadius()Ljava/lang/Integer;", 0))};

    /* JADX INFO: renamed from: heading$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate heading;

    /* JADX INFO: renamed from: horizontalAccuracy$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate horizontalAccuracy;

    /* JADX INFO: renamed from: latitude$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate latitude;

    /* JADX INFO: renamed from: livePeriod$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate livePeriod;

    /* JADX INFO: renamed from: longitude$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate longitude;

    /* JADX INFO: renamed from: proximityAlertRadius$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate proximityAlertRadius;

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendLocation$heading$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendLocation;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendLocation;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass5 extends o implements l<SendLocation, z> {
        final /* synthetic */ int $heading;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendLocation sendLocation) {
            invoke2(sendLocation);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(int i10) {
            super(1);
            this.$heading = i10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendLocation applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setHeading(Integer.valueOf(this.$heading));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendLocation$horizontalAccuracy$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendLocation;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendLocation;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06275 extends o implements l<SendLocation, z> {
        final /* synthetic */ float $horizontalAccuracy;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendLocation sendLocation) {
            invoke2(sendLocation);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06275(float f10) {
            super(1);
            this.$horizontalAccuracy = f10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendLocation applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setHorizontalAccuracy(Float.valueOf(this.$horizontalAccuracy));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendLocation$livePeriod$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendLocation;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendLocation;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06285 extends o implements l<SendLocation, z> {
        final /* synthetic */ int $livePeriod;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendLocation sendLocation) {
            invoke2(sendLocation);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06285(int i10) {
            super(1);
            this.$livePeriod = i10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendLocation applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setLivePeriod(Integer.valueOf(this.$livePeriod));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendLocation$proximityAlertRadius$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendLocation;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendLocation;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06295 extends o implements l<SendLocation, z> {
        final /* synthetic */ int $proximityAlertRadius;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendLocation sendLocation) {
            invoke2(sendLocation);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06295(int i10) {
            super(1);
            this.$proximityAlertRadius = i10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendLocation applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setProximityAlertRadius(Integer.valueOf(this.$proximityAlertRadius));
        }
    }

    /* synthetic */ SendLocation(Long l10, String str, float f10, float f11, int i10, g gVar) {
        this((i10 & 1) != 0 ? null : l10, (i10 & 2) != 0 ? null : str, f10, f11);
    }

    private SendLocation(Long l10, String str, float f10, float f11) {
        super(l10, str);
        RequestParameterDelegate requestParameterDelegateRequestParameter$default = RequestParameterDelegateKt.requestParameter$default(Float.valueOf(f10), null, 2, null);
        k<?>[] kVarArr = $$delegatedProperties;
        this.latitude = requestParameterDelegateRequestParameter$default.provideDelegate(this, kVarArr[0]);
        this.longitude = RequestParameterDelegateKt.requestParameter$default(Float.valueOf(f11), null, 2, null).provideDelegate(this, kVarArr[1]);
        this.horizontalAccuracy = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[2]);
        this.livePeriod = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[3]);
        this.heading = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[4]);
        this.proximityAlertRadius = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[5]);
    }

    public final Integer getHeading() {
        return (Integer) this.heading.getValue(this, $$delegatedProperties[4]);
    }

    public final Float getHorizontalAccuracy() {
        return (Float) this.horizontalAccuracy.getValue(this, $$delegatedProperties[2]);
    }

    public final float getLatitude() {
        return ((Number) this.latitude.getValue(this, $$delegatedProperties[0])).floatValue();
    }

    public final Integer getLivePeriod() {
        return (Integer) this.livePeriod.getValue(this, $$delegatedProperties[3]);
    }

    public final float getLongitude() {
        return ((Number) this.longitude.getValue(this, $$delegatedProperties[1])).floatValue();
    }

    public final Integer getProximityAlertRadius() {
        return (Integer) this.proximityAlertRadius.getValue(this, $$delegatedProperties[5]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendLocation heading(int heading) {
        return (SendLocation) applySelf(new AnonymousClass5(heading));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendLocation horizontalAccuracy(float horizontalAccuracy) {
        return (SendLocation) applySelf(new C06275(horizontalAccuracy));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendLocation livePeriod(int livePeriod) {
        return (SendLocation) applySelf(new C06285(livePeriod));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendLocation proximityAlertRadius(int proximityAlertRadius) {
        return (SendLocation) applySelf(new C06295(proximityAlertRadius));
    }

    public final void setHeading(Integer num) {
        this.heading.setValue(this, $$delegatedProperties[4], num);
    }

    public final void setHorizontalAccuracy(Float f10) {
        this.horizontalAccuracy.setValue(this, $$delegatedProperties[2], f10);
    }

    public final void setLivePeriod(Integer num) {
        this.livePeriod.setValue(this, $$delegatedProperties[3], num);
    }

    public final void setProximityAlertRadius(Integer num) {
        this.proximityAlertRadius.setValue(this, $$delegatedProperties[5], num);
    }

    public SendLocation(long j10, float f10, float f11) {
        this(Long.valueOf(j10), null, f10, f11);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendLocation(String channelUsername, float f10, float f11) {
        this(null, channelUsername, f10, f11);
        m.f(channelUsername, "channelUsername");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendLocation(Object chatId, float f10, float f11) {
        m.f(chatId, "chatId");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null, f10, f11);
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }
}
