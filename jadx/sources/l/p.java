package l;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class p<Z> implements v<Z> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f15121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f15122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final v<Z> f15123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f15124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final j.f f15125e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f15126f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f15127g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    interface a {
        void a(j.f fVar, p<?> pVar);
    }

    synchronized void a() {
        if (this.f15127g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f15126f++;
    }

    void e() {
        boolean z10;
        synchronized (this) {
            int i10 = this.f15126f;
            if (i10 <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z10 = true;
            int i11 = i10 - 1;
            this.f15126f = i11;
            if (i11 != 0) {
                z10 = false;
            }
        }
        if (z10) {
            this.f15124d.a(this.f15125e, this);
        }
    }

    @Override // l.v
    public synchronized void recycle() {
        if (this.f15126f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f15127g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f15127g = true;
        if (this.f15122b) {
            this.f15123c.recycle();
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f15121a + ", listener=" + this.f15124d + ", key=" + this.f15125e + ", acquired=" + this.f15126f + ", isRecycled=" + this.f15127g + ", resource=" + this.f15123c + '}';
    }

    @Override // l.v
    @NonNull
    public Class<Z> b() {
        return this.f15123c.b();
    }

    v<Z> c() {
        return this.f15123c;
    }

    boolean d() {
        return this.f15121a;
    }

    @Override // l.v
    @NonNull
    public Z get() {
        return this.f15123c.get();
    }

    @Override // l.v
    public int getSize() {
        return this.f15123c.getSize();
    }

    p(v<Z> vVar, boolean z10, boolean z11, j.f fVar, a aVar) {
        this.f15123c = (v) e0.k.d(vVar);
        this.f15121a = z10;
        this.f15122b = z11;
        this.f15125e = fVar;
        this.f15124d = (a) e0.k.d(aVar);
    }
}
