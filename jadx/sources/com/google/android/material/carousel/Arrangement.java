package com.google.android.material.carousel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Arrangement {
    private static final float MEDIUM_ITEM_FLEX_PERCENTAGE = 0.1f;
    final float cost;
    final int largeCount;
    float largeSize;
    int mediumCount;
    float mediumSize;
    final int priority;
    int smallCount;
    float smallSize;

    private float calculateLargeSize(float f10, int i10, float f11, int i11, int i12) {
        if (i10 <= 0) {
            f11 = 0.0f;
        }
        float f12 = i11 / 2.0f;
        return (f10 - ((i10 + f12) * f11)) / (i12 + f12);
    }

    @Nullable
    public static Arrangement findLowestCostArrangement(float f10, float f11, float f12, float f13, @NonNull int[] iArr, float f14, @NonNull int[] iArr2, float f15, @NonNull int[] iArr3) {
        Arrangement arrangement = null;
        int i10 = 1;
        for (int i11 : iArr3) {
            int length = iArr2.length;
            int i12 = 0;
            while (i12 < length) {
                int i13 = iArr2[i12];
                int length2 = iArr.length;
                int i14 = 0;
                while (i14 < length2) {
                    int i15 = length;
                    int i16 = i12;
                    int i17 = i10;
                    int i18 = length2;
                    int i19 = i14;
                    Arrangement arrangement2 = new Arrangement(i17, f11, f12, f13, iArr[i14], f14, i13, f15, i11, f10);
                    if (arrangement == null || arrangement2.cost < arrangement.cost) {
                        if (arrangement2.cost == 0.0f) {
                            return arrangement2;
                        }
                        arrangement = arrangement2;
                    }
                    int i20 = i17 + 1;
                    i14 = i19 + 1;
                    i12 = i16;
                    i10 = i20;
                    length = i15;
                    length2 = i18;
                }
                i12++;
                i10 = i10;
                length = length;
            }
        }
        return arrangement;
    }

    private float getSpace() {
        return (this.largeSize * this.largeCount) + (this.mediumSize * this.mediumCount) + (this.smallSize * this.smallCount);
    }

    private boolean isValid() {
        int i10 = this.largeCount;
        if (i10 <= 0 || this.smallCount <= 0 || this.mediumCount <= 0) {
            return i10 <= 0 || this.smallCount <= 0 || this.largeSize > this.smallSize;
        }
        float f10 = this.largeSize;
        float f11 = this.mediumSize;
        return f10 > f11 && f11 > this.smallSize;
    }

    int getItemCount() {
        return this.smallCount + this.mediumCount + this.largeCount;
    }

    @NonNull
    public String toString() {
        return "Arrangement [priority=" + this.priority + ", smallCount=" + this.smallCount + ", smallSize=" + this.smallSize + ", mediumCount=" + this.mediumCount + ", mediumSize=" + this.mediumSize + ", largeCount=" + this.largeCount + ", largeSize=" + this.largeSize + ", cost=" + this.cost + "]";
    }

    public Arrangement(int i10, float f10, float f11, float f12, int i11, float f13, int i12, float f14, int i13, float f15) {
        this.priority = i10;
        this.smallSize = MathUtils.clamp(f10, f11, f12);
        this.smallCount = i11;
        this.mediumSize = f13;
        this.mediumCount = i12;
        this.largeSize = f14;
        this.largeCount = i13;
        fit(f15, f11, f12, f14);
        this.cost = cost(f14);
    }

    private float cost(float f10) {
        if (!isValid()) {
            return Float.MAX_VALUE;
        }
        return Math.abs(f10 - this.largeSize) * this.priority;
    }

    private void fit(float f10, float f11, float f12, float f13) {
        float f14;
        float space = f10 - getSpace();
        int i10 = this.smallCount;
        if (i10 > 0 && space > 0.0f) {
            float f15 = this.smallSize;
            this.smallSize = f15 + Math.min(space / i10, f12 - f15);
        } else if (i10 > 0 && space < 0.0f) {
            float f16 = this.smallSize;
            this.smallSize = f16 + Math.max(space / i10, f11 - f16);
        }
        int i11 = this.smallCount;
        if (i11 > 0) {
            f14 = this.smallSize;
        } else {
            f14 = 0.0f;
        }
        this.smallSize = f14;
        float fCalculateLargeSize = calculateLargeSize(f10, i11, f14, this.mediumCount, this.largeCount);
        this.largeSize = fCalculateLargeSize;
        float f17 = (this.smallSize + fCalculateLargeSize) / 2.0f;
        this.mediumSize = f17;
        int i12 = this.mediumCount;
        if (i12 > 0 && fCalculateLargeSize != f13) {
            float f18 = (f13 - fCalculateLargeSize) * this.largeCount;
            float fMin = Math.min(Math.abs(f18), f17 * 0.1f * i12);
            if (f18 > 0.0f) {
                this.mediumSize -= fMin / this.mediumCount;
                this.largeSize += fMin / this.largeCount;
            } else {
                this.mediumSize += fMin / this.mediumCount;
                this.largeSize -= fMin / this.largeCount;
            }
        }
    }
}
