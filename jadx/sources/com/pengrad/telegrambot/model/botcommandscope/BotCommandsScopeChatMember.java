package com.pengrad.telegrambot.model.botcommandscope;

import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/pengrad/telegrambot/model/botcommandscope/BotCommandsScopeChatMember;", "Lcom/pengrad/telegrambot/model/botcommandscope/BotCommandScope;", "chatId", "", "userId", "", "(Ljava/lang/Object;J)V", "getChatId", "()Ljava/lang/Object;", "getUserId", "()J", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BotCommandsScopeChatMember extends BotCommandScope {
    private final Object chatId;
    private final long userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BotCommandsScopeChatMember(Object chatId, long j10) {
        super("chat_member");
        m.f(chatId, "chatId");
        this.chatId = chatId;
        this.userId = j10;
    }

    public final Object getChatId() {
        return this.chatId;
    }

    public final long getUserId() {
        return this.userId;
    }
}
