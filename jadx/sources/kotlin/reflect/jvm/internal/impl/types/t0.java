package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class t0 extends l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g0 f14375a;

    @Override // kotlin.reflect.jvm.internal.impl.types.k1
    public boolean b() {
        return true;
    }

    public t0(kotlin.reflect.jvm.internal.impl.builtins.h kotlinBuiltIns) {
        kotlin.jvm.internal.m.f(kotlinBuiltIns, "kotlinBuiltIns");
        o0 o0VarI = kotlinBuiltIns.I();
        kotlin.jvm.internal.m.e(o0VarI, "kotlinBuiltIns.nullableAnyType");
        this.f14375a = o0VarI;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k1
    public w1 a() {
        return w1.OUT_VARIANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k1
    public k1 c(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k1
    public g0 getType() {
        return this.f14375a;
    }
}
