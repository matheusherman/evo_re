package k4;

import com.taobao.sophix.PatchStatus;
import h3.v;
import i4.j;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[][] f12134a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[][] f12135b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[][] f12136c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, PatchStatus.CODE_LOAD_LIB_LOST, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, PatchStatus.CODE_LOAD_LIB_CPUABIS, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[][] f12137d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    static void c(b bVar) {
        bVar.a((byte) -1);
    }

    private static void g(int i10, int i11, b bVar) throws v {
        for (int i12 = 0; i12 < 8; i12++) {
            int i13 = i10 + i12;
            if (!o(bVar.b(i13, i11))) {
                throw new v();
            }
            bVar.f(i13, i11, 0);
        }
    }

    private static void h(int i10, int i11, b bVar) {
        for (int i12 = 0; i12 < 5; i12++) {
            int[] iArr = f12135b[i12];
            for (int i13 = 0; i13 < 5; i13++) {
                bVar.f(i10 + i13, i11 + i12, iArr[i13]);
            }
        }
    }

    private static void i(int i10, int i11, b bVar) {
        for (int i12 = 0; i12 < 7; i12++) {
            int[] iArr = f12134a[i12];
            for (int i13 = 0; i13 < 7; i13++) {
                bVar.f(i10 + i13, i11 + i12, iArr[i13]);
            }
        }
    }

    private static void m(int i10, int i11, b bVar) throws v {
        for (int i12 = 0; i12 < 7; i12++) {
            int i13 = i11 + i12;
            if (!o(bVar.b(i10, i13))) {
                throw new v();
            }
            bVar.f(i10, i13, 0);
        }
    }

    private static boolean o(int i10) {
        return i10 == -1;
    }

    static int b(int i10, int i11) {
        if (i11 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int iN = n(i11);
        int iN2 = i10 << (iN - 1);
        while (n(iN2) >= iN) {
            iN2 ^= i11 << (n(iN2) - iN);
        }
        return iN2;
    }

    private static void j(b bVar) throws v {
        int length = f12134a[0].length;
        i(0, 0, bVar);
        i(bVar.e() - length, 0, bVar);
        i(0, bVar.e() - length, bVar);
        g(0, 7, bVar);
        g(bVar.e() - 8, 7, bVar);
        g(0, bVar.e() - 8, bVar);
        m(7, 0, bVar);
        m(bVar.d() - 8, 0, bVar);
        m(7, bVar.d() - 7, bVar);
    }

    private static void k(b bVar) {
        int i10 = 8;
        while (i10 < bVar.e() - 8) {
            int i11 = i10 + 1;
            int i12 = i11 % 2;
            if (o(bVar.b(i10, 6))) {
                bVar.f(i10, 6, i12);
            }
            if (o(bVar.b(6, i10))) {
                bVar.f(6, i10, i12);
            }
            i10 = i11;
        }
    }

    static void l(i4.f fVar, int i10, b bVar) throws v {
        int iD;
        p3.a aVar = new p3.a();
        p(fVar, i10, aVar);
        for (int i11 = 0; i11 < aVar.m(); i11++) {
            boolean zI = aVar.i((aVar.m() - 1) - i11);
            int[] iArr = f12137d[i11];
            bVar.g(iArr[0], iArr[1], zI);
            int iE = 8;
            if (i11 < 8) {
                iE = (bVar.e() - i11) - 1;
                iD = 8;
            } else {
                iD = (bVar.d() - 7) + (i11 - 8);
            }
            bVar.g(iE, iD, zI);
        }
    }

    static void a(p3.a aVar, i4.f fVar, j jVar, int i10, b bVar) throws v {
        c(bVar);
        d(jVar, bVar);
        l(fVar, i10, bVar);
        s(jVar, bVar);
        f(aVar, i10, bVar);
    }

    static void d(j jVar, b bVar) throws v {
        j(bVar);
        e(bVar);
        r(jVar, bVar);
        k(bVar);
    }

    private static void e(b bVar) throws v {
        if (bVar.b(8, bVar.d() - 8) != 0) {
            bVar.f(8, bVar.d() - 8, 1);
            return;
        }
        throw new v();
    }

    static void f(p3.a aVar, int i10, b bVar) throws v {
        boolean zI;
        int iE = bVar.e() - 1;
        int iD = bVar.d() - 1;
        int i11 = 0;
        int i12 = -1;
        while (iE > 0) {
            if (iE == 6) {
                iE--;
            }
            while (iD >= 0 && iD < bVar.d()) {
                for (int i13 = 0; i13 < 2; i13++) {
                    int i14 = iE - i13;
                    if (o(bVar.b(i14, iD))) {
                        if (i11 < aVar.m()) {
                            zI = aVar.i(i11);
                            i11++;
                        } else {
                            zI = false;
                        }
                        if (i10 != -1 && d.f(i10, i14, iD)) {
                            zI = !zI;
                        }
                        bVar.g(i14, iD, zI);
                    }
                }
                iD += i12;
            }
            i12 = -i12;
            iD += i12;
            iE -= 2;
        }
        if (i11 == aVar.m()) {
            return;
        }
        throw new v("Not all bits consumed: " + i11 + '/' + aVar.m());
    }

    static int n(int i10) {
        return 32 - Integer.numberOfLeadingZeros(i10);
    }

    static void p(i4.f fVar, int i10, p3.a aVar) throws v {
        if (g.b(i10)) {
            int i11 = (fVar.i() << 3) | i10;
            aVar.d(i11, 5);
            aVar.d(b(i11, 1335), 10);
            p3.a aVar2 = new p3.a();
            aVar2.d(21522, 15);
            aVar.v(aVar2);
            if (aVar.m() == 15) {
                return;
            }
            throw new v("should not happen but we got: " + aVar.m());
        }
        throw new v("Invalid mask pattern");
    }

    static void q(j jVar, p3.a aVar) throws v {
        aVar.d(jVar.j(), 6);
        aVar.d(b(jVar.j(), 7973), 12);
        if (aVar.m() == 18) {
            return;
        }
        throw new v("should not happen but we got: " + aVar.m());
    }

    private static void r(j jVar, b bVar) {
        if (jVar.j() >= 2) {
            int[] iArr = f12136c[jVar.j() - 1];
            for (int i10 : iArr) {
                if (i10 >= 0) {
                    for (int i11 : iArr) {
                        if (i11 >= 0 && o(bVar.b(i11, i10))) {
                            h(i11 - 2, i10 - 2, bVar);
                        }
                    }
                }
            }
        }
    }

    static void s(j jVar, b bVar) throws v {
        if (jVar.j() >= 7) {
            p3.a aVar = new p3.a();
            q(jVar, aVar);
            int i10 = 17;
            for (int i11 = 0; i11 < 6; i11++) {
                for (int i12 = 0; i12 < 3; i12++) {
                    boolean zI = aVar.i(i10);
                    i10--;
                    bVar.g(i11, (bVar.d() - 11) + i12, zI);
                    bVar.g((bVar.d() - 11) + i12, i11, zI);
                }
            }
        }
    }
}
