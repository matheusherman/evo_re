package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class be implements ce {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final s7<Boolean> f2568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final s7<Boolean> f2569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final s7<Boolean> f2570c;

    static {
        b8 b8VarE = new b8(t7.a("com.google.android.gms.measurement")).f().e();
        b8VarE.d("measurement.set_default_event_parameters_with_backfill.client.dev", false);
        b8VarE.d("measurement.defensively_copy_bundles_validate_default_params", true);
        b8VarE.d("measurement.set_default_event_parameters_with_backfill.service", true);
        f2568a = b8VarE.d("measurement.set_default_event_parameters.fix_app_update_logging", true);
        f2569b = b8VarE.d("measurement.set_default_event_parameters.fix_deferred_analytics_collection", true);
        f2570c = b8VarE.d("measurement.set_default_event_parameters.fix_service_request_ordering", false);
        b8VarE.d("measurement.set_default_event_parameters.fix_subsequent_launches", true);
    }

    @Override // com.google.android.gms.internal.measurement.ce
    public final boolean b() {
        return f2568a.f().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.ce
    public final boolean c() {
        return f2569b.f().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.ce
    public final boolean d() {
        return f2570c.f().booleanValue();
    }
}
