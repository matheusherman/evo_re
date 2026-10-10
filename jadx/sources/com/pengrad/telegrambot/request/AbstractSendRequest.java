package com.pengrad.telegrambot.request;

import c9.l;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.ReplyParameters;
import com.pengrad.telegrambot.model.suggestedposts.SuggestedPostParameters;
import com.pengrad.telegrambot.request.AbstractSendRequest;
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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002B\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010IJ\u0013\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u0007¢\u0006\u0002\u0010JJ\u0013\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0002\u0010KJ\u0013\u0010$\u001a\u00028\u00002\u0006\u0010$\u001a\u00020\n¢\u0006\u0002\u0010IJ\u0013\u0010(\u001a\u00028\u00002\u0006\u0010(\u001a\u00020\u0007¢\u0006\u0002\u0010JJ\u0013\u0010,\u001a\u00028\u00002\u0006\u0010,\u001a\u00020\u001d¢\u0006\u0002\u0010KJ\u0013\u00100\u001a\u00028\u00002\u0006\u00100\u001a\u00020\n¢\u0006\u0002\u0010IJ\u0013\u00105\u001a\u00028\u00002\u0006\u00105\u001a\u000204¢\u0006\u0002\u0010LJ\u0013\u0010<\u001a\u00028\u00002\u0006\u0010<\u001a\u00020;¢\u0006\u0002\u0010MJ\u0013\u0010C\u001a\u00028\u00002\u0006\u0010C\u001a\u00020B¢\u0006\u0002\u0010NR/\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR/\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0018\u0010\u0014R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001a\u0010\u001bR/\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\t\u001a\u0004\u0018\u00010\u001d8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0011\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R/\u0010$\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0011\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000fR/\u0010(\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0011\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R/\u0010,\u001a\u0004\u0018\u00010\u001d2\b\u0010\t\u001a\u0004\u0018\u00010\u001d8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b/\u0010\u0011\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R/\u00100\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b3\u0010\u0011\u001a\u0004\b1\u0010\r\"\u0004\b2\u0010\u000fR/\u00105\u001a\u0004\u0018\u0001042\b\u0010\t\u001a\u0004\u0018\u0001048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b:\u0010\u0011\u001a\u0004\b6\u00107\"\u0004\b8\u00109R/\u0010<\u001a\u0004\u0018\u00010;2\b\u0010\t\u001a\u0004\u0018\u00010;8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bA\u0010\u0011\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R/\u0010C\u001a\u0004\u0018\u00010B2\b\u0010\t\u001a\u0004\u0018\u00010B8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bH\u0010\u0011\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G¨\u0006O"}, d2 = {"Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "REQ", "Lcom/pengrad/telegrambot/request/KBaseRequest;", "Lcom/pengrad/telegrambot/response/SendResponse;", "chatId", "", "channelUsername", "", "(Ljava/lang/Long;Ljava/lang/String;)V", "<set-?>", "", "allowPaidBroadcast", "getAllowPaidBroadcast", "()Ljava/lang/Boolean;", "setAllowPaidBroadcast", "(Ljava/lang/Boolean;)V", "allowPaidBroadcast$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "businessConnectionId", "getBusinessConnectionId", "()Ljava/lang/String;", "setBusinessConnectionId", "(Ljava/lang/String;)V", "businessConnectionId$delegate", "getChannelUsername", "channelUsername$delegate", "getChatId", "()Ljava/lang/Long;", "chatId$delegate", "", "directMessagesTopicId", "getDirectMessagesTopicId", "()Ljava/lang/Integer;", "setDirectMessagesTopicId", "(Ljava/lang/Integer;)V", "directMessagesTopicId$delegate", "disableNotification", "getDisableNotification", "setDisableNotification", "disableNotification$delegate", "messageEffectId", "getMessageEffectId", "setMessageEffectId", "messageEffectId$delegate", "messageThreadId", "getMessageThreadId", "setMessageThreadId", "messageThreadId$delegate", "protectContent", "getProtectContent", "setProtectContent", "protectContent$delegate", "Lcom/pengrad/telegrambot/model/request/Keyboard;", "replyMarkup", "getReplyMarkup", "()Lcom/pengrad/telegrambot/model/request/Keyboard;", "setReplyMarkup", "(Lcom/pengrad/telegrambot/model/request/Keyboard;)V", "replyMarkup$delegate", "Lcom/pengrad/telegrambot/model/request/ReplyParameters;", "replyParameters", "getReplyParameters", "()Lcom/pengrad/telegrambot/model/request/ReplyParameters;", "setReplyParameters", "(Lcom/pengrad/telegrambot/model/request/ReplyParameters;)V", "replyParameters$delegate", "Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostParameters;", "suggestedPostParameters", "getSuggestedPostParameters", "()Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostParameters;", "setSuggestedPostParameters", "(Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostParameters;)V", "suggestedPostParameters$delegate", "(Z)Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "(Ljava/lang/String;)Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "(I)Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "(Lcom/pengrad/telegrambot/model/request/Keyboard;)Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "(Lcom/pengrad/telegrambot/model/request/ReplyParameters;)Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "(Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostParameters;)Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AbstractSendRequest<REQ extends AbstractSendRequest<REQ>> extends KBaseRequest<REQ, SendResponse> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(AbstractSendRequest.class, "chatId", "getChatId()Ljava/lang/Long;", 0)), c0.g(new w(AbstractSendRequest.class, "channelUsername", "getChannelUsername()Ljava/lang/String;", 0)), c0.e(new q(AbstractSendRequest.class, "businessConnectionId", "getBusinessConnectionId()Ljava/lang/String;", 0)), c0.e(new q(AbstractSendRequest.class, "messageThreadId", "getMessageThreadId()Ljava/lang/Integer;", 0)), c0.e(new q(AbstractSendRequest.class, "directMessagesTopicId", "getDirectMessagesTopicId()Ljava/lang/Integer;", 0)), c0.e(new q(AbstractSendRequest.class, "disableNotification", "getDisableNotification()Ljava/lang/Boolean;", 0)), c0.e(new q(AbstractSendRequest.class, "protectContent", "getProtectContent()Ljava/lang/Boolean;", 0)), c0.e(new q(AbstractSendRequest.class, "allowPaidBroadcast", "getAllowPaidBroadcast()Ljava/lang/Boolean;", 0)), c0.e(new q(AbstractSendRequest.class, "messageEffectId", "getMessageEffectId()Ljava/lang/String;", 0)), c0.e(new q(AbstractSendRequest.class, "replyParameters", "getReplyParameters()Lcom/pengrad/telegrambot/model/request/ReplyParameters;", 0)), c0.e(new q(AbstractSendRequest.class, "replyMarkup", "getReplyMarkup()Lcom/pengrad/telegrambot/model/request/Keyboard;", 0)), c0.e(new q(AbstractSendRequest.class, "suggestedPostParameters", "getSuggestedPostParameters()Lcom/pengrad/telegrambot/model/suggestedposts/SuggestedPostParameters;", 0))};

    /* JADX INFO: renamed from: allowPaidBroadcast$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate allowPaidBroadcast;

    /* JADX INFO: renamed from: businessConnectionId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate businessConnectionId;

    /* JADX INFO: renamed from: channelUsername$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate channelUsername;

    /* JADX INFO: renamed from: chatId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate chatId;

    /* JADX INFO: renamed from: directMessagesTopicId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate directMessagesTopicId;

    /* JADX INFO: renamed from: disableNotification$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate disableNotification;

    /* JADX INFO: renamed from: messageEffectId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate messageEffectId;

    /* JADX INFO: renamed from: messageThreadId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate messageThreadId;

    /* JADX INFO: renamed from: protectContent$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate protectContent;

    /* JADX INFO: renamed from: replyMarkup$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate replyMarkup;

    /* JADX INFO: renamed from: replyParameters$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate replyParameters;

    /* JADX INFO: renamed from: suggestedPostParameters$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate suggestedPostParameters;

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.AbstractSendRequest$allowPaidBroadcast$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "REQ", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/AbstractSendRequest;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass5 extends o implements l<REQ, z> {
        final /* synthetic */ boolean $allowPaidBroadcast;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(Object obj) {
            invoke((AbstractSendRequest) obj);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(boolean z10) {
            super(1);
            this.$allowPaidBroadcast = z10;
        }

        public final void invoke(REQ applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setAllowPaidBroadcast(Boolean.valueOf(this.$allowPaidBroadcast));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.AbstractSendRequest$businessConnectionId$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "REQ", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/AbstractSendRequest;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C05805 extends o implements l<REQ, z> {
        final /* synthetic */ String $businessConnectionId;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(Object obj) {
            invoke((AbstractSendRequest) obj);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05805(String str) {
            super(1);
            this.$businessConnectionId = str;
        }

        public final void invoke(REQ applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setBusinessConnectionId(this.$businessConnectionId);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.AbstractSendRequest$directMessagesTopicId$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "REQ", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/AbstractSendRequest;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C05815 extends o implements l<REQ, z> {
        final /* synthetic */ int $directMessagesTopicId;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(Object obj) {
            invoke((AbstractSendRequest) obj);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05815(int i10) {
            super(1);
            this.$directMessagesTopicId = i10;
        }

        public final void invoke(REQ applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setDirectMessagesTopicId(Integer.valueOf(this.$directMessagesTopicId));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.AbstractSendRequest$disableNotification$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "REQ", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/AbstractSendRequest;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C05825 extends o implements l<REQ, z> {
        final /* synthetic */ boolean $disableNotification;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(Object obj) {
            invoke((AbstractSendRequest) obj);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05825(boolean z10) {
            super(1);
            this.$disableNotification = z10;
        }

        public final void invoke(REQ applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setDisableNotification(Boolean.valueOf(this.$disableNotification));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.AbstractSendRequest$messageEffectId$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "REQ", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/AbstractSendRequest;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C05835 extends o implements l<REQ, z> {
        final /* synthetic */ String $messageEffectId;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(Object obj) {
            invoke((AbstractSendRequest) obj);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05835(String str) {
            super(1);
            this.$messageEffectId = str;
        }

        public final void invoke(REQ applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setMessageEffectId(this.$messageEffectId);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.AbstractSendRequest$messageThreadId$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "REQ", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/AbstractSendRequest;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C05845 extends o implements l<REQ, z> {
        final /* synthetic */ int $messageThreadId;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(Object obj) {
            invoke((AbstractSendRequest) obj);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05845(int i10) {
            super(1);
            this.$messageThreadId = i10;
        }

        public final void invoke(REQ applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setMessageThreadId(Integer.valueOf(this.$messageThreadId));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.AbstractSendRequest$protectContent$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "REQ", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/AbstractSendRequest;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C05855 extends o implements l<REQ, z> {
        final /* synthetic */ boolean $protectContent;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(Object obj) {
            invoke((AbstractSendRequest) obj);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05855(boolean z10) {
            super(1);
            this.$protectContent = z10;
        }

        public final void invoke(REQ applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setProtectContent(Boolean.valueOf(this.$protectContent));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.AbstractSendRequest$replyMarkup$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "REQ", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/AbstractSendRequest;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C05865 extends o implements l<REQ, z> {
        final /* synthetic */ Keyboard $replyMarkup;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(Object obj) {
            invoke((AbstractSendRequest) obj);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05865(Keyboard keyboard) {
            super(1);
            this.$replyMarkup = keyboard;
        }

        public final void invoke(REQ applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setReplyMarkup(this.$replyMarkup);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.AbstractSendRequest$replyParameters$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "REQ", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/AbstractSendRequest;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C05875 extends o implements l<REQ, z> {
        final /* synthetic */ ReplyParameters $replyParameters;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(Object obj) {
            invoke((AbstractSendRequest) obj);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05875(ReplyParameters replyParameters) {
            super(1);
            this.$replyParameters = replyParameters;
        }

        public final void invoke(REQ applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setReplyParameters(this.$replyParameters);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.AbstractSendRequest$suggestedPostParameters$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "REQ", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/AbstractSendRequest;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C05885 extends o implements l<REQ, z> {
        final /* synthetic */ SuggestedPostParameters $suggestedPostParameters;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(Object obj) {
            invoke((AbstractSendRequest) obj);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05885(SuggestedPostParameters suggestedPostParameters) {
            super(1);
            this.$suggestedPostParameters = suggestedPostParameters;
        }

        public final void invoke(REQ applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setSuggestedPostParameters(this.$suggestedPostParameters);
        }
    }

    public AbstractSendRequest(Long l10, String str) {
        super(c0.b(SendResponse.class));
        RequestParameterDelegate requestParameterDelegateOptionalRequestParameter$default = RequestParameterDelegateKt.optionalRequestParameter$default(l10, "chat_id", null, 4, null);
        k<?>[] kVarArr = $$delegatedProperties;
        this.chatId = requestParameterDelegateOptionalRequestParameter$default.provideDelegate(this, kVarArr[0]);
        this.channelUsername = RequestParameterDelegateKt.optionalRequestParameter$default(str, "chat_id", null, 4, null).provideDelegate(this, kVarArr[1]);
        this.businessConnectionId = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[2]);
        this.messageThreadId = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[3]);
        this.directMessagesTopicId = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[4]);
        this.disableNotification = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[5]);
        this.protectContent = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[6]);
        this.allowPaidBroadcast = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[7]);
        this.messageEffectId = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[8]);
        this.replyParameters = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[9]);
        this.replyMarkup = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[10]);
        this.suggestedPostParameters = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[11]);
    }

    public final REQ allowPaidBroadcast(boolean allowPaidBroadcast) {
        return applySelf(new AnonymousClass5(allowPaidBroadcast));
    }

    public final REQ businessConnectionId(String businessConnectionId) {
        m.f(businessConnectionId, "businessConnectionId");
        return applySelf(new C05805(businessConnectionId));
    }

    public final REQ directMessagesTopicId(int directMessagesTopicId) {
        return applySelf(new C05815(directMessagesTopicId));
    }

    public final REQ disableNotification(boolean disableNotification) {
        return applySelf(new C05825(disableNotification));
    }

    public final Boolean getAllowPaidBroadcast() {
        return (Boolean) this.allowPaidBroadcast.getValue(this, $$delegatedProperties[7]);
    }

    public final String getBusinessConnectionId() {
        return (String) this.businessConnectionId.getValue(this, $$delegatedProperties[2]);
    }

    public final String getChannelUsername() {
        return (String) this.channelUsername.getValue(this, $$delegatedProperties[1]);
    }

    public final Long getChatId() {
        return (Long) this.chatId.getValue(this, $$delegatedProperties[0]);
    }

    public final Integer getDirectMessagesTopicId() {
        return (Integer) this.directMessagesTopicId.getValue(this, $$delegatedProperties[4]);
    }

    public final Boolean getDisableNotification() {
        return (Boolean) this.disableNotification.getValue(this, $$delegatedProperties[5]);
    }

    public final String getMessageEffectId() {
        return (String) this.messageEffectId.getValue(this, $$delegatedProperties[8]);
    }

    public final Integer getMessageThreadId() {
        return (Integer) this.messageThreadId.getValue(this, $$delegatedProperties[3]);
    }

    public final Boolean getProtectContent() {
        return (Boolean) this.protectContent.getValue(this, $$delegatedProperties[6]);
    }

    public final Keyboard getReplyMarkup() {
        return (Keyboard) this.replyMarkup.getValue(this, $$delegatedProperties[10]);
    }

    public final ReplyParameters getReplyParameters() {
        return (ReplyParameters) this.replyParameters.getValue(this, $$delegatedProperties[9]);
    }

    public final SuggestedPostParameters getSuggestedPostParameters() {
        return (SuggestedPostParameters) this.suggestedPostParameters.getValue(this, $$delegatedProperties[11]);
    }

    public final REQ messageEffectId(String messageEffectId) {
        m.f(messageEffectId, "messageEffectId");
        return applySelf(new C05835(messageEffectId));
    }

    public final REQ messageThreadId(int messageThreadId) {
        return applySelf(new C05845(messageThreadId));
    }

    public final REQ protectContent(boolean protectContent) {
        return applySelf(new C05855(protectContent));
    }

    public final REQ replyMarkup(Keyboard replyMarkup) {
        m.f(replyMarkup, "replyMarkup");
        return applySelf(new C05865(replyMarkup));
    }

    public final REQ replyParameters(ReplyParameters replyParameters) {
        m.f(replyParameters, "replyParameters");
        return applySelf(new C05875(replyParameters));
    }

    public final void setAllowPaidBroadcast(Boolean bool) {
        this.allowPaidBroadcast.setValue(this, $$delegatedProperties[7], bool);
    }

    public final void setBusinessConnectionId(String str) {
        this.businessConnectionId.setValue(this, $$delegatedProperties[2], str);
    }

    public final void setDirectMessagesTopicId(Integer num) {
        this.directMessagesTopicId.setValue(this, $$delegatedProperties[4], num);
    }

    public final void setDisableNotification(Boolean bool) {
        this.disableNotification.setValue(this, $$delegatedProperties[5], bool);
    }

    public final void setMessageEffectId(String str) {
        this.messageEffectId.setValue(this, $$delegatedProperties[8], str);
    }

    public final void setMessageThreadId(Integer num) {
        this.messageThreadId.setValue(this, $$delegatedProperties[3], num);
    }

    public final void setProtectContent(Boolean bool) {
        this.protectContent.setValue(this, $$delegatedProperties[6], bool);
    }

    public final void setReplyMarkup(Keyboard keyboard) {
        this.replyMarkup.setValue(this, $$delegatedProperties[10], keyboard);
    }

    public final void setReplyParameters(ReplyParameters replyParameters) {
        this.replyParameters.setValue(this, $$delegatedProperties[9], replyParameters);
    }

    public final void setSuggestedPostParameters(SuggestedPostParameters suggestedPostParameters) {
        this.suggestedPostParameters.setValue(this, $$delegatedProperties[11], suggestedPostParameters);
    }

    public final REQ suggestedPostParameters(SuggestedPostParameters suggestedPostParameters) {
        m.f(suggestedPostParameters, "suggestedPostParameters");
        return applySelf(new C05885(suggestedPostParameters));
    }
}
