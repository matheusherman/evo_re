package a0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import j.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import l.q;
import l.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public final class k<R> implements e, b0.h, j {
    private static final boolean E = Log.isLoggable("GlideRequest", 2);

    @GuardedBy("requestLock")
    private int A;

    @GuardedBy("requestLock")
    private int B;

    @GuardedBy("requestLock")
    private boolean C;

    @Nullable
    private RuntimeException D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f55a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f56b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f0.c f57c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f58d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final h<R> f59e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final f f60f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f61g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.e f62h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private final Object f63i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Class<R> f64j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final a0.a<?> f65k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f66l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f67m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.bumptech.glide.h f68n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final b0.i<R> f69o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private final List<h<R>> f70p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final c0.c<? super R> f71q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Executor f72r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @GuardedBy("requestLock")
    private v<R> f73s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @GuardedBy("requestLock")
    private l.k.d f74t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @GuardedBy("requestLock")
    private long f75u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private volatile l.k f76v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @GuardedBy("requestLock")
    private a f77w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    @GuardedBy("requestLock")
    private Drawable f78x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    @GuardedBy("requestLock")
    private Drawable f79y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    @GuardedBy("requestLock")
    private Drawable f80z;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private k(Context context, com.bumptech.glide.e eVar, @NonNull Object obj, @Nullable Object obj2, Class<R> cls, a0.a<?> aVar, int i10, int i11, com.bumptech.glide.h hVar, b0.i<R> iVar, @Nullable h<R> hVar2, @Nullable List<h<R>> list, f fVar, l.k kVar, c0.c<? super R> cVar, Executor executor) {
        this.f56b = E ? String.valueOf(super.hashCode()) : null;
        this.f57c = f0.c.a();
        this.f58d = obj;
        this.f61g = context;
        this.f62h = eVar;
        this.f63i = obj2;
        this.f64j = cls;
        this.f65k = aVar;
        this.f66l = i10;
        this.f67m = i11;
        this.f68n = hVar;
        this.f69o = iVar;
        this.f59e = hVar2;
        this.f70p = list;
        this.f60f = fVar;
        this.f76v = kVar;
        this.f71q = cVar;
        this.f72r = executor;
        this.f77w = a.PENDING;
        if (this.D == null && eVar.g().a(com.bumptech.glide.d.c.class)) {
            this.D = new RuntimeException("Glide request origin trace");
        }
    }

    public static <R> k<R> y(Context context, com.bumptech.glide.e eVar, Object obj, Object obj2, Class<R> cls, a0.a<?> aVar, int i10, int i11, com.bumptech.glide.h hVar, b0.i<R> iVar, h<R> hVar2, @Nullable List<h<R>> list, f fVar, l.k kVar, c0.c<? super R> cVar, Executor executor) {
        return new k<>(context, eVar, obj, obj2, cls, aVar, i10, i11, hVar, iVar, hVar2, list, fVar, kVar, cVar, executor);
    }

    @Override // a0.j
    public void b(q qVar) {
        z(qVar, 5);
    }

    @GuardedBy("requestLock")
    private void i() {
        if (this.C) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @GuardedBy("requestLock")
    private boolean k() {
        f fVar = this.f60f;
        return fVar == null || fVar.c(this);
    }

    @GuardedBy("requestLock")
    private boolean l() {
        f fVar = this.f60f;
        return fVar == null || fVar.e(this);
    }

    @GuardedBy("requestLock")
    private boolean m() {
        f fVar = this.f60f;
        return fVar == null || fVar.f(this);
    }

    private void o(Object obj) {
        List<h<R>> list = this.f70p;
        if (list == null) {
            return;
        }
        for (h<R> hVar : list) {
            if (hVar instanceof c) {
                ((c) hVar).a(obj);
            }
        }
    }

    @GuardedBy("requestLock")
    private Drawable p() {
        if (this.f78x == null) {
            Drawable drawableL = this.f65k.l();
            this.f78x = drawableL;
            if (drawableL == null && this.f65k.k() > 0) {
                this.f78x = t(this.f65k.k());
            }
        }
        return this.f78x;
    }

    @GuardedBy("requestLock")
    private Drawable q() {
        if (this.f80z == null) {
            Drawable drawableM = this.f65k.m();
            this.f80z = drawableM;
            if (drawableM == null && this.f65k.n() > 0) {
                this.f80z = t(this.f65k.n());
            }
        }
        return this.f80z;
    }

    @GuardedBy("requestLock")
    private Drawable r() {
        if (this.f79y == null) {
            Drawable drawableT = this.f65k.t();
            this.f79y = drawableT;
            if (drawableT == null && this.f65k.u() > 0) {
                this.f79y = t(this.f65k.u());
            }
        }
        return this.f79y;
    }

    @GuardedBy("requestLock")
    private boolean s() {
        f fVar = this.f60f;
        return fVar == null || !fVar.getRoot().a();
    }

    @GuardedBy("requestLock")
    private Drawable t(@DrawableRes int i10) {
        return u.h.a(this.f61g, i10, this.f65k.A() != null ? this.f65k.A() : this.f61g.getTheme());
    }

    private void u(String str) {
        Log.v("GlideRequest", str + " this: " + this.f56b);
    }

    private static int v(int i10, float f10) {
        return i10 == Integer.MIN_VALUE ? i10 : Math.round(f10 * i10);
    }

    @GuardedBy("requestLock")
    private void w() {
        f fVar = this.f60f;
        if (fVar != null) {
            fVar.i(this);
        }
    }

    @GuardedBy("requestLock")
    private void x() {
        f fVar = this.f60f;
        if (fVar != null) {
            fVar.b(this);
        }
    }

    private void z(q qVar, int i10) {
        boolean zE;
        this.f57c.c();
        synchronized (this.f58d) {
            try {
                qVar.k(this.D);
                int iH = this.f62h.h();
                if (iH <= i10) {
                    Log.w("Glide", "Load failed for [" + this.f63i + "] with dimensions [" + this.A + "x" + this.B + "]", qVar);
                    if (iH <= 4) {
                        qVar.g("Glide");
                    }
                }
                this.f74t = null;
                this.f77w = a.FAILED;
                w();
                boolean z10 = true;
                this.C = true;
                try {
                    List<h<R>> list = this.f70p;
                    if (list != null) {
                        Iterator<h<R>> it = list.iterator();
                        zE = false;
                        while (it.hasNext()) {
                            zE |= it.next().e(qVar, this.f63i, this.f69o, s());
                        }
                    } else {
                        zE = false;
                    }
                    h<R> hVar = this.f59e;
                    if (hVar == null || !hVar.e(qVar, this.f63i, this.f69o, s())) {
                        z10 = false;
                    }
                    if (!(zE | z10)) {
                        B();
                    }
                    this.C = false;
                    f0.b.f("GlideRequest", this.f55a);
                } catch (Throwable th) {
                    this.C = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // a0.e
    public boolean a() {
        boolean z10;
        synchronized (this.f58d) {
            z10 = this.f77w == a.COMPLETE;
        }
        return z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a0.j
    public void c(v<?> vVar, j.a aVar, boolean z10) {
        this.f57c.c();
        v<?> vVar2 = null;
        try {
            synchronized (this.f58d) {
                try {
                    this.f74t = null;
                    if (vVar == null) {
                        b(new q("Expected to receive a Resource<R> with an object of " + this.f64j + " inside, but instead got null."));
                        return;
                    }
                    Object obj = vVar.get();
                    try {
                        if (obj == null || !this.f64j.isAssignableFrom(obj.getClass())) {
                            this.f73s = null;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Expected to receive an object of ");
                            sb2.append(this.f64j);
                            sb2.append(" but instead got ");
                            sb2.append(obj != null ? obj.getClass() : "");
                            sb2.append("{");
                            sb2.append(obj);
                            sb2.append("} inside Resource{");
                            sb2.append(vVar);
                            sb2.append("}.");
                            sb2.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                            b(new q(sb2.toString()));
                        } else if (m()) {
                            A(vVar, obj, aVar, z10);
                            return;
                        } else {
                            this.f73s = null;
                            this.f77w = a.COMPLETE;
                            f0.b.f("GlideRequest", this.f55a);
                        }
                        this.f76v.k(vVar);
                    } catch (Throwable th) {
                        vVar2 = vVar;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (vVar2 != null) {
                this.f76v.k(vVar2);
            }
            throw th3;
        }
    }

    @Override // a0.e
    public void clear() {
        synchronized (this.f58d) {
            try {
                i();
                this.f57c.c();
                a aVar = this.f77w;
                a aVar2 = a.CLEARED;
                if (aVar == aVar2) {
                    return;
                }
                n();
                v<R> vVar = this.f73s;
                if (vVar != null) {
                    this.f73s = null;
                } else {
                    vVar = null;
                }
                if (k()) {
                    this.f69o.n(r());
                }
                f0.b.f("GlideRequest", this.f55a);
                this.f77w = aVar2;
                if (vVar != null) {
                    this.f76v.k(vVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a0.e
    public boolean d(e eVar) {
        int i10;
        int i11;
        Object obj;
        Class<R> cls;
        a0.a<?> aVar;
        com.bumptech.glide.h hVar;
        int size;
        int i12;
        int i13;
        Object obj2;
        Class<R> cls2;
        a0.a<?> aVar2;
        com.bumptech.glide.h hVar2;
        int size2;
        if (!(eVar instanceof k)) {
            return false;
        }
        synchronized (this.f58d) {
            try {
                i10 = this.f66l;
                i11 = this.f67m;
                obj = this.f63i;
                cls = this.f64j;
                aVar = this.f65k;
                hVar = this.f68n;
                List<h<R>> list = this.f70p;
                size = list != null ? list.size() : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        k kVar = (k) eVar;
        synchronized (kVar.f58d) {
            try {
                i12 = kVar.f66l;
                i13 = kVar.f67m;
                obj2 = kVar.f63i;
                cls2 = kVar.f64j;
                aVar2 = kVar.f65k;
                hVar2 = kVar.f68n;
                List<h<R>> list2 = kVar.f70p;
                size2 = list2 != null ? list2.size() : 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return i10 == i12 && i11 == i13 && e0.l.c(obj, obj2) && cls.equals(cls2) && aVar.equals(aVar2) && hVar == hVar2 && size == size2;
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
    @Override // b0.h
    public void e(int i10, int i11) throws Throwable {
        Object obj;
        k<R> kVar = this;
        kVar.f57c.c();
        Object obj2 = kVar.f58d;
        synchronized (obj2) {
            try {
                try {
                    boolean z10 = E;
                    if (z10) {
                        kVar.u("Got onSizeReady in " + e0.g.a(kVar.f75u));
                    }
                    if (kVar.f77w == a.WAITING_FOR_SIZE) {
                        a aVar = a.RUNNING;
                        kVar.f77w = aVar;
                        float fZ = kVar.f65k.z();
                        kVar.A = v(i10, fZ);
                        kVar.B = v(i11, fZ);
                        if (z10) {
                            kVar.u("finished setup for calling load in " + e0.g.a(kVar.f75u));
                        }
                        try {
                            l.k kVar2 = kVar.f76v;
                            com.bumptech.glide.e eVar = kVar.f62h;
                            try {
                                Object obj3 = kVar.f63i;
                                j.f fVarY = kVar.f65k.y();
                                try {
                                    int i12 = kVar.A;
                                    int i13 = kVar.B;
                                    Class<?> clsX = kVar.f65k.x();
                                    Class<R> cls = kVar.f64j;
                                    try {
                                        com.bumptech.glide.h hVar = kVar.f68n;
                                        l.j jVarJ = kVar.f65k.j();
                                        Map<Class<?>, m<?>> mapC = kVar.f65k.C();
                                        boolean zO = kVar.f65k.O();
                                        boolean zI = kVar.f65k.I();
                                        j.i iVarP = kVar.f65k.p();
                                        boolean zG = kVar.f65k.G();
                                        boolean zE = kVar.f65k.E();
                                        boolean zD = kVar.f65k.D();
                                        boolean zO2 = kVar.f65k.o();
                                        Executor executor = kVar.f72r;
                                        Object obj4 = obj2;
                                        try {
                                            kVar.f74t = kVar2.f(eVar, obj3, fVarY, i12, i13, clsX, cls, hVar, jVarJ, mapC, zO, zI, iVarP, zG, zE, zD, zO2, kVar, executor);
                                            if (kVar.f77w != aVar) {
                                                kVar.f74t = null;
                                            }
                                            if (z10) {
                                                kVar.u("finished onSizeReady in " + e0.g.a(kVar.f75u));
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            obj = obj4;
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        obj = obj2;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    obj = obj2;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                obj = obj2;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            obj = obj2;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    obj = obj2;
                }
            } catch (Throwable th7) {
                th = th7;
                obj = kVar;
            }
        }
    }

    @Override // a0.j
    public Object f() {
        this.f57c.c();
        return this.f58d;
    }

    @Override // a0.e
    public boolean g() {
        boolean z10;
        synchronized (this.f58d) {
            z10 = this.f77w == a.CLEARED;
        }
        return z10;
    }

    @Override // a0.e
    public void h() {
        synchronized (this.f58d) {
            try {
                i();
                this.f57c.c();
                this.f75u = e0.g.b();
                Object obj = this.f63i;
                if (obj == null) {
                    if (e0.l.u(this.f66l, this.f67m)) {
                        this.A = this.f66l;
                        this.B = this.f67m;
                    }
                    z(new q("Received null model"), q() == null ? 5 : 3);
                    return;
                }
                a aVar = this.f77w;
                a aVar2 = a.RUNNING;
                if (aVar == aVar2) {
                    throw new IllegalArgumentException("Cannot restart a running request");
                }
                if (aVar == a.COMPLETE) {
                    c(this.f73s, j.a.MEMORY_CACHE, false);
                    return;
                }
                o(obj);
                this.f55a = f0.b.b("GlideRequest");
                a aVar3 = a.WAITING_FOR_SIZE;
                this.f77w = aVar3;
                if (e0.l.u(this.f66l, this.f67m)) {
                    e(this.f66l, this.f67m);
                } else {
                    this.f69o.j(this);
                }
                a aVar4 = this.f77w;
                if ((aVar4 == aVar2 || aVar4 == aVar3) && l()) {
                    this.f69o.k(r());
                }
                if (E) {
                    u("finished run method in " + e0.g.a(this.f75u));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a0.e
    public boolean isRunning() {
        boolean z10;
        synchronized (this.f58d) {
            try {
                a aVar = this.f77w;
                z10 = aVar == a.RUNNING || aVar == a.WAITING_FOR_SIZE;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    @Override // a0.e
    public boolean j() {
        boolean z10;
        synchronized (this.f58d) {
            z10 = this.f77w == a.COMPLETE;
        }
        return z10;
    }

    @Override // a0.e
    public void pause() {
        synchronized (this.f58d) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        Object obj;
        Class<R> cls;
        synchronized (this.f58d) {
            obj = this.f63i;
            cls = this.f64j;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }

    @GuardedBy("requestLock")
    private void A(v<R> vVar, R r10, j.a aVar, boolean z10) {
        boolean zC;
        boolean zS = s();
        this.f77w = a.COMPLETE;
        this.f73s = vVar;
        if (this.f62h.h() <= 3) {
            Log.d("Glide", "Finished loading " + r10.getClass().getSimpleName() + " from " + aVar + " for " + this.f63i + " with size [" + this.A + "x" + this.B + "] in " + e0.g.a(this.f75u) + " ms");
        }
        x();
        boolean z11 = true;
        this.C = true;
        try {
            List<h<R>> list = this.f70p;
            if (list != null) {
                Iterator<h<R>> it = list.iterator();
                zC = false;
                while (it.hasNext()) {
                    R r11 = r10;
                    j.a aVar2 = aVar;
                    zC |= it.next().c(r11, this.f63i, this.f69o, aVar2, zS);
                    r10 = r11;
                    aVar = aVar2;
                }
            } else {
                zC = false;
            }
            R r12 = r10;
            j.a aVar3 = aVar;
            h<R> hVar = this.f59e;
            if (hVar == null || !hVar.c(r12, this.f63i, this.f69o, aVar3, zS)) {
                z11 = false;
            }
            if (!(z11 | zC)) {
                this.f69o.b(r12, this.f71q.a(aVar3, zS));
            }
            this.C = false;
            f0.b.f("GlideRequest", this.f55a);
        } catch (Throwable th) {
            this.C = false;
            throw th;
        }
    }

    @GuardedBy("requestLock")
    private void B() {
        Drawable drawableR;
        if (!l()) {
            return;
        }
        if (this.f63i == null) {
            drawableR = q();
        } else {
            drawableR = null;
        }
        if (drawableR == null) {
            drawableR = p();
        }
        if (drawableR == null) {
            drawableR = r();
        }
        this.f69o.g(drawableR);
    }

    @GuardedBy("requestLock")
    private void n() {
        i();
        this.f57c.c();
        this.f69o.a(this);
        l.k.d dVar = this.f74t;
        if (dVar != null) {
            dVar.a();
            this.f74t = null;
        }
    }
}
