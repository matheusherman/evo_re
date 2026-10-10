package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class w extends p implements u9.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ba.c f13055a;

    @Override // u9.d
    public boolean l() {
        return false;
    }

    public w(ba.c fqName) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        this.f13055a = fqName;
    }

    @Override // u9.u
    public Collection<u9.g> E(c9.l<? super ba.f, Boolean> nameFilter) {
        kotlin.jvm.internal.m.f(nameFilter, "nameFilter");
        return kotlin.collections.r.l();
    }

    @Override // u9.u
    public ba.c d() {
        return this.f13055a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof w) && kotlin.jvm.internal.m.a(d(), ((w) obj).d());
    }

    @Override // u9.d
    public List<u9.a> getAnnotations() {
        return kotlin.collections.r.l();
    }

    @Override // u9.d
    public u9.a j(ba.c fqName) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        return null;
    }

    public String toString() {
        return w.class.getName() + ": " + d();
    }

    public int hashCode() {
        return d().hashCode();
    }

    @Override // u9.u
    public Collection<u9.u> x() {
        return kotlin.collections.r.l();
    }
}
