package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class v0 {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends h1 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<g1> f14382d;

        /* JADX WARN: Multi-variable type inference failed */
        a(List<? extends g1> list) {
            this.f14382d = list;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.h1
        public k1 k(g1 key) {
            kotlin.jvm.internal.m.f(key, "key");
            if (!this.f14382d.contains(key)) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = key.d();
            kotlin.jvm.internal.m.d(hVarD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
            return s1.s((kotlin.reflect.jvm.internal.impl.descriptors.f1) hVarD);
        }
    }

    private static final g0 a(List<? extends g1> list, List<? extends g0> list2, kotlin.reflect.jvm.internal.impl.builtins.h hVar) {
        g0 g0VarP = p1.g(new a(list)).p((g0) kotlin.collections.r.g0(list2), w1.OUT_VARIANCE);
        if (g0VarP == null) {
            g0VarP = hVar.y();
        }
        kotlin.jvm.internal.m.e(g0VarP, "typeParameters: List<Typ… ?: builtIns.defaultBound");
        return g0VarP;
    }

    public static final g0 b(kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var) {
        kotlin.jvm.internal.m.f(f1Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = f1Var.b();
        kotlin.jvm.internal.m.e(mVarB, "this.containingDeclaration");
        if (mVarB instanceof kotlin.reflect.jvm.internal.impl.descriptors.i) {
            List<kotlin.reflect.jvm.internal.impl.descriptors.f1> parameters = ((kotlin.reflect.jvm.internal.impl.descriptors.i) mVarB).h().getParameters();
            kotlin.jvm.internal.m.e(parameters, "descriptor.typeConstructor.parameters");
            List<kotlin.reflect.jvm.internal.impl.descriptors.f1> list = parameters;
            ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                g1 g1VarH = ((kotlin.reflect.jvm.internal.impl.descriptors.f1) it.next()).h();
                kotlin.jvm.internal.m.e(g1VarH, "it.typeConstructor");
                arrayList.add(g1VarH);
            }
            List<g0> upperBounds = f1Var.getUpperBounds();
            kotlin.jvm.internal.m.e(upperBounds, "upperBounds");
            return a(arrayList, upperBounds, ea.c.j(f1Var));
        }
        if (!(mVarB instanceof kotlin.reflect.jvm.internal.impl.descriptors.y)) {
            throw new IllegalArgumentException("Unsupported descriptor type to build star projection type based on type parameters of it");
        }
        List<kotlin.reflect.jvm.internal.impl.descriptors.f1> typeParameters = ((kotlin.reflect.jvm.internal.impl.descriptors.y) mVarB).getTypeParameters();
        kotlin.jvm.internal.m.e(typeParameters, "descriptor.typeParameters");
        List<kotlin.reflect.jvm.internal.impl.descriptors.f1> list2 = typeParameters;
        ArrayList arrayList2 = new ArrayList(kotlin.collections.r.w(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            g1 g1VarH2 = ((kotlin.reflect.jvm.internal.impl.descriptors.f1) it2.next()).h();
            kotlin.jvm.internal.m.e(g1VarH2, "it.typeConstructor");
            arrayList2.add(g1VarH2);
        }
        List<g0> upperBounds2 = f1Var.getUpperBounds();
        kotlin.jvm.internal.m.e(upperBounds2, "upperBounds");
        return a(arrayList2, upperBounds2, ea.c.j(f1Var));
    }
}
