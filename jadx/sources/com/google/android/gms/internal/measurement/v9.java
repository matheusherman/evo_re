package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class v9 extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f3172c;

    public v9(d dVar) {
        super("internal.eventLogger");
        this.f3172c = dVar;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final s a(v6 v6Var, List<s> list) {
        c5.g(this.f2886a, 3, list);
        String strF = v6Var.b(list.get(0)).f();
        long jA = (long) c5.a(v6Var.b(list.get(1)).g().doubleValue());
        s sVarB = v6Var.b(list.get(2));
        this.f3172c.c(strF, jA, sVarB instanceof r ? c5.e((r) sVarB) : new HashMap<>());
        return s.f3010a0;
    }
}
