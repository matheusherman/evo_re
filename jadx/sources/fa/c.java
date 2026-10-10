package fa;

import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.load.java.components.g;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import u9.d0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.f f10084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f10085b;

    public c(kotlin.reflect.jvm.internal.impl.load.java.lazy.f packageFragmentProvider, g javaResolverCache) {
        m.f(packageFragmentProvider, "packageFragmentProvider");
        m.f(javaResolverCache, "javaResolverCache");
        this.f10084a = packageFragmentProvider;
        this.f10085b = javaResolverCache;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.f a() {
        return this.f10084a;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.e b(u9.g javaClass) {
        m.f(javaClass, "javaClass");
        ba.c cVarD = javaClass.d();
        if (cVarD != null && javaClass.G() == d0.SOURCE) {
            return this.f10085b.e(cVarD);
        }
        u9.g gVarH = javaClass.h();
        if (gVarH != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.e eVarB = b(gVarH);
            h hVarU0 = eVarB != null ? eVarB.u0() : null;
            kotlin.reflect.jvm.internal.impl.descriptors.h hVarE = hVarU0 != null ? hVarU0.e(javaClass.getName(), r9.d.FROM_JAVA_LOADER) : null;
            if (hVarE instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
                return (kotlin.reflect.jvm.internal.impl.descriptors.e) hVarE;
            }
            return null;
        }
        if (cVarD == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.load.java.lazy.f fVar = this.f10084a;
        ba.c cVarE = cVarD.e();
        m.e(cVarE, "fqName.parent()");
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h hVar = (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h) r.i0(fVar.c(cVarE));
        if (hVar != null) {
            return hVar.I0(javaClass);
        }
        return null;
    }
}
