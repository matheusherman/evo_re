package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.h1;
import kotlin.reflect.jvm.internal.impl.types.k1;
import kotlin.reflect.jvm.internal.impl.types.s1;
import kotlin.reflect.jvm.internal.impl.types.w1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class y {
    private static final String b(g1 g1Var) {
        StringBuilder sb2 = new StringBuilder();
        c("type: " + g1Var, sb2);
        c("hashCode: " + g1Var.hashCode(), sb2);
        c("javaClass: " + g1Var.getClass().getCanonicalName(), sb2);
        for (kotlin.reflect.jvm.internal.impl.descriptors.m mVarD = g1Var.d(); mVarD != null; mVarD = mVarD.b()) {
            c("fqName: " + kotlin.reflect.jvm.internal.impl.renderer.c.f13790g.q(mVarD), sb2);
            c("javaClass: " + mVarD.getClass().getCanonicalName(), sb2);
        }
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    private static final StringBuilder c(String str, StringBuilder sb2) {
        kotlin.jvm.internal.m.f(str, "<this>");
        sb2.append(str);
        kotlin.jvm.internal.m.e(sb2, "append(value)");
        sb2.append('\n');
        kotlin.jvm.internal.m.e(sb2, "append('\\n')");
        return sb2;
    }

    public static final g0 d(g0 subtype, g0 supertype, v typeCheckingProcedureCallbacks) {
        kotlin.jvm.internal.m.f(subtype, "subtype");
        kotlin.jvm.internal.m.f(supertype, "supertype");
        kotlin.jvm.internal.m.f(typeCheckingProcedureCallbacks, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new s(subtype, null));
        g1 g1VarJ0 = supertype.J0();
        while (!arrayDeque.isEmpty()) {
            s sVar = (s) arrayDeque.poll();
            g0 g0VarB = sVar.b();
            g1 g1VarJ1 = g0VarB.J0();
            if (typeCheckingProcedureCallbacks.a(g1VarJ1, g1VarJ0)) {
                boolean zK0 = g0VarB.K0();
                for (s sVarA = sVar.a(); sVarA != null; sVarA = sVarA.a()) {
                    g0 g0VarB2 = sVarA.b();
                    List<k1> listH0 = g0VarB2.H0();
                    if (!(listH0 instanceof Collection) || !listH0.isEmpty()) {
                        Iterator<T> it = listH0.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                g0VarB = h1.f14318c.a(g0VarB2).c().n(g0VarB, w1.INVARIANT);
                                kotlin.jvm.internal.m.e(g0VarB, "{\n                    Ty…ARIANT)\n                }");
                                break;
                            }
                            w1 w1VarA = ((k1) it.next()).a();
                            w1 w1Var = w1.INVARIANT;
                            if (w1VarA != w1Var) {
                                g0 g0VarN = kotlin.reflect.jvm.internal.impl.resolve.calls.inference.d.f(h1.f14318c.a(g0VarB2), false, 1, null).c().n(g0VarB, w1Var);
                                kotlin.jvm.internal.m.e(g0VarN, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
                                g0VarB = a(g0VarN);
                                break;
                            }
                        }
                    } else {
                        g0VarB = h1.f14318c.a(g0VarB2).c().n(g0VarB, w1.INVARIANT);
                        kotlin.jvm.internal.m.e(g0VarB, "{\n                    Ty…ARIANT)\n                }");
                        break;
                    }
                    zK0 = zK0 || g0VarB2.K0();
                }
                g1 g1VarJ2 = g0VarB.J0();
                if (typeCheckingProcedureCallbacks.a(g1VarJ2, g1VarJ0)) {
                    return s1.p(g0VarB, zK0);
                }
                throw new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + b(g1VarJ2) + ", \n\nsupertype: " + b(g1VarJ0) + " \n" + typeCheckingProcedureCallbacks.a(g1VarJ2, g1VarJ0));
            }
            for (g0 immediateSupertype : g1VarJ1.b()) {
                kotlin.jvm.internal.m.e(immediateSupertype, "immediateSupertype");
                arrayDeque.add(new s(immediateSupertype, sVar));
            }
        }
        return null;
    }

    private static final g0 a(g0 g0Var) {
        return pa.b.a(g0Var).d();
    }
}
