package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.v0;
import kotlin.reflect.jvm.internal.impl.load.java.b0;
import kotlin.reflect.jvm.internal.impl.types.q1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class s {
    public static final e a(e eVar, Collection<e> superQualifiers, boolean z10, boolean z11, boolean z12) {
        h hVarE;
        boolean z13;
        kotlin.jvm.internal.m.f(eVar, "<this>");
        kotlin.jvm.internal.m.f(superQualifiers, "superQualifiers");
        Collection<e> collection = superQualifiers;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            h hVarB = b((e) it.next());
            if (hVarB != null) {
                arrayList.add(hVarB);
            }
        }
        h hVarE2 = e(kotlin.collections.r.S0(arrayList), b(eVar), z10);
        if (hVarE2 == null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it2 = collection.iterator();
            while (it2.hasNext()) {
                h hVarD = ((e) it2.next()).d();
                if (hVarD != null) {
                    arrayList2.add(hVarD);
                }
            }
            hVarE = e(kotlin.collections.r.S0(arrayList2), eVar.d(), z10);
        } else {
            hVarE = hVarE2;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it3 = collection.iterator();
        while (it3.hasNext()) {
            f fVarC = ((e) it3.next()).c();
            if (fVarC != null) {
                arrayList3.add(fVarC);
            }
        }
        f fVar = (f) d(kotlin.collections.r.S0(arrayList3), f.MUTABLE, f.READ_ONLY, eVar.c(), z10);
        h hVar = null;
        if (hVarE != null && !z12 && (!z11 || hVarE != h.NULLABLE)) {
            hVar = hVarE;
        }
        boolean z14 = false;
        if (hVar != h.NOT_NULL) {
            z13 = false;
        } else {
            if (!eVar.b()) {
                if (!collection.isEmpty()) {
                    Iterator<T> it4 = collection.iterator();
                    while (true) {
                        if (it4.hasNext()) {
                            if (((e) it4.next()).b()) {
                            }
                        }
                    }
                }
                z13 = false;
            }
            z13 = true;
        }
        if (hVar != null && hVarE2 != hVarE) {
            z14 = true;
        }
        return new e(hVar, fVar, z13, z14);
    }

    public static final boolean c(q1 q1Var, na.i type) {
        kotlin.jvm.internal.m.f(q1Var, "<this>");
        kotlin.jvm.internal.m.f(type, "type");
        ba.c ENHANCED_NULLABILITY_ANNOTATION = b0.f13129u;
        kotlin.jvm.internal.m.e(ENHANCED_NULLABILITY_ANNOTATION, "ENHANCED_NULLABILITY_ANNOTATION");
        return q1Var.n0(type, ENHANCED_NULLABILITY_ANNOTATION);
    }

    private static final <T> T d(Set<? extends T> set, T t10, T t11, T t12, boolean z10) {
        Set<? extends T> setS0;
        T t13;
        if (!z10) {
            if (t12 != null && (setS0 = kotlin.collections.r.S0(v0.l(set, t12))) != null) {
                set = setS0;
            }
            return (T) kotlin.collections.r.G0(set);
        }
        if (set.contains(t10)) {
            t13 = t10;
        } else {
            t13 = set.contains(t11) ? t11 : null;
        }
        if (kotlin.jvm.internal.m.a(t13, t10) && kotlin.jvm.internal.m.a(t12, t11)) {
            return null;
        }
        return t12 == null ? t13 : t12;
    }

    private static final h e(Set<? extends h> set, h hVar, boolean z10) {
        h hVar2 = h.FORCE_FLEXIBILITY;
        return hVar == hVar2 ? hVar2 : (h) d(set, h.NOT_NULL, h.NULLABLE, hVar, z10);
    }

    private static final h b(e eVar) {
        if (eVar.e()) {
            return null;
        }
        return eVar.d();
    }
}
