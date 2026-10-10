package l;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<j.f, l<?>> f15131a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<j.f, l<?>> f15132b = new HashMap();

    private Map<j.f, l<?>> b(boolean z10) {
        return z10 ? this.f15132b : this.f15131a;
    }

    s() {
    }

    l<?> a(j.f fVar, boolean z10) {
        return b(z10).get(fVar);
    }

    void c(j.f fVar, l<?> lVar) {
        b(lVar.p()).put(fVar, lVar);
    }

    void d(j.f fVar, l<?> lVar) {
        Map<j.f, l<?>> mapB = b(lVar.p());
        if (lVar.equals(mapB.get(fVar))) {
            mapB.remove(fVar);
        }
    }
}
