package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.Collection;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.types.checker.g;
import kotlin.reflect.jvm.internal.impl.types.checker.j;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.k1;
import kotlin.reflect.jvm.internal.impl.types.w1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k1 f13892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j f13893b;

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public boolean e() {
        return false;
    }

    public Void g() {
        return null;
    }

    public c(k1 projection) {
        m.f(projection, "projection");
        this.f13892a = projection;
        f().a();
        w1 w1Var = w1.INVARIANT;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b
    public k1 f() {
        return this.f13892a;
    }

    public final j h() {
        return this.f13893b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public c c(g kotlinTypeRefiner) {
        m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        k1 k1VarC = f().c(kotlinTypeRefiner);
        m.e(k1VarC, "projection.refine(kotlinTypeRefiner)");
        return new c(k1VarC);
    }

    public final void j(j jVar) {
        this.f13893b = jVar;
    }

    public String toString() {
        return "CapturedTypeConstructor(" + f() + ')';
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public Collection<g0> b() {
        g0 g0VarI;
        if (f().a() == w1.OUT_VARIANCE) {
            g0VarI = f().getType();
        } else {
            g0VarI = l().I();
        }
        m.e(g0VarI, "if (projection.projectio… builtIns.nullableAnyType");
        return r.e(g0VarI);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public /* bridge */ /* synthetic */ h d() {
        return (h) g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public List<f1> getParameters() {
        return r.l();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public kotlin.reflect.jvm.internal.impl.builtins.h l() {
        kotlin.reflect.jvm.internal.impl.builtins.h hVarL = f().getType().J0().l();
        m.e(hVarL, "projection.type.constructor.builtIns");
        return hVarL;
    }
}
