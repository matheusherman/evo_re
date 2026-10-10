package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class j0 extends a0 {
    @Override // com.google.android.gms.internal.measurement.a0
    public final s b(String str, v6 v6Var, List<s> list) {
        int i10 = m0.f2851a[c5.c(str).ordinal()];
        if (i10 == 1) {
            c5.f(y0.AND, 2, list);
            s sVarB = v6Var.b(list.get(0));
            return !sVarB.e().booleanValue() ? sVarB : v6Var.b(list.get(1));
        }
        if (i10 == 2) {
            c5.f(y0.NOT, 1, list);
            return new h(Boolean.valueOf(!v6Var.b(list.get(0)).e().booleanValue()));
        }
        if (i10 != 3) {
            return super.a(str);
        }
        c5.f(y0.OR, 2, list);
        s sVarB2 = v6Var.b(list.get(0));
        return sVarB2.e().booleanValue() ? sVarB2 : v6Var.b(list.get(1));
    }

    protected j0() {
        this.f2523a.add(y0.AND);
        this.f2523a.add(y0.NOT);
        this.f2523a.add(y0.OR);
    }
}
