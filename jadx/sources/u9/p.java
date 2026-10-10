package u9;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class p {
    public static final boolean c(q qVar) {
        kotlin.jvm.internal.m.f(qVar, "<this>");
        return qVar.N().F() && (qVar instanceof r) && b((r) qVar);
    }

    private static final boolean a(r rVar) {
        x type;
        ba.c cVarD;
        b0 b0Var = (b0) kotlin.collections.r.H0(rVar.f());
        j jVar = null;
        if (b0Var != null) {
            type = b0Var.getType();
        } else {
            type = null;
        }
        if (type instanceof j) {
            jVar = (j) type;
        }
        if (jVar == null) {
            return false;
        }
        i iVarC = jVar.c();
        if (!(iVarC instanceof g) || (cVarD = ((g) iVarC).d()) == null || !kotlin.jvm.internal.m.a(cVarD.b(), "java.lang.Object")) {
            return false;
        }
        return true;
    }

    private static final boolean b(r rVar) {
        String strF = rVar.getName().f();
        int iHashCode = strF.hashCode();
        if (iHashCode != -1776922004) {
            if (iHashCode != -1295482945) {
                if (iHashCode != 147696667 || !strF.equals("hashCode")) {
                    return false;
                }
            } else {
                if (strF.equals("equals")) {
                    return a(rVar);
                }
                return false;
            }
        } else if (!strF.equals("toString")) {
            return false;
        }
        return rVar.f().isEmpty();
    }
}
