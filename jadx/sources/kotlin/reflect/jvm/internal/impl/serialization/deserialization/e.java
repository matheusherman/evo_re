package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.o0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h0 f14133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k0 f14134b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14135a;

        static {
            int[] iArr = new int[w9.b.C0384b.c.EnumC0387c.values().length];
            try {
                iArr[w9.b.C0384b.c.EnumC0387c.BYTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[w9.b.C0384b.c.EnumC0387c.CHAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[w9.b.C0384b.c.EnumC0387c.SHORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[w9.b.C0384b.c.EnumC0387c.INT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[w9.b.C0384b.c.EnumC0387c.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[w9.b.C0384b.c.EnumC0387c.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[w9.b.C0384b.c.EnumC0387c.DOUBLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[w9.b.C0384b.c.EnumC0387c.BOOLEAN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[w9.b.C0384b.c.EnumC0387c.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[w9.b.C0384b.c.EnumC0387c.CLASS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[w9.b.C0384b.c.EnumC0387c.ENUM.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[w9.b.C0384b.c.EnumC0387c.ANNOTATION.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[w9.b.C0384b.c.EnumC0387c.ARRAY.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            f14135a = iArr;
        }
    }

    public e(h0 module, k0 notFoundClasses) {
        kotlin.jvm.internal.m.f(module, "module");
        kotlin.jvm.internal.m.f(notFoundClasses, "notFoundClasses");
        this.f14133a = module;
        this.f14134b = notFoundClasses;
    }

    private final kotlin.reflect.jvm.internal.impl.builtins.h c() {
        return this.f14133a.l();
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.e e(ba.b bVar) {
        return kotlin.reflect.jvm.internal.impl.descriptors.x.c(this.f14133a, bVar, this.f14134b);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c a(w9.b proto, y9.c nameResolver) {
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarE = e(w.a(nameResolver, proto.z()));
        Map mapI = n0.i();
        if (proto.w() != 0 && !la.k.m(eVarE) && kotlin.reflect.jvm.internal.impl.resolve.e.t(eVarE)) {
            Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> collectionK = eVarE.k();
            kotlin.jvm.internal.m.e(collectionK, "annotationClass.constructors");
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) kotlin.collections.r.G0(collectionK);
            if (dVar != null) {
                List<j1> listF = dVar.f();
                kotlin.jvm.internal.m.e(listF, "constructor.valueParameters");
                List<j1> list = listF;
                LinkedHashMap linkedHashMap = new LinkedHashMap(h9.f.c(n0.e(kotlin.collections.r.w(list, 10)), 16));
                for (Object obj : list) {
                    linkedHashMap.put(((j1) obj).getName(), obj);
                }
                List<w9.b.C0384b> listX = proto.x();
                kotlin.jvm.internal.m.e(listX, "proto.argumentList");
                ArrayList arrayList = new ArrayList();
                for (w9.b.C0384b it : listX) {
                    kotlin.jvm.internal.m.e(it, "it");
                    r8.p<ba.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> pVarD = d(it, linkedHashMap, nameResolver);
                    if (pVarD != null) {
                        arrayList.add(pVarD);
                    }
                }
                mapI = n0.q(arrayList);
            }
        }
        return new kotlin.reflect.jvm.internal.impl.descriptors.annotations.d(eVarE.p(), mapI, a1.f12668a);
    }

    public final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> f(g0 expectedType, w9.b.C0384b.c value, y9.c nameResolver) {
        kotlin.jvm.internal.m.f(expectedType, "expectedType");
        kotlin.jvm.internal.m.f(value, "value");
        kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
        Boolean boolD = y9.b.O.d(value.O());
        kotlin.jvm.internal.m.e(boolD, "IS_UNSIGNED.get(value.flags)");
        boolean zBooleanValue = boolD.booleanValue();
        w9.b.C0384b.c.EnumC0387c enumC0387cS = value.S();
        switch (enumC0387cS == null ? -1 : a.f14135a[enumC0387cS.ordinal()]) {
            case 1:
                byte bQ = (byte) value.Q();
                return zBooleanValue ? new kotlin.reflect.jvm.internal.impl.resolve.constants.x(bQ) : new kotlin.reflect.jvm.internal.impl.resolve.constants.d(bQ);
            case 2:
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.e((char) value.Q());
            case 3:
                short sQ = (short) value.Q();
                return zBooleanValue ? new kotlin.reflect.jvm.internal.impl.resolve.constants.a0(sQ) : new kotlin.reflect.jvm.internal.impl.resolve.constants.u(sQ);
            case 4:
                int iQ = (int) value.Q();
                return zBooleanValue ? new kotlin.reflect.jvm.internal.impl.resolve.constants.y(iQ) : new kotlin.reflect.jvm.internal.impl.resolve.constants.m(iQ);
            case 5:
                long jQ = value.Q();
                return zBooleanValue ? new kotlin.reflect.jvm.internal.impl.resolve.constants.z(jQ) : new kotlin.reflect.jvm.internal.impl.resolve.constants.r(jQ);
            case 6:
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.l(value.P());
            case 7:
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.i(value.L());
            case 8:
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.c(value.Q() != 0);
            case 9:
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.v(nameResolver.getString(value.R()));
            case 10:
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.q(w.a(nameResolver, value.J()), value.F());
            case 11:
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.j(w.a(nameResolver, value.J()), w.b(nameResolver, value.N()));
            case 12:
                w9.b bVarE = value.E();
                kotlin.jvm.internal.m.e(bVarE, "value.annotation");
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.a(a(bVarE, nameResolver));
            case 13:
                kotlin.reflect.jvm.internal.impl.resolve.constants.h hVar = kotlin.reflect.jvm.internal.impl.resolve.constants.h.f13899a;
                List<w9.b.C0384b.c> listI = value.I();
                kotlin.jvm.internal.m.e(listI, "value.arrayElementList");
                List<w9.b.C0384b.c> list = listI;
                ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
                for (w9.b.C0384b.c it : list) {
                    o0 o0VarI = c().i();
                    kotlin.jvm.internal.m.e(o0VarI, "builtIns.anyType");
                    kotlin.jvm.internal.m.e(it, "it");
                    arrayList.add(f(o0VarI, it, nameResolver));
                }
                return hVar.b(arrayList, expectedType);
            default:
                throw new IllegalStateException(("Unsupported annotation argument type: " + value.S() + " (expected " + expectedType + ')').toString());
        }
    }

    private final boolean b(kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar, g0 g0Var, w9.b.C0384b.c cVar) {
        int i10;
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar;
        w9.b.C0384b.c.EnumC0387c enumC0387cS = cVar.S();
        if (enumC0387cS == null) {
            i10 = -1;
        } else {
            i10 = a.f14135a[enumC0387cS.ordinal()];
        }
        if (i10 != 10) {
            if (i10 != 13) {
                return kotlin.jvm.internal.m.a(gVar.a(this.f14133a), g0Var);
            }
            if ((gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.b) && ((kotlin.reflect.jvm.internal.impl.resolve.constants.b) gVar).b().size() == cVar.I().size()) {
                g0 g0VarK = c().k(g0Var);
                kotlin.jvm.internal.m.e(g0VarK, "builtIns.getArrayElementType(expectedType)");
                kotlin.reflect.jvm.internal.impl.resolve.constants.b bVar = (kotlin.reflect.jvm.internal.impl.resolve.constants.b) gVar;
                Iterable iterableM = kotlin.collections.r.m(bVar.b());
                if ((iterableM instanceof Collection) && ((Collection) iterableM).isEmpty()) {
                    return true;
                }
                Iterator it = iterableM.iterator();
                while (it.hasNext()) {
                    int iNextInt = ((kotlin.collections.k0) it).nextInt();
                    kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar2 = bVar.b().get(iNextInt);
                    w9.b.C0384b.c cVarG = cVar.G(iNextInt);
                    kotlin.jvm.internal.m.e(cVarG, "value.getArrayElement(i)");
                    if (!b(gVar2, g0VarK, cVarG)) {
                        return false;
                    }
                }
                return true;
            }
            throw new IllegalStateException(("Deserialized ArrayValue should have the same number of elements as the original array value: " + gVar).toString());
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = g0Var.J0().d();
        if (hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
            eVar = (kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD;
        } else {
            eVar = null;
        }
        if (eVar != null && !kotlin.reflect.jvm.internal.impl.builtins.h.l0(eVar)) {
            return false;
        }
        return true;
    }

    private final r8.p<ba.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> d(w9.b.C0384b c0384b, Map<ba.f, ? extends j1> map, y9.c cVar) {
        j1 j1Var = map.get(w.b(cVar, c0384b.v()));
        if (j1Var == null) {
            return null;
        }
        ba.f fVarB = w.b(cVar, c0384b.v());
        g0 type = j1Var.getType();
        kotlin.jvm.internal.m.e(type, "parameter.type");
        w9.b.C0384b.c cVarW = c0384b.w();
        kotlin.jvm.internal.m.e(cVarW, "proto.value");
        return new r8.p<>(fVarB, g(type, cVarW, cVar));
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> g(g0 g0Var, w9.b.C0384b.c cVar, y9.c cVar2) {
        kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVarF = f(g0Var, cVar, cVar2);
        if (!b(gVarF, g0Var, cVar)) {
            gVarF = null;
        }
        if (gVarF == null) {
            return kotlin.reflect.jvm.internal.impl.resolve.constants.k.f13902b.a("Unexpected argument value: actual type " + cVar.S() + " != expected type " + g0Var);
        }
        return gVarF;
    }
}
