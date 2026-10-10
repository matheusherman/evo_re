package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class ae implements wd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final s7<Long> f2544a;

    static {
        b8 b8VarE = new b8(t7.a("com.google.android.gms.measurement")).f().e();
        b8VarE.d("measurement.client.3p_consent_state_v1", true);
        b8VarE.d("measurement.service.consent_state_v1_W36", true);
        f2544a = b8VarE.b("measurement.service.storage_consent_support_version", 203600L);
    }

    @Override // com.google.android.gms.internal.measurement.wd
    public final long b() {
        return f2544a.f().longValue();
    }
}
