package w3;

import h3.d;
import h3.e;
import h3.h;
import h3.m;
import h3.o;
import h3.q;
import h3.r;
import h3.s;
import java.util.Map;
import p3.b;
import x3.c;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a implements o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final s[] f20055b = new s[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f20056a = new c();

    @Override // h3.o
    public q a(h3.c cVar) {
        return b(cVar, null);
    }

    private static b c(b bVar) throws m {
        int[] iArrJ = bVar.j();
        if (iArrJ != null) {
            int i10 = iArrJ[0];
            int i11 = iArrJ[1];
            int i12 = iArrJ[2];
            int i13 = iArrJ[3];
            b bVar2 = new b(30, 33);
            for (int i14 = 0; i14 < 33; i14++) {
                int iMin = Math.min(((i14 * i13) + (i13 / 2)) / 33, i13 - 1) + i11;
                for (int i15 = 0; i15 < 30; i15++) {
                    if (bVar.h(Math.min((((i15 * i12) + (i12 / 2)) + (((i14 & 1) * i12) / 2)) / 30, i12 - 1) + i10, iMin)) {
                        bVar2.s(i15, i14);
                    }
                }
            }
            return bVar2;
        }
        throw m.a();
    }

    @Override // h3.o
    public q b(h3.c cVar, Map<e, ?> map) throws d, h, m {
        p3.e eVarB = this.f20056a.b(c(cVar.a()), map);
        q qVar = new q(eVarB.k(), eVarB.g(), f20055b, h3.a.MAXICODE);
        qVar.h(r.ERRORS_CORRECTED, eVarB.d());
        String strB = eVarB.b();
        if (strB != null) {
            qVar.h(r.ERROR_CORRECTION_LEVEL, strB);
        }
        return qVar;
    }

    @Override // h3.o
    public void reset() {
    }
}
