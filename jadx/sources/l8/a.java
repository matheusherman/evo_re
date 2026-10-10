package l8;

import androidx.core.location.LocationRequestCompat;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final j8.d<Object, Object> f15233a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Runnable f15234b = new f();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j8.a f15235c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final j8.c<Object> f15236d = new d();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final j8.c<Throwable> f15237e = new g();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j8.c<Throwable> f15238f = new l();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final j8.e f15239g = new e();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final j8.f<Object> f15240h = new m();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final j8.f<Object> f15241i = new h();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final j8.g<Object> f15242j = new k();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final j8.c<af.a> f15243k = new j();

    /* JADX INFO: renamed from: l8.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class C0300a<T, U> implements j8.d<T, U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Class<U> f15244a;

        @Override // j8.d
        public U apply(T t10) {
            return this.f15244a.cast(t10);
        }

        C0300a(Class<U> cls) {
            this.f15244a = cls;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b<T, U> implements j8.f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Class<U> f15245a;

        @Override // j8.f
        public boolean test(T t10) {
            return this.f15245a.isInstance(t10);
        }

        b(Class<U> cls) {
            this.f15245a = cls;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c implements j8.a {
        public String toString() {
            return "EmptyAction";
        }

        c() {
        }

        @Override // j8.a
        public void run() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class d implements j8.c<Object> {
        public String toString() {
            return "EmptyConsumer";
        }

        d() {
        }

        @Override // j8.c
        public void accept(Object obj) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class f implements Runnable {
        public String toString() {
            return "EmptyRunnable";
        }

        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class i implements j8.d<Object, Object> {
        public String toString() {
            return "IdentityFunction";
        }

        i() {
        }

        @Override // j8.d
        public Object apply(Object obj) {
            return obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class l implements j8.c<Throwable> {
        @Override // j8.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            p8.a.l(new i8.c(th));
        }

        l() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class e implements j8.e {
        e() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class g implements j8.c<Throwable> {
        g() {
        }

        @Override // j8.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            p8.a.l(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class h implements j8.f<Object> {
        @Override // j8.f
        public boolean test(Object obj) {
            return false;
        }

        h() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class j implements j8.c<af.a> {
        j() {
        }

        @Override // j8.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(af.a aVar) {
            aVar.h(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class k implements j8.g<Object> {
        @Override // j8.g
        public Object get() {
            return null;
        }

        k() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class m implements j8.f<Object> {
        @Override // j8.f
        public boolean test(Object obj) {
            return true;
        }

        m() {
        }
    }

    public static <T, U> j8.d<T, U> a(Class<U> cls) {
        return new C0300a(cls);
    }

    public static <T> j8.c<T> b() {
        return (j8.c<T>) f15236d;
    }

    public static <T, U> j8.f<T> c(Class<U> cls) {
        return new b(cls);
    }
}
