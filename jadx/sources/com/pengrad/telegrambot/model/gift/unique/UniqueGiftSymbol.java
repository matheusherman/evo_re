package com.pengrad.telegrambot.model.gift.unique;

import com.pengrad.telegrambot.model.Sticker;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0007HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\nR\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/pengrad/telegrambot/model/gift/unique/UniqueGiftSymbol;", "", "name", "", "sticker", "Lcom/pengrad/telegrambot/model/Sticker;", "rarityPerMille", "", "(Ljava/lang/String;Lcom/pengrad/telegrambot/model/Sticker;I)V", "()Ljava/lang/String;", "()I", "()Lcom/pengrad/telegrambot/model/Sticker;", "component1", "component2", "component3", "copy", "equals", "", TransactionPartnerType.OTHER, "hashCode", "toString", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class UniqueGiftSymbol {
    private final String name;
    private final int rarityPerMille;
    private final Sticker sticker;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UniqueGiftSymbol)) {
            return false;
        }
        UniqueGiftSymbol uniqueGiftSymbol = (UniqueGiftSymbol) other;
        return m.a(this.name, uniqueGiftSymbol.name) && m.a(this.sticker, uniqueGiftSymbol.sticker) && this.rarityPerMille == uniqueGiftSymbol.rarityPerMille;
    }

    public UniqueGiftSymbol(String name, Sticker sticker, int i10) {
        m.f(name, "name");
        m.f(sticker, "sticker");
        this.name = name;
        this.sticker = sticker;
        this.rarityPerMille = i10;
    }

    public static /* synthetic */ UniqueGiftSymbol copy$default(UniqueGiftSymbol uniqueGiftSymbol, String str, Sticker sticker, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = uniqueGiftSymbol.name;
        }
        if ((i11 & 2) != 0) {
            sticker = uniqueGiftSymbol.sticker;
        }
        if ((i11 & 4) != 0) {
            i10 = uniqueGiftSymbol.rarityPerMille;
        }
        return uniqueGiftSymbol.copy(str, sticker, i10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Sticker getSticker() {
        return this.sticker;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getRarityPerMille() {
        return this.rarityPerMille;
    }

    public final UniqueGiftSymbol copy(String name, Sticker sticker, int rarityPerMille) {
        m.f(name, "name");
        m.f(sticker, "sticker");
        return new UniqueGiftSymbol(name, sticker, rarityPerMille);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.sticker.hashCode()) * 31) + this.rarityPerMille;
    }

    public final String name() {
        return this.name;
    }

    public final int rarityPerMille() {
        return this.rarityPerMille;
    }

    public final Sticker sticker() {
        return this.sticker;
    }

    public String toString() {
        return "UniqueGiftSymbol(name=" + this.name + ", sticker=" + this.sticker + ", rarityPerMille=" + this.rarityPerMille + ')';
    }
}
