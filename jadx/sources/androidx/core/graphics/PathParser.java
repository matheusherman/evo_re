package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public final class PathParser {
    private static final String LOGTAG = "PathParser";

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class PathDataNode {
        private final float[] mParams;
        private char mType;

        PathDataNode(char c10, float[] fArr) {
            this.mType = c10;
            this.mParams = fArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void addCommand(Path path, float[] fArr, char c10, char c11, float[] fArr2) {
            int i10;
            int i11;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            float f18;
            float f19;
            float f20;
            float f21;
            float f22;
            Path path2 = path;
            float f23 = fArr[0];
            float f24 = fArr[1];
            float f25 = fArr[2];
            float f26 = fArr[3];
            float f27 = fArr[4];
            float f28 = fArr[5];
            switch (c11) {
                case 'A':
                case 'a':
                    i10 = 7;
                    break;
                case 'C':
                case 'c':
                    i10 = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i10 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i10 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i10 = 4;
                    break;
                case 'Z':
                case 'z':
                    path2.close();
                    path2.moveTo(f27, f28);
                    f23 = f27;
                    f25 = f23;
                    f24 = f28;
                    f26 = f24;
                    i10 = 2;
                    break;
            }
            float f29 = f23;
            float f30 = f24;
            float f31 = f27;
            float f32 = f28;
            int i12 = 0;
            char c12 = c10;
            while (i12 < fArr2.length) {
                if (c11 == 'A') {
                    i11 = i12;
                    int i13 = i11 + 5;
                    int i14 = i11 + 6;
                    drawArc(path, f29, f30, fArr2[i13], fArr2[i14], fArr2[i11], fArr2[i11 + 1], fArr2[i11 + 2], fArr2[i11 + 3] != 0.0f, fArr2[i11 + 4] != 0.0f);
                    f25 = fArr2[i13];
                    f29 = f25;
                    f26 = fArr2[i14];
                    f30 = f26;
                } else if (c11 == 'C') {
                    i11 = i12;
                    int i15 = i11 + 2;
                    int i16 = i11 + 3;
                    int i17 = i11 + 4;
                    int i18 = i11 + 5;
                    path2.cubicTo(fArr2[i11], fArr2[i11 + 1], fArr2[i15], fArr2[i16], fArr2[i17], fArr2[i18]);
                    float f33 = fArr2[i17];
                    float f34 = fArr2[i18];
                    float f35 = fArr2[i15];
                    float f36 = fArr2[i16];
                    f29 = f33;
                    f30 = f34;
                    f26 = f36;
                    f25 = f35;
                } else if (c11 != 'H') {
                    if (c11 != 'Q') {
                        if (c11 == 'V') {
                            i11 = i12;
                            path2.lineTo(f29, fArr2[i11]);
                            f12 = fArr2[i11];
                        } else if (c11 != 'a') {
                            if (c11 == 'c') {
                                int i19 = i12 + 2;
                                int i20 = i12 + 3;
                                int i21 = i12 + 4;
                                int i22 = i12 + 5;
                                path2.rCubicTo(fArr2[i12], fArr2[i12 + 1], fArr2[i19], fArr2[i20], fArr2[i21], fArr2[i22]);
                                float f37 = fArr2[i19] + f29;
                                float f38 = fArr2[i20] + f30;
                                f29 += fArr2[i21];
                                f30 += fArr2[i22];
                                f25 = f37;
                                f26 = f38;
                            } else if (c11 != 'h') {
                                if (c11 != 'q') {
                                    if (c11 != 'v') {
                                        if (c11 != 'L') {
                                            if (c11 == 'M') {
                                                f17 = fArr2[i12];
                                                f18 = fArr2[i12 + 1];
                                                if (i12 > 0) {
                                                    path2.lineTo(f17, f18);
                                                } else {
                                                    path2.moveTo(f17, f18);
                                                    f29 = f17;
                                                    f31 = f29;
                                                    f30 = f18;
                                                }
                                            } else if (c11 == 'S') {
                                                if (c12 == 'c' || c12 == 's' || c12 == 'C' || c12 == 'S') {
                                                    f29 = (f29 * 2.0f) - f25;
                                                    f30 = (f30 * 2.0f) - f26;
                                                }
                                                float f39 = f29;
                                                float f40 = f30;
                                                int i23 = i12 + 1;
                                                int i24 = i12 + 2;
                                                int i25 = i12 + 3;
                                                path2.cubicTo(f39, f40, fArr2[i12], fArr2[i23], fArr2[i24], fArr2[i25]);
                                                f10 = fArr2[i12];
                                                f11 = fArr2[i23];
                                                f29 = fArr2[i24];
                                                f30 = fArr2[i25];
                                                i11 = i12;
                                            } else if (c11 == 'T') {
                                                if (c12 == 'q' || c12 == 't' || c12 == 'Q' || c12 == 'T') {
                                                    f29 = (f29 * 2.0f) - f25;
                                                    f30 = (f30 * 2.0f) - f26;
                                                }
                                                int i26 = i12 + 1;
                                                path2.quadTo(f29, f30, fArr2[i12], fArr2[i26]);
                                                float f41 = fArr2[i12];
                                                f12 = fArr2[i26];
                                                f25 = f29;
                                                f26 = f30;
                                                i11 = i12;
                                                f29 = f41;
                                            } else if (c11 == 'l') {
                                                int i27 = i12 + 1;
                                                path2.rLineTo(fArr2[i12], fArr2[i27]);
                                                f29 += fArr2[i12];
                                                f16 = fArr2[i27];
                                            } else if (c11 == 'm') {
                                                float f42 = fArr2[i12];
                                                f29 += f42;
                                                float f43 = fArr2[i12 + 1];
                                                f30 += f43;
                                                if (i12 > 0) {
                                                    path2.rLineTo(f42, f43);
                                                } else {
                                                    path2.rMoveTo(f42, f43);
                                                    f31 = f29;
                                                }
                                            } else if (c11 == 's') {
                                                if (c12 == 'c' || c12 == 's' || c12 == 'C' || c12 == 'S') {
                                                    f19 = f30 - f26;
                                                    f20 = f29 - f25;
                                                } else {
                                                    f20 = 0.0f;
                                                    f19 = 0.0f;
                                                }
                                                int i28 = i12 + 1;
                                                int i29 = i12 + 2;
                                                int i30 = i12 + 3;
                                                path2.rCubicTo(f20, f19, fArr2[i12], fArr2[i28], fArr2[i29], fArr2[i30]);
                                                f13 = fArr2[i12] + f29;
                                                f14 = fArr2[i28] + f30;
                                                f29 += fArr2[i29];
                                                f15 = fArr2[i30];
                                            } else if (c11 == 't') {
                                                if (c12 == 'q' || c12 == 't' || c12 == 'Q' || c12 == 'T') {
                                                    f21 = f29 - f25;
                                                    f22 = f30 - f26;
                                                } else {
                                                    f22 = 0.0f;
                                                    f21 = 0.0f;
                                                }
                                                int i31 = i12 + 1;
                                                path2.rQuadTo(f21, f22, fArr2[i12], fArr2[i31]);
                                                float f44 = f21 + f29;
                                                float f45 = f22 + f30;
                                                f29 += fArr2[i12];
                                                f30 += fArr2[i31];
                                                f26 = f45;
                                                f25 = f44;
                                            }
                                            f32 = f30;
                                        } else {
                                            int i32 = i12 + 1;
                                            path2.lineTo(fArr2[i12], fArr2[i32]);
                                            f17 = fArr2[i12];
                                            f18 = fArr2[i32];
                                        }
                                        f29 = f17;
                                        f30 = f18;
                                    } else {
                                        path2.rLineTo(0.0f, fArr2[i12]);
                                        f16 = fArr2[i12];
                                    }
                                    f30 += f16;
                                } else {
                                    int i33 = i12 + 1;
                                    int i34 = i12 + 2;
                                    int i35 = i12 + 3;
                                    path2.rQuadTo(fArr2[i12], fArr2[i33], fArr2[i34], fArr2[i35]);
                                    f13 = fArr2[i12] + f29;
                                    f14 = fArr2[i33] + f30;
                                    f29 += fArr2[i34];
                                    f15 = fArr2[i35];
                                }
                                f30 += f15;
                                f25 = f13;
                                f26 = f14;
                            } else {
                                path2.rLineTo(fArr2[i12], 0.0f);
                                f29 += fArr2[i12];
                            }
                            i11 = i12;
                        } else {
                            int i36 = i12 + 5;
                            int i37 = i12 + 6;
                            float f46 = f30;
                            i11 = i12;
                            float f47 = f29;
                            drawArc(path, f47, f46, fArr2[i36] + f29, fArr2[i37] + f30, fArr2[i12], fArr2[i12 + 1], fArr2[i12 + 2], fArr2[i12 + 3] != 0.0f, fArr2[i12 + 4] != 0.0f);
                            f29 = f47 + fArr2[i36];
                            f30 = f46 + fArr2[i37];
                            f25 = f29;
                            f26 = f30;
                        }
                        f30 = f12;
                    } else {
                        i11 = i12;
                        int i38 = i11 + 1;
                        int i39 = i11 + 2;
                        int i40 = i11 + 3;
                        path2.quadTo(fArr2[i11], fArr2[i38], fArr2[i39], fArr2[i40]);
                        f10 = fArr2[i11];
                        f11 = fArr2[i38];
                        f29 = fArr2[i39];
                        f30 = fArr2[i40];
                    }
                    f25 = f10;
                    f26 = f11;
                } else {
                    i11 = i12;
                    path2.lineTo(fArr2[i11], f30);
                    f29 = fArr2[i11];
                }
                i12 = i11 + i10;
                path2 = path;
                c12 = c11;
            }
            fArr[0] = f29;
            fArr[1] = f30;
            fArr[2] = f25;
            fArr[3] = f26;
            fArr[4] = f31;
            fArr[5] = f32;
        }

        private static void arcToBezier(Path path, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18) {
            double d19 = d12;
            int iCeil = (int) Math.ceil(Math.abs((d18 * 4.0d) / 3.141592653589793d));
            double dCos = Math.cos(d16);
            double dSin = Math.sin(d16);
            double dCos2 = Math.cos(d17);
            double dSin2 = Math.sin(d17);
            double d20 = -d19;
            double d21 = d20 * dCos;
            double d22 = d13 * dSin;
            double d23 = (d21 * dSin2) - (d22 * dCos2);
            double d24 = d20 * dSin;
            double d25 = d13 * dCos;
            double d26 = (dSin2 * d24) + (dCos2 * d25);
            double d27 = d18 / ((double) iCeil);
            double d28 = d17;
            double d29 = d26;
            double d30 = d23;
            int i10 = 0;
            double d31 = d14;
            double d32 = d15;
            while (i10 < iCeil) {
                double d33 = d28 + d27;
                double dSin3 = Math.sin(d33);
                double dCos3 = Math.cos(d33);
                double d34 = (d10 + ((d19 * dCos) * dCos3)) - (d22 * dSin3);
                int i11 = i10;
                double d35 = d11 + (d12 * dSin * dCos3) + (d25 * dSin3);
                double d36 = (d21 * dSin3) - (d22 * dCos3);
                double d37 = (dSin3 * d24) + (dCos3 * d25);
                double d38 = d33 - d28;
                double dTan = Math.tan(d38 / 2.0d);
                double dSin4 = (Math.sin(d38) * (Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d)) / 3.0d;
                double d39 = d31 + (d30 * dSin4);
                int i12 = iCeil;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d39, (float) (d32 + (d29 * dSin4)), (float) (d34 - (dSin4 * d36)), (float) (d35 - (dSin4 * d37)), (float) d34, (float) d35);
                dSin = dSin;
                d27 = d27;
                d31 = d34;
                d24 = d24;
                d28 = d33;
                d29 = d37;
                dCos = dCos;
                d19 = d12;
                d32 = d35;
                i10 = i11 + 1;
                iCeil = i12;
                d30 = d36;
            }
        }

        private static void drawArc(Path path, float f10, float f11, float f12, float f13, float f14, float f15, float f16, boolean z10, boolean z11) {
            double d10;
            double d11;
            double radians = Math.toRadians(f16);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d12 = f10;
            double d13 = f11;
            double d14 = f14;
            double d15 = ((d12 * dCos) + (d13 * dSin)) / d14;
            double d16 = f15;
            double d17 = ((((double) (-f10)) * dSin) + (d13 * dCos)) / d16;
            double d18 = f13;
            double d19 = ((((double) f12) * dCos) + (d18 * dSin)) / d14;
            double d20 = ((((double) (-f12)) * dSin) + (d18 * dCos)) / d16;
            double d21 = d15 - d19;
            double d22 = d17 - d20;
            double d23 = (d15 + d19) / 2.0d;
            double d24 = (d17 + d20) / 2.0d;
            double d25 = (d21 * d21) + (d22 * d22);
            if (d25 == 0.0d) {
                Log.w(PathParser.LOGTAG, " Points are coincident");
                return;
            }
            double d26 = (1.0d / d25) - 0.25d;
            if (d26 < 0.0d) {
                Log.w(PathParser.LOGTAG, "Points are too far apart " + d25);
                float fSqrt = (float) (Math.sqrt(d25) / 1.99999d);
                drawArc(path, f10, f11, f12, f13, f14 * fSqrt, fSqrt * f15, f16, z10, z11);
                return;
            }
            double dSqrt = Math.sqrt(d26);
            double d27 = d21 * dSqrt;
            double d28 = dSqrt * d22;
            if (z10 == z11) {
                d10 = d23 - d28;
                d11 = d24 + d27;
            } else {
                d10 = d23 + d28;
                d11 = d24 - d27;
            }
            double dAtan2 = Math.atan2(d17 - d11, d15 - d10);
            double dAtan3 = Math.atan2(d20 - d11, d19 - d10) - dAtan2;
            if (z11 != (dAtan3 >= 0.0d)) {
                dAtan3 = dAtan3 > 0.0d ? dAtan3 - 6.283185307179586d : dAtan3 + 6.283185307179586d;
            }
            double d29 = d10 * d14;
            double d30 = d11 * d16;
            arcToBezier(path, (d29 * dCos) - (d30 * dSin), (d29 * dSin) + (d30 * dCos), d14, d16, d12, d13, radians, dAtan2, dAtan3);
        }

        @NonNull
        public float[] getParams() {
            return this.mParams;
        }

        public char getType() {
            return this.mType;
        }

        public void interpolatePathDataNode(@NonNull PathDataNode pathDataNode, @NonNull PathDataNode pathDataNode2, float f10) {
            this.mType = pathDataNode.mType;
            int i10 = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i10 >= fArr.length) {
                    return;
                }
                this.mParams[i10] = (fArr[i10] * (1.0f - f10)) + (pathDataNode2.mParams[i10] * f10);
                i10++;
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public static void nodesToPath(@NonNull PathDataNode[] pathDataNodeArr, @NonNull Path path) {
            PathParser.nodesToPath(pathDataNodeArr, path);
        }

        PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
        }
    }

    public static boolean canMorph(@Nullable PathDataNode[] pathDataNodeArr, @Nullable PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < pathDataNodeArr.length; i10++) {
            if (pathDataNodeArr[i10].mType != pathDataNodeArr2[i10].mType || pathDataNodeArr[i10].mParams.length != pathDataNodeArr2[i10].mParams.length) {
                return false;
            }
        }
        return true;
    }

    @NonNull
    public static PathDataNode[] deepCopyNodes(@NonNull PathDataNode[] pathDataNodeArr) {
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i10 = 0; i10 < pathDataNodeArr.length; i10++) {
            pathDataNodeArr2[i10] = new PathDataNode(pathDataNodeArr[i10]);
        }
        return pathDataNodeArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:16:0x0029  */
    /* JADX WARN: Code duplicated, block: B:20:0x0033  */
    private static void extract(String str, int i10, ExtractFloatResult extractFloatResult) {
        extractFloatResult.mEndWithNegOrDot = false;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        for (int i11 = i10; i11 < str.length(); i11++) {
            char cCharAt = str.charAt(i11);
            if (cCharAt == ' ') {
                z10 = false;
                z12 = true;
            } else if (cCharAt != 'E' && cCharAt != 'e') {
                switch (cCharAt) {
                    case ',':
                        z10 = false;
                        z12 = true;
                        break;
                    case '-':
                        if (i11 == i10 || z10) {
                            z10 = false;
                        } else {
                            extractFloatResult.mEndWithNegOrDot = true;
                            z10 = false;
                            z12 = true;
                        }
                        break;
                    case '.':
                        if (z11) {
                            extractFloatResult.mEndWithNegOrDot = true;
                            z10 = false;
                            z12 = true;
                        } else {
                            z10 = false;
                            z11 = true;
                        }
                        break;
                    default:
                        z10 = false;
                        break;
                }
            } else {
                z10 = true;
            }
            if (z12) {
                extractFloatResult.mEndPosition = i11;
            }
        }
        extractFloatResult.mEndPosition = i11;
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i10 = 1;
            int i11 = 0;
            while (i10 < length) {
                extract(str, i10, extractFloatResult);
                int i12 = extractFloatResult.mEndPosition;
                if (i10 < i12) {
                    fArr[i11] = Float.parseFloat(str.substring(i10, i12));
                    i11++;
                }
                i10 = extractFloatResult.mEndWithNegOrDot ? i12 : i12 + 1;
            }
            return copyOfRange(fArr, 0, i11);
        } catch (NumberFormatException e10) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e10);
        }
    }

    public static void interpolatePathDataNodes(@NonNull PathDataNode[] pathDataNodeArr, float f10, @NonNull PathDataNode[] pathDataNodeArr2, @NonNull PathDataNode[] pathDataNodeArr3) {
        if (!interpolatePathDataNodes(pathDataNodeArr, pathDataNodeArr2, pathDataNodeArr3, f10)) {
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    public static void nodesToPath(@NonNull PathDataNode[] pathDataNodeArr, @NonNull Path path) {
        float[] fArr = new float[6];
        char c10 = 'm';
        for (PathDataNode pathDataNode : pathDataNodeArr) {
            PathDataNode.addCommand(path, fArr, c10, pathDataNode.mType, pathDataNode.mParams);
            c10 = pathDataNode.mType;
        }
    }

    public static void updateNodes(@NonNull PathDataNode[] pathDataNodeArr, @NonNull PathDataNode[] pathDataNodeArr2) {
        for (int i10 = 0; i10 < pathDataNodeArr2.length; i10++) {
            pathDataNodeArr[i10].mType = pathDataNodeArr2[i10].mType;
            for (int i11 = 0; i11 < pathDataNodeArr2[i10].mParams.length; i11++) {
                pathDataNodeArr[i10].mParams[i11] = pathDataNodeArr2[i10].mParams[i11];
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;

        ExtractFloatResult() {
        }
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c10, float[] fArr) {
        arrayList.add(new PathDataNode(c10, fArr));
    }

    static float[] copyOfRange(float[] fArr, int i10, int i11) {
        if (i10 > i11) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i10 < 0 || i10 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i12 = i11 - i10;
        int iMin = Math.min(i12, length - i10);
        float[] fArr2 = new float[i12];
        System.arraycopy(fArr, i10, fArr2, 0, iMin);
        return fArr2;
    }

    @NonNull
    public static PathDataNode[] createNodesFromPathData(@NonNull String str) {
        ArrayList arrayList = new ArrayList();
        int i10 = 1;
        int i11 = 0;
        while (i10 < str.length()) {
            int iNextStart = nextStart(str, i10);
            String strTrim = str.substring(i11, iNextStart).trim();
            if (!strTrim.isEmpty()) {
                addNode(arrayList, strTrim.charAt(0), getFloats(strTrim));
            }
            i11 = iNextStart;
            i10 = iNextStart + 1;
        }
        if (i10 - i11 == 1 && i11 < str.length()) {
            addNode(arrayList, str.charAt(i11), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[0]);
    }

    @NonNull
    public static Path createPathFromPathData(@NonNull String str) {
        Path path = new Path();
        try {
            PathDataNode.nodesToPath(createNodesFromPathData(str), path);
            return path;
        } catch (RuntimeException e10) {
            throw new RuntimeException("Error in parsing " + str, e10);
        }
    }

    private PathParser() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static boolean interpolatePathDataNodes(@NonNull PathDataNode[] pathDataNodeArr, @NonNull PathDataNode[] pathDataNodeArr2, @NonNull PathDataNode[] pathDataNodeArr3, float f10) {
        if (pathDataNodeArr.length == pathDataNodeArr2.length && pathDataNodeArr2.length == pathDataNodeArr3.length) {
            if (!canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
                return false;
            }
            for (int i10 = 0; i10 < pathDataNodeArr.length; i10++) {
                pathDataNodeArr[i10].interpolatePathDataNode(pathDataNodeArr2[i10], pathDataNodeArr3[i10], f10);
            }
            return true;
        }
        throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
    }

    private static int nextStart(String str, int i10) {
        while (i10 < str.length()) {
            char cCharAt = str.charAt(i10);
            if (((cCharAt - 'A') * (cCharAt - 'Z') <= 0 || (cCharAt - 'a') * (cCharAt - 'z') <= 0) && cCharAt != 'e' && cCharAt != 'E') {
                break;
            }
            i10++;
        }
        return i10;
    }
}
