package com.pengrad.telegrambot.model.stars.partner;

import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.gift.Gift;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/pengrad/telegrambot/model/stars/partner/TransactionPartnerChat;", "Lcom/pengrad/telegrambot/model/stars/partner/TransactionPartner;", "chat", "Lcom/pengrad/telegrambot/model/Chat;", "gift", "Lcom/pengrad/telegrambot/model/gift/Gift;", "(Lcom/pengrad/telegrambot/model/Chat;Lcom/pengrad/telegrambot/model/gift/Gift;)V", "()Lcom/pengrad/telegrambot/model/Chat;", "()Lcom/pengrad/telegrambot/model/gift/Gift;", IjkMediaMeta.IJKM_KEY_TYPE, "", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", TransactionPartnerType.OTHER, "", "hashCode", "", "toString", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class TransactionPartnerChat implements TransactionPartner {
    private final Chat chat;
    private final Gift gift;

    public TransactionPartnerChat(Chat chat, Gift gift) {
        m.f(chat, "chat");
        this.chat = chat;
        this.gift = gift;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!m.a(TransactionPartnerChat.class, other != null ? other.getClass() : null)) {
            return false;
        }
        m.d(other, "null cannot be cast to non-null type com.pengrad.telegrambot.model.stars.partner.TransactionPartnerChat");
        TransactionPartnerChat transactionPartnerChat = (TransactionPartnerChat) other;
        return m.a(this.chat, transactionPartnerChat.chat) && m.a(this.gift, transactionPartnerChat.gift) && m.a(getType(), transactionPartnerChat.getType());
    }

    public static /* synthetic */ TransactionPartnerChat copy$default(TransactionPartnerChat transactionPartnerChat, Chat chat, Gift gift, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            chat = transactionPartnerChat.chat;
        }
        if ((i10 & 2) != 0) {
            gift = transactionPartnerChat.gift;
        }
        return transactionPartnerChat.copy(chat, gift);
    }

    /* JADX INFO: renamed from: chat, reason: from getter */
    public final Chat getChat() {
        return this.chat;
    }

    public final Chat component1() {
        return this.chat;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Gift getGift() {
        return this.gift;
    }

    public final TransactionPartnerChat copy(Chat chat, Gift gift) {
        m.f(chat, "chat");
        return new TransactionPartnerChat(chat, gift);
    }

    @Override // com.pengrad.telegrambot.model.stars.partner.TransactionPartner
    public String getType() {
        return "chat";
    }

    public final Gift gift() {
        return this.gift;
    }

    public int hashCode() {
        int iHashCode = this.chat.hashCode() * 31;
        Gift gift = this.gift;
        return iHashCode + (gift != null ? gift.hashCode() : 0);
    }

    public String toString() {
        return "TransactionPartnerChat(chat=" + this.chat + ", gift=" + this.gift + ')';
    }

    public /* synthetic */ TransactionPartnerChat(Chat chat, Gift gift, int i10, g gVar) {
        this(chat, (i10 & 2) != 0 ? null : gift);
    }
}
