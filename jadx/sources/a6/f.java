package a6;

import com.taobao.sophix.PatchStatus;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[][] f135a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[][] f136b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[][] f137c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, PatchStatus.CODE_LOAD_LIB_LOST, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, PatchStatus.CODE_LOAD_LIB_CPUABIS, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[][] f138d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    static int a(int i10) {
        int i11 = 0;
        while (i10 != 0) {
            i10 >>>= 1;
            i11++;
        }
        return i11;
    }

    private static void c(int i10, int i11, b bVar) throws v5.c {
        for (int i12 = 0; i12 < 8; i12++) {
            int i13 = i10 + i12;
            if (!n(bVar.b(i13, i11))) {
                throw new v5.c();
            }
            bVar.f(i13, i11, 0);
        }
    }

    static void j(b bVar) {
        bVar.a((byte) -1);
    }

    private static void k(int i10, int i11, b bVar) throws v5.c {
        for (int i12 = 0; i12 < 7; i12++) {
            int i13 = i11 + i12;
            if (!n(bVar.b(i10, i13))) {
                throw new v5.c();
            }
            bVar.f(i10, i13, 0);
        }
    }

    private static boolean n(int i10) {
        return i10 == -1;
    }

    private static void o(int i10, int i11, b bVar) {
        for (int i12 = 0; i12 < 5; i12++) {
            for (int i13 = 0; i13 < 5; i13++) {
                bVar.f(i10 + i13, i11 + i12, f136b[i12][i13]);
            }
        }
    }

    private static void r(int i10, int i11, b bVar) {
        for (int i12 = 0; i12 < 7; i12++) {
            for (int i13 = 0; i13 < 7; i13++) {
                bVar.f(i10 + i13, i11 + i12, f135a[i12][i13]);
            }
        }
    }

    static int b(int i10, int i11) {
        if (i11 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int iA = a(i11);
        int iA2 = i10 << (iA - 1);
        while (a(iA2) >= iA) {
            iA2 ^= i11 << (a(iA2) - iA);
        }
        return iA2;
    }

    static void g(z5.a aVar, int i10, b bVar) throws v5.c {
        w5.a aVar2 = new w5.a();
        f(aVar, i10, aVar2);
        for (int i11 = 0; i11 < aVar2.h(); i11++) {
            boolean zG = aVar2.g((aVar2.h() - 1) - i11);
            int[] iArr = f138d[i11];
            bVar.g(iArr[0], iArr[1], zG);
            if (i11 < 8) {
                bVar.g((bVar.e() - i11) - 1, 8, zG);
            } else {
                bVar.g(8, (bVar.d() - 7) + (i11 - 8), zG);
            }
        }
    }

    private static void m(b bVar) {
        int i10 = 8;
        while (i10 < bVar.e() - 8) {
            int i11 = i10 + 1;
            int i12 = i11 % 2;
            if (n(bVar.b(i10, 6))) {
                bVar.f(i10, 6, i12);
            }
            if (n(bVar.b(6, i10))) {
                bVar.f(6, i10, i12);
            }
            i10 = i11;
        }
    }

    private static void s(b bVar) throws v5.c {
        int length = f135a[0].length;
        r(0, 0, bVar);
        r(bVar.e() - length, 0, bVar);
        r(0, bVar.e() - length, bVar);
        c(0, 7, bVar);
        c(bVar.e() - 8, 7, bVar);
        c(0, bVar.e() - 8, bVar);
        k(7, 0, bVar);
        k(bVar.d() - 8, 0, bVar);
        k(7, bVar.d() - 7, bVar);
    }

    static void d(w5.a aVar, int i10, b bVar) throws v5.c {
        int i11;
        boolean zG;
        int iE = bVar.e() - 1;
        int iD = bVar.d() - 1;
        int i12 = 0;
        int i13 = -1;
        while (iE > 0) {
            if (iE == 6) {
                iE--;
            }
            while (iD >= 0 && iD < bVar.d()) {
                for (int i14 = 0; i14 < 2; i14++) {
                    int i15 = iE - i14;
                    if (n(bVar.b(i15, iD))) {
                        if (i12 < aVar.h()) {
                            i11 = i12 + 1;
                            zG = aVar.g(i12);
                        } else {
                            i11 = i12;
                            zG = false;
                        }
                        if (i10 != -1 && e.c(i10, i15, iD)) {
                            zG = !zG;
                        }
                        bVar.g(i15, iD, zG);
                        i12 = i11;
                    }
                }
                iD += i13;
            }
            i13 = -i13;
            iE -= 2;
            iD += i13;
        }
        if (i12 == aVar.h()) {
            return;
        }
        throw new v5.c("Not all bits consumed: " + i12 + '/' + aVar.h());
    }

    static void e(w5.a aVar, z5.a aVar2, z5.c cVar, int i10, b bVar) throws v5.c {
        j(bVar);
        i(cVar, bVar);
        g(aVar2, i10, bVar);
        l(cVar, bVar);
        d(aVar, i10, bVar);
    }

    static void f(z5.a aVar, int i10, w5.a aVar2) throws v5.c {
        if (g.b(i10)) {
            int iF = (aVar.f() << 3) | i10;
            aVar2.d(iF, 5);
            aVar2.d(b(iF, 1335), 10);
            w5.a aVar3 = new w5.a();
            aVar3.d(21522, 15);
            aVar2.m(aVar3);
            if (aVar2.h() == 15) {
                return;
            }
            throw new v5.c("should not happen but we got: " + aVar2.h());
        }
        throw new v5.c("Invalid mask pattern");
    }

    static void h(z5.c cVar, w5.a aVar) throws v5.c {
        aVar.d(cVar.e(), 6);
        aVar.d(b(cVar.e(), 7973), 12);
        if (aVar.h() == 18) {
            return;
        }
        throw new v5.c("should not happen but we got: " + aVar.h());
    }

    static void i(z5.c cVar, b bVar) throws v5.c {
        s(bVar);
        q(bVar);
        p(cVar, bVar);
        m(bVar);
    }

    static void l(z5.c cVar, b bVar) throws v5.c {
        if (cVar.e() >= 7) {
            w5.a aVar = new w5.a();
            h(cVar, aVar);
            int i10 = 17;
            for (int i11 = 0; i11 < 6; i11++) {
                for (int i12 = 0; i12 < 3; i12++) {
                    boolean zG = aVar.g(i10);
                    i10--;
                    bVar.g(i11, (bVar.d() - 11) + i12, zG);
                    bVar.g((bVar.d() - 11) + i12, i11, zG);
                }
            }
        }
    }

    private static void p(z5.c cVar, b bVar) {
        if (cVar.e() >= 2) {
            int[] iArr = f137c[cVar.e() - 1];
            for (int i10 : iArr) {
                for (int i11 : iArr) {
                    if (i11 != -1 && i10 != -1 && n(bVar.b(i11, i10))) {
                        o(i11 - 2, i10 - 2, bVar);
                    }
                }
            }
        }
    }

    private static void q(b bVar) throws v5.c {
        if (bVar.b(8, bVar.d() - 8) != 0) {
            bVar.f(8, bVar.d() - 8, 1);
            return;
        }
        throw new v5.c();
    }
}
