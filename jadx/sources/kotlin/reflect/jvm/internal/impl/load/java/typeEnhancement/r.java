package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.b0;
import kotlin.reflect.jvm.internal.impl.types.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g f13480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f13481b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13482a;

        static {
            int[] iArr = new int[h.values().length];
            try {
                iArr[h.NULLABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[h.NOT_NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f13482a = iArr;
        }
    }

    static {
        ba.c ENHANCED_NULLABILITY_ANNOTATION = b0.f13129u;
        kotlin.jvm.internal.m.e(ENHANCED_NULLABILITY_ANNOTATION, "ENHANCED_NULLABILITY_ANNOTATION");
        f13480a = new c(ENHANCED_NULLABILITY_ANNOTATION);
        ba.c ENHANCED_MUTABILITY_ANNOTATION = b0.f13130v;
        kotlin.jvm.internal.m.e(ENHANCED_MUTABILITY_ANNOTATION, "ENHANCED_MUTABILITY_ANNOTATION");
        f13481b = new c(ENHANCED_MUTABILITY_ANNOTATION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.h f(kotlin.reflect.jvm.internal.impl.descriptors.h hVar, e eVar, o oVar) {
        kotlin.reflect.jvm.internal.impl.builtins.jvm.d dVar = kotlin.reflect.jvm.internal.impl.builtins.jvm.d.f12525a;
        if (!p.a(oVar) || !(hVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.e)) {
            return null;
        }
        if (eVar.c() == f.READ_ONLY && oVar == o.FLEXIBLE_LOWER) {
            kotlin.reflect.jvm.internal.impl.descriptors.e eVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.e) hVar;
            if (dVar.c(eVar2)) {
                return dVar.a(eVar2);
            }
        }
        if (eVar.c() == f.MUTABLE && oVar == o.FLEXIBLE_UPPER) {
            kotlin.reflect.jvm.internal.impl.descriptors.e eVar3 = (kotlin.reflect.jvm.internal.impl.descriptors.e) hVar;
            if (dVar.d(eVar3)) {
                return dVar.b(eVar3);
            }
        }
        return null;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g g() {
        return f13480a;
    }

    public static final boolean i(g0 g0Var) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        return s.c(kotlin.reflect.jvm.internal.impl.types.checker.q.f14258a, g0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g e(List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.g> list) {
        int size = list.size();
        if (size != 0) {
            if (size != 1) {
                return new kotlin.reflect.jvm.internal.impl.descriptors.annotations.k((List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.g>) kotlin.collections.r.O0(list));
            }
            return (kotlin.reflect.jvm.internal.impl.descriptors.annotations.g) kotlin.collections.r.F0(list);
        }
        throw new IllegalStateException("At least one Annotations object expected");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean h(e eVar, o oVar) {
        int i10;
        if (!p.a(oVar)) {
            return null;
        }
        h hVarD = eVar.d();
        if (hVarD == null) {
            i10 = -1;
        } else {
            i10 = a.f13482a[hVarD.ordinal()];
        }
        if (i10 != 1) {
            if (i10 != 2) {
                return null;
            }
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
