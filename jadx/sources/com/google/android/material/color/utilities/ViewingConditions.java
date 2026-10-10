package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ViewingConditions {
    public static final ViewingConditions DEFAULT = defaultWithBackgroundLstar(50.0d);
    private final double aw;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f4396c;
    private final double fl;
    private final double flRoot;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final double f4397n;
    private final double nbb;

    /* JADX INFO: renamed from: nc, reason: collision with root package name */
    private final double f4398nc;
    private final double ncb;
    private final double[] rgbD;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final double f4399z;

    public static ViewingConditions make(double[] dArr, double d10, double d11, double d12, boolean z10) {
        double dMax = Math.max(0.1d, d11);
        double[][] dArr2 = Cam16.XYZ_TO_CAM16RGB;
        double d13 = dArr[0];
        double[] dArr3 = dArr2[0];
        double d14 = dArr3[0] * d13;
        double d15 = dArr[1];
        double d16 = d14 + (dArr3[1] * d15);
        double d17 = dArr[2];
        double d18 = d16 + (dArr3[2] * d17);
        double[] dArr4 = dArr2[1];
        double d19 = (dArr4[0] * d13) + (dArr4[1] * d15) + (dArr4[2] * d17);
        double[] dArr5 = dArr2[2];
        double d20 = (d13 * dArr5[0]) + (d15 * dArr5[1]) + (d17 * dArr5[2]);
        double d21 = (d12 / 10.0d) + 0.8d;
        double dLerp = d21 >= 0.9d ? MathUtils.lerp(0.59d, 0.69d, (d21 - 0.9d) * 10.0d) : MathUtils.lerp(0.525d, 0.59d, (d21 - 0.8d) * 10.0d);
        double dClampDouble = MathUtils.clampDouble(0.0d, 1.0d, z10 ? 1.0d : (1.0d - (Math.exp(((-d10) - 42.0d) / 92.0d) * 0.2777777777777778d)) * d21);
        double[] dArr6 = {(((100.0d / d18) * dClampDouble) + 1.0d) - dClampDouble, (((100.0d / d19) * dClampDouble) + 1.0d) - dClampDouble, (((100.0d / d20) * dClampDouble) + 1.0d) - dClampDouble};
        double d22 = 5.0d * d10;
        double d23 = 1.0d / (d22 + 1.0d);
        double d24 = d23 * d23 * d23 * d23;
        double d25 = 1.0d - d24;
        double dCbrt = (d24 * d10) + (d25 * 0.1d * d25 * Math.cbrt(d22));
        double dYFromLstar = ColorUtils.yFromLstar(dMax) / dArr[1];
        double dSqrt = Math.sqrt(dYFromLstar) + 1.48d;
        double dPow = 0.725d / Math.pow(dYFromLstar, 0.2d);
        double[] dArr7 = {Math.pow(((dArr6[0] * dCbrt) * d18) / 100.0d, 0.42d), Math.pow(((dArr6[1] * dCbrt) * d19) / 100.0d, 0.42d), Math.pow(((dArr6[2] * dCbrt) * d20) / 100.0d, 0.42d)};
        double d26 = dArr7[0];
        double d27 = (d26 * 400.0d) / (d26 + 27.13d);
        double d28 = dArr7[1];
        double d29 = (d28 * 400.0d) / (d28 + 27.13d);
        double d30 = dArr7[2];
        double[] dArr8 = {d27, d29, (400.0d * d30) / (d30 + 27.13d)};
        return new ViewingConditions(dYFromLstar, ((dArr8[0] * 2.0d) + dArr8[1] + (dArr8[2] * 0.05d)) * dPow, dPow, dPow, dLerp, d21, dArr6, dCbrt, Math.pow(dCbrt, 0.25d), dSqrt);
    }

    public double getAw() {
        return this.aw;
    }

    double getC() {
        return this.f4396c;
    }

    double getFl() {
        return this.fl;
    }

    public double getFlRoot() {
        return this.flRoot;
    }

    public double getN() {
        return this.f4397n;
    }

    public double getNbb() {
        return this.nbb;
    }

    double getNc() {
        return this.f4398nc;
    }

    double getNcb() {
        return this.ncb;
    }

    public double[] getRgbD() {
        return this.rgbD;
    }

    double getZ() {
        return this.f4399z;
    }

    private ViewingConditions(double d10, double d11, double d12, double d13, double d14, double d15, double[] dArr, double d16, double d17, double d18) {
        this.f4397n = d10;
        this.aw = d11;
        this.nbb = d12;
        this.ncb = d13;
        this.f4396c = d14;
        this.f4398nc = d15;
        this.rgbD = dArr;
        this.fl = d16;
        this.flRoot = d17;
        this.f4399z = d18;
    }

    public static ViewingConditions defaultWithBackgroundLstar(double d10) {
        return make(ColorUtils.whitePointD65(), (ColorUtils.yFromLstar(50.0d) * 63.66197723675813d) / 100.0d, d10, 2.0d, false);
    }
}
