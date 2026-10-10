package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Contrast {
    private static final double CONTRAST_RATIO_EPSILON = 0.04d;
    private static final double LUMINANCE_GAMUT_MAP_TOLERANCE = 0.4d;
    public static final double RATIO_30 = 3.0d;
    public static final double RATIO_45 = 4.5d;
    public static final double RATIO_70 = 7.0d;
    public static final double RATIO_MAX = 21.0d;
    public static final double RATIO_MIN = 1.0d;

    public static double darker(double d10, double d11) {
        if (d10 >= 0.0d && d10 <= 100.0d) {
            double dYFromLstar = ColorUtils.yFromLstar(d10);
            double d12 = ((dYFromLstar + 5.0d) / d11) - 5.0d;
            if (d12 >= 0.0d && d12 <= 100.0d) {
                double dRatioOfYs = ratioOfYs(dYFromLstar, d12);
                double dAbs = Math.abs(dRatioOfYs - d11);
                if (dRatioOfYs < d11 && dAbs > CONTRAST_RATIO_EPSILON) {
                    return -1.0d;
                }
                double dLstarFromY = ColorUtils.lstarFromY(d12) - LUMINANCE_GAMUT_MAP_TOLERANCE;
                if (dLstarFromY >= 0.0d && dLstarFromY <= 100.0d) {
                    return dLstarFromY;
                }
            }
        }
        return -1.0d;
    }

    public static double lighter(double d10, double d11) {
        if (d10 >= 0.0d && d10 <= 100.0d) {
            double dYFromLstar = ColorUtils.yFromLstar(d10);
            double d12 = ((dYFromLstar + 5.0d) * d11) - 5.0d;
            if (d12 >= 0.0d && d12 <= 100.0d) {
                double dRatioOfYs = ratioOfYs(d12, dYFromLstar);
                double dAbs = Math.abs(dRatioOfYs - d11);
                if (dRatioOfYs < d11 && dAbs > CONTRAST_RATIO_EPSILON) {
                    return -1.0d;
                }
                double dLstarFromY = ColorUtils.lstarFromY(d12) + LUMINANCE_GAMUT_MAP_TOLERANCE;
                if (dLstarFromY >= 0.0d && dLstarFromY <= 100.0d) {
                    return dLstarFromY;
                }
            }
        }
        return -1.0d;
    }

    private Contrast() {
    }

    public static double darkerUnsafe(double d10, double d11) {
        return Math.max(0.0d, darker(d10, d11));
    }

    public static double lighterUnsafe(double d10, double d11) {
        double dLighter = lighter(d10, d11);
        if (dLighter < 0.0d) {
            return 100.0d;
        }
        return dLighter;
    }

    public static double ratioOfTones(double d10, double d11) {
        return ratioOfYs(ColorUtils.yFromLstar(d10), ColorUtils.yFromLstar(d11));
    }

    public static double ratioOfYs(double d10, double d11) {
        double dMax = Math.max(d10, d11);
        if (dMax != d11) {
            d10 = d11;
        }
        return (dMax + 5.0d) / (d10 + 5.0d);
    }
}
