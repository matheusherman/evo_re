package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.collections.n0;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.k;
import kotlin.reflect.jvm.internal.impl.load.java.b0;
import r8.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f13167a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ba.f f13168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ba.f f13169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ba.f f13170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<ba.c, ba.c> f13171e;

    static {
        ba.f fVarL = ba.f.l("message");
        m.e(fVarL, "identifier(\"message\")");
        f13168b = fVarL;
        ba.f fVarL2 = ba.f.l("allowedTargets");
        m.e(fVarL2, "identifier(\"allowedTargets\")");
        f13169c = fVarL2;
        ba.f fVarL3 = ba.f.l("value");
        m.e(fVarL3, "identifier(\"value\")");
        f13170d = fVarL3;
        f13171e = n0.l(v.a(k.a.H, b0.f13112d), v.a(k.a.L, b0.f13114f), v.a(k.a.P, b0.f13117i));
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.annotations.c f(c cVar, u9.a aVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return cVar.e(aVar, gVar, z10);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c a(ba.c kotlinName, u9.d annotationOwner, kotlin.reflect.jvm.internal.impl.load.java.lazy.g c10) {
        u9.a aVarJ;
        m.f(kotlinName, "kotlinName");
        m.f(annotationOwner, "annotationOwner");
        m.f(c10, "c");
        if (m.a(kotlinName, k.a.f12646y)) {
            ba.c DEPRECATED_ANNOTATION = b0.f13116h;
            m.e(DEPRECATED_ANNOTATION, "DEPRECATED_ANNOTATION");
            u9.a aVarJ2 = annotationOwner.j(DEPRECATED_ANNOTATION);
            if (aVarJ2 != null || annotationOwner.l()) {
                return new e(aVarJ2, c10);
            }
        }
        ba.c cVar = f13171e.get(kotlinName);
        if (cVar == null || (aVarJ = annotationOwner.j(cVar)) == null) {
            return null;
        }
        return f(f13167a, aVarJ, c10, false, 4, null);
    }

    public final ba.f b() {
        return f13168b;
    }

    public final ba.f c() {
        return f13170d;
    }

    public final ba.f d() {
        return f13169c;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c e(u9.a annotation, kotlin.reflect.jvm.internal.impl.load.java.lazy.g c10, boolean z10) {
        m.f(annotation, "annotation");
        m.f(c10, "c");
        ba.b bVarE = annotation.e();
        if (m.a(bVarE, ba.b.m(b0.f13112d))) {
            return new i(annotation, c10);
        }
        if (m.a(bVarE, ba.b.m(b0.f13114f))) {
            return new h(annotation, c10);
        }
        if (m.a(bVarE, ba.b.m(b0.f13117i))) {
            return new b(c10, annotation, k.a.P);
        }
        if (m.a(bVarE, ba.b.m(b0.f13116h))) {
            return null;
        }
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.e(c10, annotation, z10);
    }

    private c() {
    }
}
