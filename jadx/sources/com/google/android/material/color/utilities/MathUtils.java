package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MathUtils {
    public static double differenceDegrees(double d10, double d11) {
        return 180.0d - Math.abs(Math.abs(d10 - d11) - 180.0d);
    }

    public static double[] matrixMultiply(double[] dArr, double[][] dArr2) {
        double d10 = dArr[0];
        double[] dArr3 = dArr2[0];
        double d11 = dArr3[0] * d10;
        double d12 = dArr[1];
        double d13 = d11 + (dArr3[1] * d12);
        double d14 = dArr[2];
        double d15 = d13 + (dArr3[2] * d14);
        double[] dArr4 = dArr2[1];
        double d16 = (dArr4[0] * d10) + (dArr4[1] * d12) + (dArr4[2] * d14);
        double[] dArr5 = dArr2[2];
        return new double[]{d15, d16, (d10 * dArr5[0]) + (d12 * dArr5[1]) + (d14 * dArr5[2])};
    }

    public static double rotationDirection(double d10, double d11) {
        return sanitizeDegreesDouble(d11 - d10) <= 180.0d ? 1.0d : -1.0d;
    }

    public static double clampDouble(double d10, double d11, double d12) {
        if (d12 < d10) {
            return d10;
        }
        return d12 > d11 ? d11 : d12;
    }

    public static int clampInt(int i10, int i11, int i12) {
        if (i12 < i10) {
            return i10;
        }
        return i12 > i11 ? i11 : i12;
    }

    public static double lerp(double d10, double d11, double d12) {
        return ((1.0d - d12) * d10) + (d12 * d11);
    }

    public static int sanitizeDegreesInt(int i10) {
        int i11 = i10 % 360;
        return i11 < 0 ? i11 + 360 : i11;
    }

    public static int signum(double d10) {
        if (d10 < 0.0d) {
            return -1;
        }
        return d10 == 0.0d ? 0 : 1;
    }

    private MathUtils() {
    }

    public static double sanitizeDegreesDouble(double d10) {
        double d11 = d10 % 360.0d;
        if (d11 < 0.0d) {
            return d11 + 360.0d;
        }
        return d11;
    }
}
