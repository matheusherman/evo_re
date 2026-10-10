package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0 f14370a = la.k.d(la.j.C, new String[0]);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o0 f14371b = la.k.d(la.j.f15321v, new String[0]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o0 f14372c = new a("NO_EXPECTED_TYPE");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final o0 f14373d = new a("UNIT_EXPECTED_TYPE");

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a extends r {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14374b;

        /* JADX WARN: Code duplicated, block: B:20:0x0030  */
        private static /* synthetic */ void V0(int i10) {
            String str = (i10 == 1 || i10 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i10 == 1 || i10 == 4) ? 2 : 3];
            if (i10 == 1) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            } else if (i10 == 2) {
                objArr[0] = "delegate";
            } else if (i10 == 3) {
                objArr[0] = "kotlinTypeRefiner";
            } else if (i10 != 4) {
                objArr[0] = "newAttributes";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            }
            if (i10 == 1) {
                objArr[1] = "toString";
            } else if (i10 != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            } else {
                objArr[1] = "refine";
            }
            if (i10 != 1) {
                if (i10 == 2) {
                    objArr[2] = "replaceDelegate";
                } else if (i10 == 3) {
                    objArr[2] = "refine";
                } else if (i10 != 4) {
                    objArr[2] = "replaceAttributes";
                }
            }
            String str2 = String.format(str, objArr);
            if (i10 != 1 && i10 != 4) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.v1
        /* JADX INFO: renamed from: Q0 */
        public o0 N0(boolean z10) {
            throw new IllegalStateException(this.f14374b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.v1
        /* JADX INFO: renamed from: R0 */
        public o0 P0(c1 c1Var) {
            if (c1Var == null) {
                V0(0);
            }
            throw new IllegalStateException(this.f14374b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.r
        protected o0 S0() {
            throw new IllegalStateException(this.f14374b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.r
        public r U0(o0 o0Var) {
            if (o0Var == null) {
                V0(2);
            }
            throw new IllegalStateException(this.f14374b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.r
        /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public a T0(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            if (gVar == null) {
                V0(3);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.o0
        public String toString() {
            String str = this.f14374b;
            if (str == null) {
                V0(1);
            }
            return str;
        }

        public a(String str) {
            this.f14374b = str;
        }
    }

    public static g0 o(g0 g0Var) {
        if (g0Var == null) {
            a(1);
        }
        return p(g0Var, true);
    }

    public static boolean w(g0 g0Var) {
        if (g0Var == null) {
            a(0);
        }
        return g0Var == f14372c || g0Var == f14373d;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0035  */
    /* JADX WARN: Code duplicated, block: B:33:0x0055  */
    /* JADX WARN: Code duplicated, block: B:75:0x0105  */
    /* JADX WARN: Code duplicated, block: B:82:0x011c  */
    private static /* synthetic */ void a(int i10) {
        String str;
        int i11;
        if (i10 != 4 && i10 != 9 && i10 != 11 && i10 != 15 && i10 != 17 && i10 != 19 && i10 != 26 && i10 != 35 && i10 != 48 && i10 != 53 && i10 != 6 && i10 != 7) {
            switch (i10) {
                case 56:
                case 57:
                case 58:
                case 59:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i10 != 4 && i10 != 9 && i10 != 11 && i10 != 15 && i10 != 17 && i10 != 19 && i10 != 26 && i10 != 35 && i10 != 48 && i10 != 53 && i10 != 6 && i10 != 7) {
            switch (i10) {
                case 56:
                case 57:
                case 58:
                case 59:
                    i11 = 2;
                    break;
                default:
                    i11 = 3;
                    break;
            }
        } else {
            i11 = 2;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 15:
            case 17:
            case 19:
            case 26:
            case 35:
            case 48:
            case 53:
            case 56:
            case 57:
            case 58:
            case 59:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                break;
            case 5:
            case 8:
            case 10:
            case 18:
            case 23:
            case 25:
            case 27:
            case 28:
            case 29:
            case 30:
            case 38:
            case 40:
            default:
                objArr[0] = IjkMediaMeta.IJKM_KEY_TYPE;
                break;
            case 12:
                objArr[0] = "typeConstructor";
                break;
            case 13:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 14:
                objArr[0] = "refinedTypeFactory";
                break;
            case 16:
                objArr[0] = "parameters";
                break;
            case 20:
                objArr[0] = "subType";
                break;
            case 21:
                objArr[0] = "superType";
                break;
            case 22:
                objArr[0] = "substitutor";
                break;
            case 24:
                objArr[0] = "result";
                break;
            case 31:
            case 33:
                objArr[0] = "clazz";
                break;
            case 32:
                objArr[0] = "typeArguments";
                break;
            case 34:
                objArr[0] = "projections";
                break;
            case 36:
                objArr[0] = "a";
                break;
            case 37:
                objArr[0] = "b";
                break;
            case 39:
                objArr[0] = "typeParameters";
                break;
            case 41:
                objArr[0] = "typeParameterConstructors";
                break;
            case 42:
                objArr[0] = "specialType";
                break;
            case 43:
            case 44:
                objArr[0] = "isSpecialType";
                break;
            case 45:
            case 46:
                objArr[0] = "parameterDescriptor";
                break;
            case 47:
            case 51:
                objArr[0] = "numberValueTypeConstructor";
                break;
            case 49:
            case 50:
                objArr[0] = "supertypes";
                break;
            case 52:
            case 55:
                objArr[0] = "expectedType";
                break;
            case 54:
                objArr[0] = "literalTypeConstructor";
                break;
        }
        if (i10 == 4) {
            objArr[1] = "makeNullableAsSpecified";
        } else if (i10 == 9) {
            objArr[1] = "makeNullableIfNeeded";
        } else if (i10 == 11 || i10 == 15) {
            objArr[1] = "makeUnsubstitutedType";
        } else if (i10 == 17) {
            objArr[1] = "getDefaultTypeProjections";
        } else if (i10 == 19) {
            objArr[1] = "getImmediateSupertypes";
        } else if (i10 == 26) {
            objArr[1] = "getAllSupertypes";
        } else if (i10 == 35) {
            objArr[1] = "substituteProjectionsForParameters";
        } else if (i10 == 48) {
            objArr[1] = "getDefaultPrimitiveNumberType";
        } else if (i10 != 53) {
            if (i10 != 6 && i10 != 7) {
                switch (i10) {
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        objArr[1] = "getPrimitiveNumberType";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                        break;
                }
            } else {
                objArr[1] = "makeNullableIfNeeded";
            }
        } else {
            objArr[1] = "getPrimitiveNumberType";
        }
        switch (i10) {
            case 1:
                objArr[2] = "makeNullable";
                break;
            case 2:
                objArr[2] = "makeNotNullable";
                break;
            case 3:
                objArr[2] = "makeNullableAsSpecified";
                break;
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 15:
            case 17:
            case 19:
            case 26:
            case 35:
            case 48:
            case 53:
            case 56:
            case 57:
            case 58:
            case 59:
                break;
            case 5:
            case 8:
                objArr[2] = "makeNullableIfNeeded";
                break;
            case 10:
                objArr[2] = "canHaveSubtypes";
                break;
            case 12:
            case 13:
            case 14:
                objArr[2] = "makeUnsubstitutedType";
                break;
            case 16:
                objArr[2] = "getDefaultTypeProjections";
                break;
            case 18:
                objArr[2] = "getImmediateSupertypes";
                break;
            case 20:
            case 21:
            case 22:
                objArr[2] = "createSubstitutedSupertype";
                break;
            case 23:
            case 24:
                objArr[2] = "collectAllSupertypes";
                break;
            case 25:
                objArr[2] = "getAllSupertypes";
                break;
            case 27:
                objArr[2] = "isNullableType";
                break;
            case 28:
                objArr[2] = "acceptsNullable";
                break;
            case 29:
                objArr[2] = "hasNullableSuperType";
                break;
            case 30:
                objArr[2] = "getClassDescriptor";
                break;
            case 31:
            case 32:
                objArr[2] = "substituteParameters";
                break;
            case 33:
            case 34:
                objArr[2] = "substituteProjectionsForParameters";
                break;
            case 36:
            case 37:
                objArr[2] = "equalTypes";
                break;
            case 38:
            case 39:
                objArr[2] = "dependsOnTypeParameters";
                break;
            case 40:
            case 41:
                objArr[2] = "dependsOnTypeConstructors";
                break;
            case 42:
            case 43:
            case 44:
                objArr[2] = "contains";
                break;
            case 45:
            case 46:
                objArr[2] = "makeStarProjection";
                break;
            case 47:
            case 49:
                objArr[2] = "getDefaultPrimitiveNumberType";
                break;
            case 50:
                objArr[2] = "findByFqName";
                break;
            case 51:
            case 52:
            case 54:
            case 55:
                objArr[2] = "getPrimitiveNumberType";
                break;
            case 60:
                objArr[2] = "isTypeParameter";
                break;
            case 61:
                objArr[2] = "isReifiedTypeParameter";
                break;
            case 62:
                objArr[2] = "isNonReifiedTypeParameter";
                break;
            case 63:
                objArr[2] = "getTypeParameterDescriptorOrNull";
                break;
            default:
                objArr[2] = "noExpectedType";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 4 && i10 != 9 && i10 != 11 && i10 != 15 && i10 != 17 && i10 != 19 && i10 != 26 && i10 != 35 && i10 != 48 && i10 != 53 && i10 != 6 && i10 != 7) {
            switch (i10) {
                case 56:
                case 57:
                case 58:
                case 59:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    public static boolean b(g0 g0Var) {
        if (g0Var == null) {
            a(28);
        }
        if (g0Var.K0()) {
            return true;
        }
        return d0.b(g0Var) && b(d0.a(g0Var).S0());
    }

    public static boolean c(g0 g0Var, c9.l<v1, Boolean> lVar) {
        if (lVar == null) {
            a(43);
        }
        return d(g0Var, lVar, null);
    }

    private static boolean d(g0 g0Var, c9.l<v1, Boolean> lVar, sa.g<g0> gVar) {
        if (lVar == null) {
            a(44);
        }
        if (g0Var == null) {
            return false;
        }
        v1 v1VarM0 = g0Var.M0();
        if (w(g0Var)) {
            return lVar.invoke(v1VarM0).booleanValue();
        }
        if (gVar != null && gVar.contains(g0Var)) {
            return false;
        }
        if (lVar.invoke(v1VarM0).booleanValue()) {
            return true;
        }
        if (gVar == null) {
            gVar = sa.g.e();
        }
        gVar.add(g0Var);
        a0 a0Var = v1VarM0 instanceof a0 ? (a0) v1VarM0 : null;
        if (a0Var != null && (d(a0Var.R0(), lVar, gVar) || d(a0Var.S0(), lVar, gVar))) {
            return true;
        }
        if ((v1VarM0 instanceof p) && d(((p) v1VarM0).V0(), lVar, gVar)) {
            return true;
        }
        g1 g1VarJ0 = g0Var.J0();
        if (g1VarJ0 instanceof f0) {
            Iterator<g0> it = ((f0) g1VarJ0).b().iterator();
            while (it.hasNext()) {
                if (d(it.next(), lVar, gVar)) {
                    return true;
                }
            }
            return false;
        }
        for (k1 k1Var : g0Var.H0()) {
            if (!k1Var.b()) {
                if (d(k1Var.getType(), lVar, gVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static g0 e(g0 g0Var, g0 g0Var2, p1 p1Var) {
        if (g0Var == null) {
            a(20);
        }
        if (g0Var2 == null) {
            a(21);
        }
        if (p1Var == null) {
            a(22);
        }
        g0 g0VarP = p1Var.p(g0Var2, w1.INVARIANT);
        if (g0VarP != null) {
            return q(g0VarP, g0Var.K0());
        }
        return null;
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.e f(g0 g0Var) {
        if (g0Var == null) {
            a(30);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = g0Var.J0().d();
        if (hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD;
        }
        return null;
    }

    public static List<k1> g(List<kotlin.reflect.jvm.internal.impl.descriptors.f1> list) {
        if (list == null) {
            a(16);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.f1> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new m1(it.next().p()));
        }
        List<k1> listO0 = kotlin.collections.r.O0(arrayList);
        if (listO0 == null) {
            a(17);
        }
        return listO0;
    }

    public static List<g0> h(g0 g0Var) {
        if (g0Var == null) {
            a(18);
        }
        p1 p1VarF = p1.f(g0Var);
        Collection<g0> collectionB = g0Var.J0().b();
        ArrayList arrayList = new ArrayList(collectionB.size());
        Iterator<g0> it = collectionB.iterator();
        while (it.hasNext()) {
            g0 g0VarE = e(g0Var, it.next(), p1VarF);
            if (g0VarE != null) {
                arrayList.add(g0VarE);
            }
        }
        return arrayList;
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.f1 i(g0 g0Var) {
        if (g0Var == null) {
            a(63);
        }
        if (g0Var.J0().d() instanceof kotlin.reflect.jvm.internal.impl.descriptors.f1) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.f1) g0Var.J0().d();
        }
        return null;
    }

    public static boolean j(g0 g0Var) {
        if (g0Var == null) {
            a(29);
        }
        if (g0Var.J0().d() instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
            return false;
        }
        Iterator<g0> it = h(g0Var).iterator();
        while (it.hasNext()) {
            if (l(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean k(g0 g0Var) {
        return g0Var != null && g0Var.J0() == f14370a.J0();
    }

    public static boolean l(g0 g0Var) {
        if (g0Var == null) {
            a(27);
        }
        if (g0Var.K0()) {
            return true;
        }
        if (d0.b(g0Var) && l(d0.a(g0Var).S0())) {
            return true;
        }
        if (s0.c(g0Var)) {
            return false;
        }
        if (m(g0Var)) {
            return j(g0Var);
        }
        if (g0Var instanceof e) {
            kotlin.reflect.jvm.internal.impl.descriptors.f1 f1VarA = ((e) g0Var).S0().a();
            return f1VarA == null || j(f1VarA.p());
        }
        g1 g1VarJ0 = g0Var.J0();
        if (g1VarJ0 instanceof f0) {
            Iterator<g0> it = g1VarJ0.b().iterator();
            while (it.hasNext()) {
                if (l(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean m(g0 g0Var) {
        if (g0Var == null) {
            a(60);
        }
        return i(g0Var) != null || (g0Var.J0() instanceof kotlin.reflect.jvm.internal.impl.types.checker.n);
    }

    public static g0 n(g0 g0Var) {
        if (g0Var == null) {
            a(2);
        }
        return p(g0Var, false);
    }

    public static g0 p(g0 g0Var, boolean z10) {
        if (g0Var == null) {
            a(3);
        }
        v1 v1VarN0 = g0Var.M0().N0(z10);
        if (v1VarN0 == null) {
            a(4);
        }
        return v1VarN0;
    }

    public static g0 q(g0 g0Var, boolean z10) {
        if (g0Var == null) {
            a(8);
        }
        if (z10) {
            return o(g0Var);
        }
        if (g0Var == null) {
            a(9);
        }
        return g0Var;
    }

    public static o0 r(o0 o0Var, boolean z10) {
        if (o0Var == null) {
            a(5);
        }
        if (!z10) {
            if (o0Var == null) {
                a(7);
            }
            return o0Var;
        }
        o0 o0VarN0 = o0Var.N0(true);
        if (o0VarN0 == null) {
            a(6);
        }
        return o0VarN0;
    }

    public static k1 s(kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var) {
        if (f1Var == null) {
            a(45);
        }
        return new u0(f1Var);
    }

    public static k1 t(kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var, y yVar) {
        if (f1Var == null) {
            a(46);
        }
        return yVar.b() == r1.SUPERTYPE ? new m1(v0.b(f1Var)) : new u0(f1Var);
    }

    public static o0 v(g1 g1Var, kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar, c9.l<kotlin.reflect.jvm.internal.impl.types.checker.g, o0> lVar) {
        if (g1Var == null) {
            a(12);
        }
        if (hVar == null) {
            a(13);
        }
        if (lVar == null) {
            a(14);
        }
        o0 o0VarL = h0.l(c1.f14231b.h(), g1Var, g(g1Var.getParameters()), false, hVar, lVar);
        if (o0VarL == null) {
            a(15);
        }
        return o0VarL;
    }

    public static o0 u(kotlin.reflect.jvm.internal.impl.descriptors.h hVar, kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar2, c9.l<kotlin.reflect.jvm.internal.impl.types.checker.g, o0> lVar) {
        if (la.k.m(hVar)) {
            la.h hVarD = la.k.d(la.j.B, hVar.toString());
            if (hVarD == null) {
                a(11);
            }
            return hVarD;
        }
        return v(hVar.h(), hVar2, lVar);
    }
}
