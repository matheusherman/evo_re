package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class od implements pd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final s7<Boolean> f2929a;

    static {
        b8 b8VarE = new b8(t7.a("com.google.android.gms.measurement")).f().e();
        f2929a = b8VarE.d("measurement.service.ad_impression.convert_value_to_double", true);
        b8VarE.d("measurement.client.ad_impression", true);
        b8VarE.d("measurement.service.separate_public_internal_event_blacklisting", true);
        b8VarE.d("measurement.service.ad_impression", true);
    }

    @Override // com.google.android.gms.internal.measurement.pd
    public final boolean b() {
        return f2929a.f().booleanValue();
    }
}
