package com.pengrad.telegrambot.model.business;

import androidx.paging.a;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0095\u0001\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0013\u0010\u000b\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0012R\u0013\u0010\r\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0012R\u0013\u0010\u0006\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0012R\u0013\u0010\u0005\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0012R\u0013\u0010\b\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012R\u0013\u0010\u0007\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0012R\u0013\u0010\t\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0012R\u0013\u0010\n\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0012R\u0013\u0010\u0010\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0012R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0012R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0012R\u0013\u0010\u000e\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0012R\u0013\u0010\u000f\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0012R\u0013\u0010\f\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0012¨\u0006("}, d2 = {"Lcom/pengrad/telegrambot/model/business/BusinessBotRights;", "", "canReply", "", "canReadMessages", "canDeleteSentMessages", "canDeleteAllMessages", "canEditName", "canEditBio", "canEditProfilePhoto", "canEditUsername", "canChangeGiftSettings", "canViewGiftsAndStars", "canConvertGiftsToStars", "canTransferAndUpgradeGifts", "canTransferStars", "canManageStories", "(ZZZZZZZZZZZZZZ)V", "()Z", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", TransactionPartnerType.OTHER, "hashCode", "", "toString", "", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class BusinessBotRights {
    private final boolean canChangeGiftSettings;
    private final boolean canConvertGiftsToStars;
    private final boolean canDeleteAllMessages;
    private final boolean canDeleteSentMessages;
    private final boolean canEditBio;
    private final boolean canEditName;
    private final boolean canEditProfilePhoto;
    private final boolean canEditUsername;
    private final boolean canManageStories;
    private final boolean canReadMessages;
    private final boolean canReply;
    private final boolean canTransferAndUpgradeGifts;
    private final boolean canTransferStars;
    private final boolean canViewGiftsAndStars;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BusinessBotRights)) {
            return false;
        }
        BusinessBotRights businessBotRights = (BusinessBotRights) other;
        return this.canReply == businessBotRights.canReply && this.canReadMessages == businessBotRights.canReadMessages && this.canDeleteSentMessages == businessBotRights.canDeleteSentMessages && this.canDeleteAllMessages == businessBotRights.canDeleteAllMessages && this.canEditName == businessBotRights.canEditName && this.canEditBio == businessBotRights.canEditBio && this.canEditProfilePhoto == businessBotRights.canEditProfilePhoto && this.canEditUsername == businessBotRights.canEditUsername && this.canChangeGiftSettings == businessBotRights.canChangeGiftSettings && this.canViewGiftsAndStars == businessBotRights.canViewGiftsAndStars && this.canConvertGiftsToStars == businessBotRights.canConvertGiftsToStars && this.canTransferAndUpgradeGifts == businessBotRights.canTransferAndUpgradeGifts && this.canTransferStars == businessBotRights.canTransferStars && this.canManageStories == businessBotRights.canManageStories;
    }

    /* JADX INFO: renamed from: canChangeGiftSettings, reason: from getter */
    public final boolean getCanChangeGiftSettings() {
        return this.canChangeGiftSettings;
    }

    /* JADX INFO: renamed from: canConvertGiftsToStars, reason: from getter */
    public final boolean getCanConvertGiftsToStars() {
        return this.canConvertGiftsToStars;
    }

    /* JADX INFO: renamed from: canDeleteAllMessages, reason: from getter */
    public final boolean getCanDeleteAllMessages() {
        return this.canDeleteAllMessages;
    }

    /* JADX INFO: renamed from: canDeleteSentMessages, reason: from getter */
    public final boolean getCanDeleteSentMessages() {
        return this.canDeleteSentMessages;
    }

    /* JADX INFO: renamed from: canEditBio, reason: from getter */
    public final boolean getCanEditBio() {
        return this.canEditBio;
    }

    /* JADX INFO: renamed from: canEditName, reason: from getter */
    public final boolean getCanEditName() {
        return this.canEditName;
    }

    /* JADX INFO: renamed from: canEditProfilePhoto, reason: from getter */
    public final boolean getCanEditProfilePhoto() {
        return this.canEditProfilePhoto;
    }

    /* JADX INFO: renamed from: canEditUsername, reason: from getter */
    public final boolean getCanEditUsername() {
        return this.canEditUsername;
    }

    /* JADX INFO: renamed from: canManageStories, reason: from getter */
    public final boolean getCanManageStories() {
        return this.canManageStories;
    }

    /* JADX INFO: renamed from: canReadMessages, reason: from getter */
    public final boolean getCanReadMessages() {
        return this.canReadMessages;
    }

    /* JADX INFO: renamed from: canReply, reason: from getter */
    public final boolean getCanReply() {
        return this.canReply;
    }

    /* JADX INFO: renamed from: canTransferAndUpgradeGifts, reason: from getter */
    public final boolean getCanTransferAndUpgradeGifts() {
        return this.canTransferAndUpgradeGifts;
    }

    /* JADX INFO: renamed from: canTransferStars, reason: from getter */
    public final boolean getCanTransferStars() {
        return this.canTransferStars;
    }

    /* JADX INFO: renamed from: canViewGiftsAndStars, reason: from getter */
    public final boolean getCanViewGiftsAndStars() {
        return this.canViewGiftsAndStars;
    }

    public final boolean component1() {
        return this.canReply;
    }

    public final boolean component10() {
        return this.canViewGiftsAndStars;
    }

    public final boolean component11() {
        return this.canConvertGiftsToStars;
    }

    public final boolean component12() {
        return this.canTransferAndUpgradeGifts;
    }

    public final boolean component13() {
        return this.canTransferStars;
    }

    public final boolean component14() {
        return this.canManageStories;
    }

    public final boolean component2() {
        return this.canReadMessages;
    }

    public final boolean component3() {
        return this.canDeleteSentMessages;
    }

    public final boolean component4() {
        return this.canDeleteAllMessages;
    }

    public final boolean component5() {
        return this.canEditName;
    }

    public final boolean component6() {
        return this.canEditBio;
    }

    public final boolean component7() {
        return this.canEditProfilePhoto;
    }

    public final boolean component8() {
        return this.canEditUsername;
    }

    public final boolean component9() {
        return this.canChangeGiftSettings;
    }

    public final BusinessBotRights copy(boolean canReply, boolean canReadMessages, boolean canDeleteSentMessages, boolean canDeleteAllMessages, boolean canEditName, boolean canEditBio, boolean canEditProfilePhoto, boolean canEditUsername, boolean canChangeGiftSettings, boolean canViewGiftsAndStars, boolean canConvertGiftsToStars, boolean canTransferAndUpgradeGifts, boolean canTransferStars, boolean canManageStories) {
        return new BusinessBotRights(canReply, canReadMessages, canDeleteSentMessages, canDeleteAllMessages, canEditName, canEditBio, canEditProfilePhoto, canEditUsername, canChangeGiftSettings, canViewGiftsAndStars, canConvertGiftsToStars, canTransferAndUpgradeGifts, canTransferStars, canManageStories);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((a.a(this.canReply) * 31) + a.a(this.canReadMessages)) * 31) + a.a(this.canDeleteSentMessages)) * 31) + a.a(this.canDeleteAllMessages)) * 31) + a.a(this.canEditName)) * 31) + a.a(this.canEditBio)) * 31) + a.a(this.canEditProfilePhoto)) * 31) + a.a(this.canEditUsername)) * 31) + a.a(this.canChangeGiftSettings)) * 31) + a.a(this.canViewGiftsAndStars)) * 31) + a.a(this.canConvertGiftsToStars)) * 31) + a.a(this.canTransferAndUpgradeGifts)) * 31) + a.a(this.canTransferStars)) * 31) + a.a(this.canManageStories);
    }

    public String toString() {
        return "BusinessBotRights(canReply=" + this.canReply + ", canReadMessages=" + this.canReadMessages + ", canDeleteSentMessages=" + this.canDeleteSentMessages + ", canDeleteAllMessages=" + this.canDeleteAllMessages + ", canEditName=" + this.canEditName + ", canEditBio=" + this.canEditBio + ", canEditProfilePhoto=" + this.canEditProfilePhoto + ", canEditUsername=" + this.canEditUsername + ", canChangeGiftSettings=" + this.canChangeGiftSettings + ", canViewGiftsAndStars=" + this.canViewGiftsAndStars + ", canConvertGiftsToStars=" + this.canConvertGiftsToStars + ", canTransferAndUpgradeGifts=" + this.canTransferAndUpgradeGifts + ", canTransferStars=" + this.canTransferStars + ", canManageStories=" + this.canManageStories + ')';
    }

    public BusinessBotRights(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, boolean z20, boolean z21, boolean z22, boolean z23) {
        this.canReply = z10;
        this.canReadMessages = z11;
        this.canDeleteSentMessages = z12;
        this.canDeleteAllMessages = z13;
        this.canEditName = z14;
        this.canEditBio = z15;
        this.canEditProfilePhoto = z16;
        this.canEditUsername = z17;
        this.canChangeGiftSettings = z18;
        this.canViewGiftsAndStars = z19;
        this.canConvertGiftsToStars = z20;
        this.canTransferAndUpgradeGifts = z21;
        this.canTransferStars = z22;
        this.canManageStories = z23;
    }
}
