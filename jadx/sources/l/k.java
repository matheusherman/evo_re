package l;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class k implements m, n.h.a, p.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final boolean f15053i = Log.isLoggable("Engine", 2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f15054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o f15055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final n.h f15056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f15057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final y f15058e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f15059f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a f15060g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final l.a f15061h;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @VisibleForTesting
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final o.a f15066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final o.a f15067b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final o.a f15068c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final o.a f15069d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final m f15070e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final p.a f15071f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Pools.Pool<l<?>> f15072g = f0.a.d(150, new a());

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a implements f0.a.d<l<?>> {
            a() {
            }

            @Override // f0.a.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public l<?> a() {
                b bVar = b.this;
                return new l<>(bVar.f15066a, bVar.f15067b, bVar.f15068c, bVar.f15069d, bVar.f15070e, bVar.f15071f, bVar.f15072g);
            }
        }

        <R> l<R> a(j.f fVar, boolean z10, boolean z11, boolean z12, boolean z13) {
            return ((l) e0.k.d(this.f15072g.acquire())).l(fVar, z10, z11, z12, z13);
        }

        b(o.a aVar, o.a aVar2, o.a aVar3, o.a aVar4, m mVar, p.a aVar5) {
            this.f15066a = aVar;
            this.f15067b = aVar2;
            this.f15068c = aVar3;
            this.f15069d = aVar4;
            this.f15070e = mVar;
            this.f15071f = aVar5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class c implements h.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final n.a.InterfaceC0306a f15074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile n.a f15075b;

        @Override // l.h.e
        public n.a a() {
            if (this.f15075b == null) {
                synchronized (this) {
                    try {
                        if (this.f15075b == null) {
                            this.f15075b = this.f15074a.build();
                        }
                        if (this.f15075b == null) {
                            this.f15075b = new n.b();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return this.f15075b;
        }

        c(n.a.InterfaceC0306a interfaceC0306a) {
            this.f15074a = interfaceC0306a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final l<?> f15076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a0.j f15077b;

        d(a0.j jVar, l<?> lVar) {
            this.f15077b = jVar;
            this.f15076a = lVar;
        }

        public void a() {
            synchronized (k.this) {
                this.f15076a.r(this.f15077b);
            }
        }
    }

    public k(n.h hVar, n.a.InterfaceC0306a interfaceC0306a, o.a aVar, o.a aVar2, o.a aVar3, o.a aVar4, boolean z10) {
        this(hVar, interfaceC0306a, aVar, aVar2, aVar3, aVar4, null, null, null, null, null, null, z10);
    }

    @Nullable
    private p<?> i(n nVar, boolean z10, long j10) {
        if (!z10) {
            return null;
        }
        p<?> pVarG = g(nVar);
        if (pVarG != null) {
            if (f15053i) {
                j("Loaded resource from active resources", j10, nVar);
            }
            return pVarG;
        }
        p<?> pVarH = h(nVar);
        if (pVarH == null) {
            return null;
        }
        if (f15053i) {
            j("Loaded resource from cache", j10, nVar);
        }
        return pVarH;
    }

    private <R> d l(com.bumptech.glide.e eVar, Object obj, j.f fVar, int i10, int i11, Class<?> cls, Class<R> cls2, com.bumptech.glide.h hVar, j jVar, Map<Class<?>, j.m<?>> map, boolean z10, boolean z11, j.i iVar, boolean z12, boolean z13, boolean z14, boolean z15, a0.j jVar2, Executor executor, n nVar, long j10) {
        l<?> lVarA = this.f15054a.a(nVar, z15);
        if (lVarA != null) {
            lVarA.e(jVar2, executor);
            if (f15053i) {
                j("Added to existing load", j10, nVar);
            }
            return new d(jVar2, lVarA);
        }
        l<R> lVarA2 = this.f15057d.a(nVar, z12, z13, z14, z15);
        h<R> hVarA = this.f15060g.a(eVar, obj, nVar, fVar, i10, i11, cls, cls2, hVar, jVar, map, z10, z11, z15, iVar, lVarA2);
        this.f15054a.c(nVar, lVarA2);
        lVarA2.e(jVar2, executor);
        lVarA2.s(hVarA);
        if (f15053i) {
            j("Started new load", j10, nVar);
        }
        return new d(jVar2, lVarA2);
    }

    @Override // l.m
    public synchronized void c(l<?> lVar, j.f fVar, p<?> pVar) {
        if (pVar != null) {
            try {
                if (pVar.d()) {
                    this.f15061h.a(fVar, pVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f15054a.d(fVar, lVar);
    }

    @Override // l.m
    public synchronized void d(l<?> lVar, j.f fVar) {
        this.f15054a.d(fVar, lVar);
    }

    public <R> d f(com.bumptech.glide.e eVar, Object obj, j.f fVar, int i10, int i11, Class<?> cls, Class<R> cls2, com.bumptech.glide.h hVar, j jVar, Map<Class<?>, j.m<?>> map, boolean z10, boolean z11, j.i iVar, boolean z12, boolean z13, boolean z14, boolean z15, a0.j jVar2, Executor executor) {
        long jB = f15053i ? e0.g.b() : 0L;
        n nVarA = this.f15055b.a(obj, fVar, i10, i11, map, cls, cls2, iVar);
        synchronized (this) {
            try {
                p<?> pVarI = i(nVarA, z12, jB);
                if (pVarI == null) {
                    return l(eVar, obj, fVar, i10, i11, cls, cls2, hVar, jVar, map, z10, z11, iVar, z12, z13, z14, z15, jVar2, executor, nVarA, jB);
                }
                jVar2.c(pVarI, j.a.MEMORY_CACHE, false);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @VisibleForTesting
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final h.e f15062a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Pools.Pool<h<?>> f15063b = f0.a.d(150, new C0299a());

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f15064c;

        /* JADX INFO: renamed from: l.k$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class C0299a implements f0.a.d<h<?>> {
            C0299a() {
            }

            @Override // f0.a.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public h<?> a() {
                a aVar = a.this;
                return new h<>(aVar.f15062a, aVar.f15063b);
            }
        }

        <R> h<R> a(com.bumptech.glide.e eVar, Object obj, n nVar, j.f fVar, int i10, int i11, Class<?> cls, Class<R> cls2, com.bumptech.glide.h hVar, j jVar, Map<Class<?>, j.m<?>> map, boolean z10, boolean z11, boolean z12, j.i iVar, h.b<R> bVar) {
            h hVar2 = (h) e0.k.d(this.f15063b.acquire());
            int i12 = this.f15064c;
            this.f15064c = i12 + 1;
            return hVar2.v(eVar, obj, nVar, fVar, i10, i11, cls, cls2, hVar, jVar, map, z10, z11, z12, iVar, bVar, i12);
        }

        a(h.e eVar) {
            this.f15062a = eVar;
        }
    }

    @VisibleForTesting
    k(n.h hVar, n.a.InterfaceC0306a interfaceC0306a, o.a aVar, o.a aVar2, o.a aVar3, o.a aVar4, s sVar, o oVar, l.a aVar5, b bVar, a aVar6, y yVar, boolean z10) {
        this.f15056c = hVar;
        c cVar = new c(interfaceC0306a);
        this.f15059f = cVar;
        l.a aVar7 = aVar5 == null ? new l.a(z10) : aVar5;
        this.f15061h = aVar7;
        aVar7.f(this);
        this.f15055b = oVar == null ? new o() : oVar;
        this.f15054a = sVar == null ? new s() : sVar;
        this.f15057d = bVar == null ? new b(aVar, aVar2, aVar3, aVar4, this, this) : bVar;
        this.f15060g = aVar6 == null ? new a(cVar) : aVar6;
        this.f15058e = yVar == null ? new y() : yVar;
        hVar.e(this);
    }

    private p<?> e(j.f fVar) {
        v<?> vVarD = this.f15056c.d(fVar);
        if (vVarD == null) {
            return null;
        }
        return vVarD instanceof p ? (p) vVarD : new p<>(vVarD, true, true, fVar, this);
    }

    @Nullable
    private p<?> g(j.f fVar) {
        p<?> pVarE = this.f15061h.e(fVar);
        if (pVarE != null) {
            pVarE.a();
        }
        return pVarE;
    }

    private static void j(String str, long j10, j.f fVar) {
        Log.v("Engine", str + " in " + e0.g.a(j10) + "ms, key: " + fVar);
    }

    @Override // l.p.a
    public void a(j.f fVar, p<?> pVar) {
        this.f15061h.d(fVar);
        if (pVar.d()) {
            this.f15056c.c(fVar, pVar);
        } else {
            this.f15058e.a(pVar, false);
        }
    }

    @Override // n.h.a
    public void b(@NonNull v<?> vVar) {
        this.f15058e.a(vVar, true);
    }

    public void k(v<?> vVar) {
        if (!(vVar instanceof p)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((p) vVar).e();
    }

    private p<?> h(j.f fVar) {
        p<?> pVarE = e(fVar);
        if (pVarE != null) {
            pVarE.a();
            this.f15061h.a(fVar, pVarE);
        }
        return pVarE;
    }
}
