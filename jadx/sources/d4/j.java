package d4;

import h3.m;
import h3.s;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final e4.a f9635a = new e4.a();

    private static c a(h hVar) {
        int[] iArrJ;
        if (hVar == null || (iArrJ = hVar.j()) == null) {
            return null;
        }
        int iP = p(iArrJ);
        int i10 = 0;
        int i11 = 0;
        for (int i12 : iArrJ) {
            i11 += iP - i12;
            if (i12 > 0) {
                break;
            }
        }
        d[] dVarArrD = hVar.d();
        for (int i13 = 0; i11 > 0 && dVarArrD[i13] == null; i13++) {
            i11--;
        }
        for (int length = iArrJ.length - 1; length >= 0; length--) {
            int i14 = iArrJ[length];
            i10 += iP - i14;
            if (i14 > 0) {
                break;
            }
        }
        for (int length2 = dVarArrD.length - 1; i10 > 0 && dVarArrD[length2] == null; length2--) {
            i10--;
        }
        return hVar.a().a(i11, i10, hVar.k());
    }

    private static void b(f fVar, b[][] bVarArr) throws m {
        b bVar = bVarArr[0][1];
        int[] iArrA = bVar.a();
        int iJ = (fVar.j() * fVar.l()) - r(fVar.k());
        if (iArrA.length == 0) {
            if (iJ < 1 || iJ > 928) {
                throw m.a();
            }
            bVar.b(iJ);
            return;
        }
        if (iArrA[0] == iJ || iJ < 1 || iJ > 928) {
            return;
        }
        bVar.b(iJ);
    }

    private static p3.e h(int i10, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws h3.d {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i11 = 100;
        while (true) {
            int i12 = i11 - 1;
            if (i11 <= 0) {
                throw h3.d.a();
            }
            for (int i13 = 0; i13 < length; i13++) {
                iArr[iArr3[i13]] = iArr4[i13][iArr5[i13]];
            }
            try {
                return j(iArr, i10, iArr2);
            } catch (h3.d unused) {
                if (length == 0) {
                    throw h3.d.a();
                }
                for (int i14 = 0; i14 < length; i14++) {
                    int i15 = iArr5[i14];
                    if (i15 < iArr4[i14].length - 1) {
                        iArr5[i14] = i15 + 1;
                        break;
                    }
                    iArr5[i14] = 0;
                    if (i14 == length - 1) {
                        throw h3.d.a();
                    }
                }
                i11 = i12;
            }
        }
    }

    private static p3.e j(int[] iArr, int i10, int[] iArr2) throws h3.d, h3.h {
        if (iArr.length == 0) {
            throw h3.h.a();
        }
        int i11 = 1 << (i10 + 1);
        int iE = e(iArr, iArr2, i11);
        w(iArr, i11);
        p3.e eVarB = e.b(iArr, String.valueOf(i10));
        eVarB.n(Integer.valueOf(iE));
        eVarB.m(Integer.valueOf(iArr2.length));
        return eVarB;
    }

    private static a l(h hVar, h hVar2) {
        a aVarI;
        a aVarI2;
        if (hVar == null || (aVarI = hVar.i()) == null) {
            if (hVar2 == null) {
                return null;
            }
            return hVar2.i();
        }
        if (hVar2 == null || (aVarI2 = hVar2.i()) == null || aVarI.a() == aVarI2.a() || aVarI.b() == aVarI2.b() || aVarI.c() == aVarI2.c()) {
            return aVarI;
        }
        return null;
    }

    private static int o(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    private static int p(int[] iArr) {
        int iMax = -1;
        for (int i10 : iArr) {
            iMax = Math.max(iMax, i10);
        }
        return iMax;
    }

    private static int r(int i10) {
        return 2 << i10;
    }

    private static f v(h hVar, h hVar2) {
        a aVarL;
        if ((hVar == null && hVar2 == null) || (aVarL = l(hVar, hVar2)) == null) {
            return null;
        }
        return new f(aVarL, c.j(a(hVar), a(hVar2)));
    }

    private static void w(int[] iArr, int i10) throws h3.h {
        if (iArr.length < 4) {
            throw h3.h.a();
        }
        int i11 = iArr[0];
        if (i11 > iArr.length) {
            throw h3.h.a();
        }
        if (i11 == 0) {
            if (i10 >= iArr.length) {
                throw h3.h.a();
            }
            iArr[0] = iArr.length - i10;
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0011  */
    /* JADX WARN: Code duplicated, block: B:14:0x0017  */
    /* JADX WARN: Code duplicated, block: B:17:0x0020 A[LOOP:1: B:8:0x000a->B:17:0x0020, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:21:0x001f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x0022 A[EDGE_INSN: B:24:0x0022->B:18:0x0022 BREAK  A[LOOP:1: B:8:0x000a->B:17:0x0020], SYNTHETIC] */
    private static int c(p3.b bVar, int i10, int i11, boolean z10, int i12, int i13) {
        int i14 = z10 ? -1 : 1;
        int i15 = i12;
        for (int i16 = 0; i16 < 2; i16++) {
            while (true) {
                if (!z10) {
                    if (i15 >= i11) {
                        break;
                    }
                    if (z10 == bVar.h(i15, i13)) {
                        break;
                        break;
                    }
                    if (Math.abs(i12 - i15) > 2) {
                        return i12;
                    }
                    i15 += i14;
                } else {
                    if (i15 < i10) {
                        break;
                    }
                    if (z10 == bVar.h(i15, i13)) {
                        break;
                    }
                    if (Math.abs(i12 - i15) > 2) {
                        return i12;
                    }
                    i15 += i14;
                }
            }
            i14 = -i14;
            z10 = !z10;
        }
        return i15;
    }

    private static boolean d(int i10, int i11, int i12) {
        return i11 + (-2) <= i10 && i10 <= i12 + 2;
    }

    private static int e(int[] iArr, int[] iArr2, int i10) throws h3.d {
        if ((iArr2 == null || iArr2.length <= (i10 / 2) + 3) && i10 >= 0 && i10 <= 512) {
            return f9635a.a(iArr, i10, iArr2);
        }
        throw h3.d.a();
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00db  */
    /* JADX WARN: Code duplicated, block: B:73:0x00f1 A[SYNTHETIC] */
    public static p3.e i(p3.b bVar, s sVar, s sVar2, s sVar3, s sVar4, int i10, int i11) {
        g gVar;
        int i12;
        d dVarK;
        h hVar = null;
        c cVar = new c(bVar, sVar, sVar2, sVar3, sVar4);
        h hVarS = null;
        boolean z10 = true;
        while (true) {
            h hVarS2 = sVar != null ? s(bVar, cVar, sVar, true, i10, i11) : hVar;
            if (sVar3 != null) {
                hVarS = s(bVar, cVar, sVar3, false, i10, i11);
            }
            c cVar2 = cVar;
            f fVarV = v(hVarS2, hVarS);
            if (fVarV == null) {
                throw m.a();
            }
            cVar = fVarV.m();
            if (!z10 || cVar == null || (cVar.g() >= cVar2.g() && cVar.e() <= cVar2.e())) {
                fVarV.p(cVar2);
                int iJ = fVarV.j() + 1;
                fVarV.q(0, hVarS2);
                fVarV.q(iJ, hVarS);
                boolean z11 = hVarS2 != null;
                int i13 = i10;
                int i14 = i11;
                for (int i15 = 1; i15 <= iJ; i15++) {
                    int i16 = z11 ? i15 : iJ - i15;
                    if (fVarV.n(i16) == null) {
                        g hVar2 = (i16 == 0 || i16 == iJ) ? new h(cVar2, i16 == 0) : new g(cVar2);
                        fVarV.q(i16, hVar2);
                        int i17 = -1;
                        int iMin = i13;
                        int iMax = i14;
                        int iG = cVar2.g();
                        int i18 = -1;
                        while (iG <= cVar2.e()) {
                            int iT = t(fVarV, i16, iG, z11);
                            if (iT >= 0 && iT <= cVar2.d()) {
                                i12 = iT;
                                gVar = hVar2;
                                dVarK = k(bVar, cVar2.f(), cVar2.d(), z11, i12, iG, iMin, iMax);
                                if (dVarK != null) {
                                    gVar.f(iG, dVarK);
                                    iMin = Math.min(iMin, dVarK.f());
                                    iMax = Math.max(iMax, dVarK.f());
                                    i18 = i12;
                                }
                            } else if (i18 == i17) {
                                gVar = hVar2;
                            } else {
                                iT = i18;
                                i12 = iT;
                                gVar = hVar2;
                                dVarK = k(bVar, cVar2.f(), cVar2.d(), z11, i12, iG, iMin, iMax);
                                if (dVarK != null) {
                                    gVar.f(iG, dVarK);
                                    iMin = Math.min(iMin, dVarK.f());
                                    iMax = Math.max(iMax, dVarK.f());
                                    i18 = i12;
                                }
                            }
                            iG++;
                            hVar2 = gVar;
                            i17 = -1;
                        }
                        i13 = iMin;
                        i14 = iMax;
                    }
                }
                return g(fVarV);
            }
            hVar = hVarS2;
            z10 = false;
        }
    }

    private static int[] m(int i10) {
        int[] iArr = new int[8];
        int i11 = 0;
        int i12 = 7;
        while (true) {
            int i13 = i10 & 1;
            if (i13 != i11) {
                i12--;
                if (i12 < 0) {
                    return iArr;
                }
                i11 = i13;
            }
            iArr[i12] = iArr[i12] + 1;
            i10 >>= 1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0013 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:12:0x0015  */
    /* JADX WARN: Code duplicated, block: B:28:0x0027 A[EDGE_INSN: B:28:0x0027->B:16:0x0027 BREAK  A[LOOP:0: B:7:0x000c->B:31:0x000c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x0022 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x001b A[SYNTHETIC] */
    private static int[] q(p3.b bVar, int i10, int i11, boolean z10, int i12, int i13) {
        int[] iArr = new int[8];
        int i14 = z10 ? 1 : -1;
        int i15 = 0;
        boolean z11 = z10;
        while (true) {
            if (!z10) {
                if (i12 < i10) {
                    break;
                }
                if (i15 < 8) {
                    break;
                    break;
                }
                if (bVar.h(i12, i13) == z11) {
                    iArr[i15] = iArr[i15] + 1;
                    i12 += i14;
                } else {
                    i15++;
                    z11 = !z11;
                }
            } else {
                if (i12 >= i11) {
                    break;
                }
                if (i15 < 8) {
                    break;
                }
                if (bVar.h(i12, i13) == z11) {
                    iArr[i15] = iArr[i15] + 1;
                    i12 += i14;
                } else {
                    i15++;
                    z11 = !z11;
                }
            }
        }
        if (i15 != 8) {
            if (z10) {
                i10 = i11;
            }
            if (i12 != i10 || i15 != 7) {
                return null;
            }
        }
        return iArr;
    }

    private static h s(p3.b bVar, c cVar, s sVar, boolean z10, int i10, int i11) {
        h hVar = new h(cVar, z10);
        int i12 = 0;
        while (i12 < 2) {
            int i13 = i12 == 0 ? 1 : -1;
            int iC = (int) sVar.c();
            for (int iD = (int) sVar.d(); iD <= cVar.e() && iD >= cVar.g(); iD += i13) {
                d dVarK = k(bVar, 0, bVar.n(), z10, iC, iD, i10, i11);
                if (dVarK != null) {
                    hVar.f(iD, dVarK);
                    iC = z10 ? dVarK.d() : dVarK.b();
                }
            }
            i12++;
        }
        return hVar;
    }

    private static int t(f fVar, int i10, int i11, boolean z10) {
        int i12 = z10 ? 1 : -1;
        int i13 = i10 - i12;
        d dVarB = u(fVar, i13) ? fVar.n(i13).b(i11) : null;
        if (dVarB != null) {
            return z10 ? dVarB.b() : dVarB.d();
        }
        d dVarC = fVar.n(i10).c(i11);
        if (dVarC != null) {
            return z10 ? dVarC.d() : dVarC.b();
        }
        if (u(fVar, i13)) {
            dVarC = fVar.n(i13).c(i11);
        }
        if (dVarC != null) {
            return z10 ? dVarC.b() : dVarC.d();
        }
        int i14 = 0;
        while (true) {
            i10 -= i12;
            if (!u(fVar, i10)) {
                c cVarM = fVar.m();
                return z10 ? cVarM.f() : cVarM.d();
            }
            for (d dVar : fVar.n(i10).d()) {
                if (dVar != null) {
                    return (z10 ? dVar.b() : dVar.d()) + (i12 * i14 * (dVar.b() - dVar.d()));
                }
            }
            i14++;
        }
    }

    private static boolean u(f fVar, int i10) {
        return i10 >= 0 && i10 <= fVar.j() + 1;
    }

    private static b[][] f(f fVar) {
        int iC;
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, fVar.l(), fVar.j() + 2);
        for (b[] bVarArr2 : bVarArr) {
            int i10 = 0;
            while (true) {
                if (i10 < bVarArr2.length) {
                    bVarArr2[i10] = new b();
                    i10++;
                }
            }
        }
        int i11 = 0;
        for (g gVar : fVar.o()) {
            if (gVar != null) {
                for (d dVar : gVar.d()) {
                    if (dVar != null && (iC = dVar.c()) >= 0 && iC < bVarArr.length) {
                        bVarArr[iC][i11].b(dVar.e());
                    }
                }
            }
            i11++;
        }
        return bVarArr;
    }

    private static p3.e g(f fVar) throws m {
        b[][] bVarArrF = f(fVar);
        b(fVar, bVarArrF);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[fVar.l() * fVar.j()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i10 = 0; i10 < fVar.l(); i10++) {
            int i11 = 0;
            while (i11 < fVar.j()) {
                int i12 = i11 + 1;
                int[] iArrA = bVarArrF[i10][i12].a();
                int iJ = (fVar.j() * i10) + i11;
                if (iArrA.length == 0) {
                    arrayList.add(Integer.valueOf(iJ));
                } else if (iArrA.length == 1) {
                    iArr[iJ] = iArrA[0];
                } else {
                    arrayList3.add(Integer.valueOf(iJ));
                    arrayList2.add(iArrA);
                }
                i11 = i12;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i13 = 0; i13 < size; i13++) {
            iArr2[i13] = (int[]) arrayList2.get(i13);
        }
        return h(fVar.k(), iArr, c4.a.b(arrayList), c4.a.b(arrayList3), iArr2);
    }

    private static d k(p3.b bVar, int i10, int i11, boolean z10, int i12, int i13, int i14, int i15) {
        int i16;
        int iD;
        int iA;
        int iC = c(bVar, i10, i11, z10, i12, i13);
        int[] iArrQ = q(bVar, i10, i11, z10, iC, i13);
        if (iArrQ == null) {
            return null;
        }
        int iD2 = q3.a.d(iArrQ);
        if (z10) {
            i16 = iC + iD2;
        } else {
            for (int i17 = 0; i17 < iArrQ.length / 2; i17++) {
                int i18 = iArrQ[i17];
                iArrQ[i17] = iArrQ[(iArrQ.length - 1) - i17];
                iArrQ[(iArrQ.length - 1) - i17] = i18;
            }
            iC -= iD2;
            i16 = iC;
        }
        if (!d(iD2, i14, i15) || (iA = c4.a.a((iD = i.d(iArrQ)))) == -1) {
            return null;
        }
        return new d(iC, i16, n(iD), iA);
    }

    private static int n(int i10) {
        return o(m(i10));
    }
}
