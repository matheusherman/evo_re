package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private short f9690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private cb.c f9691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private cb.c f9692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<Short, n> f9693e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<Short, List<l>> f9694f = new HashMap();

    public void a(l lVar) {
        List<l> arrayList = this.f9694f.get(Short.valueOf(lVar.b()));
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f9694f.put(Short.valueOf(lVar.b()), arrayList);
        }
        arrayList.add(lVar);
    }

    public void b(n nVar) {
        this.f9693e.put(Short.valueOf(nVar.b()), nVar);
    }

    public short c() {
        return this.f9690b;
    }

    public cb.c d() {
        return this.f9692d;
    }

    public n e(short s10) {
        return this.f9693e.get(Short.valueOf(s10));
    }

    public cb.c f() {
        return this.f9691c;
    }

    public List<l> g(short s10) {
        return this.f9694f.get(Short.valueOf(s10));
    }

    public void h(cb.c cVar) {
        this.f9692d = cVar;
    }

    public void i(cb.c cVar) {
        this.f9691c = cVar;
    }

    public h(d dVar) {
        this.f9689a = dVar.f();
        this.f9690b = (short) dVar.d();
    }
}
