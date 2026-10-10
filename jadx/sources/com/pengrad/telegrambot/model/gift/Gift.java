package com.pengrad.telegrambot.model.gift;

import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Sticker;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\fHÆ\u0003J\\\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000eR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u000fR\u0017\u0010\n\u001a\u0004\u0018\u00010\u00078\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\n\u0010\u0010R\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0012R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0013R\u0017\u0010\t\u001a\u0004\u0018\u00010\u00078\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\b\u0010\u0010¨\u0006\""}, d2 = {"Lcom/pengrad/telegrambot/model/gift/Gift;", "", IjkMediaMeta.IJKM_KEY_TRACK_ID, "", "sticker", "Lcom/pengrad/telegrambot/model/Sticker;", "starCount", "", "upgradeStarCount", "totalCount", "remainingCount", "publisherChat", "Lcom/pengrad/telegrambot/model/Chat;", "(Ljava/lang/String;Lcom/pengrad/telegrambot/model/Sticker;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/pengrad/telegrambot/model/Chat;)V", "()Ljava/lang/String;", "()Lcom/pengrad/telegrambot/model/Chat;", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()I", "()Lcom/pengrad/telegrambot/model/Sticker;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Lcom/pengrad/telegrambot/model/Sticker;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/pengrad/telegrambot/model/Chat;)Lcom/pengrad/telegrambot/model/gift/Gift;", "equals", "", TransactionPartnerType.OTHER, "hashCode", "toString", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class Gift {
    private final String id;
    private final Chat publisherChat;
    private final Integer remainingCount;
    private final int starCount;
    private final Sticker sticker;
    private final Integer totalCount;
    private final Integer upgradeStarCount;

    public Gift(String id2, Sticker sticker, int i10, Integer num, Integer num2, Integer num3, Chat chat) {
        m.f(id2, "id");
        m.f(sticker, "sticker");
        this.id = id2;
        this.sticker = sticker;
        this.starCount = i10;
        this.upgradeStarCount = num;
        this.totalCount = num2;
        this.remainingCount = num3;
        this.publisherChat = chat;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Gift)) {
            return false;
        }
        Gift gift = (Gift) other;
        return m.a(this.id, gift.id) && m.a(this.sticker, gift.sticker) && this.starCount == gift.starCount && m.a(this.upgradeStarCount, gift.upgradeStarCount) && m.a(this.totalCount, gift.totalCount) && m.a(this.remainingCount, gift.remainingCount) && m.a(this.publisherChat, gift.publisherChat);
    }

    public static /* synthetic */ Gift copy$default(Gift gift, String str, Sticker sticker, int i10, Integer num, Integer num2, Integer num3, Chat chat, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = gift.id;
        }
        if ((i11 & 2) != 0) {
            sticker = gift.sticker;
        }
        if ((i11 & 4) != 0) {
            i10 = gift.starCount;
        }
        if ((i11 & 8) != 0) {
            num = gift.upgradeStarCount;
        }
        if ((i11 & 16) != 0) {
            num2 = gift.totalCount;
        }
        if ((i11 & 32) != 0) {
            num3 = gift.remainingCount;
        }
        if ((i11 & 64) != 0) {
            chat = gift.publisherChat;
        }
        Integer num4 = num3;
        Chat chat2 = chat;
        Integer num5 = num2;
        int i12 = i10;
        return gift.copy(str, sticker, i12, num, num5, num4, chat2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Sticker getSticker() {
        return this.sticker;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getStarCount() {
        return this.starCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getUpgradeStarCount() {
        return this.upgradeStarCount;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getTotalCount() {
        return this.totalCount;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getRemainingCount() {
        return this.remainingCount;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Chat getPublisherChat() {
        return this.publisherChat;
    }

    public final Gift copy(String id2, Sticker sticker, int starCount, Integer upgradeStarCount, Integer totalCount, Integer remainingCount, Chat publisherChat) {
        m.f(id2, "id");
        m.f(sticker, "sticker");
        return new Gift(id2, sticker, starCount, upgradeStarCount, totalCount, remainingCount, publisherChat);
    }

    public int hashCode() {
        int iHashCode = ((((this.id.hashCode() * 31) + this.sticker.hashCode()) * 31) + this.starCount) * 31;
        Integer num = this.upgradeStarCount;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.totalCount;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.remainingCount;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Chat chat = this.publisherChat;
        return iHashCode4 + (chat != null ? chat.hashCode() : 0);
    }

    public final String id() {
        return this.id;
    }

    public final Chat publisherChat() {
        return this.publisherChat;
    }

    public final Integer remainingCount() {
        return this.remainingCount;
    }

    public final int starCount() {
        return this.starCount;
    }

    public final Sticker sticker() {
        return this.sticker;
    }

    public String toString() {
        return "Gift(id=" + this.id + ", sticker=" + this.sticker + ", starCount=" + this.starCount + ", upgradeStarCount=" + this.upgradeStarCount + ", totalCount=" + this.totalCount + ", remainingCount=" + this.remainingCount + ", publisherChat=" + this.publisherChat + ')';
    }

    public final Integer totalCount() {
        return this.totalCount;
    }

    public final Integer upgradeStarCount() {
        return this.upgradeStarCount;
    }

    public /* synthetic */ Gift(String str, Sticker sticker, int i10, Integer num, Integer num2, Integer num3, Chat chat, int i11, g gVar) {
        this(str, sticker, i10, (i11 & 8) != 0 ? null : num, (i11 & 16) != 0 ? null : num2, (i11 & 32) != 0 ? null : num3, (i11 & 64) != 0 ? null : chat);
    }
}
