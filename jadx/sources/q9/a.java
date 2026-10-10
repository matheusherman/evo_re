package q9;

import ba.f;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import r9.b;
import r9.c;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class a {
    public static final void a(c cVar, b from, e scopeOwner, f name) {
        m.f(cVar, "<this>");
        m.f(from, "from");
        m.f(scopeOwner, "scopeOwner");
        m.f(name, "name");
        if (cVar == c.a.f17875a) {
            return;
        }
        from.f();
    }

    public static final void b(c cVar, b from, l0 scopeOwner, f name) {
        m.f(cVar, "<this>");
        m.f(from, "from");
        m.f(scopeOwner, "scopeOwner");
        m.f(name, "name");
        String strB = scopeOwner.d().b();
        m.e(strB, "scopeOwner.fqName.asString()");
        String strF = name.f();
        m.e(strF, "name.asString()");
        c(cVar, from, strB, strF);
    }

    public static final void c(c cVar, b from, String packageFqName, String name) {
        m.f(cVar, "<this>");
        m.f(from, "from");
        m.f(packageFqName, "packageFqName");
        m.f(name, "name");
        if (cVar == c.a.f17875a) {
            return;
        }
        from.f();
    }
}
