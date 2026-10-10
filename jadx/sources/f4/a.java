package f4;

import h3.c;
import h3.e;
import h3.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f10019a = {0, 4, 1, 5};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f10020b = {6, 2, 7, 3};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f10021c = {8, 1, 1, 1, 1, 1, 1, 3};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f10022d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f10023e = {0, 180, 270, 90};

    private static void b(s[] sVarArr, s[] sVarArr2, int[] iArr) {
        for (int i10 = 0; i10 < iArr.length; i10++) {
            sVarArr[iArr[i10]] = sVarArr2[i10];
        }
    }

    private static int[] e(p3.b bVar, int i10, int i11, int i12, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i13 = 0;
        while (bVar.h(i10, i11) && i10 > 0) {
            int i14 = i13 + 1;
            if (i13 >= 3) {
                break;
            }
            i10--;
            i13 = i14;
        }
        int length = iArr.length;
        int i15 = i10;
        int i16 = 0;
        boolean z10 = false;
        while (i10 < i12) {
            if (bVar.h(i10, i11) != z10) {
                iArr2[i16] = iArr2[i16] + 1;
            } else {
                if (i16 != length - 1) {
                    i16++;
                } else {
                    if (h(iArr2, iArr) < 0.42f) {
                        return new int[]{i15, i10};
                    }
                    i15 += iArr2[0] + iArr2[1];
                    int i17 = i16 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i17);
                    iArr2[i17] = 0;
                    iArr2[i16] = 0;
                    i16--;
                }
                iArr2[i16] = 1;
                z10 = !z10;
            }
            i10++;
        }
        if (i16 != length - 1 || h(iArr2, iArr) >= 0.42f) {
            return null;
        }
        return new int[]{i15, i10 - 1};
    }

    private static s[] f(p3.b bVar, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        int i15;
        boolean z10;
        int[] iArrE;
        s[] sVarArr = new s[4];
        int[] iArr2 = iArr;
        int[] iArr3 = new int[iArr2.length];
        int i16 = i12;
        while (true) {
            if (i16 >= i10) {
                i15 = i16;
                z10 = false;
                break;
            }
            int[] iArrE2 = e(bVar, i13, i16, i11, iArr2, iArr3);
            if (iArrE2 != null) {
                int[] iArr4 = iArrE2;
                while (true) {
                    i15 = i16;
                    if (i15 <= 0 || (iArrE = e(bVar, i13, (i16 = i15 - 1), i11, iArr, iArr3)) == null) {
                        break;
                    }
                    iArr4 = iArrE;
                }
                float f10 = i15;
                sVarArr[0] = new s(iArr4[0], f10);
                sVarArr[1] = new s(iArr4[1], f10);
                z10 = true;
                break;
            }
            i16 += 5;
            iArr2 = iArr;
        }
        int i17 = i15 + 1;
        if (z10) {
            int[] iArr5 = {(int) sVarArr[0].c(), (int) sVarArr[1].c()};
            int i18 = i17;
            int i19 = 0;
            while (i18 < i10) {
                int[] iArrE3 = e(bVar, iArr5[0], i18, i11, iArr, iArr3);
                if (iArrE3 != null && Math.abs(iArr5[0] - iArrE3[0]) < 5 && Math.abs(iArr5[1] - iArrE3[1]) < 5) {
                    iArr5 = iArrE3;
                    i19 = 0;
                } else {
                    if (i19 > 25) {
                        break;
                    }
                    i19++;
                }
                i18++;
            }
            i17 = i18 - (i19 + 1);
            float f11 = i17;
            sVarArr[2] = new s(iArr5[0], f11);
            sVarArr[3] = new s(iArr5[1], f11);
        }
        if (i17 - i15 < i14) {
            Arrays.fill(sVarArr, (Object) null);
        }
        return sVarArr;
    }

    private static float h(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            i10 += iArr[i12];
            i11 += iArr2[i12];
        }
        if (i10 < i11) {
            return Float.POSITIVE_INFINITY;
        }
        float f10 = i10;
        float f11 = f10 / i11;
        float f12 = 0.8f * f11;
        float f13 = 0.0f;
        for (int i13 = 0; i13 < length; i13++) {
            int i14 = iArr[i13];
            float f14 = iArr2[i13] * f11;
            float f15 = i14;
            float f16 = f15 > f14 ? f15 - f14 : f14 - f15;
            if (f16 > f12) {
                return Float.POSITIVE_INFINITY;
            }
            f13 += f16;
        }
        return f13 / f10;
    }

    private static p3.b a(p3.b bVar, int i10) {
        if (i10 % 360 == 0) {
            return bVar;
        }
        p3.b bVarClone = bVar.clone();
        bVarClone.o(i10);
        return bVarClone;
    }

    private static List<s[]> d(boolean z10, p3.b bVar) {
        int iC;
        float fD;
        ArrayList<s[]> arrayList = new ArrayList();
        int iMax = 0;
        loop0: while (true) {
            int i10 = 0;
            boolean z11 = false;
            while (iMax < bVar.k()) {
                s[] sVarArrG = g(bVar, iMax, i10);
                if (sVarArrG[0] == null && sVarArrG[3] == null) {
                    if (!z11) {
                        break;
                    }
                    for (s[] sVarArr : arrayList) {
                        s sVar = sVarArr[1];
                        if (sVar != null) {
                            iMax = (int) Math.max(iMax, sVar.d());
                        }
                        s sVar2 = sVarArr[3];
                        if (sVar2 != null) {
                            iMax = Math.max(iMax, (int) sVar2.d());
                        }
                    }
                    iMax += 5;
                } else {
                    arrayList.add(sVarArrG);
                    if (!z10) {
                        break loop0;
                    }
                    s sVar3 = sVarArrG[2];
                    if (sVar3 != null) {
                        iC = (int) sVar3.c();
                        fD = sVarArrG[2].d();
                    } else {
                        iC = (int) sVarArrG[4].c();
                        fD = sVarArrG[4].d();
                    }
                    iMax = (int) fD;
                    i10 = iC;
                    z11 = true;
                }
            }
            break loop0;
        }
        return arrayList;
    }

    public static b c(c cVar, Map<e, ?> map, boolean z10) {
        p3.b bVarA = cVar.a();
        for (int i10 : f10023e) {
            p3.b bVarA2 = a(bVarA, i10);
            List<s[]> listD = d(z10, bVarA2);
            if (!listD.isEmpty()) {
                return new b(bVarA2, listD, i10);
            }
        }
        return new b(bVarA, new ArrayList(), 0);
    }

    private static s[] g(p3.b bVar, int i10, int i11) {
        int iK = bVar.k();
        int iN = bVar.n();
        s[] sVarArr = new s[8];
        int iMax = 10;
        int i12 = i10;
        int i13 = i11;
        b(sVarArr, f(bVar, iK, iN, i12, i13, 10, f10021c), f10019a);
        s sVar = sVarArr[4];
        if (sVar != null) {
            int iC = (int) sVar.c();
            int iD = (int) sVarArr[4].d();
            s sVar2 = sVarArr[5];
            if (sVar2 != null) {
                iMax = (int) Math.max((((int) sVar2.d()) - iD) * 0.5f, 10.0f);
            }
            i12 = iD;
            i13 = iC;
        }
        b(sVarArr, f(bVar, iK, iN, i12, i13, iMax, f10022d), f10020b);
        return sVarArr;
    }
}
