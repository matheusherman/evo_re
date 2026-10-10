package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class t0 extends a0 {
    @Override // com.google.android.gms.internal.measurement.a0
    public final s b(String str, v6 v6Var, List<s> list) {
        if (str == null || str.isEmpty() || !v6Var.g(str)) {
            throw new IllegalArgumentException(String.format("Command not found: %s", str));
        }
        s sVarC = v6Var.c(str);
        if (sVarC instanceof n) {
            return ((n) sVarC).a(v6Var, list);
        }
        throw new IllegalArgumentException(String.format("Function %s is not defined", str));
    }
}
