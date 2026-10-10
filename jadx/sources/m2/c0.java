package m2;

import androidx.annotation.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class c0<T> implements r2.b<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final r2.a<Object> f15530c = new r2.a() { // from class: m2.a0
        @Override // r2.a
        public final void a(r2.b bVar) {
            c0.b(bVar);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final r2.b<Object> f15531d = new r2.b() { // from class: m2.b0
        @Override // r2.b
        public final Object get() {
            return c0.a();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private r2.a<T> f15532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile r2.b<T> f15533b;

    public static /* synthetic */ Object a() {
        return null;
    }

    static <T> c0<T> c() {
        return new c0<>(f15530c, f15531d);
    }

    void d(r2.b<T> bVar) {
        r2.a<T> aVar;
        if (this.f15533b != f15531d) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (this) {
            aVar = this.f15532a;
            this.f15532a = null;
            this.f15533b = bVar;
        }
        aVar.a(bVar);
    }

    @Override // r2.b
    public T get() {
        return this.f15533b.get();
    }

    private c0(r2.a<T> aVar, r2.b<T> bVar) {
        this.f15532a = aVar;
        this.f15533b = bVar;
    }

    public static /* synthetic */ void b(r2.b bVar) {
    }
}
