package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import ka.n;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.load.java.y;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f13376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f13377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final r8.i<y> f13378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final r8.i f13379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.d f13380e;

    public g(b components, k typeParameterResolver, r8.i<y> delegateForDefaultTypeQualifiers) {
        m.f(components, "components");
        m.f(typeParameterResolver, "typeParameterResolver");
        m.f(delegateForDefaultTypeQualifiers, "delegateForDefaultTypeQualifiers");
        this.f13376a = components;
        this.f13377b = typeParameterResolver;
        this.f13378c = delegateForDefaultTypeQualifiers;
        this.f13379d = delegateForDefaultTypeQualifiers;
        this.f13380e = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.d(this, typeParameterResolver);
    }

    public final b a() {
        return this.f13376a;
    }

    public final y b() {
        return (y) this.f13379d.getValue();
    }

    public final r8.i<y> c() {
        return this.f13378c;
    }

    public final h0 d() {
        return this.f13376a.m();
    }

    public final n e() {
        return this.f13376a.u();
    }

    public final k f() {
        return this.f13377b;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.d g() {
        return this.f13380e;
    }
}
