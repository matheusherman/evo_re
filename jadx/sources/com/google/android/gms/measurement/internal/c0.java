package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f3440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f3441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f3442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f3443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final long f3444e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final long f3445f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final long f3446g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Long f3447h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final Long f3448i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final Long f3449j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final Boolean f3450k;

    c0(String str, String str2, long j10, long j11, long j12, long j13, Long l10, Long l11, Long l12, Boolean bool) {
        this(str, str2, 0L, 0L, 0L, j12, 0L, null, null, null, null);
    }

    c0(String str, String str2, long j10, long j11, long j12, long j13, long j14, Long l10, Long l11, Long l12, Boolean bool) {
        m1.g.e(str);
        m1.g.e(str2);
        m1.g.a(j10 >= 0);
        m1.g.a(j11 >= 0);
        m1.g.a(j12 >= 0);
        m1.g.a(j14 >= 0);
        this.f3440a = str;
        this.f3441b = str2;
        this.f3442c = j10;
        this.f3443d = j11;
        this.f3444e = j12;
        this.f3445f = j13;
        this.f3446g = j14;
        this.f3447h = l10;
        this.f3448i = l11;
        this.f3449j = l12;
        this.f3450k = bool;
    }

    final c0 a(long j10) {
        return new c0(this.f3440a, this.f3441b, this.f3442c, this.f3443d, this.f3444e, j10, this.f3446g, this.f3447h, this.f3448i, this.f3449j, this.f3450k);
    }

    final c0 b(long j10, long j11) {
        return new c0(this.f3440a, this.f3441b, this.f3442c, this.f3443d, this.f3444e, this.f3445f, j10, Long.valueOf(j11), this.f3448i, this.f3449j, this.f3450k);
    }

    final c0 c(Long l10, Long l11, Boolean bool) {
        return new c0(this.f3440a, this.f3441b, this.f3442c, this.f3443d, this.f3444e, this.f3445f, this.f3446g, this.f3447h, l10, l11, (bool == null || bool.booleanValue()) ? bool : null);
    }
}
