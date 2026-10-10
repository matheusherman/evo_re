package com.google.android.gms.internal.measurement;

import androidx.p000lifecycle.CoroutineLiveDataKt;
import org.apache.log4j.helpers.FileWatchdog;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class ud implements vd {
    private static final s7<Boolean> A;
    private static final s7<String> B;
    private static final s7<Long> C;
    private static final s7<Long> D;
    private static final s7<Long> E;
    private static final s7<Long> F;
    private static final s7<Long> G;
    private static final s7<Long> H;
    private static final s7<String> I;
    private static final s7<String> J;
    private static final s7<Long> K;
    private static final s7<Long> L;
    private static final s7<Long> M;
    private static final s7<Long> N;
    private static final s7<Long> O;
    private static final s7<Long> P;
    private static final s7<Long> Q;
    private static final s7<Long> R;
    private static final s7<Long> S;
    private static final s7<Long> T;
    private static final s7<String> U;
    private static final s7<Long> V;
    private static final s7<String> W;
    private static final s7<String> X;
    private static final s7<String> Y;
    private static final s7<Long> Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final s7<Long> f3112a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private static final s7<Long> f3113a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final s7<Long> f3114b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private static final s7<Long> f3115b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final s7<Boolean> f3116c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private static final s7<Long> f3117c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final s7<Long> f3118d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private static final s7<Long> f3119d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final s7<Long> f3120e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private static final s7<Long> f3121e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final s7<String> f3122f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private static final s7<Long> f3123f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final s7<String> f3124g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private static final s7<Long> f3125g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final s7<Long> f3126h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private static final s7<Long> f3127h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final s7<Long> f3128i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private static final s7<Long> f3129i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final s7<String> f3130j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private static final s7<Long> f3131j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final s7<Long> f3132k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private static final s7<Long> f3133k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final s7<String> f3134l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private static final s7<Long> f3135l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final s7<Long> f3136m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private static final s7<Long> f3137m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final s7<Long> f3138n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private static final s7<Long> f3139n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final s7<Long> f3140o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private static final s7<Long> f3141o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final s7<Long> f3142p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private static final s7<Long> f3143p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final s7<Long> f3144q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private static final s7<String> f3145q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final s7<Long> f3146r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private static final s7<Long> f3147r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final s7<Long> f3148s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private static final s7<String> f3149s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final s7<Long> f3150t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final s7<Long> f3151u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final s7<Long> f3152v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final s7<Long> f3153w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final s7<Long> f3154x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final s7<Long> f3155y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final s7<Long> f3156z;

    static {
        b8 b8VarE = new b8(t7.a("com.google.android.gms.measurement")).f().e();
        f3112a = b8VarE.b("measurement.ad_id_cache_time", 10000L);
        f3114b = b8VarE.b("measurement.app_uninstalled_additional_ad_id_cache_time", 3600000L);
        f3116c = b8VarE.d("measurement.config.bundle_for_all_apps_on_backgrounded", true);
        f3118d = b8VarE.b("measurement.max_bundles_per_iteration", 100L);
        f3120e = b8VarE.b("measurement.config.cache_time", 86400000L);
        b8VarE.c("measurement.log_tag", "FA");
        f3122f = b8VarE.c("measurement.config.url_authority", "app-measurement.com");
        f3124g = b8VarE.c("measurement.config.url_scheme", "https");
        f3126h = b8VarE.b("measurement.upload.debug_upload_interval", 1000L);
        f3128i = b8VarE.b("measurement.session.engagement_interval", 3600000L);
        f3130j = b8VarE.c("measurement.rb.attribution.event_params", "value|currency");
        f3132k = b8VarE.b("measurement.upload.google_signal_max_queue_time", 605000L);
        f3134l = b8VarE.c("measurement.sgtm.google_signal.url", "https://app-measurement.com/s/d");
        f3136m = b8VarE.b("measurement.lifetimevalue.max_currency_tracked", 4L);
        f3138n = b8VarE.b("measurement.dma_consent.max_daily_dcu_realtime_events", 1L);
        f3140o = b8VarE.b("measurement.upload.max_event_parameter_value_length", 500L);
        f3142p = b8VarE.b("measurement.store.max_stored_events_per_app", 100000L);
        f3144q = b8VarE.b("measurement.experiment.max_ids", 50L);
        f3146r = b8VarE.b("measurement.audience.filter_result_max_count", 200L);
        f3148s = b8VarE.b("measurement.upload.max_item_scoped_custom_parameters", 27L);
        f3150t = b8VarE.b("measurement.rb.max_trigger_registrations_per_day", 1000L);
        f3151u = b8VarE.b("measurement.rb.attribution.max_trigger_uris_queried_at_once", 0L);
        f3152v = b8VarE.b("measurement.rb.attribution.client.min_ad_services_version", 7L);
        f3153w = b8VarE.b("measurement.alarm_manager.minimum_interval", FileWatchdog.DEFAULT_DELAY);
        f3154x = b8VarE.b("measurement.upload.minimum_delay", 500L);
        f3155y = b8VarE.b("measurement.monitoring.sample_period_millis", 86400000L);
        f3156z = b8VarE.b("measurement.rb.attribution.notify_app_delay_millis", 3000L);
        A = b8VarE.d("measurement.config.notify_trigger_uris_on_backgrounded", true);
        B = b8VarE.c("measurement.rb.attribution.app_allowlist", "*");
        C = b8VarE.b("measurement.upload.realtime_upload_interval", 10000L);
        D = b8VarE.b("measurement.upload.refresh_blacklisted_config_interval", 604800000L);
        b8VarE.b("measurement.config.cache_time.service", 3600000L);
        E = b8VarE.b("measurement.service_client.idle_disconnect_millis", CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        b8VarE.c("measurement.log_tag.service", "FA-SVC");
        b8VarE.c("measurement.sgtm.app_allowlist", "*");
        F = b8VarE.b("measurement.sgtm.batch.retry_interval", 1800000L);
        G = b8VarE.b("measurement.sgtm.batch.retry_max_count", 10L);
        H = b8VarE.b("measurement.sgtm.batch.retry_max_wait", 21600000L);
        I = b8VarE.c("measurement.sgtm.service_upload_apps_list", "de.zalando.mobile");
        J = b8VarE.c("measurement.sgtm.upload.backoff_http_codes", "404,429,503,504");
        K = b8VarE.b("measurement.sgtm.upload.batches_retrieval_limit", 5L);
        L = b8VarE.b("measurement.sgtm.upload.max_queued_batches", CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        M = b8VarE.b("measurement.sgtm.upload.min_delay_after_background", 600000L);
        N = b8VarE.b("measurement.sgtm.upload.min_delay_after_broadcast", 1000L);
        O = b8VarE.b("measurement.sgtm.upload.min_delay_after_startup", CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        P = b8VarE.b("measurement.sgtm.upload.retry_interval", 600000L);
        Q = b8VarE.b("measurement.sgtm.upload.retry_max_wait", 21600000L);
        R = b8VarE.b("measurement.upload.stale_data_deletion_interval", 86400000L);
        S = b8VarE.b("measurement.rb.attribution.max_retry_delay_seconds", 16L);
        T = b8VarE.b("measurement.rb.attribution.client.min_time_after_boot_seconds", 90L);
        U = b8VarE.c("measurement.rb.attribution.uri_authority", "google-analytics.com");
        V = b8VarE.b("measurement.rb.attribution.max_queue_time", 864000000L);
        W = b8VarE.c("measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion");
        X = b8VarE.c("measurement.rb.attribution.query_parameters_to_remove", "");
        Y = b8VarE.c("measurement.rb.attribution.uri_scheme", "https");
        Z = b8VarE.b("measurement.sdk.attribution.cache.ttl", 604800000L);
        f3113a0 = b8VarE.b("measurement.redaction.app_instance_id.ttl", 7200000L);
        f3115b0 = b8VarE.b("measurement.upload.backoff_period", 43200000L);
        f3117c0 = b8VarE.b("measurement.upload.initial_upload_delay_time", 15000L);
        f3119d0 = b8VarE.b("measurement.upload.interval", 3600000L);
        f3121e0 = b8VarE.b("measurement.upload.max_bundle_size", 65536L);
        f3123f0 = b8VarE.b("measurement.upload.max_bundles", 100L);
        f3125g0 = b8VarE.b("measurement.upload.max_conversions_per_day", 500L);
        f3127h0 = b8VarE.b("measurement.upload.max_error_events_per_day", 1000L);
        f3129i0 = b8VarE.b("measurement.upload.max_events_per_bundle", 1000L);
        f3131j0 = b8VarE.b("measurement.upload.max_events_per_day", 100000L);
        f3133k0 = b8VarE.b("measurement.upload.max_public_events_per_day", 50000L);
        f3135l0 = b8VarE.b("measurement.upload.max_queue_time", 518400000L);
        f3137m0 = b8VarE.b("measurement.upload.max_realtime_events_per_day", 10L);
        f3139n0 = b8VarE.b("measurement.upload.max_batch_size", 65536L);
        f3141o0 = b8VarE.b("measurement.upload.retry_count", 6L);
        f3143p0 = b8VarE.b("measurement.upload.retry_time", 1800000L);
        f3145q0 = b8VarE.c("measurement.upload.url", "https://app-measurement.com/a");
        f3147r0 = b8VarE.b("measurement.upload.window_interval", 3600000L);
        f3149s0 = b8VarE.c("measurement.rb.attribution.user_properties", "_npa,npa|_fot,fot");
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long A() {
        return f3119d0.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long B() {
        return T.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long C() {
        return f3143p0.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long D() {
        return f3153w.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long E() {
        return Q.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long F() {
        return f3135l0.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long G() {
        return f3148s.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long H() {
        return f3113a0.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final String I() {
        return f3149s0.f();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long J() {
        return D.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long K() {
        return N.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long L() {
        return f3129i0.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final String M() {
        return f3134l.f();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long N() {
        return f3150t.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long O() {
        return f3115b0.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long P() {
        return f3139n0.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final boolean Q() {
        return f3116c.f().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long R() {
        return E.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long S() {
        return O.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long T() {
        return f3131j0.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final String U() {
        return B.f();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long V() {
        return V.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final String W() {
        return Y.f();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long X() {
        return L.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long Y() {
        return f3125g0.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final String Z() {
        return f3124g.f();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long a() {
        return f3144q.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long a0() {
        return f3156z.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long b() {
        return f3112a.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long b0() {
        return Z.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long c() {
        return f3114b.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final String c0() {
        return f3145q0.f();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long d() {
        return f3118d.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long d0() {
        return f3146r.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long e() {
        return f3120e.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long e0() {
        return C.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long f() {
        return f3128i.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long f0() {
        return M.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long g() {
        return f3126h.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long g0() {
        return f3127h0.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long h() {
        return f3136m.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final String h0() {
        return f3130j.f();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long i() {
        return f3142p.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final String i0() {
        return W.f();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long j() {
        return f3138n.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long j0() {
        return H.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long k() {
        return f3132k.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long k0() {
        return f3121e0.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long l() {
        return f3140o.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long l0() {
        return f3147r0.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final String m() {
        return J.f();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long m0() {
        return f3154x.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long n() {
        return f3151u.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long n0() {
        return R.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long o() {
        return f3117c0.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final String o0() {
        return X.f();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long p() {
        return f3141o0.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long p0() {
        return K.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final boolean q() {
        return A.f().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long q0() {
        return f3123f0.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long r() {
        return F.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final String r0() {
        return f3122f.f();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long s() {
        return P.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long s0() {
        return f3155y.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long t() {
        return f3133k0.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final String u() {
        return I.f();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long v() {
        return f3137m0.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long w() {
        return S.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final String x() {
        return U.f();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long y() {
        return f3152v.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final long z() {
        return G.f().longValue();
    }
}
