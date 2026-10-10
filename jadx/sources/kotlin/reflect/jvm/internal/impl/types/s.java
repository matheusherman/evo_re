package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class s extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o0 f14369b;

    public s(o0 delegate) {
        kotlin.jvm.internal.m.f(delegate, "delegate");
        this.f14369b = delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: R0 */
    public o0 P0(c1 newAttributes) {
        kotlin.jvm.internal.m.f(newAttributes, "newAttributes");
        return newAttributes != I0() ? new q0(this, newAttributes) : this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.r
    protected o0 S0() {
        return this.f14369b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: Q0 */
    public o0 N0(boolean z10) {
        if (z10 == K0()) {
            return this;
        }
        return S0().N0(z10).P0(I0());
    }
}
