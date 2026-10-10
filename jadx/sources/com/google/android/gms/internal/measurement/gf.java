package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class gf implements hf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final s7<Boolean> f2727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final s7<Boolean> f2728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final s7<Boolean> f2729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final s7<Boolean> f2730d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final s7<Boolean> f2731e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final s7<Boolean> f2732f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final s7<Boolean> f2733g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final s7<Boolean> f2734h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final s7<Boolean> f2735i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final s7<Boolean> f2736j;

    @Override // com.google.android.gms.internal.measurement.hf
    public final boolean b() {
        return true;
    }

    static {
        b8 b8VarE = new b8(t7.a("com.google.android.gms.measurement")).f().e();
        f2727a = b8VarE.d("measurement.rb.attribution.ad_campaign_info", true);
        b8VarE.d("measurement.rb.attribution.client.bundle_on_backgrounded", true);
        b8VarE.d("measurement.rb.attribution.service.bundle_on_backgrounded", true);
        f2728b = b8VarE.d("measurement.rb.attribution.client2", true);
        b8VarE.d("measurement.rb.attribution.dma_fix", true);
        f2729c = b8VarE.d("measurement.rb.attribution.followup1.service", false);
        f2730d = b8VarE.d("measurement.rb.attribution.client.get_trigger_uris_async", true);
        f2731e = b8VarE.d("measurement.rb.attribution.service.trigger_uris_high_priority", true);
        b8VarE.d("measurement.rb.attribution.index_out_of_bounds_fix", true);
        f2732f = b8VarE.d("measurement.rb.attribution.service.enable_max_trigger_uris_queried_at_once", true);
        f2733g = b8VarE.d("measurement.rb.attribution.retry_disposition", false);
        f2734h = b8VarE.d("measurement.rb.attribution.service", true);
        f2735i = b8VarE.d("measurement.rb.attribution.enable_trigger_redaction", true);
        f2736j = b8VarE.d("measurement.rb.attribution.uuid_generation", true);
        b8VarE.b("measurement.id.rb.attribution.retry_disposition", 0L);
        b8VarE.d("measurement.rb.attribution.improved_retry", true);
    }

    @Override // com.google.android.gms.internal.measurement.hf
    public final boolean c() {
        return f2727a.f().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.hf
    public final boolean d() {
        return f2728b.f().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.hf
    public final boolean e() {
        return f2729c.f().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.hf
    public final boolean f() {
        return f2731e.f().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.hf
    public final boolean g() {
        return f2730d.f().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.hf
    public final boolean h() {
        return f2733g.f().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.hf
    public final boolean i() {
        return f2736j.f().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.hf
    public final boolean j() {
        return f2734h.f().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.hf
    public final boolean k() {
        return f2732f.f().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.hf
    public final boolean l() {
        return f2735i.f().booleanValue();
    }
}
