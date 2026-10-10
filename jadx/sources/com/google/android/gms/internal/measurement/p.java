package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final /* synthetic */ class p {
    public static s a(m mVar, s sVar, v6 v6Var, List<s> list) {
        if (mVar.n(sVar.f())) {
            s sVarI = mVar.i(sVar.f());
            if (sVarI instanceof n) {
                return ((n) sVarI).a(v6Var, list);
            }
            throw new IllegalArgumentException(String.format("%s is not a function", sVar.f()));
        }
        if ("hasOwnProperty".equals(sVar.f())) {
            c5.g("hasOwnProperty", 1, list);
            if (mVar.n(v6Var.b(list.get(0)).f())) {
                return s.f3015f0;
            }
            return s.f3016g0;
        }
        throw new IllegalArgumentException(String.format("Object has no function %s", sVar.f()));
    }

    public static Iterator<s> b(Map<String, s> map) {
        return new o(map.keySet().iterator());
    }
}
