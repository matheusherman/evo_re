package androidx.leanback.graphics;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public final class ColorFilterCache {
    private static final SparseArray<ColorFilterCache> sColorToFiltersMap = new SparseArray<>();
    private final PorterDuffColorFilter[] mFilters = new PorterDuffColorFilter[256];

    public ColorFilter getFilterForLevel(float f10) {
        if (f10 < 0.0f || f10 > 1.0d) {
            return null;
        }
        return this.mFilters[(int) (f10 * 255.0f)];
    }

    private ColorFilterCache(int i10, int i11, int i12) {
        for (int i13 = 0; i13 <= 255; i13++) {
            this.mFilters[i13] = new PorterDuffColorFilter(Color.argb(i13, i10, i11, i12), PorterDuff.Mode.SRC_ATOP);
        }
    }

    public static ColorFilterCache getColorFilterCache(int i10) {
        int iRed = Color.red(i10);
        int iGreen = Color.green(i10);
        int iBlue = Color.blue(i10);
        int iRgb = Color.rgb(iRed, iGreen, iBlue);
        SparseArray<ColorFilterCache> sparseArray = sColorToFiltersMap;
        ColorFilterCache colorFilterCache = sparseArray.get(iRgb);
        if (colorFilterCache == null) {
            ColorFilterCache colorFilterCache2 = new ColorFilterCache(iRed, iGreen, iBlue);
            sparseArray.put(iRgb, colorFilterCache2);
            return colorFilterCache2;
        }
        return colorFilterCache;
    }
}
