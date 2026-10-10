package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class n implements m, s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f2886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Map<String, s> f2887b = new HashMap();

    public abstract s a(v6 v6Var, List<s> list);

    public final String b() {
        return this.f2886a;
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final Boolean e() {
        return Boolean.TRUE;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        String str = this.f2886a;
        if (str != null) {
            return str.equals(nVar.f2886a);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final String f() {
        return this.f2886a;
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final Double g() {
        return Double.valueOf(Double.NaN);
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final Iterator<s> h() {
        return p.b(this.f2887b);
    }

    public int hashCode() {
        String str = this.f2886a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.m
    public final s i(String str) {
        return this.f2887b.containsKey(str) ? this.f2887b.get(str) : s.f3010a0;
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final s k(String str, v6 v6Var, List<s> list) {
        return "toString".equals(str) ? new u(this.f2886a) : p.a(this, new u(str), v6Var, list);
    }

    @Override // com.google.android.gms.internal.measurement.m
    public final void m(String str, s sVar) {
        if (sVar == null) {
            this.f2887b.remove(str);
        } else {
            this.f2887b.put(str, sVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.m
    public final boolean n(String str) {
        return this.f2887b.containsKey(str);
    }

    public n(String str) {
        this.f2886a = str;
    }

    @Override // com.google.android.gms.internal.measurement.s
    public s d() {
        return this;
    }
}
