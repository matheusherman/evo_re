package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class v extends a0 implements na.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c1 f14381d;

    @Override // kotlin.reflect.jvm.internal.impl.types.a0, kotlin.reflect.jvm.internal.impl.types.g0
    public boolean K0() {
        return false;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public v(kotlin.reflect.jvm.internal.impl.builtins.h builtIns, c1 attributes) {
        kotlin.jvm.internal.m.f(builtIns, "builtIns");
        kotlin.jvm.internal.m.f(attributes, "attributes");
        o0 o0VarH = builtIns.H();
        kotlin.jvm.internal.m.e(o0VarH, "builtIns.nothingType");
        o0 o0VarI = builtIns.I();
        kotlin.jvm.internal.m.e(o0VarI, "builtIns.nullableAnyType");
        super(o0VarH, o0VarI);
        this.f14381d = attributes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a0, kotlin.reflect.jvm.internal.impl.types.g0
    public c1 I0() {
        return this.f14381d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a0
    public String T0(kotlin.reflect.jvm.internal.impl.renderer.c renderer, kotlin.reflect.jvm.internal.impl.renderer.f options) {
        kotlin.jvm.internal.m.f(renderer, "renderer");
        kotlin.jvm.internal.m.f(options, "options");
        return "dynamic";
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: V0, reason: merged with bridge method [inline-methods] */
    public v T0(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public v P0(c1 newAttributes) {
        kotlin.jvm.internal.m.f(newAttributes, "newAttributes");
        return new v(oa.a.i(Q0()), newAttributes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a0
    public o0 Q0() {
        return S0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public v N0(boolean z10) {
        return this;
    }
}
