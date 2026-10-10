package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class fg implements cg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final s7<Boolean> f2702a;

    static {
        b8 b8VarE = new b8(t7.a("com.google.android.gms.measurement")).f().e();
        f2702a = b8VarE.d("measurement.tcf.consent_fix", false);
        b8VarE.d("measurement.tcf.client", true);
        b8VarE.d("measurement.tcf.service", true);
    }

    @Override // com.google.android.gms.internal.measurement.cg
    public final boolean b() {
        return f2702a.f().booleanValue();
    }
}
