package z3;

import h3.m;
import y3.r;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class a extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f22651b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int[] f22654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int[] f22655f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f22650a = new int[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float[] f22652c = new float[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f22653d = new float[4];

    protected static void h(int[] iArr, float[] fArr) {
        int i10 = 0;
        float f10 = fArr[0];
        for (int i11 = 1; i11 < iArr.length; i11++) {
            float f11 = fArr[i11];
            if (f11 < f10) {
                i10 = i11;
                f10 = f11;
            }
        }
        iArr[i10] = iArr[i10] - 1;
    }

    protected static void o(int[] iArr, float[] fArr) {
        int i10 = 0;
        float f10 = fArr[0];
        for (int i11 = 1; i11 < iArr.length; i11++) {
            float f11 = fArr[i11];
            if (f11 > f10) {
                i10 = i11;
                f10 = f11;
            }
        }
        iArr[i10] = iArr[i10] + 1;
    }

    protected static boolean p(int[] iArr) {
        int i10 = iArr[0] + iArr[1];
        float f10 = i10 / ((iArr[2] + i10) + iArr[3]);
        if (f10 >= 0.7916667f && f10 <= 0.89285713f) {
            int i11 = Integer.MAX_VALUE;
            int i12 = Integer.MIN_VALUE;
            for (int i13 : iArr) {
                if (i13 > i12) {
                    i12 = i13;
                }
                if (i13 < i11) {
                    i11 = i13;
                }
            }
            if (i12 < i11 * 10) {
                return true;
            }
        }
        return false;
    }

    protected static int q(int[] iArr, int[][] iArr2) throws m {
        for (int i10 = 0; i10 < iArr2.length; i10++) {
            if (r.e(iArr, iArr2[i10], 0.45f) < 0.2f) {
                return i10;
            }
        }
        throw m.a();
    }

    protected final int[] i() {
        return this.f22651b;
    }

    protected final int[] j() {
        return this.f22650a;
    }

    protected final int[] k() {
        return this.f22655f;
    }

    protected final float[] l() {
        return this.f22653d;
    }

    protected final int[] m() {
        return this.f22654e;
    }

    protected final float[] n() {
        return this.f22652c;
    }

    protected a() {
        int[] iArr = new int[8];
        this.f22651b = iArr;
        this.f22654e = new int[iArr.length / 2];
        this.f22655f = new int[iArr.length / 2];
    }
}
