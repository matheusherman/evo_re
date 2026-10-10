package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class w8 {
    public static s a(j6 j6Var) {
        if (j6Var == null) {
            return s.f3010a0;
        }
        int i10 = y7.f3277a[j6Var.L().ordinal()];
        if (i10 == 1) {
            return j6Var.U() ? new u(j6Var.O()) : s.f3017h0;
        }
        if (i10 == 2) {
            return j6Var.T() ? new k(Double.valueOf(j6Var.K())) : new k(null);
        }
        if (i10 == 3) {
            return j6Var.S() ? new h(Boolean.valueOf(j6Var.R())) : new h(null);
        }
        if (i10 != 4) {
            if (i10 == 5) {
                throw new IllegalArgumentException("Unknown type found. Cannot convert entity");
            }
            throw new IllegalStateException("Invalid entity: " + String.valueOf(j6Var));
        }
        List<j6> listQ = j6Var.Q();
        ArrayList arrayList = new ArrayList();
        Iterator<j6> it = listQ.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return new v(j6Var.N(), arrayList);
    }

    public static s b(Object obj) {
        if (obj == null) {
            return s.f3011b0;
        }
        if (obj instanceof String) {
            return new u((String) obj);
        }
        if (obj instanceof Double) {
            return new k((Double) obj);
        }
        if (obj instanceof Long) {
            return new k(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new k(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return new h((Boolean) obj);
        }
        if (!(obj instanceof Map)) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            g gVar = new g();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                gVar.s(b(it.next()));
            }
            return gVar;
        }
        r rVar = new r();
        Map map = (Map) obj;
        for (Object string : map.keySet()) {
            s sVarB = b(map.get(string));
            if (string != null) {
                if (!(string instanceof String)) {
                    string = string.toString();
                }
                rVar.m((String) string, sVarB);
            }
        }
        return rVar;
    }
}
