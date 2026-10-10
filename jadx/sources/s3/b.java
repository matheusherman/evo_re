package s3;

import h3.f;
import h3.g;
import h3.u;
import java.nio.charset.Charset;
import java.util.Map;
import v3.e;
import v3.i;
import v3.j;
import v3.k;
import v3.l;
import v3.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b implements u {
    private static p3.b b(k4.b bVar, int i10, int i11) {
        p3.b bVar2;
        int iE = bVar.e();
        int iD = bVar.d();
        int iMax = Math.max(i10, iE);
        int iMax2 = Math.max(i11, iD);
        int iMin = Math.min(iMax / iE, iMax2 / iD);
        int i12 = (iMax - (iE * iMin)) / 2;
        int i13 = (iMax2 - (iD * iMin)) / 2;
        if (i11 >= iD && i10 >= iE) {
            bVar2 = new p3.b(i10, i11);
        } else {
            bVar2 = new p3.b(iE, iD);
            i12 = 0;
            i13 = 0;
        }
        bVar2.c();
        int i14 = 0;
        while (i14 < iD) {
            int i15 = i12;
            int i16 = 0;
            while (i16 < iE) {
                if (bVar.b(i16, i14) == 1) {
                    bVar2.t(i15, i13, iMin, iMin);
                }
                i16++;
                i15 += iMin;
            }
            i14++;
            i13 += iMin;
        }
        return bVar2;
    }

    private static p3.b c(e eVar, l lVar, int i10, int i11) {
        boolean z10;
        boolean z11;
        int iH = lVar.h();
        int iG = lVar.g();
        k4.b bVar = new k4.b(lVar.j(), lVar.i());
        int i12 = 0;
        for (int i13 = 0; i13 < iG; i13++) {
            if (i13 % lVar.f19579e == 0) {
                int i14 = 0;
                for (int i15 = 0; i15 < lVar.j(); i15++) {
                    if (i15 % 2 == 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    bVar.g(i14, i12, z11);
                    i14++;
                }
                i12++;
            }
            int i16 = 0;
            for (int i17 = 0; i17 < iH; i17++) {
                if (i17 % lVar.f19578d == 0) {
                    bVar.g(i16, i12, true);
                    i16++;
                }
                bVar.g(i16, i12, eVar.e(i17, i13));
                int i18 = i16 + 1;
                int i19 = lVar.f19578d;
                if (i17 % i19 == i19 - 1) {
                    if (i13 % 2 == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    bVar.g(i18, i12, z10);
                    i16 += 2;
                } else {
                    i16 = i18;
                }
            }
            int i20 = i12 + 1;
            int i21 = lVar.f19579e;
            if (i13 % i21 == i21 - 1) {
                int i22 = 0;
                for (int i23 = 0; i23 < lVar.j(); i23++) {
                    bVar.g(i22, i20, true);
                    i22++;
                }
                i12 += 2;
            } else {
                i12 = i20;
            }
        }
        return b(bVar, i10, i11);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0089 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x008b  */
    @Override // h3.u
    public p3.b a(String str, h3.a aVar, int i10, int i11, Map<g, ?> map) {
        f fVar;
        f fVar2;
        String strB;
        g gVar;
        int i12;
        if (!str.isEmpty()) {
            if (aVar == h3.a.DATA_MATRIX) {
                if (i10 >= 0 && i11 >= 0) {
                    m mVar = m.FORCE_NONE;
                    Charset charsetForName = null;
                    if (map != null) {
                        m mVar2 = (m) map.get(g.DATA_MATRIX_SHAPE);
                        if (mVar2 != null) {
                            mVar = mVar2;
                        }
                        fVar = (f) map.get(g.MIN_SIZE);
                        if (fVar == null) {
                            fVar = null;
                        }
                        fVar2 = (f) map.get(g.MAX_SIZE);
                        if (fVar2 == null) {
                            fVar2 = null;
                        }
                    } else {
                        fVar = null;
                        fVar2 = null;
                    }
                    boolean z10 = false;
                    if (map != null) {
                        g gVar2 = g.DATA_MATRIX_COMPACT;
                        if (map.containsKey(gVar2) && Boolean.parseBoolean(map.get(gVar2).toString())) {
                            g gVar3 = g.GS1_FORMAT;
                            if (map.containsKey(gVar3) && Boolean.parseBoolean(map.get(gVar3).toString())) {
                                z10 = true;
                            }
                            g gVar4 = g.CHARACTER_SET;
                            if (map.containsKey(gVar4)) {
                                charsetForName = Charset.forName(map.get(gVar4).toString());
                            }
                            if (z10) {
                                i12 = 29;
                            } else {
                                i12 = -1;
                            }
                            strB = k.h(str, charsetForName, i12, mVar);
                        } else {
                            if (map != null) {
                                gVar = g.FORCE_C40;
                                if (map.containsKey(gVar) && Boolean.parseBoolean(map.get(gVar).toString())) {
                                    z10 = true;
                                }
                            }
                            strB = j.b(str, mVar, fVar, fVar2, z10);
                        }
                    } else {
                        if (map != null) {
                            gVar = g.FORCE_C40;
                            if (map.containsKey(gVar)) {
                                z10 = true;
                            }
                        }
                        strB = j.b(str, mVar, fVar, fVar2, z10);
                    }
                    l lVarL = l.l(strB.length(), mVar, fVar, fVar2, true);
                    e eVar = new e(i.b(strB, lVarL), lVarL.h(), lVarL.g());
                    eVar.h();
                    return c(eVar, lVarL, i10, i11);
                }
                throw new IllegalArgumentException("Requested dimensions can't be negative: " + i10 + 'x' + i11);
            }
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got " + aVar);
        }
        throw new IllegalArgumentException("Found empty contents");
    }
}
