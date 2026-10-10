package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class ye extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ xd f3308c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ye(wb wbVar, String str, xd xdVar) {
        super(str);
        this.f3308c = xdVar;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final s a(v6 v6Var, List<s> list) {
        c5.g("getValue", 2, list);
        s sVarB = v6Var.b(list.get(0));
        s sVarB2 = v6Var.b(list.get(1));
        String strI = this.f3308c.i(sVarB.f());
        return strI != null ? new u(strI) : sVarB2;
    }
}
