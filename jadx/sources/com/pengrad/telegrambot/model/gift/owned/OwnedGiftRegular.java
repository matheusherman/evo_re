package com.pengrad.telegrambot.model.gift.owned;

import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.User;
import com.pengrad.telegrambot.model.gift.Gift;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001e\u0018\u0000 22\u00020\u0001:\u00012B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0081\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u0019\u0010\f\u001a\u00020\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u00101J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0010R \u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0012\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u0014\u0010\u001c\"\u0004\b\u001d\u0010\u001eR&\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\f\u0010 \"\u0004\b!\u0010\"R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010$R \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u000f\u0010\u0018\"\u0004\b%\u0010\u001aR \u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0011\u0010\u0018\"\u0004\b&\u0010\u001aR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010'\"\u0004\b(\u0010)R \u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u0016\u0010\u001c\"\u0004\b*\u0010\u001eR\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010+R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010,\"\u0004\b-\u0010.R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010'\"\u0004\b/\u0010)R \u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0013\u0010\u0018\"\u0004\b0\u0010\u001a¨\u00063"}, d2 = {"Lcom/pengrad/telegrambot/model/gift/owned/OwnedGiftRegular;", "Lcom/pengrad/telegrambot/model/gift/owned/OwnedGift;", "gift", "Lcom/pengrad/telegrambot/model/gift/Gift;", "sendDate", "", "(Lcom/pengrad/telegrambot/model/gift/Gift;J)V", "ownedGiftId", "", "senderUser", "Lcom/pengrad/telegrambot/model/User;", "text", "entities", "", "Lcom/pengrad/telegrambot/model/MessageEntity;", "isPrivate", "", "isSaved", "canBeUpgraded", "wasRefunded", "convertStarCount", "", "prepaidUpgradeStarCount", "(Lcom/pengrad/telegrambot/model/gift/Gift;Ljava/lang/String;Lcom/pengrad/telegrambot/model/User;JLjava/lang/String;[Lcom/pengrad/telegrambot/model/MessageEntity;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)V", "()Ljava/lang/Boolean;", "setCanBeUpgraded", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "()Ljava/lang/Integer;", "setConvertStarCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "()[Lcom/pengrad/telegrambot/model/MessageEntity;", "setEntities", "([Lcom/pengrad/telegrambot/model/MessageEntity;)V", "[Lcom/pengrad/telegrambot/model/MessageEntity;", "()Lcom/pengrad/telegrambot/model/gift/Gift;", "setPrivate", "setSaved", "()Ljava/lang/String;", "setOwnedGiftId", "(Ljava/lang/String;)V", "setPrepaidUpgradeStarCount", "()J", "()Lcom/pengrad/telegrambot/model/User;", "setSenderUser", "(Lcom/pengrad/telegrambot/model/User;)V", "setText", "setWasRefunded", "([Lcom/pengrad/telegrambot/model/MessageEntity;)Lcom/pengrad/telegrambot/model/gift/owned/OwnedGiftRegular;", "Companion", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class OwnedGiftRegular extends OwnedGift {
    public static final String TYPE = "regular";
    private Boolean canBeUpgraded;
    private Integer convertStarCount;
    private MessageEntity[] entities;
    private final Gift gift;
    private Boolean isPrivate;
    private Boolean isSaved;
    private String ownedGiftId;
    private Integer prepaidUpgradeStarCount;
    private final long sendDate;
    private User senderUser;
    private String text;
    private Boolean wasRefunded;

    private OwnedGiftRegular(Gift gift, String str, User user, long j10, String str2, MessageEntity[] messageEntityArr, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Integer num, Integer num2) {
        super(TYPE);
        this.gift = gift;
        this.ownedGiftId = str;
        this.senderUser = user;
        this.sendDate = j10;
        this.text = str2;
        this.entities = messageEntityArr;
        this.isPrivate = bool;
        this.isSaved = bool2;
        this.canBeUpgraded = bool3;
        this.wasRefunded = bool4;
        this.convertStarCount = num;
        this.prepaidUpgradeStarCount = num2;
    }

    /* JADX INFO: renamed from: canBeUpgraded, reason: from getter */
    public final Boolean getCanBeUpgraded() {
        return this.canBeUpgraded;
    }

    /* JADX INFO: renamed from: convertStarCount, reason: from getter */
    public final Integer getConvertStarCount() {
        return this.convertStarCount;
    }

    /* JADX INFO: renamed from: entities, reason: from getter */
    public final MessageEntity[] getEntities() {
        return this.entities;
    }

    /* JADX INFO: renamed from: isPrivate, reason: from getter */
    public final Boolean getIsPrivate() {
        return this.isPrivate;
    }

    /* JADX INFO: renamed from: isSaved, reason: from getter */
    public final Boolean getIsSaved() {
        return this.isSaved;
    }

    /* JADX INFO: renamed from: ownedGiftId, reason: from getter */
    public final String getOwnedGiftId() {
        return this.ownedGiftId;
    }

    /* JADX INFO: renamed from: prepaidUpgradeStarCount, reason: from getter */
    public final Integer getPrepaidUpgradeStarCount() {
        return this.prepaidUpgradeStarCount;
    }

    /* JADX INFO: renamed from: senderUser, reason: from getter */
    public final User getSenderUser() {
        return this.senderUser;
    }

    /* JADX INFO: renamed from: text, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: wasRefunded, reason: from getter */
    public final Boolean getWasRefunded() {
        return this.wasRefunded;
    }

    public final OwnedGiftRegular canBeUpgraded(boolean canBeUpgraded) {
        this.canBeUpgraded = Boolean.valueOf(canBeUpgraded);
        return this;
    }

    public final OwnedGiftRegular convertStarCount(int convertStarCount) {
        this.convertStarCount = Integer.valueOf(convertStarCount);
        return this;
    }

    public final OwnedGiftRegular entities(MessageEntity[] entities) {
        m.f(entities, "entities");
        this.entities = entities;
        return this;
    }

    /* JADX INFO: renamed from: gift, reason: from getter */
    public final Gift getGift() {
        return this.gift;
    }

    public final OwnedGiftRegular isPrivate(boolean isPrivate) {
        this.isPrivate = Boolean.valueOf(isPrivate);
        return this;
    }

    public final OwnedGiftRegular isSaved(boolean isSaved) {
        this.isSaved = Boolean.valueOf(isSaved);
        return this;
    }

    public final OwnedGiftRegular ownedGiftId(String ownedGiftId) {
        m.f(ownedGiftId, "ownedGiftId");
        this.ownedGiftId = ownedGiftId;
        return this;
    }

    public final OwnedGiftRegular prepaidUpgradeStarCount(int prepaidUpgradeStarCount) {
        this.prepaidUpgradeStarCount = Integer.valueOf(prepaidUpgradeStarCount);
        return this;
    }

    /* JADX INFO: renamed from: sendDate, reason: from getter */
    public final long getSendDate() {
        return this.sendDate;
    }

    public final OwnedGiftRegular senderUser(User senderUser) {
        m.f(senderUser, "senderUser");
        this.senderUser = senderUser;
        return this;
    }

    public final void setCanBeUpgraded(Boolean bool) {
        this.canBeUpgraded = bool;
    }

    public final void setConvertStarCount(Integer num) {
        this.convertStarCount = num;
    }

    public final void setEntities(MessageEntity[] messageEntityArr) {
        this.entities = messageEntityArr;
    }

    public final void setOwnedGiftId(String str) {
        this.ownedGiftId = str;
    }

    public final void setPrepaidUpgradeStarCount(Integer num) {
        this.prepaidUpgradeStarCount = num;
    }

    public final void setPrivate(Boolean bool) {
        this.isPrivate = bool;
    }

    public final void setSaved(Boolean bool) {
        this.isSaved = bool;
    }

    public final void setSenderUser(User user) {
        this.senderUser = user;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final void setWasRefunded(Boolean bool) {
        this.wasRefunded = bool;
    }

    public final OwnedGiftRegular text(String text) {
        m.f(text, "text");
        this.text = text;
        return this;
    }

    public final OwnedGiftRegular wasRefunded(boolean wasRefunded) {
        this.wasRefunded = Boolean.valueOf(wasRefunded);
        return this;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OwnedGiftRegular(Gift gift, long j10) {
        this(gift, null, null, j10, null, null, null, null, null, null, null, null);
        m.f(gift, "gift");
    }
}
