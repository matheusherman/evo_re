package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.q0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class r extends j implements q0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final /* synthetic */ i9.k<Object>[] f12936h = {kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(r.class), "fragments", "getFragments()Ljava/util/List;")), kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(r.class), "empty", "getEmpty()Z"))};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final x f12937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ba.c f12938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ka.i f12939e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ka.i f12940f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.h f12941g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.a<Boolean> {
        a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final Boolean invoke() {
            return Boolean.valueOf(o0.b(r.this.r0().M0(), r.this.d()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.l0>> {
        b() {
            super(0);
        }

        @Override // c9.a
        public final List<? extends kotlin.reflect.jvm.internal.impl.descriptors.l0> invoke() {
            return o0.c(r.this.r0().M0(), r.this.d());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends kotlin.jvm.internal.o implements c9.a<kotlin.reflect.jvm.internal.impl.resolve.scopes.h> {
        c() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h invoke() {
            if (r.this.isEmpty()) {
                return kotlin.reflect.jvm.internal.impl.resolve.scopes.h.b.f14005b;
            }
            List<kotlin.reflect.jvm.internal.impl.descriptors.l0> listD = r.this.D();
            ArrayList arrayList = new ArrayList(kotlin.collections.r.w(listD, 10));
            Iterator<T> it = listD.iterator();
            while (it.hasNext()) {
                arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.l0) it.next()).n());
            }
            List listC0 = kotlin.collections.r.C0(arrayList, new h0(r.this.r0(), r.this.d()));
            return kotlin.reflect.jvm.internal.impl.resolve.scopes.b.f13960d.a("package view scope for " + r.this.d() + " in " + r.this.r0().getName(), listC0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(x module, ba.c fqName, ka.n storageManager) {
        super(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b(), fqName.h());
        kotlin.jvm.internal.m.f(module, "module");
        kotlin.jvm.internal.m.f(fqName, "fqName");
        kotlin.jvm.internal.m.f(storageManager, "storageManager");
        this.f12937c = module;
        this.f12938d = fqName;
        this.f12939e = storageManager.c(new b());
        this.f12940f = storageManager.c(new a());
        this.f12941g = new kotlin.reflect.jvm.internal.impl.resolve.scopes.g(storageManager, new c());
    }

    protected final boolean B0() {
        return ((Boolean) ka.m.a(this.f12940f, this, f12936h[1])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.q0
    public List<kotlin.reflect.jvm.internal.impl.descriptors.l0> D() {
        return (List) ka.m.a(this.f12939e, this, f12936h[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.q0
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public x r0() {
        return this.f12937c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R H(kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> visitor, D d10) {
        kotlin.jvm.internal.m.f(visitor, "visitor");
        return visitor.c(this, d10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.q0
    public ba.c d() {
        return this.f12938d;
    }

    public boolean equals(Object obj) {
        q0 q0Var = obj instanceof q0 ? (q0) obj : null;
        return q0Var != null && kotlin.jvm.internal.m.a(d(), q0Var.d()) && kotlin.jvm.internal.m.a(r0(), q0Var.r0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.q0
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h n() {
        return this.f12941g;
    }

    public int hashCode() {
        return (r0().hashCode() * 31) + d().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.q0
    public boolean isEmpty() {
        return B0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public q0 b() {
        if (d().d()) {
            return null;
        }
        x xVarR0 = r0();
        ba.c cVarE = d().e();
        kotlin.jvm.internal.m.e(cVarE, "fqName.parent()");
        return xVarR0.U(cVarE);
    }
}
