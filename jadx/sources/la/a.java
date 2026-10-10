package la;

import java.util.List;
import kotlin.collections.r;
import kotlin.collections.v0;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.types.n1;
import kotlin.reflect.jvm.internal.impl.types.p1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a extends kotlin.reflect.jvm.internal.impl.descriptors.impl.h {
    /* JADX WARN: Illegal instructions before constructor call */
    public a(ba.f name) {
        m.f(name, "name");
        k kVar = k.f15326a;
        h0 h0VarI = kVar.i();
        e0 e0Var = e0.OPEN;
        kotlin.reflect.jvm.internal.impl.descriptors.f fVar = kotlin.reflect.jvm.internal.impl.descriptors.f.CLASS;
        List listL = r.l();
        a1 a1Var = a1.f12668a;
        super(h0VarI, name, e0Var, fVar, listL, a1Var, false, ka.f.f12182e);
        kotlin.reflect.jvm.internal.impl.descriptors.impl.f fVarJ1 = kotlin.reflect.jvm.internal.impl.descriptors.impl.f.j1(this, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b(), true, a1Var);
        fVarJ1.m1(r.l(), t.f13067d);
        m.e(fVarJ1, "create(this, Annotations…          )\n            }");
        g gVar = g.SCOPE_FOR_ERROR_CLASS;
        String string = fVarJ1.getName().toString();
        m.e(string, "errorConstructor.name.toString()");
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarB = k.b(gVar, string, "");
        j jVar = j.T1;
        fVarJ1.c1(new h(kVar.e(jVar, new String[0]), hVarB, jVar, null, false, new String[0], 24, null));
        G0(hVarB, v0.d(fVarJ1), fVarJ1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.c1
    /* JADX INFO: renamed from: B0 */
    public kotlin.reflect.jvm.internal.impl.descriptors.e c(p1 substitutor) {
        m.f(substitutor, "substitutor");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.impl.t
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h C(n1 typeSubstitution, kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        m.f(typeSubstitution, "typeSubstitution");
        m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        g gVar = g.SCOPE_FOR_ERROR_CLASS;
        String string = getName().toString();
        m.e(string, "name.toString()");
        return k.b(gVar, string, typeSubstitution.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.h
    public String toString() {
        String strF = getName().f();
        m.e(strF, "name.asString()");
        return strF;
    }
}
