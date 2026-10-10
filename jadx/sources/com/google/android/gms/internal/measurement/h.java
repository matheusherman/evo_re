package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class h implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f2738a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && this.f2738a == ((h) obj).f2738a;
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final Iterator<s> h() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final s d() {
        return new h(Boolean.valueOf(this.f2738a));
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final Boolean e() {
        return Boolean.valueOf(this.f2738a);
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final String f() {
        return Boolean.toString(this.f2738a);
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final Double g() {
        return Double.valueOf(this.f2738a ? 1.0d : 0.0d);
    }

    public final int hashCode() {
        return Boolean.valueOf(this.f2738a).hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final s k(String str, v6 v6Var, List<s> list) {
        if ("toString".equals(str)) {
            return new u(Boolean.toString(this.f2738a));
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", Boolean.toString(this.f2738a), str));
    }

    public final String toString() {
        return String.valueOf(this.f2738a);
    }

    public h(Boolean bool) {
        if (bool == null) {
            this.f2738a = false;
        } else {
            this.f2738a = bool.booleanValue();
        }
    }
}
