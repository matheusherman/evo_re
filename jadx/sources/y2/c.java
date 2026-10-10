package y2;

import java.util.Iterator;
import java.util.Set;
import m2.r;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f22313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f22314b;

    public static /* synthetic */ i b(m2.e eVar) {
        return new c(eVar.d(f.class), d.a());
    }

    public static m2.c<i> c() {
        return m2.c.c(i.class).b(r.k(f.class)).e(new m2.h() { // from class: y2.b
            @Override // m2.h
            public final Object a(m2.e eVar) {
                return c.b(eVar);
            }
        }).c();
    }

    private static String d(Set<f> set) {
        StringBuilder sb2 = new StringBuilder();
        Iterator<f> it = set.iterator();
        while (it.hasNext()) {
            f next = it.next();
            sb2.append(next.b());
            sb2.append('/');
            sb2.append(next.c());
            if (it.hasNext()) {
                sb2.append(' ');
            }
        }
        return sb2.toString();
    }

    @Override // y2.i
    public String a() {
        if (this.f22314b.b().isEmpty()) {
            return this.f22313a;
        }
        return this.f22313a + ' ' + d(this.f22314b.b());
    }

    c(Set<f> set, d dVar) {
        this.f22313a = d(set);
        this.f22314b = dVar;
    }
}
