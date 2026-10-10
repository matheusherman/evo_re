package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class c5 {
    public static boolean l(s sVar) {
        if (sVar == null) {
            return false;
        }
        Double dG = sVar.g();
        return !dG.isNaN() && dG.doubleValue() >= 0.0d && dG.equals(Double.valueOf(Math.floor(dG.doubleValue())));
    }

    public static int b(v6 v6Var) {
        int i10 = i(v6Var.c("runtime.counter").g().doubleValue() + 1.0d);
        if (i10 > 1000000) {
            throw new IllegalStateException("Instructions allowed exceeded");
        }
        v6Var.h("runtime.counter", new k(Double.valueOf(i10)));
        return i10;
    }

    public static y0 c(String str) {
        y0 y0VarA = (str == null || str.isEmpty()) ? null : y0.a(Integer.parseInt(str));
        if (y0VarA != null) {
            return y0VarA;
        }
        throw new IllegalArgumentException(String.format("Unsupported commandId %s", str));
    }

    public static Object d(s sVar) {
        if (s.f3011b0.equals(sVar)) {
            return null;
        }
        if (s.f3010a0.equals(sVar)) {
            return "";
        }
        if (sVar instanceof r) {
            return e((r) sVar);
        }
        if (!(sVar instanceof g)) {
            return !sVar.g().isNaN() ? sVar.g() : sVar.f();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<s> it = ((g) sVar).iterator();
        while (it.hasNext()) {
            Object objD = d(it.next());
            if (objD != null) {
                arrayList.add(objD);
            }
        }
        return arrayList;
    }

    public static Map<String, Object> e(r rVar) {
        HashMap map = new HashMap();
        for (String str : rVar.a()) {
            Object objD = d(rVar.i(str));
            if (objD != null) {
                map.put(str, objD);
            }
        }
        return map;
    }

    public static double a(double d10) {
        int i10;
        if (Double.isNaN(d10)) {
            return 0.0d;
        }
        if (!Double.isInfinite(d10) && d10 != 0.0d && d10 != -0.0d) {
            if (d10 > 0.0d) {
                i10 = 1;
            } else {
                i10 = -1;
            }
            return ((double) i10) * Math.floor(Math.abs(d10));
        }
        return d10;
    }

    public static void f(y0 y0Var, int i10, List<s> list) {
        g(y0Var.name(), i10, list);
    }

    public static void g(String str, int i10, List<s> list) {
        if (list.size() == i10) {
        } else {
            throw new IllegalArgumentException(String.format("%s operation requires %s parameters found %s", str, Integer.valueOf(i10), Integer.valueOf(list.size())));
        }
    }

    public static boolean h(s sVar, s sVar2) {
        if (!sVar.getClass().equals(sVar2.getClass())) {
            return false;
        }
        if ((sVar instanceof z) || (sVar instanceof q)) {
            return true;
        }
        if (sVar instanceof k) {
            if (Double.isNaN(sVar.g().doubleValue()) || Double.isNaN(sVar2.g().doubleValue())) {
                return false;
            }
            return sVar.g().equals(sVar2.g());
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

    public static int i(double d10) {
        int i10;
        if (!Double.isNaN(d10) && !Double.isInfinite(d10) && d10 != 0.0d) {
            if (d10 > 0.0d) {
                i10 = 1;
            } else {
                i10 = -1;
            }
            return (int) ((((double) i10) * Math.floor(Math.abs(d10))) % 4.294967296E9d);
        }
        return 0;
    }

    public static void j(y0 y0Var, int i10, List<s> list) {
        k(y0Var.name(), i10, list);
    }

    public static void k(String str, int i10, List<s> list) {
        if (list.size() >= i10) {
        } else {
            throw new IllegalArgumentException(String.format("%s operation requires at least %s parameters found %s", str, Integer.valueOf(i10), Integer.valueOf(list.size())));
        }
    }

    public static long m(double d10) {
        return ((long) i(d10)) & 4294967295L;
    }

    public static void n(String str, int i10, List<s> list) {
        if (list.size() <= i10) {
        } else {
            throw new IllegalArgumentException(String.format("%s operation requires at most %s parameters found %s", str, Integer.valueOf(i10), Integer.valueOf(list.size())));
        }
    }
}
