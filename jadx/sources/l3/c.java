package l3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f15184a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private static void b(p3.b bVar, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12 += 2) {
            int i13 = i10 - i12;
            int i14 = i13;
            while (true) {
                int i15 = i10 + i12;
                if (i14 <= i15) {
                    bVar.s(i14, i13);
                    bVar.s(i14, i15);
                    bVar.s(i13, i14);
                    bVar.s(i15, i14);
                    i14++;
                }
            }
        }
        int i16 = i10 - i11;
        bVar.s(i16, i16);
        int i17 = i16 + 1;
        bVar.s(i17, i16);
        bVar.s(i16, i17);
        int i18 = i10 + i11;
        bVar.s(i18, i16);
        bVar.s(i18, i17);
        bVar.s(i18, i18 - 1);
    }

    private static r3.a h(int i10) {
        if (i10 == 4) {
            return r3.a.f17795k;
        }
        if (i10 == 6) {
            return r3.a.f17794j;
        }
        if (i10 == 8) {
            return r3.a.f17798n;
        }
        if (i10 == 10) {
            return r3.a.f17793i;
        }
        if (i10 == 12) {
            return r3.a.f17792h;
        }
        throw new IllegalArgumentException("Unsupported word size " + i10);
    }

    private static int[] a(p3.a aVar, int i10, int i11) {
        int[] iArr = new int[i11];
        int iM = aVar.m() / i10;
        for (int i12 = 0; i12 < iM; i12++) {
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                i13 |= aVar.i((i12 * i10) + i14) ? 1 << ((i10 - i14) - 1) : 0;
            }
            iArr[i12] = i13;
        }
        return iArr;
    }

    private static void c(p3.b bVar, boolean z10, int i10, p3.a aVar) {
        int i11 = i10 / 2;
        int i12 = 0;
        if (z10) {
            while (i12 < 7) {
                int i13 = (i11 - 3) + i12;
                if (aVar.i(i12)) {
                    bVar.s(i13, i11 - 5);
                }
                if (aVar.i(i12 + 7)) {
                    bVar.s(i11 + 5, i13);
                }
                if (aVar.i(20 - i12)) {
                    bVar.s(i13, i11 + 5);
                }
                if (aVar.i(27 - i12)) {
                    bVar.s(i11 - 5, i13);
                }
                i12++;
            }
            return;
        }
        while (i12 < 10) {
            int i14 = (i11 - 5) + i12 + (i12 / 5);
            if (aVar.i(i12)) {
                bVar.s(i14, i11 - 7);
            }
            if (aVar.i(i12 + 10)) {
                bVar.s(i11 + 7, i14);
            }
            if (aVar.i(29 - i12)) {
                bVar.s(i14, i11 + 7);
            }
            if (aVar.i(39 - i12)) {
                bVar.s(i11 - 7, i14);
            }
            i12++;
        }
    }

    public static a d(String str, int i10, int i11, Charset charset) {
        return e(str.getBytes(charset != null ? charset : StandardCharsets.ISO_8859_1), i10, i11, charset);
    }

    public static a e(byte[] bArr, int i10, int i11, Charset charset) {
        p3.a aVarI;
        int i12;
        boolean z10;
        int iAbs;
        int iJ;
        int i13;
        p3.a aVarA = new d(bArr, charset).a();
        int iM = ((aVarA.m() * i10) / 100) + 11;
        int iM2 = aVarA.m() + iM;
        int i14 = 0;
        int i15 = 1;
        if (i11 != 0) {
            z10 = i11 < 0;
            iAbs = Math.abs(i11);
            if (iAbs > (z10 ? 4 : 32)) {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i11)));
            }
            iJ = j(iAbs, z10);
            i12 = f15184a[iAbs];
            int i16 = iJ - (iJ % i12);
            aVarI = i(aVarA, i12);
            if (aVarI.m() + iM > i16) {
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
            if (z10 && aVarI.m() > i12 * 64) {
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
        } else {
            p3.a aVarI2 = null;
            int i17 = 0;
            int i18 = 0;
            while (true) {
                if (i17 > 32) {
                    throw new IllegalArgumentException("Data too large for an Aztec code");
                }
                boolean z11 = i17 <= 3;
                int i19 = z11 ? i17 + 1 : i17;
                int iJ2 = j(i19, z11);
                if (iM2 <= iJ2) {
                    if (aVarI2 == null || i18 != f15184a[i19]) {
                        int i20 = f15184a[i19];
                        i18 = i20;
                        aVarI2 = i(aVarA, i20);
                    }
                    int i21 = iJ2 - (iJ2 % i18);
                    if ((!z11 || aVarI2.m() <= i18 * 64) && aVarI2.m() + iM <= i21) {
                        aVarI = aVarI2;
                        i12 = i18;
                        z10 = z11;
                        iAbs = i19;
                        iJ = iJ2;
                        break;
                    }
                }
                i17++;
                i14 = 0;
                i15 = 1;
            }
        }
        p3.a aVarF = f(aVarI, iJ, i12);
        int iM3 = aVarI.m() / i12;
        p3.a aVarG = g(z10, iAbs, iM3);
        int i22 = (z10 ? 11 : 14) + (iAbs * 4);
        int[] iArr = new int[i22];
        int i23 = 2;
        if (z10) {
            for (int i24 = 0; i24 < i22; i24++) {
                iArr[i24] = i24;
            }
            i13 = i22;
        } else {
            int i25 = i22 / 2;
            i13 = i22 + 1 + (((i25 - 1) / 15) * 2);
            int i26 = i13 / 2;
            for (int i27 = 0; i27 < i25; i27++) {
                int i28 = (i27 / 15) + i27;
                iArr[(i25 - i27) - 1] = (i26 - i28) - 1;
                iArr[i25 + i27] = i28 + i26 + i15;
            }
        }
        p3.b bVar = new p3.b(i13);
        int i29 = 0;
        int i30 = 0;
        while (i29 < iAbs) {
            int i31 = ((iAbs - i29) * 4) + (z10 ? 9 : 12);
            int i32 = 0;
            while (i32 < i31) {
                int i33 = i32 * 2;
                while (i14 < i23) {
                    if (aVarF.i(i30 + i33 + i14)) {
                        int i34 = i29 * 2;
                        bVar.s(iArr[i34 + i14], iArr[i34 + i32]);
                    }
                    if (aVarF.i((i31 * 2) + i30 + i33 + i14)) {
                        int i35 = i29 * 2;
                        bVar.s(iArr[i35 + i32], iArr[((i22 - 1) - i35) - i14]);
                    }
                    if (aVarF.i((i31 * 4) + i30 + i33 + i14)) {
                        int i36 = (i22 - 1) - (i29 * 2);
                        bVar.s(iArr[i36 - i14], iArr[i36 - i32]);
                    }
                    if (aVarF.i((i31 * 6) + i30 + i33 + i14)) {
                        int i37 = i29 * 2;
                        bVar.s(iArr[((i22 - 1) - i37) - i32], iArr[i37 + i14]);
                    }
                    i14++;
                    i23 = 2;
                }
                i32++;
                i14 = 0;
                i23 = 2;
            }
            i30 += i31 * 8;
            i29++;
            i14 = 0;
            i23 = 2;
        }
        c(bVar, z10, i13, aVarG);
        if (z10) {
            b(bVar, i13 / 2, 5);
        } else {
            int i38 = i13 / 2;
            b(bVar, i38, 7);
            int i39 = 0;
            int i40 = 0;
            while (i40 < (i22 / 2) - 1) {
                for (int i41 = i38 & 1; i41 < i13; i41 += 2) {
                    int i42 = i38 - i39;
                    bVar.s(i42, i41);
                    int i43 = i38 + i39;
                    bVar.s(i43, i41);
                    bVar.s(i41, i42);
                    bVar.s(i41, i43);
                }
                i40 += 15;
                i39 += 16;
            }
        }
        a aVar = new a();
        aVar.c(z10);
        aVar.f(i13);
        aVar.d(iAbs);
        aVar.b(iM3);
        aVar.e(bVar);
        return aVar;
    }

    static p3.a g(boolean z10, int i10, int i11) {
        p3.a aVar = new p3.a();
        if (z10) {
            aVar.d(i10 - 1, 2);
            aVar.d(i11 - 1, 6);
            return f(aVar, 28, 4);
        }
        aVar.d(i10 - 1, 5);
        aVar.d(i11 - 1, 11);
        return f(aVar, 40, 4);
    }

    static p3.a i(p3.a aVar, int i10) {
        p3.a aVar2 = new p3.a();
        int iM = aVar.m();
        int i11 = (1 << i10) - 2;
        int i12 = 0;
        while (i12 < iM) {
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                int i15 = i12 + i14;
                if (i15 >= iM || aVar.i(i15)) {
                    i13 |= 1 << ((i10 - 1) - i14);
                }
            }
            int i16 = i13 & i11;
            if (i16 == i11) {
                aVar2.d(i16, i10);
            } else {
                if (i16 == 0) {
                    aVar2.d(i13 | 1, i10);
                } else {
                    aVar2.d(i13, i10);
                }
                i12 += i10;
            }
            i12--;
            i12 += i10;
        }
        return aVar2;
    }

    private static int j(int i10, boolean z10) {
        return ((z10 ? 88 : 112) + (i10 * 16)) * i10;
    }

    private static p3.a f(p3.a aVar, int i10, int i11) {
        int iM = aVar.m() / i11;
        r3.d dVar = new r3.d(h(i11));
        int i12 = i10 / i11;
        int[] iArrA = a(aVar, i11, i12);
        dVar.b(iArrA, i12 - iM);
        p3.a aVar2 = new p3.a();
        aVar2.d(0, i10 % i11);
        for (int i13 : iArrA) {
            aVar2.d(i13, i11);
        }
        return aVar2;
    }
}
