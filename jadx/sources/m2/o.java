package m2;

import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class o implements e, o2.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final r2.b<Set<Object>> f15556i = new r2.b() { // from class: m2.k
        @Override // r2.b
        public final Object get() {
            return Collections.EMPTY_SET;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<c<?>, r2.b<?>> f15557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<e0<?>, r2.b<?>> f15558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<e0<?>, y<?>> f15559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<r2.b<ComponentRegistrar>> f15560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Set<String> f15561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final v f15562f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicReference<Boolean> f15563g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final j f15564h;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Executor f15565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<r2.b<ComponentRegistrar>> f15566b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<c<?>> f15567c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private j f15568d = j.f15549a;

        public b b(c<?> cVar) {
            this.f15567c.add(cVar);
            return this;
        }

        public b c(final ComponentRegistrar componentRegistrar) {
            this.f15566b.add(new r2.b() { // from class: m2.p
                @Override // r2.b
                public final Object get() {
                    return o.b.a(componentRegistrar);
                }
            });
            return this;
        }

        public b d(Collection<r2.b<ComponentRegistrar>> collection) {
            this.f15566b.addAll(collection);
            return this;
        }

        public o e() {
            return new o(this.f15565a, this.f15566b, this.f15567c, this.f15568d, null);
        }

        public b f(j jVar) {
            this.f15568d = jVar;
            return this;
        }

        b(Executor executor) {
            this.f15565a = executor;
        }

        public static /* synthetic */ ComponentRegistrar a(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }
    }

    /* synthetic */ o(Executor executor, Iterable iterable, Collection collection, j jVar, a aVar) {
        this(executor, iterable, collection, jVar);
    }

    @Override // m2.e
    public synchronized <T> r2.b<T> f(e0<T> e0Var) {
        d0.c(e0Var, "Null interface requested.");
        return (r2.b) this.f15558b.get(e0Var);
    }

    @Override // m2.e
    public synchronized <T> r2.b<Set<T>> g(e0<T> e0Var) {
        y<?> yVar = this.f15559c.get(e0Var);
        if (yVar != null) {
            return yVar;
        }
        return (r2.b<Set<T>>) f15556i;
    }

    private o(Executor executor, Iterable<r2.b<ComponentRegistrar>> iterable, Collection<c<?>> collection, j jVar) {
        this.f15557a = new HashMap();
        this.f15558b = new HashMap();
        this.f15559c = new HashMap();
        this.f15561e = new HashSet();
        this.f15563g = new AtomicReference<>();
        v vVar = new v(executor);
        this.f15562f = vVar;
        this.f15564h = jVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(c.q(vVar, v.class, p2.d.class, p2.c.class));
        arrayList.add(c.q(this, o2.a.class, new Class[0]));
        for (c<?> cVar : collection) {
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        this.f15560d = o(iterable);
        l(arrayList);
    }

    public static b k(Executor executor) {
        return new b(executor);
    }

    private void l(List<c<?>> list) {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<r2.b<ComponentRegistrar>> it = this.f15560d.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = it.next().get();
                    if (componentRegistrar != null) {
                        list.addAll(this.f15564h.a(componentRegistrar));
                        it.remove();
                    }
                } catch (w e10) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e10);
                }
            }
            Iterator<c<?>> it2 = list.iterator();
            while (it2.hasNext()) {
                for (Object obj : it2.next().j().toArray()) {
                    if (obj.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                        if (this.f15561e.contains(obj.toString())) {
                            it2.remove();
                            break;
                        }
                        this.f15561e.add(obj.toString());
                    }
                }
            }
            if (this.f15557a.isEmpty()) {
                q.a(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.f15557a.keySet());
                arrayList2.addAll(list);
                q.a(arrayList2);
            }
            for (final c<?> cVar : list) {
                this.f15557a.put(cVar, new x(new r2.b() { // from class: m2.l
                    @Override // r2.b
                    public final Object get() {
                        return o.h(this.f15550a, cVar);
                    }
                }));
            }
            arrayList.addAll(r(list));
            arrayList.addAll(s());
            q();
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            ((Runnable) it3.next()).run();
        }
        p();
    }

    private static <T> List<T> o(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    private void p() {
        Boolean bool = this.f15563g.get();
        if (bool != null) {
            m(this.f15557a, bool.booleanValue());
        }
    }

    private void q() {
        for (c<?> cVar : this.f15557a.keySet()) {
            for (r rVar : cVar.g()) {
                if (rVar.f() && !this.f15559c.containsKey(rVar.b())) {
                    this.f15559c.put(rVar.b(), y.b(Collections.EMPTY_SET));
                } else if (this.f15558b.containsKey(rVar.b())) {
                    continue;
                } else {
                    if (rVar.e()) {
                        throw new z(String.format("Unsatisfied dependency for component %s: %s", cVar, rVar.b()));
                    }
                    if (!rVar.f()) {
                        this.f15558b.put(rVar.b(), c0.c());
                    }
                }
            }
        }
    }

    private List<Runnable> r(List<c<?>> list) {
        ArrayList arrayList = new ArrayList();
        for (c<?> cVar : list) {
            if (cVar.p()) {
                final r2.b<?> bVar = this.f15557a.get(cVar);
                for (e0<? super Object> e0Var : cVar.j()) {
                    if (this.f15558b.containsKey(e0Var)) {
                        final c0 c0Var = (c0) this.f15558b.get(e0Var);
                        arrayList.add(new Runnable() { // from class: m2.m
                            @Override // java.lang.Runnable
                            public final void run() {
                                c0Var.d(bVar);
                            }
                        });
                    } else {
                        this.f15558b.put(e0Var, bVar);
                    }
                }
            }
        }
        return arrayList;
    }

    private List<Runnable> s() {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (Map.Entry<c<?>, r2.b<?>> entry : this.f15557a.entrySet()) {
            c<?> key = entry.getKey();
            if (!key.p()) {
                r2.b<?> value = entry.getValue();
                for (e0<? super Object> e0Var : key.j()) {
                    if (!map.containsKey(e0Var)) {
                        map.put(e0Var, new HashSet());
                    }
                    ((Set) map.get(e0Var)).add(value);
                }
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            if (this.f15559c.containsKey(entry2.getKey())) {
                final y<?> yVar = this.f15559c.get(entry2.getKey());
                for (final r2.b bVar : (Set) entry2.getValue()) {
                    arrayList.add(new Runnable() { // from class: m2.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            yVar.a(bVar);
                        }
                    });
                }
            } else {
                this.f15559c.put((e0) entry2.getKey(), y.b((Collection) entry2.getValue()));
            }
        }
        return arrayList;
    }

    public void n(boolean z10) {
        HashMap map;
        if (androidx.p000lifecycle.h.a(this.f15563g, null, Boolean.valueOf(z10))) {
            synchronized (this) {
                map = new HashMap(this.f15557a);
            }
            m(map, z10);
        }
    }

    public static /* synthetic */ Object h(o oVar, c cVar) {
        oVar.getClass();
        return cVar.h().a(new f0(cVar, oVar));
    }

    private void m(Map<c<?>, r2.b<?>> map, boolean z10) {
        for (Map.Entry<c<?>, r2.b<?>> entry : map.entrySet()) {
            c<?> key = entry.getKey();
            r2.b<?> value = entry.getValue();
            if (key.n() || (key.o() && z10)) {
                value.get();
            }
        }
        this.f15562f.c();
    }

    @Override // m2.e
    public /* synthetic */ Object a(Class cls) {
        return d.a(this, cls);
    }

    @Override // m2.e
    public /* synthetic */ Set b(e0 e0Var) {
        return d.e(this, e0Var);
    }

    @Override // m2.e
    public /* synthetic */ r2.b c(Class cls) {
        return d.c(this, cls);
    }

    @Override // m2.e
    public /* synthetic */ Set d(Class cls) {
        return d.d(this, cls);
    }

    @Override // m2.e
    public /* synthetic */ Object e(e0 e0Var) {
        return d.b(this, e0Var);
    }
}
