package com.google.firebase.analytics;

import android.os.Bundle;
import androidx.annotation.Nullable;
import b2.a1;
import com.google.android.gms.internal.measurement.f3;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class a implements a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ f3 f4705a;

    a(f3 f3Var) {
        this.f4705a = f3Var;
    }

    @Override // b2.a1
    public final long f() {
        return this.f4705a.b();
    }

    @Override // b2.a1
    @Nullable
    public final String h() {
        return this.f4705a.G();
    }

    @Override // b2.a1
    public final int i(String str) {
        return this.f4705a.a(str);
    }

    @Override // b2.a1
    @Nullable
    public final String j() {
        return this.f4705a.H();
    }

    @Override // b2.a1
    @Nullable
    public final String k() {
        return this.f4705a.F();
    }

    @Override // b2.a1
    @Nullable
    public final String l() {
        return this.f4705a.I();
    }

    @Override // b2.a1
    public final void m(Bundle bundle) {
        this.f4705a.l(bundle);
    }

    @Override // b2.a1
    public final void n(String str) {
        this.f4705a.C(str);
    }

    @Override // b2.a1
    public final void o(String str, @Nullable String str2, @Nullable Bundle bundle) {
        this.f4705a.t(str, str2, bundle);
    }

    @Override // b2.a1
    public final List<Bundle> p(@Nullable String str, @Nullable String str2) {
        return this.f4705a.g(str, str2);
    }

    @Override // b2.a1
    public final void q(String str) {
        this.f4705a.z(str);
    }

    @Override // b2.a1
    public final Map<String, Object> r(@Nullable String str, @Nullable String str2, boolean z10) {
        return this.f4705a.h(str, str2, z10);
    }

    @Override // b2.a1
    public final void s(String str, String str2, Bundle bundle) {
        this.f4705a.A(str, str2, bundle);
    }
}
