package com.pengrad.telegrambot.model.gift.unique;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J1\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0013\u0010\u0005\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0013\u0010\u0006\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/pengrad/telegrambot/model/gift/unique/UniqueGiftBackdropColors;", "", "centerColor", "", "edgeColor", "symbolColor", "textColor", "(IIII)V", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", TransactionPartnerType.OTHER, "hashCode", "toString", "", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class UniqueGiftBackdropColors {
    private final int centerColor;
    private final int edgeColor;
    private final int symbolColor;
    private final int textColor;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UniqueGiftBackdropColors)) {
            return false;
        }
        UniqueGiftBackdropColors uniqueGiftBackdropColors = (UniqueGiftBackdropColors) other;
        return this.centerColor == uniqueGiftBackdropColors.centerColor && this.edgeColor == uniqueGiftBackdropColors.edgeColor && this.symbolColor == uniqueGiftBackdropColors.symbolColor && this.textColor == uniqueGiftBackdropColors.textColor;
    }

    public static /* synthetic */ UniqueGiftBackdropColors copy$default(UniqueGiftBackdropColors uniqueGiftBackdropColors, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = uniqueGiftBackdropColors.centerColor;
        }
        if ((i14 & 2) != 0) {
            i11 = uniqueGiftBackdropColors.edgeColor;
        }
        if ((i14 & 4) != 0) {
            i12 = uniqueGiftBackdropColors.symbolColor;
        }
        if ((i14 & 8) != 0) {
            i13 = uniqueGiftBackdropColors.textColor;
        }
        return uniqueGiftBackdropColors.copy(i10, i11, i12, i13);
    }

    /* JADX INFO: renamed from: centerColor, reason: from getter */
    public final int getCenterColor() {
        return this.centerColor;
    }

    public final int component1() {
        return this.centerColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getEdgeColor() {
        return this.edgeColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSymbolColor() {
        return this.symbolColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getTextColor() {
        return this.textColor;
    }

    public final UniqueGiftBackdropColors copy(int centerColor, int edgeColor, int symbolColor, int textColor) {
        return new UniqueGiftBackdropColors(centerColor, edgeColor, symbolColor, textColor);
    }

    public final int edgeColor() {
        return this.edgeColor;
    }

    public int hashCode() {
        return (((((this.centerColor * 31) + this.edgeColor) * 31) + this.symbolColor) * 31) + this.textColor;
    }

    public final int symbolColor() {
        return this.symbolColor;
    }

    public final int textColor() {
        return this.textColor;
    }

    public String toString() {
        return "UniqueGiftBackdropColors(centerColor=" + this.centerColor + ", edgeColor=" + this.edgeColor + ", symbolColor=" + this.symbolColor + ", textColor=" + this.textColor + ')';
    }

    public UniqueGiftBackdropColors(int i10, int i11, int i12, int i13) {
        this.centerColor = i10;
        this.edgeColor = i11;
        this.symbolColor = i12;
        this.textColor = i13;
    }
}
