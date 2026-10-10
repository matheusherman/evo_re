package com.pengrad.telegrambot.request;

import c9.l;
import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.model.request.ReplyParameters;
import com.pengrad.telegrambot.response.MessageIdResponse;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegate;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegateKt;
import i9.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.j;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.w;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB+\b\u0016\u0012\n\u0010\u0003\u001a\u00060\tj\u0002`\n\u0012\n\u0010\u0005\u001a\u00060\tj\u0002`\n\u0012\n\u0010\u0006\u001a\u00060\u000bj\u0002`\f¢\u0006\u0002\u0010\rB\u001f\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0010B'\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\n\u0010\u0005\u001a\u00060\tj\u0002`\n\u0012\n\u0010\u0006\u001a\u00060\u000bj\u0002`\f¢\u0006\u0002\u0010\u0011B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0013B'\b\u0016\u0012\n\u0010\u0003\u001a\u00060\tj\u0002`\n\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\n\u0010\u0006\u001a\u00060\u000bj\u0002`\f¢\u0006\u0002\u0010\u0014B\u001f\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0015B#\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\n\u0010\u0006\u001a\u00060\u000bj\u0002`\f¢\u0006\u0002\u0010\u0016B\u001f\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0018B#\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0017\u0012\n\u0010\u0006\u001a\u00060\u000bj\u0002`\f¢\u0006\u0002\u0010\u0019B7\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u000fJ\u001f\u0010,\u001a\u00020\u00002\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020+0i\"\u00020+¢\u0006\u0002\u0010jJ\u0014\u0010,\u001a\u00020\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*J\u000e\u00107\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u001cJ\u000e\u0010B\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u0007J\u000e\u0010I\u001a\u00020\u00002\u0006\u0010I\u001a\u00020HJ\u000e\u0010O\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\u001cJ\u000e\u0010T\u001a\u00020\u00002\u0006\u0010T\u001a\u00020SJ\u000e\u0010[\u001a\u00020\u00002\u0006\u0010k\u001a\u00020ZJ\u000e\u0010a\u001a\u00020\u00002\u0006\u0010a\u001a\u00020\u001cJ\u000e\u0010e\u001a\u00020\u00002\u0006\u0010e\u001a\u00020\u0007R/\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R/\u0010$\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b)\u0010#\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R;\u0010,\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010#\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u0010#\u001a\u0004\b2\u0010&R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u0010#\u001a\u0004\b4\u00105R/\u00107\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b:\u0010#\u001a\u0004\b8\u0010\u001f\"\u0004\b9\u0010!R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u0010#\u001a\u0004\b;\u0010&R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b>\u0010#\u001a\u0004\b=\u00105R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bA\u0010#\u001a\u0004\b?\u0010@R/\u0010B\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bG\u0010#\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR/\u0010I\u001a\u0004\u0018\u00010H2\b\u0010\u001b\u001a\u0004\u0018\u00010H8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bN\u0010#\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR/\u0010O\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bR\u0010#\u001a\u0004\bP\u0010\u001f\"\u0004\bQ\u0010!R/\u0010T\u001a\u0004\u0018\u00010S2\b\u0010\u001b\u001a\u0004\u0018\u00010S8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bY\u0010#\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR/\u0010[\u001a\u0004\u0018\u00010Z2\b\u0010\u001b\u001a\u0004\u0018\u00010Z8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b`\u0010#\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R/\u0010a\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bd\u0010#\u001a\u0004\bb\u0010\u001f\"\u0004\bc\u0010!R/\u0010e\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bh\u0010#\u001a\u0004\bf\u0010D\"\u0004\bg\u0010F¨\u0006l"}, d2 = {"Lcom/pengrad/telegrambot/request/CopyMessage;", "Lcom/pengrad/telegrambot/request/KBaseRequest;", "Lcom/pengrad/telegrambot/response/MessageIdResponse;", "chatId", "", "fromChatId", "messageId", "", "(JJI)V", "Ljava/lang/Long;", "Lcom/pengrad/telegrambot/utility/kotlin/JavaLong;", "Ljava/lang/Integer;", "Lcom/pengrad/telegrambot/utility/kotlin/JavaInteger;", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)V", "channelUsername", "", "(Ljava/lang/String;JI)V", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;)V", "fromChannelUsername", "(JLjava/lang/String;I)V", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)V", "(Ljava/lang/String;Ljava/lang/String;I)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "", "(Ljava/lang/Object;Ljava/lang/Object;I)V", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Integer;)V", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;I)V", "<set-?>", "", "allowPaidBroadcast", "getAllowPaidBroadcast", "()Ljava/lang/Boolean;", "setAllowPaidBroadcast", "(Ljava/lang/Boolean;)V", "allowPaidBroadcast$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "caption", "getCaption", "()Ljava/lang/String;", "setCaption", "(Ljava/lang/String;)V", "caption$delegate", "", "Lcom/pengrad/telegrambot/model/MessageEntity;", "captionEntities", "getCaptionEntities", "()Ljava/util/List;", "setCaptionEntities", "(Ljava/util/List;)V", "captionEntities$delegate", "getChannelUsername", "channelUsername$delegate", "getChatId", "()Ljava/lang/Long;", "chatId$delegate", "disableNotification", "getDisableNotification", "setDisableNotification", "disableNotification$delegate", "getFromChannelUsername", "fromChannelUsername$delegate", "getFromChatId", "fromChatId$delegate", "getMessageId", "()I", "messageId$delegate", "messageThreadId", "getMessageThreadId", "()Ljava/lang/Integer;", "setMessageThreadId", "(Ljava/lang/Integer;)V", "messageThreadId$delegate", "Lcom/pengrad/telegrambot/model/request/ParseMode;", "parseMode", "getParseMode", "()Lcom/pengrad/telegrambot/model/request/ParseMode;", "setParseMode", "(Lcom/pengrad/telegrambot/model/request/ParseMode;)V", "parseMode$delegate", "protectContent", "getProtectContent", "setProtectContent", "protectContent$delegate", "Lcom/pengrad/telegrambot/model/request/Keyboard;", "replyMarkup", "getReplyMarkup", "()Lcom/pengrad/telegrambot/model/request/Keyboard;", "setReplyMarkup", "(Lcom/pengrad/telegrambot/model/request/Keyboard;)V", "replyMarkup$delegate", "Lcom/pengrad/telegrambot/model/request/ReplyParameters;", "replyParameters", "getReplyParameters", "()Lcom/pengrad/telegrambot/model/request/ReplyParameters;", "setReplyParameters", "(Lcom/pengrad/telegrambot/model/request/ReplyParameters;)V", "replyParameters$delegate", "showCaptionAboveMedia", "getShowCaptionAboveMedia", "setShowCaptionAboveMedia", "showCaptionAboveMedia$delegate", "videoStartTimestamp", "getVideoStartTimestamp", "setVideoStartTimestamp", "videoStartTimestamp$delegate", "", "([Lcom/pengrad/telegrambot/model/MessageEntity;)Lcom/pengrad/telegrambot/request/CopyMessage;", "parameters", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CopyMessage extends KBaseRequest<CopyMessage, MessageIdResponse> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(CopyMessage.class, "chatId", "getChatId()Ljava/lang/Long;", 0)), c0.g(new w(CopyMessage.class, "channelUsername", "getChannelUsername()Ljava/lang/String;", 0)), c0.g(new w(CopyMessage.class, "fromChatId", "getFromChatId()Ljava/lang/Long;", 0)), c0.g(new w(CopyMessage.class, "fromChannelUsername", "getFromChannelUsername()Ljava/lang/String;", 0)), c0.g(new w(CopyMessage.class, "messageId", "getMessageId()I", 0)), c0.e(new q(CopyMessage.class, "messageThreadId", "getMessageThreadId()Ljava/lang/Integer;", 0)), c0.e(new q(CopyMessage.class, "caption", "getCaption()Ljava/lang/String;", 0)), c0.e(new q(CopyMessage.class, "parseMode", "getParseMode()Lcom/pengrad/telegrambot/model/request/ParseMode;", 0)), c0.e(new q(CopyMessage.class, "captionEntities", "getCaptionEntities()Ljava/util/List;", 0)), c0.e(new q(CopyMessage.class, "replyParameters", "getReplyParameters()Lcom/pengrad/telegrambot/model/request/ReplyParameters;", 0)), c0.e(new q(CopyMessage.class, "replyMarkup", "getReplyMarkup()Lcom/pengrad/telegrambot/model/request/Keyboard;", 0)), c0.e(new q(CopyMessage.class, "showCaptionAboveMedia", "getShowCaptionAboveMedia()Ljava/lang/Boolean;", 0)), c0.e(new q(CopyMessage.class, "disableNotification", "getDisableNotification()Ljava/lang/Boolean;", 0)), c0.e(new q(CopyMessage.class, "protectContent", "getProtectContent()Ljava/lang/Boolean;", 0)), c0.e(new q(CopyMessage.class, "videoStartTimestamp", "getVideoStartTimestamp()Ljava/lang/Integer;", 0)), c0.e(new q(CopyMessage.class, "allowPaidBroadcast", "getAllowPaidBroadcast()Ljava/lang/Boolean;", 0))};

    /* JADX INFO: renamed from: allowPaidBroadcast$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate allowPaidBroadcast;

    /* JADX INFO: renamed from: caption$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate caption;

    /* JADX INFO: renamed from: captionEntities$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate captionEntities;

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

    /* JADX INFO: renamed from: parseMode$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate parseMode;

    /* JADX INFO: renamed from: protectContent$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate protectContent;

    /* JADX INFO: renamed from: replyMarkup$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate replyMarkup;

    /* JADX INFO: renamed from: replyParameters$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate replyParameters;

    /* JADX INFO: renamed from: showCaptionAboveMedia$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate showCaptionAboveMedia;

    /* JADX INFO: renamed from: videoStartTimestamp$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate videoStartTimestamp;

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.CopyMessage$allowPaidBroadcast$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/CopyMessage;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/CopyMessage;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass5 extends o implements l<CopyMessage, z> {
        final /* synthetic */ boolean $allowPaidBroadcast;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(CopyMessage copyMessage) {
            invoke2(copyMessage);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(boolean z10) {
            super(1);
            this.$allowPaidBroadcast = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CopyMessage applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setAllowPaidBroadcast(Boolean.valueOf(this.$allowPaidBroadcast));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.CopyMessage$caption$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/CopyMessage;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/CopyMessage;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C05895 extends o implements l<CopyMessage, z> {
        final /* synthetic */ String $caption;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(CopyMessage copyMessage) {
            invoke2(copyMessage);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05895(String str) {
            super(1);
            this.$caption = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CopyMessage applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setCaption(this.$caption);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.CopyMessage$captionEntities$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/CopyMessage;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/CopyMessage;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C05905 extends o implements l<CopyMessage, z> {
        final /* synthetic */ List<MessageEntity> $captionEntities;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(CopyMessage copyMessage) {
            invoke2(copyMessage);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C05905(List<? extends MessageEntity> list) {
            super(1);
            this.$captionEntities = list;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CopyMessage applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setCaptionEntities(this.$captionEntities);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.CopyMessage$captionEntities$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/CopyMessage;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/CopyMessage;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass6 extends o implements l<CopyMessage, z> {
        final /* synthetic */ MessageEntity[] $captionEntities;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(CopyMessage copyMessage) {
            invoke2(copyMessage);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(MessageEntity[] messageEntityArr) {
            super(1);
            this.$captionEntities = messageEntityArr;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CopyMessage applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setCaptionEntities(j.E0(this.$captionEntities));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.CopyMessage$disableNotification$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/CopyMessage;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/CopyMessage;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C05915 extends o implements l<CopyMessage, z> {
        final /* synthetic */ boolean $disableNotification;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(CopyMessage copyMessage) {
            invoke2(copyMessage);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05915(boolean z10) {
            super(1);
            this.$disableNotification = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CopyMessage applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setDisableNotification(Boolean.valueOf(this.$disableNotification));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.CopyMessage$messageThreadId$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/CopyMessage;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/CopyMessage;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C05925 extends o implements l<CopyMessage, z> {
        final /* synthetic */ int $messageThreadId;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(CopyMessage copyMessage) {
            invoke2(copyMessage);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05925(int i10) {
            super(1);
            this.$messageThreadId = i10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CopyMessage applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setMessageThreadId(Integer.valueOf(this.$messageThreadId));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.CopyMessage$parseMode$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/CopyMessage;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/CopyMessage;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C05935 extends o implements l<CopyMessage, z> {
        final /* synthetic */ ParseMode $parseMode;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(CopyMessage copyMessage) {
            invoke2(copyMessage);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05935(ParseMode parseMode) {
            super(1);
            this.$parseMode = parseMode;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CopyMessage applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setParseMode(this.$parseMode);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.CopyMessage$protectContent$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/CopyMessage;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/CopyMessage;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C05945 extends o implements l<CopyMessage, z> {
        final /* synthetic */ boolean $protectContent;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(CopyMessage copyMessage) {
            invoke2(copyMessage);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05945(boolean z10) {
            super(1);
            this.$protectContent = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CopyMessage applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setProtectContent(Boolean.valueOf(this.$protectContent));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.CopyMessage$replyMarkup$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/CopyMessage;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/CopyMessage;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C05955 extends o implements l<CopyMessage, z> {
        final /* synthetic */ Keyboard $replyMarkup;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(CopyMessage copyMessage) {
            invoke2(copyMessage);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05955(Keyboard keyboard) {
            super(1);
            this.$replyMarkup = keyboard;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CopyMessage applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setReplyMarkup(this.$replyMarkup);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.CopyMessage$replyParameters$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/CopyMessage;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/CopyMessage;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C05965 extends o implements l<CopyMessage, z> {
        final /* synthetic */ ReplyParameters $parameters;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(CopyMessage copyMessage) {
            invoke2(copyMessage);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05965(ReplyParameters replyParameters) {
            super(1);
            this.$parameters = replyParameters;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CopyMessage applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setReplyParameters(this.$parameters);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.CopyMessage$showCaptionAboveMedia$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/CopyMessage;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/CopyMessage;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C05975 extends o implements l<CopyMessage, z> {
        final /* synthetic */ boolean $showCaptionAboveMedia;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(CopyMessage copyMessage) {
            invoke2(copyMessage);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05975(boolean z10) {
            super(1);
            this.$showCaptionAboveMedia = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CopyMessage applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setShowCaptionAboveMedia(Boolean.valueOf(this.$showCaptionAboveMedia));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.CopyMessage$videoStartTimestamp$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/CopyMessage;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/CopyMessage;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C05985 extends o implements l<CopyMessage, z> {
        final /* synthetic */ int $videoStartTimestamp;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(CopyMessage copyMessage) {
            invoke2(copyMessage);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05985(int i10) {
            super(1);
            this.$videoStartTimestamp = i10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CopyMessage applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setVideoStartTimestamp(Integer.valueOf(this.$videoStartTimestamp));
        }
    }

    private CopyMessage(Long l10, String str, Long l11, String str2, int i10) {
        super(c0.b(MessageIdResponse.class));
        RequestParameterDelegate requestParameterDelegateOptionalRequestParameter$default = RequestParameterDelegateKt.optionalRequestParameter$default(l10, "chat_id", null, 4, null);
        k<?>[] kVarArr = $$delegatedProperties;
        this.chatId = requestParameterDelegateOptionalRequestParameter$default.provideDelegate(this, kVarArr[0]);
        this.channelUsername = RequestParameterDelegateKt.optionalRequestParameter$default(str, "chat_id", null, 4, null).provideDelegate(this, kVarArr[1]);
        this.fromChatId = RequestParameterDelegateKt.optionalRequestParameter$default(l11, "from_chat_id", null, 4, null).provideDelegate(this, kVarArr[2]);
        this.fromChannelUsername = RequestParameterDelegateKt.optionalRequestParameter$default(str2, "from_chat_id", null, 4, null).provideDelegate(this, kVarArr[3]);
        this.messageId = RequestParameterDelegateKt.requestParameter$default(Integer.valueOf(i10), null, 2, null).provideDelegate(this, kVarArr[4]);
        this.messageThreadId = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[5]);
        this.caption = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[6]);
        this.parseMode = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[7]);
        this.captionEntities = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[8]);
        this.replyParameters = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[9]);
        this.replyMarkup = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[10]);
        this.showCaptionAboveMedia = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[11]);
        this.disableNotification = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[12]);
        this.protectContent = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[13]);
        this.videoStartTimestamp = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[14]);
        this.allowPaidBroadcast = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[15]);
    }

    public final CopyMessage captionEntities(List<? extends MessageEntity> captionEntities) {
        m.f(captionEntities, "captionEntities");
        return applySelf(new C05905(captionEntities));
    }

    public final CopyMessage allowPaidBroadcast(boolean allowPaidBroadcast) {
        return applySelf(new AnonymousClass5(allowPaidBroadcast));
    }

    public final CopyMessage caption(String caption) {
        m.f(caption, "caption");
        return applySelf(new C05895(caption));
    }

    public final CopyMessage captionEntities(MessageEntity... captionEntities) {
        m.f(captionEntities, "captionEntities");
        return applySelf(new AnonymousClass6(captionEntities));
    }

    public final CopyMessage disableNotification(boolean disableNotification) {
        return applySelf(new C05915(disableNotification));
    }

    public final Boolean getAllowPaidBroadcast() {
        return (Boolean) this.allowPaidBroadcast.getValue(this, $$delegatedProperties[15]);
    }

    public final String getCaption() {
        return (String) this.caption.getValue(this, $$delegatedProperties[6]);
    }

    public final List<MessageEntity> getCaptionEntities() {
        return (List) this.captionEntities.getValue(this, $$delegatedProperties[8]);
    }

    public final String getChannelUsername() {
        return (String) this.channelUsername.getValue(this, $$delegatedProperties[1]);
    }

    public final Long getChatId() {
        return (Long) this.chatId.getValue(this, $$delegatedProperties[0]);
    }

    public final Boolean getDisableNotification() {
        return (Boolean) this.disableNotification.getValue(this, $$delegatedProperties[12]);
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

    public final ParseMode getParseMode() {
        return (ParseMode) this.parseMode.getValue(this, $$delegatedProperties[7]);
    }

    public final Boolean getProtectContent() {
        return (Boolean) this.protectContent.getValue(this, $$delegatedProperties[13]);
    }

    public final Keyboard getReplyMarkup() {
        return (Keyboard) this.replyMarkup.getValue(this, $$delegatedProperties[10]);
    }

    public final ReplyParameters getReplyParameters() {
        return (ReplyParameters) this.replyParameters.getValue(this, $$delegatedProperties[9]);
    }

    public final Boolean getShowCaptionAboveMedia() {
        return (Boolean) this.showCaptionAboveMedia.getValue(this, $$delegatedProperties[11]);
    }

    public final Integer getVideoStartTimestamp() {
        return (Integer) this.videoStartTimestamp.getValue(this, $$delegatedProperties[14]);
    }

    public final CopyMessage messageThreadId(int messageThreadId) {
        return applySelf(new C05925(messageThreadId));
    }

    public final CopyMessage parseMode(ParseMode parseMode) {
        m.f(parseMode, "parseMode");
        return applySelf(new C05935(parseMode));
    }

    public final CopyMessage protectContent(boolean protectContent) {
        return applySelf(new C05945(protectContent));
    }

    public final CopyMessage replyMarkup(Keyboard replyMarkup) {
        m.f(replyMarkup, "replyMarkup");
        return applySelf(new C05955(replyMarkup));
    }

    public final CopyMessage replyParameters(ReplyParameters parameters) {
        m.f(parameters, "parameters");
        return applySelf(new C05965(parameters));
    }

    public final void setAllowPaidBroadcast(Boolean bool) {
        this.allowPaidBroadcast.setValue(this, $$delegatedProperties[15], bool);
    }

    public final void setCaption(String str) {
        this.caption.setValue(this, $$delegatedProperties[6], str);
    }

    public final void setCaptionEntities(List<? extends MessageEntity> list) {
        this.captionEntities.setValue(this, $$delegatedProperties[8], list);
    }

    public final void setDisableNotification(Boolean bool) {
        this.disableNotification.setValue(this, $$delegatedProperties[12], bool);
    }

    public final void setMessageThreadId(Integer num) {
        this.messageThreadId.setValue(this, $$delegatedProperties[5], num);
    }

    public final void setParseMode(ParseMode parseMode) {
        this.parseMode.setValue(this, $$delegatedProperties[7], parseMode);
    }

    public final void setProtectContent(Boolean bool) {
        this.protectContent.setValue(this, $$delegatedProperties[13], bool);
    }

    public final void setReplyMarkup(Keyboard keyboard) {
        this.replyMarkup.setValue(this, $$delegatedProperties[10], keyboard);
    }

    public final void setReplyParameters(ReplyParameters replyParameters) {
        this.replyParameters.setValue(this, $$delegatedProperties[9], replyParameters);
    }

    public final void setShowCaptionAboveMedia(Boolean bool) {
        this.showCaptionAboveMedia.setValue(this, $$delegatedProperties[11], bool);
    }

    public final void setVideoStartTimestamp(Integer num) {
        this.videoStartTimestamp.setValue(this, $$delegatedProperties[14], num);
    }

    public final CopyMessage showCaptionAboveMedia(boolean showCaptionAboveMedia) {
        return applySelf(new C05975(showCaptionAboveMedia));
    }

    public final CopyMessage videoStartTimestamp(int videoStartTimestamp) {
        return applySelf(new C05985(videoStartTimestamp));
    }

    public CopyMessage(long j10, long j11, int i10) {
        this(Long.valueOf(j10), null, Long.valueOf(j11), null, i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CopyMessage(Long chatId, Long fromChatId, Integer messageId) {
        this(chatId.longValue(), fromChatId.longValue(), messageId.intValue());
        m.f(chatId, "chatId");
        m.f(fromChatId, "fromChatId");
        m.f(messageId, "messageId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CopyMessage(String channelUsername, long j10, int i10) {
        this(null, channelUsername, Long.valueOf(j10), null, i10);
        m.f(channelUsername, "channelUsername");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CopyMessage(String channelUsername, Long fromChatId, Integer messageId) {
        this(channelUsername, fromChatId.longValue(), messageId.intValue());
        m.f(channelUsername, "channelUsername");
        m.f(fromChatId, "fromChatId");
        m.f(messageId, "messageId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CopyMessage(long j10, String fromChannelUsername, int i10) {
        this(Long.valueOf(j10), null, null, fromChannelUsername, i10);
        m.f(fromChannelUsername, "fromChannelUsername");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CopyMessage(Long chatId, String fromChannelUsername, Integer messageId) {
        this(chatId.longValue(), fromChannelUsername, messageId.intValue());
        m.f(chatId, "chatId");
        m.f(fromChannelUsername, "fromChannelUsername");
        m.f(messageId, "messageId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CopyMessage(String channelUsername, String fromChannelUsername, int i10) {
        this(null, channelUsername, null, fromChannelUsername, i10);
        m.f(channelUsername, "channelUsername");
        m.f(fromChannelUsername, "fromChannelUsername");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CopyMessage(String channelUsername, String fromChannelUsername, Integer messageId) {
        this(channelUsername, fromChannelUsername, messageId.intValue());
        m.f(channelUsername, "channelUsername");
        m.f(fromChannelUsername, "fromChannelUsername");
        m.f(messageId, "messageId");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CopyMessage(Object chatId, Object fromChatId, int i10) {
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
    public CopyMessage(Object chatId, Object fromChatId, Integer messageId) {
        this(chatId, fromChatId, messageId.intValue());
        m.f(chatId, "chatId");
        m.f(fromChatId, "fromChatId");
        m.f(messageId, "messageId");
    }
}
