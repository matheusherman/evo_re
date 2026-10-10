package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.q0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class h0 extends kotlin.reflect.jvm.internal.impl.resolve.scopes.i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.h0 f12846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ba.c f12847c;

    public h0(kotlin.reflect.jvm.internal.impl.descriptors.h0 moduleDescriptor, ba.c fqName) {
        kotlin.jvm.internal.m.f(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.m.f(fqName, "fqName");
        this.f12846b = moduleDescriptor;
        this.f12847c = fqName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g(kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, c9.l<? super ba.f, Boolean> nameFilter) {
        kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.m.f(nameFilter, "nameFilter");
        if (!kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f13966c.f())) {
            return kotlin.collections.r.l();
        }
        if (this.f12847c.d() && kindFilter.l().contains(kotlin.reflect.jvm.internal.impl.resolve.scopes.c.b.f13965a)) {
            return kotlin.collections.r.l();
        }
        Collection<ba.c> collectionM = this.f12846b.m(this.f12847c, nameFilter);
        ArrayList arrayList = new ArrayList(collectionM.size());
        Iterator<ba.c> it = collectionM.iterator();
        while (it.hasNext()) {
            ba.f fVarG = it.next().g();
            kotlin.jvm.internal.m.e(fVarG, "subFqName.shortName()");
            if (nameFilter.invoke(fVarG).booleanValue()) {
                sa.a.a(arrayList, h(fVarG));
            }
        }
        return arrayList;
    }

    protected final q0 h(ba.f name) {
        kotlin.jvm.internal.m.f(name, "name");
        if (name.m()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h0 h0Var = this.f12846b;
        ba.c cVarC = this.f12847c.c(name);
        kotlin.jvm.internal.m.e(cVarC, "fqName.child(name)");
        q0 q0VarU = h0Var.U(cVarC);
        if (q0VarU.isEmpty()) {
            return null;
        }
        return q0VarU;
    }

    public String toString() {
        return "subpackages of " + this.f12847c + " from " + this.f12846b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> f() {
        return v0.e();
    }
}
