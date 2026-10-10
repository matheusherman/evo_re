package y3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class q extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final y[] f22376b = new y[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y[] f22377a;

    @Override // y3.r, h3.o
    public void reset() {
        for (y yVar : this.f22377a) {
            yVar.reset();
        }
    }

    public q(Map<h3.e, ?> map) {
        Collection collection;
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(h3.e.POSSIBLE_FORMATS);
        }
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(h3.a.EAN_13)) {
                arrayList.add(new i());
            } else if (collection.contains(h3.a.UPC_A)) {
                arrayList.add(new t());
            }
            if (collection.contains(h3.a.EAN_8)) {
                arrayList.add(new k());
            }
            if (collection.contains(h3.a.UPC_E)) {
                arrayList.add(new a0());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new i());
            arrayList.add(new k());
            arrayList.add(new a0());
        }
        this.f22377a = (y[]) arrayList.toArray(f22376b);
    }

    @Override // y3.r
    public h3.q c(int i10, p3.a aVar, Map<h3.e, ?> map) throws h3.m {
        boolean z10;
        Collection collection;
        boolean z11;
        int[] iArrP = y.p(aVar);
        for (y yVar : this.f22377a) {
            try {
                h3.q qVarM = yVar.m(i10, aVar, iArrP, map);
                if (qVarM.b() == h3.a.EAN_13 && qVarM.f().charAt(0) == '0') {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (map == null) {
                    collection = null;
                } else {
                    collection = (Collection) map.get(h3.e.POSSIBLE_FORMATS);
                }
                if (collection != null && !collection.contains(h3.a.UPC_A)) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (z10 && z11) {
                    h3.q qVar = new h3.q(qVarM.f().substring(1), qVarM.c(), qVarM.e(), h3.a.UPC_A);
                    qVar.g(qVarM.d());
                    return qVar;
                }
                return qVarM;
            } catch (h3.p unused) {
            }
        }
        throw h3.m.a();
    }
}
