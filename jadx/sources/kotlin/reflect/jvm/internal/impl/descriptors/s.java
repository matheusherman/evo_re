package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class s {
    public static final h a(m mVar) {
        kotlin.jvm.internal.m.f(mVar, "<this>");
        m mVarB = mVar.b();
        if (mVarB != null && !(mVar instanceof l0)) {
            if (!b(mVarB)) {
                return a(mVarB);
            }
            if (mVarB instanceof h) {
                return (h) mVarB;
            }
        }
        return null;
    }

    public static final boolean b(m mVar) {
        kotlin.jvm.internal.m.f(mVar, "<this>");
        return mVar.b() instanceof l0;
    }

    public static final boolean c(y yVar) {
        kotlin.reflect.jvm.internal.impl.types.o0 o0VarP;
        kotlin.reflect.jvm.internal.impl.types.g0 g0VarY;
        kotlin.reflect.jvm.internal.impl.types.g0 returnType;
        kotlin.jvm.internal.m.f(yVar, "<this>");
        m mVarB = yVar.b();
        e eVar = mVarB instanceof e ? (e) mVarB : null;
        if (eVar != null) {
            e eVar2 = kotlin.reflect.jvm.internal.impl.resolve.g.f(eVar) ? eVar : null;
            if (eVar2 != null && (o0VarP = eVar2.p()) != null && (g0VarY = oa.a.y(o0VarP)) != null && (returnType = yVar.getReturnType()) != null && kotlin.jvm.internal.m.a(yVar.getName(), kotlin.reflect.jvm.internal.impl.util.q.f14442e) && ((oa.a.n(returnType) || oa.a.o(returnType)) && yVar.f().size() == 1)) {
                kotlin.reflect.jvm.internal.impl.types.g0 type = yVar.f().get(0).getType();
                kotlin.jvm.internal.m.e(type, "valueParameters[0].type");
                if (kotlin.jvm.internal.m.a(oa.a.y(type), g0VarY) && yVar.n0().isEmpty() && yVar.i0() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final e d(h0 h0Var, ba.c fqName, r9.b lookupLocation) {
        h hVarE;
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarU0;
        kotlin.jvm.internal.m.f(h0Var, "<this>");
        kotlin.jvm.internal.m.f(fqName, "fqName");
        kotlin.jvm.internal.m.f(lookupLocation, "lookupLocation");
        if (fqName.d()) {
            return null;
        }
        ba.c cVarE = fqName.e();
        kotlin.jvm.internal.m.e(cVarE, "fqName.parent()");
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarN = h0Var.U(cVarE).n();
        ba.f fVarG = fqName.g();
        kotlin.jvm.internal.m.e(fVarG, "fqName.shortName()");
        h hVarE2 = hVarN.e(fVarG, lookupLocation);
        e eVar = hVarE2 instanceof e ? (e) hVarE2 : null;
        if (eVar != null) {
            return eVar;
        }
        ba.c cVarE2 = fqName.e();
        kotlin.jvm.internal.m.e(cVarE2, "fqName.parent()");
        e eVarD = d(h0Var, cVarE2, lookupLocation);
        if (eVarD == null || (hVarU0 = eVarD.u0()) == null) {
            hVarE = null;
        } else {
            ba.f fVarG2 = fqName.g();
            kotlin.jvm.internal.m.e(fVarG2, "fqName.shortName()");
            hVarE = hVarU0.e(fVarG2, lookupLocation);
        }
        if (hVarE instanceof e) {
            return (e) hVarE;
        }
        return null;
    }
}
