package h4;

import h3.c;
import h3.d;
import h3.h;
import h3.m;
import h3.o;
import h3.q;
import h3.r;
import h3.s;
import i4.e;
import i4.i;
import java.util.List;
import java.util.Map;
import p3.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a implements o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final s[] f10841b = new s[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f10842a = new e();

    @Override // h3.o
    public q a(c cVar) {
        return b(cVar, null);
    }

    @Override // h3.o
    public final q b(c cVar, Map<h3.e, ?> map) throws d, h, m {
        s[] sVarArrB;
        p3.e eVarC;
        if (map == null || !map.containsKey(h3.e.PURE_BARCODE)) {
            g gVarE = new j4.c(cVar.a()).e(map);
            p3.e eVarC2 = this.f10842a.c(gVarE.a(), map);
            sVarArrB = gVarE.b();
            eVarC = eVarC2;
        } else {
            eVarC = this.f10842a.c(c(cVar.a()), map);
            sVarArrB = f10841b;
        }
        if (eVarC.f() instanceof i) {
            ((i) eVarC.f()).a(sVarArrB);
        }
        q qVar = new q(eVarC.k(), eVarC.g(), sVarArrB, h3.a.QR_CODE);
        List<byte[]> listA = eVarC.a();
        if (listA != null) {
            qVar.h(r.BYTE_SEGMENTS, listA);
        }
        String strB = eVarC.b();
        if (strB != null) {
            qVar.h(r.ERROR_CORRECTION_LEVEL, strB);
        }
        if (eVarC.l()) {
            qVar.h(r.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(eVarC.i()));
            qVar.h(r.STRUCTURED_APPEND_PARITY, Integer.valueOf(eVarC.h()));
        }
        qVar.h(r.ERRORS_CORRECTED, eVarC.d());
        qVar.h(r.SYMBOLOGY_IDENTIFIER, "]Q" + eVarC.j());
        return qVar;
    }

    private static p3.b c(p3.b bVar) throws m {
        int[] iArrM = bVar.m();
        int[] iArrI = bVar.i();
        if (iArrM != null && iArrI != null) {
            float fD = d(iArrM, bVar);
            int i10 = iArrM[1];
            int i11 = iArrI[1];
            int i12 = iArrM[0];
            int i13 = iArrI[0];
            if (i12 < i13 && i10 < i11) {
                int i14 = i11 - i10;
                if (i14 != i13 - i12 && (i13 = i12 + i14) >= bVar.n()) {
                    throw m.a();
                }
                int iRound = Math.round(((i13 - i12) + 1) / fD);
                int iRound2 = Math.round((i14 + 1) / fD);
                if (iRound > 0 && iRound2 > 0) {
                    if (iRound2 == iRound) {
                        int i15 = (int) (fD / 2.0f);
                        int i16 = i10 + i15;
                        int i17 = i12 + i15;
                        int i18 = (((int) ((iRound - 1) * fD)) + i17) - i13;
                        if (i18 > 0) {
                            if (i18 <= i15) {
                                i17 -= i18;
                            } else {
                                throw m.a();
                            }
                        }
                        int i19 = (((int) ((iRound2 - 1) * fD)) + i16) - i11;
                        if (i19 > 0) {
                            if (i19 <= i15) {
                                i16 -= i19;
                            } else {
                                throw m.a();
                            }
                        }
                        p3.b bVar2 = new p3.b(iRound, iRound2);
                        for (int i20 = 0; i20 < iRound2; i20++) {
                            int i21 = ((int) (i20 * fD)) + i16;
                            for (int i22 = 0; i22 < iRound; i22++) {
                                if (bVar.h(((int) (i22 * fD)) + i17, i21)) {
                                    bVar2.s(i22, i20);
                                }
                            }
                        }
                        return bVar2;
                    }
                    throw m.a();
                }
                throw m.a();
            }
            throw m.a();
        }
        throw m.a();
    }

    private static float d(int[] iArr, p3.b bVar) throws m {
        int iK = bVar.k();
        int iN = bVar.n();
        int i10 = iArr[0];
        boolean z10 = true;
        int i11 = iArr[1];
        int i12 = 0;
        while (i10 < iN && i11 < iK) {
            if (z10 != bVar.h(i10, i11)) {
                i12++;
                if (i12 == 5) {
                    break;
                }
                z10 = !z10;
            }
            i10++;
            i11++;
        }
        if (i10 != iN && i11 != iK) {
            return (i10 - iArr[0]) / 7.0f;
        }
        throw m.a();
    }

    @Override // h3.o
    public void reset() {
    }
}
