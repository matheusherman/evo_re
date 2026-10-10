package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class pc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f3917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.google.android.gms.internal.measurement.s5 f3918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f3919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, String> f3920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b2.c1 f3921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f3922f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f3923g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3924h;

    /* synthetic */ pc(long j10, com.google.android.gms.internal.measurement.s5 s5Var, String str, Map map, b2.c1 c1Var, long j11, long j12, long j13, int i10, b2.u1 u1Var) {
        this(j10, s5Var, str, map, c1Var, j11, j12, j13, i10);
    }

    private pc(long j10, com.google.android.gms.internal.measurement.s5 s5Var, String str, Map<String, String> map, b2.c1 c1Var, long j11, long j12, long j13, int i10) {
        this.f3917a = j10;
        this.f3918b = s5Var;
        this.f3919c = str;
        this.f3920d = map;
        this.f3921e = c1Var;
        this.f3922f = j12;
        this.f3923g = j13;
        this.f3924h = i10;
    }

    public final int a() {
        return this.f3924h;
    }

    public final long b() {
        return this.f3923g;
    }

    public final long c() {
        return this.f3917a;
    }

    public final b2.c1 d() {
        return this.f3921e;
    }

    public final zzoz e() {
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : this.f3920d.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        return new zzoz(this.f3917a, this.f3918b.m(), this.f3919c, bundle, this.f3921e.b(), this.f3922f);
    }

    public final dc f() {
        return new dc(this.f3919c, this.f3920d, this.f3921e);
    }

    @Nullable
    public final com.google.android.gms.internal.measurement.s5 g() {
        return this.f3918b;
    }

    public final String h() {
        return this.f3919c;
    }
}
