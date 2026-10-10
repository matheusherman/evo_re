package m;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import m.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class g<K extends m, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a<K, V> f15427a = new a<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<K, a<K, V>> f15428b = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f15429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<V> f15430b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        a<K, V> f15431c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        a<K, V> f15432d;

        a() {
            this(null);
        }

        a(K k10) {
            this.f15432d = this;
            this.f15431c = this;
            this.f15429a = k10;
        }

        public void a(V v10) {
            if (this.f15430b == null) {
                this.f15430b = new ArrayList();
            }
            this.f15430b.add(v10);
        }

        public int c() {
            List<V> list = this.f15430b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Nullable
        public V b() {
            int iC = c();
            if (iC > 0) {
                return this.f15430b.remove(iC - 1);
            }
            return null;
        }
    }

    private static <K, V> void e(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f15432d;
        aVar2.f15431c = aVar.f15431c;
        aVar.f15431c.f15432d = aVar2;
    }

    private static <K, V> void g(a<K, V> aVar) {
        aVar.f15431c.f15432d = aVar;
        aVar.f15432d.f15431c = aVar;
    }

    @Nullable
    public V a(K k10) {
        a<K, V> aVar = this.f15428b.get(k10);
        if (aVar == null) {
            aVar = new a<>(k10);
            this.f15428b.put(k10, aVar);
        } else {
            k10.a();
        }
        b(aVar);
        return aVar.b();
    }

    public void d(K k10, V v10) {
        a<K, V> aVar = this.f15428b.get(k10);
        if (aVar == null) {
            aVar = new a<>(k10);
            c(aVar);
            this.f15428b.put(k10, aVar);
        } else {
            k10.a();
        }
        aVar.a(v10);
    }

    @Nullable
    public V f() {
        for (a aVar = this.f15427a.f15432d; !aVar.equals(this.f15427a); aVar = aVar.f15432d) {
            V v10 = (V) aVar.b();
            if (v10 != null) {
                return v10;
            }
            e(aVar);
            this.f15428b.remove(aVar.f15429a);
            ((m) aVar.f15429a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("GroupedLinkedMap( ");
        a aVar = this.f15427a.f15431c;
        boolean z10 = false;
        while (!aVar.equals(this.f15427a)) {
            sb2.append('{');
            sb2.append(aVar.f15429a);
            sb2.append(':');
            sb2.append(aVar.c());
            sb2.append("}, ");
            aVar = aVar.f15431c;
            z10 = true;
        }
        if (z10) {
            sb2.delete(sb2.length() - 2, sb2.length());
        }
        sb2.append(" )");
        return sb2.toString();
    }

    g() {
    }

    private void b(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f15427a;
        aVar.f15432d = aVar2;
        aVar.f15431c = aVar2.f15431c;
        g(aVar);
    }

    private void c(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f15427a;
        aVar.f15432d = aVar2.f15432d;
        aVar.f15431c = aVar2;
        g(aVar);
    }
}
