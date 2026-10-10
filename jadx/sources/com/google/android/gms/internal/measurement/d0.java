package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class d0 extends a0 {
    private static boolean d(s sVar, s sVar2) {
        if (sVar instanceof m) {
            sVar = new u(sVar.f());
        }
        if (sVar2 instanceof m) {
            sVar2 = new u(sVar2.f());
        }
        if ((sVar instanceof u) && (sVar2 instanceof u)) {
            return sVar.f().compareTo(sVar2.f()) < 0;
        }
        double dDoubleValue = sVar.g().doubleValue();
        double dDoubleValue2 = sVar2.g().doubleValue();
        return (Double.isNaN(dDoubleValue) || Double.isNaN(dDoubleValue2) || (dDoubleValue == 0.0d && dDoubleValue2 == -0.0d) || ((dDoubleValue == -0.0d && dDoubleValue2 == 0.0d) || Double.compare(dDoubleValue, dDoubleValue2) >= 0)) ? false : true;
    }

    private static boolean e(s sVar, s sVar2) {
        if (sVar instanceof m) {
            sVar = new u(sVar.f());
        }
        if (sVar2 instanceof m) {
            sVar2 = new u(sVar2.f());
        }
        return (((sVar instanceof u) && (sVar2 instanceof u)) || !(Double.isNaN(sVar.g().doubleValue()) || Double.isNaN(sVar2.g().doubleValue()))) && !d(sVar2, sVar);
    }

    public d0() {
        this.f2523a.add(y0.EQUALS);
        this.f2523a.add(y0.GREATER_THAN);
        this.f2523a.add(y0.GREATER_THAN_EQUALS);
        this.f2523a.add(y0.IDENTITY_EQUALS);
        this.f2523a.add(y0.IDENTITY_NOT_EQUALS);
        this.f2523a.add(y0.LESS_THAN);
        this.f2523a.add(y0.LESS_THAN_EQUALS);
        this.f2523a.add(y0.NOT_EQUALS);
    }

    private static boolean c(s sVar, s sVar2) {
        s kVar;
        s kVar2;
        while (!sVar.getClass().equals(sVar2.getClass())) {
            if (((sVar instanceof z) || (sVar instanceof q)) && ((sVar2 instanceof z) || (sVar2 instanceof q))) {
                return true;
            }
            boolean z10 = sVar instanceof k;
            if (z10 && (sVar2 instanceof u)) {
                kVar2 = new k(sVar2.g());
            } else {
                boolean z11 = sVar instanceof u;
                if (z11 && (sVar2 instanceof k)) {
                    kVar = new k(sVar.g());
                } else if (sVar instanceof h) {
                    kVar = new k(sVar.g());
                } else if (sVar2 instanceof h) {
                    kVar2 = new k(sVar2.g());
                } else if ((z11 || z10) && (sVar2 instanceof m)) {
                    kVar2 = new u(sVar2.f());
                } else {
                    if (!(sVar instanceof m) || (!(sVar2 instanceof u) && !(sVar2 instanceof k))) {
                        return false;
                    }
                    kVar = new u(sVar.f());
                }
                sVar = kVar;
            }
            sVar2 = kVar2;
        }
        if ((sVar instanceof z) || (sVar instanceof q)) {
            return true;
        }
        if (sVar instanceof k) {
            if (Double.isNaN(sVar.g().doubleValue()) || Double.isNaN(sVar2.g().doubleValue()) || sVar.g().doubleValue() != sVar2.g().doubleValue()) {
                return false;
            }
            return true;
        }
        if (sVar instanceof u) {
            return sVar.f().equals(sVar2.f());
        }
        if (sVar instanceof h) {
            return sVar.e().equals(sVar2.e());
        }
        if (sVar != sVar2) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x005c  */
    /* JADX WARN: Code duplicated, block: B:18:0x005f  */
    @Override // com.google.android.gms.internal.measurement.a0
    public final s b(String str, v6 v6Var, List<s> list) {
        boolean zC;
        boolean zH;
        c5.f(c5.c(str), 2, list);
        s sVarB = v6Var.b(list.get(0));
        s sVarB2 = v6Var.b(list.get(1));
        switch (g0.f2705a[c5.c(str).ordinal()]) {
            case 1:
                zC = c(sVarB, sVarB2);
                if (zC) {
                    return s.f3015f0;
                }
                return s.f3016g0;
            case 2:
                zC = d(sVarB2, sVarB);
                if (zC) {
                    return s.f3015f0;
                }
                return s.f3016g0;
            case 3:
                zC = e(sVarB2, sVarB);
                if (zC) {
                    return s.f3015f0;
                }
                return s.f3016g0;
            case 4:
                zC = c5.h(sVarB, sVarB2);
                if (zC) {
                    return s.f3015f0;
                }
                return s.f3016g0;
            case 5:
                zH = c5.h(sVarB, sVarB2);
                zC = !zH;
                if (zC) {
                    return s.f3015f0;
                }
                return s.f3016g0;
            case 6:
                zC = d(sVarB, sVarB2);
                if (zC) {
                    return s.f3015f0;
                }
                return s.f3016g0;
            case 7:
                zC = e(sVarB, sVarB2);
                if (zC) {
                    return s.f3015f0;
                }
                return s.f3016g0;
            case 8:
                zH = c(sVarB, sVarB2);
                zC = !zH;
                if (zC) {
                    return s.f3015f0;
                }
                return s.f3016g0;
            default:
                return super.a(str);
        }
    }
}
