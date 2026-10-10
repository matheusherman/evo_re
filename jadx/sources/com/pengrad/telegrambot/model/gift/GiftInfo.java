package com.pengrad.telegrambot.model.gift;

import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0010J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010 \u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0011Jr\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010%\u001a\u00020\u0007H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016R\u0017\u0010\t\u001a\u0004\u0018\u00010\n8\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\t\u0010\u0011R\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0006\u0010\u0013R\u001d\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\f\u0010\u0015R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0017R\u0017\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u000f\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0018R\u0017\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\b\u0010\u0013R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0018¨\u0006'"}, d2 = {"Lcom/pengrad/telegrambot/model/gift/GiftInfo;", "", "gift", "Lcom/pengrad/telegrambot/model/gift/Gift;", "ownedGiftId", "", "convertStarCount", "", "prepaidUpgradeStarCount", "canBeUpgraded", "", "text", "entities", "", "Lcom/pengrad/telegrambot/model/MessageEntity;", "isPrivate", "(Lcom/pengrad/telegrambot/model/gift/Gift;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;[Lcom/pengrad/telegrambot/model/MessageEntity;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()[Lcom/pengrad/telegrambot/model/MessageEntity;", "[Lcom/pengrad/telegrambot/model/MessageEntity;", "()Lcom/pengrad/telegrambot/model/gift/Gift;", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lcom/pengrad/telegrambot/model/gift/Gift;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;[Lcom/pengrad/telegrambot/model/MessageEntity;Ljava/lang/Boolean;)Lcom/pengrad/telegrambot/model/gift/GiftInfo;", "equals", TransactionPartnerType.OTHER, "hashCode", "toString", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class GiftInfo {
    private final Boolean canBeUpgraded;
    private final Integer convertStarCount;
    private final MessageEntity[] entities;
    private final Gift gift;
    private final Boolean isPrivate;
    private final String ownedGiftId;
    private final Integer prepaidUpgradeStarCount;
    private final String text;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GiftInfo)) {
            return false;
        }
        GiftInfo giftInfo = (GiftInfo) other;
        return m.a(this.gift, giftInfo.gift) && m.a(this.ownedGiftId, giftInfo.ownedGiftId) && m.a(this.convertStarCount, giftInfo.convertStarCount) && m.a(this.prepaidUpgradeStarCount, giftInfo.prepaidUpgradeStarCount) && m.a(this.canBeUpgraded, giftInfo.canBeUpgraded) && m.a(this.text, giftInfo.text) && Arrays.equals(this.entities, giftInfo.entities) && m.a(this.isPrivate, giftInfo.isPrivate);
    }

    public GiftInfo(Gift gift, String str, Integer num, Integer num2, Boolean bool, String str2, MessageEntity[] messageEntityArr, Boolean bool2) {
        m.f(gift, "gift");
        this.gift = gift;
        this.ownedGiftId = str;
        this.convertStarCount = num;
        this.prepaidUpgradeStarCount = num2;
        this.canBeUpgraded = bool;
        this.text = str2;
        this.entities = messageEntityArr;
        this.isPrivate = bool2;
    }

    public static /* synthetic */ GiftInfo copy$default(GiftInfo giftInfo, Gift gift, String str, Integer num, Integer num2, Boolean bool, String str2, MessageEntity[] messageEntityArr, Boolean bool2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gift = giftInfo.gift;
        }
        if ((i10 & 2) != 0) {
            str = giftInfo.ownedGiftId;
        }
        if ((i10 & 4) != 0) {
            num = giftInfo.convertStarCount;
        }
        if ((i10 & 8) != 0) {
            num2 = giftInfo.prepaidUpgradeStarCount;
        }
        if ((i10 & 16) != 0) {
            bool = giftInfo.canBeUpgraded;
        }
        if ((i10 & 32) != 0) {
            str2 = giftInfo.text;
        }
        if ((i10 & 64) != 0) {
            messageEntityArr = giftInfo.entities;
        }
        if ((i10 & 128) != 0) {
            bool2 = giftInfo.isPrivate;
        }
        MessageEntity[] messageEntityArr2 = messageEntityArr;
        Boolean bool3 = bool2;
        Boolean bool4 = bool;
        String str3 = str2;
        return giftInfo.copy(gift, str, num, num2, bool4, str3, messageEntityArr2, bool3);
    }

    /* JADX INFO: renamed from: canBeUpgraded, reason: from getter */
    public final Boolean getCanBeUpgraded() {
        return this.canBeUpgraded;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Gift getGift() {
        return this.gift;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOwnedGiftId() {
        return this.ownedGiftId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getConvertStarCount() {
        return this.convertStarCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getPrepaidUpgradeStarCount() {
        return this.prepaidUpgradeStarCount;
    }

    public final Boolean component5() {
        return this.canBeUpgraded;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final MessageEntity[] getEntities() {
        return this.entities;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Boolean getIsPrivate() {
        return this.isPrivate;
    }

    public final Integer convertStarCount() {
        return this.convertStarCount;
    }

    public final GiftInfo copy(Gift gift, String ownedGiftId, Integer convertStarCount, Integer prepaidUpgradeStarCount, Boolean canBeUpgraded, String text, MessageEntity[] entities, Boolean isPrivate) {
        m.f(gift, "gift");
        return new GiftInfo(gift, ownedGiftId, convertStarCount, prepaidUpgradeStarCount, canBeUpgraded, text, entities, isPrivate);
    }

    public final MessageEntity[] entities() {
        return this.entities;
    }

    public final Gift gift() {
        return this.gift;
    }

    public int hashCode() {
        int iHashCode = this.gift.hashCode() * 31;
        String str = this.ownedGiftId;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        Integer num = this.convertStarCount;
        int iIntValue = (iHashCode2 + (num != null ? num.intValue() : 0)) * 31;
        Integer num2 = this.prepaidUpgradeStarCount;
        int iIntValue2 = (iIntValue + (num2 != null ? num2.intValue() : 0)) * 31;
        Boolean bool = this.canBeUpgraded;
        int iHashCode3 = (iIntValue2 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str2 = this.text;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        MessageEntity[] messageEntityArr = this.entities;
        int iHashCode5 = (iHashCode4 + (messageEntityArr != null ? Arrays.hashCode(messageEntityArr) : 0)) * 31;
        Boolean bool2 = this.isPrivate;
        return iHashCode5 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public final Boolean isPrivate() {
        return this.isPrivate;
    }

    public final String ownedGiftId() {
        return this.ownedGiftId;
    }

    public final Integer prepaidUpgradeStarCount() {
        return this.prepaidUpgradeStarCount;
    }

    public final String text() {
        return this.text;
    }

    public String toString() {
        String string;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("GiftInfo(gift=");
        sb2.append(this.gift);
        sb2.append(", ownedGiftId=");
        sb2.append(this.ownedGiftId);
        sb2.append(", convertStarCount=");
        sb2.append(this.convertStarCount);
        sb2.append(", prepaidUpgradeStarCount=");
        sb2.append(this.prepaidUpgradeStarCount);
        sb2.append(", canBeUpgraded=");
        sb2.append(this.canBeUpgraded);
        sb2.append(", text=");
        sb2.append(this.text);
        sb2.append(", entities=");
        MessageEntity[] messageEntityArr = this.entities;
        if (messageEntityArr != null) {
            string = Arrays.toString(messageEntityArr);
            m.e(string, "toString(...)");
        } else {
            string = null;
        }
        sb2.append(string);
        sb2.append(", isPrivate=");
        sb2.append(this.isPrivate);
        sb2.append(')');
        return sb2.toString();
    }
}
