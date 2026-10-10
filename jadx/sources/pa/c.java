package pa;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.types.checker.e;
import kotlin.reflect.jvm.internal.impl.types.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f1 f17457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g0 f17458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g0 f17459c;

    public c(f1 typeParameter, g0 inProjection, g0 outProjection) {
        m.f(typeParameter, "typeParameter");
        m.f(inProjection, "inProjection");
        m.f(outProjection, "outProjection");
        this.f17457a = typeParameter;
        this.f17458b = inProjection;
        this.f17459c = outProjection;
    }

    public final g0 a() {
        return this.f17458b;
    }

    public final g0 b() {
        return this.f17459c;
    }

    public final f1 c() {
        return this.f17457a;
    }

    public final boolean d() {
        return e.f14235a.d(this.f17458b, this.f17459c);
    }
}
