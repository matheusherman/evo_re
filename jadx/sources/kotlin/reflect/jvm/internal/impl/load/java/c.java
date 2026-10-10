package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.n0;
import kotlin.collections.v0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ba.c f13131a = new ba.c("javax.annotation.meta.TypeQualifierNickname");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ba.c f13132b = new ba.c("javax.annotation.meta.TypeQualifier");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ba.c f13133c = new ba.c("javax.annotation.meta.TypeQualifierDefault");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ba.c f13134d = new ba.c("kotlin.annotations.jvm.UnderMigration");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final List<b> f13135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Map<ba.c, r> f13136f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Map<ba.c, r> f13137g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Set<ba.c> f13138h;

    static {
        b bVar = b.VALUE_PARAMETER;
        List<b> listO = kotlin.collections.r.o(b.FIELD, b.METHOD_RETURN_TYPE, bVar, b.TYPE_PARAMETER_BOUNDS, b.TYPE_USE);
        f13135e = listO;
        ba.c cVarL = c0.l();
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.h hVar = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.h.NOT_NULL;
        Map<ba.c, r> mapL = n0.l(r8.v.a(cVarL, new r(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i(hVar, false, 2, null), listO, false)), r8.v.a(c0.i(), new r(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i(hVar, false, 2, null), listO, false)));
        f13136f = mapL;
        f13137g = n0.n(n0.l(r8.v.a(new ba.c("javax.annotation.ParametersAreNullableByDefault"), new r(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.h.NULLABLE, false, 2, null), kotlin.collections.r.e(bVar), false, 4, null)), r8.v.a(new ba.c("javax.annotation.ParametersAreNonnullByDefault"), new r(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i(hVar, false, 2, null), kotlin.collections.r.e(bVar), false, 4, null))), mapL);
        f13138h = v0.h(c0.f(), c0.e());
    }

    public static final Map<ba.c, r> a() {
        return f13137g;
    }

    public static final Set<ba.c> b() {
        return f13138h;
    }

    public static final Map<ba.c, r> c() {
        return f13136f;
    }

    public static final ba.c d() {
        return f13134d;
    }

    public static final ba.c e() {
        return f13133c;
    }

    public static final ba.c f() {
        return f13132b;
    }

    public static final ba.c g() {
        return f13131a;
    }
}
