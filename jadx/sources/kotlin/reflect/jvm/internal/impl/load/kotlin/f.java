package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.types.f0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.k1;
import kotlin.reflect.jvm.internal.impl.types.s1;
import kotlin.reflect.jvm.internal.impl.types.w1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class f {
    public static final String a(kotlin.reflect.jvm.internal.impl.descriptors.e klass, a0<?> typeMappingConfiguration) {
        kotlin.jvm.internal.m.f(klass, "klass");
        kotlin.jvm.internal.m.f(typeMappingConfiguration, "typeMappingConfiguration");
        String strB = typeMappingConfiguration.b(klass);
        if (strB != null) {
            return strB;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = klass.b();
        kotlin.jvm.internal.m.e(mVarB, "klass.containingDeclaration");
        String strJ = ba.h.b(klass.getName()).j();
        kotlin.jvm.internal.m.e(strJ, "safeIdentifier(klass.name).identifier");
        if (mVarB instanceof l0) {
            ba.c cVarD = ((l0) mVarB).d();
            if (cVarD.d()) {
                return strJ;
            }
            StringBuilder sb2 = new StringBuilder();
            String strB2 = cVarD.b();
            kotlin.jvm.internal.m.e(strB2, "fqName.asString()");
            sb2.append(ua.n.D(strB2, '.', '/', false, 4, null));
            sb2.append('/');
            sb2.append(strJ);
            return sb2.toString();
        }
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar = mVarB instanceof kotlin.reflect.jvm.internal.impl.descriptors.e ? (kotlin.reflect.jvm.internal.impl.descriptors.e) mVarB : null;
        if (eVar == null) {
            throw new IllegalArgumentException("Unexpected container: " + mVarB + " for " + klass);
        }
        String strD = typeMappingConfiguration.d(eVar);
        if (strD == null) {
            strD = a(eVar, typeMappingConfiguration);
        }
        return strD + '$' + strJ;
    }

    public static /* synthetic */ String b(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, a0 a0Var, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            a0Var = b0.f13531a;
        }
        return a(eVar, a0Var);
    }

    public static final boolean c(kotlin.reflect.jvm.internal.impl.descriptors.a descriptor) {
        kotlin.jvm.internal.m.f(descriptor, "descriptor");
        if (descriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.l) {
            return true;
        }
        g0 returnType = descriptor.getReturnType();
        kotlin.jvm.internal.m.c(returnType);
        if (!kotlin.reflect.jvm.internal.impl.builtins.h.C0(returnType)) {
            return false;
        }
        g0 returnType2 = descriptor.getReturnType();
        kotlin.jvm.internal.m.c(returnType2);
        return (s1.l(returnType2) || (descriptor instanceof v0)) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v36, types: [T, java.lang.Object] */
    public static final <T> T d(g0 kotlinType, o<T> factory, c0 mode, a0<? extends T> typeMappingConfiguration, l<T> lVar, c9.q<? super g0, ? super T, ? super c0, r8.z> writeGenericType) {
        T tA;
        g0 g0Var;
        Object objD;
        kotlin.jvm.internal.m.f(kotlinType, "kotlinType");
        kotlin.jvm.internal.m.f(factory, "factory");
        kotlin.jvm.internal.m.f(mode, "mode");
        kotlin.jvm.internal.m.f(typeMappingConfiguration, "typeMappingConfiguration");
        kotlin.jvm.internal.m.f(writeGenericType, "writeGenericType");
        g0 g0VarE = typeMappingConfiguration.e(kotlinType);
        if (g0VarE != null) {
            return (T) d(g0VarE, factory, mode, typeMappingConfiguration, lVar, writeGenericType);
        }
        if (kotlin.reflect.jvm.internal.impl.builtins.g.q(kotlinType)) {
            return (T) d(kotlin.reflect.jvm.internal.impl.builtins.l.a(kotlinType), factory, mode, typeMappingConfiguration, lVar, writeGenericType);
        }
        kotlin.reflect.jvm.internal.impl.types.checker.q qVar = kotlin.reflect.jvm.internal.impl.types.checker.q.f14258a;
        Object objB = d0.b(qVar, kotlinType, factory, mode);
        if (objB != null) {
            ?? r10 = (Object) d0.a(factory, objB, mode.d());
            writeGenericType.invoke(kotlinType, r10, mode);
            return r10;
        }
        g1 g1VarJ0 = kotlinType.J0();
        if (g1VarJ0 instanceof f0) {
            f0 f0Var = (f0) g1VarJ0;
            g0 g0VarI = f0Var.i();
            if (g0VarI == null) {
                g0VarI = typeMappingConfiguration.c(f0Var.b());
            }
            return (T) d(oa.a.y(g0VarI), factory, mode, typeMappingConfiguration, lVar, writeGenericType);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = g1VarJ0.d();
        if (hVarD == null) {
            throw new UnsupportedOperationException("no descriptor for type constructor of " + kotlinType);
        }
        if (la.k.m(hVarD)) {
            T t10 = (T) factory.c("error/NonExistentClass");
            typeMappingConfiguration.f(kotlinType, (kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD);
            return t10;
        }
        boolean z10 = hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.e;
        if (z10 && kotlin.reflect.jvm.internal.impl.builtins.h.c0(kotlinType)) {
            if (kotlinType.H0().size() != 1) {
                throw new UnsupportedOperationException("arrays must have one type argument");
            }
            k1 k1Var = kotlinType.H0().get(0);
            g0 type = k1Var.getType();
            kotlin.jvm.internal.m.e(type, "memberProjection.type");
            if (k1Var.a() == w1.IN_VARIANCE) {
                objD = factory.c("java/lang/Object");
            } else {
                w1 w1VarA = k1Var.a();
                kotlin.jvm.internal.m.e(w1VarA, "memberProjection.projectionKind");
                objD = d(type, factory, mode.f(w1VarA, true), typeMappingConfiguration, lVar, writeGenericType);
            }
            return (T) factory.b('[' + factory.a(objD));
        }
        if (!z10) {
            if (hVarD instanceof f1) {
                g0 g0VarJ = oa.a.j((f1) hVarD);
                if (kotlinType.K0()) {
                    g0VarJ = oa.a.w(g0VarJ);
                }
                return (T) d(g0VarJ, factory, mode, typeMappingConfiguration, null, sa.e.b());
            }
            if ((hVarD instanceof e1) && mode.b()) {
                return (T) d(((e1) hVarD).R(), factory, mode, typeMappingConfiguration, lVar, writeGenericType);
            }
            throw new UnsupportedOperationException("Unknown type " + kotlinType);
        }
        if (kotlin.reflect.jvm.internal.impl.resolve.g.b(hVarD) && !mode.c() && (g0Var = (g0) kotlin.reflect.jvm.internal.impl.types.z.a(qVar, kotlinType)) != null) {
            return (T) d(g0Var, factory, mode.g(), typeMappingConfiguration, lVar, writeGenericType);
        }
        if (mode.e() && kotlin.reflect.jvm.internal.impl.builtins.h.l0((kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD)) {
            tA = (Object) factory.e();
        } else {
            kotlin.reflect.jvm.internal.impl.descriptors.e eVar = (kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD;
            kotlin.reflect.jvm.internal.impl.descriptors.e eVarA = eVar.a();
            kotlin.jvm.internal.m.e(eVarA, "descriptor.original");
            tA = typeMappingConfiguration.a(eVarA);
            if (tA == null) {
                if (eVar.g() == kotlin.reflect.jvm.internal.impl.descriptors.f.ENUM_ENTRY) {
                    kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = eVar.b();
                    kotlin.jvm.internal.m.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    eVar = (kotlin.reflect.jvm.internal.impl.descriptors.e) mVarB;
                }
                kotlin.reflect.jvm.internal.impl.descriptors.e eVarA2 = eVar.a();
                kotlin.jvm.internal.m.e(eVarA2, "enumClassIfEnumEntry.original");
                tA = (Object) factory.c(a(eVarA2, typeMappingConfiguration));
            }
        }
        writeGenericType.invoke(kotlinType, tA, mode);
        return tA;
    }

    public static /* synthetic */ Object e(g0 g0Var, o oVar, c0 c0Var, a0 a0Var, l lVar, c9.q qVar, int i10, Object obj) {
        if ((i10 & 32) != 0) {
            qVar = sa.e.b();
        }
        return d(g0Var, oVar, c0Var, a0Var, lVar, qVar);
    }
}
