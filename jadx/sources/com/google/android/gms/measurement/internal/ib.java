package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class ib extends m5 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f3718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final qb f3720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final ob f3721f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final jb f3722g;

    @Override // com.google.android.gms.measurement.internal.m5
    protected final boolean y() {
        return false;
    }

    public final boolean G(boolean z10, boolean z11, long j10) {
        return this.f3721f.d(z10, z11, j10);
    }

    ib(s6 s6Var) {
        super(s6Var);
        this.f3719d = true;
        this.f3720e = new qb(this);
        this.f3721f = new ob(this);
        this.f3722g = new jb(this);
    }

    static /* synthetic */ void E(ib ibVar, long j10) {
        ibVar.n();
        ibVar.I();
        ibVar.l().L().b("Activity paused, time", Long.valueOf(j10));
        ibVar.f3722g.b(j10);
        if (ibVar.d().Y()) {
            ibVar.f3721f.e(j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void I() {
        n();
        if (this.f3718c == null) {
            this.f3718c = new com.google.android.gms.internal.measurement.n2(Looper.getMainLooper());
        }
    }

    static /* synthetic */ void K(ib ibVar, long j10) {
        ibVar.n();
        ibVar.I();
        ibVar.l().L().b("Activity resumed, time", Long.valueOf(j10));
        if (ibVar.d().u(g0.f3552b1)) {
            if (ibVar.d().Y() || ibVar.f3719d) {
                ibVar.f3721f.f(j10);
            }
        } else if (ibVar.d().Y() || ibVar.h().f3386u.b()) {
            ibVar.f3721f.f(j10);
        }
        ibVar.f3722g.a();
        qb qbVar = ibVar.f3720e;
        qbVar.f3954a.n();
        if (qbVar.f3954a.f3965a.s()) {
            qbVar.b(qbVar.f3954a.c().a(), false);
        }
    }

    @WorkerThread
    final void F(boolean z10) {
        n();
        this.f3719d = z10;
    }

    @WorkerThread
    final boolean H() {
        n();
        return this.f3719d;
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
}
