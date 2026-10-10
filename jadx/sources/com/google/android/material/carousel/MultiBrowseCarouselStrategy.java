package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class MultiBrowseCarouselStrategy extends CarouselStrategy {
    private int keylineCount = 0;
    private static final int[] SMALL_COUNTS = {1};
    private static final int[] MEDIUM_COUNTS = {1, 0};

    @Override // com.google.android.material.carousel.CarouselStrategy
    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        boolean z10;
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f10 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (carousel.isHorizontal()) {
            f10 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float smallItemSizeMin = getSmallItemSizeMin() + f10;
        float fMax = Math.max(getSmallItemSizeMax() + f10, smallItemSizeMin);
        float f11 = containerHeight;
        float fMin = Math.min(measuredHeight + f10, f11);
        float fClamp = MathUtils.clamp((measuredHeight / 3.0f) + f10, smallItemSizeMin + f10, fMax + f10);
        float f12 = (fMin + fClamp) / 2.0f;
        int[] iArrDoubleCounts = SMALL_COUNTS;
        float f13 = 2.0f * smallItemSizeMin;
        if (f11 <= f13) {
            iArrDoubleCounts = new int[]{0};
        }
        int[] iArrDoubleCounts2 = MEDIUM_COUNTS;
        if (carousel.getCarouselAlignment() == 1) {
            iArrDoubleCounts = CarouselStrategy.doubleCounts(iArrDoubleCounts);
            iArrDoubleCounts2 = CarouselStrategy.doubleCounts(iArrDoubleCounts2);
        }
        int iMax = (int) Math.max(1.0d, Math.floor(((f11 - (CarouselStrategyHelper.maxValue(iArrDoubleCounts2) * f12)) - (CarouselStrategyHelper.maxValue(iArrDoubleCounts) * fMax)) / fMin));
        int iCeil = (int) Math.ceil(f11 / fMin);
        int i10 = (iCeil - iMax) + 1;
        int[] iArr = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr[i11] = iCeil - i11;
        }
        Arrangement arrangementFindLowestCostArrangement = Arrangement.findLowestCostArrangement(f11, fClamp, smallItemSizeMin, fMax, iArrDoubleCounts, f12, iArrDoubleCounts2, fMin, iArr);
        this.keylineCount = arrangementFindLowestCostArrangement.getItemCount();
        boolean zEnsureArrangementFitsItemCount = ensureArrangementFitsItemCount(arrangementFindLowestCostArrangement, carousel.getItemCount());
        int i12 = arrangementFindLowestCostArrangement.mediumCount;
        if (i12 == 0 && arrangementFindLowestCostArrangement.smallCount == 0 && f11 > f13) {
            arrangementFindLowestCostArrangement.smallCount = 1;
            z10 = true;
        } else {
            z10 = zEnsureArrangementFitsItemCount;
        }
        if (z10) {
            arrangementFindLowestCostArrangement = Arrangement.findLowestCostArrangement(f11, fClamp, smallItemSizeMin, fMax, new int[]{arrangementFindLowestCostArrangement.smallCount}, f12, new int[]{i12}, fMin, new int[]{arrangementFindLowestCostArrangement.largeCount});
        }
        return CarouselStrategyHelper.createKeylineState(view.getContext(), f10, containerHeight, arrangementFindLowestCostArrangement, carousel.getCarouselAlignment());
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    public boolean shouldRefreshKeylineState(@NonNull Carousel carousel, int i10) {
        if (i10 >= this.keylineCount || carousel.getItemCount() < this.keylineCount) {
            return i10 >= this.keylineCount && carousel.getItemCount() < this.keylineCount;
        }
        return true;
    }

    boolean ensureArrangementFitsItemCount(Arrangement arrangement, int i10) {
        boolean z10;
        int itemCount = arrangement.getItemCount() - i10;
        if (itemCount > 0 && (arrangement.smallCount > 0 || arrangement.mediumCount > 1)) {
            z10 = true;
        } else {
            z10 = false;
        }
        while (itemCount > 0) {
            int i11 = arrangement.smallCount;
            if (i11 > 0) {
                arrangement.smallCount = i11 - 1;
            } else {
                int i12 = arrangement.mediumCount;
                if (i12 > 1) {
                    arrangement.mediumCount = i12 - 1;
                }
            }
            itemCount--;
        }
        return z10;
    }
}
