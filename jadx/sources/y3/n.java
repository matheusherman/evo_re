package y3;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class n extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f22366b = {6, 8, 10, 12, 14};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f22367c = {1, 1, 1, 1};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[][] f22368d = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[][] f22369e = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f22370a = -1;

    private static int[] l(p3.a aVar, int i10, int[] iArr) throws h3.m {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int iM = aVar.m();
        int i11 = i10;
        boolean z10 = false;
        int i12 = 0;
        while (i10 < iM) {
            if (aVar.i(i10) != z10) {
                iArr2[i12] = iArr2[i12] + 1;
            } else {
                if (i12 != length - 1) {
                    i12++;
                } else {
                    if (r.e(iArr2, iArr, 0.5f) < 0.38f) {
                        return new int[]{i11, i10};
                    }
                    i11 += iArr2[0] + iArr2[1];
                    int i13 = i12 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i13);
                    iArr2[i13] = 0;
                    iArr2[i12] = 0;
                    i12--;
                }
                iArr2[i12] = 1;
                z10 = !z10;
            }
            i10++;
        }
        throw h3.m.a();
    }

    private static int h(int[] iArr) throws h3.m {
        int length = f22369e.length;
        float f10 = 0.38f;
        int i10 = 0;
        int i11 = -1;
        while (i10 < length) {
            float fE = r.e(iArr, f22369e[i10], i10 <= 9 ? 0.5f : 0.75f);
            if (fE < f10) {
                i11 = i10;
                f10 = fE;
            } else if (fE == f10) {
                i11 = -1;
            }
            i10++;
        }
        if (i11 >= 0) {
            return i11 % 10;
        }
        throw h3.m.a();
    }

    private static void j(p3.a aVar, int i10, int i11, StringBuilder sb2) throws h3.m {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i10 < i11) {
            r.f(aVar, i10, iArr);
            for (int i12 = 0; i12 < 5; i12++) {
                int i13 = i12 * 2;
                iArr2[i12] = iArr[i13];
                iArr3[i12] = iArr[i13 + 1];
            }
            sb2.append((char) (h(iArr2) + 48));
            sb2.append((char) (h(iArr3) + 48));
            for (int i14 = 0; i14 < 10; i14++) {
                i10 += iArr[i14];
            }
        }
    }

    private void n(p3.a aVar, int i10) throws h3.m {
        int iMin = Math.min(this.f22370a * 10, i10);
        for (int i11 = i10 - 1; iMin > 0 && i11 >= 0 && !aVar.i(i11); i11--) {
            iMin--;
        }
        if (iMin != 0) {
            throw h3.m.a();
        }
    }

    private int[] i(p3.a aVar) {
        int[] iArrL;
        aVar.q();
        try {
            int iM = m(aVar);
            try {
                iArrL = l(aVar, iM, f22368d[0]);
            } catch (h3.m unused) {
                iArrL = l(aVar, iM, f22368d[1]);
            }
            n(aVar, iArrL[0]);
            int i10 = iArrL[0];
            iArrL[0] = aVar.m() - iArrL[1];
            iArrL[1] = aVar.m() - i10;
            aVar.q();
            return iArrL;
        } catch (Throwable th) {
            aVar.q();
            throw th;
        }
    }

    private int[] k(p3.a aVar) throws h3.m {
        int[] iArrL = l(aVar, m(aVar), f22367c);
        int i10 = iArrL[1];
        int i11 = iArrL[0];
        this.f22370a = (i10 - i11) / 4;
        n(aVar, i11);
        return iArrL;
    }

    private static int m(p3.a aVar) throws h3.m {
        int iM = aVar.m();
        int iK = aVar.k(0);
        if (iK != iM) {
            return iK;
        }
        throw h3.m.a();
    }

    @Override // y3.r
    public h3.q c(int i10, p3.a aVar, Map<h3.e, ?> map) throws h3.h, h3.m {
        int[] iArr;
        boolean z10;
        int[] iArrK = k(aVar);
        int[] iArrI = i(aVar);
        StringBuilder sb2 = new StringBuilder(20);
        j(aVar, iArrK[1], iArrI[0], sb2);
        String string = sb2.toString();
        if (map != null) {
            iArr = (int[]) map.get(h3.e.ALLOWED_LENGTHS);
        } else {
            iArr = null;
        }
        if (iArr == null) {
            iArr = f22366b;
        }
        int length = string.length();
        int length2 = iArr.length;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i11 < length2) {
                int i13 = iArr[i11];
                if (length == i13) {
                    z10 = true;
                    break;
                }
                if (i13 > i12) {
                    i12 = i13;
                }
                i11++;
            } else {
                z10 = false;
                break;
            }
        }
        if (!z10 && length > i12) {
            z10 = true;
        }
        if (z10) {
            float f10 = i10;
            h3.q qVar = new h3.q(string, null, new h3.s[]{new h3.s(iArrK[1], f10), new h3.s(iArrI[0], f10)}, h3.a.ITF);
            qVar.h(h3.r.SYMBOLOGY_IDENTIFIER, "]I0");
            return qVar;
        }
        throw h3.h.a();
    }
}
