package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zf implements bg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final s7<Boolean> f3330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final s7<Boolean> f3331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final s7<Boolean> f3332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final s7<Boolean> f3333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final s7<Boolean> f3334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final s7<Boolean> f3335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final s7<Boolean> f3336g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final s7<Boolean> f3337h;

    static {
        b8 b8VarE = new b8(t7.a("com.google.android.gms.measurement")).f().e();
        f3330a = b8VarE.d("measurement.sgtm.client.scion_upload_action", true);
        f3331b = b8VarE.d("measurement.sgtm.client.upload_on_backgrounded.dev", false);
        f3332c = b8VarE.d("measurement.sgtm.google_signal.enable", false);
        f3333d = b8VarE.d("measurement.sgtm.no_proxy.client", true);
        f3334e = b8VarE.d("measurement.sgtm.no_proxy.service", false);
        b8VarE.d("measurement.sgtm.preview_mode_enabled", true);
        b8VarE.d("measurement.sgtm.rollout_percentage_fix", true);
        b8VarE.d("measurement.sgtm.service", true);
        f3335f = b8VarE.d("measurement.sgtm.service.batching_on_backgrounded", false);
        f3336g = b8VarE.d("measurement.sgtm.upload_queue", false);
        f3337h = b8VarE.d("measurement.sgtm.upload_on_uninstall", true);
        b8VarE.b("measurement.id.sgtm", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.bg
    public final boolean b() {
        return f3330a.f().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.bg
    public final boolean c() {
        return f3331b.f().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.bg
    public final boolean d() {
        return f3332c.f().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.bg
    public final boolean e() {
        return f3333d.f().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.bg
    public final boolean f() {
        return f3335f.f().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.bg
    public final boolean g() {
        return f3334e.f().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.bg
    public final boolean h() {
        return f3337h.f().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.bg
    public final boolean k() {
        return f3336g.f().booleanValue();
    }
}
