package m2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class q {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final m2.c<?> f15570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<b> f15571b = new HashSet();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Set<b> f15572c = new HashSet();

        void a(b bVar) {
            this.f15571b.add(bVar);
        }

        void b(b bVar) {
            this.f15572c.add(bVar);
        }

        m2.c<?> c() {
            return this.f15570a;
        }

        Set<b> d() {
            return this.f15571b;
        }

        boolean e() {
            return this.f15571b.isEmpty();
        }

        boolean f() {
            return this.f15572c.isEmpty();
        }

        void g(b bVar) {
            this.f15572c.remove(bVar);
        }

        b(m2.c<?> cVar) {
            this.f15570a = cVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e0<?> f15573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f15574b;

        /* synthetic */ c(e0 e0Var, boolean z10, a aVar) {
            this(e0Var, z10);
        }

        private c(e0<?> e0Var, boolean z10) {
            this.f15573a = e0Var;
            this.f15574b = z10;
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.f15573a.equals(this.f15573a) && cVar.f15574b == this.f15574b) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((this.f15573a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f15574b).hashCode();
        }
    }

    private static Set<b> b(Set<b> set) {
        HashSet hashSet = new HashSet();
        for (b bVar : set) {
            if (bVar.f()) {
                hashSet.add(bVar);
            }
        }
        return hashSet;
    }

    private static Set<b> c(List<m2.c<?>> list) {
        Set<b> set;
        HashMap map = new HashMap(list.size());
        Iterator<m2.c<?>> it = list.iterator();
        while (true) {
            a aVar = null;
            if (!it.hasNext()) {
                Iterator it2 = map.values().iterator();
                while (it2.hasNext()) {
                    for (b bVar : (Set) it2.next()) {
                        for (r rVar : bVar.c().g()) {
                            if (rVar.d() && (set = (Set) map.get(new c(rVar.b(), rVar.f(), aVar))) != null) {
                                for (b bVar2 : set) {
                                    bVar.a(bVar2);
                                    bVar2.b(bVar);
                                }
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator it3 = map.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                return hashSet;
            }
            m2.c<?> next = it.next();
            b bVar3 = new b(next);
            for (e0<? super Object> e0Var : next.j()) {
                c cVar = new c(e0Var, !next.p(), aVar);
                if (!map.containsKey(cVar)) {
                    map.put(cVar, new HashSet());
                }
                Set set2 = (Set) map.get(cVar);
                if (!set2.isEmpty() && !cVar.f15574b) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", e0Var));
                }
                set2.add(bVar3);
            }
        }
    }

    static void a(List<m2.c<?>> list) {
        Set<b> setC = c(list);
        Set<b> setB = b(setC);
        int i10 = 0;
        while (!setB.isEmpty()) {
            b next = setB.iterator().next();
            setB.remove(next);
            i10++;
            for (b bVar : next.d()) {
                bVar.g(next);
                if (bVar.f()) {
                    setB.add(bVar);
                }
            }
        }
        if (i10 == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar2 : setC) {
            if (!bVar2.f() && !bVar2.e()) {
                arrayList.add(bVar2.c());
            }
        }
        throw new s(arrayList);
    }
}
