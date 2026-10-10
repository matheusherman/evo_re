package l;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class h<R> implements l.f.a, Runnable, Comparable<h<?>>, f0.a.f {
    private j.a A;
    private com.bumptech.glide.load.data.d<?> B;
    private volatile l.f C;
    private volatile boolean D;
    private volatile boolean E;
    private boolean F;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e f14998d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Pools.Pool<h<?>> f14999e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.bumptech.glide.e f15002h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private j.f f15003i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.bumptech.glide.h f15004j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private n f15005k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f15006l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f15007m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private j f15008n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private j.i f15009o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private b<R> f15010p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f15011q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private EnumC0298h f15012r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private g f15013s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f15014t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f15015u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Object f15016v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Thread f15017w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private j.f f15018x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private j.f f15019y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Object f15020z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l.g<R> f14995a = new l.g<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Throwable> f14996b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f0.c f14997c = f0.c.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d<?> f15000f = new d<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final f f15001g = new f();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    interface b<R> {
        void b(q qVar);

        void c(v<R> vVar, j.a aVar, boolean z10);

        void d(h<?> hVar);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class c<Z> implements i.a<Z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final j.a f15024a;

        c(j.a aVar) {
            this.f15024a = aVar;
        }

        @Override // l.i.a
        @NonNull
        public v<Z> a(@NonNull v<Z> vVar) {
            return h.this.G(this.f15024a, vVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class d<Z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private j.f f15026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private j.l<Z> f15027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private u<Z> f15028c;

        void a() {
            this.f15026a = null;
            this.f15027b = null;
            this.f15028c = null;
        }

        void b(e eVar, j.i iVar) {
            f0.b.a("DecodeJob.encode");
            try {
                eVar.a().a(this.f15026a, new l.e(this.f15027b, this.f15028c, iVar));
            } finally {
                this.f15028c.f();
                f0.b.e();
            }
        }

        boolean c() {
            return this.f15028c != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        <X> void d(j.f fVar, j.l<X> lVar, u<X> uVar) {
            this.f15026a = fVar;
            this.f15027b = lVar;
            this.f15028c = uVar;
        }

        d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    interface e {
        n.a a();
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f15029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f15030b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f15031c;

        synchronized boolean b() {
            this.f15030b = true;
            return a(false);
        }

        synchronized boolean c() {
            this.f15031c = true;
            return a(false);
        }

        synchronized boolean d(boolean z10) {
            this.f15029a = true;
            return a(z10);
        }

        synchronized void e() {
            this.f15030b = false;
            this.f15029a = false;
            this.f15031c = false;
        }

        private boolean a(boolean z10) {
            return (this.f15031c || z10 || this.f15030b) && this.f15029a;
        }

        f() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private enum g {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* JADX INFO: renamed from: l.h$h, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private enum EnumC0298h {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    private void w(String str, long j10) {
        x(str, j10, null);
    }

    public void m() {
        this.E = true;
        l.f fVar = this.C;
        if (fVar != null) {
            fVar.cancel();
        }
    }

    h<R> v(com.bumptech.glide.e eVar, Object obj, n nVar, j.f fVar, int i10, int i11, Class<?> cls, Class<R> cls2, com.bumptech.glide.h hVar, j jVar, Map<Class<?>, j.m<?>> map, boolean z10, boolean z11, boolean z12, j.i iVar, b<R> bVar, int i12) {
        this.f14995a.v(eVar, obj, fVar, i10, i11, jVar, cls, cls2, hVar, iVar, map, z10, z11, this.f14998d);
        this.f15002h = eVar;
        this.f15003i = fVar;
        this.f15004j = hVar;
        this.f15005k = nVar;
        this.f15006l = i10;
        this.f15007m = i11;
        this.f15008n = jVar;
        this.f15015u = z12;
        this.f15009o = iVar;
        this.f15010p = bVar;
        this.f15011q = i12;
        this.f15013s = g.INITIALIZE;
        this.f15016v = obj;
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f15021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f15022b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f15023c;

        static {
            int[] iArr = new int[j.c.values().length];
            f15023c = iArr;
            try {
                iArr[j.c.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15023c[j.c.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[EnumC0298h.values().length];
            f15022b = iArr2;
            try {
                iArr2[EnumC0298h.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15022b[EnumC0298h.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15022b[EnumC0298h.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15022b[EnumC0298h.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15022b[EnumC0298h.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[g.values().length];
            f15021a = iArr3;
            try {
                iArr3[g.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f15021a[g.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f15021a[g.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void A(v<R> vVar, j.a aVar, boolean z10) {
        u uVar;
        f0.b.a("DecodeJob.notifyEncodeAndRelease");
        try {
            if (vVar instanceof r) {
                ((r) vVar).initialize();
            }
            if (this.f15000f.c()) {
                vVar = u.d(vVar);
                uVar = vVar;
            } else {
                uVar = 0;
            }
            z(vVar, aVar, z10);
            this.f15012r = EnumC0298h.ENCODE;
            try {
                if (this.f15000f.c()) {
                    this.f15000f.b(this.f14998d, this.f15009o);
                }
                if (uVar != 0) {
                    uVar.f();
                }
                C();
                f0.b.e();
            } catch (Throwable th) {
                if (uVar != 0) {
                    uVar.f();
                }
                throw th;
            }
        } catch (Throwable th2) {
            f0.b.e();
            throw th2;
        }
    }

    private void C() {
        if (this.f15001g.b()) {
            M();
        }
    }

    private void F() {
        if (this.f15001g.c()) {
            M();
        }
    }

    private void M() {
        this.f15001g.e();
        this.f15000f.a();
        this.f14995a.a();
        this.D = false;
        this.f15002h = null;
        this.f15003i = null;
        this.f15009o = null;
        this.f15004j = null;
        this.f15005k = null;
        this.f15010p = null;
        this.f15012r = null;
        this.C = null;
        this.f15017w = null;
        this.f15018x = null;
        this.f15020z = null;
        this.A = null;
        this.B = null;
        this.f15014t = 0L;
        this.E = false;
        this.f15016v = null;
        this.f14996b.clear();
        this.f14999e.release(this);
    }

    private void O(g gVar) {
        this.f15013s = gVar;
        this.f15010p.d(this);
    }

    private void R() {
        int i10 = a.f15021a[this.f15013s.ordinal()];
        if (i10 == 1) {
            this.f15012r = s(EnumC0298h.INITIALIZE);
            this.C = r();
            P();
        } else if (i10 == 2) {
            P();
        } else {
            if (i10 == 3) {
                q();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.f15013s);
        }
    }

    private void S() {
        Throwable th;
        this.f14997c.c();
        if (!this.D) {
            this.D = true;
            return;
        }
        if (this.f14996b.isEmpty()) {
            th = null;
        } else {
            List<Throwable> list = this.f14996b;
            th = list.get(list.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    private <Data> v<R> o(com.bumptech.glide.load.data.d<?> dVar, Data data, j.a aVar) {
        if (data == null) {
            dVar.b();
            return null;
        }
        try {
            long jB = e0.g.b();
            v<R> vVarP = p(data, aVar);
            if (Log.isLoggable("DecodeJob", 2)) {
                w("Decoded result " + vVarP, jB);
            }
            return vVarP;
        } finally {
            dVar.b();
        }
    }

    private <Data> v<R> p(Data data, j.a aVar) {
        return Q(data, aVar, this.f14995a.h(data.getClass()));
    }

    private void q() {
        v<R> vVarO;
        if (Log.isLoggable("DecodeJob", 2)) {
            x("Retrieved data", this.f15014t, "data: " + this.f15020z + ", cache key: " + this.f15018x + ", fetcher: " + this.B);
        }
        try {
            vVarO = o(this.B, this.f15020z, this.A);
        } catch (q e10) {
            e10.i(this.f15019y, this.A);
            this.f14996b.add(e10);
            vVarO = null;
        }
        if (vVarO != null) {
            A(vVarO, this.A, this.F);
        } else {
            P();
        }
    }

    private l.f r() {
        int i10 = a.f15022b[this.f15012r.ordinal()];
        if (i10 == 1) {
            return new w(this.f14995a, this);
        }
        if (i10 == 2) {
            return new l.c(this.f14995a, this);
        }
        if (i10 == 3) {
            return new z(this.f14995a, this);
        }
        if (i10 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.f15012r);
    }

    private EnumC0298h s(EnumC0298h enumC0298h) {
        int i10 = a.f15022b[enumC0298h.ordinal()];
        if (i10 == 1) {
            return this.f15008n.a() ? EnumC0298h.DATA_CACHE : s(EnumC0298h.DATA_CACHE);
        }
        if (i10 == 2) {
            return this.f15015u ? EnumC0298h.FINISHED : EnumC0298h.SOURCE;
        }
        if (i10 == 3 || i10 == 4) {
            return EnumC0298h.FINISHED;
        }
        if (i10 == 5) {
            return this.f15008n.b() ? EnumC0298h.RESOURCE_CACHE : s(EnumC0298h.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + enumC0298h);
    }

    @NonNull
    private j.i t(j.a aVar) {
        j.i iVar = this.f15009o;
        if (Build.VERSION.SDK_INT < 26) {
            return iVar;
        }
        boolean z10 = aVar == j.a.RESOURCE_DISK_CACHE || this.f14995a.x();
        j.h<Boolean> hVar = s.t.f18200j;
        Boolean bool = (Boolean) iVar.c(hVar);
        if (bool != null && (!bool.booleanValue() || z10)) {
            return iVar;
        }
        j.i iVar2 = new j.i();
        iVar2.d(this.f15009o);
        iVar2.f(hVar, Boolean.valueOf(z10));
        return iVar2;
    }

    private int u() {
        return this.f15004j.ordinal();
    }

    private void x(String str, long j10, String str2) {
        String str3;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" in ");
        sb2.append(e0.g.a(j10));
        sb2.append(", load key: ");
        sb2.append(this.f15005k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb2.append(str3);
        sb2.append(", thread: ");
        sb2.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb2.toString());
    }

    void J(boolean z10) {
        if (this.f15001g.d(z10)) {
            M();
        }
    }

    boolean T() {
        EnumC0298h enumC0298hS = s(EnumC0298h.INITIALIZE);
        return enumC0298hS == EnumC0298h.RESOURCE_CACHE || enumC0298hS == EnumC0298h.DATA_CACHE;
    }

    @Override // f0.a.f
    @NonNull
    public f0.c a() {
        return this.f14997c;
    }

    @Override // l.f.a
    public void j(j.f fVar, Object obj, com.bumptech.glide.load.data.d<?> dVar, j.a aVar, j.f fVar2) {
        this.f15018x = fVar;
        this.f15020z = obj;
        this.B = dVar;
        this.A = aVar;
        this.f15019y = fVar2;
        this.F = fVar != this.f14995a.c().get(0);
        if (Thread.currentThread() != this.f15017w) {
            O(g.DECODE_DATA);
            return;
        }
        f0.b.a("DecodeJob.decodeFromRetrievedData");
        try {
            q();
        } finally {
            f0.b.e();
        }
    }

    @Override // l.f.a
    public void k() {
        O(g.SWITCH_TO_SOURCE_SERVICE);
    }

    @Override // java.lang.Runnable
    public void run() {
        f0.b.c("DecodeJob#run(reason=%s, model=%s)", this.f15013s, this.f15016v);
        com.bumptech.glide.load.data.d<?> dVar = this.B;
        try {
            try {
                if (this.E) {
                    B();
                    if (dVar != null) {
                        dVar.b();
                    }
                    f0.b.e();
                    return;
                }
                R();
                if (dVar != null) {
                    dVar.b();
                }
                f0.b.e();
            } catch (Throwable th) {
                if (dVar != null) {
                    dVar.b();
                }
                f0.b.e();
                throw th;
            }
        } catch (l.b e10) {
            throw e10;
        } catch (Throwable th2) {
            if (Log.isLoggable("DecodeJob", 3)) {
                Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.E + ", stage: " + this.f15012r, th2);
            }
            if (this.f15012r != EnumC0298h.ENCODE) {
                this.f14996b.add(th2);
                B();
            }
            if (!this.E) {
                throw th2;
            }
            throw th2;
        }
    }

    h(e eVar, Pools.Pool<h<?>> pool) {
        this.f14998d = eVar;
        this.f14999e = pool;
    }

    private void B() {
        S();
        this.f15010p.b(new q("Failed to load resource", new ArrayList(this.f14996b)));
        F();
    }

    private void P() {
        this.f15017w = Thread.currentThread();
        this.f15014t = e0.g.b();
        boolean zA = false;
        while (!this.E && this.C != null && !(zA = this.C.a())) {
            this.f15012r = s(this.f15012r);
            this.C = r();
            if (this.f15012r == EnumC0298h.SOURCE) {
                O(g.SWITCH_TO_SOURCE_SERVICE);
                return;
            }
        }
        if ((this.f15012r == EnumC0298h.FINISHED || this.E) && !zA) {
            B();
        }
    }

    private <Data, ResourceType> v<R> Q(Data data, j.a aVar, t<Data, ResourceType, R> tVar) {
        j.i iVarT = t(aVar);
        com.bumptech.glide.load.data.e<Data> eVarL = this.f15002h.i().l(data);
        try {
            return tVar.a(eVarL, iVarT, this.f15006l, this.f15007m, new c(aVar));
        } finally {
            eVarL.b();
        }
    }

    private void z(v<R> vVar, j.a aVar, boolean z10) {
        S();
        this.f15010p.c(vVar, aVar, z10);
    }

    @NonNull
    <Z> v<Z> G(j.a aVar, @NonNull v<Z> vVar) {
        v<Z> vVarB;
        j.m<Z> mVar;
        j.c cVarB;
        j.f dVar;
        Class<?> cls = vVar.get().getClass();
        j.l<Z> lVarN = null;
        if (aVar != j.a.RESOURCE_DISK_CACHE) {
            j.m<Z> mVarS = this.f14995a.s(cls);
            mVar = mVarS;
            vVarB = mVarS.b(this.f15002h, vVar, this.f15006l, this.f15007m);
        } else {
            vVarB = vVar;
            mVar = null;
        }
        if (!vVar.equals(vVarB)) {
            vVar.recycle();
        }
        if (this.f14995a.w(vVarB)) {
            lVarN = this.f14995a.n(vVarB);
            cVarB = lVarN.b(this.f15009o);
        } else {
            cVarB = j.c.NONE;
        }
        j.l lVar = lVarN;
        if (this.f15008n.d(!this.f14995a.y(this.f15018x), aVar, cVarB)) {
            if (lVar != null) {
                int i10 = a.f15023c[cVarB.ordinal()];
                if (i10 != 1) {
                    if (i10 == 2) {
                        dVar = new x(this.f14995a.b(), this.f15018x, this.f15003i, this.f15006l, this.f15007m, mVar, cls, this.f15009o);
                    } else {
                        throw new IllegalArgumentException("Unknown strategy: " + cVarB);
                    }
                } else {
                    dVar = new l.d(this.f15018x, this.f15003i);
                }
                u uVarD = u.d(vVarB);
                this.f15000f.d(dVar, lVar, uVarD);
                return uVarD;
            }
            throw new com.bumptech.glide.i.d(vVarB.get().getClass());
        }
        return vVarB;
    }

    @Override // l.f.a
    public void f(j.f fVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, j.a aVar) {
        dVar.b();
        q qVar = new q("Fetching data failed", exc);
        qVar.j(fVar, aVar, dVar.a());
        this.f14996b.add(qVar);
        if (Thread.currentThread() != this.f15017w) {
            O(g.SWITCH_TO_SOURCE_SERVICE);
        } else {
            P();
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull h<?> hVar) {
        int iU = u() - hVar.u();
        if (iU == 0) {
            return this.f15011q - hVar.f15011q;
        }
        return iU;
    }
}
