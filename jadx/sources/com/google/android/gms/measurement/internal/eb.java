package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class eb extends bc {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, cb> f3519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b6 f3520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b6 f3521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b6 f3522g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b6 f3523h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b6 f3524i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b6 f3525j;

    @Override // com.google.android.gms.measurement.internal.bc
    protected final boolean y() {
        return false;
    }

    @WorkerThread
    @Deprecated
    private final Pair<String, Boolean> z(String str) {
        cb cbVar;
        g1.a.C0182a c0182aA;
        n();
        long jB = c().b();
        cb cbVar2 = this.f3519d.get(str);
        if (cbVar2 != null && jB < cbVar2.f3463c) {
            return new Pair<>(cbVar2.f3461a, Boolean.valueOf(cbVar2.f3462b));
        }
        g1.a.b(true);
        long jF = d().F(str) + jB;
        try {
            try {
                c0182aA = g1.a.a(b());
            } catch (PackageManager.NameNotFoundException unused) {
                if (cbVar2 != null && jB < cbVar2.f3463c + d().D(str, g0.f3553c)) {
                    return new Pair<>(cbVar2.f3461a, Boolean.valueOf(cbVar2.f3462b));
                }
                c0182aA = null;
            }
            if (c0182aA == null) {
                return new Pair<>("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
            }
            String strA = c0182aA.a();
            cbVar = strA != null ? new cb(strA, c0182aA.b(), jF) : new cb("", c0182aA.b(), jF);
            this.f3519d.put(str, cbVar);
            g1.a.b(false);
            return new Pair<>(cbVar.f3461a, Boolean.valueOf(cbVar.f3462b));
        } catch (Exception e10) {
            l().G().b("Unable to get advertising id", e10);
            cbVar = new cb("", false, jF);
        }
    }

    eb(gc gcVar) {
        super(gcVar);
        this.f3519d = new HashMap();
        a6 a6VarH = h();
        Objects.requireNonNull(a6VarH);
        this.f3520e = new b6(a6VarH, "last_delete_stale", 0L);
        a6 a6VarH2 = h();
        Objects.requireNonNull(a6VarH2);
        this.f3521f = new b6(a6VarH2, "last_delete_stale_batch", 0L);
        a6 a6VarH3 = h();
        Objects.requireNonNull(a6VarH3);
        this.f3522g = new b6(a6VarH3, "backoff", 0L);
        a6 a6VarH4 = h();
        Objects.requireNonNull(a6VarH4);
        this.f3523h = new b6(a6VarH4, "last_upload", 0L);
        a6 a6VarH5 = h();
        Objects.requireNonNull(a6VarH5);
        this.f3524i = new b6(a6VarH5, "last_upload_attempt", 0L);
        a6 a6VarH6 = h();
        Objects.requireNonNull(a6VarH6);
        this.f3525j = new b6(a6VarH6, "midnight_offset", 0L);
    }

    @WorkerThread
    final Pair<String, Boolean> A(String str, v7 v7Var) {
        if (v7Var.w()) {
            return z(str);
        }
        return new Pair<>("", Boolean.FALSE);
    }

    @WorkerThread
    @Deprecated
    final String B(String str, boolean z10) {
        String str2;
        n();
        if (z10) {
            str2 = (String) z(str).first;
        } else {
            str2 = "00000000-0000-0000-0000-000000000000";
        }
        MessageDigest messageDigestU0 = wc.U0();
        if (messageDigestU0 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestU0.digest(str2.getBytes())));
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ p6 a() {
        return super.a();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ Context b() {
        return super.b();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.util.d c() {
        return super.c();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ i d() {
        return super.d();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ e e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ a0 f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ k5 g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ a6 h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ l9 i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ wc j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void k() {
        super.k();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ p5 l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void m() {
        super.m();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void n() {
        super.n();
    }

    @Override // com.google.android.gms.measurement.internal.yb
    public final /* bridge */ /* synthetic */ sc o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.yb
    public final /* bridge */ /* synthetic */ zc q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.yb
    public final /* bridge */ /* synthetic */ m r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.yb
    public final /* bridge */ /* synthetic */ j6 s() {
        return super.s();
    }

    @Override // com.google.android.gms.measurement.internal.yb
    public final /* bridge */ /* synthetic */ eb t() {
        return super.t();
    }

    @Override // com.google.android.gms.measurement.internal.yb
    public final /* bridge */ /* synthetic */ ec u() {
        return super.u();
    }
}
