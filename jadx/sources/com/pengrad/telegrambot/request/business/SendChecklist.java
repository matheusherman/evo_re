package com.pengrad.telegrambot.request.business;

import c9.l;
import com.pengrad.telegrambot.model.checklist.InputChecklist;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.ReplyParameters;
import com.pengrad.telegrambot.request.KBaseRequest;
import com.pengrad.telegrambot.response.SendChecklistResponse;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tBO\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fR\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001a\u0010\u001bR/\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0016\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R/\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010\u0016\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010%R/\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b)\u0010\u0016\u001a\u0004\b'\u0010\u001f\"\u0004\b(\u0010!R/\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u00118F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010\u0016\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R/\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b3\u0010\u0016\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/pengrad/telegrambot/request/business/SendChecklist;", "Lcom/pengrad/telegrambot/request/KBaseRequest;", "Lcom/pengrad/telegrambot/response/SendChecklistResponse;", "businessConnectionId", "", "chatId", "", "checklist", "Lcom/pengrad/telegrambot/model/checklist/InputChecklist;", "(Ljava/lang/String;JLcom/pengrad/telegrambot/model/checklist/InputChecklist;)V", "disableNotification", "", "protectContent", "messageEffectId", "replyParameters", "Lcom/pengrad/telegrambot/model/request/ReplyParameters;", "replyMarkup", "Lcom/pengrad/telegrambot/model/request/InlineKeyboardMarkup;", "(Ljava/lang/String;JLcom/pengrad/telegrambot/model/checklist/InputChecklist;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/pengrad/telegrambot/model/request/ReplyParameters;Lcom/pengrad/telegrambot/model/request/InlineKeyboardMarkup;)V", "getBusinessConnectionId", "()Ljava/lang/String;", "businessConnectionId$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "getChatId", "()J", "chatId$delegate", "getChecklist", "()Lcom/pengrad/telegrambot/model/checklist/InputChecklist;", "checklist$delegate", "<set-?>", "getDisableNotification", "()Ljava/lang/Boolean;", "setDisableNotification", "(Ljava/lang/Boolean;)V", "disableNotification$delegate", "getMessageEffectId", "setMessageEffectId", "(Ljava/lang/String;)V", "messageEffectId$delegate", "getProtectContent", "setProtectContent", "protectContent$delegate", "getReplyMarkup", "()Lcom/pengrad/telegrambot/model/request/InlineKeyboardMarkup;", "setReplyMarkup", "(Lcom/pengrad/telegrambot/model/request/InlineKeyboardMarkup;)V", "replyMarkup$delegate", "getReplyParameters", "()Lcom/pengrad/telegrambot/model/request/ReplyParameters;", "setReplyParameters", "(Lcom/pengrad/telegrambot/model/request/ReplyParameters;)V", "replyParameters$delegate", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SendChecklist extends KBaseRequest<SendChecklist, SendChecklistResponse> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(SendChecklist.class, "businessConnectionId", "getBusinessConnectionId()Ljava/lang/String;", 0)), c0.g(new w(SendChecklist.class, "chatId", "getChatId()J", 0)), c0.g(new w(SendChecklist.class, "checklist", "getChecklist()Lcom/pengrad/telegrambot/model/checklist/InputChecklist;", 0)), c0.e(new q(SendChecklist.class, "disableNotification", "getDisableNotification()Ljava/lang/Boolean;", 0)), c0.e(new q(SendChecklist.class, "protectContent", "getProtectContent()Ljava/lang/Boolean;", 0)), c0.e(new q(SendChecklist.class, "messageEffectId", "getMessageEffectId()Ljava/lang/String;", 0)), c0.e(new q(SendChecklist.class, "replyParameters", "getReplyParameters()Lcom/pengrad/telegrambot/model/request/ReplyParameters;", 0)), c0.e(new q(SendChecklist.class, "replyMarkup", "getReplyMarkup()Lcom/pengrad/telegrambot/model/request/InlineKeyboardMarkup;", 0))};

    /* JADX INFO: renamed from: businessConnectionId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate businessConnectionId;

    /* JADX INFO: renamed from: chatId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate chatId;

    /* JADX INFO: renamed from: checklist$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate checklist;

    /* JADX INFO: renamed from: disableNotification$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate disableNotification;

    /* JADX INFO: renamed from: messageEffectId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate messageEffectId;

    /* JADX INFO: renamed from: protectContent$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate protectContent;

    /* JADX INFO: renamed from: replyMarkup$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate replyMarkup;

    /* JADX INFO: renamed from: replyParameters$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate replyParameters;

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.business.SendChecklist$disableNotification$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/business/SendChecklist;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/business/SendChecklist;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass5 extends o implements l<SendChecklist, z> {
        final /* synthetic */ boolean $disableNotification;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendChecklist sendChecklist) {
            invoke2(sendChecklist);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(boolean z10) {
            super(1);
            this.$disableNotification = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendChecklist applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setDisableNotification(Boolean.valueOf(this.$disableNotification));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.business.SendChecklist$messageEffectId$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/business/SendChecklist;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/business/SendChecklist;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06805 extends o implements l<SendChecklist, z> {
        final /* synthetic */ String $messageEffectId;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendChecklist sendChecklist) {
            invoke2(sendChecklist);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06805(String str) {
            super(1);
            this.$messageEffectId = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendChecklist applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setMessageEffectId(this.$messageEffectId);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.business.SendChecklist$protectContent$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/business/SendChecklist;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/business/SendChecklist;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06815 extends o implements l<SendChecklist, z> {
        final /* synthetic */ boolean $protectContent;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendChecklist sendChecklist) {
            invoke2(sendChecklist);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06815(boolean z10) {
            super(1);
            this.$protectContent = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendChecklist applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setProtectContent(Boolean.valueOf(this.$protectContent));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.business.SendChecklist$replyMarkup$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/business/SendChecklist;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/business/SendChecklist;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06825 extends o implements l<SendChecklist, z> {
        final /* synthetic */ InlineKeyboardMarkup $replyMarkup;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendChecklist sendChecklist) {
            invoke2(sendChecklist);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06825(InlineKeyboardMarkup inlineKeyboardMarkup) {
            super(1);
            this.$replyMarkup = inlineKeyboardMarkup;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendChecklist applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setReplyMarkup(this.$replyMarkup);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.business.SendChecklist$replyParameters$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/business/SendChecklist;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/business/SendChecklist;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06835 extends o implements l<SendChecklist, z> {
        final /* synthetic */ ReplyParameters $replyParameters;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendChecklist sendChecklist) {
            invoke2(sendChecklist);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06835(ReplyParameters replyParameters) {
            super(1);
            this.$replyParameters = replyParameters;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendChecklist applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setReplyParameters(this.$replyParameters);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendChecklist(String businessConnectionId, long j10, InputChecklist checklist, Boolean bool, Boolean bool2, String str, ReplyParameters replyParameters, InlineKeyboardMarkup inlineKeyboardMarkup) {
        super(c0.b(SendChecklistResponse.class));
        m.f(businessConnectionId, "businessConnectionId");
        m.f(checklist, "checklist");
        RequestParameterDelegate requestParameterDelegateRequestParameter = RequestParameterDelegateKt.requestParameter(businessConnectionId, "business_connection_id");
        k<?>[] kVarArr = $$delegatedProperties;
        this.businessConnectionId = requestParameterDelegateRequestParameter.provideDelegate(this, kVarArr[0]);
        this.chatId = RequestParameterDelegateKt.requestParameter(Long.valueOf(j10), "chat_id").provideDelegate(this, kVarArr[1]);
        this.checklist = RequestParameterDelegateKt.requestParameter(checklist, "checklist").provideDelegate(this, kVarArr[2]);
        this.disableNotification = RequestParameterDelegateKt.optionalRequestParameter$default(bool, "disable_notification", null, 4, null).provideDelegate(this, kVarArr[3]);
        this.protectContent = RequestParameterDelegateKt.optionalRequestParameter$default(bool2, "protect_content", null, 4, null).provideDelegate(this, kVarArr[4]);
        this.messageEffectId = RequestParameterDelegateKt.optionalRequestParameter$default(str, "message_effect_id", null, 4, null).provideDelegate(this, kVarArr[5]);
        this.replyParameters = RequestParameterDelegateKt.optionalRequestParameter$default(replyParameters, "reply_parameters", null, 4, null).provideDelegate(this, kVarArr[6]);
        this.replyMarkup = RequestParameterDelegateKt.optionalRequestParameter$default(inlineKeyboardMarkup, "reply_markup", null, 4, null).provideDelegate(this, kVarArr[7]);
    }

    public final SendChecklist disableNotification(boolean disableNotification) {
        return applySelf(new AnonymousClass5(disableNotification));
    }

    public final String getBusinessConnectionId() {
        return (String) this.businessConnectionId.getValue(this, $$delegatedProperties[0]);
    }

    public final long getChatId() {
        return ((Number) this.chatId.getValue(this, $$delegatedProperties[1])).longValue();
    }

    public final InputChecklist getChecklist() {
        return (InputChecklist) this.checklist.getValue(this, $$delegatedProperties[2]);
    }

    public final Boolean getDisableNotification() {
        return (Boolean) this.disableNotification.getValue(this, $$delegatedProperties[3]);
    }

    public final String getMessageEffectId() {
        return (String) this.messageEffectId.getValue(this, $$delegatedProperties[5]);
    }

    public final Boolean getProtectContent() {
        return (Boolean) this.protectContent.getValue(this, $$delegatedProperties[4]);
    }

    public final InlineKeyboardMarkup getReplyMarkup() {
        return (InlineKeyboardMarkup) this.replyMarkup.getValue(this, $$delegatedProperties[7]);
    }

    public final ReplyParameters getReplyParameters() {
        return (ReplyParameters) this.replyParameters.getValue(this, $$delegatedProperties[6]);
    }

    public final SendChecklist messageEffectId(String messageEffectId) {
        m.f(messageEffectId, "messageEffectId");
        return applySelf(new C06805(messageEffectId));
    }

    public final SendChecklist protectContent(boolean protectContent) {
        return applySelf(new C06815(protectContent));
    }

    public final SendChecklist replyMarkup(InlineKeyboardMarkup replyMarkup) {
        m.f(replyMarkup, "replyMarkup");
        return applySelf(new C06825(replyMarkup));
    }

    public final SendChecklist replyParameters(ReplyParameters replyParameters) {
        m.f(replyParameters, "replyParameters");
        return applySelf(new C06835(replyParameters));
    }

    public final void setDisableNotification(Boolean bool) {
        this.disableNotification.setValue(this, $$delegatedProperties[3], bool);
    }

    public final void setMessageEffectId(String str) {
        this.messageEffectId.setValue(this, $$delegatedProperties[5], str);
    }

    public final void setProtectContent(Boolean bool) {
        this.protectContent.setValue(this, $$delegatedProperties[4], bool);
    }

    public final void setReplyMarkup(InlineKeyboardMarkup inlineKeyboardMarkup) {
        this.replyMarkup.setValue(this, $$delegatedProperties[7], inlineKeyboardMarkup);
    }

    public final void setReplyParameters(ReplyParameters replyParameters) {
        this.replyParameters.setValue(this, $$delegatedProperties[6], replyParameters);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendChecklist(String businessConnectionId, long j10, InputChecklist checklist) {
        this(businessConnectionId, j10, checklist, null, null, null, null, null);
        m.f(businessConnectionId, "businessConnectionId");
        m.f(checklist, "checklist");
    }
}
