package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.reflect.jvm.internal.impl.descriptors.i0;
import kotlin.reflect.jvm.internal.impl.descriptors.k1;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.o0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ba.c f13929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ba.b f13930b;

    static {
        ba.c cVar = new ba.c("kotlin.jvm.JvmInline");
        f13929a = cVar;
        ba.b bVarM = ba.b.m(cVar);
        kotlin.jvm.internal.m.e(bVarM, "topLevel(JVM_INLINE_ANNOTATION_FQ_NAME)");
        f13930b = bVarM;
    }

    public static final boolean a(kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        kotlin.jvm.internal.m.f(aVar, "<this>");
        if (!(aVar instanceof v0)) {
            return false;
        }
        u0 correspondingProperty = ((v0) aVar).x0();
        kotlin.jvm.internal.m.e(correspondingProperty, "correspondingProperty");
        return e(correspondingProperty);
    }

    public static final boolean b(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        kotlin.jvm.internal.m.f(mVar, "<this>");
        return (mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) && (((kotlin.reflect.jvm.internal.impl.descriptors.e) mVar).v0() instanceof z);
    }

    public static final boolean c(g0 g0Var) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = g0Var.J0().d();
        if (hVarD != null) {
            return b(hVarD);
        }
        return false;
    }

    public static final boolean d(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        kotlin.jvm.internal.m.f(mVar, "<this>");
        return (mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) && (((kotlin.reflect.jvm.internal.impl.descriptors.e) mVar).v0() instanceof i0);
    }

    public static final boolean e(k1 k1Var) {
        z<o0> zVarN;
        kotlin.jvm.internal.m.f(k1Var, "<this>");
        if (k1Var.i0() != null) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = k1Var.b();
        ba.f fVarC = null;
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar = mVarB instanceof kotlin.reflect.jvm.internal.impl.descriptors.e ? (kotlin.reflect.jvm.internal.impl.descriptors.e) mVarB : null;
        if (eVar != null && (zVarN = ea.c.n(eVar)) != null) {
            fVarC = zVarN.c();
        }
        return kotlin.jvm.internal.m.a(fVarC, k1Var.getName());
    }

    public static final boolean f(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        kotlin.jvm.internal.m.f(mVar, "<this>");
        return b(mVar) || d(mVar);
    }

    public static final g0 g(g0 g0Var) {
        z<o0> zVarN;
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = g0Var.J0().d();
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar = hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.e ? (kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD : null;
        if (eVar == null || (zVarN = ea.c.n(eVar)) == null) {
            return null;
        }
        return (o0) zVarN.d();
    }
}
