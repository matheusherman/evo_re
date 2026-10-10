package s3;

import h3.c;
import h3.e;
import h3.h;
import h3.m;
import h3.o;
import h3.q;
import h3.r;
import h3.s;
import java.util.List;
import java.util.Map;
import p3.g;
import t3.d;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a implements o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final s[] f18260b = new s[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f18261a = new d();

    @Override // h3.o
    public q a(c cVar) {
        return b(cVar, null);
    }

    @Override // h3.o
    public q b(c cVar, Map<e, ?> map) throws h, m {
        s[] sVarArrB;
        p3.e eVarB;
        if (map == null || !map.containsKey(e.PURE_BARCODE)) {
            g gVarB = new u3.a(cVar.a()).b();
            p3.e eVarB2 = this.f18261a.b(gVarB.a());
            sVarArrB = gVarB.b();
            eVarB = eVarB2;
        } else {
            eVarB = this.f18261a.b(c(cVar.a()));
            sVarArrB = f18260b;
        }
        q qVar = new q(eVarB.k(), eVarB.g(), sVarArrB, h3.a.DATA_MATRIX);
        List<byte[]> listA = eVarB.a();
        if (listA != null) {
            qVar.h(r.BYTE_SEGMENTS, listA);
        }
        String strB = eVarB.b();
        if (strB != null) {
            qVar.h(r.ERROR_CORRECTION_LEVEL, strB);
        }
        qVar.h(r.ERRORS_CORRECTED, eVarB.d());
        qVar.h(r.SYMBOLOGY_IDENTIFIER, "]d" + eVarB.j());
        return qVar;
    }

    private static p3.b c(p3.b bVar) throws m {
        int[] iArrM = bVar.m();
        int[] iArrI = bVar.i();
        if (iArrM != null && iArrI != null) {
            int iD = d(iArrM, bVar);
            int i10 = iArrM[1];
            int i11 = iArrI[1];
            int i12 = iArrM[0];
            int i13 = ((iArrI[0] - i12) + 1) / iD;
            int i14 = ((i11 - i10) + 1) / iD;
            if (i13 > 0 && i14 > 0) {
                int i15 = iD / 2;
                int i16 = i10 + i15;
                int i17 = i12 + i15;
                p3.b bVar2 = new p3.b(i13, i14);
                for (int i18 = 0; i18 < i14; i18++) {
                    int i19 = (i18 * iD) + i16;
                    for (int i20 = 0; i20 < i13; i20++) {
                        if (bVar.h((i20 * iD) + i17, i19)) {
                            bVar2.s(i20, i18);
                        }
                    }
                }
                return bVar2;
            }
            throw m.a();
        }
        throw m.a();
    }

    private static int d(int[] iArr, p3.b bVar) throws m {
        int iN = bVar.n();
        int i10 = iArr[0];
        int i11 = iArr[1];
        while (i10 < iN && bVar.h(i10, i11)) {
            i10++;
        }
        if (i10 != iN) {
            int i12 = i10 - iArr[0];
            if (i12 != 0) {
                return i12;
            }
            throw m.a();
        }
        throw m.a();
    }

    @Override // h3.o
    public void reset() {
    }
}
