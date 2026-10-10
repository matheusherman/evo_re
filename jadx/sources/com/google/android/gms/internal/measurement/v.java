package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class v implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<s> f3158b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        String str = this.f3157a;
        if (str == null ? vVar.f3157a != null : !str.equals(vVar.f3157a)) {
            return false;
        }
        ArrayList<s> arrayList = this.f3158b;
        ArrayList<s> arrayList2 = vVar.f3158b;
        if (arrayList != null) {
            return arrayList.equals(arrayList2);
        }
        return arrayList2 == null;
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final Iterator<s> h() {
        return null;
    }

    public final String a() {
        return this.f3157a;
    }

    public final ArrayList<s> b() {
        return this.f3158b;
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final Boolean e() {
        throw new IllegalStateException("Statement cannot be cast as Boolean");
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final String f() {
        throw new IllegalStateException("Statement cannot be cast as String");
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final Double g() {
        throw new IllegalStateException("Statement cannot be cast as Double");
    }

    public final int hashCode() {
        String str = this.f3157a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        ArrayList<s> arrayList = this.f3158b;
        return iHashCode + (arrayList != null ? arrayList.hashCode() : 0);
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final s k(String str, v6 v6Var, List<s> list) {
        throw new IllegalStateException("Statement is not an evaluated entity");
    }

    public v(String str, List<s> list) {
        this.f3157a = str;
        ArrayList<s> arrayList = new ArrayList<>();
        this.f3158b = arrayList;
        arrayList.addAll(list);
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final s d() {
        return this;
    }
}
