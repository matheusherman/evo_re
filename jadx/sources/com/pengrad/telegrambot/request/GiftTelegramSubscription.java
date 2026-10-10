package com.pengrad.telegrambot.request;

import c9.l;
import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegate;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegateKt;
import i9.k;
import kotlin.Metadata;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.w;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bBC\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0002\u0010\u000fJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u0019\u0010\f\u001a\u00020\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010'J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nR\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0007\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0014\u0010\u0011R/\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR;\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u0013\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR/\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0013\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0013\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/pengrad/telegrambot/request/GiftTelegramSubscription;", "Lcom/pengrad/telegrambot/request/KBaseRequest;", "Lcom/pengrad/telegrambot/response/BaseResponse;", "userId", "", "monthCount", "", "starCount", "(JII)V", "text", "", "textParseMode", "textEntities", "", "Lcom/pengrad/telegrambot/model/MessageEntity;", "(JIILjava/lang/String;Ljava/lang/String;[Lcom/pengrad/telegrambot/model/MessageEntity;)V", "getMonthCount", "()I", "monthCount$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "getStarCount", "starCount$delegate", "<set-?>", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "text$delegate", "getTextEntities", "()[Lcom/pengrad/telegrambot/model/MessageEntity;", "setTextEntities", "([Lcom/pengrad/telegrambot/model/MessageEntity;)V", "textEntities$delegate", "getTextParseMode", "setTextParseMode", "textParseMode$delegate", "getUserId", "()J", "userId$delegate", "([Lcom/pengrad/telegrambot/model/MessageEntity;)Lcom/pengrad/telegrambot/request/GiftTelegramSubscription;", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GiftTelegramSubscription extends KBaseRequest<GiftTelegramSubscription, BaseResponse> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(GiftTelegramSubscription.class, "userId", "getUserId()J", 0)), c0.g(new w(GiftTelegramSubscription.class, "monthCount", "getMonthCount()I", 0)), c0.g(new w(GiftTelegramSubscription.class, "starCount", "getStarCount()I", 0)), c0.e(new q(GiftTelegramSubscription.class, "text", "getText()Ljava/lang/String;", 0)), c0.e(new q(GiftTelegramSubscription.class, "textParseMode", "getTextParseMode()Ljava/lang/String;", 0)), c0.e(new q(GiftTelegramSubscription.class, "textEntities", "getTextEntities()[Lcom/pengrad/telegrambot/model/MessageEntity;", 0))};

    /* JADX INFO: renamed from: monthCount$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate monthCount;

    /* JADX INFO: renamed from: starCount$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate starCount;

    /* JADX INFO: renamed from: text$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate text;

    /* JADX INFO: renamed from: textEntities$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate textEntities;

    /* JADX INFO: renamed from: textParseMode$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate textParseMode;

    /* JADX INFO: renamed from: userId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate userId;

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.GiftTelegramSubscription$text$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/GiftTelegramSubscription;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/GiftTelegramSubscription;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass5 extends o implements l<GiftTelegramSubscription, z> {
        final /* synthetic */ String $text;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(GiftTelegramSubscription giftTelegramSubscription) {
            invoke2(giftTelegramSubscription);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(String str) {
            super(1);
            this.$text = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GiftTelegramSubscription applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setText(this.$text);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.GiftTelegramSubscription$textEntities$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/GiftTelegramSubscription;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/GiftTelegramSubscription;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06025 extends o implements l<GiftTelegramSubscription, z> {
        final /* synthetic */ MessageEntity[] $textEntities;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(GiftTelegramSubscription giftTelegramSubscription) {
            invoke2(giftTelegramSubscription);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06025(MessageEntity[] messageEntityArr) {
            super(1);
            this.$textEntities = messageEntityArr;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GiftTelegramSubscription applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setTextEntities(this.$textEntities);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.GiftTelegramSubscription$textParseMode$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/GiftTelegramSubscription;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/GiftTelegramSubscription;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06035 extends o implements l<GiftTelegramSubscription, z> {
        final /* synthetic */ String $textParseMode;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(GiftTelegramSubscription giftTelegramSubscription) {
            invoke2(giftTelegramSubscription);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06035(String str) {
            super(1);
            this.$textParseMode = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GiftTelegramSubscription applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setTextParseMode(this.$textParseMode);
        }
    }

    private GiftTelegramSubscription(long j10, int i10, int i11, String str, String str2, MessageEntity[] messageEntityArr) {
        super(c0.b(BaseResponse.class));
        RequestParameterDelegate requestParameterDelegateRequestParameter = RequestParameterDelegateKt.requestParameter(Long.valueOf(j10), "user_id");
        k<?>[] kVarArr = $$delegatedProperties;
        this.userId = requestParameterDelegateRequestParameter.provideDelegate(this, kVarArr[0]);
        this.monthCount = RequestParameterDelegateKt.requestParameter(Integer.valueOf(i10), "month_count").provideDelegate(this, kVarArr[1]);
        this.starCount = RequestParameterDelegateKt.requestParameter(Integer.valueOf(i11), "star_count").provideDelegate(this, kVarArr[2]);
        this.text = RequestParameterDelegateKt.optionalRequestParameter$default(str, "text", null, 4, null).provideDelegate(this, kVarArr[3]);
        this.textParseMode = RequestParameterDelegateKt.optionalRequestParameter$default(str2, "text_parse_mode", null, 4, null).provideDelegate(this, kVarArr[4]);
        this.textEntities = RequestParameterDelegateKt.optionalRequestParameter$default(messageEntityArr, "text_entities", null, 4, null).provideDelegate(this, kVarArr[5]);
    }

    public final int getMonthCount() {
        return ((Number) this.monthCount.getValue(this, $$delegatedProperties[1])).intValue();
    }

    public final int getStarCount() {
        return ((Number) this.starCount.getValue(this, $$delegatedProperties[2])).intValue();
    }

    public final String getText() {
        return (String) this.text.getValue(this, $$delegatedProperties[3]);
    }

    public final MessageEntity[] getTextEntities() {
        return (MessageEntity[]) this.textEntities.getValue(this, $$delegatedProperties[5]);
    }

    public final String getTextParseMode() {
        return (String) this.textParseMode.getValue(this, $$delegatedProperties[4]);
    }

    public final long getUserId() {
        return ((Number) this.userId.getValue(this, $$delegatedProperties[0])).longValue();
    }

    public final void setText(String str) {
        this.text.setValue(this, $$delegatedProperties[3], str);
    }

    public final void setTextEntities(MessageEntity[] messageEntityArr) {
        this.textEntities.setValue(this, $$delegatedProperties[5], messageEntityArr);
    }

    public final void setTextParseMode(String str) {
        this.textParseMode.setValue(this, $$delegatedProperties[4], str);
    }

    public final GiftTelegramSubscription text(String text) {
        m.f(text, "text");
        return applySelf(new AnonymousClass5(text));
    }

    public final GiftTelegramSubscription textEntities(MessageEntity[] textEntities) {
        m.f(textEntities, "textEntities");
        return applySelf(new C06025(textEntities));
    }

    public final GiftTelegramSubscription textParseMode(String textParseMode) {
        m.f(textParseMode, "textParseMode");
        return applySelf(new C06035(textParseMode));
    }

    public GiftTelegramSubscription(long j10, int i10, int i11) {
        this(j10, i10, i11, null, null, null);
    }
}
