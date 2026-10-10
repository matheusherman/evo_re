package la;

import java.util.Arrays;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.k1;
import kotlin.reflect.jvm.internal.impl.types.o0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class h extends o0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g1 f15280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.h f15281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final j f15282d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<k1> f15283e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f15284f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String[] f15285g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f15286h;

    public /* synthetic */ h(g1 g1Var, kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar, j jVar, List list, boolean z10, String[] strArr, int i10, kotlin.jvm.internal.g gVar) {
        this(g1Var, hVar, jVar, (i10 & 8) != 0 ? r.l() : list, (i10 & 16) != 0 ? false : z10, strArr);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public List<k1> H0() {
        return this.f15283e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public c1 I0() {
        return c1.f14231b.h();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public g1 J0() {
        return this.f15280b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public boolean K0() {
        return this.f15284f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: Q0 */
    public o0 N0(boolean z10) {
        g1 g1VarJ0 = J0();
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarN = n();
        j jVar = this.f15282d;
        List<k1> listH0 = H0();
        String[] strArr = this.f15285g;
        return new h(g1VarJ0, hVarN, jVar, listH0, z10, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: R0 */
    public o0 P0(c1 newAttributes) {
        m.f(newAttributes, "newAttributes");
        return this;
    }

    public final String S0() {
        return this.f15286h;
    }

    public final j T0() {
        return this.f15282d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public h T0(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    public final h V0(List<? extends k1> newArguments) {
        m.f(newArguments, "newArguments");
        g1 g1VarJ0 = J0();
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarN = n();
        j jVar = this.f15282d;
        boolean zK0 = K0();
        String[] strArr = this.f15285g;
        return new h(g1VarJ0, hVarN, jVar, newArguments, zK0, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h n() {
        return this.f15281c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(g1 constructor, kotlin.reflect.jvm.internal.impl.resolve.scopes.h memberScope, j kind, List<? extends k1> arguments, boolean z10, String... formatParams) {
        m.f(constructor, "constructor");
        m.f(memberScope, "memberScope");
        m.f(kind, "kind");
        m.f(arguments, "arguments");
        m.f(formatParams, "formatParams");
        this.f15280b = constructor;
        this.f15281c = memberScope;
        this.f15282d = kind;
        this.f15283e = arguments;
        this.f15284f = z10;
        this.f15285g = formatParams;
        g0 g0Var = g0.f12340a;
        String strF = kind.f();
        Object[] objArrCopyOf = Arrays.copyOf(formatParams, formatParams.length);
        String str = String.format(strF, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        m.e(str, "format(format, *args)");
        this.f15286h = str;
    }
}
