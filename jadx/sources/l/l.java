package l;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class l<R> implements h.b<R>, f0.a.f {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final c f15079z = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final e f15080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f0.c f15081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final p.a f15082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Pools.Pool<l<?>> f15083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c f15084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final m f15085f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final o.a f15086g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final o.a f15087h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final o.a f15088i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final o.a f15089j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AtomicInteger f15090k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private j.f f15091l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f15092m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f15093n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f15094o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f15095p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private v<?> f15096q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    j.a f15097r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f15098s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    q f15099t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f15100u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    p<?> f15101v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private h<R> f15102w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private volatile boolean f15103x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f15104y;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a0.j f15105a;

        a(a0.j jVar) {
            this.f15105a = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f15105a.f()) {
                synchronized (l.this) {
                    try {
                        if (l.this.f15080a.f(this.f15105a)) {
                            l.this.f(this.f15105a);
                        }
                        l.this.i();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a0.j f15107a;

        b(a0.j jVar) {
            this.f15107a = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f15107a.f()) {
                synchronized (l.this) {
                    try {
                        if (l.this.f15080a.f(this.f15107a)) {
                            l.this.f15101v.a();
                            l.this.g(this.f15107a);
                            l.this.r(this.f15107a);
                        }
                        l.this.i();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @VisibleForTesting
    static class c {
        public <R> p<R> a(v<R> vVar, boolean z10, j.f fVar, p.a aVar) {
            return new p<>(vVar, z10, true, fVar, aVar);
        }

        c() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a0.j f15109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f15110b;

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f15109a.equals(((d) obj).f15109a);
            }
            return false;
        }

        public int hashCode() {
            return this.f15109a.hashCode();
        }

        d(a0.j jVar, Executor executor) {
            this.f15109a = jVar;
            this.f15110b = executor;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class e implements Iterable<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<d> f15111a;

        e() {
            this(new ArrayList(2));
        }

        e(List<d> list) {
            this.f15111a = list;
        }

        private static d h(a0.j jVar) {
            return new d(jVar, e0.e.a());
        }

        void clear() {
            this.f15111a.clear();
        }

        void e(a0.j jVar, Executor executor) {
            this.f15111a.add(new d(jVar, executor));
        }

        boolean f(a0.j jVar) {
            return this.f15111a.contains(h(jVar));
        }

        e g() {
            return new e(new ArrayList(this.f15111a));
        }

        void i(a0.j jVar) {
            this.f15111a.remove(h(jVar));
        }

        boolean isEmpty() {
            return this.f15111a.isEmpty();
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<d> iterator() {
            return this.f15111a.iterator();
        }

        int size() {
            return this.f15111a.size();
        }
    }

    l(o.a aVar, o.a aVar2, o.a aVar3, o.a aVar4, m mVar, p.a aVar5, Pools.Pool<l<?>> pool) {
        this(aVar, aVar2, aVar3, aVar4, mVar, aVar5, pool, f15079z);
    }

    private synchronized void q() {
        if (this.f15091l == null) {
            throw new IllegalArgumentException();
        }
        this.f15080a.clear();
        this.f15091l = null;
        this.f15101v = null;
        this.f15096q = null;
        this.f15100u = false;
        this.f15103x = false;
        this.f15098s = false;
        this.f15104y = false;
        this.f15102w.J(false);
        this.f15102w = null;
        this.f15099t = null;
        this.f15097r = null;
        this.f15083d.release(this);
    }

    @Override // l.h.b
    public void b(q qVar) {
        synchronized (this) {
            this.f15099t = qVar;
        }
        n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // l.h.b
    public void c(v<R> vVar, j.a aVar, boolean z10) {
        synchronized (this) {
            this.f15096q = vVar;
            this.f15097r = aVar;
            this.f15104y = z10;
        }
        o();
    }

    synchronized void e(a0.j jVar, Executor executor) {
        try {
            this.f15081b.c();
            this.f15080a.e(jVar, executor);
            if (this.f15098s) {
                k(1);
                executor.execute(new b(jVar));
            } else if (this.f15100u) {
                k(1);
                executor.execute(new a(jVar));
            } else {
                e0.k.a(!this.f15103x, "Cannot add callbacks to a cancelled EngineJob");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    void i() {
        p<?> pVar;
        synchronized (this) {
            try {
                this.f15081b.c();
                e0.k.a(m(), "Not yet complete!");
                int iDecrementAndGet = this.f15090k.decrementAndGet();
                e0.k.a(iDecrementAndGet >= 0, "Can't decrement below 0");
                if (iDecrementAndGet == 0) {
                    pVar = this.f15101v;
                    q();
                } else {
                    pVar = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (pVar != null) {
            pVar.e();
        }
    }

    synchronized void k(int i10) {
        p<?> pVar;
        e0.k.a(m(), "Not yet complete!");
        if (this.f15090k.getAndAdd(i10) == 0 && (pVar = this.f15101v) != null) {
            pVar.a();
        }
    }

    @VisibleForTesting
    synchronized l<R> l(j.f fVar, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f15091l = fVar;
        this.f15092m = z10;
        this.f15093n = z11;
        this.f15094o = z12;
        this.f15095p = z13;
        return this;
    }

    void n() {
        synchronized (this) {
            try {
                this.f15081b.c();
                if (this.f15103x) {
                    q();
                    return;
                }
                if (this.f15080a.isEmpty()) {
                    throw new IllegalStateException("Received an exception without any callbacks to notify");
                }
                if (this.f15100u) {
                    throw new IllegalStateException("Already failed once");
                }
                this.f15100u = true;
                j.f fVar = this.f15091l;
                e eVarG = this.f15080a.g();
                k(eVarG.size() + 1);
                this.f15085f.c(this, fVar, null);
                for (d dVar : eVarG) {
                    dVar.f15110b.execute(new a(dVar.f15109a));
                }
                i();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    void o() {
        synchronized (this) {
            try {
                this.f15081b.c();
                if (this.f15103x) {
                    this.f15096q.recycle();
                    q();
                    return;
                }
                if (this.f15080a.isEmpty()) {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                }
                if (this.f15098s) {
                    throw new IllegalStateException("Already have resource");
                }
                this.f15101v = this.f15084e.a(this.f15096q, this.f15092m, this.f15091l, this.f15082c);
                this.f15098s = true;
                e eVarG = this.f15080a.g();
                k(eVarG.size() + 1);
                this.f15085f.c(this, this.f15091l, this.f15101v);
                for (d dVar : eVarG) {
                    dVar.f15110b.execute(new b(dVar.f15109a));
                }
                i();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    synchronized void r(a0.j jVar) {
        try {
            this.f15081b.c();
            this.f15080a.i(jVar);
            if (this.f15080a.isEmpty()) {
                h();
                if (this.f15098s || this.f15100u) {
                    if (this.f15090k.get() == 0) {
                        q();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void s(h<R> hVar) {
        try {
            this.f15102w = hVar;
            (hVar.T() ? this.f15086g : j()).execute(hVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    @VisibleForTesting
    l(o.a aVar, o.a aVar2, o.a aVar3, o.a aVar4, m mVar, p.a aVar5, Pools.Pool<l<?>> pool, c cVar) {
        this.f15080a = new e();
        this.f15081b = f0.c.a();
        this.f15090k = new AtomicInteger();
        this.f15086g = aVar;
        this.f15087h = aVar2;
        this.f15088i = aVar3;
        this.f15089j = aVar4;
        this.f15085f = mVar;
        this.f15082c = aVar5;
        this.f15083d = pool;
        this.f15084e = cVar;
    }

    private o.a j() {
        if (this.f15093n) {
            return this.f15088i;
        }
        return this.f15094o ? this.f15089j : this.f15087h;
    }

    private boolean m() {
        return this.f15100u || this.f15098s || this.f15103x;
    }

    @Override // f0.a.f
    @NonNull
    public f0.c a() {
        return this.f15081b;
    }

    @GuardedBy("this")
    void f(a0.j jVar) {
        try {
            jVar.b(this.f15099t);
        } catch (Throwable th) {
            throw new l.b(th);
        }
    }

    @GuardedBy("this")
    void g(a0.j jVar) {
        try {
            jVar.c(this.f15101v, this.f15097r, this.f15104y);
        } catch (Throwable th) {
            throw new l.b(th);
        }
    }

    boolean p() {
        return this.f15095p;
    }

    @Override // l.h.b
    public void d(h<?> hVar) {
        j().execute(hVar);
    }

    void h() {
        if (m()) {
            return;
        }
        this.f15103x = true;
        this.f15102w.m();
        this.f15085f.d(this, this.f15091l);
    }
}
