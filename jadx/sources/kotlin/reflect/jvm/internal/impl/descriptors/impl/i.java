package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class i implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<kotlin.reflect.jvm.internal.impl.descriptors.m0> f12848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12849b;

    /* JADX WARN: Multi-variable type inference failed */
    public i(List<? extends kotlin.reflect.jvm.internal.impl.descriptors.m0> providers, String debugName) {
        kotlin.jvm.internal.m.f(providers, "providers");
        kotlin.jvm.internal.m.f(debugName, "debugName");
        this.f12848a = providers;
        this.f12849b = debugName;
        providers.size();
        kotlin.collections.r.S0(providers).size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p0
    public boolean a(ba.c fqName) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        List<kotlin.reflect.jvm.internal.impl.descriptors.m0> list = this.f12848a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!o0.b((kotlin.reflect.jvm.internal.impl.descriptors.m0) it.next(), fqName)) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p0
    public void b(ba.c fqName, Collection<kotlin.reflect.jvm.internal.impl.descriptors.l0> packageFragments) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        kotlin.jvm.internal.m.f(packageFragments, "packageFragments");
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.m0> it = this.f12848a.iterator();
        while (it.hasNext()) {
            o0.a(it.next(), fqName, packageFragments);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m0
    public List<kotlin.reflect.jvm.internal.impl.descriptors.l0> c(ba.c fqName) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.m0> it = this.f12848a.iterator();
        while (it.hasNext()) {
            o0.a(it.next(), fqName, arrayList);
        }
        return kotlin.collections.r.O0(arrayList);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m0
    public Collection<ba.c> m(ba.c fqName, c9.l<? super ba.f, Boolean> nameFilter) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        kotlin.jvm.internal.m.f(nameFilter, "nameFilter");
        HashSet hashSet = new HashSet();
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.m0> it = this.f12848a.iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().m(fqName, nameFilter));
        }
        return hashSet;
    }

    public String toString() {
        return this.f12849b;
    }
}
