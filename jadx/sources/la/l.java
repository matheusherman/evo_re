package la;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class l extends f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(g kind, String... formatParams) {
        super(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length));
        m.f(kind, "kind");
        m.f(formatParams, "formatParams");
    }

    @Override // la.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> b() {
        throw new IllegalStateException();
    }

    @Override // la.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> d() {
        throw new IllegalStateException();
    }

    @Override // la.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public kotlin.reflect.jvm.internal.impl.descriptors.h e(ba.f name, r9.b location) {
        m.f(name, "name");
        m.f(location, "location");
        throw new IllegalStateException(j() + ", required name: " + name);
    }

    @Override // la.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> f() {
        throw new IllegalStateException();
    }

    @Override // la.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g(kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, c9.l<? super ba.f, Boolean> nameFilter) {
        m.f(kindFilter, "kindFilter");
        m.f(nameFilter, "nameFilter");
        throw new IllegalStateException(j());
    }

    @Override // la.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    /* JADX INFO: renamed from: h */
    public Set<z0> c(ba.f name, r9.b location) {
        m.f(name, "name");
        m.f(location, "location");
        throw new IllegalStateException(j() + ", required name: " + name);
    }

    @Override // la.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    /* JADX INFO: renamed from: i */
    public Set<u0> a(ba.f name, r9.b location) {
        m.f(name, "name");
        m.f(location, "location");
        throw new IllegalStateException(j() + ", required name: " + name);
    }

    @Override // la.f
    public String toString() {
        return "ThrowingScope{" + j() + '}';
    }
}
