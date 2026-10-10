package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.p000lifecycle.CoroutineLiveDataKt;
import com.google.android.gms.internal.measurement.df;
import com.google.android.gms.internal.measurement.dg;
import com.google.android.gms.internal.measurement.ee;
import com.google.android.gms.internal.measurement.ef;
import com.google.android.gms.internal.measurement.eg;
import com.google.android.gms.internal.measurement.fe;
import com.google.android.gms.internal.measurement.jg;
import com.google.android.gms.internal.measurement.ke;
import com.google.android.gms.internal.measurement.kf;
import com.google.android.gms.internal.measurement.le;
import com.google.android.gms.internal.measurement.lf;
import com.google.android.gms.internal.measurement.md;
import com.google.android.gms.internal.measurement.qe;
import com.google.android.gms.internal.measurement.qf;
import com.google.android.gms.internal.measurement.rd;
import com.google.android.gms.internal.measurement.re;
import com.google.android.gms.internal.measurement.rf;
import com.google.android.gms.internal.measurement.s7;
import com.google.android.gms.internal.measurement.sd;
import com.google.android.gms.internal.measurement.we;
import com.google.android.gms.internal.measurement.wf;
import com.google.android.gms.internal.measurement.xe;
import com.google.android.gms.internal.measurement.xf;
import com.google.android.gms.internal.measurement.yd;
import com.google.android.gms.internal.measurement.zd;
import com.tencent.bugly.BuglyStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Priority;
import org.apache.log4j.helpers.FileWatchdog;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class g0 {
    public static final f5<Integer> A;
    public static final f5<Integer> A0;
    public static final f5<Integer> B;
    public static final f5<Boolean> B0;
    public static final f5<Long> C;
    public static final f5<Boolean> C0;
    public static final f5<Long> D;
    public static final f5<Boolean> D0;
    public static final f5<Long> E;
    public static final f5<Boolean> E0;
    public static final f5<Long> F;
    public static final f5<Boolean> F0;
    public static final f5<Long> G;
    public static final f5<Boolean> G0;
    public static final f5<Long> H;
    public static final f5<Boolean> H0;
    public static final f5<Long> I;
    public static final f5<Integer> I0;
    public static final f5<Long> J;
    public static final f5<Boolean> J0;
    public static final f5<Long> K;
    public static final f5<Boolean> K0;
    public static final f5<Long> L;
    public static final f5<Boolean> L0;
    public static final f5<Long> M;
    public static final f5<Boolean> M0;
    public static final f5<Long> N;
    public static final f5<Boolean> N0;
    public static final f5<Long> O;
    public static final f5<Boolean> O0;
    public static final f5<Long> P;
    public static final f5<Boolean> P0;
    public static final f5<Integer> Q;
    public static final f5<Boolean> Q0;
    public static final f5<Long> R;
    public static final f5<Boolean> R0;
    public static final f5<Long> S;
    public static final f5<Boolean> S0;
    public static final f5<Integer> T;
    public static final f5<Boolean> T0;
    public static final f5<Integer> U;
    public static final f5<Boolean> U0;
    public static final f5<Integer> V;
    public static final f5<Boolean> V0;
    public static final f5<Integer> W;
    public static final f5<Boolean> W0;
    public static final f5<Integer> X;
    public static final f5<Boolean> X0;
    public static final f5<Long> Y;
    public static final f5<Boolean> Y0;
    public static final f5<Boolean> Z;
    public static final f5<Boolean> Z0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<f5<?>> f3547a = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final f5<String> f3548a0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public static final f5<Boolean> f3549a1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f5<Long> f3550b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final f5<Long> f3551b0;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static final f5<Boolean> f3552b1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f5<Long> f3553c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final f5<Integer> f3554c0;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public static final f5<Boolean> f3555c1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f5<Long> f3556d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final f5<Double> f3557d0;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public static final f5<Boolean> f3558d1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f5<Long> f3559e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final f5<Integer> f3560e0;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public static final f5<Boolean> f3561e1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f5<String> f3562f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final f5<Integer> f3563f0;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public static final f5<Boolean> f3564f1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f5<String> f3565g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final f5<Integer> f3566g0;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public static final f5<Boolean> f3567g1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final f5<Integer> f3568h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final f5<Integer> f3569h0;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public static final f5<Boolean> f3570h1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final f5<Integer> f3571i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final f5<Long> f3572i0;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public static final f5<Boolean> f3573i1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final f5<Integer> f3574j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final f5<Long> f3575j0;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public static final f5<Boolean> f3576j1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final f5<Integer> f3577k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final f5<Integer> f3578k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final f5<Boolean> f3579k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final f5<Integer> f3580l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final f5<Integer> f3581l0;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public static final f5<Boolean> f3582l1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final f5<Integer> f3583m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final f5<String> f3584m0;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public static final f5<Boolean> f3585m1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final f5<Integer> f3586n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final f5<String> f3587n0;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public static final f5<Boolean> f3588n1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final f5<Integer> f3589o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final f5<String> f3590o0;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public static final f5<Boolean> f3591o1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final f5<Integer> f3592p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final f5<Long> f3593p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public static final f5<Boolean> f3594p1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final f5<Integer> f3595q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final f5<String> f3596q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final f5<String> f3597r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final f5<String> f3598r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final f5<String> f3599s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final f5<String> f3600s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final f5<String> f3601t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final f5<String> f3602t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final f5<String> f3603u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final f5<Long> f3604u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final f5<Long> f3605v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final f5<Integer> f3606v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final f5<Long> f3607w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final f5<Integer> f3608w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final f5<Long> f3609x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final f5<Integer> f3610x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final f5<Long> f3611y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final f5<Boolean> f3612y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final f5<Integer> f3613z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final f5<Boolean> f3614z0;

    static {
        Collections.synchronizedSet(new HashSet());
        f3550b = F("measurement.ad_id_cache_time", 10000L, new e5() { // from class: com.google.android.gms.measurement.internal.h0
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.a());
            }
        });
        f3553c = F("measurement.app_uninstalled_additional_ad_id_cache_time", 3600000L, new e5() { // from class: com.google.android.gms.measurement.internal.e2
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.B());
            }
        });
        f3556d = F("measurement.monitoring.sample_period_millis", 86400000L, new e5() { // from class: com.google.android.gms.measurement.internal.q2
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.m0());
            }
        });
        f3559e = c("measurement.config.cache_time", 86400000L, 3600000L, new e5() { // from class: com.google.android.gms.measurement.internal.d3
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.W());
            }
        }, false);
        f3562f = F("measurement.config.url_scheme", "https", new e5() { // from class: com.google.android.gms.measurement.internal.p3
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return sd.H();
            }
        });
        f3565g = F("measurement.config.url_authority", "app-measurement.com", new e5() { // from class: com.google.android.gms.measurement.internal.c4
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return sd.G();
            }
        });
        f3568h = F("measurement.upload.max_bundles", 100, new e5() { // from class: com.google.android.gms.measurement.internal.o4
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.t());
            }
        });
        f3571i = F("measurement.upload.max_batch_size", 65536, new e5() { // from class: com.google.android.gms.measurement.internal.b5
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.C());
            }
        });
        f3574j = F("measurement.upload.max_bundle_size", 65536, new e5() { // from class: com.google.android.gms.measurement.internal.w0
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.s());
            }
        });
        f3577k = F("measurement.upload.max_events_per_bundle", 1000, new e5() { // from class: com.google.android.gms.measurement.internal.i1
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.w());
            }
        });
        Integer numValueOf = Integer.valueOf(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
        f3580l = F("measurement.upload.max_events_per_day", numValueOf, new e5() { // from class: com.google.android.gms.measurement.internal.g1
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.x());
            }
        });
        f3583m = F("measurement.upload.max_error_events_per_day", 1000, new e5() { // from class: com.google.android.gms.measurement.internal.v1
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.v());
            }
        });
        f3586n = F("measurement.upload.max_public_events_per_day", Integer.valueOf(Priority.FATAL_INT), new e5() { // from class: com.google.android.gms.measurement.internal.x1
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.y());
            }
        });
        f3589o = F("measurement.upload.max_conversions_per_day", 10000, new e5() { // from class: com.google.android.gms.measurement.internal.w1
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.u());
            }
        });
        f3592p = F("measurement.upload.max_realtime_events_per_day", 10, new e5() { // from class: com.google.android.gms.measurement.internal.z1
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.A());
            }
        });
        f3595q = F("measurement.store.max_stored_events_per_app", numValueOf, new e5() { // from class: com.google.android.gms.measurement.internal.y1
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.d0());
            }
        });
        f3597r = F("measurement.upload.url", "https://app-measurement.com/a", new e5() { // from class: com.google.android.gms.measurement.internal.b2
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return sd.R();
            }
        });
        f3599s = F("measurement.sgtm.google_signal.url", "https://app-measurement.com/s/d", new e5() { // from class: com.google.android.gms.measurement.internal.d2
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return sd.J();
            }
        });
        f3601t = F("measurement.sgtm.service_upload_apps_list", "de.zalando.mobile", new e5() { // from class: com.google.android.gms.measurement.internal.c2
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return sd.L();
            }
        });
        f3603u = F("measurement.sgtm.upload.backoff_http_codes", "404,429,503,504", new e5() { // from class: com.google.android.gms.measurement.internal.f2
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return sd.M();
            }
        });
        f3605v = F("measurement.sgtm.upload.retry_interval", 600000L, new e5() { // from class: com.google.android.gms.measurement.internal.h2
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.h());
            }
        });
        f3607w = F("measurement.sgtm.upload.retry_max_wait", 21600000L, new e5() { // from class: com.google.android.gms.measurement.internal.g2
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.i());
            }
        });
        f3609x = F("measurement.sgtm.batch.retry_interval", 1800000L, new e5() { // from class: com.google.android.gms.measurement.internal.j2
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.r0());
            }
        });
        f3611y = F("measurement.sgtm.batch.retry_max_wait", 21600000L, new e5() { // from class: com.google.android.gms.measurement.internal.i2
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.b());
            }
        });
        f3613z = F("measurement.sgtm.batch.retry_max_count", 10, new e5() { // from class: com.google.android.gms.measurement.internal.l2
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.s0());
            }
        });
        A = F("measurement.sgtm.upload.max_queued_batches", 5000, new e5() { // from class: com.google.android.gms.measurement.internal.k2
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.d());
            }
        });
        B = F("measurement.sgtm.upload.batches_retrieval_limit", 5, new e5() { // from class: com.google.android.gms.measurement.internal.m2
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.c());
            }
        });
        Long lValueOf = Long.valueOf(CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        C = F("measurement.sgtm.upload.min_delay_after_startup", lValueOf, new e5() { // from class: com.google.android.gms.measurement.internal.p2
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.g());
            }
        });
        D = F("measurement.sgtm.upload.min_delay_after_broadcast", 1000L, new e5() { // from class: com.google.android.gms.measurement.internal.o2
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.f());
            }
        });
        E = F("measurement.sgtm.upload.min_delay_after_background", 600000L, new e5() { // from class: com.google.android.gms.measurement.internal.r2
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.e());
            }
        });
        F = F("measurement.upload.backoff_period", 43200000L, new e5() { // from class: com.google.android.gms.measurement.internal.t2
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.p());
            }
        });
        G = F("measurement.upload.window_interval", 3600000L, new e5() { // from class: com.google.android.gms.measurement.internal.s2
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.F());
            }
        });
        H = F("measurement.upload.interval", 3600000L, new e5() { // from class: com.google.android.gms.measurement.internal.w2
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.r());
            }
        });
        I = F("measurement.upload.realtime_upload_interval", 10000L, new e5() { // from class: com.google.android.gms.measurement.internal.u2
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.o0());
            }
        });
        J = F("measurement.upload.debug_upload_interval", 1000L, new e5() { // from class: com.google.android.gms.measurement.internal.y2
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.X());
            }
        });
        K = F("measurement.upload.minimum_delay", 500L, new e5() { // from class: com.google.android.gms.measurement.internal.a3
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.l0());
            }
        });
        L = F("measurement.alarm_manager.minimum_interval", Long.valueOf(FileWatchdog.DEFAULT_DELAY), new e5() { // from class: com.google.android.gms.measurement.internal.z2
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.k0());
            }
        });
        M = F("measurement.upload.stale_data_deletion_interval", 86400000L, new e5() { // from class: com.google.android.gms.measurement.internal.c3
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.j());
            }
        });
        N = F("measurement.upload.refresh_blacklisted_config_interval", 604800000L, new e5() { // from class: com.google.android.gms.measurement.internal.b3
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.p0());
            }
        });
        O = F("measurement.upload.initial_upload_delay_time", 15000L, new e5() { // from class: com.google.android.gms.measurement.internal.e3
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.q());
            }
        });
        P = F("measurement.upload.retry_time", 1800000L, new e5() { // from class: com.google.android.gms.measurement.internal.g3
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.E());
            }
        });
        Q = F("measurement.upload.retry_count", 6, new e5() { // from class: com.google.android.gms.measurement.internal.f3
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.D());
            }
        });
        R = F("measurement.upload.max_queue_time", 518400000L, new e5() { // from class: com.google.android.gms.measurement.internal.i3
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.z());
            }
        });
        S = F("measurement.upload.google_signal_max_queue_time", 300000L, new e5() { // from class: com.google.android.gms.measurement.internal.h3
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.Z());
            }
        });
        T = F("measurement.lifetimevalue.max_currency_tracked", 4, new e5() { // from class: com.google.android.gms.measurement.internal.j3
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.a0());
            }
        });
        U = F("measurement.audience.filter_result_max_count", 200, new e5() { // from class: com.google.android.gms.measurement.internal.m3
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.f0());
            }
        });
        V = a("measurement.upload.max_public_user_properties", 100);
        W = a("measurement.upload.max_event_name_cardinality", 2000);
        X = a("measurement.upload.max_public_event_params", 100);
        Y = F("measurement.service_client.idle_disconnect_millis", lValueOf, new e5() { // from class: com.google.android.gms.measurement.internal.l3
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.q0());
            }
        });
        Boolean bool = Boolean.FALSE;
        Z = F("measurement.test.boolean_flag", bool, new e5() { // from class: com.google.android.gms.measurement.internal.o3
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(df.f());
            }
        });
        f3548a0 = F("measurement.test.string_flag", "---", new e5() { // from class: com.google.android.gms.measurement.internal.n3
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return df.e();
            }
        });
        f3551b0 = F("measurement.test.long_flag", -1L, new e5() { // from class: com.google.android.gms.measurement.internal.q3
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(df.d());
            }
        });
        b("measurement.test.cached_long_flag", -1L, new e5() { // from class: com.google.android.gms.measurement.internal.s3
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(df.b());
            }
        });
        f3554c0 = F("measurement.test.int_flag", -2, new e5() { // from class: com.google.android.gms.measurement.internal.r3
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) df.c());
            }
        });
        f3557d0 = F("measurement.test.double_flag", Double.valueOf(-3.0d), new e5() { // from class: com.google.android.gms.measurement.internal.u3
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Double.valueOf(df.a());
            }
        });
        f3560e0 = F("measurement.experiment.max_ids", 50, new e5() { // from class: com.google.android.gms.measurement.internal.x3
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.e0());
            }
        });
        f3563f0 = F("measurement.upload.max_item_scoped_custom_parameters", 27, new e5() { // from class: com.google.android.gms.measurement.internal.v3
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.g0());
            }
        });
        f3566g0 = b("measurement.upload.max_event_parameter_value_length", 500, new e5() { // from class: com.google.android.gms.measurement.internal.z3
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.c0());
            }
        });
        f3569h0 = F("measurement.max_bundles_per_iteration", 100, new e5() { // from class: com.google.android.gms.measurement.internal.y3
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.V());
            }
        });
        f3572i0 = F("measurement.sdk.attribution.cache.ttl", 604800000L, new e5() { // from class: com.google.android.gms.measurement.internal.b4
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.n());
            }
        });
        f3575j0 = F("measurement.redaction.app_instance_id.ttl", 7200000L, new e5() { // from class: com.google.android.gms.measurement.internal.a4
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.o());
            }
        });
        f3578k0 = F("measurement.rb.attribution.client.min_ad_services_version", 7, new e5() { // from class: com.google.android.gms.measurement.internal.d4
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.j0());
            }
        });
        f3581l0 = F("measurement.dma_consent.max_daily_dcu_realtime_events", 1, new e5() { // from class: com.google.android.gms.measurement.internal.f4
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.b0());
            }
        });
        f3584m0 = F("measurement.rb.attribution.uri_scheme", "https", new e5() { // from class: com.google.android.gms.measurement.internal.e4
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return sd.Q();
            }
        });
        f3587n0 = F("measurement.rb.attribution.uri_authority", "google-analytics.com", new e5() { // from class: com.google.android.gms.measurement.internal.g4
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return sd.N();
            }
        });
        f3590o0 = F("measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion", new e5() { // from class: com.google.android.gms.measurement.internal.j4
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return sd.O();
            }
        });
        f3593p0 = F("measurement.session.engagement_interval", 3600000L, new e5() { // from class: com.google.android.gms.measurement.internal.i4
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.Y());
            }
        });
        f3596q0 = F("measurement.rb.attribution.app_allowlist", "*", new e5() { // from class: com.google.android.gms.measurement.internal.l4
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return sd.K();
            }
        });
        f3598r0 = F("measurement.rb.attribution.user_properties", "_npa,npa|_fot,fot", new e5() { // from class: com.google.android.gms.measurement.internal.k4
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return sd.S();
            }
        });
        f3600s0 = F("measurement.rb.attribution.event_params", "value|currency", new e5() { // from class: com.google.android.gms.measurement.internal.n4
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return sd.I();
            }
        });
        f3602t0 = F("measurement.rb.attribution.query_parameters_to_remove", "", new e5() { // from class: com.google.android.gms.measurement.internal.m4
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return sd.P();
            }
        });
        f3604u0 = F("measurement.rb.attribution.max_queue_time", 864000000L, new e5() { // from class: com.google.android.gms.measurement.internal.p4
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Long.valueOf(sd.m());
            }
        });
        f3606v0 = F("measurement.rb.attribution.max_retry_delay_seconds", 16, new e5() { // from class: com.google.android.gms.measurement.internal.r4
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.k());
            }
        });
        f3608w0 = F("measurement.rb.attribution.client.min_time_after_boot_seconds", 90, new e5() { // from class: com.google.android.gms.measurement.internal.t4
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.l());
            }
        });
        F("measurement.rb.attribution.max_trigger_uris_queried_at_once", 0, new e5() { // from class: com.google.android.gms.measurement.internal.s4
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.i0());
            }
        });
        f3610x0 = F("measurement.rb.max_trigger_registrations_per_day", 1000, new e5() { // from class: com.google.android.gms.measurement.internal.v4
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.h0());
            }
        });
        Boolean bool2 = Boolean.TRUE;
        f3612y0 = F("measurement.config.bundle_for_all_apps_on_backgrounded", bool2, new e5() { // from class: com.google.android.gms.measurement.internal.u4
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(sd.T());
            }
        });
        f3614z0 = F("measurement.config.notify_trigger_uris_on_backgrounded", bool2, new e5() { // from class: com.google.android.gms.measurement.internal.y4
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(sd.U());
            }
        });
        A0 = F("measurement.rb.attribution.notify_app_delay_millis", 3000, new e5() { // from class: com.google.android.gms.measurement.internal.w4
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) sd.n0());
            }
        });
        B0 = a("measurement.quality.checksum", bool);
        C0 = F("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", bool, new e5() { // from class: com.google.android.gms.measurement.internal.a5
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(ke.c());
            }
        });
        D0 = F("measurement.audience.refresh_event_count_filters_timestamp", bool, new e5() { // from class: com.google.android.gms.measurement.internal.z4
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(ke.b());
            }
        });
        E0 = b("measurement.audience.use_bundle_timestamp_for_event_count_filters", bool, new e5() { // from class: com.google.android.gms.measurement.internal.c5
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(ke.d());
            }
        });
        F0 = F("measurement.sdk.collection.last_deep_link_referrer_campaign2", bool, new e5() { // from class: com.google.android.gms.measurement.internal.i0
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(xe.a());
            }
        });
        G0 = F("measurement.integration.disable_firebase_instance_id", bool, new e5() { // from class: com.google.android.gms.measurement.internal.l0
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(eg.b());
            }
        });
        H0 = F("measurement.collection.service.update_with_analytics_fix", bool, new e5() { // from class: com.google.android.gms.measurement.internal.k0
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(jg.a());
            }
        });
        I0 = F("measurement.service.storage_consent_support_version", 203600, new e5() { // from class: com.google.android.gms.measurement.internal.n0
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Integer.valueOf((int) yd.a());
            }
        });
        J0 = F("measurement.service.store_null_safelist", bool2, new e5() { // from class: com.google.android.gms.measurement.internal.m0
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(fe.b());
            }
        });
        K0 = F("measurement.service.store_safelist", bool2, new e5() { // from class: com.google.android.gms.measurement.internal.p0
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(fe.c());
            }
        });
        L0 = F("measurement.session_stitching_token_enabled", bool, new e5() { // from class: com.google.android.gms.measurement.internal.o0
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(rf.b());
            }
        });
        M0 = F("measurement.sgtm.upload_queue", bool, new e5() { // from class: com.google.android.gms.measurement.internal.r0
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(xf.g());
            }
        });
        N0 = F("measurement.sgtm.google_signal.enable", bool, new e5() { // from class: com.google.android.gms.measurement.internal.q0
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(xf.c());
            }
        });
        O0 = F("measurement.sgtm.upload_on_uninstall", bool2, new e5() { // from class: com.google.android.gms.measurement.internal.u0
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(xf.h());
            }
        });
        P0 = F("measurement.sgtm.no_proxy.service", bool, new e5() { // from class: com.google.android.gms.measurement.internal.v0
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(xf.e());
            }
        });
        Q0 = F("measurement.sgtm.service.batching_on_backgrounded", bool, new e5() { // from class: com.google.android.gms.measurement.internal.y0
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(xf.f());
            }
        });
        R0 = b("measurement.sgtm.no_proxy.client", bool2, new e5() { // from class: com.google.android.gms.measurement.internal.x0
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(xf.d());
            }
        });
        S0 = b("measurement.sgtm.client.upload_on_backgrounded.dev", bool, new e5() { // from class: com.google.android.gms.measurement.internal.a1
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(xf.b());
            }
        });
        T0 = b("measurement.sgtm.client.scion_upload_action", bool2, new e5() { // from class: com.google.android.gms.measurement.internal.z0
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(xf.a());
            }
        });
        U0 = F("measurement.gmscore_client_telemetry", bool, new e5() { // from class: com.google.android.gms.measurement.internal.c1
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(we.a());
            }
        });
        V0 = b("measurement.rb.attribution.service", bool2, new e5() { // from class: com.google.android.gms.measurement.internal.b1
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(ef.i());
            }
        });
        W0 = b("measurement.rb.attribution.client2", bool2, new e5() { // from class: com.google.android.gms.measurement.internal.e1
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(ef.c());
            }
        });
        X0 = F("measurement.rb.attribution.uuid_generation", bool2, new e5() { // from class: com.google.android.gms.measurement.internal.d1
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(ef.k());
            }
        });
        Y0 = F("measurement.rb.attribution.enable_trigger_redaction", bool2, new e5() { // from class: com.google.android.gms.measurement.internal.f1
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(ef.j());
            }
        });
        F("measurement.rb.attribution.followup1.service", bool, new e5() { // from class: com.google.android.gms.measurement.internal.q1
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(ef.d());
            }
        });
        Z0 = F("measurement.rb.attribution.retry_disposition", bool, new e5() { // from class: com.google.android.gms.measurement.internal.a2
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(ef.h());
            }
        });
        f3549a1 = F("measurement.rb.attribution.ad_campaign_info", bool2, new e5() { // from class: com.google.android.gms.measurement.internal.n2
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(ef.b());
            }
        });
        f3552b1 = F("measurement.client.sessions.enable_fix_background_engagement", bool, new e5() { // from class: com.google.android.gms.measurement.internal.x2
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(wf.a());
            }
        });
        f3555c1 = F("measurement.fix_engagement_on_reset_analytics_data", bool2, new e5() { // from class: com.google.android.gms.measurement.internal.k3
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(le.a());
            }
        });
        f3558d1 = F("measurement.set_default_event_parameters_propagate_clear.service.dev", bool, new e5() { // from class: com.google.android.gms.measurement.internal.t3
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(ee.b());
            }
        });
        f3561e1 = F("measurement.set_default_event_parameters_propagate_clear.client.dev", bool, new e5() { // from class: com.google.android.gms.measurement.internal.h4
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(ee.a());
            }
        });
        f3564f1 = F("measurement.set_default_event_parameters.fix_deferred_analytics_collection", bool2, new e5() { // from class: com.google.android.gms.measurement.internal.q4
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(zd.b());
            }
        });
        f3567g1 = F("measurement.chimera.parameter.service", bool2, new e5() { // from class: com.google.android.gms.measurement.internal.j0
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(rd.b());
            }
        });
        f3570h1 = F("measurement.service.ad_impression.convert_value_to_double", bool2, new e5() { // from class: com.google.android.gms.measurement.internal.s0
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(md.a());
            }
        });
        F("measurement.rb.attribution.service.enable_max_trigger_uris_queried_at_once", bool2, new e5() { // from class: com.google.android.gms.measurement.internal.h1
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(ef.g());
            }
        });
        F("measurement.remove_conflicting_first_party_apis.dev", bool, new e5() { // from class: com.google.android.gms.measurement.internal.k1
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(kf.a());
            }
        });
        f3573i1 = F("measurement.rb.attribution.service.trigger_uris_high_priority", bool2, new e5() { // from class: com.google.android.gms.measurement.internal.j1
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(ef.f());
            }
        });
        f3576j1 = F("measurement.rb.attribution.client.get_trigger_uris_async", bool2, new e5() { // from class: com.google.android.gms.measurement.internal.m1
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(ef.e());
            }
        });
        f3579k1 = F("measurement.backfill_session_ids.service", bool, new e5() { // from class: com.google.android.gms.measurement.internal.l1
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(qf.b());
            }
        });
        f3582l1 = F("measurement.tcf.consent_fix", bool, new e5() { // from class: com.google.android.gms.measurement.internal.o1
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(dg.a());
            }
        });
        f3585m1 = F("measurement.experiment.enable_phenotype_experiment_reporting", bool2, new e5() { // from class: com.google.android.gms.measurement.internal.n1
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(lf.a());
            }
        });
        f3588n1 = F("measurement.set_default_event_parameters.fix_service_request_ordering", bool, new e5() { // from class: com.google.android.gms.measurement.internal.p1
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(zd.c());
            }
        });
        F("measurement.set_default_event_parameters.fix_app_update_logging", bool2, new e5() { // from class: com.google.android.gms.measurement.internal.s1
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(zd.a());
            }
        });
        f3591o1 = F("measurement.fix_high_memory.prune_ees_config", bool, new e5() { // from class: com.google.android.gms.measurement.internal.r1
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(qe.a());
            }
        });
        f3594p1 = b("measurement.upload_controller.wait_initialization", bool, new e5() { // from class: com.google.android.gms.measurement.internal.t1
            @Override // com.google.android.gms.measurement.internal.e5
            public final Object b() {
                return Boolean.valueOf(re.a());
            }
        });
    }

    private static <V> f5<V> F(String str, V v10, e5<V> e5Var) {
        return c(str, v10, v10, e5Var, false);
    }

    private static <V> f5<V> a(String str, V v10) {
        return c(str, v10, v10, null, false);
    }

    private static <V> f5<V> b(String str, V v10, e5<V> e5Var) {
        return c(str, v10, v10, e5Var, true);
    }

    private static <V> f5<V> c(String str, V v10, V v11, e5<V> e5Var, boolean z10) {
        f5<V> f5Var = new f5<>(str, v10, v11, e5Var, null);
        if (z10) {
            f3547a.add(f5Var);
        }
        return f5Var;
    }

    public static Map<String, String> e(Context context) {
        com.google.android.gms.internal.measurement.c7 c7VarA = com.google.android.gms.internal.measurement.c7.a(context.getContentResolver(), com.google.android.gms.internal.measurement.t7.a("com.google.android.gms.measurement"), new Runnable() { // from class: b2.d
            @Override // java.lang.Runnable
            public final void run() {
                s7.m();
            }
        });
        if (c7VarA == null) {
            return Collections.EMPTY_MAP;
        }
        return c7VarA.b();
    }
}
