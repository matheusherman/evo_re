package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class wc extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f3185b;

    public wc(d dVar) {
        this.f3185b = dVar;
    }

    @Override // com.google.android.gms.internal.measurement.r, com.google.android.gms.internal.measurement.s
    public final s k(String str, v6 v6Var, List<s> list) {
        str.getClass();
        switch (str) {
            case "getEventName":
                c5.g("getEventName", 0, list);
                return new u(this.f3185b.d().e());
            case "getTimestamp":
                c5.g("getTimestamp", 0, list);
                return new k(Double.valueOf(this.f3185b.d().a()));
            case "getParamValue":
                c5.g("getParamValue", 1, list);
                return w8.b(this.f3185b.d().b(v6Var.b(list.get(0)).f()));
            case "getParams":
                c5.g("getParams", 0, list);
                Map<String, Object> mapG = this.f3185b.d().g();
                r rVar = new r();
                for (String str2 : mapG.keySet()) {
                    rVar.m(str2, w8.b(mapG.get(str2)));
                }
                return rVar;
            case "setParamValue":
                c5.g("setParamValue", 2, list);
                String strF = v6Var.b(list.get(0)).f();
                s sVarB = v6Var.b(list.get(1));
                this.f3185b.d().d(strF, c5.d(sVarB));
                return sVarB;
            case "setEventName":
                c5.g("setEventName", 1, list);
                s sVarB2 = v6Var.b(list.get(0));
                if (!s.f3010a0.equals(sVarB2) && !s.f3011b0.equals(sVarB2)) {
                    this.f3185b.d().f(sVarB2.f());
                    return new u(sVarB2.f());
                }
                throw new IllegalArgumentException("Illegal event name");
            default:
                return super.k(str, v6Var, list);
        }
    }
}
