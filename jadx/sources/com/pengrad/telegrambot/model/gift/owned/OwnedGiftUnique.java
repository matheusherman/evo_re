package com.pengrad.telegrambot.model.gift.owned;

import com.pengrad.telegrambot.model.User;
import com.pengrad.telegrambot.model.gift.Gift;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001c\u0018\u0000 )2\u00020\u0001:\u0001)BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0010R \u0010\f\u001a\u0004\u0018\u00010\u000b8\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0015R \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\n\u0010\u0011\"\u0004\b\u0016\u0010\u0013R \u0010\u000f\u001a\u0004\u0018\u00010\t8\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u000f\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\b\u001a\u00020\t8\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010#\"\u0004\b$\u0010%R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010&\"\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/pengrad/telegrambot/model/gift/owned/OwnedGiftUnique;", "Lcom/pengrad/telegrambot/model/gift/owned/OwnedGift;", "gift", "Lcom/pengrad/telegrambot/model/gift/Gift;", "ownedGiftId", "", "senderUser", "Lcom/pengrad/telegrambot/model/User;", "sendDate", "", "isSaved", "", "canBeTransferred", "prepaidUpgradeStarCount", "", "nextTransferDate", "(Lcom/pengrad/telegrambot/model/gift/Gift;Ljava/lang/String;Lcom/pengrad/telegrambot/model/User;JLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;)V", "()Ljava/lang/Boolean;", "setCanBeTransferred", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "()Lcom/pengrad/telegrambot/model/gift/Gift;", "setSaved", "()Ljava/lang/Long;", "setNextTransferDate", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "()Ljava/lang/String;", "setOwnedGiftId", "(Ljava/lang/String;)V", "transferStarCount", "()Ljava/lang/Integer;", "setPrepaidUpgradeStarCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "()J", "setSendDate", "(J)V", "()Lcom/pengrad/telegrambot/model/User;", "setSenderUser", "(Lcom/pengrad/telegrambot/model/User;)V", "Companion", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class OwnedGiftUnique extends OwnedGift {
    public static final String TYPE = "unique";
    private Boolean canBeTransferred;
    private final Gift gift;
    private Boolean isSaved;
    private Long nextTransferDate;
    private String ownedGiftId;
    private Integer prepaidUpgradeStarCount;
    private long sendDate;
    private User senderUser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OwnedGiftUnique(Gift gift, String str, User user, long j10, Boolean bool, Boolean bool2, Integer num, Long l10) {
        super(TYPE);
        m.f(gift, "gift");
        this.gift = gift;
        this.ownedGiftId = str;
        this.senderUser = user;
        this.sendDate = j10;
        this.isSaved = bool;
        this.canBeTransferred = bool2;
        this.prepaidUpgradeStarCount = num;
        this.nextTransferDate = l10;
    }

    /* JADX INFO: renamed from: canBeTransferred, reason: from getter */
    public final Boolean getCanBeTransferred() {
        return this.canBeTransferred;
    }

    /* JADX INFO: renamed from: gift, reason: from getter */
    public final Gift getGift() {
        return this.gift;
    }

    /* JADX INFO: renamed from: isSaved, reason: from getter */
    public final Boolean getIsSaved() {
        return this.isSaved;
    }

    /* JADX INFO: renamed from: nextTransferDate, reason: from getter */
    public final Long getNextTransferDate() {
        return this.nextTransferDate;
    }

    /* JADX INFO: renamed from: ownedGiftId, reason: from getter */
    public final String getOwnedGiftId() {
        return this.ownedGiftId;
    }

    /* JADX INFO: renamed from: sendDate, reason: from getter */
    public final long getSendDate() {
        return this.sendDate;
    }

    /* JADX INFO: renamed from: senderUser, reason: from getter */
    public final User getSenderUser() {
        return this.senderUser;
    }

    public final void setCanBeTransferred(Boolean bool) {
        this.canBeTransferred = bool;
    }

    public final void setNextTransferDate(Long l10) {
        this.nextTransferDate = l10;
    }

    public final void setOwnedGiftId(String str) {
        this.ownedGiftId = str;
    }

    public final void setPrepaidUpgradeStarCount(Integer num) {
        this.prepaidUpgradeStarCount = num;
    }

    public final void setSaved(Boolean bool) {
        this.isSaved = bool;
    }

    public final void setSendDate(long j10) {
        this.sendDate = j10;
    }

    public final void setSenderUser(User user) {
        this.senderUser = user;
    }

    /* JADX INFO: renamed from: transferStarCount, reason: from getter */
    public final Integer getPrepaidUpgradeStarCount() {
        return this.prepaidUpgradeStarCount;
    }
}
