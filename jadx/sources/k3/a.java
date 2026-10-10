package k3;

import h3.m;
import h3.s;
import p3.l;
import r3.c;
import r3.e;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f12115g = {3808, 476, 2107, 1799};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p3.b f12116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f12119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f12120e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f12121f;

    /* JADX INFO: renamed from: k3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class C0202a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f12123b;

        int a() {
            return this.f12122a;
        }

        int b() {
            return this.f12123b;
        }

        C0202a(int i10, int i11) {
            this.f12122a = i10;
            this.f12123b = i11;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f12125b;

        int a() {
            return this.f12124a;
        }

        int b() {
            return this.f12125b;
        }

        s c() {
            return new s(this.f12124a, this.f12125b);
        }

        public String toString() {
            return "<" + this.f12124a + ' ' + this.f12125b + '>';
        }

        b(int i10, int i11) {
            this.f12124a = i10;
            this.f12125b = i11;
        }
    }

    private static s[] d(s[] sVarArr, int i10, int i11) {
        float f10 = i11 / (i10 * 2.0f);
        float fC = sVarArr[0].c() - sVarArr[2].c();
        float fD = sVarArr[0].d() - sVarArr[2].d();
        float fC2 = (sVarArr[0].c() + sVarArr[2].c()) / 2.0f;
        float fD2 = (sVarArr[0].d() + sVarArr[2].d()) / 2.0f;
        float f11 = fC * f10;
        float f12 = fD * f10;
        s sVar = new s(fC2 + f11, fD2 + f12);
        s sVar2 = new s(fC2 - f11, fD2 - f12);
        float fC3 = sVarArr[1].c() - sVarArr[3].c();
        float fD3 = sVarArr[1].d() - sVarArr[3].d();
        float fC4 = (sVarArr[1].c() + sVarArr[3].c()) / 2.0f;
        float fD4 = (sVarArr[1].d() + sVarArr[3].d()) / 2.0f;
        float f13 = fC3 * f10;
        float f14 = f10 * fD3;
        return new s[]{sVar, new s(fC4 + f13, fD4 + f14), sVar2, new s(fC4 - f13, fD4 - f14)};
    }

    private int e(s[] sVarArr) throws m {
        long j10;
        long j11;
        if (!o(sVarArr[0]) || !o(sVarArr[1]) || !o(sVarArr[2]) || !o(sVarArr[3])) {
            throw m.a();
        }
        int i10 = this.f12120e * 2;
        int[] iArr = {r(sVarArr[0], sVarArr[1], i10), r(sVarArr[1], sVarArr[2], i10), r(sVarArr[2], sVarArr[3], i10), r(sVarArr[3], sVarArr[0], i10)};
        this.f12121f = m(iArr, i10);
        long j12 = 0;
        for (int i11 = 0; i11 < 4; i11++) {
            int i12 = iArr[(this.f12121f + i11) % 4];
            if (this.f12117b) {
                j10 = j12 << 7;
                j11 = (i12 >> 1) & 127;
            } else {
                j10 = j12 << 10;
                j11 = ((i12 >> 2) & 992) + ((i12 >> 1) & 31);
            }
            j12 = j10 + j11;
        }
        C0202a c0202aH = h(j12, this.f12117b);
        int iA = c0202aH.a();
        if (this.f12117b) {
            this.f12118c = (iA >> 6) + 1;
            this.f12119d = (iA & 63) + 1;
        } else {
            this.f12118c = (iA >> 11) + 1;
            this.f12119d = (iA & 2047) + 1;
        }
        return c0202aH.b();
    }

    private static C0202a h(long j10, boolean z10) throws m {
        int i10;
        int i11;
        if (z10) {
            i10 = 7;
            i11 = 2;
        } else {
            i10 = 10;
            i11 = 4;
        }
        int i12 = i10 - i11;
        int[] iArr = new int[i10];
        for (int i13 = i10 - 1; i13 >= 0; i13--) {
            iArr[i13] = ((int) j10) & 15;
            j10 >>= 4;
        }
        try {
            int iA = new c(r3.a.f17795k).a(iArr, i12);
            int i14 = 0;
            for (int i15 = 0; i15 < i11; i15++) {
                i14 = (i14 << 4) + iArr[i15];
            }
            return new C0202a(i14, iA);
        } catch (e unused) {
            throw m.a();
        }
    }

    private b k() {
        s sVarC;
        s sVar;
        s sVar2;
        s sVar3;
        s sVarC2;
        s sVarC3;
        s sVarC4;
        s sVarC5;
        try {
            s[] sVarArrC = new q3.b(this.f12116a).c();
            sVar2 = sVarArrC[0];
            sVar3 = sVarArrC[1];
            sVar = sVarArrC[2];
            sVarC = sVarArrC[3];
        } catch (m unused) {
            int iN = this.f12116a.n() / 2;
            int iK = this.f12116a.k() / 2;
            int i10 = iN + 7;
            int i11 = iK - 7;
            s sVarC6 = j(new b(i10, i11), false, 1, -1).c();
            int i12 = iK + 7;
            s sVarC7 = j(new b(i10, i12), false, 1, 1).c();
            int i13 = iN - 7;
            s sVarC8 = j(new b(i13, i12), false, -1, 1).c();
            sVarC = j(new b(i13, i11), false, -1, -1).c();
            sVar = sVarC8;
            sVar2 = sVarC6;
            sVar3 = sVarC7;
        }
        int iC = q3.a.c((((sVar2.c() + sVarC.c()) + sVar3.c()) + sVar.c()) / 4.0f);
        int iC2 = q3.a.c((((sVar2.d() + sVarC.d()) + sVar3.d()) + sVar.d()) / 4.0f);
        try {
            s[] sVarArrC2 = new q3.b(this.f12116a, 15, iC, iC2).c();
            sVarC2 = sVarArrC2[0];
            sVarC3 = sVarArrC2[1];
            sVarC4 = sVarArrC2[2];
            sVarC5 = sVarArrC2[3];
        } catch (m unused2) {
            int i14 = iC + 7;
            int i15 = iC2 - 7;
            sVarC2 = j(new b(i14, i15), false, 1, -1).c();
            int i16 = iC2 + 7;
            sVarC3 = j(new b(i14, i16), false, 1, 1).c();
            int i17 = iC - 7;
            sVarC4 = j(new b(i17, i16), false, -1, 1).c();
            sVarC5 = j(new b(i17, i15), false, -1, -1).c();
        }
        return new b(q3.a.c((((sVarC2.c() + sVarC5.c()) + sVarC3.c()) + sVarC4.c()) / 4.0f), q3.a.c((((sVarC2.d() + sVarC5.d()) + sVarC3.d()) + sVarC4.d()) / 4.0f));
    }

    private static int m(int[] iArr, int i10) throws m {
        int i11 = 0;
        for (int i12 : iArr) {
            i11 = (i11 << 3) + ((i12 >> (i10 - 2)) << 1) + (i12 & 1);
        }
        int i13 = ((i11 & 1) << 11) + (i11 >> 1);
        for (int i14 = 0; i14 < 4; i14++) {
            if (Integer.bitCount(f12115g[i14] ^ i13) <= 2) {
                return i14;
            }
        }
        throw m.a();
    }

    private s[] f(b bVar) throws m {
        this.f12120e = 1;
        b bVar2 = bVar;
        b bVar3 = bVar2;
        b bVar4 = bVar3;
        b bVar5 = bVar4;
        boolean z10 = true;
        while (this.f12120e < 9) {
            b bVarJ = j(bVar2, z10, 1, -1);
            b bVarJ2 = j(bVar3, z10, 1, 1);
            b bVarJ3 = j(bVar4, z10, -1, 1);
            b bVarJ4 = j(bVar5, z10, -1, -1);
            if (this.f12120e > 2) {
                double dC = (c(bVarJ4, bVarJ) * this.f12120e) / (c(bVar5, bVar2) * (this.f12120e + 2));
                if (dC < 0.75d || dC > 1.25d || !p(bVarJ, bVarJ2, bVarJ3, bVarJ4)) {
                    break;
                }
            }
            z10 = !z10;
            this.f12120e++;
            bVar5 = bVarJ4;
            bVar2 = bVarJ;
            bVar3 = bVarJ2;
            bVar4 = bVarJ3;
        }
        int i10 = this.f12120e;
        if (i10 != 5 && i10 != 7) {
            throw m.a();
        }
        this.f12117b = i10 == 5;
        s[] sVarArr = {new s(bVar2.a() + 0.5f, bVar2.b() - 0.5f), new s(bVar3.a() + 0.5f, bVar3.b() + 0.5f), new s(bVar4.a() - 0.5f, bVar4.b() + 0.5f), new s(bVar5.a() - 0.5f, bVar5.b() - 0.5f)};
        int i11 = this.f12120e;
        return d(sVarArr, (i11 * 2) - 3, i11 * 2);
    }

    private int i() {
        if (this.f12117b) {
            return (this.f12118c * 4) + 11;
        }
        int i10 = this.f12118c;
        return (i10 * 4) + ((((i10 * 2) + 6) / 15) * 2) + 15;
    }

    private s[] l(s[] sVarArr) {
        return d(sVarArr, this.f12120e * 2, i());
    }

    private boolean n(int i10, int i11) {
        return i10 >= 0 && i10 < this.f12116a.n() && i11 >= 0 && i11 < this.f12116a.k();
    }

    private boolean p(b bVar, b bVar2, b bVar3, b bVar4) {
        b bVar5 = new b(Math.max(0, bVar.a() - 3), Math.min(this.f12116a.k() - 1, bVar.b() + 3));
        b bVar6 = new b(Math.max(0, bVar2.a() - 3), Math.max(0, bVar2.b() - 3));
        b bVar7 = new b(Math.min(this.f12116a.n() - 1, bVar3.a() + 3), Math.max(0, Math.min(this.f12116a.k() - 1, bVar3.b() - 3)));
        b bVar8 = new b(Math.min(this.f12116a.n() - 1, bVar4.a() + 3), Math.min(this.f12116a.k() - 1, bVar4.b() + 3));
        int iG = g(bVar8, bVar5);
        return iG != 0 && g(bVar5, bVar6) == iG && g(bVar6, bVar7) == iG && g(bVar7, bVar8) == iG;
    }

    public a(p3.b bVar) {
        this.f12116a = bVar;
    }

    private static float b(s sVar, s sVar2) {
        return q3.a.a(sVar.c(), sVar.d(), sVar2.c(), sVar2.d());
    }

    private static float c(b bVar, b bVar2) {
        return q3.a.b(bVar.a(), bVar.b(), bVar2.a(), bVar2.b());
    }

    private int g(b bVar, b bVar2) {
        float fC = c(bVar, bVar2);
        boolean z10 = false;
        if (fC == 0.0f) {
            return 0;
        }
        float fA = (bVar2.a() - bVar.a()) / fC;
        float fB = (bVar2.b() - bVar.b()) / fC;
        float fA2 = bVar.a();
        float fB2 = bVar.b();
        boolean zH = this.f12116a.h(bVar.a(), bVar.b());
        int iFloor = (int) Math.floor(fC);
        int i10 = 0;
        for (int i11 = 0; i11 < iFloor; i11++) {
            if (this.f12116a.h(q3.a.c(fA2), q3.a.c(fB2)) != zH) {
                i10++;
            }
            fA2 += fA;
            fB2 += fB;
        }
        float f10 = i10 / fC;
        if (f10 > 0.1f && f10 < 0.9f) {
            return 0;
        }
        if (f10 <= 0.1f) {
            z10 = true;
        }
        if (z10 == zH) {
            return 1;
        }
        return -1;
    }

    private b j(b bVar, boolean z10, int i10, int i11) {
        int iA = bVar.a() + i10;
        int iB = bVar.b();
        while (true) {
            iB += i11;
            if (!n(iA, iB) || this.f12116a.h(iA, iB) != z10) {
                break;
            }
            iA += i10;
        }
        int i12 = iA - i10;
        int i13 = iB - i11;
        while (n(i12, i13) && this.f12116a.h(i12, i13) == z10) {
            i12 += i10;
        }
        int i14 = i12 - i10;
        while (n(i14, i13) && this.f12116a.h(i14, i13) == z10) {
            i13 += i11;
        }
        return new b(i14, i13 - i11);
    }

    private boolean o(s sVar) {
        return n(q3.a.c(sVar.c()), q3.a.c(sVar.d()));
    }

    private p3.b q(p3.b bVar, s sVar, s sVar2, s sVar3, s sVar4) {
        l lVarB = l.b();
        int i10 = i();
        float f10 = i10 / 2.0f;
        int i11 = this.f12120e;
        float f11 = f10 - i11;
        float f12 = f10 + i11;
        return lVarB.c(bVar, i10, i10, f11, f11, f12, f11, f12, f12, f11, f12, sVar.c(), sVar.d(), sVar2.c(), sVar2.d(), sVar3.c(), sVar3.d(), sVar4.c(), sVar4.d());
    }

    private int r(s sVar, s sVar2, int i10) {
        float fB = b(sVar, sVar2);
        float f10 = fB / i10;
        float fC = sVar.c();
        float fD = sVar.d();
        float fC2 = ((sVar2.c() - sVar.c()) * f10) / fB;
        float fD2 = (f10 * (sVar2.d() - sVar.d())) / fB;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            float f11 = i12;
            if (this.f12116a.h(q3.a.c((f11 * fC2) + fC), q3.a.c((f11 * fD2) + fD))) {
                i11 |= 1 << ((i10 - i12) - 1);
            }
        }
        return i11;
    }

    public i3.a a(boolean z10) throws m {
        s[] sVarArrF = f(k());
        if (z10) {
            s sVar = sVarArrF[0];
            sVarArrF[0] = sVarArrF[2];
            sVarArrF[2] = sVar;
        }
        int iE = e(sVarArrF);
        p3.b bVar = this.f12116a;
        int i10 = this.f12121f;
        return new i3.a(q(bVar, sVarArrF[i10 % 4], sVarArrF[(i10 + 1) % 4], sVarArrF[(i10 + 2) % 4], sVarArrF[(i10 + 3) % 4]), l(sVarArrF), this.f12117b, this.f12119d, this.f12118c, iE);
    }
}
