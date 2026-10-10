package y3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class p extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final r[] f22374b = new r[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r[] f22375a;

    @Override // y3.r
    public h3.q c(int i10, p3.a aVar, Map<h3.e, ?> map) throws h3.m {
        for (r rVar : this.f22375a) {
            try {
                return rVar.c(i10, aVar, map);
            } catch (h3.p unused) {
            }
        }
        throw h3.m.a();
    }

    @Override // y3.r, h3.o
    public void reset() {
        for (r rVar : this.f22375a) {
            rVar.reset();
        }
    }

    public p(Map<h3.e, ?> map) {
        Collection collection;
        boolean z10;
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(h3.e.POSSIBLE_FORMATS);
        }
        if (map != null && map.get(h3.e.ASSUME_CODE_39_CHECK_DIGIT) != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(h3.a.EAN_13) || collection.contains(h3.a.UPC_A) || collection.contains(h3.a.EAN_8) || collection.contains(h3.a.UPC_E)) {
                arrayList.add(new q(map));
            }
            if (collection.contains(h3.a.CODE_39)) {
                arrayList.add(new e(z10));
            }
            if (collection.contains(h3.a.CODE_93)) {
                arrayList.add(new g());
            }
            if (collection.contains(h3.a.CODE_128)) {
                arrayList.add(new c());
            }
            if (collection.contains(h3.a.ITF)) {
                arrayList.add(new n());
            }
            if (collection.contains(h3.a.CODABAR)) {
                arrayList.add(new a());
            }
            if (collection.contains(h3.a.RSS_14)) {
                arrayList.add(new z3.e());
            }
            if (collection.contains(h3.a.RSS_EXPANDED)) {
                arrayList.add(new a4.d());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new q(map));
            arrayList.add(new e());
            arrayList.add(new a());
            arrayList.add(new g());
            arrayList.add(new c());
            arrayList.add(new n());
            arrayList.add(new z3.e());
            arrayList.add(new a4.d());
        }
        this.f22375a = (r[]) arrayList.toArray(f22374b);
    }
}
