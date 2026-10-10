package la;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.collections.r;
import kotlin.collections.v0;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.k1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f15326a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final h0 f15327b = d.f15260a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a f15328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final g0 f15329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final g0 f15330e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final u0 f15331f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Set<u0> f15332g;

    public static final boolean o(g0 g0Var) {
        if (g0Var == null) {
            return false;
        }
        g1 g1VarJ0 = g0Var.J0();
        return (g1VarJ0 instanceof i) && ((i) g1VarJ0).g() == j.f15322w;
    }

    static {
        String str = String.format(b.ERROR_CLASS.f(), Arrays.copyOf(new Object[]{"unknown class"}, 1));
        m.e(str, "format(this, *args)");
        ba.f fVarO = ba.f.o(str);
        m.e(fVarO, "special(ErrorEntity.ERRO….format(\"unknown class\"))");
        f15328c = new a(fVarO);
        f15329d = d(j.f15319t, new String[0]);
        f15330e = d(j.S1, new String[0]);
        e eVar = new e();
        f15331f = eVar;
        f15332g = v0.d(eVar);
    }

    public static final f a(g kind, boolean z10, String... formatParams) {
        m.f(kind, "kind");
        m.f(formatParams, "formatParams");
        return z10 ? new l(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length)) : new f(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public static final f b(g kind, String... formatParams) {
        m.f(kind, "kind");
        m.f(formatParams, "formatParams");
        return a(kind, false, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public static final h d(j kind, String... formatParams) {
        m.f(kind, "kind");
        m.f(formatParams, "formatParams");
        return f15326a.g(kind, r.l(), (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public static final boolean m(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (mVar == null) {
            return false;
        }
        k kVar = f15326a;
        return kVar.n(mVar) || kVar.n(mVar.b()) || mVar == f15327b;
    }

    private final boolean n(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        return mVar instanceof a;
    }

    public final h c(j kind, g1 typeConstructor, String... formatParams) {
        m.f(kind, "kind");
        m.f(typeConstructor, "typeConstructor");
        m.f(formatParams, "formatParams");
        return f(kind, r.l(), typeConstructor, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public final i e(j kind, String... formatParams) {
        m.f(kind, "kind");
        m.f(formatParams, "formatParams");
        return new i(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public final h f(j kind, List<? extends k1> arguments, g1 typeConstructor, String... formatParams) {
        m.f(kind, "kind");
        m.f(arguments, "arguments");
        m.f(typeConstructor, "typeConstructor");
        m.f(formatParams, "formatParams");
        return new h(typeConstructor, b(g.ERROR_TYPE_SCOPE, typeConstructor.toString()), kind, arguments, false, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public final h g(j kind, List<? extends k1> arguments, String... formatParams) {
        m.f(kind, "kind");
        m.f(arguments, "arguments");
        m.f(formatParams, "formatParams");
        return f(kind, arguments, e(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length)), (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public final a h() {
        return f15328c;
    }

    public final h0 i() {
        return f15327b;
    }

    public final Set<u0> j() {
        return f15332g;
    }

    public final g0 k() {
        return f15330e;
    }

    public final g0 l() {
        return f15329d;
    }

    public final String p(g0 type) {
        m.f(type, "type");
        oa.a.u(type);
        g1 g1VarJ0 = type.J0();
        m.d(g1VarJ0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
        return ((i) g1VarJ0).h(0);
    }

    private k() {
    }
}
