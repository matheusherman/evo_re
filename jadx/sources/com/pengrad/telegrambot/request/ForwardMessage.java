package com.pengrad.telegrambot.request;

import c9.l;
import com.pengrad.telegrambot.response.SendResponse;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u001c\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB+\b\u0016\u0012\n\u0010\u0003\u001a\u00060\tj\u0002`\n\u0012\n\u0010\u0005\u001a\u00060\tj\u0002`\n\u0012\n\u0010\u0006\u001a\u00060\u000bj\u0002`\f¢\u0006\u0002\u0010\rB\u001f\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0010B'\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\n\u0010\u0005\u001a\u00060\tj\u0002`\n\u0012\n\u0010\u0006\u001a\u00060\u000bj\u0002`\f¢\u0006\u0002\u0010\u0011B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0013B'\b\u0016\u0012\n\u0010\u0003\u001a\u00060\tj\u0002`\n\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\n\u0010\u0006\u001a\u00060\u000bj\u0002`\f¢\u0006\u0002\u0010\u0014B\u001f\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0015B#\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\n\u0010\u0006\u001a\u00060\u000bj\u0002`\f¢\u0006\u0002\u0010\u0016B\u001f\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0018B#\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0017\u0012\n\u0010\u0006\u001a\u00060\u000bj\u0002`\f¢\u0006\u0002\u0010\u0019B7\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u001aJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010$\u001a\u00020#J\u000e\u00101\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0007J\u000e\u00107\u001a\u00020\u00002\u0006\u00107\u001a\u00020#J\u000e\u0010;\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u0007R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b\u001f\u0010 R/\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\"\u001a\u0004\u0018\u00010#8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b)\u0010\u001e\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u001e\u001a\u0004\b*\u0010\u001cR\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u001e\u001a\u0004\b,\u0010 R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u001e\u001a\u0004\b.\u0010/R/\u00101\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b6\u0010\u001e\u001a\u0004\b2\u00103\"\u0004\b4\u00105R/\u00107\u001a\u0004\u0018\u00010#2\b\u0010\"\u001a\u0004\u0018\u00010#8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b:\u0010\u001e\u001a\u0004\b8\u0010&\"\u0004\b9\u0010(R/\u0010;\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b>\u0010\u001e\u001a\u0004\b<\u00103\"\u0004\b=\u00105¨\u0006?"}, d2 = {"Lcom/pengrad/telegrambot/request/ForwardMessage;", "Lcom/pengrad/telegrambot/request/KBaseRequest;", "Lcom/pengrad/telegrambot/response/SendResponse;", "chatId", "", "fromChatId", "messageId", "", "(JJI)V", "Ljava/lang/Long;", "Lcom/pengrad/telegrambot/utility/kotlin/JavaLong;", "Ljava/lang/Integer;", "Lcom/pengrad/telegrambot/utility/kotlin/JavaInteger;", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)V", "channelUsername", "", "(Ljava/lang/String;JI)V", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;)V", "fromChannelUsername", "(JLjava/lang/String;I)V", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)V", "(Ljava/lang/String;Ljava/lang/String;I)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "", "(Ljava/lang/Object;Ljava/lang/Object;I)V", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Integer;)V", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;I)V", "getChannelUsername", "()Ljava/lang/String;", "channelUsername$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "getChatId", "()Ljava/lang/Long;", "chatId$delegate", "<set-?>", "", "disableNotification", "getDisableNotification", "()Ljava/lang/Boolean;", "setDisableNotification", "(Ljava/lang/Boolean;)V", "disableNotification$delegate", "getFromChannelUsername", "fromChannelUsername$delegate", "getFromChatId", "fromChatId$delegate", "getMessageId", "()I", "messageId$delegate", "messageThreadId", "getMessageThreadId", "()Ljava/lang/Integer;", "setMessageThreadId", "(Ljava/lang/Integer;)V", "messageThreadId$delegate", "protectContent", "getProtectContent", "setProtectContent", "protectContent$delegate", "videoStartTimestamp", "getVideoStartTimestamp", "setVideoStartTimestamp", "videoStartTimestamp$delegate", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ForwardMessage extends KBaseRequest<ForwardMessage, SendResponse> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(ForwardMessage.class, "chatId", "getChatId()Ljava/lang/Long;", 0)), c0.g(new w(ForwardMessage.class, "channelUsername", "getChannelUsername()Ljava/lang/String;", 0)), c0.g(new w(ForwardMessage.class, "fromChatId", "getFromChatId()Ljava/lang/Long;", 0)), c0.g(new w(ForwardMessage.class, "fromChannelUsername", "getFromChannelUsername()Ljava/lang/String;", 0)), c0.g(new w(ForwardMessage.class, "messageId", "getMessageId()I", 0)), c0.e(new q(ForwardMessage.class, "messageThreadId", "getMessageThreadId()Ljava/lang/Integer;", 0)), c0.e(new q(ForwardMessage.class, "disableNotification", "getDisableNotification()Ljava/lang/Boolean;", 0)), c0.e(new q(ForwardMessage.class, "protectContent", "getProtectContent()Ljava/lang/Boolean;", 0)), c0.e(new q(ForwardMessage.class, "videoStartTimestamp", "getVideoStartTimestamp()Ljava/lang/Integer;", 0))};

    /* JADX INFO: renamed from: channelUsername$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate channelUsername;

    /* JADX INFO: renamed from: chatId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate chatId;

    /* JADX INFO: renamed from: disableNotification$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate disableNotification;

    /* JADX INFO: renamed from: fromChannelUsername$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate fromChannelUsername;

    /* JADX INFO: renamed from: fromChatId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate fromChatId;

    /* JADX INFO: renamed from: messageId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate messageId;

    /* JADX INFO: renamed from: messageThreadId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate messageThreadId;

    /* JADX INFO: renamed from: protectContent$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate protectContent;

    /* JADX INFO: renamed from: videoStartTimestamp$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate videoStartTimestamp;

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.ForwardMessage$disableNotification$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/ForwardMessage;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/ForwardMessage;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass5 extends o implements l<ForwardMessage, z> {
        final /* synthetic */ boolean $disableNotification;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(ForwardMessage forwardMessage) {
            invoke2(forwardMessage);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(boolean z10) {
            super(1);
            this.$disableNotification = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ForwardMessage applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setDisableNotification(Boolean.valueOf(this.$disableNotification));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.ForwardMessage$messageThreadId$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/ForwardMessage;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/ForwardMessage;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C05995 extends o implements l<ForwardMessage, z> {
        final /* synthetic */ int $messageThreadId;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(ForwardMessage forwardMessage) {
            invoke2(forwardMessage);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05995(int i10) {
            super(1);
            this.$messageThreadId = i10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ForwardMessage applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setMessageThreadId(Integer.valueOf(this.$messageThreadId));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.ForwardMessage$protectContent$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/ForwardMessage;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/ForwardMessage;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06005 extends o implements l<ForwardMessage, z> {
        final /* synthetic */ boolean $protectContent;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(ForwardMessage forwardMessage) {
            invoke2(forwardMessage);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06005(boolean z10) {
            super(1);
            this.$protectContent = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ForwardMessage applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setProtectContent(Boolean.valueOf(this.$protectContent));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.ForwardMessage$videoStartTimestamp$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/ForwardMessage;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/ForwardMessage;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06015 extends o implements l<ForwardMessage, z> {
        final /* synthetic */ int $videoStartTimestamp;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(ForwardMessage forwardMessage) {
            invoke2(forwardMessage);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06015(int i10) {
            super(1);
            this.$videoStartTimestamp = i10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ForwardMessage applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setVideoStartTimestamp(Integer.valueOf(this.$videoStartTimestamp));
        }
    }

    private ForwardMessage(Long l10, String str, Long l11, String str2, int i10) {
        super(c0.b(SendResponse.class));
        RequestParameterDelegate requestParameterDelegateOptionalRequestParameter$default = RequestParameterDelegateKt.optionalRequestParameter$default(l10, "chat_id", null, 4, null);
        k<?>[] kVarArr = $$delegatedProperties;
        this.chatId = requestParameterDelegateOptionalRequestParameter$default.provideDelegate(this, kVarArr[0]);
        this.channelUsername = RequestParameterDelegateKt.optionalRequestParameter$default(str, "chat_id", null, 4, null).provideDelegate(this, kVarArr[1]);
        this.fromChatId = RequestParameterDelegateKt.optionalRequestParameter$default(l11, "from_chat_id", null, 4, null).provideDelegate(this, kVarArr[2]);
        this.fromChannelUsername = RequestParameterDelegateKt.optionalRequestParameter$default(str2, "from_chat_id", null, 4, null).provideDelegate(this, kVarArr[3]);
        this.messageId = RequestParameterDelegateKt.requestParameter$default(Integer.valueOf(i10), null, 2, null).provideDelegate(this, kVarArr[4]);
        this.messageThreadId = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[5]);
        this.disableNotification = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[6]);
        this.protectContent = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[7]);
        this.videoStartTimestamp = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[8]);
    }

    public final ForwardMessage disableNotification(boolean disableNotification) {
        return applySelf(new AnonymousClass5(disableNotification));
    }

    public final String getChannelUsername() {
        return (String) this.channelUsername.getValue(this, $$delegatedProperties[1]);
    }

    public final Long getChatId() {
        return (Long) this.chatId.getValue(this, $$delegatedProperties[0]);
    }

    public final Boolean getDisableNotification() {
        return (Boolean) this.disableNotification.getValue(this, $$delegatedProperties[6]);
    }

    public final String getFromChannelUsername() {
        return (String) this.fromChannelUsername.getValue(this, $$delegatedProperties[3]);
    }

    public final Long getFromChatId() {
        return (Long) this.fromChatId.getValue(this, $$delegatedProperties[2]);
    }

    public final int getMessageId() {
        return ((Number) this.messageId.getValue(this, $$delegatedProperties[4])).intValue();
    }

    public final Integer getMessageThreadId() {
        return (Integer) this.messageThreadId.getValue(this, $$delegatedProperties[5]);
    }

    public final Boolean getProtectContent() {
        return (Boolean) this.protectContent.getValue(this, $$delegatedProperties[7]);
    }

    public final Integer getVideoStartTimestamp() {
        return (Integer) this.videoStartTimestamp.getValue(this, $$delegatedProperties[8]);
    }

    public final ForwardMessage messageThreadId(int messageThreadId) {
        return applySelf(new C05995(messageThreadId));
    }

    public final ForwardMessage protectContent(boolean protectContent) {
        return applySelf(new C06005(protectContent));
    }

    public final void setDisableNotification(Boolean bool) {
        this.disableNotification.setValue(this, $$delegatedProperties[6], bool);
    }

    public final void setMessageThreadId(Integer num) {
        this.messageThreadId.setValue(this, $$delegatedProperties[5], num);
    }

    public final void setProtectContent(Boolean bool) {
        this.protectContent.setValue(this, $$delegatedProperties[7], bool);
    }

    public final void setVideoStartTimestamp(Integer num) {
        this.videoStartTimestamp.setValue(this, $$delegatedProperties[8], num);
    }

    public final ForwardMessage videoStartTimestamp(int videoStartTimestamp) {
        return applySelf(new C06015(videoStartTimestamp));
    }

    public ForwardMessage(long j10, long j11, int i10) {
        this(Long.valueOf(j10), null, Long.valueOf(j11), null, i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ForwardMessage(Long chatId, Long fromChatId, Integer messageId) {
        this(chatId.longValue(), fromChatId.longValue(), messageId.intValue());
        m.f(chatId, "chatId");
        m.f(fromChatId, "fromChatId");
        m.f(messageId, "messageId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ForwardMessage(String channelUsername, long j10, int i10) {
        this(null, channelUsername, Long.valueOf(j10), null, i10);
        m.f(channelUsername, "channelUsername");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ForwardMessage(String channelUsername, Long fromChatId, Integer messageId) {
        this(channelUsername, fromChatId.longValue(), messageId.intValue());
        m.f(channelUsername, "channelUsername");
        m.f(fromChatId, "fromChatId");
        m.f(messageId, "messageId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ForwardMessage(long j10, String fromChannelUsername, int i10) {
        this(Long.valueOf(j10), null, null, fromChannelUsername, i10);
        m.f(fromChannelUsername, "fromChannelUsername");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ForwardMessage(Long chatId, String fromChannelUsername, Integer messageId) {
        this(chatId.longValue(), fromChannelUsername, messageId.intValue());
        m.f(chatId, "chatId");
        m.f(fromChannelUsername, "fromChannelUsername");
        m.f(messageId, "messageId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ForwardMessage(String channelUsername, String fromChannelUsername, int i10) {
        this(null, channelUsername, null, fromChannelUsername, i10);
        m.f(channelUsername, "channelUsername");
        m.f(fromChannelUsername, "fromChannelUsername");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ForwardMessage(String channelUsername, String fromChannelUsername, Integer messageId) {
        this(channelUsername, fromChannelUsername, messageId.intValue());
        m.f(channelUsername, "channelUsername");
        m.f(fromChannelUsername, "fromChannelUsername");
        m.f(messageId, "messageId");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ForwardMessage(Object chatId, Object fromChatId, int i10) {
        m.f(chatId, "chatId");
        m.f(fromChatId, "fromChatId");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        Long lValueOf = number != null ? Long.valueOf(number.longValue()) : null;
        String str = chatId instanceof String ? (String) chatId : null;
        Number number2 = fromChatId instanceof Number ? (Number) fromChatId : null;
        this(lValueOf, str, number2 != null ? Long.valueOf(number2.longValue()) : null, fromChatId instanceof String ? (String) fromChatId : null, i10);
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
        if (getFromChatId() == null && getFromChannelUsername() == null) {
            throw new IllegalArgumentException("fromChatId parameter must be either Long or String");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ForwardMessage(Object chatId, Object fromChatId, Integer messageId) {
        this(chatId, fromChatId, messageId.intValue());
        m.f(chatId, "chatId");
        m.f(fromChatId, "fromChatId");
        m.f(messageId, "messageId");
    }
}
