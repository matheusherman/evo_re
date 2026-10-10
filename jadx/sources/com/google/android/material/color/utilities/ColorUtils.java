package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ColorUtils {
    static final double[][] SRGB_TO_XYZ = {new double[]{0.41233895d, 0.35762064d, 0.18051042d}, new double[]{0.2126d, 0.7152d, 0.0722d}, new double[]{0.01932141d, 0.11916382d, 0.95034478d}};
    static final double[][] XYZ_TO_SRGB = {new double[]{3.2413774792388685d, -1.5376652402851851d, -0.49885366846268053d}, new double[]{-0.9691452513005321d, 1.8758853451067872d, 0.04156585616912061d}, new double[]{0.05562093689691305d, -0.20395524564742123d, 1.0571799111220335d}};
    static final double[] WHITE_POINT_D65 = {95.047d, 100.0d, 108.883d};

    public static int argbFromLinrgb(double[] dArr) {
        return argbFromRgb(delinearized(dArr[0]), delinearized(dArr[1]), delinearized(dArr[2]));
    }

    public static double linearized(int i10) {
        double d10 = ((double) i10) / 255.0d;
        return (d10 <= 0.040449936d ? d10 / 12.92d : Math.pow((d10 + 0.055d) / 1.055d, 2.4d)) * 100.0d;
    }

    public static int alphaFromArgb(int i10) {
        return (i10 >> 24) & 255;
    }

    public static int argbFromLab(double d10, double d11, double d12) {
        double[] dArr = WHITE_POINT_D65;
        double d13 = (d10 + 16.0d) / 116.0d;
        double d14 = d13 - (d12 / 200.0d);
        return argbFromXyz(labInvf((d11 / 500.0d) + d13) * dArr[0], labInvf(d13) * dArr[1], labInvf(d14) * dArr[2]);
    }

    public static int argbFromRgb(int i10, int i11, int i12) {
        return ((i10 & 255) << 16) | ViewCompat.MEASURED_STATE_MASK | ((i11 & 255) << 8) | (i12 & 255);
    }

    public static int argbFromXyz(double d10, double d11, double d12) {
        double[][] dArr = XYZ_TO_SRGB;
        double[] dArr2 = dArr[0];
        double d13 = (dArr2[0] * d10) + (dArr2[1] * d11) + (dArr2[2] * d12);
        double[] dArr3 = dArr[1];
        double d14 = (dArr3[0] * d10) + (dArr3[1] * d11) + (dArr3[2] * d12);
        double[] dArr4 = dArr[2];
        return argbFromRgb(delinearized(d13), delinearized(d14), delinearized((dArr4[0] * d10) + (dArr4[1] * d11) + (dArr4[2] * d12)));
    }

    public static int blueFromArgb(int i10) {
        return i10 & 255;
    }

    public static int delinearized(double d10) {
        double d11 = d10 / 100.0d;
        return MathUtils.clampInt(0, 255, (int) Math.round((d11 <= 0.0031308d ? d11 * 12.92d : (Math.pow(d11, 0.4166666666666667d) * 1.055d) - 0.055d) * 255.0d));
    }

    public static int greenFromArgb(int i10) {
        return (i10 >> 8) & 255;
    }

    static double labInvf(double d10) {
        double d11 = d10 * d10 * d10;
        return d11 > 0.008856451679035631d ? d11 : ((d10 * 116.0d) - 16.0d) / 903.2962962962963d;
    }

    public static double lstarFromY(double d10) {
        return (labF(d10 / 100.0d) * 116.0d) - 16.0d;
    }

    public static int redFromArgb(int i10) {
        return (i10 >> 16) & 255;
    }

    public static double[] whitePointD65() {
        return WHITE_POINT_D65;
    }

    public static double yFromLstar(double d10) {
        return labInvf((d10 + 16.0d) / 116.0d) * 100.0d;
    }

    private ColorUtils() {
    }

    public static int argbFromLstar(double d10) {
        int iDelinearized = delinearized(yFromLstar(d10));
        return argbFromRgb(iDelinearized, iDelinearized, iDelinearized);
    }

    public static boolean isOpaque(int i10) {
        if (alphaFromArgb(i10) >= 255) {
            return true;
        }
        return false;
    }

    public static double[] labFromArgb(int i10) {
        double dLinearized = linearized(redFromArgb(i10));
        double dLinearized2 = linearized(greenFromArgb(i10));
        double dLinearized3 = linearized(blueFromArgb(i10));
        double[][] dArr = SRGB_TO_XYZ;
        double[] dArr2 = dArr[0];
        double d10 = (dArr2[0] * dLinearized) + (dArr2[1] * dLinearized2) + (dArr2[2] * dLinearized3);
        double[] dArr3 = dArr[1];
        double d11 = (dArr3[0] * dLinearized) + (dArr3[1] * dLinearized2) + (dArr3[2] * dLinearized3);
        double[] dArr4 = dArr[2];
        double d12 = (dArr4[0] * dLinearized) + (dArr4[1] * dLinearized2) + (dArr4[2] * dLinearized3);
        double[] dArr5 = WHITE_POINT_D65;
        double d13 = d10 / dArr5[0];
        double d14 = d11 / dArr5[1];
        double d15 = d12 / dArr5[2];
        double dLabF = labF(d13);
        double dLabF2 = labF(d14);
        return new double[]{(116.0d * dLabF2) - 16.0d, (dLabF - dLabF2) * 500.0d, (dLabF2 - labF(d15)) * 200.0d};
    }

    public static double lstarFromArgb(int i10) {
        return (labF(xyzFromArgb(i10)[1] / 100.0d) * 116.0d) - 16.0d;
    }

    public static double[] xyzFromArgb(int i10) {
        return MathUtils.matrixMultiply(new double[]{linearized(redFromArgb(i10)), linearized(greenFromArgb(i10)), linearized(blueFromArgb(i10))}, SRGB_TO_XYZ);
    }

    static double labF(double d10) {
        if (d10 > 0.008856451679035631d) {
            return Math.pow(d10, 0.3333333333333333d);
        }
        return ((d10 * 903.2962962962963d) + 16.0d) / 116.0d;
    }
}
