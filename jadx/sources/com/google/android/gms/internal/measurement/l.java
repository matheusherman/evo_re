package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class l implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f2815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2816b;

    public l(String str) {
        this.f2815a = s.f3010a0;
        this.f2816b = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f2816b.equals(lVar.f2816b) && this.f2815a.equals(lVar.f2815a);
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final Iterator<s> h() {
        return null;
    }

    public final s a() {
        return this.f2815a;
    }

    public final String b() {
        return this.f2816b;
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final s d() {
        return new l(this.f2816b, this.f2815a.d());
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final Boolean e() {
        throw new IllegalStateException("Control is not a boolean");
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final String f() {
        throw new IllegalStateException("Control is not a String");
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final Double g() {
        throw new IllegalStateException("Control is not a double");
    }

    public final int hashCode() {
        return (this.f2816b.hashCode() * 31) + this.f2815a.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final s k(String str, v6 v6Var, List<s> list) {
        throw new IllegalStateException("Control does not have functions");
    }

    public l(String str, s sVar) {
        this.f2815a = sVar;
        this.f2816b = str;
    }
}
