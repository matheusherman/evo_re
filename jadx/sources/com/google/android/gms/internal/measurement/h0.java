package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class h0 {
    private static g a(g gVar, v6 v6Var, n nVar) {
        return b(gVar, v6Var, nVar, null, null);
    }

    private static g b(g gVar, v6 v6Var, n nVar, Boolean bool, Boolean bool2) {
        g gVar2 = new g();
        Iterator<Integer> itY = gVar.y();
        while (itY.hasNext()) {
            int iIntValue = itY.next().intValue();
            if (gVar.x(iIntValue)) {
                s sVarA = nVar.a(v6Var, Arrays.asList(gVar.q(iIntValue), new k(Double.valueOf(iIntValue)), gVar));
                if (sVarA.e().equals(bool)) {
                    break;
                }
                if (bool2 == null || sVarA.e().equals(bool2)) {
                    gVar2.w(iIntValue, sVarA);
                }
            }
        }
        return gVar2;
    }

    private static s c(g gVar, v6 v6Var, List<s> list, boolean z10) {
        s sVarA;
        c5.k("reduce", 1, list);
        c5.n("reduce", 2, list);
        s sVarB = v6Var.b(list.get(0));
        if (!(sVarB instanceof n)) {
            throw new IllegalArgumentException("Callback should be a method");
        }
        if (list.size() == 2) {
            sVarA = v6Var.b(list.get(1));
            if (sVarA instanceof l) {
                throw new IllegalArgumentException("Failed to parse initial value");
            }
        } else {
            if (gVar.t() == 0) {
                throw new IllegalStateException("Empty array with no initial value error");
            }
            sVarA = null;
        }
        n nVar = (n) sVarB;
        int iT = gVar.t();
        int i10 = z10 ? 0 : iT - 1;
        int i11 = z10 ? iT - 1 : 0;
        int i12 = z10 ? 1 : -1;
        if (sVarA == null) {
            sVarA = gVar.q(i10);
            i10 += i12;
        }
        while ((i11 - i10) * i12 >= 0) {
            if (gVar.x(i10)) {
                sVarA = nVar.a(v6Var, Arrays.asList(sVarA, gVar.q(i10), new k(Double.valueOf(i10)), gVar));
                if (sVarA instanceof l) {
                    throw new IllegalStateException("Reduce operation failed");
                }
                i10 += i12;
            } else {
                i10 += i12;
            }
        }
        return sVarA;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static s d(String str, g gVar, v6 v6Var, List<s> list) {
        String strF;
        n nVar;
        v6 v6Var2;
        Double d10;
        Double dValueOf = Double.valueOf(-1.0d);
        str.getClass();
        byte b10 = -1;
        switch (str.hashCode()) {
            case -1776922004:
                if (str.equals("toString")) {
                    b10 = 0;
                }
                break;
            case -1354795244:
                if (str.equals("concat")) {
                    b10 = 1;
                }
                break;
            case -1274492040:
                if (str.equals("filter")) {
                    b10 = 2;
                }
                break;
            case -934873754:
                if (str.equals("reduce")) {
                    b10 = 3;
                }
                break;
            case -895859076:
                if (str.equals("splice")) {
                    b10 = 4;
                }
                break;
            case -678635926:
                if (str.equals("forEach")) {
                    b10 = 5;
                }
                break;
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    b10 = 6;
                }
                break;
            case -277637751:
                if (str.equals("unshift")) {
                    b10 = 7;
                }
                break;
            case 107868:
                if (str.equals("map")) {
                    b10 = 8;
                }
                break;
            case 111185:
                if (str.equals("pop")) {
                    b10 = 9;
                }
                break;
            case 3267882:
                if (str.equals("join")) {
                    b10 = 10;
                }
                break;
            case 3452698:
                if (str.equals("push")) {
                    b10 = 11;
                }
                break;
            case 3536116:
                if (str.equals("some")) {
                    b10 = 12;
                }
                break;
            case 3536286:
                if (str.equals("sort")) {
                    b10 = 13;
                }
                break;
            case 96891675:
                if (str.equals("every")) {
                    b10 = 14;
                }
                break;
            case 109407362:
                if (str.equals("shift")) {
                    b10 = 15;
                }
                break;
            case 109526418:
                if (str.equals("slice")) {
                    b10 = 16;
                }
                break;
            case 965561430:
                if (str.equals("reduceRight")) {
                    b10 = 17;
                }
                break;
            case 1099846370:
                if (str.equals("reverse")) {
                    b10 = 18;
                }
                break;
            case 1943291465:
                if (str.equals("indexOf")) {
                    b10 = 19;
                }
                break;
        }
        double dT = 0.0d;
        switch (b10) {
            case 0:
                c5.g("toString", 0, list);
                return new u(gVar.toString());
            case 1:
                g gVar2 = (g) gVar.d();
                if (!list.isEmpty()) {
                    Iterator<s> it = list.iterator();
                    while (it.hasNext()) {
                        s sVarB = v6Var.b(it.next());
                        if (sVarB instanceof l) {
                            throw new IllegalStateException("Failed evaluation of arguments");
                        }
                        int iT = gVar2.t();
                        if (sVarB instanceof g) {
                            g gVar3 = (g) sVarB;
                            Iterator<Integer> itY = gVar3.y();
                            while (itY.hasNext()) {
                                Integer next = itY.next();
                                gVar2.w(next.intValue() + iT, gVar3.q(next.intValue()));
                            }
                        } else {
                            gVar2.w(iT, sVarB);
                        }
                    }
                }
                return gVar2;
            case 2:
                c5.g("filter", 1, list);
                s sVarB2 = v6Var.b(list.get(0));
                if (!(sVarB2 instanceof t)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (gVar.o() == 0) {
                    return new g();
                }
                g gVar4 = (g) gVar.d();
                g gVarB = b(gVar, v6Var, (t) sVarB2, null, Boolean.TRUE);
                g gVar5 = new g();
                Iterator<Integer> itY2 = gVarB.y();
                while (itY2.hasNext()) {
                    gVar5.s(gVar4.q(itY2.next().intValue()));
                }
                return gVar5;
            case 3:
                return c(gVar, v6Var, list, true);
            case 4:
                if (list.isEmpty()) {
                    return new g();
                }
                int iA = (int) c5.a(v6Var.b(list.get(0)).g().doubleValue());
                if (iA < 0) {
                    iA = Math.max(0, iA + gVar.t());
                } else if (iA > gVar.t()) {
                    iA = gVar.t();
                }
                int iT2 = gVar.t();
                g gVar6 = new g();
                if (list.size() > 1) {
                    int iMax = Math.max(0, (int) c5.a(v6Var.b(list.get(1)).g().doubleValue()));
                    if (iMax > 0) {
                        for (int i10 = iA; i10 < Math.min(iT2, iA + iMax); i10++) {
                            gVar6.s(gVar.q(iA));
                            gVar.v(iA);
                        }
                    }
                    if (list.size() > 2) {
                        for (int i11 = 2; i11 < list.size(); i11++) {
                            s sVarB3 = v6Var.b(list.get(i11));
                            if (sVarB3 instanceof l) {
                                throw new IllegalArgumentException("Failed to parse elements to add");
                            }
                            gVar.r((iA + i11) - 2, sVarB3);
                        }
                    }
                } else {
                    while (iA < iT2) {
                        gVar6.s(gVar.q(iA));
                        gVar.w(iA, null);
                        iA++;
                    }
                }
                return gVar6;
            case 5:
                c5.g("forEach", 1, list);
                s sVarB4 = v6Var.b(list.get(0));
                if (!(sVarB4 instanceof t)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (gVar.o() == 0) {
                    return s.f3010a0;
                }
                a(gVar, v6Var, (t) sVarB4);
                return s.f3010a0;
            case 6:
                c5.n("lastIndexOf", 2, list);
                s sVarB5 = s.f3010a0;
                if (!list.isEmpty()) {
                    sVarB5 = v6Var.b(list.get(0));
                }
                double dT2 = gVar.t() - 1;
                if (list.size() > 1) {
                    s sVarB6 = v6Var.b(list.get(1));
                    dT2 = Double.isNaN(sVarB6.g().doubleValue()) ? gVar.t() - 1 : c5.a(sVarB6.g().doubleValue());
                    if (dT2 < 0.0d) {
                        dT2 += (double) gVar.t();
                    }
                }
                if (dT2 < 0.0d) {
                    return new k(dValueOf);
                }
                for (int iMin = (int) Math.min(gVar.t(), dT2); iMin >= 0; iMin--) {
                    if (gVar.x(iMin) && c5.h(gVar.q(iMin), sVarB5)) {
                        return new k(Double.valueOf(iMin));
                    }
                }
                return new k(dValueOf);
            case 7:
                if (!list.isEmpty()) {
                    g gVar7 = new g();
                    Iterator<s> it2 = list.iterator();
                    while (it2.hasNext()) {
                        s sVarB7 = v6Var.b(it2.next());
                        if (sVarB7 instanceof l) {
                            throw new IllegalStateException("Argument evaluation failed");
                        }
                        gVar7.s(sVarB7);
                    }
                    int iT3 = gVar7.t();
                    Iterator<Integer> itY3 = gVar.y();
                    while (itY3.hasNext()) {
                        Integer next2 = itY3.next();
                        gVar7.w(next2.intValue() + iT3, gVar.q(next2.intValue()));
                    }
                    gVar.A();
                    Iterator<Integer> itY4 = gVar7.y();
                    while (itY4.hasNext()) {
                        Integer next3 = itY4.next();
                        gVar.w(next3.intValue(), gVar7.q(next3.intValue()));
                    }
                }
                return new k(Double.valueOf(gVar.t()));
            case 8:
                c5.g("map", 1, list);
                s sVarB8 = v6Var.b(list.get(0));
                if (sVarB8 instanceof t) {
                    return gVar.t() == 0 ? new g() : a(gVar, v6Var, (t) sVarB8);
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 9:
                c5.g("pop", 0, list);
                int iT4 = gVar.t();
                if (iT4 == 0) {
                    return s.f3010a0;
                }
                int i12 = iT4 - 1;
                s sVarQ = gVar.q(i12);
                gVar.v(i12);
                return sVarQ;
            case 10:
                c5.n("join", 1, list);
                if (gVar.t() == 0) {
                    return s.f3017h0;
                }
                if (list.isEmpty()) {
                    strF = ",";
                } else {
                    s sVarB9 = v6Var.b(list.get(0));
                    strF = ((sVarB9 instanceof q) || (sVarB9 instanceof z)) ? "" : sVarB9.f();
                }
                return new u(gVar.u(strF));
            case 11:
                if (!list.isEmpty()) {
                    Iterator<s> it3 = list.iterator();
                    while (it3.hasNext()) {
                        gVar.s(v6Var.b(it3.next()));
                    }
                }
                return new k(Double.valueOf(gVar.t()));
            case 12:
                c5.g("some", 1, list);
                s sVarB10 = v6Var.b(list.get(0));
                if (!(sVarB10 instanceof n)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (gVar.t() != 0) {
                    n nVar2 = (n) sVarB10;
                    Iterator<Integer> itY5 = gVar.y();
                    while (itY5.hasNext()) {
                        int iIntValue = itY5.next().intValue();
                        if (gVar.x(iIntValue) && nVar2.a(v6Var, Arrays.asList(gVar.q(iIntValue), new k(Double.valueOf(iIntValue)), gVar)).e().booleanValue()) {
                            return s.f3015f0;
                        }
                    }
                }
                return s.f3016g0;
            case 13:
                c5.n("sort", 1, list);
                if (gVar.t() >= 2) {
                    List<s> listZ = gVar.z();
                    if (list.isEmpty()) {
                        nVar = null;
                    } else {
                        s sVarB11 = v6Var.b(list.get(0));
                        if (!(sVarB11 instanceof n)) {
                            throw new IllegalArgumentException("Comparator should be a method");
                        }
                        nVar = (n) sVarB11;
                    }
                    Collections.sort(listZ, new k0(nVar, v6Var));
                    gVar.A();
                    Iterator<s> it4 = listZ.iterator();
                    int i13 = 0;
                    while (it4.hasNext()) {
                        gVar.w(i13, it4.next());
                        i13++;
                    }
                }
                return gVar;
            case 14:
                c5.g("every", 1, list);
                s sVarB12 = v6Var.b(list.get(0));
                if (sVarB12 instanceof t) {
                    return (gVar.t() == 0 || b(gVar, v6Var, (t) sVarB12, Boolean.FALSE, Boolean.TRUE).t() == gVar.t()) ? s.f3015f0 : s.f3016g0;
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 15:
                c5.g("shift", 0, list);
                if (gVar.t() == 0) {
                    return s.f3010a0;
                }
                s sVarQ2 = gVar.q(0);
                gVar.v(0);
                return sVarQ2;
            case 16:
                c5.n("slice", 2, list);
                if (list.isEmpty()) {
                    return gVar.d();
                }
                double dT3 = gVar.t();
                double dA = c5.a(v6Var.b(list.get(0)).g().doubleValue());
                double dMax = dA < 0.0d ? Math.max(dA + dT3, 0.0d) : Math.min(dA, dT3);
                if (list.size() == 2) {
                    double dA2 = c5.a(v6Var.b(list.get(1)).g().doubleValue());
                    dT3 = dA2 < 0.0d ? Math.max(dT3 + dA2, 0.0d) : Math.min(dT3, dA2);
                }
                g gVar8 = new g();
                for (int i14 = (int) dMax; i14 < dT3; i14++) {
                    gVar8.s(gVar.q(i14));
                }
                return gVar8;
            case 17:
                return c(gVar, v6Var, list, false);
            case 18:
                c5.g("reverse", 0, list);
                int iT5 = gVar.t();
                if (iT5 != 0) {
                    for (int i15 = 0; i15 < iT5 / 2; i15++) {
                        if (gVar.x(i15)) {
                            s sVarQ3 = gVar.q(i15);
                            gVar.w(i15, null);
                            int i16 = (iT5 - 1) - i15;
                            if (gVar.x(i16)) {
                                gVar.w(i15, gVar.q(i16));
                            }
                            gVar.w(i16, sVarQ3);
                        }
                    }
                }
                return gVar;
            case 19:
                c5.n("indexOf", 2, list);
                s sVarB13 = s.f3010a0;
                if (list.isEmpty()) {
                    v6Var2 = v6Var;
                } else {
                    v6Var2 = v6Var;
                    sVarB13 = v6Var2.b(list.get(0));
                }
                if (list.size() > 1) {
                    double dA3 = c5.a(v6Var2.b(list.get(1)).g().doubleValue());
                    if (dA3 >= gVar.t()) {
                        return new k(dValueOf);
                    }
                    d10 = dValueOf;
                    dT = dA3 < 0.0d ? ((double) gVar.t()) + dA3 : dA3;
                } else {
                    d10 = dValueOf;
                }
                Iterator<Integer> itY6 = gVar.y();
                while (itY6.hasNext()) {
                    int iIntValue2 = itY6.next().intValue();
                    double d11 = iIntValue2;
                    if (d11 >= dT && c5.h(gVar.q(iIntValue2), sVarB13)) {
                        return new k(Double.valueOf(d11));
                    }
                }
                return new k(d10);
            default:
                throw new IllegalArgumentException("Command not supported");
        }
    }
}
