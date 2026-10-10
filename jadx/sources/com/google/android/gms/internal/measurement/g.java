package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class g implements m, s, Iterable<s> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SortedMap<Integer, s> f2703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, s> f2704b;

    public g() {
        this.f2703a = new TreeMap();
        this.f2704b = new TreeMap();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (t() != gVar.t()) {
            return false;
        }
        if (this.f2703a.isEmpty()) {
            return gVar.f2703a.isEmpty();
        }
        for (int iIntValue = this.f2703a.firstKey().intValue(); iIntValue <= this.f2703a.lastKey().intValue(); iIntValue++) {
            if (!q(iIntValue).equals(gVar.q(iIntValue))) {
                return false;
            }
        }
        return true;
    }

    public final void A() {
        this.f2703a.clear();
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final s d() {
        g gVar = new g();
        for (Map.Entry<Integer, s> entry : this.f2703a.entrySet()) {
            if (entry.getValue() instanceof m) {
                gVar.f2703a.put(entry.getKey(), entry.getValue());
            } else {
                gVar.f2703a.put(entry.getKey(), entry.getValue().d());
            }
        }
        return gVar;
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final Boolean e() {
        return Boolean.TRUE;
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final Double g() {
        if (this.f2703a.size() == 1) {
            return q(0).g();
        }
        return this.f2703a.size() <= 0 ? Double.valueOf(0.0d) : Double.valueOf(Double.NaN);
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final Iterator<s> h() {
        return new f(this, this.f2703a.keySet().iterator(), this.f2704b.keySet().iterator());
    }

    public final int hashCode() {
        return this.f2703a.hashCode() * 31;
    }

    @Override // com.google.android.gms.internal.measurement.m
    public final s i(String str) {
        s sVar;
        if ("length".equals(str)) {
            return new k(Double.valueOf(t()));
        }
        return (!n(str) || (sVar = this.f2704b.get(str)) == null) ? s.f3010a0 : sVar;
    }

    @Override // java.lang.Iterable
    public final Iterator<s> iterator() {
        return new i(this);
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final s k(String str, v6 v6Var, List<s> list) {
        return ("concat".equals(str) || "every".equals(str) || "filter".equals(str) || "forEach".equals(str) || "indexOf".equals(str) || "join".equals(str) || "lastIndexOf".equals(str) || "map".equals(str) || "pop".equals(str) || "push".equals(str) || "reduce".equals(str) || "reduceRight".equals(str) || "reverse".equals(str) || "shift".equals(str) || "slice".equals(str) || "some".equals(str) || "sort".equals(str) || "splice".equals(str) || "toString".equals(str) || "unshift".equals(str)) ? h0.d(str, this, v6Var, list) : p.a(this, new u(str), v6Var, list);
    }

    @Override // com.google.android.gms.internal.measurement.m
    public final void m(String str, s sVar) {
        if (sVar == null) {
            this.f2704b.remove(str);
        } else {
            this.f2704b.put(str, sVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.m
    public final boolean n(String str) {
        return "length".equals(str) || this.f2704b.containsKey(str);
    }

    public final int o() {
        return this.f2703a.size();
    }

    public final void r(int i10, s sVar) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Invalid value index: " + i10);
        }
        if (i10 >= t()) {
            w(i10, sVar);
            return;
        }
        for (int iIntValue = this.f2703a.lastKey().intValue(); iIntValue >= i10; iIntValue--) {
            s sVar2 = this.f2703a.get(Integer.valueOf(iIntValue));
            if (sVar2 != null) {
                w(iIntValue + 1, sVar2);
                this.f2703a.remove(Integer.valueOf(iIntValue));
            }
        }
        w(i10, sVar);
    }

    public final int t() {
        if (this.f2703a.isEmpty()) {
            return 0;
        }
        return this.f2703a.lastKey().intValue() + 1;
    }

    public final String toString() {
        return u(",");
    }

    public final String u(String str) {
        if (str == null) {
            str = "";
        }
        StringBuilder sb2 = new StringBuilder();
        if (!this.f2703a.isEmpty()) {
            for (int i10 = 0; i10 < t(); i10++) {
                s sVarQ = q(i10);
                sb2.append(str);
                if (!(sVarQ instanceof z) && !(sVarQ instanceof q)) {
                    sb2.append(sVarQ.f());
                }
            }
            sb2.delete(0, str.length());
        }
        return sb2.toString();
    }

    public final void v(int i10) {
        int iIntValue = this.f2703a.lastKey().intValue();
        if (i10 > iIntValue || i10 < 0) {
            return;
        }
        this.f2703a.remove(Integer.valueOf(i10));
        if (i10 == iIntValue) {
            int i11 = i10 - 1;
            if (this.f2703a.containsKey(Integer.valueOf(i11)) || i11 < 0) {
                return;
            }
            this.f2703a.put(Integer.valueOf(i11), s.f3010a0);
            return;
        }
        while (true) {
            i10++;
            if (i10 > this.f2703a.lastKey().intValue()) {
                return;
            }
            s sVar = this.f2703a.get(Integer.valueOf(i10));
            if (sVar != null) {
                this.f2703a.put(Integer.valueOf(i10 - 1), sVar);
                this.f2703a.remove(Integer.valueOf(i10));
            }
        }
    }

    public final void w(int i10, s sVar) {
        if (i10 > 32468) {
            throw new IllegalStateException("Array too large");
        }
        if (i10 < 0) {
            throw new IndexOutOfBoundsException("Out of bounds index: " + i10);
        }
        if (sVar == null) {
            this.f2703a.remove(Integer.valueOf(i10));
        } else {
            this.f2703a.put(Integer.valueOf(i10), sVar);
        }
    }

    public final boolean x(int i10) {
        if (i10 >= 0 && i10 <= this.f2703a.lastKey().intValue()) {
            return this.f2703a.containsKey(Integer.valueOf(i10));
        }
        throw new IndexOutOfBoundsException("Out of bounds index: " + i10);
    }

    public final Iterator<Integer> y() {
        return this.f2703a.keySet().iterator();
    }

    public final List<s> z() {
        ArrayList arrayList = new ArrayList(t());
        for (int i10 = 0; i10 < t(); i10++) {
            arrayList.add(q(i10));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final String f() {
        return toString();
    }

    public final s q(int i10) {
        s sVar;
        if (i10 < t()) {
            if (x(i10) && (sVar = this.f2703a.get(Integer.valueOf(i10))) != null) {
                return sVar;
            }
            return s.f3010a0;
        }
        throw new IndexOutOfBoundsException("Attempting to get element outside of current array");
    }

    public final void s(s sVar) {
        w(t(), sVar);
    }

    public g(List<s> list) {
        this();
        if (list != null) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                w(i10, list.get(i10));
            }
        }
    }

    public g(s... sVarArr) {
        this((List<s>) Arrays.asList(sVarArr));
    }
}
