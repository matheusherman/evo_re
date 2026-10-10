package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.collections.n0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ba.c f13483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ba.c f13484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ba.c f13485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ba.c f13486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f13487e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ba.c[] f13488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final d0<w> f13489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final w f13490h;

    static {
        ba.c cVar = new ba.c("org.jspecify.nullness");
        f13483a = cVar;
        ba.c cVar2 = new ba.c("org.jspecify.annotations");
        f13484b = cVar2;
        ba.c cVar3 = new ba.c("io.reactivex.rxjava3.annotations");
        f13485c = cVar3;
        ba.c cVar4 = new ba.c("org.checkerframework.checker.nullness.compatqual");
        f13486d = cVar4;
        String strB = cVar3.b();
        kotlin.jvm.internal.m.e(strB, "RXJAVA3_ANNOTATIONS_PACKAGE.asString()");
        f13487e = strB;
        f13488f = new ba.c[]{new ba.c(strB + ".Nullable"), new ba.c(strB + ".NonNull")};
        ba.c cVar5 = new ba.c("org.jetbrains.annotations");
        w.a aVar = w.f13491d;
        r8.p pVarA = r8.v.a(cVar5, aVar.a());
        r8.p pVarA2 = r8.v.a(new ba.c("androidx.annotation"), aVar.a());
        r8.p pVarA3 = r8.v.a(new ba.c("android.support.annotation"), aVar.a());
        r8.p pVarA4 = r8.v.a(new ba.c("android.annotation"), aVar.a());
        r8.p pVarA5 = r8.v.a(new ba.c("com.android.annotations"), aVar.a());
        r8.p pVarA6 = r8.v.a(new ba.c("org.eclipse.jdt.annotation"), aVar.a());
        r8.p pVarA7 = r8.v.a(new ba.c("org.checkerframework.checker.nullness.qual"), aVar.a());
        r8.p pVarA8 = r8.v.a(cVar4, aVar.a());
        r8.p pVarA9 = r8.v.a(new ba.c("javax.annotation"), aVar.a());
        r8.p pVarA10 = r8.v.a(new ba.c("edu.umd.cs.findbugs.annotations"), aVar.a());
        r8.p pVarA11 = r8.v.a(new ba.c("io.reactivex.annotations"), aVar.a());
        ba.c cVar6 = new ba.c("androidx.annotation.RecentlyNullable");
        g0 g0Var = g0.WARN;
        r8.p pVarA12 = r8.v.a(cVar6, new w(g0Var, null, null, 4, null));
        r8.p pVarA13 = r8.v.a(new ba.c("androidx.annotation.RecentlyNonNull"), new w(g0Var, null, null, 4, null));
        r8.p pVarA14 = r8.v.a(new ba.c("lombok"), aVar.a());
        r8.g gVar = new r8.g(1, 9);
        g0 g0Var2 = g0.STRICT;
        f13489g = new e0(n0.l(pVarA, pVarA2, pVarA3, pVarA4, pVarA5, pVarA6, pVarA7, pVarA8, pVarA9, pVarA10, pVarA11, pVarA12, pVarA13, pVarA14, r8.v.a(cVar, new w(g0Var, gVar, g0Var2)), r8.v.a(cVar2, new w(g0Var, new r8.g(1, 9), g0Var2)), r8.v.a(cVar3, new w(g0Var, new r8.g(1, 8), g0Var2))));
        f13490h = new w(g0Var, null, null, 4, null);
    }

    public static final z a(r8.g configuredKotlinVersion) {
        kotlin.jvm.internal.m.f(configuredKotlinVersion, "configuredKotlinVersion");
        w wVar = f13490h;
        g0 g0VarC = (wVar.d() == null || wVar.d().compareTo(configuredKotlinVersion) > 0) ? wVar.c() : wVar.b();
        return new z(g0VarC, c(g0VarC), null, 4, null);
    }

    public static /* synthetic */ z b(r8.g gVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = r8.g.f17857f;
        }
        return a(gVar);
    }

    public static final g0 c(g0 globalReportLevel) {
        kotlin.jvm.internal.m.f(globalReportLevel, "globalReportLevel");
        if (globalReportLevel == g0.WARN) {
            return null;
        }
        return globalReportLevel;
    }

    public static final g0 d(ba.c annotationFqName) {
        kotlin.jvm.internal.m.f(annotationFqName, "annotationFqName");
        return h(annotationFqName, d0.f13192a.a(), null, 4, null);
    }

    public static final ba.c e() {
        return f13484b;
    }

    public static final ba.c[] f() {
        return f13488f;
    }

    public static final g0 g(ba.c annotation, d0<? extends g0> configuredReportLevels, r8.g configuredKotlinVersion) {
        kotlin.jvm.internal.m.f(annotation, "annotation");
        kotlin.jvm.internal.m.f(configuredReportLevels, "configuredReportLevels");
        kotlin.jvm.internal.m.f(configuredKotlinVersion, "configuredKotlinVersion");
        g0 g0VarA = configuredReportLevels.a(annotation);
        if (g0VarA != null) {
            return g0VarA;
        }
        w wVarA = f13489g.a(annotation);
        if (wVarA == null) {
            return g0.IGNORE;
        }
        return (wVarA.d() == null || wVarA.d().compareTo(configuredKotlinVersion) > 0) ? wVarA.c() : wVarA.b();
    }

    public static /* synthetic */ g0 h(ba.c cVar, d0 d0Var, r8.g gVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            gVar = new r8.g(1, 7, 20);
        }
        return g(cVar, d0Var, gVar);
    }
}
