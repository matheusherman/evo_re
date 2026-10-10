package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import c9.l;
import java.util.Collection;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import u9.u;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class f implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f13374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ka.a<ba.c, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h> f13375b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements c9.a<kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h> {
        final /* synthetic */ u $jPackage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(u uVar) {
            super(0);
            this.$jPackage = uVar;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h invoke() {
            return new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h(f.this.f13374a, this.$jPackage);
        }
    }

    public f(b components) {
        m.f(components, "components");
        g gVar = new g(components, k.a.f13387a, r8.j.c(null));
        this.f13374a = gVar;
        this.f13375b = gVar.e().d();
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h e(ba.c cVar) {
        u uVarA = kotlin.reflect.jvm.internal.impl.load.java.o.a(this.f13374a.a().d(), cVar, false, 2, null);
        if (uVarA == null) {
            return null;
        }
        return this.f13375b.a(cVar, new a(uVarA));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p0
    public boolean a(ba.c fqName) {
        m.f(fqName, "fqName");
        return kotlin.reflect.jvm.internal.impl.load.java.o.a(this.f13374a.a().d(), fqName, false, 2, null) == null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p0
    public void b(ba.c fqName, Collection<l0> packageFragments) {
        m.f(fqName, "fqName");
        m.f(packageFragments, "packageFragments");
        sa.a.a(packageFragments, e(fqName));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m0
    public List<kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h> c(ba.c fqName) {
        m.f(fqName, "fqName");
        return r.p(e(fqName));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public List<ba.c> m(ba.c fqName, l<? super ba.f, Boolean> nameFilter) {
        m.f(fqName, "fqName");
        m.f(nameFilter, "nameFilter");
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h hVarE = e(fqName);
        List<ba.c> listL0 = hVarE != null ? hVarE.L0() : null;
        return listL0 == null ? r.l() : listL0;
    }

    public String toString() {
        return "LazyJavaPackageFragmentProvider of module " + this.f13374a.a().m();
    }
}
