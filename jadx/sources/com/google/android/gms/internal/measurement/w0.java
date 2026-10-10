package com.google.android.gms.internal.measurement;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class w0 extends a0 {
    @Override // com.google.android.gms.internal.measurement.a0
    public final s b(String str, v6 v6Var, List<s> list) {
        String str2;
        int i10 = 0;
        switch (v0.f3159a[c5.c(str).ordinal()]) {
            case 1:
                c5.f(y0.ASSIGN, 2, list);
                s sVarB = v6Var.b(list.get(0));
                if (!(sVarB instanceof u)) {
                    throw new IllegalArgumentException(String.format("Expected string for assign var. got %s", sVarB.getClass().getCanonicalName()));
                }
                if (!v6Var.g(sVarB.f())) {
                    throw new IllegalArgumentException(String.format("Attempting to assign undefined value %s", sVarB.f()));
                }
                s sVarB2 = v6Var.b(list.get(1));
                v6Var.h(sVarB.f(), sVarB2);
                return sVarB2;
            case 2:
                c5.j(y0.CONST, 2, list);
                if (list.size() % 2 != 0) {
                    throw new IllegalArgumentException(String.format("CONST requires an even number of arguments, found %s", Integer.valueOf(list.size())));
                }
                for (int i11 = 0; i11 < list.size() - 1; i11 += 2) {
                    s sVarB3 = v6Var.b(list.get(i11));
                    if (!(sVarB3 instanceof u)) {
                        throw new IllegalArgumentException(String.format("Expected string for const name. got %s", sVarB3.getClass().getCanonicalName()));
                    }
                    v6Var.f(sVarB3.f(), v6Var.b(list.get(i11 + 1)));
                }
                return s.f3010a0;
            case 3:
                if (list.isEmpty()) {
                    return new g();
                }
                g gVar = new g();
                Iterator<s> it = list.iterator();
                while (it.hasNext()) {
                    s sVarB4 = v6Var.b(it.next());
                    if (sVarB4 instanceof l) {
                        throw new IllegalStateException("Failed to evaluate array element");
                    }
                    gVar.w(i10, sVarB4);
                    i10++;
                }
                return gVar;
            case 4:
                if (list.isEmpty()) {
                    return new r();
                }
                if (list.size() % 2 != 0) {
                    throw new IllegalArgumentException(String.format("CREATE_OBJECT requires an even number of arguments, found %s", Integer.valueOf(list.size())));
                }
                r rVar = new r();
                while (i10 < list.size() - 1) {
                    s sVarB5 = v6Var.b(list.get(i10));
                    s sVarB6 = v6Var.b(list.get(i10 + 1));
                    if ((sVarB5 instanceof l) || (sVarB6 instanceof l)) {
                        throw new IllegalStateException("Failed to evaluate map entry");
                    }
                    rVar.m(sVarB5.f(), sVarB6);
                    i10 += 2;
                }
                return rVar;
            case 5:
                c5.j(y0.EXPRESSION_LIST, 1, list);
                s sVarB7 = s.f3010a0;
                while (i10 < list.size()) {
                    sVarB7 = v6Var.b(list.get(i10));
                    if (sVarB7 instanceof l) {
                        throw new IllegalStateException("ControlValue cannot be in an expression list");
                    }
                    i10++;
                }
                return sVarB7;
            case 6:
                c5.f(y0.GET, 1, list);
                s sVarB8 = v6Var.b(list.get(0));
                if (sVarB8 instanceof u) {
                    return v6Var.c(sVarB8.f());
                }
                throw new IllegalArgumentException(String.format("Expected string for get var. got %s", sVarB8.getClass().getCanonicalName()));
            case 7:
            case 8:
                c5.f(y0.GET_PROPERTY, 2, list);
                s sVarB9 = v6Var.b(list.get(0));
                s sVarB10 = v6Var.b(list.get(1));
                if ((sVarB9 instanceof g) && c5.l(sVarB10)) {
                    return ((g) sVarB9).q(sVarB10.g().intValue());
                }
                if (sVarB9 instanceof m) {
                    return ((m) sVarB9).i(sVarB10.f());
                }
                if (sVarB9 instanceof u) {
                    if ("length".equals(sVarB10.f())) {
                        return new k(Double.valueOf(sVarB9.f().length()));
                    }
                    if (c5.l(sVarB10) && sVarB10.g().doubleValue() < sVarB9.f().length()) {
                        return new u(String.valueOf(sVarB9.f().charAt(sVarB10.g().intValue())));
                    }
                }
                return s.f3010a0;
            case 9:
                c5.f(y0.NULL, 0, list);
                return s.f3011b0;
            case 10:
                c5.f(y0.SET_PROPERTY, 3, list);
                s sVarB11 = v6Var.b(list.get(0));
                s sVarB12 = v6Var.b(list.get(1));
                s sVarB13 = v6Var.b(list.get(2));
                if (sVarB11 == s.f3010a0 || sVarB11 == s.f3011b0) {
                    throw new IllegalStateException(String.format("Can't set property %s of %s", sVarB12.f(), sVarB11.f()));
                }
                if ((sVarB11 instanceof g) && (sVarB12 instanceof k)) {
                    ((g) sVarB11).w(sVarB12.g().intValue(), sVarB13);
                    return sVarB13;
                }
                if (sVarB11 instanceof m) {
                    ((m) sVarB11).m(sVarB12.f(), sVarB13);
                }
                return sVarB13;
            case 11:
                c5.f(y0.TYPEOF, 1, list);
                s sVarB14 = v6Var.b(list.get(0));
                if (sVarB14 instanceof z) {
                    str2 = "undefined";
                } else if (sVarB14 instanceof h) {
                    str2 = TypedValues.Custom.S_BOOLEAN;
                } else if (sVarB14 instanceof k) {
                    str2 = "number";
                } else if (sVarB14 instanceof u) {
                    str2 = TypedValues.Custom.S_STRING;
                } else if (sVarB14 instanceof t) {
                    str2 = "function";
                } else {
                    if ((sVarB14 instanceof v) || (sVarB14 instanceof l)) {
                        throw new IllegalArgumentException(String.format("Unsupported value type %s in typeof", sVarB14));
                    }
                    str2 = "object";
                }
                return new u(str2);
            case 12:
                c5.f(y0.UNDEFINED, 0, list);
                return s.f3010a0;
            case 13:
                c5.j(y0.VAR, 1, list);
                Iterator<s> it2 = list.iterator();
                while (it2.hasNext()) {
                    s sVarB15 = v6Var.b(it2.next());
                    if (!(sVarB15 instanceof u)) {
                        throw new IllegalArgumentException(String.format("Expected string for var name. got %s", sVarB15.getClass().getCanonicalName()));
                    }
                    v6Var.e(sVarB15.f(), s.f3010a0);
                }
                return s.f3010a0;
            default:
                return super.a(str);
        }
    }

    protected w0() {
        this.f2523a.add(y0.ASSIGN);
        this.f2523a.add(y0.CONST);
        this.f2523a.add(y0.CREATE_ARRAY);
        this.f2523a.add(y0.CREATE_OBJECT);
        this.f2523a.add(y0.EXPRESSION_LIST);
        this.f2523a.add(y0.GET);
        this.f2523a.add(y0.GET_INDEX);
        this.f2523a.add(y0.GET_PROPERTY);
        this.f2523a.add(y0.NULL);
        this.f2523a.add(y0.SET_PROPERTY);
        this.f2523a.add(y0.TYPEOF);
        this.f2523a.add(y0.UNDEFINED);
        this.f2523a.add(y0.VAR);
    }
}
