package com.pengrad.telegrambot.request;

import c9.l;
import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.Poll;
import com.pengrad.telegrambot.model.request.InputPollOption;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegate;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegateKt;
import i9.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.j;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.w;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tB%\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\u000bB+\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\r\"\u00020\b¢\u0006\u0002\u0010\u000eB5\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010[\u001a\u00020\u0011J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0003J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010&\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0005J\u001f\u0010-\u001a\u00020\u00002\u0012\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020,0\r\"\u00020,¢\u0006\u0002\u0010\\J\u0014\u0010-\u001a\u00020\u00002\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\u0007J\u000e\u00104\u001a\u00020\u00002\u0006\u00104\u001a\u000203J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u0011J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u0011J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\u001fJ\u001f\u0010H\u001a\u00020\u00002\u0012\u0010H\u001a\n\u0012\u0006\b\u0001\u0012\u00020,0\r\"\u00020,¢\u0006\u0002\u0010\\J\u0014\u0010H\u001a\u00020\u00002\f\u0010H\u001a\b\u0012\u0004\u0012\u00020,0\u0007J\u000e\u0010L\u001a\u00020\u00002\u0006\u0010L\u001a\u000203J\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020PJ\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010W\u001a\u00020\u0005R/\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u00118F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R/\u0010\u0019\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR/\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u001f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0018\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R/\u0010&\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0018\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R;\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00072\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b2\u0010\u0018\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R/\u00104\u001a\u0004\u0018\u0001032\b\u0010\u0010\u001a\u0004\u0018\u0001038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b9\u0010\u0018\u001a\u0004\b5\u00106\"\u0004\b7\u00108R/\u0010:\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u00118F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b<\u0010\u0018\u001a\u0004\b:\u0010\u0014\"\u0004\b;\u0010\u0016R/\u0010=\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u00118F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b?\u0010\u0018\u001a\u0004\b=\u0010\u0014\"\u0004\b>\u0010\u0016R/\u0010@\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u001f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bC\u0010\u0018\u001a\u0004\bA\u0010\"\"\u0004\bB\u0010$R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0018\u001a\u0004\bD\u0010/R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u0018\u001a\u0004\bF\u0010(R;\u0010H\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00072\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bK\u0010\u0018\u001a\u0004\bI\u0010/\"\u0004\bJ\u00101R/\u0010L\u001a\u0004\u0018\u0001032\b\u0010\u0010\u001a\u0004\u0018\u0001038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bO\u0010\u0018\u001a\u0004\bM\u00106\"\u0004\bN\u00108R/\u0010Q\u001a\u0004\u0018\u00010P2\b\u0010\u0010\u001a\u0004\u0018\u00010P8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bV\u0010\u0018\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR/\u0010W\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bZ\u0010\u0018\u001a\u0004\bX\u0010(\"\u0004\bY\u0010*¨\u0006]"}, d2 = {"Lcom/pengrad/telegrambot/request/SendPoll;", "Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "chatId", "", "question", "", "options", "", "Lcom/pengrad/telegrambot/model/request/InputPollOption;", "(JLjava/lang/String;Ljava/util/List;)V", "channelUsername", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "", "", "(Ljava/lang/Object;Ljava/lang/String;[Lcom/pengrad/telegrambot/model/request/InputPollOption;)V", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "<set-?>", "", "allowsMultipleAnswers", "getAllowsMultipleAnswers", "()Ljava/lang/Boolean;", "setAllowsMultipleAnswers", "(Ljava/lang/Boolean;)V", "allowsMultipleAnswers$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "closeDate", "getCloseDate", "()Ljava/lang/Long;", "setCloseDate", "(Ljava/lang/Long;)V", "closeDate$delegate", "", "correctOptionId", "getCorrectOptionId", "()Ljava/lang/Integer;", "setCorrectOptionId", "(Ljava/lang/Integer;)V", "correctOptionId$delegate", "explanation", "getExplanation", "()Ljava/lang/String;", "setExplanation", "(Ljava/lang/String;)V", "explanation$delegate", "Lcom/pengrad/telegrambot/model/MessageEntity;", "explanationEntities", "getExplanationEntities", "()Ljava/util/List;", "setExplanationEntities", "(Ljava/util/List;)V", "explanationEntities$delegate", "Lcom/pengrad/telegrambot/model/request/ParseMode;", "explanationParseMode", "getExplanationParseMode", "()Lcom/pengrad/telegrambot/model/request/ParseMode;", "setExplanationParseMode", "(Lcom/pengrad/telegrambot/model/request/ParseMode;)V", "explanationParseMode$delegate", "isAnonymous", "setAnonymous", "isAnonymous$delegate", "isClosed", "setClosed", "isClosed$delegate", "openPeriod", "getOpenPeriod", "setOpenPeriod", "openPeriod$delegate", "getOptions", "options$delegate", "getQuestion", "question$delegate", "questionEntities", "getQuestionEntities", "setQuestionEntities", "questionEntities$delegate", "questionParseMode", "getQuestionParseMode", "setQuestionParseMode", "questionParseMode$delegate", "Lcom/pengrad/telegrambot/model/Poll$Type;", IjkMediaMeta.IJKM_KEY_TYPE, "getType", "()Lcom/pengrad/telegrambot/model/Poll$Type;", "setType", "(Lcom/pengrad/telegrambot/model/Poll$Type;)V", "type$delegate", "typeRaw", "getTypeRaw", "setTypeRaw", "typeRaw$delegate", "allowMultipleAnswers", "([Lcom/pengrad/telegrambot/model/MessageEntity;)Lcom/pengrad/telegrambot/request/SendPoll;", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SendPoll extends AbstractSendRequest<SendPoll> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(SendPoll.class, "question", "getQuestion()Ljava/lang/String;", 0)), c0.g(new w(SendPoll.class, "options", "getOptions()Ljava/util/List;", 0)), c0.e(new q(SendPoll.class, IjkMediaMeta.IJKM_KEY_TYPE, "getType()Lcom/pengrad/telegrambot/model/Poll$Type;", 0)), c0.e(new q(SendPoll.class, "typeRaw", "getTypeRaw()Ljava/lang/String;", 0)), c0.e(new q(SendPoll.class, "isAnonymous", "isAnonymous()Ljava/lang/Boolean;", 0)), c0.e(new q(SendPoll.class, "allowsMultipleAnswers", "getAllowsMultipleAnswers()Ljava/lang/Boolean;", 0)), c0.e(new q(SendPoll.class, "correctOptionId", "getCorrectOptionId()Ljava/lang/Integer;", 0)), c0.e(new q(SendPoll.class, "questionParseMode", "getQuestionParseMode()Lcom/pengrad/telegrambot/model/request/ParseMode;", 0)), c0.e(new q(SendPoll.class, "questionEntities", "getQuestionEntities()Ljava/util/List;", 0)), c0.e(new q(SendPoll.class, "explanation", "getExplanation()Ljava/lang/String;", 0)), c0.e(new q(SendPoll.class, "explanationParseMode", "getExplanationParseMode()Lcom/pengrad/telegrambot/model/request/ParseMode;", 0)), c0.e(new q(SendPoll.class, "explanationEntities", "getExplanationEntities()Ljava/util/List;", 0)), c0.e(new q(SendPoll.class, "openPeriod", "getOpenPeriod()Ljava/lang/Integer;", 0)), c0.e(new q(SendPoll.class, "closeDate", "getCloseDate()Ljava/lang/Long;", 0)), c0.e(new q(SendPoll.class, "isClosed", "isClosed()Ljava/lang/Boolean;", 0))};

    /* JADX INFO: renamed from: allowsMultipleAnswers$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate allowsMultipleAnswers;

    /* JADX INFO: renamed from: closeDate$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate closeDate;

    /* JADX INFO: renamed from: correctOptionId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate correctOptionId;

    /* JADX INFO: renamed from: explanation$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate explanation;

    /* JADX INFO: renamed from: explanationEntities$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate explanationEntities;

    /* JADX INFO: renamed from: explanationParseMode$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate explanationParseMode;

    /* JADX INFO: renamed from: isAnonymous$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate isAnonymous;

    /* JADX INFO: renamed from: isClosed$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate isClosed;

    /* JADX INFO: renamed from: openPeriod$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate openPeriod;

    /* JADX INFO: renamed from: options$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate options;

    /* JADX INFO: renamed from: question$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate question;

    /* JADX INFO: renamed from: questionEntities$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate questionEntities;

    /* JADX INFO: renamed from: questionParseMode$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate questionParseMode;

    /* JADX INFO: renamed from: type$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate type;

    /* JADX INFO: renamed from: typeRaw$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate typeRaw;

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendPoll$allowsMultipleAnswers$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendPoll;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendPoll;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass5 extends o implements l<SendPoll, z> {
        final /* synthetic */ boolean $allowMultipleAnswers;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendPoll sendPoll) {
            invoke2(sendPoll);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(boolean z10) {
            super(1);
            this.$allowMultipleAnswers = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendPoll applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setAllowsMultipleAnswers(Boolean.valueOf(this.$allowMultipleAnswers));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendPoll$closeDate$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendPoll;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendPoll;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06365 extends o implements l<SendPoll, z> {
        final /* synthetic */ long $closeDate;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendPoll sendPoll) {
            invoke2(sendPoll);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06365(long j10) {
            super(1);
            this.$closeDate = j10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendPoll applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setCloseDate(Long.valueOf(this.$closeDate));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendPoll$correctOptionId$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendPoll;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendPoll;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06375 extends o implements l<SendPoll, z> {
        final /* synthetic */ int $correctOptionId;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendPoll sendPoll) {
            invoke2(sendPoll);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06375(int i10) {
            super(1);
            this.$correctOptionId = i10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendPoll applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setCorrectOptionId(Integer.valueOf(this.$correctOptionId));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendPoll$explanation$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendPoll;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendPoll;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06385 extends o implements l<SendPoll, z> {
        final /* synthetic */ String $explanation;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendPoll sendPoll) {
            invoke2(sendPoll);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06385(String str) {
            super(1);
            this.$explanation = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendPoll applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setExplanation(this.$explanation);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendPoll$explanationEntities$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendPoll;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendPoll;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06395 extends o implements l<SendPoll, z> {
        final /* synthetic */ List<MessageEntity> $explanationEntities;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendPoll sendPoll) {
            invoke2(sendPoll);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C06395(List<? extends MessageEntity> list) {
            super(1);
            this.$explanationEntities = list;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendPoll applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setExplanationEntities(this.$explanationEntities);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendPoll$explanationParseMode$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendPoll;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendPoll;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06405 extends o implements l<SendPoll, z> {
        final /* synthetic */ ParseMode $explanationParseMode;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendPoll sendPoll) {
            invoke2(sendPoll);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06405(ParseMode parseMode) {
            super(1);
            this.$explanationParseMode = parseMode;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendPoll applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setExplanationParseMode(this.$explanationParseMode);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendPoll$isAnonymous$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendPoll;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendPoll;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06415 extends o implements l<SendPoll, z> {
        final /* synthetic */ boolean $isAnonymous;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendPoll sendPoll) {
            invoke2(sendPoll);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06415(boolean z10) {
            super(1);
            this.$isAnonymous = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendPoll applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setAnonymous(Boolean.valueOf(this.$isAnonymous));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendPoll$isClosed$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendPoll;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendPoll;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06425 extends o implements l<SendPoll, z> {
        final /* synthetic */ boolean $isClosed;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendPoll sendPoll) {
            invoke2(sendPoll);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06425(boolean z10) {
            super(1);
            this.$isClosed = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendPoll applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setClosed(Boolean.valueOf(this.$isClosed));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendPoll$openPeriod$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendPoll;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendPoll;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06435 extends o implements l<SendPoll, z> {
        final /* synthetic */ int $openPeriod;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendPoll sendPoll) {
            invoke2(sendPoll);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06435(int i10) {
            super(1);
            this.$openPeriod = i10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendPoll applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setOpenPeriod(Integer.valueOf(this.$openPeriod));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendPoll$questionEntities$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendPoll;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendPoll;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06445 extends o implements l<SendPoll, z> {
        final /* synthetic */ List<MessageEntity> $questionEntities;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendPoll sendPoll) {
            invoke2(sendPoll);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C06445(List<? extends MessageEntity> list) {
            super(1);
            this.$questionEntities = list;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendPoll applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setQuestionEntities(this.$questionEntities);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendPoll$questionParseMode$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendPoll;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendPoll;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06455 extends o implements l<SendPoll, z> {
        final /* synthetic */ ParseMode $questionParseMode;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendPoll sendPoll) {
            invoke2(sendPoll);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06455(ParseMode parseMode) {
            super(1);
            this.$questionParseMode = parseMode;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendPoll applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setQuestionParseMode(this.$questionParseMode);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendPoll$type$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendPoll;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendPoll;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06465 extends o implements l<SendPoll, z> {
        final /* synthetic */ Poll.Type $type;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendPoll sendPoll) {
            invoke2(sendPoll);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06465(Poll.Type type) {
            super(1);
            this.$type = type;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendPoll applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setType(this.$type);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendPoll$type$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendPoll;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendPoll;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass6 extends o implements l<SendPoll, z> {
        final /* synthetic */ String $typeRaw;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendPoll sendPoll) {
            invoke2(sendPoll);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(String str) {
            super(1);
            this.$typeRaw = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendPoll applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setTypeRaw(this.$typeRaw);
        }
    }

    /* synthetic */ SendPoll(Long l10, String str, String str2, List list, int i10, g gVar) {
        this((i10 & 1) != 0 ? null : l10, (i10 & 2) != 0 ? null : str, str2, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendPoll explanationEntities(List<? extends MessageEntity> explanationEntities) {
        m.f(explanationEntities, "explanationEntities");
        return (SendPoll) applySelf(new C06395(explanationEntities));
    }

    public final Boolean isAnonymous() {
        return (Boolean) this.isAnonymous.getValue(this, $$delegatedProperties[4]);
    }

    public final Boolean isClosed() {
        return (Boolean) this.isClosed.getValue(this, $$delegatedProperties[14]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendPoll questionEntities(List<? extends MessageEntity> questionEntities) {
        m.f(questionEntities, "questionEntities");
        return (SendPoll) applySelf(new C06445(questionEntities));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendPoll type(Poll.Type type) {
        m.f(type, "type");
        return (SendPoll) applySelf(new C06465(type));
    }

    private SendPoll(Long l10, String str, String str2, List<? extends InputPollOption> list) {
        super(l10, str);
        RequestParameterDelegate requestParameterDelegateRequestParameter$default = RequestParameterDelegateKt.requestParameter$default(str2, null, 2, null);
        k<?>[] kVarArr = $$delegatedProperties;
        this.question = requestParameterDelegateRequestParameter$default.provideDelegate(this, kVarArr[0]);
        this.options = RequestParameterDelegateKt.requestParameter$default(list, null, 2, null).provideDelegate(this, kVarArr[1]);
        this.type = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[2]);
        this.typeRaw = RequestParameterDelegateKt.optionalRequestParameter$default(null, IjkMediaMeta.IJKM_KEY_TYPE, null, 5, null).provideDelegate(this, kVarArr[3]);
        this.isAnonymous = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[4]);
        this.allowsMultipleAnswers = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[5]);
        this.correctOptionId = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[6]);
        this.questionParseMode = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[7]);
        this.questionEntities = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[8]);
        this.explanation = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[9]);
        this.explanationParseMode = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[10]);
        this.explanationEntities = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[11]);
        this.openPeriod = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[12]);
        this.closeDate = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[13]);
        this.isClosed = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[14]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendPoll allowsMultipleAnswers(boolean allowMultipleAnswers) {
        return (SendPoll) applySelf(new AnonymousClass5(allowMultipleAnswers));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendPoll closeDate(long closeDate) {
        return (SendPoll) applySelf(new C06365(closeDate));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendPoll correctOptionId(int correctOptionId) {
        return (SendPoll) applySelf(new C06375(correctOptionId));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendPoll explanation(String explanation) {
        m.f(explanation, "explanation");
        return (SendPoll) applySelf(new C06385(explanation));
    }

    public final SendPoll explanationEntities(MessageEntity... explanationEntities) {
        m.f(explanationEntities, "explanationEntities");
        return explanationEntities(j.E0(explanationEntities));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendPoll explanationParseMode(ParseMode explanationParseMode) {
        m.f(explanationParseMode, "explanationParseMode");
        return (SendPoll) applySelf(new C06405(explanationParseMode));
    }

    public final Boolean getAllowsMultipleAnswers() {
        return (Boolean) this.allowsMultipleAnswers.getValue(this, $$delegatedProperties[5]);
    }

    public final Long getCloseDate() {
        return (Long) this.closeDate.getValue(this, $$delegatedProperties[13]);
    }

    public final Integer getCorrectOptionId() {
        return (Integer) this.correctOptionId.getValue(this, $$delegatedProperties[6]);
    }

    public final String getExplanation() {
        return (String) this.explanation.getValue(this, $$delegatedProperties[9]);
    }

    public final List<MessageEntity> getExplanationEntities() {
        return (List) this.explanationEntities.getValue(this, $$delegatedProperties[11]);
    }

    public final ParseMode getExplanationParseMode() {
        return (ParseMode) this.explanationParseMode.getValue(this, $$delegatedProperties[10]);
    }

    public final Integer getOpenPeriod() {
        return (Integer) this.openPeriod.getValue(this, $$delegatedProperties[12]);
    }

    public final List<InputPollOption> getOptions() {
        return (List) this.options.getValue(this, $$delegatedProperties[1]);
    }

    public final String getQuestion() {
        return (String) this.question.getValue(this, $$delegatedProperties[0]);
    }

    public final List<MessageEntity> getQuestionEntities() {
        return (List) this.questionEntities.getValue(this, $$delegatedProperties[8]);
    }

    public final ParseMode getQuestionParseMode() {
        return (ParseMode) this.questionParseMode.getValue(this, $$delegatedProperties[7]);
    }

    public final Poll.Type getType() {
        return (Poll.Type) this.type.getValue(this, $$delegatedProperties[2]);
    }

    public final String getTypeRaw() {
        return (String) this.typeRaw.getValue(this, $$delegatedProperties[3]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendPoll isAnonymous(boolean isAnonymous) {
        return (SendPoll) applySelf(new C06415(isAnonymous));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendPoll isClosed(boolean isClosed) {
        return (SendPoll) applySelf(new C06425(isClosed));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendPoll openPeriod(int openPeriod) {
        return (SendPoll) applySelf(new C06435(openPeriod));
    }

    public final SendPoll questionEntities(MessageEntity... questionEntities) {
        m.f(questionEntities, "questionEntities");
        return questionEntities(j.E0(questionEntities));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendPoll questionParseMode(ParseMode questionParseMode) {
        m.f(questionParseMode, "questionParseMode");
        return (SendPoll) applySelf(new C06455(questionParseMode));
    }

    public final void setAllowsMultipleAnswers(Boolean bool) {
        this.allowsMultipleAnswers.setValue(this, $$delegatedProperties[5], bool);
    }

    public final void setAnonymous(Boolean bool) {
        this.isAnonymous.setValue(this, $$delegatedProperties[4], bool);
    }

    public final void setCloseDate(Long l10) {
        this.closeDate.setValue(this, $$delegatedProperties[13], l10);
    }

    public final void setClosed(Boolean bool) {
        this.isClosed.setValue(this, $$delegatedProperties[14], bool);
    }

    public final void setCorrectOptionId(Integer num) {
        this.correctOptionId.setValue(this, $$delegatedProperties[6], num);
    }

    public final void setExplanation(String str) {
        this.explanation.setValue(this, $$delegatedProperties[9], str);
    }

    public final void setExplanationEntities(List<? extends MessageEntity> list) {
        this.explanationEntities.setValue(this, $$delegatedProperties[11], list);
    }

    public final void setExplanationParseMode(ParseMode parseMode) {
        this.explanationParseMode.setValue(this, $$delegatedProperties[10], parseMode);
    }

    public final void setOpenPeriod(Integer num) {
        this.openPeriod.setValue(this, $$delegatedProperties[12], num);
    }

    public final void setQuestionEntities(List<? extends MessageEntity> list) {
        this.questionEntities.setValue(this, $$delegatedProperties[8], list);
    }

    public final void setQuestionParseMode(ParseMode parseMode) {
        this.questionParseMode.setValue(this, $$delegatedProperties[7], parseMode);
    }

    public final void setType(Poll.Type type) {
        this.type.setValue(this, $$delegatedProperties[2], type);
    }

    public final void setTypeRaw(String str) {
        this.typeRaw.setValue(this, $$delegatedProperties[3], str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendPoll type(String typeRaw) {
        m.f(typeRaw, "typeRaw");
        return (SendPoll) applySelf(new AnonymousClass6(typeRaw));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendPoll(long j10, String question, List<? extends InputPollOption> options) {
        this(Long.valueOf(j10), null, question, options);
        m.f(question, "question");
        m.f(options, "options");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendPoll(String channelUsername, String question, List<? extends InputPollOption> options) {
        this(null, channelUsername, question, options);
        m.f(channelUsername, "channelUsername");
        m.f(question, "question");
        m.f(options, "options");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendPoll(Object chatId, String question, InputPollOption... options) {
        m.f(chatId, "chatId");
        m.f(question, "question");
        m.f(options, "options");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null, question, j.E0(options));
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }
}
