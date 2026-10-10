package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class o0 {
    public static final void a(m0 m0Var, ba.c fqName, Collection<l0> packageFragments) {
        kotlin.jvm.internal.m.f(m0Var, "<this>");
        kotlin.jvm.internal.m.f(fqName, "fqName");
        kotlin.jvm.internal.m.f(packageFragments, "packageFragments");
        if (m0Var instanceof p0) {
            ((p0) m0Var).b(fqName, packageFragments);
        } else {
            packageFragments.addAll(m0Var.c(fqName));
        }
    }

    public static final boolean b(m0 m0Var, ba.c fqName) {
        kotlin.jvm.internal.m.f(m0Var, "<this>");
        kotlin.jvm.internal.m.f(fqName, "fqName");
        return m0Var instanceof p0 ? ((p0) m0Var).a(fqName) : c(m0Var, fqName).isEmpty();
    }

    public static final List<l0> c(m0 m0Var, ba.c fqName) {
        kotlin.jvm.internal.m.f(m0Var, "<this>");
        kotlin.jvm.internal.m.f(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        a(m0Var, fqName, arrayList);
        return arrayList;
    }
}
