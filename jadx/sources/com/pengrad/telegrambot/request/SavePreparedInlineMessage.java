package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.request.InlineQueryResult;
import com.pengrad.telegrambot.response.SavePreparedInlineMessageResponse;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegate;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegateKt;
import i9.k;
import kotlin.Metadata;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.w;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\tJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\tJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\tR/\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR/\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR/\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR/\u0010\u0019\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR\u001f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0010\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/pengrad/telegrambot/request/SavePreparedInlineMessage;", "Lcom/pengrad/telegrambot/request/KBaseRequest;", "Lcom/pengrad/telegrambot/response/SavePreparedInlineMessageResponse;", "userId", "", "result", "Lcom/pengrad/telegrambot/model/request/InlineQueryResult;", "(JLcom/pengrad/telegrambot/model/request/InlineQueryResult;)V", "<set-?>", "", "allowBotChats", "getAllowBotChats", "()Ljava/lang/Boolean;", "setAllowBotChats", "(Ljava/lang/Boolean;)V", "allowBotChats$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "allowChannelChats", "getAllowChannelChats", "setAllowChannelChats", "allowChannelChats$delegate", "allowGroupChats", "getAllowGroupChats", "setAllowGroupChats", "allowGroupChats$delegate", "allowUserChats", "getAllowUserChats", "setAllowUserChats", "allowUserChats$delegate", "getResult", "()Lcom/pengrad/telegrambot/model/request/InlineQueryResult;", "result$delegate", "getUserId", "()J", "userId$delegate", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SavePreparedInlineMessage extends KBaseRequest<SavePreparedInlineMessage, SavePreparedInlineMessageResponse> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(SavePreparedInlineMessage.class, "userId", "getUserId()J", 0)), c0.g(new w(SavePreparedInlineMessage.class, "result", "getResult()Lcom/pengrad/telegrambot/model/request/InlineQueryResult;", 0)), c0.e(new q(SavePreparedInlineMessage.class, "allowUserChats", "getAllowUserChats()Ljava/lang/Boolean;", 0)), c0.e(new q(SavePreparedInlineMessage.class, "allowBotChats", "getAllowBotChats()Ljava/lang/Boolean;", 0)), c0.e(new q(SavePreparedInlineMessage.class, "allowGroupChats", "getAllowGroupChats()Ljava/lang/Boolean;", 0)), c0.e(new q(SavePreparedInlineMessage.class, "allowChannelChats", "getAllowChannelChats()Ljava/lang/Boolean;", 0))};

    /* JADX INFO: renamed from: allowBotChats$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate allowBotChats;

    /* JADX INFO: renamed from: allowChannelChats$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate allowChannelChats;

    /* JADX INFO: renamed from: allowGroupChats$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate allowGroupChats;

    /* JADX INFO: renamed from: allowUserChats$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate allowUserChats;

    /* JADX INFO: renamed from: result$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate result;

    /* JADX INFO: renamed from: userId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SavePreparedInlineMessage(long j10, InlineQueryResult<?> result) {
        super(c0.b(SavePreparedInlineMessageResponse.class));
        m.f(result, "result");
        RequestParameterDelegate requestParameterDelegateRequestParameter = RequestParameterDelegateKt.requestParameter(Long.valueOf(j10), "user_id");
        k<?>[] kVarArr = $$delegatedProperties;
        this.userId = requestParameterDelegateRequestParameter.provideDelegate(this, kVarArr[0]);
        this.result = RequestParameterDelegateKt.requestParameter$default(result, null, 2, null).provideDelegate(this, kVarArr[1]);
        this.allowUserChats = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[2]);
        this.allowBotChats = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[3]);
        this.allowGroupChats = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[4]);
        this.allowChannelChats = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[5]);
    }

    public final Boolean getAllowBotChats() {
        return (Boolean) this.allowBotChats.getValue(this, $$delegatedProperties[3]);
    }

    public final Boolean getAllowChannelChats() {
        return (Boolean) this.allowChannelChats.getValue(this, $$delegatedProperties[5]);
    }

    public final Boolean getAllowGroupChats() {
        return (Boolean) this.allowGroupChats.getValue(this, $$delegatedProperties[4]);
    }

    public final Boolean getAllowUserChats() {
        return (Boolean) this.allowUserChats.getValue(this, $$delegatedProperties[2]);
    }

    public final InlineQueryResult<?> getResult() {
        return (InlineQueryResult) this.result.getValue(this, $$delegatedProperties[1]);
    }

    public final long getUserId() {
        return ((Number) this.userId.getValue(this, $$delegatedProperties[0])).longValue();
    }

    public final void setAllowBotChats(Boolean bool) {
        this.allowBotChats.setValue(this, $$delegatedProperties[3], bool);
    }

    public final void setAllowChannelChats(Boolean bool) {
        this.allowChannelChats.setValue(this, $$delegatedProperties[5], bool);
    }

    public final void setAllowGroupChats(Boolean bool) {
        this.allowGroupChats.setValue(this, $$delegatedProperties[4], bool);
    }

    public final void setAllowUserChats(Boolean bool) {
        this.allowUserChats.setValue(this, $$delegatedProperties[2], bool);
    }

    public final SavePreparedInlineMessage allowBotChats(boolean allowBotChats) {
        setAllowBotChats(Boolean.valueOf(allowBotChats));
        return this;
    }

    public final SavePreparedInlineMessage allowChannelChats(boolean allowChannelChats) {
        setAllowChannelChats(Boolean.valueOf(allowChannelChats));
        return this;
    }

    public final SavePreparedInlineMessage allowGroupChats(boolean allowGroupChats) {
        setAllowGroupChats(Boolean.valueOf(allowGroupChats));
        return this;
    }

    public final SavePreparedInlineMessage allowUserChats(boolean allowUserChats) {
        setAllowUserChats(Boolean.valueOf(allowUserChats));
        return this;
    }
}
