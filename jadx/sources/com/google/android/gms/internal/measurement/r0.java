package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class r0 extends a0 {
    @Override // com.google.android.gms.internal.measurement.a0
    public final s b(String str, v6 v6Var, List<s> list) {
        switch (u0.f3092a[c5.c(str).ordinal()]) {
            case 1:
                c5.f(y0.ADD, 2, list);
                s sVarB = v6Var.b(list.get(0));
                s sVarB2 = v6Var.b(list.get(1));
                if (!(sVarB instanceof m) && !(sVarB instanceof u) && !(sVarB2 instanceof m) && !(sVarB2 instanceof u)) {
                    return new k(Double.valueOf(sVarB.g().doubleValue() + sVarB2.g().doubleValue()));
                }
                return new u(sVarB.f() + sVarB2.f());
            case 2:
                c5.f(y0.DIVIDE, 2, list);
                return new k(Double.valueOf(v6Var.b(list.get(0)).g().doubleValue() / v6Var.b(list.get(1)).g().doubleValue()));
            case 3:
                c5.f(y0.MODULUS, 2, list);
                return new k(Double.valueOf(v6Var.b(list.get(0)).g().doubleValue() % v6Var.b(list.get(1)).g().doubleValue()));
            case 4:
                c5.f(y0.MULTIPLY, 2, list);
                return new k(Double.valueOf(v6Var.b(list.get(0)).g().doubleValue() * v6Var.b(list.get(1)).g().doubleValue()));
            case 5:
                c5.f(y0.NEGATE, 1, list);
                return new k(Double.valueOf(v6Var.b(list.get(0)).g().doubleValue() * (-1.0d)));
            case 6:
            case 7:
                c5.g(str, 2, list);
                s sVarB3 = v6Var.b(list.get(0));
                v6Var.b(list.get(1));
                return sVarB3;
            case 8:
            case 9:
                c5.g(str, 1, list);
                return v6Var.b(list.get(0));
            case 10:
                c5.f(y0.SUBTRACT, 2, list);
                return new k(Double.valueOf(v6Var.b(list.get(0)).g().doubleValue() + new k(Double.valueOf(v6Var.b(list.get(1)).g().doubleValue() * (-1.0d))).g().doubleValue()));
            default:
                return super.a(str);
        }
    }

    protected r0() {
        this.f2523a.add(y0.ADD);
        this.f2523a.add(y0.DIVIDE);
        this.f2523a.add(y0.MODULUS);
        this.f2523a.add(y0.MULTIPLY);
        this.f2523a.add(y0.NEGATE);
        this.f2523a.add(y0.POST_DECREMENT);
        this.f2523a.add(y0.POST_INCREMENT);
        this.f2523a.add(y0.PRE_DECREMENT);
        this.f2523a.add(y0.PRE_INCREMENT);
        this.f2523a.add(y0.SUBTRACT);
    }
}
