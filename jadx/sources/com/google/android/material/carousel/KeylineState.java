package com.google.android.material.carousel;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.utilities.Contrast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class KeylineState {
    private final int carouselSize;
    private final int firstFocalKeylineIndex;
    private final float itemSize;
    private final List<Keyline> keylines;
    private final int lastFocalKeylineIndex;
    private int totalVisibleFocalItems;

    /* JADX INFO: renamed from: com.google.android.material.carousel.KeylineState$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class Builder {
        private static final int NO_INDEX = -1;
        private static final float UNKNOWN_LOC = Float.MIN_VALUE;
        private final int carouselSize;
        private final float itemSize;
        private Keyline tmpFirstFocalKeyline;
        private Keyline tmpLastFocalKeyline;
        private final List<Keyline> tmpKeylines = new ArrayList();
        private int firstFocalKeylineIndex = -1;
        private int lastFocalKeylineIndex = -1;
        private float lastKeylineMaskedSize = 0.0f;
        private int latestAnchorKeylineIndex = -1;

        private static float calculateKeylineLocationForItemPosition(float f10, float f11, int i10, int i11) {
            return (f10 - (i10 * f11)) + (i11 * f11);
        }

        @NonNull
        public Builder addAnchorKeyline(float f10, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f11, float f12) {
            return addKeyline(f10, f11, f12, false, true);
        }

        @NonNull
        public Builder addKeyline(float f10, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f11, float f12, boolean z10) {
            return addKeyline(f10, f11, f12, z10, false);
        }

        @NonNull
        public Builder addKeylineRange(float f10, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f11, float f12, int i10) {
            return addKeylineRange(f10, f11, f12, i10, false);
        }

        @NonNull
        public Builder addKeyline(float f10, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f11, float f12) {
            return addKeyline(f10, f11, f12, false);
        }

        @NonNull
        public Builder addKeylineRange(float f10, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f11, float f12, int i10, boolean z10) {
            if (i10 > 0 && f12 > 0.0f) {
                for (int i11 = 0; i11 < i10; i11++) {
                    addKeyline((i11 * f12) + f10, f11, f12, z10);
                }
            }
            return this;
        }

        @NonNull
        public KeylineState build() {
            if (this.tmpFirstFocalKeyline == null) {
                throw new IllegalStateException("There must be a keyline marked as focal.");
            }
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < this.tmpKeylines.size(); i10++) {
                Keyline keyline = this.tmpKeylines.get(i10);
                arrayList.add(new Keyline(calculateKeylineLocationForItemPosition(this.tmpFirstFocalKeyline.locOffset, this.itemSize, this.firstFocalKeylineIndex, i10), keyline.locOffset, keyline.mask, keyline.maskedItemSize, keyline.isAnchor, keyline.cutoff, keyline.leftOrTopPaddingShift, keyline.rightOrBottomPaddingShift));
            }
            return new KeylineState(this.itemSize, arrayList, this.firstFocalKeylineIndex, this.lastFocalKeylineIndex, this.carouselSize, null);
        }

        public Builder(float f10, int i10) {
            this.itemSize = f10;
            this.carouselSize = i10;
        }

        @NonNull
        public Builder addKeyline(float f10, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f11, float f12, boolean z10, boolean z11, float f13, float f14, float f15) {
            if (f12 <= 0.0f) {
                return this;
            }
            if (z11) {
                if (!z10) {
                    int i10 = this.latestAnchorKeylineIndex;
                    if (i10 != -1 && i10 != 0) {
                        throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
                    }
                    this.latestAnchorKeylineIndex = this.tmpKeylines.size();
                } else {
                    throw new IllegalArgumentException("Anchor keylines cannot be focal.");
                }
            }
            Keyline keyline = new Keyline(UNKNOWN_LOC, f10, f11, f12, z11, f13, f14, f15);
            if (z10) {
                if (this.tmpFirstFocalKeyline == null) {
                    this.tmpFirstFocalKeyline = keyline;
                    this.firstFocalKeylineIndex = this.tmpKeylines.size();
                }
                if (this.lastFocalKeylineIndex != -1 && this.tmpKeylines.size() - this.lastFocalKeylineIndex > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                }
                if (f12 == this.tmpFirstFocalKeyline.maskedItemSize) {
                    this.tmpLastFocalKeyline = keyline;
                    this.lastFocalKeylineIndex = this.tmpKeylines.size();
                } else {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
            } else {
                if (this.tmpFirstFocalKeyline == null && keyline.maskedItemSize < this.lastKeylineMaskedSize) {
                    throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                }
                if (this.tmpLastFocalKeyline != null && keyline.maskedItemSize > this.lastKeylineMaskedSize) {
                    throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                }
            }
            this.lastKeylineMaskedSize = keyline.maskedItemSize;
            this.tmpKeylines.add(keyline);
            return this;
        }

        @NonNull
        public Builder addKeyline(float f10, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f11, float f12, boolean z10, boolean z11, float f13) {
            return addKeyline(f10, f11, f12, z10, z11, f13, 0.0f, 0.0f);
        }

        @NonNull
        public Builder addKeyline(float f10, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f11, float f12, boolean z10, boolean z11) {
            float f13;
            float fAbs;
            float f14 = f12 / 2.0f;
            float f15 = f10 - f14;
            float f16 = f14 + f10;
            int i10 = this.carouselSize;
            if (f16 > i10) {
                fAbs = Math.abs(f16 - Math.max(f16 - f12, i10));
            } else {
                if (f15 < 0.0f) {
                    fAbs = Math.abs(f15 - Math.min(f15 + f12, 0.0f));
                } else {
                    f13 = 0.0f;
                }
                return addKeyline(f10, f11, f12, z10, z11, f13);
            }
            f13 = fAbs;
            return addKeyline(f10, f11, f12, z10, z11, f13);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class Keyline {
        final float cutoff;
        final boolean isAnchor;
        final float leftOrTopPaddingShift;
        final float loc;
        final float locOffset;
        final float mask;
        final float maskedItemSize;
        final float rightOrBottomPaddingShift;

        Keyline(float f10, float f11, float f12, float f13) {
            this(f10, f11, f12, f13, false, 0.0f, 0.0f, 0.0f);
        }

        Keyline(float f10, float f11, float f12, float f13, boolean z10, float f14, float f15, float f16) {
            this.loc = f10;
            this.locOffset = f11;
            this.mask = f12;
            this.maskedItemSize = f13;
            this.isAnchor = z10;
            this.cutoff = f14;
            this.leftOrTopPaddingShift = f15;
            this.rightOrBottomPaddingShift = f16;
        }

        static Keyline lerp(Keyline keyline, Keyline keyline2, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
            return new Keyline(AnimationUtils.lerp(keyline.loc, keyline2.loc, f10), AnimationUtils.lerp(keyline.locOffset, keyline2.locOffset, f10), AnimationUtils.lerp(keyline.mask, keyline2.mask, f10), AnimationUtils.lerp(keyline.maskedItemSize, keyline2.maskedItemSize, f10));
        }
    }

    /* synthetic */ KeylineState(float f10, List list, int i10, int i11, int i12, AnonymousClass1 anonymousClass1) {
        this(f10, list, i10, i11, i12);
    }

    @Nullable
    Keyline getFirstNonAnchorKeyline() {
        for (int i10 = 0; i10 < this.keylines.size(); i10++) {
            Keyline keyline = this.keylines.get(i10);
            if (!keyline.isAnchor) {
                return keyline;
            }
        }
        return null;
    }

    private KeylineState(float f10, List<Keyline> list, int i10, int i11, int i12) {
        this.itemSize = f10;
        this.keylines = Collections.unmodifiableList(list);
        this.firstFocalKeylineIndex = i10;
        this.lastFocalKeylineIndex = i11;
        while (i10 <= i11) {
            if (list.get(i10).cutoff == 0.0f) {
                this.totalVisibleFocalItems++;
            }
            i10++;
        }
        this.carouselSize = i12;
    }

    static KeylineState reverse(KeylineState keylineState, int i10) {
        Builder builder = new Builder(keylineState.getItemSize(), i10);
        float f10 = (i10 - keylineState.getLastKeyline().locOffset) - (keylineState.getLastKeyline().maskedItemSize / 2.0f);
        int size = keylineState.getKeylines().size() - 1;
        while (size >= 0) {
            Keyline keyline = keylineState.getKeylines().get(size);
            builder.addKeyline((keyline.maskedItemSize / 2.0f) + f10, keyline.mask, keyline.maskedItemSize, size >= keylineState.getFirstFocalKeylineIndex() && size <= keylineState.getLastFocalKeylineIndex(), keyline.isAnchor);
            f10 += keyline.maskedItemSize;
            size--;
        }
        return builder.build();
    }

    int getCarouselSize() {
        return this.carouselSize;
    }

    Keyline getFirstFocalKeyline() {
        return this.keylines.get(this.firstFocalKeylineIndex);
    }

    int getFirstFocalKeylineIndex() {
        return this.firstFocalKeylineIndex;
    }

    Keyline getFirstKeyline() {
        return this.keylines.get(0);
    }

    List<Keyline> getFocalKeylines() {
        return this.keylines.subList(this.firstFocalKeylineIndex, this.lastFocalKeylineIndex + 1);
    }

    float getItemSize() {
        return this.itemSize;
    }

    List<Keyline> getKeylines() {
        return this.keylines;
    }

    Keyline getLastFocalKeyline() {
        return this.keylines.get(this.lastFocalKeylineIndex);
    }

    int getLastFocalKeylineIndex() {
        return this.lastFocalKeylineIndex;
    }

    Keyline getLastKeyline() {
        List<Keyline> list = this.keylines;
        return list.get(list.size() - 1);
    }

    @Nullable
    Keyline getLastNonAnchorKeyline() {
        for (int size = this.keylines.size() - 1; size >= 0; size--) {
            Keyline keyline = this.keylines.get(size);
            if (!keyline.isAnchor) {
                return keyline;
            }
        }
        return null;
    }

    int getNumberOfNonAnchorKeylines() {
        Iterator<Keyline> it = this.keylines.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next().isAnchor) {
                i10++;
            }
        }
        return this.keylines.size() - i10;
    }

    int getTotalVisibleFocalItems() {
        return this.totalVisibleFocalItems;
    }

    static KeylineState lerp(KeylineState keylineState, KeylineState keylineState2, float f10) {
        if (keylineState.getItemSize() == keylineState2.getItemSize()) {
            List<Keyline> keylines = keylineState.getKeylines();
            List<Keyline> keylines2 = keylineState2.getKeylines();
            if (keylines.size() == keylines2.size()) {
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < keylineState.getKeylines().size(); i10++) {
                    arrayList.add(Keyline.lerp(keylines.get(i10), keylines2.get(i10), f10));
                }
                return new KeylineState(keylineState.getItemSize(), arrayList, AnimationUtils.lerp(keylineState.getFirstFocalKeylineIndex(), keylineState2.getFirstFocalKeylineIndex(), f10), AnimationUtils.lerp(keylineState.getLastFocalKeylineIndex(), keylineState2.getLastFocalKeylineIndex(), f10), keylineState.carouselSize);
            }
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
    }
}
