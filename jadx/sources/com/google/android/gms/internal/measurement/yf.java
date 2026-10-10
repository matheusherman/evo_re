package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class yf implements vf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final s7<Boolean> f3309a;

    static {
        b8 b8VarE = new b8(t7.a("com.google.android.gms.measurement")).f().e();
        b8VarE.d("measurement.client.sessions.background_sessions_enabled", true);
        f3309a = b8VarE.d("measurement.client.sessions.enable_fix_background_engagement", false);
        b8VarE.d("measurement.client.sessions.immediate_start_enabled_foreground", true);
        b8VarE.d("measurement.client.sessions.enable_pause_engagement_in_background", true);
        b8VarE.d("measurement.client.sessions.remove_expired_session_properties_enabled", true);
        b8VarE.d("measurement.client.sessions.session_id_enabled", true);
        b8VarE.b("measurement.id.client.sessions.enable_fix_background_engagement", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.vf
    public final boolean b() {
        return f3309a.f().booleanValue();
    }
}
