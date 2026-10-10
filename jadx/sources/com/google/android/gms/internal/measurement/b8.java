package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class b8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f2553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Uri f2554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final String f2555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final String f2556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f2557e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f2558f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f2559g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f2560h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final com.google.common.base.f<Context, Boolean> f2561i;

    public b8(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    public final s7<String> c(String str, String str2) {
        return s7.d(this, str, str2, true);
    }

    private b8(String str, Uri uri, String str2, String str3, boolean z10, boolean z11, boolean z12, boolean z13, com.google.common.base.f<Context, Boolean> fVar) {
        this.f2553a = str;
        this.f2554b = uri;
        this.f2555c = str2;
        this.f2556d = str3;
        this.f2557e = z10;
        this.f2558f = z11;
        this.f2559g = z12;
        this.f2560h = z13;
        this.f2561i = fVar;
    }

    public final s7<Double> a(String str, double d10) {
        return s7.b(this, str, Double.valueOf(-3.0d), true);
    }

    public final b8 e() {
        return new b8(this.f2553a, this.f2554b, this.f2555c, this.f2556d, this.f2557e, this.f2558f, true, this.f2560h, this.f2561i);
    }

    public final b8 f() {
        if (!this.f2555c.isEmpty()) {
            throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
        }
        com.google.common.base.f<Context, Boolean> fVar = this.f2561i;
        if (fVar == null) {
            return new b8(this.f2553a, this.f2554b, this.f2555c, this.f2556d, true, this.f2558f, this.f2559g, this.f2560h, fVar);
        }
        throw new IllegalStateException("Cannot skip gservices both always and conditionally");
    }

    public final s7<Long> b(String str, long j10) {
        return s7.c(this, str, Long.valueOf(j10), true);
    }

    public final s7<Boolean> d(String str, boolean z10) {
        return s7.a(this, str, Boolean.valueOf(z10), true);
    }
}
