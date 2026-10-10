package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.types.a0;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.d0;
import kotlin.reflect.jvm.internal.impl.types.d1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.h0;
import kotlin.reflect.jvm.internal.impl.types.i0;
import kotlin.reflect.jvm.internal.impl.types.k1;
import kotlin.reflect.jvm.internal.impl.types.n0;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.s0;
import kotlin.reflect.jvm.internal.impl.types.s1;
import kotlin.reflect.jvm.internal.impl.types.u1;
import kotlin.reflect.jvm.internal.impl.types.v1;
import kotlin.reflect.jvm.internal.impl.types.w1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.c f13430a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final g0 f13431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f13432b;

        public final int a() {
            return this.f13432b;
        }

        public final g0 b() {
            return this.f13431a;
        }

        public a(g0 g0Var, int i10) {
            this.f13431a = g0Var;
            this.f13432b = i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final o0 f13433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f13434b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f13435c;

        public final boolean a() {
            return this.f13435c;
        }

        public final int b() {
            return this.f13434b;
        }

        public final o0 c() {
            return this.f13433a;
        }

        public b(o0 o0Var, int i10, boolean z10) {
            this.f13433a = o0Var;
            this.f13434b = i10;
            this.f13435c = z10;
        }
    }

    public d(kotlin.reflect.jvm.internal.impl.load.java.lazy.c javaResolverSettings) {
        kotlin.jvm.internal.m.f(javaResolverSettings, "javaResolverSettings");
        this.f13430a = javaResolverSettings;
    }

    private final b b(o0 o0Var, c9.l<? super Integer, e> lVar, int i10, o oVar, boolean z10, boolean z11) {
        g1 g1VarJ0;
        Boolean bool;
        a aVar;
        k1 k1VarS;
        c9.l<? super Integer, e> lVar2 = lVar;
        boolean zA = p.a(oVar);
        boolean z12 = (z11 && z10) ? false : true;
        g0 g0Var = null;
        if (!zA && o0Var.H0().isEmpty()) {
            return new b(null, 1, false);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = o0Var.J0().d();
        if (hVarD == null) {
            return new b(null, 1, false);
        }
        e eVarInvoke = lVar2.invoke(Integer.valueOf(i10));
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarF = r.f(hVarD, eVarInvoke, oVar);
        Boolean boolH = r.h(eVarInvoke, oVar);
        if (hVarF == null || (g1VarJ0 = hVarF.h()) == null) {
            g1VarJ0 = o0Var.J0();
        }
        g1 g1Var = g1VarJ0;
        kotlin.jvm.internal.m.e(g1Var, "enhancedClassifier?.typeConstructor ?: constructor");
        int iA = i10 + 1;
        List<k1> listH0 = o0Var.H0();
        List<f1> parameters = g1Var.getParameters();
        kotlin.jvm.internal.m.e(parameters, "typeConstructor.parameters");
        List<f1> list = parameters;
        Iterator<T> it = listH0.iterator();
        Iterator<T> it2 = list.iterator();
        ArrayList arrayList = new ArrayList(Math.min(kotlin.collections.r.w(listH0, 10), kotlin.collections.r.w(list, 10)));
        while (it.hasNext() && it2.hasNext()) {
            Object next = it.next();
            f1 f1Var = (f1) it2.next();
            k1 k1Var = (k1) next;
            if (z12) {
                bool = boolH;
                if (!k1Var.b()) {
                    aVar = d(k1Var.getType().M0(), lVar2, iA, z11);
                } else if (lVar2.invoke(Integer.valueOf(iA)).d() == h.FORCE_FLEXIBILITY) {
                    v1 v1VarM0 = k1Var.getType().M0();
                    aVar = new a(h0.d(d0.c(v1VarM0).N0(false), d0.d(v1VarM0).N0(true)), 1);
                } else {
                    aVar = new a(null, 1);
                }
            } else {
                bool = boolH;
                aVar = new a(g0Var, 0);
            }
            iA += aVar.a();
            if (aVar.b() != null) {
                g0 g0VarB = aVar.b();
                w1 w1VarA = k1Var.a();
                kotlin.jvm.internal.m.e(w1VarA, "arg.projectionKind");
                k1VarS = oa.a.f(g0VarB, w1VarA, f1Var);
            } else if (hVarF == null || k1Var.b()) {
                k1VarS = hVarF != null ? s1.s(f1Var) : null;
            } else {
                g0 type = k1Var.getType();
                kotlin.jvm.internal.m.e(type, "arg.type");
                w1 w1VarA2 = k1Var.a();
                kotlin.jvm.internal.m.e(w1VarA2, "arg.projectionKind");
                k1VarS = oa.a.f(type, w1VarA2, f1Var);
            }
            arrayList.add(k1VarS);
            lVar2 = lVar;
            boolH = bool;
            g0Var = null;
        }
        Boolean bool2 = boolH;
        int i11 = iA - i10;
        if (hVarF == null && bool2 == null) {
            if (!arrayList.isEmpty()) {
                Iterator it3 = arrayList.iterator();
                do {
                    if (it3.hasNext()) {
                    }
                } while (((k1) it3.next()) == null);
            }
            return new b(null, i11, false);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations = o0Var.getAnnotations();
        c cVar = r.f13481b;
        if (hVarF == null) {
            cVar = null;
        }
        c1 c1VarB = d1.b(r.e(kotlin.collections.r.q(annotations, cVar, bool2 != null ? r.g() : null)));
        List<k1> listH1 = o0Var.H0();
        Iterator it4 = arrayList.iterator();
        Iterator<T> it5 = listH1.iterator();
        ArrayList arrayList2 = new ArrayList(Math.min(kotlin.collections.r.w(arrayList, 10), kotlin.collections.r.w(listH1, 10)));
        while (it4.hasNext() && it5.hasNext()) {
            Object next2 = it4.next();
            k1 k1Var2 = (k1) it5.next();
            k1 k1Var3 = (k1) next2;
            if (k1Var3 != null) {
                k1Var2 = k1Var3;
            }
            arrayList2.add(k1Var2);
        }
        o0 o0VarJ = h0.j(c1VarB, g1Var, arrayList2, bool2 != null ? bool2.booleanValue() : o0Var.K0(), null, 16, null);
        if (eVarInvoke.b()) {
            o0VarJ = e(o0VarJ);
        }
        return new b(o0VarJ, i11, bool2 != null && eVarInvoke.e());
    }

    static /* synthetic */ b c(d dVar, o0 o0Var, c9.l lVar, int i10, o oVar, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z10 = false;
        }
        if ((i11 & 16) != 0) {
            z11 = false;
        }
        return dVar.b(o0Var, lVar, i10, oVar, z10, z11);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x009d  */
    private final a d(v1 v1Var, c9.l<? super Integer, e> lVar, int i10, boolean z10) {
        g0 g0VarC;
        g0 g0VarD = null;
        if (i0.a(v1Var)) {
            return new a(null, 1);
        }
        if (!(v1Var instanceof a0)) {
            if (!(v1Var instanceof o0)) {
                throw new r8.n();
            }
            b bVarC = c(this, (o0) v1Var, lVar, i10, o.INFLEXIBLE, false, z10, 8, null);
            return new a(bVarC.a() ? u1.d(v1Var, bVarC.c()) : bVarC.c(), bVarC.b());
        }
        boolean z11 = v1Var instanceof n0;
        a0 a0Var = (a0) v1Var;
        b bVarB = b(a0Var.R0(), lVar, i10, o.FLEXIBLE_LOWER, z11, z10);
        b bVarB2 = b(a0Var.S0(), lVar, i10, o.FLEXIBLE_UPPER, z11, z10);
        bVarB.b();
        bVarB2.b();
        if (bVarB.c() != null || bVarB2.c() != null) {
            if (bVarB.a() || bVarB2.a()) {
                o0 o0VarC = bVarB2.c();
                if (o0VarC == null) {
                    g0VarC = bVarB.c();
                    kotlin.jvm.internal.m.c(g0VarC);
                } else {
                    o0 o0VarC2 = bVarB.c();
                    if (o0VarC2 == null) {
                        o0VarC2 = o0VarC;
                    }
                    g0VarC = h0.d(o0VarC2, o0VarC);
                    if (g0VarC == null) {
                        g0VarC = bVarB.c();
                        kotlin.jvm.internal.m.c(g0VarC);
                    }
                }
                g0VarD = u1.d(v1Var, g0VarC);
            } else if (z11) {
                o0 o0VarC3 = bVarB.c();
                if (o0VarC3 == null) {
                    o0VarC3 = a0Var.R0();
                }
                o0 o0VarC4 = bVarB2.c();
                if (o0VarC4 == null) {
                    o0VarC4 = a0Var.S0();
                }
                g0VarD = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.h(o0VarC3, o0VarC4);
            } else {
                o0 o0VarC5 = bVarB.c();
                if (o0VarC5 == null) {
                    o0VarC5 = a0Var.R0();
                }
                o0 o0VarC6 = bVarB2.c();
                if (o0VarC6 == null) {
                    o0VarC6 = a0Var.S0();
                }
                g0VarD = h0.d(o0VarC5, o0VarC6);
            }
        }
        return new a(g0VarD, bVarB.b());
    }

    private final o0 e(o0 o0Var) {
        return this.f13430a.a() ? s0.h(o0Var, true) : new g(o0Var);
    }

    public final g0 a(g0 g0Var, c9.l<? super Integer, e> qualifiers, boolean z10) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        kotlin.jvm.internal.m.f(qualifiers, "qualifiers");
        return d(g0Var.M0(), qualifiers, 0, z10).b();
    }
}
