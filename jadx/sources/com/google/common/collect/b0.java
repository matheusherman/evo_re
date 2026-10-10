package com.google.common.collect;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class b0 {
    static boolean a(a0<?, ?> a0Var, Object obj) {
        if (obj == a0Var) {
            return true;
        }
        if (obj instanceof a0) {
            return a0Var.a().equals(((a0) obj).a());
        }
        return false;
    }
}
