package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class ge implements de {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final s7<Boolean> f2725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final s7<Boolean> f2726b;

    static {
        b8 b8VarE = new b8(t7.a("com.google.android.gms.measurement")).f().e();
        f2725a = b8VarE.d("measurement.set_default_event_parameters_propagate_clear.client.dev", false);
        f2726b = b8VarE.d("measurement.set_default_event_parameters_propagate_clear.service", false);
        b8VarE.b("measurement.id.set_default_event_parameters_propagate_clear.experiment_id", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.de
    public final boolean b() {
        return f2725a.f().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.de
    public final boolean c() {
        return f2726b.f().booleanValue();
    }
}
