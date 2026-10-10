package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.Collection;
import kotlin.collections.r;
import kotlin.collections.v0;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f12525a = new d();

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.e f(d dVar, ba.c cVar, kotlin.reflect.jvm.internal.impl.builtins.h hVar, Integer num, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            num = null;
        }
        return dVar.e(cVar, hVar, num);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.e a(kotlin.reflect.jvm.internal.impl.descriptors.e mutable) {
        m.f(mutable, "mutable");
        ba.c cVarO = c.f12505a.o(kotlin.reflect.jvm.internal.impl.resolve.e.m(mutable));
        if (cVarO != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.e eVarO = ea.c.j(mutable).o(cVarO);
            m.e(eVarO, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
            return eVarO;
        }
        throw new IllegalArgumentException("Given class " + mutable + " is not a mutable collection");
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.e b(kotlin.reflect.jvm.internal.impl.descriptors.e readOnly) {
        m.f(readOnly, "readOnly");
        ba.c cVarP = c.f12505a.p(kotlin.reflect.jvm.internal.impl.resolve.e.m(readOnly));
        if (cVarP != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.e eVarO = ea.c.j(readOnly).o(cVarP);
            m.e(eVarO, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
            return eVarO;
        }
        throw new IllegalArgumentException("Given class " + readOnly + " is not a read-only collection");
    }

    public final boolean c(kotlin.reflect.jvm.internal.impl.descriptors.e mutable) {
        m.f(mutable, "mutable");
        return c.f12505a.k(kotlin.reflect.jvm.internal.impl.resolve.e.m(mutable));
    }

    public final boolean d(kotlin.reflect.jvm.internal.impl.descriptors.e readOnly) {
        m.f(readOnly, "readOnly");
        return c.f12505a.l(kotlin.reflect.jvm.internal.impl.resolve.e.m(readOnly));
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.e e(ba.c fqName, kotlin.reflect.jvm.internal.impl.builtins.h builtIns, Integer num) {
        m.f(fqName, "fqName");
        m.f(builtIns, "builtIns");
        ba.b bVarM = (num == null || !m.a(fqName, c.f12505a.h())) ? c.f12505a.m(fqName) : kotlin.reflect.jvm.internal.impl.builtins.k.a(num.intValue());
        if (bVarM != null) {
            return builtIns.o(bVarM.b());
        }
        return null;
    }

    public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> g(ba.c fqName, kotlin.reflect.jvm.internal.impl.builtins.h builtIns) {
        m.f(fqName, "fqName");
        m.f(builtIns, "builtIns");
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarF = f(this, fqName, builtIns, null, 4, null);
        if (eVarF == null) {
            return v0.e();
        }
        ba.c cVarP = c.f12505a.p(ea.c.m(eVarF));
        if (cVarP == null) {
            return v0.d(eVarF);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarO = builtIns.o(cVarP);
        m.e(eVarO, "builtIns.getBuiltInClass…otlinMutableAnalogFqName)");
        return r.o(eVarF, eVarO);
    }

    private d() {
    }
}
