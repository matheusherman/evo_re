package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.List;
import kotlin.collections.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class a implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ka.n f14021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final t f14022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h0 f14023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected k f14024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ka.h<ba.c, l0> f14025e;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class C0257a extends kotlin.jvm.internal.o implements c9.l<ba.c, l0> {
        C0257a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final l0 invoke(ba.c fqName) {
            kotlin.jvm.internal.m.f(fqName, "fqName");
            o oVarD = a.this.d(fqName);
            if (oVarD == null) {
                return null;
            }
            oVarD.H0(a.this.e());
            return oVarD;
        }
    }

    protected abstract o d(ba.c cVar);

    public a(ka.n storageManager, t finder, h0 moduleDescriptor) {
        kotlin.jvm.internal.m.f(storageManager, "storageManager");
        kotlin.jvm.internal.m.f(finder, "finder");
        kotlin.jvm.internal.m.f(moduleDescriptor, "moduleDescriptor");
        this.f14021a = storageManager;
        this.f14022b = finder;
        this.f14023c = moduleDescriptor;
        this.f14025e = storageManager.i(new C0257a());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p0
    public boolean a(ba.c fqName) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        return (this.f14025e.i(fqName) ? (l0) this.f14025e.invoke(fqName) : d(fqName)) == null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p0
    public void b(ba.c fqName, Collection<l0> packageFragments) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        kotlin.jvm.internal.m.f(packageFragments, "packageFragments");
        sa.a.a(packageFragments, this.f14025e.invoke(fqName));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m0
    public List<l0> c(ba.c fqName) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        return kotlin.collections.r.p(this.f14025e.invoke(fqName));
    }

    protected final k e() {
        k kVar = this.f14024d;
        if (kVar != null) {
            return kVar;
        }
        kotlin.jvm.internal.m.v("components");
        return null;
    }

    protected final t f() {
        return this.f14022b;
    }

    protected final h0 g() {
        return this.f14023c;
    }

    protected final ka.n h() {
        return this.f14021a;
    }

    protected final void i(k kVar) {
        kotlin.jvm.internal.m.f(kVar, "<set-?>");
        this.f14024d = kVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m0
    public Collection<ba.c> m(ba.c fqName, c9.l<? super ba.f, Boolean> nameFilter) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        kotlin.jvm.internal.m.f(nameFilter, "nameFilter");
        return v0.e();
    }
}
