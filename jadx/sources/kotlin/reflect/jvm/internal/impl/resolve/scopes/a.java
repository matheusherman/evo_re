package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class a implements h {
    protected abstract h i();

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Collection<u0> a(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        return i().a(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Collection<z0> c(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        return i().c(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public kotlin.reflect.jvm.internal.impl.descriptors.h e(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        return i().e(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g(d kindFilter, c9.l<? super ba.f, Boolean> nameFilter) {
        kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.m.f(nameFilter, "nameFilter");
        return i().g(kindFilter, nameFilter);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> b() {
        return i().b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> d() {
        return i().d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> f() {
        return i().f();
    }

    public final h h() {
        if (i() instanceof a) {
            h hVarI = i();
            kotlin.jvm.internal.m.d(hVarI, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.AbstractScopeAdapter");
            return ((a) hVarI).h();
        }
        return i();
    }
}
