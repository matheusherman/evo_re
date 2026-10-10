package com.pengrad.telegrambot.model.story.area;

import c6.a;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003JE\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\b\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u0013\u0010\u0006\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\nR\u0013\u0010\u0007\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\nR\u0013\u0010\u0005\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\nR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/pengrad/telegrambot/model/story/area/StoryAreaPosition;", "", "xPercentage", "", "yPercentage", "widthPercentage", "heightPercentage", "rotationAngle", "cornerRadiusPercentage", "(DDDDDD)V", "()D", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", TransactionPartnerType.OTHER, "hashCode", "", "toString", "", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class StoryAreaPosition {
    private final double cornerRadiusPercentage;
    private final double heightPercentage;
    private final double rotationAngle;
    private final double widthPercentage;
    private final double xPercentage;
    private final double yPercentage;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoryAreaPosition)) {
            return false;
        }
        StoryAreaPosition storyAreaPosition = (StoryAreaPosition) other;
        return Double.compare(this.xPercentage, storyAreaPosition.xPercentage) == 0 && Double.compare(this.yPercentage, storyAreaPosition.yPercentage) == 0 && Double.compare(this.widthPercentage, storyAreaPosition.widthPercentage) == 0 && Double.compare(this.heightPercentage, storyAreaPosition.heightPercentage) == 0 && Double.compare(this.rotationAngle, storyAreaPosition.rotationAngle) == 0 && Double.compare(this.cornerRadiusPercentage, storyAreaPosition.cornerRadiusPercentage) == 0;
    }

    public static /* synthetic */ StoryAreaPosition copy$default(StoryAreaPosition storyAreaPosition, double d10, double d11, double d12, double d13, double d14, double d15, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            d10 = storyAreaPosition.xPercentage;
        }
        return storyAreaPosition.copy(d10, (i10 & 2) != 0 ? storyAreaPosition.yPercentage : d11, (i10 & 4) != 0 ? storyAreaPosition.widthPercentage : d12, (i10 & 8) != 0 ? storyAreaPosition.heightPercentage : d13, (i10 & 16) != 0 ? storyAreaPosition.rotationAngle : d14, (i10 & 32) != 0 ? storyAreaPosition.cornerRadiusPercentage : d15);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getXPercentage() {
        return this.xPercentage;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getYPercentage() {
        return this.yPercentage;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final double getWidthPercentage() {
        return this.widthPercentage;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final double getHeightPercentage() {
        return this.heightPercentage;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final double getRotationAngle() {
        return this.rotationAngle;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final double getCornerRadiusPercentage() {
        return this.cornerRadiusPercentage;
    }

    public final StoryAreaPosition copy(double xPercentage, double yPercentage, double widthPercentage, double heightPercentage, double rotationAngle, double cornerRadiusPercentage) {
        return new StoryAreaPosition(xPercentage, yPercentage, widthPercentage, heightPercentage, rotationAngle, cornerRadiusPercentage);
    }

    public final double cornerRadiusPercentage() {
        return this.cornerRadiusPercentage;
    }

    public int hashCode() {
        return (((((((((a.a(this.xPercentage) * 31) + a.a(this.yPercentage)) * 31) + a.a(this.widthPercentage)) * 31) + a.a(this.heightPercentage)) * 31) + a.a(this.rotationAngle)) * 31) + a.a(this.cornerRadiusPercentage);
    }

    public final double heightPercentage() {
        return this.heightPercentage;
    }

    public final double rotationAngle() {
        return this.rotationAngle;
    }

    public String toString() {
        return "StoryAreaPosition(xPercentage=" + this.xPercentage + ", yPercentage=" + this.yPercentage + ", widthPercentage=" + this.widthPercentage + ", heightPercentage=" + this.heightPercentage + ", rotationAngle=" + this.rotationAngle + ", cornerRadiusPercentage=" + this.cornerRadiusPercentage + ')';
    }

    public final double widthPercentage() {
        return this.widthPercentage;
    }

    public final double xPercentage() {
        return this.xPercentage;
    }

    public final double yPercentage() {
        return this.yPercentage;
    }

    public StoryAreaPosition(double d10, double d11, double d12, double d13, double d14, double d15) {
        this.xPercentage = d10;
        this.yPercentage = d11;
        this.widthPercentage = d12;
        this.heightPercentage = d13;
        this.rotationAngle = d14;
        this.cornerRadiusPercentage = d15;
    }
}
