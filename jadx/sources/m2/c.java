package m2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<e0<? super T>> f15517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<r> f15518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f15519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f15520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final h<T> f15521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Set<Class<?>> f15522g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f15523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<e0<? super T>> f15524b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Set<r> f15525c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f15526d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f15527e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private h<T> f15528f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Set<Class<?>> f15529g;

        /* synthetic */ b(Class cls, Class[] clsArr, a aVar) {
            this(cls, clsArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public b<T> f() {
            this.f15527e = 1;
            return this;
        }

        public b<T> d() {
            return h(2);
        }

        /* synthetic */ b(e0 e0Var, e0[] e0VarArr, a aVar) {
            this(e0Var, e0VarArr);
        }

        private b<T> h(int i10) {
            d0.d(this.f15526d == 0, "Instantiation type has already been set.");
            this.f15526d = i10;
            return this;
        }

        private void i(e0<?> e0Var) {
            d0.a(!this.f15524b.contains(e0Var), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public b<T> b(r rVar) {
            d0.c(rVar, "Null dependency");
            i(rVar.b());
            this.f15525c.add(rVar);
            return this;
        }

        public c<T> c() {
            d0.d(this.f15528f != null, "Missing required property: factory.");
            return new c<>(this.f15523a, new HashSet(this.f15524b), new HashSet(this.f15525c), this.f15526d, this.f15527e, this.f15528f, this.f15529g, null);
        }

        public b<T> e(h<T> hVar) {
            this.f15528f = (h) d0.c(hVar, "Null factory");
            return this;
        }

        public b<T> g(@NonNull String str) {
            this.f15523a = str;
            return this;
        }

        @SafeVarargs
        private b(Class<T> cls, Class<? super T>... clsArr) {
            this.f15523a = null;
            HashSet hashSet = new HashSet();
            this.f15524b = hashSet;
            this.f15525c = new HashSet();
            this.f15526d = 0;
            this.f15527e = 0;
            this.f15529g = new HashSet();
            d0.c(cls, "Null interface");
            hashSet.add(e0.b(cls));
            for (Class<? super T> cls2 : clsArr) {
                d0.c(cls2, "Null interface");
                this.f15524b.add(e0.b(cls2));
            }
        }

        @SafeVarargs
        private b(e0<T> e0Var, e0<? super T>... e0VarArr) {
            this.f15523a = null;
            HashSet hashSet = new HashSet();
            this.f15524b = hashSet;
            this.f15525c = new HashSet();
            this.f15526d = 0;
            this.f15527e = 0;
            this.f15529g = new HashSet();
            d0.c(e0Var, "Null interface");
            hashSet.add(e0Var);
            for (e0<? super T> e0Var2 : e0VarArr) {
                d0.c(e0Var2, "Null interface");
            }
            Collections.addAll(this.f15524b, e0VarArr);
        }
    }

    /* synthetic */ c(String str, Set set, Set set2, int i10, int i11, h hVar, Set set3, a aVar) {
        this(str, set, set2, i10, i11, hVar, set3);
    }

    private c(@Nullable String str, Set<e0<? super T>> set, Set<r> set2, int i10, int i11, h<T> hVar, Set<Class<?>> set3) {
        this.f15516a = str;
        this.f15517b = Collections.unmodifiableSet(set);
        this.f15518c = Collections.unmodifiableSet(set2);
        this.f15519d = i10;
        this.f15520e = i11;
        this.f15521f = hVar;
        this.f15522g = Collections.unmodifiableSet(set3);
    }

    public static <T> b<T> c(Class<T> cls) {
        return new b<>(cls, new Class[0], (a) null);
    }

    @SafeVarargs
    public static <T> b<T> d(Class<T> cls, Class<? super T>... clsArr) {
        return new b<>(cls, clsArr, (a) null);
    }

    public static <T> b<T> e(e0<T> e0Var) {
        return new b<>(e0Var, new e0[0], (a) null);
    }

    @SafeVarargs
    public static <T> b<T> f(e0<T> e0Var, e0<? super T>... e0VarArr) {
        return new b<>(e0Var, e0VarArr, (a) null);
    }

    public Set<r> g() {
        return this.f15518c;
    }

    public h<T> h() {
        return this.f15521f;
    }

    @Nullable
    public String i() {
        return this.f15516a;
    }

    public Set<e0<? super T>> j() {
        return this.f15517b;
    }

    public Set<Class<?>> k() {
        return this.f15522g;
    }

    public boolean n() {
        return this.f15519d == 1;
    }

    public boolean o() {
        return this.f15519d == 2;
    }

    public boolean p() {
        return this.f15520e == 0;
    }

    public c<T> r(h<T> hVar) {
        return new c<>(this.f15516a, this.f15517b, this.f15518c, this.f15519d, this.f15520e, hVar, this.f15522g);
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f15517b.toArray()) + ">{" + this.f15519d + ", type=" + this.f15520e + ", deps=" + Arrays.toString(this.f15518c.toArray()) + "}";
    }

    public static <T> c<T> l(final T t10, Class<T> cls) {
        return m(cls).e(new h() { // from class: m2.a
            @Override // m2.h
            public final Object a(e eVar) {
                return c.b(t10, eVar);
            }
        }).c();
    }

    public static <T> b<T> m(Class<T> cls) {
        return c(cls).f();
    }

    @SafeVarargs
    public static <T> c<T> q(final T t10, Class<T> cls, Class<? super T>... clsArr) {
        return d(cls, clsArr).e(new h() { // from class: m2.b
            @Override // m2.h
            public final Object a(e eVar) {
                return c.a(t10, eVar);
            }
        }).c();
    }

    public static /* synthetic */ Object a(Object obj, e eVar) {
        return obj;
    }

    public static /* synthetic */ Object b(Object obj, e eVar) {
        return obj;
    }
}
