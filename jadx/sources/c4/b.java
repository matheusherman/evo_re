package c4;

import d4.j;
import h3.e;
import h3.m;
import h3.o;
import h3.q;
import h3.r;
import h3.s;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class b implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final q[] f1121a = new q[0];

    private static int d(s[] sVarArr) {
        return Math.max(Math.max(e(sVarArr[0], sVarArr[4]), (e(sVarArr[6], sVarArr[2]) * 17) / 18), Math.max(e(sVarArr[1], sVarArr[5]), (e(sVarArr[7], sVarArr[3]) * 17) / 18));
    }

    private static int f(s[] sVarArr) {
        return Math.min(Math.min(g(sVarArr[0], sVarArr[4]), (g(sVarArr[6], sVarArr[2]) * 17) / 18), Math.min(g(sVarArr[1], sVarArr[5]), (g(sVarArr[7], sVarArr[3]) * 17) / 18));
    }

    @Override // h3.o
    public q a(h3.c cVar) {
        return b(cVar, null);
    }

    @Override // h3.o
    public q b(h3.c cVar, Map<e, ?> map) throws m {
        q qVar;
        q[] qVarArrC = c(cVar, map, false);
        if (qVarArrC.length == 0 || (qVar = qVarArrC[0]) == null) {
            throw m.a();
        }
        return qVar;
    }

    private static q[] c(h3.c cVar, Map<e, ?> map, boolean z10) {
        ArrayList arrayList = new ArrayList();
        f4.b bVarC = f4.a.c(cVar, map, z10);
        for (s[] sVarArr : bVarC.b()) {
            p3.e eVarI = j.i(bVarC.a(), sVarArr[4], sVarArr[5], sVarArr[6], sVarArr[7], f(sVarArr), d(sVarArr));
            q qVar = new q(eVarI.k(), eVarI.g(), sVarArr, h3.a.PDF_417);
            qVar.h(r.ERROR_CORRECTION_LEVEL, eVarI.b());
            qVar.h(r.ERRORS_CORRECTED, eVarI.d());
            qVar.h(r.ERASURES_CORRECTED, eVarI.c());
            c cVar2 = (c) eVarI.f();
            if (cVar2 != null) {
                qVar.h(r.PDF417_EXTRA_METADATA, cVar2);
            }
            qVar.h(r.ORIENTATION, Integer.valueOf(bVarC.c()));
            qVar.h(r.SYMBOLOGY_IDENTIFIER, "]L" + eVarI.j());
            arrayList.add(qVar);
        }
        return (q[]) arrayList.toArray(f1121a);
    }

    private static int e(s sVar, s sVar2) {
        if (sVar == null || sVar2 == null) {
            return 0;
        }
        return (int) Math.abs(sVar.c() - sVar2.c());
    }

    private static int g(s sVar, s sVar2) {
        if (sVar == null || sVar2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(sVar.c() - sVar2.c());
    }

    @Override // h3.o
    public void reset() {
    }
}
