package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class r extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n1 f13001a;

    public r(n1 delegate) {
        kotlin.jvm.internal.m.f(delegate, "delegate");
        this.f13001a = delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
    public n1 b() {
        return this.f13001a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
    public String c() {
        return b().b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
    public u f() {
        u uVarJ = t.j(b().d());
        kotlin.jvm.internal.m.e(uVarJ, "toDescriptorVisibility(delegate.normalize())");
        return uVarJ;
    }
}
