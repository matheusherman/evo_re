package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.collections.v0;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.types.r1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b {
    public static final a a(r1 r1Var, boolean z10, boolean z11, f1 f1Var) {
        m.f(r1Var, "<this>");
        return new a(r1Var, null, z11, z10, f1Var != null ? v0.d(f1Var) : null, null, 34, null);
    }

    public static /* synthetic */ a b(r1 r1Var, boolean z10, boolean z11, f1 f1Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        if ((i10 & 4) != 0) {
            f1Var = null;
        }
        return a(r1Var, z10, z11, f1Var);
    }
}
