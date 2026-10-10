package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f13061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<kotlin.reflect.jvm.internal.impl.types.k1> f13062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final s0 f13063c;

    /* JADX WARN: Multi-variable type inference failed */
    public s0(i classifierDescriptor, List<? extends kotlin.reflect.jvm.internal.impl.types.k1> arguments, s0 s0Var) {
        kotlin.jvm.internal.m.f(classifierDescriptor, "classifierDescriptor");
        kotlin.jvm.internal.m.f(arguments, "arguments");
        this.f13061a = classifierDescriptor;
        this.f13062b = arguments;
        this.f13063c = s0Var;
    }

    public final List<kotlin.reflect.jvm.internal.impl.types.k1> a() {
        return this.f13062b;
    }

    public final i b() {
        return this.f13061a;
    }

    public final s0 c() {
        return this.f13063c;
    }
}
