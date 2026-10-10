package p3;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static l f17307a = new f();

    public abstract b c(b bVar, int i10, int i11, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25);

    public abstract b d(b bVar, int i10, int i11, o oVar);

    public static l b() {
        return f17307a;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0035  */
    /* JADX WARN: Code duplicated, block: B:20:0x0039 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x003b  */
    /* JADX WARN: Code duplicated, block: B:40:0x0072  */
    /* JADX WARN: Code duplicated, block: B:42:0x0076 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x0078  */
    /* JADX WARN: Code duplicated, block: B:55:0x0041 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x007e A[SYNTHETIC] */
    protected static void a(b bVar, float[] fArr) {
        int iN = bVar.n();
        int iK = bVar.k();
        int length = fArr.length - 1;
        boolean z10 = true;
        for (int i10 = 0; i10 < length && z10; i10 += 2) {
            int i11 = (int) fArr[i10];
            int i12 = i10 + 1;
            int i13 = (int) fArr[i12];
            if (i11 >= -1 && i11 <= iN && i13 >= -1 && i13 <= iK) {
                if (i11 == -1) {
                    fArr[i10] = 0.0f;
                } else {
                    if (i11 == iN) {
                        fArr[i10] = iN - 1;
                    } else {
                        z10 = false;
                    }
                    if (i13 == -1) {
                        fArr[i12] = 0.0f;
                    } else {
                        if (i13 == iK) {
                            fArr[i12] = iK - 1;
                        }
                    }
                    z10 = true;
                }
                z10 = true;
                if (i13 == -1) {
                    fArr[i12] = 0.0f;
                } else {
                    if (i13 == iK) {
                        fArr[i12] = iK - 1;
                    }
                }
                z10 = true;
            } else {
                throw h3.m.a();
            }
        }
        boolean z11 = true;
        for (int length2 = fArr.length - 2; length2 >= 0 && z11; length2 -= 2) {
            int i14 = (int) fArr[length2];
            int i15 = length2 + 1;
            int i16 = (int) fArr[i15];
            if (i14 >= -1 && i14 <= iN && i16 >= -1 && i16 <= iK) {
                if (i14 == -1) {
                    fArr[length2] = 0.0f;
                } else {
                    if (i14 == iN) {
                        fArr[length2] = iN - 1;
                    } else {
                        z11 = false;
                    }
                    if (i16 == -1) {
                        fArr[i15] = 0.0f;
                    } else {
                        if (i16 == iK) {
                            fArr[i15] = iK - 1;
                        }
                    }
                    z11 = true;
                }
                z11 = true;
                if (i16 == -1) {
                    fArr[i15] = 0.0f;
                } else {
                    if (i16 == iK) {
                        fArr[i15] = iK - 1;
                    }
                }
                z11 = true;
            } else {
                throw h3.m.a();
            }
        }
    }
}
