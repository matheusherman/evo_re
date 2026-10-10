package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class g1 {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.l<m, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12757a = new a();

        a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(m it) {
            kotlin.jvm.internal.m.f(it, "it");
            return Boolean.valueOf(it instanceof kotlin.reflect.jvm.internal.impl.descriptors.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.l<m, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f12758a = new b();

        b() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(m it) {
            kotlin.jvm.internal.m.f(it, "it");
            return Boolean.valueOf(!(it instanceof l));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends kotlin.jvm.internal.o implements c9.l<m, ta.h<? extends f1>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f12759a = new c();

        c() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ta.h<f1> invoke(m it) {
            kotlin.jvm.internal.m.f(it, "it");
            List<f1> typeParameters = ((kotlin.reflect.jvm.internal.impl.descriptors.a) it).getTypeParameters();
            kotlin.jvm.internal.m.e(typeParameters, "it as CallableDescriptor).typeParameters");
            return kotlin.collections.r.Z(typeParameters);
        }
    }

    private static final s0 b(kotlin.reflect.jvm.internal.impl.types.g0 g0Var, i iVar, int i10) {
        if (iVar == null || la.k.m(iVar)) {
            return null;
        }
        int size = iVar.r().size() + i10;
        if (iVar.J()) {
            List<kotlin.reflect.jvm.internal.impl.types.k1> listSubList = g0Var.H0().subList(i10, size);
            m mVarB = iVar.b();
            return new s0(iVar, listSubList, b(g0Var, mVarB instanceof i ? (i) mVarB : null, size));
        }
        if (size != g0Var.H0().size()) {
            kotlin.reflect.jvm.internal.impl.resolve.e.E(iVar);
        }
        return new s0(iVar, g0Var.H0().subList(i10, g0Var.H0().size()), null);
    }

    public static final s0 a(kotlin.reflect.jvm.internal.impl.types.g0 g0Var) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        h hVarD = g0Var.J0().d();
        return b(g0Var, hVarD instanceof i ? (i) hVarD : null, 0);
    }

    private static final kotlin.reflect.jvm.internal.impl.descriptors.c c(f1 f1Var, m mVar, int i10) {
        return new kotlin.reflect.jvm.internal.impl.descriptors.c(f1Var, mVar, i10);
    }

    public static final List<f1> d(i iVar) {
        List<f1> listL;
        m next;
        kotlin.reflect.jvm.internal.impl.types.g1 g1VarH;
        kotlin.jvm.internal.m.f(iVar, "<this>");
        List<f1> declaredTypeParameters = iVar.r();
        kotlin.jvm.internal.m.e(declaredTypeParameters, "declaredTypeParameters");
        if (!iVar.J() && !(iVar.b() instanceof kotlin.reflect.jvm.internal.impl.descriptors.a)) {
            return declaredTypeParameters;
        }
        List listP = ta.k.P(ta.k.D(ta.k.y(ta.k.N(ea.c.q(iVar), a.f12757a), b.f12758a), c.f12759a));
        Iterator<m> it = ea.c.q(iVar).iterator();
        do {
            listL = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(next instanceof e));
        e eVar = (e) next;
        if (eVar != null && (g1VarH = eVar.h()) != null) {
            listL = g1VarH.getParameters();
        }
        if (listL == null) {
            listL = kotlin.collections.r.l();
        }
        if (listP.isEmpty() && listL.isEmpty()) {
            List<f1> declaredTypeParameters2 = iVar.r();
            kotlin.jvm.internal.m.e(declaredTypeParameters2, "declaredTypeParameters");
            return declaredTypeParameters2;
        }
        List<f1> listB0 = kotlin.collections.r.B0(listP, listL);
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(listB0, 10));
        for (f1 it2 : listB0) {
            kotlin.jvm.internal.m.e(it2, "it");
            arrayList.add(c(it2, iVar, declaredTypeParameters.size()));
        }
        return kotlin.collections.r.B0(declaredTypeParameters, arrayList);
    }
}
