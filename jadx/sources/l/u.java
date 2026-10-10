package l;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class u<Z> implements v<Z>, f0.a.f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Pools.Pool<u<?>> f15137e = f0.a.d(20, new a());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f0.c f15138a = f0.c.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private v<Z> f15139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f15140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f15141d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements f0.a.d<u<?>> {
        @Override // f0.a.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public u<?> a() {
            return new u<>();
        }

        a() {
        }
    }

    private void c(v<Z> vVar) {
        this.f15141d = false;
        this.f15140c = true;
        this.f15139b = vVar;
    }

    private void e() {
        this.f15139b = null;
        f15137e.release(this);
    }

    synchronized void f() {
        this.f15138a.c();
        if (!this.f15140c) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f15140c = false;
        if (this.f15141d) {
            recycle();
        }
    }

    @Override // l.v
    public synchronized void recycle() {
        this.f15138a.c();
        this.f15141d = true;
        if (!this.f15140c) {
            this.f15139b.recycle();
            e();
        }
    }

    @NonNull
    static <Z> u<Z> d(v<Z> vVar) {
        u<Z> uVar = (u) e0.k.d(f15137e.acquire());
        uVar.c(vVar);
        return uVar;
    }

    @Override // f0.a.f
    @NonNull
    public f0.c a() {
        return this.f15138a;
    }

    @Override // l.v
    @NonNull
    public Class<Z> b() {
        return this.f15139b.b();
    }

    @Override // l.v
    @NonNull
    public Z get() {
        return this.f15139b.get();
    }

    @Override // l.v
    public int getSize() {
        return this.f15139b.getSize();
    }

    u() {
    }
}
