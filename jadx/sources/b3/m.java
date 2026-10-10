package b3;

import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.x;
import com.google.gson.y;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class m<T> extends l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r<T> f810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.gson.j<T> f811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final com.google.gson.e f812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f3.a<T> f813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final y f814e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final m<T>.b f815f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f816g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile x<T> f817h;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class b implements q, com.google.gson.i {
        private b() {
        }

        /* synthetic */ b(m mVar, a aVar) {
            this();
        }

        @Override // com.google.gson.i
        public <R> R a(com.google.gson.k kVar, Type type) {
            return (R) m.this.f812c.h(kVar, type);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class c implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f3.a<?> f819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f820b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Class<?> f821c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final r<?> f822d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final com.google.gson.j<?> f823e;

        @Override // com.google.gson.y
        public <T> x<T> a(com.google.gson.e eVar, f3.a<T> aVar) {
            boolean zIsAssignableFrom;
            f3.a<?> aVar2 = this.f819a;
            if (aVar2 != null) {
                zIsAssignableFrom = aVar2.equals(aVar) || (this.f820b && this.f819a.d() == aVar.c());
            } else {
                zIsAssignableFrom = this.f821c.isAssignableFrom(aVar.c());
            }
            if (zIsAssignableFrom) {
                return new m(this.f822d, this.f823e, eVar, aVar, this);
            }
            return null;
        }

        c(Object obj, f3.a<?> aVar, boolean z10, Class<?> cls) {
            r<?> rVar;
            boolean z11;
            if (obj instanceof r) {
                rVar = (r) obj;
            } else {
                rVar = null;
            }
            this.f822d = rVar;
            com.google.gson.j<?> jVar = obj instanceof com.google.gson.j ? (com.google.gson.j) obj : null;
            this.f823e = jVar;
            if (rVar == null && jVar == null) {
                z11 = false;
            } else {
                z11 = true;
            }
            com.google.gson.internal.a.a(z11);
            this.f819a = aVar;
            this.f820b = z10;
            this.f821c = cls;
        }
    }

    public m(r<T> rVar, com.google.gson.j<T> jVar, com.google.gson.e eVar, f3.a<T> aVar, y yVar, boolean z10) {
        this.f815f = new b(this, null);
        this.f810a = rVar;
        this.f811b = jVar;
        this.f812c = eVar;
        this.f813d = aVar;
        this.f814e = yVar;
        this.f816g = z10;
    }

    private x<T> f() {
        x<T> xVar = this.f817h;
        if (xVar != null) {
            return xVar;
        }
        x<T> xVarR = this.f812c.r(this.f814e, this.f813d);
        this.f817h = xVarR;
        return xVarR;
    }

    @Override // com.google.gson.x
    public T b(g3.a aVar) {
        if (this.f811b == null) {
            return f().b(aVar);
        }
        com.google.gson.k kVarA = com.google.gson.internal.m.a(aVar);
        if (this.f816g && kVarA.i()) {
            return null;
        }
        return this.f811b.deserialize(kVarA, this.f813d.d(), this.f815f);
    }

    @Override // com.google.gson.x
    public void d(g3.c cVar, T t10) throws IOException {
        r<T> rVar = this.f810a;
        if (rVar == null) {
            f().d(cVar, t10);
        } else if (this.f816g && t10 == null) {
            cVar.q();
        } else {
            com.google.gson.internal.m.b(rVar.a(t10, this.f813d.d(), this.f815f), cVar);
        }
    }

    @Override // b3.l
    public x<T> e() {
        return this.f810a != null ? this : f();
    }

    public static y g(f3.a<?> aVar, Object obj) {
        boolean z10;
        if (aVar.d() == aVar.c()) {
            z10 = true;
        } else {
            z10 = false;
        }
        return new c(obj, aVar, z10, null);
    }

    public m(r<T> rVar, com.google.gson.j<T> jVar, com.google.gson.e eVar, f3.a<T> aVar, y yVar) {
        this(rVar, jVar, eVar, aVar, yVar, true);
    }
}
