package m2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class f0 implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<e0<?>> f15537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<e0<?>> f15538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<e0<?>> f15539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set<e0<?>> f15540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set<e0<?>> f15541e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set<Class<?>> f15542f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e f15543g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class a implements p2.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<Class<?>> f15544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final p2.c f15545b;

        public a(Set<Class<?>> set, p2.c cVar) {
            this.f15544a = set;
            this.f15545b = cVar;
        }
    }

    @Override // m2.e
    public <T> T a(Class<T> cls) {
        if (!this.f15537a.contains(e0.b(cls))) {
            throw new t(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        T t10 = (T) this.f15543g.a(cls);
        return !cls.equals(p2.c.class) ? t10 : (T) new a(this.f15542f, (p2.c) t10);
    }

    @Override // m2.e
    public <T> Set<T> b(e0<T> e0Var) {
        if (this.f15540d.contains(e0Var)) {
            return this.f15543g.b(e0Var);
        }
        throw new t(String.format("Attempting to request an undeclared dependency Set<%s>.", e0Var));
    }

    @Override // m2.e
    public <T> T e(e0<T> e0Var) {
        if (this.f15537a.contains(e0Var)) {
            return (T) this.f15543g.e(e0Var);
        }
        throw new t(String.format("Attempting to request an undeclared dependency %s.", e0Var));
    }

    @Override // m2.e
    public <T> r2.b<T> f(e0<T> e0Var) {
        if (this.f15538b.contains(e0Var)) {
            return this.f15543g.f(e0Var);
        }
        throw new t(String.format("Attempting to request an undeclared dependency Provider<%s>.", e0Var));
    }

    @Override // m2.e
    public <T> r2.b<Set<T>> g(e0<T> e0Var) {
        if (this.f15541e.contains(e0Var)) {
            return this.f15543g.g(e0Var);
        }
        throw new t(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", e0Var));
    }

    f0(c<?> cVar, e eVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (r rVar : cVar.g()) {
            if (rVar.d()) {
                if (rVar.f()) {
                    hashSet4.add(rVar.b());
                } else {
                    hashSet.add(rVar.b());
                }
            } else if (rVar.c()) {
                hashSet3.add(rVar.b());
            } else if (rVar.f()) {
                hashSet5.add(rVar.b());
            } else {
                hashSet2.add(rVar.b());
            }
        }
        if (!cVar.k().isEmpty()) {
            hashSet.add(e0.b(p2.c.class));
        }
        this.f15537a = Collections.unmodifiableSet(hashSet);
        this.f15538b = Collections.unmodifiableSet(hashSet2);
        this.f15539c = Collections.unmodifiableSet(hashSet3);
        this.f15540d = Collections.unmodifiableSet(hashSet4);
        this.f15541e = Collections.unmodifiableSet(hashSet5);
        this.f15542f = cVar.k();
        this.f15543g = eVar;
    }

    @Override // m2.e
    public <T> r2.b<T> c(Class<T> cls) {
        return f(e0.b(cls));
    }

    @Override // m2.e
    public /* synthetic */ Set d(Class cls) {
        return d.d(this, cls);
    }
}
