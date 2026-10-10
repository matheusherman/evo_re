package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class w extends v2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Long> f4133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, Integer> f4134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f4135d;

    @WorkerThread
    private final void C(String str, long j10, q9 q9Var) {
        if (q9Var == null) {
            l().L().a("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j10 < 1000) {
            l().L().b("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j10));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j10);
        wc.Y(q9Var, bundle, true);
        s().h1("am", "_xu", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void D(long j10) {
        Iterator<String> it = this.f4133b.keySet().iterator();
        while (it.hasNext()) {
            this.f4133b.put(it.next(), Long.valueOf(j10));
        }
        if (this.f4133b.isEmpty()) {
            return;
        }
        this.f4135d = j10;
    }

    @WorkerThread
    private final void y(long j10, q9 q9Var) {
        if (q9Var == null) {
            l().L().a("Not logging ad exposure. No active activity");
            return;
        }
        if (j10 < 1000) {
            l().L().b("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j10));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j10);
        wc.Y(q9Var, bundle, true);
        s().h1("am", "_xa", bundle);
    }

    public final void B(String str, long j10) {
        if (str == null || str.length() == 0) {
            l().H().a("Ad unit id must be a non-empty string");
        } else {
            a().E(new a(this, str, j10));
        }
    }

    public final void F(String str, long j10) {
        if (str == null || str.length() == 0) {
            l().H().a("Ad unit id must be a non-empty string");
        } else {
            a().E(new u1(this, str, j10));
        }
    }

    public w(s6 s6Var) {
        super(s6Var);
        this.f4134c = new ArrayMap();
        this.f4133b = new ArrayMap();
    }

    static /* synthetic */ void A(w wVar, String str, long j10) {
        wVar.n();
        m1.g.e(str);
        if (wVar.f4134c.isEmpty()) {
            wVar.f4135d = j10;
        }
        Integer num = wVar.f4134c.get(str);
        if (num != null) {
            wVar.f4134c.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (wVar.f4134c.size() >= 100) {
            wVar.l().M().a("Too many ads visible");
        } else {
            wVar.f4134c.put(str, 1);
            wVar.f4133b.put(str, Long.valueOf(j10));
        }
    }

    static /* synthetic */ void E(w wVar, String str, long j10) {
        wVar.n();
        m1.g.e(str);
        Integer num = wVar.f4134c.get(str);
        if (num != null) {
            q9 q9VarE = wVar.u().E(false);
            int iIntValue = num.intValue() - 1;
            if (iIntValue == 0) {
                wVar.f4134c.remove(str);
                Long l10 = wVar.f4133b.get(str);
                if (l10 == null) {
                    wVar.l().H().a("First ad unit exposure time was never set");
                } else {
                    long jLongValue = j10 - l10.longValue();
                    wVar.f4133b.remove(str);
                    wVar.C(str, jLongValue, q9VarE);
                }
                if (wVar.f4134c.isEmpty()) {
                    long j11 = wVar.f4135d;
                    if (j11 == 0) {
                        wVar.l().H().a("First ad exposure time was never set");
                        return;
                    } else {
                        wVar.y(j10 - j11, q9VarE);
                        wVar.f4135d = 0L;
                        return;
                    }
                }
                return;
            }
            wVar.f4134c.put(str, Integer.valueOf(iIntValue));
            return;
        }
        wVar.l().H().b("Call to endAdUnitExposure for unknown ad unit id", str);
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

    @Override // com.google.android.gms.measurement.internal.v2, com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void k() {
        super.k();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ p5 l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.v2, com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void m() {
        super.m();
    }

    @Override // com.google.android.gms.measurement.internal.v2, com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void n() {
        super.n();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ w o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ h5 q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ j5 r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ z7 s() {
        return super.s();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ o9 t() {
        return super.t();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ s9 u() {
        return super.u();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ x9 v() {
        return super.v();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ ib w() {
        return super.w();
    }

    @WorkerThread
    public final void x(long j10) {
        q9 q9VarE = u().E(false);
        for (String str : this.f4133b.keySet()) {
            C(str, j10 - this.f4133b.get(str).longValue(), q9VarE);
        }
        if (!this.f4133b.isEmpty()) {
            y(j10 - this.f4135d, q9VarE);
        }
        D(j10);
    }
}
