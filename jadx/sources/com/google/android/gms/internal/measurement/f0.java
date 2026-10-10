package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class f0 extends a0 {
    private static s c(v6 v6Var, List<s> list) {
        c5.j(y0.FN, 2, list);
        s sVarB = v6Var.b(list.get(0));
        s sVarB2 = v6Var.b(list.get(1));
        if (!(sVarB2 instanceof g)) {
            throw new IllegalArgumentException(String.format("FN requires an ArrayValue of parameter names found %s", sVarB2.getClass().getCanonicalName()));
        }
        List<s> listZ = ((g) sVarB2).z();
        List<s> arrayList = new ArrayList<>();
        if (list.size() > 2) {
            arrayList = list.subList(2, list.size());
        }
        return new t(sVarB.f(), listZ, arrayList, v6Var);
    }

    @Override // com.google.android.gms.internal.measurement.a0
    public final s b(String str, v6 v6Var, List<s> list) {
        switch (i0.f2759a[c5.c(str).ordinal()]) {
            case 1:
                c5.f(y0.APPLY, 3, list);
                s sVarB = v6Var.b(list.get(0));
                String strF = v6Var.b(list.get(1)).f();
                s sVarB2 = v6Var.b(list.get(2));
                if (!(sVarB2 instanceof g)) {
                    throw new IllegalArgumentException(String.format("Function arguments for Apply are not a list found %s", sVarB2.getClass().getCanonicalName()));
                }
                if (strF.isEmpty()) {
                    throw new IllegalArgumentException("Function name for apply is undefined");
                }
                return sVarB.k(strF, v6Var, ((g) sVarB2).z());
            case 2:
                return v6Var.d().a(new g(list));
            case 3:
                c5.f(y0.BREAK, 0, list);
                return s.f3013d0;
            case 4:
            case 5:
                if (!list.isEmpty()) {
                    s sVarB3 = v6Var.b(list.get(0));
                    if (sVarB3 instanceof g) {
                        return v6Var.a((g) sVarB3);
                    }
                }
                return s.f3010a0;
            case 6:
                c5.f(y0.BREAK, 0, list);
                return s.f3012c0;
            case 7:
                c5.j(y0.DEFINE_FUNCTION, 2, list);
                t tVar = (t) c(v6Var, list);
                if (tVar.b() == null) {
                    v6Var.h("", tVar);
                    return tVar;
                }
                v6Var.h(tVar.b(), tVar);
                return tVar;
            case 8:
                return c(v6Var, list);
            case 9:
                c5.j(y0.IF, 2, list);
                s sVarB4 = v6Var.b(list.get(0));
                s sVarB5 = v6Var.b(list.get(1));
                s sVarB6 = list.size() > 2 ? v6Var.b(list.get(2)) : null;
                s sVar = s.f3010a0;
                s sVarA = sVarB4.e().booleanValue() ? v6Var.a((g) sVarB5) : sVarB6 != null ? v6Var.a((g) sVarB6) : sVar;
                return sVarA instanceof l ? sVarA : sVar;
            case 10:
                return new g(list);
            case 11:
                if (list.isEmpty()) {
                    return s.f3014e0;
                }
                c5.f(y0.RETURN, 1, list);
                return new l("return", v6Var.b(list.get(0)));
            case 12:
                c5.f(y0.SWITCH, 3, list);
                s sVarB7 = v6Var.b(list.get(0));
                s sVarB8 = v6Var.b(list.get(1));
                s sVarB9 = v6Var.b(list.get(2));
                if (!(sVarB8 instanceof g)) {
                    throw new IllegalArgumentException("Malformed SWITCH statement, cases are not a list");
                }
                if (!(sVarB9 instanceof g)) {
                    throw new IllegalArgumentException("Malformed SWITCH statement, case statements are not a list");
                }
                g gVar = (g) sVarB8;
                g gVar2 = (g) sVarB9;
                boolean z10 = false;
                for (int i10 = 0; i10 < gVar.t(); i10++) {
                    if (z10 || sVarB7.equals(v6Var.b(gVar.q(i10)))) {
                        s sVarB10 = v6Var.b(gVar2.q(i10));
                        if (sVarB10 instanceof l) {
                            if (!((l) sVarB10).b().equals("break")) {
                                return sVarB10;
                            }
                            return s.f3010a0;
                        }
                        z10 = true;
                    }
                }
                if (gVar.t() + 1 == gVar2.t()) {
                    s sVarB11 = v6Var.b(gVar2.q(gVar.t()));
                    if (sVarB11 instanceof l) {
                        String strB = ((l) sVarB11).b();
                        if (strB.equals("return") || strB.equals("continue")) {
                            return sVarB11;
                        }
                    }
                }
                return s.f3010a0;
            case 13:
                c5.f(y0.TERNARY, 3, list);
                return v6Var.b(list.get(0)).e().booleanValue() ? v6Var.b(list.get(1)) : v6Var.b(list.get(2));
            default:
                return super.a(str);
        }
    }

    protected f0() {
        this.f2523a.add(y0.APPLY);
        this.f2523a.add(y0.BLOCK);
        this.f2523a.add(y0.BREAK);
        this.f2523a.add(y0.CASE);
        this.f2523a.add(y0.DEFAULT);
        this.f2523a.add(y0.CONTINUE);
        this.f2523a.add(y0.DEFINE_FUNCTION);
        this.f2523a.add(y0.FN);
        this.f2523a.add(y0.IF);
        this.f2523a.add(y0.QUOTE);
        this.f2523a.add(y0.RETURN);
        this.f2523a.add(y0.SWITCH);
        this.f2523a.add(y0.TERNARY);
    }
}
