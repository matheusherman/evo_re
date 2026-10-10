package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final g0<n> f13959a = new g0<>("ResolutionAnchorProvider");

    public static final h0 a(h0 h0Var) {
        kotlin.jvm.internal.m.f(h0Var, "<this>");
        n nVar = (n) h0Var.D0(f13959a);
        if (nVar != null) {
            return nVar.a(h0Var);
        }
        return null;
    }
}
