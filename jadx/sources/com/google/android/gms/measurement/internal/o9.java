package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class o9 extends m5 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JobScheduler f3871c;

    @Override // com.google.android.gms.measurement.internal.m5
    protected final boolean y() {
        return true;
    }

    public o9(s6 s6Var) {
        super(s6Var);
    }

    @VisibleForTesting
    private final int F() {
        return ("measurement-client" + b().getPackageName()).hashCode();
    }

    @Override // com.google.android.gms.measurement.internal.m5
    @TargetApi(24)
    @WorkerThread
    protected final void C() {
        this.f3871c = (JobScheduler) b().getSystemService("jobscheduler");
    }

    @TargetApi(24)
    @WorkerThread
    public final void D(long j10) {
        String str;
        z();
        n();
        JobScheduler jobScheduler = this.f3871c;
        if (jobScheduler != null && jobScheduler.getPendingJob(F()) != null) {
            l().L().a("[sgtm] There's an existing pending job, skip this schedule.");
            return;
        }
        com.google.android.gms.internal.measurement.x5.b bVarE = E();
        if (bVarE != com.google.android.gms.internal.measurement.x5.b.CLIENT_UPLOAD_ELIGIBLE) {
            l().L().b("[sgtm] Not eligible for Scion upload", bVarE.name());
            return;
        }
        l().L().b("[sgtm] Scheduling Scion upload, millis", Long.valueOf(j10));
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.SCION_UPLOAD");
        int iSchedule = ((JobScheduler) m1.g.k(this.f3871c)).schedule(new JobInfo.Builder(F(), new ComponentName(b(), "com.google.android.gms.measurement.AppMeasurementJobService")).setRequiredNetworkType(1).setMinimumLatency(j10).setOverrideDeadline(j10 << 1).setExtras(persistableBundle).build());
        r5 r5VarL = l().L();
        if (iSchedule == 1) {
            str = "SUCCESS";
        } else {
            str = "FAILURE";
        }
        r5VarL.b("[sgtm] Scion upload job scheduled with result", str);
    }

    @WorkerThread
    final com.google.android.gms.internal.measurement.x5.b E() {
        z();
        n();
        if (!d().u(g0.R0)) {
            return com.google.android.gms.internal.measurement.x5.b.CLIENT_FLAG_OFF;
        }
        if (this.f3871c == null) {
            return com.google.android.gms.internal.measurement.x5.b.MISSING_JOB_SCHEDULER;
        }
        if (!d().w()) {
            return com.google.android.gms.internal.measurement.x5.b.NOT_ENABLED_IN_MANIFEST;
        }
        if (!d().u(g0.T0)) {
            return com.google.android.gms.internal.measurement.x5.b.SDK_TOO_OLD;
        }
        if (!wc.v0(b(), "com.google.android.gms.measurement.AppMeasurementJobService")) {
            return com.google.android.gms.internal.measurement.x5.b.MEASUREMENT_SERVICE_NOT_ENABLED;
        }
        if (Build.VERSION.SDK_INT < 24) {
            return com.google.android.gms.internal.measurement.x5.b.ANDROID_TOO_OLD;
        }
        if (!v().p0()) {
            return com.google.android.gms.internal.measurement.x5.b.NON_PLAY_MODE;
        }
        return com.google.android.gms.internal.measurement.x5.b.CLIENT_UPLOAD_ELIGIBLE;
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
