package com.pengrad.telegrambot.request.business;

import c9.l;
import com.pengrad.telegrambot.model.checklist.InputChecklist;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.KBaseRequest;
import com.pengrad.telegrambot.response.EditMessageChecklistResponse;
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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rR\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u0019\u0010\u001aR/\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u0012\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/pengrad/telegrambot/request/business/EditMessageChecklist;", "Lcom/pengrad/telegrambot/request/KBaseRequest;", "Lcom/pengrad/telegrambot/response/EditMessageChecklistResponse;", "businessConnectionId", "", "chatId", "", "messageId", "", "checklist", "Lcom/pengrad/telegrambot/model/checklist/InputChecklist;", "(Ljava/lang/String;JILcom/pengrad/telegrambot/model/checklist/InputChecklist;)V", "replyMarkup", "Lcom/pengrad/telegrambot/model/request/InlineKeyboardMarkup;", "(Ljava/lang/String;JILcom/pengrad/telegrambot/model/checklist/InputChecklist;Lcom/pengrad/telegrambot/model/request/InlineKeyboardMarkup;)V", "getBusinessConnectionId", "()Ljava/lang/String;", "businessConnectionId$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "getChatId", "()J", "chatId$delegate", "getChecklist", "()Lcom/pengrad/telegrambot/model/checklist/InputChecklist;", "checklist$delegate", "getMessageId", "()I", "messageId$delegate", "<set-?>", "getReplyMarkup", "()Lcom/pengrad/telegrambot/model/request/InlineKeyboardMarkup;", "setReplyMarkup", "(Lcom/pengrad/telegrambot/model/request/InlineKeyboardMarkup;)V", "replyMarkup$delegate", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EditMessageChecklist extends KBaseRequest<EditMessageChecklist, EditMessageChecklistResponse> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(EditMessageChecklist.class, "businessConnectionId", "getBusinessConnectionId()Ljava/lang/String;", 0)), c0.g(new w(EditMessageChecklist.class, "chatId", "getChatId()J", 0)), c0.g(new w(EditMessageChecklist.class, "messageId", "getMessageId()I", 0)), c0.g(new w(EditMessageChecklist.class, "checklist", "getChecklist()Lcom/pengrad/telegrambot/model/checklist/InputChecklist;", 0)), c0.e(new q(EditMessageChecklist.class, "replyMarkup", "getReplyMarkup()Lcom/pengrad/telegrambot/model/request/InlineKeyboardMarkup;", 0))};

    /* JADX INFO: renamed from: businessConnectionId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate businessConnectionId;

    /* JADX INFO: renamed from: chatId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate chatId;

    /* JADX INFO: renamed from: checklist$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate checklist;

    /* JADX INFO: renamed from: messageId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate messageId;

    /* JADX INFO: renamed from: replyMarkup$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate replyMarkup;

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.business.EditMessageChecklist$replyMarkup$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/business/EditMessageChecklist;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/business/EditMessageChecklist;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass5 extends o implements l<EditMessageChecklist, z> {
        final /* synthetic */ InlineKeyboardMarkup $replyMarkup;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(EditMessageChecklist editMessageChecklist) {
            invoke2(editMessageChecklist);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(InlineKeyboardMarkup inlineKeyboardMarkup) {
            super(1);
            this.$replyMarkup = inlineKeyboardMarkup;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EditMessageChecklist applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setReplyMarkup(this.$replyMarkup);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditMessageChecklist(String businessConnectionId, long j10, int i10, InputChecklist checklist, InlineKeyboardMarkup inlineKeyboardMarkup) {
        super(c0.b(EditMessageChecklistResponse.class));
        m.f(businessConnectionId, "businessConnectionId");
        m.f(checklist, "checklist");
        RequestParameterDelegate requestParameterDelegateRequestParameter = RequestParameterDelegateKt.requestParameter(businessConnectionId, "business_connection_id");
        k<?>[] kVarArr = $$delegatedProperties;
        this.businessConnectionId = requestParameterDelegateRequestParameter.provideDelegate(this, kVarArr[0]);
        this.chatId = RequestParameterDelegateKt.requestParameter(Long.valueOf(j10), "chat_id").provideDelegate(this, kVarArr[1]);
        this.messageId = RequestParameterDelegateKt.requestParameter(Integer.valueOf(i10), "message_id").provideDelegate(this, kVarArr[2]);
        this.checklist = RequestParameterDelegateKt.requestParameter(checklist, "checklist").provideDelegate(this, kVarArr[3]);
        this.replyMarkup = RequestParameterDelegateKt.optionalRequestParameter$default(inlineKeyboardMarkup, "reply_markup", null, 4, null).provideDelegate(this, kVarArr[4]);
    }

    public final String getBusinessConnectionId() {
        return (String) this.businessConnectionId.getValue(this, $$delegatedProperties[0]);
    }

    public final long getChatId() {
        return ((Number) this.chatId.getValue(this, $$delegatedProperties[1])).longValue();
    }

    public final InputChecklist getChecklist() {
        return (InputChecklist) this.checklist.getValue(this, $$delegatedProperties[3]);
    }

    public final int getMessageId() {
        return ((Number) this.messageId.getValue(this, $$delegatedProperties[2])).intValue();
    }

    public final InlineKeyboardMarkup getReplyMarkup() {
        return (InlineKeyboardMarkup) this.replyMarkup.getValue(this, $$delegatedProperties[4]);
    }

    public final EditMessageChecklist replyMarkup(InlineKeyboardMarkup replyMarkup) {
        m.f(replyMarkup, "replyMarkup");
        return applySelf(new AnonymousClass5(replyMarkup));
    }

    public final void setReplyMarkup(InlineKeyboardMarkup inlineKeyboardMarkup) {
        this.replyMarkup.setValue(this, $$delegatedProperties[4], inlineKeyboardMarkup);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EditMessageChecklist(String businessConnectionId, long j10, int i10, InputChecklist checklist) {
        this(businessConnectionId, j10, i10, checklist, null);
        m.f(businessConnectionId, "businessConnectionId");
        m.f(checklist, "checklist");
    }
}
