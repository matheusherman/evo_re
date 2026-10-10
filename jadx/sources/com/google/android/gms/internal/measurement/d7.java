package com.google.android.gms.internal.measurement;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class d7 extends e8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.common.base.q<com.google.common.base.l<q7>> f2607b;

    public final boolean equals(Object obj) {
        com.google.common.base.q<com.google.common.base.l<q7>> qVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof e8) {
            e8 e8Var = (e8) obj;
            if (this.f2606a.equals(e8Var.a()) && ((qVar = this.f2607b) != null ? qVar.equals(e8Var.b()) : e8Var.b() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.e8
    final Context a() {
        return this.f2606a;
    }

    @Override // com.google.android.gms.internal.measurement.e8
    final com.google.common.base.q<com.google.common.base.l<q7>> b() {
        return this.f2607b;
    }

    public final int hashCode() {
        int iHashCode = (this.f2606a.hashCode() ^ 1000003) * 1000003;
        com.google.common.base.q<com.google.common.base.l<q7>> qVar = this.f2607b;
        return iHashCode ^ (qVar == null ? 0 : qVar.hashCode());
    }

    public final String toString() {
        return "FlagsContext{context=" + String.valueOf(this.f2606a) + ", hermeticFileOverrides=" + String.valueOf(this.f2607b) + "}";
    }

    d7(Context context, com.google.common.base.q<com.google.common.base.l<q7>> qVar) {
        if (context != null) {
            this.f2606a = context;
            this.f2607b = qVar;
            return;
        }
        throw new NullPointerException("Null context");
    }
}
