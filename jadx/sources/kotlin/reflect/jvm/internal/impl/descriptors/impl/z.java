package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.a1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class z extends k implements kotlin.reflect.jvm.internal.impl.descriptors.l0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ba.c f12973e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f12974f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(kotlin.reflect.jvm.internal.impl.descriptors.h0 module, ba.c fqName) {
        super(module, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b(), fqName.h(), a1.f12668a);
        kotlin.jvm.internal.m.f(module, "module");
        kotlin.jvm.internal.m.f(fqName, "fqName");
        this.f12973e = fqName;
        this.f12974f = "package " + fqName + " of " + module;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R H(kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> visitor, D d10) {
        kotlin.jvm.internal.m.f(visitor, "visitor");
        return visitor.f(this, d10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k, kotlin.reflect.jvm.internal.impl.descriptors.m
    public kotlin.reflect.jvm.internal.impl.descriptors.h0 b() {
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = super.b();
        kotlin.jvm.internal.m.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ModuleDescriptor");
        return (kotlin.reflect.jvm.internal.impl.descriptors.h0) mVarB;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l0
    public final ba.c d() {
        return this.f12973e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k, kotlin.reflect.jvm.internal.impl.descriptors.p
    public a1 getSource() {
        a1 NO_SOURCE = a1.f12668a;
        kotlin.jvm.internal.m.e(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.j
    public String toString() {
        return this.f12974f;
    }
}
