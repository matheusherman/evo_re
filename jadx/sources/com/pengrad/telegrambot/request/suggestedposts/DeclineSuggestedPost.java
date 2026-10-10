package com.pengrad.telegrambot.request.suggestedposts;

import c9.l;
import com.pengrad.telegrambot.request.KBaseRequest;
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
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bR\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR/\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/pengrad/telegrambot/request/suggestedposts/DeclineSuggestedPost;", "Lcom/pengrad/telegrambot/request/KBaseRequest;", "Lcom/pengrad/telegrambot/response/BaseResponse;", "chatId", "", "messageId", "", "comment", "", "(JILjava/lang/String;)V", "getChatId", "()J", "chatId$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "<set-?>", "getComment", "()Ljava/lang/String;", "setComment", "(Ljava/lang/String;)V", "comment$delegate", "getMessageId", "()I", "messageId$delegate", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DeclineSuggestedPost extends KBaseRequest<DeclineSuggestedPost, BaseResponse> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(DeclineSuggestedPost.class, "chatId", "getChatId()J", 0)), c0.g(new w(DeclineSuggestedPost.class, "messageId", "getMessageId()I", 0)), c0.e(new q(DeclineSuggestedPost.class, "comment", "getComment()Ljava/lang/String;", 0))};

    /* JADX INFO: renamed from: chatId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate chatId;

    /* JADX INFO: renamed from: comment$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate comment;

    /* JADX INFO: renamed from: messageId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate messageId;

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.suggestedposts.DeclineSuggestedPost$comment$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/suggestedposts/DeclineSuggestedPost;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/suggestedposts/DeclineSuggestedPost;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass5 extends o implements l<DeclineSuggestedPost, z> {
        final /* synthetic */ String $comment;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(DeclineSuggestedPost declineSuggestedPost) {
            invoke2(declineSuggestedPost);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(String str) {
            super(1);
            this.$comment = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DeclineSuggestedPost applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setComment(this.$comment);
        }
    }

    public DeclineSuggestedPost(long j10, int i10, String str) {
        super(c0.b(BaseResponse.class));
        RequestParameterDelegate requestParameterDelegateRequestParameter$default = RequestParameterDelegateKt.requestParameter$default(Long.valueOf(j10), null, 2, null);
        k<?>[] kVarArr = $$delegatedProperties;
        this.chatId = requestParameterDelegateRequestParameter$default.provideDelegate(this, kVarArr[0]);
        this.messageId = RequestParameterDelegateKt.requestParameter$default(Integer.valueOf(i10), null, 2, null).provideDelegate(this, kVarArr[1]);
        this.comment = RequestParameterDelegateKt.optionalRequestParameter$default(str, null, null, 6, null).provideDelegate(this, kVarArr[2]);
    }

    public final DeclineSuggestedPost comment(String comment) {
        m.f(comment, "comment");
        return applySelf(new AnonymousClass5(comment));
    }

    public final long getChatId() {
        return ((Number) this.chatId.getValue(this, $$delegatedProperties[0])).longValue();
    }

    public final String getComment() {
        return (String) this.comment.getValue(this, $$delegatedProperties[2]);
    }

    public final int getMessageId() {
        return ((Number) this.messageId.getValue(this, $$delegatedProperties[1])).intValue();
    }

    public final void setComment(String str) {
        this.comment.setValue(this, $$delegatedProperties[2], str);
    }
}
