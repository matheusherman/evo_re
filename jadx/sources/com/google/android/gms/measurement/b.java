package com.google.android.gms.measurement;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.measurement.internal.s6;
import com.google.android.gms.measurement.internal.z7;
import java.util.List;
import java.util.Map;
import m1.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class b extends AppMeasurement.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s6 f3355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final z7 f3356b;

    public b(@NonNull s6 s6Var) {
        super(null);
        g.k(s6Var);
        this.f3355a = s6Var;
        this.f3356b = s6Var.J();
    }

    @Override // b2.a1
    public final long f() {
        return this.f3355a.P().R0();
    }

    @Override // b2.a1
    public final String h() {
        return this.f3356b.B0();
    }

    @Override // b2.a1
    public final String j() {
        return this.f3356b.C0();
    }

    @Override // b2.a1
    public final String k() {
        return this.f3356b.A0();
    }

    @Override // b2.a1
    public final String l() {
        return this.f3356b.A0();
    }

    @Override // b2.a1
    public final void m(Bundle bundle) {
        this.f3356b.N(bundle);
    }

    @Override // b2.a1
    public final void n(String str) {
        this.f3355a.A().F(str, this.f3355a.c().b());
    }

    @Override // b2.a1
    public final void o(String str, String str2, Bundle bundle) {
        this.f3355a.J().o0(str, str2, bundle);
    }

    @Override // b2.a1
    public final List<Bundle> p(String str, String str2) {
        return this.f3356b.J(str, str2);
    }

    @Override // b2.a1
    public final void q(String str) {
        this.f3355a.A().B(str, this.f3355a.c().b());
    }

    @Override // b2.a1
    public final Map<String, Object> r(String str, String str2, boolean z10) {
        return this.f3356b.K(str, str2, z10);
    }

    @Override // b2.a1
    public final void s(String str, String str2, Bundle bundle) {
        this.f3356b.b1(str, str2, bundle);
    }

    @Override // b2.a1
    public final int i(String str) {
        return z7.G(str);
    }
}
