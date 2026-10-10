package h3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class k implements o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final o[] f10805c = new o[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<e, ?> f10806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private o[] f10807b;

    @Override // h3.o
    public q a(c cVar) {
        e(null);
        return c(cVar);
    }

    private q c(c cVar) throws m {
        o[] oVarArr = this.f10807b;
        if (oVarArr != null) {
            for (o oVar : oVarArr) {
                if (Thread.currentThread().isInterrupted()) {
                    throw m.a();
                }
                try {
                    return oVar.b(cVar, this.f10806a);
                } catch (p unused) {
                }
            }
            Map<e, ?> map = this.f10806a;
            if (map != null && map.containsKey(e.ALSO_INVERTED)) {
                cVar.a().e();
                for (o oVar2 : this.f10807b) {
                    if (Thread.currentThread().isInterrupted()) {
                        throw m.a();
                    }
                    try {
                        return oVar2.b(cVar, this.f10806a);
                    } catch (p unused2) {
                    }
                }
            }
        }
        throw m.a();
    }

    public q d(c cVar) {
        if (this.f10807b == null) {
            e(null);
        }
        return c(cVar);
    }

    public void e(Map<e, ?> map) {
        this.f10806a = map;
        boolean z10 = map != null && map.containsKey(e.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(e.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            boolean z11 = collection.contains(a.UPC_A) || collection.contains(a.UPC_E) || collection.contains(a.EAN_13) || collection.contains(a.EAN_8) || collection.contains(a.CODABAR) || collection.contains(a.CODE_39) || collection.contains(a.CODE_93) || collection.contains(a.CODE_128) || collection.contains(a.ITF) || collection.contains(a.RSS_14) || collection.contains(a.RSS_EXPANDED);
            if (z11 && !z10) {
                arrayList.add(new y3.p(map));
            }
            if (collection.contains(a.QR_CODE)) {
                arrayList.add(new h4.a());
            }
            if (collection.contains(a.DATA_MATRIX)) {
                arrayList.add(new s3.a());
            }
            if (collection.contains(a.AZTEC)) {
                arrayList.add(new i3.b());
            }
            if (collection.contains(a.PDF_417)) {
                arrayList.add(new c4.b());
            }
            if (collection.contains(a.MAXICODE)) {
                arrayList.add(new w3.a());
            }
            if (z11 && z10) {
                arrayList.add(new y3.p(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z10) {
                arrayList.add(new y3.p(map));
            }
            arrayList.add(new h4.a());
            arrayList.add(new s3.a());
            arrayList.add(new i3.b());
            arrayList.add(new c4.b());
            arrayList.add(new w3.a());
            if (z10) {
                arrayList.add(new y3.p(map));
            }
        }
        this.f10807b = (o[]) arrayList.toArray(f10805c);
    }

    @Override // h3.o
    public void reset() {
        o[] oVarArr = this.f10807b;
        if (oVarArr != null) {
            for (o oVar : oVarArr) {
                oVar.reset();
            }
        }
    }

    @Override // h3.o
    public q b(c cVar, Map<e, ?> map) {
        e(map);
        return c(cVar);
    }
}
