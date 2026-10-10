package f1;

import android.opengl.Matrix;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f9942a = new float[16];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f9943b = new float[16];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d1.i<float[]> f9944c = new d1.i<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f9945d;

    public static void a(float[] fArr, float[] fArr2) {
        Matrix.setIdentityM(fArr, 0);
        float f10 = fArr2[10];
        float f11 = fArr2[8];
        float fSqrt = (float) Math.sqrt((f10 * f10) + (f11 * f11));
        float f12 = fArr2[10];
        fArr[0] = f12 / fSqrt;
        float f13 = fArr2[8];
        fArr[2] = f13 / fSqrt;
        fArr[8] = (-f13) / fSqrt;
        fArr[10] = f12 / fSqrt;
    }

    private static void b(float[] fArr, float[] fArr2) {
        float f10 = fArr2[0];
        float f11 = -fArr2[1];
        float f12 = -fArr2[2];
        float length = Matrix.length(f10, f11, f12);
        if (length != 0.0f) {
            Matrix.setRotateM(fArr, 0, (float) Math.toDegrees(length), f10 / length, f11 / length, f12 / length);
        } else {
            Matrix.setIdentityM(fArr, 0);
        }
    }

    public boolean c(float[] fArr, long j10) {
        float[] fArrD = this.f9944c.d(j10);
        if (fArrD == null) {
            return false;
        }
        b(this.f9943b, fArrD);
        if (!this.f9945d) {
            a(this.f9942a, this.f9943b);
            this.f9945d = true;
        }
        Matrix.multiplyMM(fArr, 0, this.f9942a, 0, this.f9943b, 0);
        return true;
    }
}
