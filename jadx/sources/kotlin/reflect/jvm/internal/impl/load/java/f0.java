package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class f0 {
    public static final List<ba.f> a(ba.f name) {
        kotlin.jvm.internal.m.f(name, "name");
        String strF = name.f();
        kotlin.jvm.internal.m.e(strF, "name.asString()");
        if (a0.c(strF)) {
            return kotlin.collections.r.p(b(name));
        }
        return a0.d(strF) ? f(name) : g.f13202a.b(name);
    }

    public static final ba.f b(ba.f methodName) {
        kotlin.jvm.internal.m.f(methodName, "methodName");
        ba.f fVarE = e(methodName, "get", false, null, 12, null);
        return fVarE == null ? e(methodName, "is", false, null, 8, null) : fVarE;
    }

    public static final ba.f c(ba.f methodName, boolean z10) {
        kotlin.jvm.internal.m.f(methodName, "methodName");
        return e(methodName, "set", false, z10 ? "is" : null, 4, null);
    }

    static /* synthetic */ ba.f e(ba.f fVar, String str, boolean z10, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        if ((i10 & 8) != 0) {
            str2 = null;
        }
        return d(fVar, str, z10, str2);
    }

    public static final List<ba.f> f(ba.f methodName) {
        kotlin.jvm.internal.m.f(methodName, "methodName");
        return kotlin.collections.r.q(c(methodName, false), c(methodName, true));
    }

    private static final ba.f d(ba.f fVar, String str, boolean z10, String str2) {
        if (fVar.m()) {
            return null;
        }
        String strJ = fVar.j();
        kotlin.jvm.internal.m.e(strJ, "methodName.identifier");
        if (!ua.n.I(strJ, str, false, 2, null) || strJ.length() == str.length()) {
            return null;
        }
        char cCharAt = strJ.charAt(str.length());
        if ('a' <= cCharAt && cCharAt < '{') {
            return null;
        }
        if (str2 != null) {
            return ba.f.l(str2 + ua.n.s0(strJ, str));
        }
        if (!z10) {
            return fVar;
        }
        String strC = qa.a.c(ua.n.s0(strJ, str), true);
        if (!ba.f.n(strC)) {
            return null;
        }
        return ba.f.l(strC);
    }
}
