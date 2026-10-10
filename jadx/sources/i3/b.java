package i3;

import h3.e;
import h3.h;
import h3.m;
import h3.o;
import h3.q;
import h3.r;
import h3.s;
import h3.t;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b implements o {
    @Override // h3.o
    public q a(h3.c cVar) {
        return b(cVar, null);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0042  */
    /* JADX WARN: Code duplicated, block: B:35:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x0076 A[LOOP:0: B:38:0x0074->B:39:0x0076, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:42:0x009b  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a6  */
    @Override // h3.o
    public q b(h3.c cVar, Map<e, ?> map) throws h, m {
        s[] sVarArrB;
        int iC;
        m mVar;
        s[] sVarArrB2;
        int iC2;
        h hVar;
        s[] sVarArr;
        q qVar;
        List<byte[]> listA;
        String strB;
        t tVar;
        k3.a aVar = new k3.a(cVar.a());
        p3.e eVarC = null;
        try {
            a aVarA = aVar.a(false);
            sVarArrB = aVarA.b();
            try {
                iC = aVarA.c();
                try {
                    iC2 = iC;
                    hVar = null;
                    eVarC = new j3.a().c(aVarA);
                    sVarArrB2 = sVarArrB;
                    mVar = null;
                } catch (h e10) {
                    e = e10;
                    iC2 = iC;
                    hVar = e;
                    sVarArrB2 = sVarArrB;
                    mVar = null;
                } catch (m e11) {
                    e = e11;
                    s[] sVarArr2 = sVarArrB;
                    mVar = e;
                    sVarArrB2 = sVarArr2;
                    iC2 = iC;
                    hVar = null;
                }
            } catch (h e12) {
                e = e12;
                iC = 0;
                iC2 = iC;
                hVar = e;
                sVarArrB2 = sVarArrB;
                mVar = null;
                if (eVarC == null) {
                    try {
                        a aVarA2 = aVar.a(true);
                        sVarArrB2 = aVarA2.b();
                        iC2 = aVarA2.c();
                        eVarC = new j3.a().c(aVarA2);
                    } catch (h | m e13) {
                        if (mVar != null) {
                            throw mVar;
                        }
                        if (hVar != null) {
                            throw hVar;
                        }
                        throw e13;
                    }
                }
                sVarArr = sVarArrB2;
                int i10 = iC2;
                if (map != null) {
                    for (s sVar : sVarArr) {
                        tVar.a(sVar);
                    }
                }
                qVar = new q(eVarC.k(), eVarC.g(), eVarC.e(), sVarArr, h3.a.AZTEC, System.currentTimeMillis());
                listA = eVarC.a();
                if (listA != null) {
                    qVar.h(r.BYTE_SEGMENTS, listA);
                }
                strB = eVarC.b();
                if (strB != null) {
                    qVar.h(r.ERROR_CORRECTION_LEVEL, strB);
                }
                qVar.h(r.ERRORS_CORRECTED, Integer.valueOf(i10 + eVarC.d().intValue()));
                qVar.h(r.SYMBOLOGY_IDENTIFIER, "]z" + eVarC.j());
                return qVar;
            } catch (m e14) {
                e = e14;
                iC = 0;
                s[] sVarArr3 = sVarArrB;
                mVar = e;
                sVarArrB2 = sVarArr3;
                iC2 = iC;
                hVar = null;
                if (eVarC == null) {
                    a aVarA3 = aVar.a(true);
                    sVarArrB2 = aVarA3.b();
                    iC2 = aVarA3.c();
                    eVarC = new j3.a().c(aVarA3);
                }
                sVarArr = sVarArrB2;
                int i11 = iC2;
                if (map != null) {
                    while (i < r1) {
                        tVar.a(sVar);
                    }
                }
                qVar = new q(eVarC.k(), eVarC.g(), eVarC.e(), sVarArr, h3.a.AZTEC, System.currentTimeMillis());
                listA = eVarC.a();
                if (listA != null) {
                    qVar.h(r.BYTE_SEGMENTS, listA);
                }
                strB = eVarC.b();
                if (strB != null) {
                    qVar.h(r.ERROR_CORRECTION_LEVEL, strB);
                }
                qVar.h(r.ERRORS_CORRECTED, Integer.valueOf(i11 + eVarC.d().intValue()));
                qVar.h(r.SYMBOLOGY_IDENTIFIER, "]z" + eVarC.j());
                return qVar;
            }
        } catch (h e15) {
            e = e15;
            sVarArrB = null;
        } catch (m e16) {
            e = e16;
            sVarArrB = null;
        }
        if (eVarC == null) {
            a aVarA4 = aVar.a(true);
            sVarArrB2 = aVarA4.b();
            iC2 = aVarA4.c();
            eVarC = new j3.a().c(aVarA4);
        }
        sVarArr = sVarArrB2;
        int i12 = iC2;
        if (map != null && (tVar = (t) map.get(e.NEED_RESULT_POINT_CALLBACK)) != null) {
            while (i < r1) {
                tVar.a(sVar);
            }
        }
        qVar = new q(eVarC.k(), eVarC.g(), eVarC.e(), sVarArr, h3.a.AZTEC, System.currentTimeMillis());
        listA = eVarC.a();
        if (listA != null) {
            qVar.h(r.BYTE_SEGMENTS, listA);
        }
        strB = eVarC.b();
        if (strB != null) {
            qVar.h(r.ERROR_CORRECTION_LEVEL, strB);
        }
        qVar.h(r.ERRORS_CORRECTED, Integer.valueOf(i12 + eVarC.d().intValue()));
        qVar.h(r.SYMBOLOGY_IDENTIFIER, "]z" + eVarC.j());
        return qVar;
    }

    @Override // h3.o
    public void reset() {
    }
}
