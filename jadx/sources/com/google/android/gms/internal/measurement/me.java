package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class me implements je {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final s7<Boolean> f2876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final s7<Boolean> f2877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final s7<Boolean> f2878c;

    @Override // com.google.android.gms.internal.measurement.je
    public final boolean b() {
        return true;
    }

    static {
        b8 b8VarE = new b8(t7.a("com.google.android.gms.measurement")).f().e();
        b8VarE.d("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        f2876a = b8VarE.d("measurement.audience.refresh_event_count_filters_timestamp", false);
        f2877b = b8VarE.d("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        f2878c = b8VarE.d("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    @Override // com.google.android.gms.internal.measurement.je
    public final boolean c() {
        return f2876a.f().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.je
    public final boolean d() {
        return f2877b.f().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.je
    public final boolean e() {
        return f2878c.f().booleanValue();
    }
}
