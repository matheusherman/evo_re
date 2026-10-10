package oa;

import c9.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.IndexedValue;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.i;
import kotlin.reflect.jvm.internal.impl.types.a0;
import kotlin.reflect.jvm.internal.impl.types.d1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.h0;
import kotlin.reflect.jvm.internal.impl.types.k1;
import kotlin.reflect.jvm.internal.impl.types.m1;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.o1;
import kotlin.reflect.jvm.internal.impl.types.p;
import kotlin.reflect.jvm.internal.impl.types.s1;
import kotlin.reflect.jvm.internal.impl.types.u0;
import kotlin.reflect.jvm.internal.impl.types.u1;
import kotlin.reflect.jvm.internal.impl.types.v1;
import kotlin.reflect.jvm.internal.impl.types.w0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import r8.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class a {

    /* JADX INFO: renamed from: oa.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class C0321a extends o implements l<v1, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0321a f16514a = new C0321a();

        C0321a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(v1 it) {
            m.f(it, "it");
            h hVarD = it.J0().d();
            return Boolean.valueOf(hVarD != null ? a.s(hVarD) : false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends o implements l<v1, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f16516a = new c();

        c() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(v1 it) {
            m.f(it, "it");
            h hVarD = it.J0().d();
            boolean z10 = false;
            if (hVarD != null && ((hVarD instanceof e1) || (hVarD instanceof f1))) {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends o implements l<v1, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f16515a = new b();

        b() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(v1 v1Var) {
            return Boolean.valueOf(s1.m(v1Var));
        }
    }

    public static final k1 a(g0 g0Var) {
        m.f(g0Var, "<this>");
        return new m1(g0Var);
    }

    public static final boolean b(g0 g0Var, l<? super v1, Boolean> predicate) {
        m.f(g0Var, "<this>");
        m.f(predicate, "predicate");
        return s1.c(g0Var, predicate);
    }

    public static final boolean d(g0 g0Var) {
        m.f(g0Var, "<this>");
        return b(g0Var, C0321a.f16514a);
    }

    public static final boolean e(g0 g0Var) {
        m.f(g0Var, "<this>");
        return s1.c(g0Var, b.f16515a);
    }

    public static final k1 f(g0 type, w1 projectionKind, f1 f1Var) {
        m.f(type, "type");
        m.f(projectionKind, "projectionKind");
        if ((f1Var != null ? f1Var.j() : null) == projectionKind) {
            projectionKind = w1.INVARIANT;
        }
        return new m1(projectionKind, type);
    }

    public static final Set<f1> g(g0 g0Var, Set<? extends f1> set) {
        m.f(g0Var, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        h(g0Var, g0Var, linkedHashSet, set);
        return linkedHashSet;
    }

    public static final kotlin.reflect.jvm.internal.impl.builtins.h i(g0 g0Var) {
        m.f(g0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.builtins.h hVarL = g0Var.J0().l();
        m.e(hVarL, "constructor.builtIns");
        return hVarL;
    }

    public static final g0 j(f1 f1Var) {
        Object obj;
        m.f(f1Var, "<this>");
        List<g0> upperBounds = f1Var.getUpperBounds();
        m.e(upperBounds, "upperBounds");
        upperBounds.isEmpty();
        List<g0> upperBounds2 = f1Var.getUpperBounds();
        m.e(upperBounds2, "upperBounds");
        Iterator<T> it = upperBounds2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            h hVarD = ((g0) next).J0().d();
            e eVar = hVarD instanceof e ? (e) hVarD : null;
            if (eVar != null && eVar.g() != f.INTERFACE && eVar.g() != f.ANNOTATION_CLASS) {
                obj = next;
                break;
            }
        }
        g0 g0Var = (g0) obj;
        if (g0Var != null) {
            return g0Var;
        }
        List<g0> upperBounds3 = f1Var.getUpperBounds();
        m.e(upperBounds3, "upperBounds");
        Object objG0 = r.g0(upperBounds3);
        m.e(objG0, "upperBounds.first()");
        return (g0) objG0;
    }

    public static final boolean k(f1 typeParameter) {
        m.f(typeParameter, "typeParameter");
        return m(typeParameter, null, null, 6, null);
    }

    public static final boolean l(f1 typeParameter, g1 g1Var, Set<? extends f1> set) {
        m.f(typeParameter, "typeParameter");
        List<g0> upperBounds = typeParameter.getUpperBounds();
        m.e(upperBounds, "typeParameter.upperBounds");
        List<g0> list = upperBounds;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (g0 upperBound : list) {
            m.e(upperBound, "upperBound");
            if (c(upperBound, typeParameter.p().J0(), set) && (g1Var == null || m.a(upperBound.J0(), g1Var))) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean m(f1 f1Var, g1 g1Var, Set set, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            g1Var = null;
        }
        if ((i10 & 4) != 0) {
            set = null;
        }
        return l(f1Var, g1Var, set);
    }

    public static final boolean n(g0 g0Var) {
        m.f(g0Var, "<this>");
        return kotlin.reflect.jvm.internal.impl.builtins.h.f0(g0Var);
    }

    public static final boolean o(g0 g0Var) {
        m.f(g0Var, "<this>");
        return kotlin.reflect.jvm.internal.impl.builtins.h.n0(g0Var);
    }

    public static final boolean p(g0 g0Var) {
        m.f(g0Var, "<this>");
        if (g0Var instanceof kotlin.reflect.jvm.internal.impl.types.e) {
            return true;
        }
        return (g0Var instanceof p) && (((p) g0Var).V0() instanceof kotlin.reflect.jvm.internal.impl.types.e);
    }

    public static final boolean q(g0 g0Var) {
        m.f(g0Var, "<this>");
        if (g0Var instanceof w0) {
            return true;
        }
        return (g0Var instanceof p) && (((p) g0Var).V0() instanceof w0);
    }

    public static final boolean r(g0 g0Var, g0 superType) {
        m.f(g0Var, "<this>");
        m.f(superType, "superType");
        return kotlin.reflect.jvm.internal.impl.types.checker.e.f14235a.d(g0Var, superType);
    }

    public static final boolean s(h hVar) {
        m.f(hVar, "<this>");
        return (hVar instanceof f1) && (((f1) hVar).b() instanceof e1);
    }

    public static final boolean t(g0 g0Var) {
        m.f(g0Var, "<this>");
        return s1.m(g0Var);
    }

    public static final boolean u(g0 type) {
        m.f(type, "type");
        return (type instanceof la.h) && ((la.h) type).T0().i();
    }

    public static final g0 v(g0 g0Var) {
        m.f(g0Var, "<this>");
        g0 g0VarN = s1.n(g0Var);
        m.e(g0VarN, "makeNotNullable(this)");
        return g0VarN;
    }

    public static final g0 w(g0 g0Var) {
        m.f(g0Var, "<this>");
        g0 g0VarO = s1.o(g0Var);
        m.e(g0VarO, "makeNullable(this)");
        return g0VarO;
    }

    public static final g0 x(g0 g0Var, g newAnnotations) {
        m.f(g0Var, "<this>");
        m.f(newAnnotations, "newAnnotations");
        return (g0Var.getAnnotations().isEmpty() && newAnnotations.isEmpty()) ? g0Var : g0Var.M0().P0(d1.a(g0Var.I0(), newAnnotations));
    }

    public static final g0 y(g0 g0Var) {
        o0 o0Var;
        v1 v1VarF;
        m.f(g0Var, "<this>");
        v1 v1VarM0 = g0Var.M0();
        if (v1VarM0 instanceof a0) {
            a0 a0Var = (a0) v1VarM0;
            o0 o0VarR0 = a0Var.R0();
            if (!o0VarR0.J0().getParameters().isEmpty() && o0VarR0.J0().d() != null) {
                List<f1> parameters = o0VarR0.J0().getParameters();
                m.e(parameters, "constructor.parameters");
                List<f1> list = parameters;
                ArrayList arrayList = new ArrayList(r.w(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new u0((f1) it.next()));
                }
                o0VarR0 = o1.f(o0VarR0, arrayList, null, 2, null);
            }
            o0 o0VarS0 = a0Var.S0();
            if (!o0VarS0.J0().getParameters().isEmpty() && o0VarS0.J0().d() != null) {
                List<f1> parameters2 = o0VarS0.J0().getParameters();
                m.e(parameters2, "constructor.parameters");
                List<f1> list2 = parameters2;
                ArrayList arrayList2 = new ArrayList(r.w(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new u0((f1) it2.next()));
                }
                o0VarS0 = o1.f(o0VarS0, arrayList2, null, 2, null);
            }
            v1VarF = h0.d(o0VarR0, o0VarS0);
        } else {
            if (!(v1VarM0 instanceof o0)) {
                throw new n();
            }
            o0Var = (o0) v1VarM0;
            if (!o0Var.J0().getParameters().isEmpty() && o0Var.J0().d() != null) {
                v1VarF = o0Var;
                v1VarF = o0Var;
                List<f1> parameters3 = o0Var.J0().getParameters();
                m.e(parameters3, "constructor.parameters");
                List<f1> list3 = parameters3;
                ArrayList arrayList3 = new ArrayList(r.w(list3, 10));
                Iterator<T> it3 = list3.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(new u0((f1) it3.next()));
                }
                v1VarF = o1.f(o0Var, arrayList3, null, 2, null);
            }
        }
        v1VarF = o0Var;
        v1VarF = o0Var;
        v1VarF = o0Var;
        return u1.b(v1VarF, v1VarM0);
    }

    public static final boolean z(g0 g0Var) {
        m.f(g0Var, "<this>");
        return b(g0Var, c.f16516a);
    }

    private static final boolean c(g0 g0Var, g1 g1Var, Set<? extends f1> set) {
        i iVar;
        List<f1> listR;
        f1 f1Var;
        boolean zC;
        if (m.a(g0Var.J0(), g1Var)) {
            return true;
        }
        h hVarD = g0Var.J0().d();
        if (hVarD instanceof i) {
            iVar = (i) hVarD;
        } else {
            iVar = null;
        }
        if (iVar != null) {
            listR = iVar.r();
        } else {
            listR = null;
        }
        Iterable<IndexedValue> iterableU0 = r.U0(g0Var.H0());
        if ((iterableU0 instanceof Collection) && ((Collection) iterableU0).isEmpty()) {
            return false;
        }
        for (IndexedValue indexedValue : iterableU0) {
            int index = indexedValue.getIndex();
            k1 k1Var = (k1) indexedValue.b();
            if (listR != null) {
                f1Var = (f1) r.j0(listR, index);
            } else {
                f1Var = null;
            }
            if ((f1Var != null && set != null && set.contains(f1Var)) || k1Var.b()) {
                zC = false;
            } else {
                g0 type = k1Var.getType();
                m.e(type, "argument.type");
                zC = c(type, g1Var, set);
            }
            if (zC) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void h(g0 g0Var, g0 g0Var2, Set<f1> set, Set<? extends f1> set2) {
        i iVar;
        List<f1> listR;
        f1 f1Var;
        h hVarD = g0Var.J0().d();
        if (hVarD instanceof f1) {
            if (!m.a(g0Var.J0(), g0Var2.J0())) {
                set.add(hVarD);
                return;
            }
            for (g0 upperBound : ((f1) hVarD).getUpperBounds()) {
                m.e(upperBound, "upperBound");
                h(upperBound, g0Var2, set, set2);
            }
            return;
        }
        h hVarD2 = g0Var.J0().d();
        if (hVarD2 instanceof i) {
            iVar = (i) hVarD2;
        } else {
            iVar = null;
        }
        if (iVar != null) {
            listR = iVar.r();
        } else {
            listR = null;
        }
        int i10 = 0;
        for (k1 k1Var : g0Var.H0()) {
            int i11 = i10 + 1;
            if (listR != null) {
                f1Var = (f1) r.j0(listR, i10);
            } else {
                f1Var = null;
            }
            if ((f1Var == null || set2 == null || !set2.contains(f1Var)) && !k1Var.b() && !r.a0(set, k1Var.getType().J0().d()) && !m.a(k1Var.getType().J0(), g0Var2.J0())) {
                g0 type = k1Var.getType();
                m.e(type, "argument.type");
                h(type, g0Var2, set, set2);
            }
            i10 = i11;
        }
    }
}
