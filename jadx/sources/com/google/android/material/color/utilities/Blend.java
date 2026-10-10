package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class Blend {
    private Blend() {
    }

    public static int cam16Ucs(int i10, int i11, double d10) {
        Cam16 cam16FromInt = Cam16.fromInt(i10);
        Cam16 cam16FromInt2 = Cam16.fromInt(i11);
        double jstar = cam16FromInt.getJstar();
        double astar = cam16FromInt.getAstar();
        double bstar = cam16FromInt.getBstar();
        return Cam16.fromUcs(jstar + ((cam16FromInt2.getJstar() - jstar) * d10), astar + ((cam16FromInt2.getAstar() - astar) * d10), bstar + ((cam16FromInt2.getBstar() - bstar) * d10)).toInt();
    }

    public static int harmonize(int i10, int i11) {
        Hct hctFromInt = Hct.fromInt(i10);
        Hct hctFromInt2 = Hct.fromInt(i11);
        return Hct.from(MathUtils.sanitizeDegreesDouble(hctFromInt.getHue() + (Math.min(MathUtils.differenceDegrees(hctFromInt.getHue(), hctFromInt2.getHue()) * 0.5d, 15.0d) * MathUtils.rotationDirection(hctFromInt.getHue(), hctFromInt2.getHue()))), hctFromInt.getChroma(), hctFromInt.getTone()).toInt();
    }

    public static int hctHue(int i10, int i11, double d10) {
        return Hct.from(Cam16.fromInt(cam16Ucs(i10, i11, d10)).getHue(), Cam16.fromInt(i10).getChroma(), ColorUtils.lstarFromArgb(i10)).toInt();
    }
}
