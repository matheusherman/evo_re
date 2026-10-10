package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegate;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegateKt;
import i9.k;
import kotlin.Metadata;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.w;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\bB\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\nB'\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bR\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/pengrad/telegrambot/request/SendGame;", "Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "chatId", "", "gameShortName", "", "(JLjava/lang/String;)V", "channelUsername", "(Ljava/lang/String;Ljava/lang/String;)V", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getGameShortName", "()Ljava/lang/String;", "gameShortName$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SendGame extends AbstractSendRequest<SendGame> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(SendGame.class, "gameShortName", "getGameShortName()Ljava/lang/String;", 0))};

    /* JADX INFO: renamed from: gameShortName$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate gameShortName;

    /* synthetic */ SendGame(Long l10, String str, String str2, int i10, g gVar) {
        this((i10 & 1) != 0 ? null : l10, (i10 & 2) != 0 ? null : str, str2);
    }

    private SendGame(Long l10, String str, String str2) {
        super(l10, str);
        this.gameShortName = RequestParameterDelegateKt.requestParameter$default(str2, null, 2, null).provideDelegate(this, $$delegatedProperties[0]);
    }

    public final String getGameShortName() {
        return (String) this.gameShortName.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendGame(long j10, String gameShortName) {
        this(Long.valueOf(j10), null, gameShortName);
        m.f(gameShortName, "gameShortName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendGame(String channelUsername, String gameShortName) {
        this(null, channelUsername, gameShortName);
        m.f(channelUsername, "channelUsername");
        m.f(gameShortName, "gameShortName");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendGame(Object chatId, String gameShortName) {
        m.f(chatId, "chatId");
        m.f(gameShortName, "gameShortName");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null, gameShortName);
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }
}
