package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class ze implements ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final s7<Boolean> f3329a;

    static {
        b8 b8VarE = new b8(t7.a("com.google.android.gms.measurement")).f().e();
        b8VarE.d("measurement.gmscore_feature_tracking", true);
        f3329a = b8VarE.d("measurement.gmscore_client_telemetry", false);
    }

    @Override // com.google.android.gms.internal.measurement.ve
    public final boolean b() {
        return f3329a.f().booleanValue();
    }
}
