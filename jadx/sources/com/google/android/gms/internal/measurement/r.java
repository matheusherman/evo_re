package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class r implements m, s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, s> f2975a = new HashMap();

    public final List<String> a() {
        return new ArrayList(this.f2975a.keySet());
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final s d() {
        r rVar = new r();
        for (Map.Entry<String, s> entry : this.f2975a.entrySet()) {
            if (entry.getValue() instanceof m) {
                rVar.f2975a.put(entry.getKey(), entry.getValue());
            } else {
                rVar.f2975a.put(entry.getKey(), entry.getValue().d());
            }
        }
        return rVar;
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final Boolean e() {
        return Boolean.TRUE;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            return this.f2975a.equals(((r) obj).f2975a);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final String f() {
        return "[object Object]";
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final Double g() {
        return Double.valueOf(Double.NaN);
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final Iterator<s> h() {
        return p.b(this.f2975a);
    }

    public int hashCode() {
        return this.f2975a.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.m
    public final s i(String str) {
        return this.f2975a.containsKey(str) ? this.f2975a.get(str) : s.f3010a0;
    }

    @Override // com.google.android.gms.internal.measurement.s
    public s k(String str, v6 v6Var, List<s> list) {
        return "toString".equals(str) ? new u(toString()) : p.a(this, new u(str), v6Var, list);
    }

    @Override // com.google.android.gms.internal.measurement.m
    public final void m(String str, s sVar) {
        if (sVar == null) {
            this.f2975a.remove(str);
        } else {
            this.f2975a.put(str, sVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.m
    public final boolean n(String str) {
        return this.f2975a.containsKey(str);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("{");
        if (!this.f2975a.isEmpty()) {
            for (String str : this.f2975a.keySet()) {
                sb2.append(String.format("%s: %s,", str, this.f2975a.get(str)));
            }
            sb2.deleteCharAt(sb2.lastIndexOf(","));
        }
        sb2.append("}");
        return sb2.toString();
    }
}
