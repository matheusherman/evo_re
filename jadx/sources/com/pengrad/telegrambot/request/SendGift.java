package com.pengrad.telegrambot.request;

import c9.l;
import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.response.BaseResponse;
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

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 52\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0017\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\tB3\b\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0006J\u0019\u0010$\u001a\u00020\u00002\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"¢\u0006\u0002\u00103J\u000e\u0010+\u001a\u00020\u00002\u0006\u00104\u001a\u00020*R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0013\u0010\rR/\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00168F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR/\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u000f\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010 R;\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b)\u0010\u000f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R/\u0010+\u001a\u0004\u0018\u00010*2\b\u0010\u0015\u001a\u0004\u0018\u00010*8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b0\u0010\u000f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001d\u0010\n\u001a\u0004\u0018\u00010\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u000f\u001a\u0004\b1\u0010\u0011¨\u00066"}, d2 = {"Lcom/pengrad/telegrambot/request/SendGift;", "Lcom/pengrad/telegrambot/request/KBaseRequest;", "Lcom/pengrad/telegrambot/response/BaseResponse;", "chatId", "", "giftId", "", "(JLjava/lang/String;)V", "channelUsername", "(Ljava/lang/String;Ljava/lang/String;)V", "userId", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getChannelUsername", "()Ljava/lang/String;", "channelUsername$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "getChatId", "()Ljava/lang/Long;", "chatId$delegate", "getGiftId", "giftId$delegate", "<set-?>", "", "payForUpgrade", "getPayForUpgrade", "()Ljava/lang/Boolean;", "setPayForUpgrade", "(Ljava/lang/Boolean;)V", "payForUpgrade$delegate", "text", "getText", "setText", "(Ljava/lang/String;)V", "text$delegate", "", "Lcom/pengrad/telegrambot/model/MessageEntity;", "textEntities", "getTextEntities", "()[Lcom/pengrad/telegrambot/model/MessageEntity;", "setTextEntities", "([Lcom/pengrad/telegrambot/model/MessageEntity;)V", "textEntities$delegate", "Lcom/pengrad/telegrambot/model/request/ParseMode;", "textParseMode", "getTextParseMode", "()Lcom/pengrad/telegrambot/model/request/ParseMode;", "setTextParseMode", "(Lcom/pengrad/telegrambot/model/request/ParseMode;)V", "textParseMode$delegate", "getUserId", "userId$delegate", "([Lcom/pengrad/telegrambot/model/MessageEntity;)Lcom/pengrad/telegrambot/request/SendGift;", "parseMode", "Companion", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SendGift extends KBaseRequest<SendGift, BaseResponse> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(SendGift.class, "userId", "getUserId()Ljava/lang/Long;", 0)), c0.g(new w(SendGift.class, "chatId", "getChatId()Ljava/lang/Long;", 0)), c0.g(new w(SendGift.class, "channelUsername", "getChannelUsername()Ljava/lang/String;", 0)), c0.g(new w(SendGift.class, "giftId", "getGiftId()Ljava/lang/String;", 0)), c0.e(new q(SendGift.class, "payForUpgrade", "getPayForUpgrade()Ljava/lang/Boolean;", 0)), c0.e(new q(SendGift.class, "text", "getText()Ljava/lang/String;", 0)), c0.e(new q(SendGift.class, "textParseMode", "getTextParseMode()Lcom/pengrad/telegrambot/model/request/ParseMode;", 0)), c0.e(new q(SendGift.class, "textEntities", "getTextEntities()[Lcom/pengrad/telegrambot/model/MessageEntity;", 0))};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: channelUsername$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate channelUsername;

    /* JADX INFO: renamed from: chatId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate chatId;

    /* JADX INFO: renamed from: giftId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate giftId;

    /* JADX INFO: renamed from: payForUpgrade$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate payForUpgrade;

    /* JADX INFO: renamed from: text$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate text;

    /* JADX INFO: renamed from: textEntities$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate textEntities;

    /* JADX INFO: renamed from: textParseMode$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate textParseMode;

    /* JADX INFO: renamed from: userId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate userId;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0019\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0087\u0002¨\u0006\u000e"}, d2 = {"Lcom/pengrad/telegrambot/request/SendGift$Companion;", "", "()V", "fromChannel", "Lcom/pengrad/telegrambot/request/SendGift;", "channelUsername", "", "giftId", "fromChatId", "chatId", "", "fromUserId", "userId", "invoke", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }

        public final SendGift fromChannel(String channelUsername, String giftId) {
            m.f(channelUsername, "channelUsername");
            m.f(giftId, "giftId");
            return new SendGift(channelUsername, giftId);
        }

        public final SendGift fromChatId(long chatId, String giftId) {
            m.f(giftId, "giftId");
            return new SendGift(chatId, giftId);
        }

        public final SendGift fromUserId(long userId, String giftId) {
            m.f(giftId, "giftId");
            return new SendGift(Long.valueOf(userId), null, null, giftId, 6, null);
        }

        public final SendGift invoke(long userId, String giftId) {
            m.f(giftId, "giftId");
            return fromUserId(userId, giftId);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendGift$textParseMode$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/pengrad/telegrambot/model/request/ParseMode;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass2 extends o implements l<ParseMode, Object> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1);
        }

        @Override // c9.l
        public final Object invoke(ParseMode parseMode) {
            if (parseMode != null) {
                return parseMode.name();
            }
            return null;
        }
    }

    /* synthetic */ SendGift(Long l10, Long l11, String str, String str2, int i10, g gVar) {
        this((i10 & 1) != 0 ? null : l10, (i10 & 2) != 0 ? null : l11, (i10 & 4) != 0 ? null : str, str2);
    }

    private SendGift(Long l10, Long l11, String str, String str2) {
        super(c0.b(BaseResponse.class));
        RequestParameterDelegate requestParameterDelegateOptionalRequestParameter$default = RequestParameterDelegateKt.optionalRequestParameter$default(l10, null, null, 6, null);
        k<?>[] kVarArr = $$delegatedProperties;
        this.userId = requestParameterDelegateOptionalRequestParameter$default.provideDelegate(this, kVarArr[0]);
        this.chatId = RequestParameterDelegateKt.optionalRequestParameter$default(l11, "chat_id", null, 4, null).provideDelegate(this, kVarArr[1]);
        this.channelUsername = RequestParameterDelegateKt.optionalRequestParameter$default(str, "chat_id", null, 4, null).provideDelegate(this, kVarArr[2]);
        this.giftId = RequestParameterDelegateKt.requestParameter$default(str2, null, 2, null).provideDelegate(this, kVarArr[3]);
        this.payForUpgrade = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[4]);
        this.text = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[5]);
        this.textParseMode = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, AnonymousClass2.INSTANCE, 3, null).provideDelegate(this, kVarArr[6]);
        this.textEntities = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[7]);
    }

    public static final SendGift fromChannel(String str, String str2) {
        return INSTANCE.fromChannel(str, str2);
    }

    public static final SendGift fromChatId(long j10, String str) {
        return INSTANCE.fromChatId(j10, str);
    }

    public static final SendGift fromUserId(long j10, String str) {
        return INSTANCE.fromUserId(j10, str);
    }

    public final String getChannelUsername() {
        return (String) this.channelUsername.getValue(this, $$delegatedProperties[2]);
    }

    public final Long getChatId() {
        return (Long) this.chatId.getValue(this, $$delegatedProperties[1]);
    }

    public final String getGiftId() {
        return (String) this.giftId.getValue(this, $$delegatedProperties[3]);
    }

    public final Boolean getPayForUpgrade() {
        return (Boolean) this.payForUpgrade.getValue(this, $$delegatedProperties[4]);
    }

    public final String getText() {
        return (String) this.text.getValue(this, $$delegatedProperties[5]);
    }

    public final MessageEntity[] getTextEntities() {
        return (MessageEntity[]) this.textEntities.getValue(this, $$delegatedProperties[7]);
    }

    public final ParseMode getTextParseMode() {
        return (ParseMode) this.textParseMode.getValue(this, $$delegatedProperties[6]);
    }

    public final Long getUserId() {
        return (Long) this.userId.getValue(this, $$delegatedProperties[0]);
    }

    public final void setPayForUpgrade(Boolean bool) {
        this.payForUpgrade.setValue(this, $$delegatedProperties[4], bool);
    }

    public final void setText(String str) {
        this.text.setValue(this, $$delegatedProperties[5], str);
    }

    public final void setTextEntities(MessageEntity[] messageEntityArr) {
        this.textEntities.setValue(this, $$delegatedProperties[7], messageEntityArr);
    }

    public final void setTextParseMode(ParseMode parseMode) {
        this.textParseMode.setValue(this, $$delegatedProperties[6], parseMode);
    }

    public final SendGift text(String text) {
        m.f(text, "text");
        setText(text);
        return this;
    }

    public final SendGift textEntities(MessageEntity[] textEntities) {
        m.f(textEntities, "textEntities");
        setTextEntities(textEntities);
        return this;
    }

    public final SendGift textParseMode(ParseMode parseMode) {
        m.f(parseMode, "parseMode");
        setTextParseMode(parseMode);
        return this;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendGift(long j10, String giftId) {
        this(null, Long.valueOf(j10), null, giftId);
        m.f(giftId, "giftId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendGift(String channelUsername, String giftId) {
        this(null, null, channelUsername, giftId);
        m.f(channelUsername, "channelUsername");
        m.f(giftId, "giftId");
    }
}
