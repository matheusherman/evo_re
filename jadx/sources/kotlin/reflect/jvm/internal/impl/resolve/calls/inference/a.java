package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.k1;
import kotlin.reflect.jvm.internal.impl.types.o0;
import la.k;
import org.apache.log4j.spi.LocationInfo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a extends o0 implements na.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k1 f13888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f13889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f13890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c1 f13891e;

    public /* synthetic */ a(k1 k1Var, b bVar, boolean z10, c1 c1Var, int i10, g gVar) {
        this(k1Var, (i10 & 2) != 0 ? new c(k1Var) : bVar, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? c1.f14231b.h() : c1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public c1 I0() {
        return this.f13891e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public boolean K0() {
        return this.f13890d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: R0 */
    public o0 P0(c1 newAttributes) {
        m.f(newAttributes, "newAttributes");
        return new a(this.f13888b, J0(), K0(), newAttributes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    /* JADX INFO: renamed from: S0, reason: merged with bridge method [inline-methods] */
    public b J0() {
        return this.f13889c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public a T0(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        k1 k1VarC = this.f13888b.c(kotlinTypeRefiner);
        m.e(k1VarC, "typeProjection.refine(kotlinTypeRefiner)");
        return new a(k1VarC, J0(), K0(), I0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public h n() {
        return k.a(la.g.CAPTURED_TYPE_SCOPE, true, new String[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.o0
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Captured(");
        sb2.append(this.f13888b);
        sb2.append(')');
        sb2.append(K0() ? LocationInfo.NA : "");
        return sb2.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public List<k1> H0() {
        return r.l();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.o0
    /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] */
    public a N0(boolean z10) {
        if (z10 == K0()) {
            return this;
        }
        return new a(this.f13888b, J0(), z10, I0());
    }

    public a(k1 typeProjection, b constructor, boolean z10, c1 attributes) {
        m.f(typeProjection, "typeProjection");
        m.f(constructor, "constructor");
        m.f(attributes, "attributes");
        this.f13888b = typeProjection;
        this.f13889c = constructor;
        this.f13890d = z10;
        this.f13891e = attributes;
    }
}
