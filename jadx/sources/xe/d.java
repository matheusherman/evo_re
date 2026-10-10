package xe;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final ExecutorService f22220m = Executors.newCachedThreadPool();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f22225e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f22227g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f22228h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    List<ze.b> f22230j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    g f22231k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    h f22232l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f22221a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f22222b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f22223c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f22224d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f22226f = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    ExecutorService f22229i = f22220m;

    g a() {
        g gVar = this.f22231k;
        return gVar != null ? gVar : g.a.a();
    }

    h b() {
        h hVar = this.f22232l;
        if (hVar != null) {
            return hVar;
        }
        if (ye.a.a()) {
            return ye.a.b().f22581b;
        }
        return null;
    }

    d() {
    }
}
