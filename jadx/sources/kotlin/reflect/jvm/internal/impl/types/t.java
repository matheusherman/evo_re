package kotlin.reflect.jvm.internal.impl.types;

import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class t {
    private static /* synthetic */ void a(int i10) {
        String str = i10 != 4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i10 != 4 ? 3 : 2];
        switch (i10) {
            case 1:
            case 6:
                objArr[0] = "originalSubstitution";
                break;
            case 2:
            case 7:
                objArr[0] = "newContainingDeclaration";
                break;
            case 3:
            case 8:
                objArr[0] = "result";
                break;
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            case 5:
            default:
                objArr[0] = "typeParameters";
                break;
        }
        if (i10 != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        } else {
            objArr[1] = "substituteTypeParameters";
        }
        if (i10 != 4) {
            objArr[2] = "substituteTypeParameters";
        }
        String str2 = String.format(str, objArr);
        if (i10 == 4) {
            throw new IllegalStateException(str2);
        }
    }

    public static p1 b(List<kotlin.reflect.jvm.internal.impl.descriptors.f1> list, n1 n1Var, kotlin.reflect.jvm.internal.impl.descriptors.m mVar, List<kotlin.reflect.jvm.internal.impl.descriptors.f1> list2) {
        if (list == null) {
            a(0);
        }
        if (n1Var == null) {
            a(1);
        }
        if (mVar == null) {
            a(2);
        }
        if (list2 == null) {
            a(3);
        }
        p1 p1VarC = c(list, n1Var, mVar, list2, null);
        if (p1VarC != null) {
            return p1VarC;
        }
        throw new AssertionError("Substitution failed");
    }

    public static p1 c(List<kotlin.reflect.jvm.internal.impl.descriptors.f1> list, n1 n1Var, kotlin.reflect.jvm.internal.impl.descriptors.m mVar, List<kotlin.reflect.jvm.internal.impl.descriptors.f1> list2, boolean[] zArr) {
        if (list == null) {
            a(5);
        }
        if (n1Var == null) {
            a(6);
        }
        if (mVar == null) {
            a(7);
        }
        if (list2 == null) {
            a(8);
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        int i10 = 0;
        for (kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var : list) {
            kotlin.reflect.jvm.internal.impl.descriptors.impl.k0 k0VarM0 = kotlin.reflect.jvm.internal.impl.descriptors.impl.k0.M0(mVar, f1Var.getAnnotations(), f1Var.z(), f1Var.j(), f1Var.getName(), i10, kotlin.reflect.jvm.internal.impl.descriptors.a1.f12668a, f1Var.d0());
            map.put(f1Var.h(), new m1(k0VarM0.p()));
            map2.put(f1Var, k0VarM0);
            list2.add(k0VarM0);
            i10++;
        }
        h1 h1VarJ = h1.j(map);
        p1 p1VarH = p1.h(n1Var, h1VarJ);
        p1 p1VarH2 = p1.h(n1Var.h(), h1VarJ);
        for (kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var2 : list) {
            kotlin.reflect.jvm.internal.impl.descriptors.impl.k0 k0Var = (kotlin.reflect.jvm.internal.impl.descriptors.impl.k0) map2.get(f1Var2);
            for (g0 g0Var : f1Var2.getUpperBounds()) {
                kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = g0Var.J0().d();
                g0 g0VarP = (((hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.f1) && oa.a.k((kotlin.reflect.jvm.internal.impl.descriptors.f1) hVarD)) ? p1VarH : p1VarH2).p(g0Var, w1.OUT_VARIANCE);
                if (g0VarP == null) {
                    return null;
                }
                if (g0VarP != g0Var && zArr != null) {
                    zArr[0] = true;
                }
                k0Var.I0(g0VarP);
            }
            k0Var.R0();
        }
        return p1VarH;
    }
}
