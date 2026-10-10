package com.pengrad.telegrambot.request;

import c9.l;
import com.pengrad.telegrambot.model.reaction.ReactionTypeEmoji;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegate;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegateKt;
import i9.k;
import kotlin.Metadata;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0010\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\b¢\u0006\u0002\u0010\tB\u001f\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0000J\u0006\u0010\u0013\u001a\u00020\u0000J\u0006\u0010\u0014\u001a\u00020\u0000J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0000J\u0006\u0010\u0016\u001a\u00020\u0000R/\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/pengrad/telegrambot/request/SendDice;", "Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "chatId", "", "(J)V", "channelUsername", "", "(Ljava/lang/String;)V", "", "(Ljava/lang/Object;)V", "(Ljava/lang/Long;Ljava/lang/String;)V", "<set-?>", ReactionTypeEmoji.EMOJI_TYPE, "getEmoji", "()Ljava/lang/String;", "setEmoji", "emoji$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "basketball", "bowling", "darts", "football", "slotMachine", "Companion", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SendDice extends AbstractSendRequest<SendDice> {
    public static final String BASKETBALL_EMOJI = "🏀";
    public static final String BOWLING_EMOJI = "🎳";
    public static final String DARTS_EMOJI = "🎯";
    public static final String FOOTBALL_EMOJI = "⚽";
    public static final String SLOT_MACHINE_EMOJI = "🎰";

    /* JADX INFO: renamed from: emoji$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate emoji;
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.e(new q(SendDice.class, ReactionTypeEmoji.EMOJI_TYPE, "getEmoji()Ljava/lang/String;", 0))};

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendDice$emoji$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendDice;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendDice;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass5 extends o implements l<SendDice, z> {
        final /* synthetic */ String $emoji;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendDice sendDice) {
            invoke2(sendDice);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(String str) {
            super(1);
            this.$emoji = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendDice applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setEmoji(this.$emoji);
        }
    }

    /* synthetic */ SendDice(Long l10, String str, int i10, g gVar) {
        this((i10 & 1) != 0 ? null : l10, (i10 & 2) != 0 ? null : str);
    }

    private SendDice(Long l10, String str) {
        super(l10, str);
        this.emoji = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, $$delegatedProperties[0]);
    }

    public final SendDice basketball() {
        return emoji(BASKETBALL_EMOJI);
    }

    public final SendDice bowling() {
        return emoji(BOWLING_EMOJI);
    }

    public final SendDice darts() {
        return emoji(DARTS_EMOJI);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendDice emoji(String emoji) {
        m.f(emoji, "emoji");
        return (SendDice) applySelf(new AnonymousClass5(emoji));
    }

    public final SendDice football() {
        return emoji(FOOTBALL_EMOJI);
    }

    public final String getEmoji() {
        return (String) this.emoji.getValue(this, $$delegatedProperties[0]);
    }

    public final void setEmoji(String str) {
        this.emoji.setValue(this, $$delegatedProperties[0], str);
    }

    public final SendDice slotMachine() {
        return emoji(SLOT_MACHINE_EMOJI);
    }

    public SendDice(long j10) {
        this(Long.valueOf(j10), null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendDice(String channelUsername) {
        this(null, channelUsername);
        m.f(channelUsername, "channelUsername");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendDice(Object chatId) {
        m.f(chatId, "chatId");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null);
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }
}
