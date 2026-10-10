package l;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class g<Transcode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<p.o.a<?>> f14977a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<j.f> f14978b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.e f14979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f14980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14981e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f14982f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Class<?> f14983g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private h.e f14984h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private j.i f14985i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map<Class<?>, j.m<?>> f14986j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Class<Transcode> f14987k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f14988l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f14989m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private j.f f14990n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private com.bumptech.glide.h f14991o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private j f14992p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f14993q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f14994r;

    void a() {
        this.f14979c = null;
        this.f14980d = null;
        this.f14990n = null;
        this.f14983g = null;
        this.f14987k = null;
        this.f14985i = null;
        this.f14991o = null;
        this.f14986j = null;
        this.f14992p = null;
        this.f14977a.clear();
        this.f14988l = false;
        this.f14978b.clear();
        this.f14989m = false;
    }

    m.b b() {
        return this.f14979c.b();
    }

    List<j.f> c() {
        if (!this.f14989m) {
            this.f14989m = true;
            this.f14978b.clear();
            List<p.o.a<?>> listG = g();
            int size = listG.size();
            for (int i10 = 0; i10 < size; i10++) {
                p.o.a<?> aVar = listG.get(i10);
                if (!this.f14978b.contains(aVar.f17201a)) {
                    this.f14978b.add(aVar.f17201a);
                }
                for (int i11 = 0; i11 < aVar.f17202b.size(); i11++) {
                    if (!this.f14978b.contains(aVar.f17202b.get(i11))) {
                        this.f14978b.add(aVar.f17202b.get(i11));
                    }
                }
            }
        }
        return this.f14978b;
    }

    n.a d() {
        return this.f14984h.a();
    }

    j e() {
        return this.f14992p;
    }

    int f() {
        return this.f14982f;
    }

    List<p.o.a<?>> g() {
        if (!this.f14988l) {
            this.f14988l = true;
            this.f14977a.clear();
            List listI = this.f14979c.i().i(this.f14980d);
            int size = listI.size();
            for (int i10 = 0; i10 < size; i10++) {
                p.o.a<?> aVarB = ((p.o) listI.get(i10)).b(this.f14980d, this.f14981e, this.f14982f, this.f14985i);
                if (aVarB != null) {
                    this.f14977a.add(aVarB);
                }
            }
        }
        return this.f14977a;
    }

    <Data> t<Data, ?, Transcode> h(Class<Data> cls) {
        return this.f14979c.i().h(cls, this.f14983g, this.f14987k);
    }

    Class<?> i() {
        return this.f14980d.getClass();
    }

    List<p.o<File, ?>> j(File file) {
        return this.f14979c.i().i(file);
    }

    j.i k() {
        return this.f14985i;
    }

    com.bumptech.glide.h l() {
        return this.f14991o;
    }

    List<Class<?>> m() {
        return this.f14979c.i().j(this.f14980d.getClass(), this.f14983g, this.f14987k);
    }

    <Z> j.l<Z> n(v<Z> vVar) {
        return this.f14979c.i().k(vVar);
    }

    <T> com.bumptech.glide.load.data.e<T> o(T t10) {
        return this.f14979c.i().l(t10);
    }

    j.f p() {
        return this.f14990n;
    }

    <X> j.d<X> q(X x10) {
        return this.f14979c.i().m(x10);
    }

    Class<?> r() {
        return this.f14987k;
    }

    <Z> j.m<Z> s(Class<Z> cls) {
        j.m<Z> mVar = (j.m) this.f14986j.get(cls);
        if (mVar == null) {
            for (Map.Entry<Class<?>, j.m<?>> entry : this.f14986j.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    mVar = (j.m) entry.getValue();
                    break;
                }
            }
        }
        if (mVar != null) {
            return mVar;
        }
        if (!this.f14986j.isEmpty() || !this.f14993q) {
            return r.l.c();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    int t() {
        return this.f14981e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    <R> void v(com.bumptech.glide.e eVar, Object obj, j.f fVar, int i10, int i11, j jVar, Class<?> cls, Class<R> cls2, com.bumptech.glide.h hVar, j.i iVar, Map<Class<?>, j.m<?>> map, boolean z10, boolean z11, h.e eVar2) {
        this.f14979c = eVar;
        this.f14980d = obj;
        this.f14990n = fVar;
        this.f14981e = i10;
        this.f14982f = i11;
        this.f14992p = jVar;
        this.f14983g = cls;
        this.f14984h = eVar2;
        this.f14987k = cls2;
        this.f14991o = hVar;
        this.f14985i = iVar;
        this.f14986j = map;
        this.f14993q = z10;
        this.f14994r = z11;
    }

    boolean w(v<?> vVar) {
        return this.f14979c.i().n(vVar);
    }

    boolean x() {
        return this.f14994r;
    }

    g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean u(Class<?> cls) {
        if (h(cls) != null) {
            return true;
        }
        return false;
    }

    boolean y(j.f fVar) {
        List<p.o.a<?>> listG = g();
        int size = listG.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (listG.get(i10).f17201a.equals(fVar)) {
                return true;
            }
        }
        return false;
    }
}
