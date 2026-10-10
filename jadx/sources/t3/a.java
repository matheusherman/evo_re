package t3;

import h3.h;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p3.b f18867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p3.b f18868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f18869c;

    private p3.b a(p3.b bVar) {
        int iF = this.f18869c.f();
        int iE = this.f18869c.e();
        if (bVar.k() != iF) {
            throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
        }
        int iC = this.f18869c.c();
        int iB = this.f18869c.b();
        int i10 = iF / iC;
        int i11 = iE / iB;
        p3.b bVar2 = new p3.b(i11 * iB, i10 * iC);
        for (int i12 = 0; i12 < i10; i12++) {
            int i13 = i12 * iC;
            for (int i14 = 0; i14 < i11; i14++) {
                int i15 = i14 * iB;
                for (int i16 = 0; i16 < iC; i16++) {
                    int i17 = ((iC + 2) * i12) + 1 + i16;
                    int i18 = i13 + i16;
                    for (int i19 = 0; i19 < iB; i19++) {
                        if (bVar.h(((iB + 2) * i14) + 1 + i19, i17)) {
                            bVar2.s(i15 + i19, i18);
                        }
                    }
                }
            }
        }
        return bVar2;
    }

    private int d(int i10, int i11) {
        int i12 = i10 - 1;
        int i13 = (h(i12, 0, i10, i11) ? 1 : 0) << 1;
        if (h(i12, 1, i10, i11)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (h(i12, 2, i10, i11)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (h(0, i11 - 2, i10, i11)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        int i17 = i11 - 1;
        if (h(0, i17, i10, i11)) {
            i16 |= 1;
        }
        int i18 = i16 << 1;
        if (h(1, i17, i10, i11)) {
            i18 |= 1;
        }
        int i19 = i18 << 1;
        if (h(2, i17, i10, i11)) {
            i19 |= 1;
        }
        int i20 = i19 << 1;
        return h(3, i17, i10, i11) ? i20 | 1 : i20;
    }

    private int e(int i10, int i11) {
        int i12 = (h(i10 + (-3), 0, i10, i11) ? 1 : 0) << 1;
        if (h(i10 - 2, 0, i10, i11)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (h(i10 - 1, 0, i10, i11)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (h(0, i11 - 4, i10, i11)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (h(0, i11 - 3, i10, i11)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        if (h(0, i11 - 2, i10, i11)) {
            i16 |= 1;
        }
        int i17 = i16 << 1;
        int i18 = i11 - 1;
        if (h(0, i18, i10, i11)) {
            i17 |= 1;
        }
        int i19 = i17 << 1;
        return h(1, i18, i10, i11) ? i19 | 1 : i19;
    }

    private int f(int i10, int i11) {
        int i12 = i10 - 1;
        int i13 = (h(i12, 0, i10, i11) ? 1 : 0) << 1;
        int i14 = i11 - 1;
        if (h(i12, i14, i10, i11)) {
            i13 |= 1;
        }
        int i15 = i13 << 1;
        int i16 = i11 - 3;
        if (h(0, i16, i10, i11)) {
            i15 |= 1;
        }
        int i17 = i15 << 1;
        int i18 = i11 - 2;
        if (h(0, i18, i10, i11)) {
            i17 |= 1;
        }
        int i19 = i17 << 1;
        if (h(0, i14, i10, i11)) {
            i19 |= 1;
        }
        int i20 = i19 << 1;
        if (h(1, i16, i10, i11)) {
            i20 |= 1;
        }
        int i21 = i20 << 1;
        if (h(1, i18, i10, i11)) {
            i21 |= 1;
        }
        int i22 = i21 << 1;
        return h(1, i14, i10, i11) ? i22 | 1 : i22;
    }

    private int g(int i10, int i11) {
        int i12 = (h(i10 + (-3), 0, i10, i11) ? 1 : 0) << 1;
        if (h(i10 - 2, 0, i10, i11)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (h(i10 - 1, 0, i10, i11)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (h(0, i11 - 2, i10, i11)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        int i16 = i11 - 1;
        if (h(0, i16, i10, i11)) {
            i15 |= 1;
        }
        int i17 = i15 << 1;
        if (h(1, i16, i10, i11)) {
            i17 |= 1;
        }
        int i18 = i17 << 1;
        if (h(2, i16, i10, i11)) {
            i18 |= 1;
        }
        int i19 = i18 << 1;
        return h(3, i16, i10, i11) ? i19 | 1 : i19;
    }

    private boolean h(int i10, int i11, int i12, int i13) {
        if (i10 < 0) {
            i10 += i12;
            i11 += 4 - ((i12 + 4) & 7);
        }
        if (i11 < 0) {
            i11 += i13;
            i10 += 4 - ((i13 + 4) & 7);
        }
        if (i10 >= i12) {
            i10 -= i12;
        }
        this.f18868b.s(i11, i10);
        return this.f18867a.h(i11, i10);
    }

    private int i(int i10, int i11, int i12, int i13) {
        int i14 = i10 - 2;
        int i15 = i11 - 2;
        int i16 = (h(i14, i15, i12, i13) ? 1 : 0) << 1;
        int i17 = i11 - 1;
        if (h(i14, i17, i12, i13)) {
            i16 |= 1;
        }
        int i18 = i16 << 1;
        int i19 = i10 - 1;
        if (h(i19, i15, i12, i13)) {
            i18 |= 1;
        }
        int i20 = i18 << 1;
        if (h(i19, i17, i12, i13)) {
            i20 |= 1;
        }
        int i21 = i20 << 1;
        if (h(i19, i11, i12, i13)) {
            i21 |= 1;
        }
        int i22 = i21 << 1;
        if (h(i10, i15, i12, i13)) {
            i22 |= 1;
        }
        int i23 = i22 << 1;
        if (h(i10, i17, i12, i13)) {
            i23 |= 1;
        }
        int i24 = i23 << 1;
        return h(i10, i11, i12, i13) ? i24 | 1 : i24;
    }

    e b() {
        return this.f18869c;
    }

    byte[] c() throws h {
        byte[] bArr = new byte[this.f18869c.g()];
        int iK = this.f18867a.k();
        int iN = this.f18867a.n();
        int i10 = 0;
        boolean z10 = false;
        int i11 = 0;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        int i12 = 4;
        while (true) {
            if (i12 == iK && i10 == 0 && !z10) {
                bArr[i11] = (byte) d(iK, iN);
                i12 -= 2;
                i10 += 2;
                i11++;
                z10 = true;
            } else {
                int i13 = iK - 2;
                if (i12 == i13 && i10 == 0 && (iN & 3) != 0 && !z11) {
                    bArr[i11] = (byte) e(iK, iN);
                    i12 -= 2;
                    i10 += 2;
                    i11++;
                    z11 = true;
                } else if (i12 == iK + 4 && i10 == 2 && (iN & 7) == 0 && !z12) {
                    bArr[i11] = (byte) f(iK, iN);
                    i12 -= 2;
                    i10 += 2;
                    i11++;
                    z12 = true;
                } else if (i12 == i13 && i10 == 0 && (iN & 7) == 4 && !z13) {
                    bArr[i11] = (byte) g(iK, iN);
                    i12 -= 2;
                    i10 += 2;
                    i11++;
                    z13 = true;
                } else {
                    while (true) {
                        if (i12 < iK && i10 >= 0 && !this.f18868b.h(i10, i12)) {
                            bArr[i11] = (byte) i(i12, i10, iK, iN);
                            i11++;
                        }
                        int i14 = i12 - 2;
                        int i15 = i10 + 2;
                        if (i14 < 0 || i15 >= iN) {
                            break;
                        }
                        i12 = i14;
                        i10 = i15;
                    }
                    int i16 = i12 - 1;
                    int i17 = i10 + 5;
                    while (true) {
                        if (i16 >= 0 && i17 < iN && !this.f18868b.h(i17, i16)) {
                            bArr[i11] = (byte) i(i16, i17, iK, iN);
                            i11++;
                        }
                        int i18 = i16 + 2;
                        int i19 = i17 - 2;
                        if (i18 >= iK || i19 < 0) {
                            break;
                        }
                        i16 = i18;
                        i17 = i19;
                    }
                    i12 = i16 + 5;
                    i10 = i17 - 1;
                }
            }
            if (i12 >= iK && i10 >= iN) {
                break;
            }
        }
        if (i11 == this.f18869c.g()) {
            return bArr;
        }
        throw h.a();
    }

    a(p3.b bVar) throws h {
        int iK = bVar.k();
        if (iK >= 8 && iK <= 144 && (iK & 1) == 0) {
            this.f18869c = j(bVar);
            p3.b bVarA = a(bVar);
            this.f18867a = bVarA;
            this.f18868b = new p3.b(bVarA.n(), bVarA.k());
            return;
        }
        throw h.a();
    }

    private static e j(p3.b bVar) {
        return e.h(bVar.k(), bVar.n());
    }
}
