package com.google.android.gms.internal.measurement;

import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class i1 extends r1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f2760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f2761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final t1 f2762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final s1 f2763f;

    /* synthetic */ i1(String str, boolean z10, t1 t1Var, g1 g1Var, f1 f1Var, s1 s1Var, k1 k1Var) {
        this(str, false, t1Var, null, null, s1Var);
    }

    @Override // com.google.android.gms.internal.measurement.r1
    public final g1 a() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.r1
    public final f1 b() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r1) {
            r1 r1Var = (r1) obj;
            if (this.f2760c.equals(r1Var.e()) && this.f2761d == r1Var.f() && this.f2762e.equals(r1Var.c())) {
                r1Var.a();
                r1Var.b();
                if (this.f2763f.equals(r1Var.d())) {
                    return true;
                }
            }
        }
        return false;
    }

    private i1(String str, boolean z10, t1 t1Var, g1 g1Var, f1 f1Var, s1 s1Var) {
        this.f2760c = str;
        this.f2761d = z10;
        this.f2762e = t1Var;
        this.f2763f = s1Var;
    }

    @Override // com.google.android.gms.internal.measurement.r1
    public final t1 c() {
        return this.f2762e;
    }

    @Override // com.google.android.gms.internal.measurement.r1
    public final s1 d() {
        return this.f2763f;
    }

    @Override // com.google.android.gms.internal.measurement.r1
    public final String e() {
        return this.f2760c;
    }

    @Override // com.google.android.gms.internal.measurement.r1
    public final boolean f() {
        return this.f2761d;
    }

    public final int hashCode() {
        return ((((((this.f2760c.hashCode() ^ 1000003) * 1000003) ^ (this.f2761d ? 1231 : 1237)) * 1000003) ^ this.f2762e.hashCode()) * 583896283) ^ this.f2763f.hashCode();
    }

    public final String toString() {
        return "FileComplianceOptions{fileOwner=" + this.f2760c + ", hasDifferentDmaOwner=" + this.f2761d + ", fileChecks=" + String.valueOf(this.f2762e) + ", dataForwardingNotAllowedResolver=" + Configurator.NULL + ", multipleProductIdGroupsResolver=" + Configurator.NULL + ", filePurpose=" + String.valueOf(this.f2763f) + "}";
    }
}
