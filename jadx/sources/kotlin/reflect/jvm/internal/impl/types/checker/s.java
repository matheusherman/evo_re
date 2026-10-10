package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g0 f14260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final s f14261b;

    public s(g0 type, s sVar) {
        kotlin.jvm.internal.m.f(type, "type");
        this.f14260a = type;
        this.f14261b = sVar;
    }

    public final s a() {
        return this.f14261b;
    }

    public final g0 b() {
        return this.f14260a;
    }
}
