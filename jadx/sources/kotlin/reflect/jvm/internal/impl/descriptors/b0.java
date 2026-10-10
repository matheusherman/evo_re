package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final g0<c0> f12737a = new g0<>("InvalidModuleNotifier");

    public static final void a(h0 h0Var) {
        r8.z zVar;
        kotlin.jvm.internal.m.f(h0Var, "<this>");
        c0 c0Var = (c0) h0Var.D0(f12737a);
        if (c0Var != null) {
            c0Var.a(h0Var);
            zVar = r8.z.f17874a;
        } else {
            zVar = null;
        }
        if (zVar != null) {
            return;
        }
        throw new a0("Accessing invalid module descriptor " + h0Var);
    }
}
