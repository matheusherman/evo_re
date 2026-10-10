package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class HeroCarouselStrategy extends CarouselStrategy {
    private int keylineCount = 0;
    private static final int[] SMALL_COUNTS = {1};
    private static final int[] MEDIUM_COUNTS = {0, 1};

    @Override // com.google.android.material.carousel.CarouselStrategy
    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        int[] iArr;
        int i10;
        int[] iArrDoubleCounts;
        int[] iArrDoubleCounts2;
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f10 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredWidth = view.getMeasuredWidth() * 2;
        if (carousel.isHorizontal()) {
            f10 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredWidth = view.getMeasuredHeight() * 2;
        }
        float smallItemSizeMin = getSmallItemSizeMin() + f10;
        float fMax = Math.max(getSmallItemSizeMax() + f10, smallItemSizeMin);
        float f11 = containerHeight;
        float fMin = Math.min(measuredWidth + f10, f11);
        float fClamp = MathUtils.clamp((measuredWidth / 3.0f) + f10, smallItemSizeMin + f10, fMax + f10);
        float f12 = (fMin + fClamp) / 2.0f;
        int[] iArr2 = SMALL_COUNTS;
        int i11 = 0;
        if (f11 < 2.0f * smallItemSizeMin) {
            iArr = new int[]{0};
        } else {
            iArr = iArr2;
        }
        int iMax = (int) Math.max(1.0d, Math.floor((f11 - (CarouselStrategyHelper.maxValue(iArr2) * fMax)) / fMin));
        int iCeil = (((int) Math.ceil(f11 / fMin)) - iMax) + 1;
        int[] iArr3 = new int[iCeil];
        for (int i12 = 0; i12 < iCeil; i12++) {
            iArr3[i12] = iMax + i12;
        }
        if (carousel.getCarouselAlignment() == 1) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        if (i10 != 0) {
            iArrDoubleCounts = CarouselStrategy.doubleCounts(iArr);
        } else {
            iArrDoubleCounts = iArr;
        }
        if (i10 != 0) {
            iArrDoubleCounts2 = CarouselStrategy.doubleCounts(MEDIUM_COUNTS);
        } else {
            iArrDoubleCounts2 = MEDIUM_COUNTS;
        }
        Arrangement arrangementFindLowestCostArrangement = Arrangement.findLowestCostArrangement(f11, fClamp, smallItemSizeMin, fMax, iArrDoubleCounts, f12, iArrDoubleCounts2, fMin, iArr3);
        this.keylineCount = arrangementFindLowestCostArrangement.getItemCount();
        if (arrangementFindLowestCostArrangement.getItemCount() > carousel.getItemCount()) {
            arrangementFindLowestCostArrangement = Arrangement.findLowestCostArrangement(f11, fClamp, smallItemSizeMin, fMax, iArr, f12, MEDIUM_COUNTS, fMin, iArr3);
        } else {
            i11 = i10;
        }
        return CarouselStrategyHelper.createKeylineState(view.getContext(), f10, containerHeight, arrangementFindLowestCostArrangement, i11);
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    public boolean shouldRefreshKeylineState(@NonNull Carousel carousel, int i10) {
        if (carousel.getCarouselAlignment() == 1) {
            if ((i10 < this.keylineCount && carousel.getItemCount() >= this.keylineCount) || (i10 >= this.keylineCount && carousel.getItemCount() < this.keylineCount)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
