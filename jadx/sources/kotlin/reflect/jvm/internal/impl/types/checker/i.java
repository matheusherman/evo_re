package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.k1;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.v1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class i extends o0 implements na.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final na.b f14239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j f14240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final v1 f14241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c1 f14242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f14243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f14244g;

    public /* synthetic */ i(na.b bVar, j jVar, v1 v1Var, c1 c1Var, boolean z10, boolean z11, int i10, kotlin.jvm.internal.g gVar) {
        this(bVar, jVar, v1Var, (i10 & 8) != 0 ? c1.f14231b.h() : c1Var, (i10 & 16) != 0 ? false : z10, (i10 & 32) != 0 ? false : z11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public c1 I0() {
        return this.f14242e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public boolean K0() {
        return this.f14243f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: R0 */
    public o0 P0(c1 newAttributes) {
        kotlin.jvm.internal.m.f(newAttributes, "newAttributes");
        return new i(this.f14239b, J0(), this.f14241d, newAttributes, K0(), this.f14244g);
    }

    public final na.b S0() {
        return this.f14239b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] */
    public j J0() {
        return this.f14240c;
    }

    public final v1 U0() {
        return this.f14241d;
    }

    public final boolean V0() {
        return this.f14244g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.o0
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public i N0(boolean z10) {
        return new i(this.f14239b, J0(), this.f14241d, I0(), z10, false, 32, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public i T0(g kotlinTypeRefiner) {
        kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        na.b bVar = this.f14239b;
        j jVarK = J0().c(kotlinTypeRefiner);
        v1 v1Var = this.f14241d;
        return new i(bVar, jVarK, v1Var != null ? kotlinTypeRefiner.a(v1Var).M0() : null, I0(), K0(), false, 32, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h n() {
        return la.k.a(la.g.CAPTURED_TYPE_SCOPE, true, new String[0]);
    }

    public i(na.b captureStatus, j constructor, v1 v1Var, c1 attributes, boolean z10, boolean z11) {
        kotlin.jvm.internal.m.f(captureStatus, "captureStatus");
        kotlin.jvm.internal.m.f(constructor, "constructor");
        kotlin.jvm.internal.m.f(attributes, "attributes");
        this.f14239b = captureStatus;
        this.f14240c = constructor;
        this.f14241d = v1Var;
        this.f14242e = attributes;
        this.f14243f = z10;
        this.f14244g = z11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public List<k1> H0() {
        return kotlin.collections.r.l();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public i(na.b captureStatus, v1 v1Var, k1 projection, f1 typeParameter) {
        kotlin.jvm.internal.m.f(captureStatus, "captureStatus");
        kotlin.jvm.internal.m.f(projection, "projection");
        kotlin.jvm.internal.m.f(typeParameter, "typeParameter");
        c1 c1Var = null;
        boolean z10 = false;
        boolean z11 = false;
        this(captureStatus, new j(projection, null, null, typeParameter, 6, null), v1Var, c1Var, z10, z11, 56, null);
    }
}
