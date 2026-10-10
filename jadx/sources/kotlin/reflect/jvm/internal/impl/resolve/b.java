package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.reflect.jvm.internal.impl.types.g1;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class b implements kotlin.reflect.jvm.internal.impl.types.checker.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f13882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.a f13883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.a f13884c;

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.e.a
    public boolean a(g1 g1Var, g1 g1Var2) {
        return c.d(this.f13882a, this.f13883b, this.f13884c, g1Var, g1Var2);
    }

    public b(boolean z10, kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        this.f13882a = z10;
        this.f13883b = aVar;
        this.f13884c = aVar2;
    }
}
