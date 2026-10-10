package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class y extends a0 {
    @Override // com.google.android.gms.internal.measurement.a0
    public final s b(String str, v6 v6Var, List<s> list) {
        switch (b0.f2548a[c5.c(str).ordinal()]) {
            case 1:
                c5.f(y0.BITWISE_AND, 2, list);
                return new k(Double.valueOf(c5.i(v6Var.b(list.get(0)).g().doubleValue()) & c5.i(v6Var.b(list.get(1)).g().doubleValue())));
            case 2:
                c5.f(y0.BITWISE_LEFT_SHIFT, 2, list);
                return new k(Double.valueOf(c5.i(v6Var.b(list.get(0)).g().doubleValue()) << ((int) (c5.m(v6Var.b(list.get(1)).g().doubleValue()) & 31))));
            case 3:
                c5.f(y0.BITWISE_NOT, 1, list);
                return new k(Double.valueOf(~c5.i(v6Var.b(list.get(0)).g().doubleValue())));
            case 4:
                c5.f(y0.BITWISE_OR, 2, list);
                return new k(Double.valueOf(c5.i(v6Var.b(list.get(0)).g().doubleValue()) | c5.i(v6Var.b(list.get(1)).g().doubleValue())));
            case 5:
                c5.f(y0.BITWISE_RIGHT_SHIFT, 2, list);
                return new k(Double.valueOf(c5.i(v6Var.b(list.get(0)).g().doubleValue()) >> ((int) (c5.m(v6Var.b(list.get(1)).g().doubleValue()) & 31))));
            case 6:
                c5.f(y0.BITWISE_UNSIGNED_RIGHT_SHIFT, 2, list);
                return new k(Double.valueOf(c5.m(v6Var.b(list.get(0)).g().doubleValue()) >>> ((int) (c5.m(v6Var.b(list.get(1)).g().doubleValue()) & 31))));
            case 7:
                c5.f(y0.BITWISE_XOR, 2, list);
                return new k(Double.valueOf(c5.i(v6Var.b(list.get(0)).g().doubleValue()) ^ c5.i(v6Var.b(list.get(1)).g().doubleValue())));
            default:
                return super.a(str);
        }
    }

    public y() {
        this.f2523a.add(y0.BITWISE_AND);
        this.f2523a.add(y0.BITWISE_LEFT_SHIFT);
        this.f2523a.add(y0.BITWISE_NOT);
        this.f2523a.add(y0.BITWISE_OR);
        this.f2523a.add(y0.BITWISE_RIGHT_SHIFT);
        this.f2523a.add(y0.BITWISE_UNSIGNED_RIGHT_SHIFT);
        this.f2523a.add(y0.BITWISE_XOR);
    }
}
