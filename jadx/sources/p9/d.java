package p9;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.w;
import kotlin.reflect.jvm.internal.impl.load.java.p;
import u9.u;
import ua.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class d implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ClassLoader f17439a;

    public d(ClassLoader classLoader) {
        kotlin.jvm.internal.m.f(classLoader, "classLoader");
        this.f17439a = classLoader;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.p
    public u9.g a(p.a request) {
        kotlin.jvm.internal.m.f(request, "request");
        ba.b bVarA = request.a();
        ba.c cVarH = bVarA.h();
        kotlin.jvm.internal.m.e(cVarH, "classId.packageFqName");
        String strB = bVarA.i().b();
        kotlin.jvm.internal.m.e(strB, "classId.relativeClassName.asString()");
        String strD = n.D(strB, '.', '$', false, 4, null);
        if (!cVarH.d()) {
            strD = cVarH.b() + '.' + strD;
        }
        Class<?> clsA = e.a(this.f17439a, strD);
        if (clsA != null) {
            return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.l(clsA);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.p
    public Set<String> b(ba.c packageFqName) {
        kotlin.jvm.internal.m.f(packageFqName, "packageFqName");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.p
    public u c(ba.c fqName, boolean z10) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        return new w(fqName);
    }
}
