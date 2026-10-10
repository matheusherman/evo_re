package la;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import kotlin.collections.r;
import kotlin.collections.v0;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f implements kotlin.reflect.jvm.internal.impl.resolve.scopes.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f15267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f15268c;

    public f(g kind, String... formatParams) {
        m.f(kind, "kind");
        m.f(formatParams, "formatParams");
        this.f15267b = kind;
        String strF = kind.f();
        Object[] objArrCopyOf = Arrays.copyOf(formatParams, formatParams.length);
        String str = String.format(strF, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        m.e(str, "format(this, *args)");
        this.f15268c = str;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public kotlin.reflect.jvm.internal.impl.descriptors.h e(ba.f name, r9.b location) {
        m.f(name, "name");
        m.f(location, "location");
        String str = String.format(b.ERROR_CLASS.f(), Arrays.copyOf(new Object[]{name}, 1));
        m.e(str, "format(this, *args)");
        ba.f fVarO = ba.f.o(str);
        m.e(fVarO, "special(ErrorEntity.ERRO…S.debugText.format(name))");
        return new a(fVarO);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g(kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, c9.l<? super ba.f, Boolean> nameFilter) {
        m.f(kindFilter, "kindFilter");
        m.f(nameFilter, "nameFilter");
        return r.l();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Set<z0> c(ba.f name, r9.b location) {
        m.f(name, "name");
        m.f(location, "location");
        return v0.d(new c(k.f15326a.h()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public Set<u0> a(ba.f name, r9.b location) {
        m.f(name, "name");
        m.f(location, "location");
        return k.f15326a.j();
    }

    protected final String j() {
        return this.f15268c;
    }

    public String toString() {
        return "ErrorScope{" + this.f15268c + '}';
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> b() {
        return v0.e();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> d() {
        return v0.e();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> f() {
        return v0.e();
    }
}
