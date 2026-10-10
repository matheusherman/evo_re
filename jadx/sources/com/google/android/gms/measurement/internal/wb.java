package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.core.app.NotificationCompat;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class wb extends bc {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AlarmManager f4155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private v f4156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Integer f4157f;

    private final int B() {
        if (this.f4157f == null) {
            this.f4157f = Integer.valueOf(("measurement" + b().getPackageName()).hashCode());
        }
        return this.f4157f.intValue();
    }

    private final v D() {
        if (this.f4156e == null) {
            this.f4156e = new vb(this, this.f4241b.I0());
        }
        return this.f4156e;
    }

    @Override // com.google.android.gms.measurement.internal.bc
    protected final boolean y() {
        AlarmManager alarmManager = this.f4155d;
        if (alarmManager != null) {
            alarmManager.cancel(C());
        }
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        E();
        return false;
    }

    protected wb(gc gcVar) {
        super(gcVar);
        this.f4155d = (AlarmManager) b().getSystemService(NotificationCompat.CATEGORY_ALARM);
    }

    private final PendingIntent C() {
        Context contextB = b();
        return com.google.android.gms.internal.measurement.b2.a(contextB, 0, new Intent().setClassName(contextB, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), com.google.android.gms.internal.measurement.b2.f2549a);
    }

    @TargetApi(24)
    private final void E() {
        JobScheduler jobScheduler = (JobScheduler) b().getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(B());
        }
    }

    public final void A() {
        v();
        l().L().a("Unscheduling upload");
        AlarmManager alarmManager = this.f4155d;
        if (alarmManager != null) {
            alarmManager.cancel(C());
        }
        D().a();
        if (Build.VERSION.SDK_INT >= 24) {
            E();
        }
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

    public final void z(long j10) {
        v();
        Context contextB = b();
        if (!wc.f0(contextB)) {
            l().G().a("Receiver not registered/enabled");
        }
        if (!wc.g0(contextB, false)) {
            l().G().a("Service not registered/enabled");
        }
        A();
        l().L().b("Scheduling upload, millis", Long.valueOf(j10));
        long jB = c().b() + j10;
        if (j10 < Math.max(0L, g0.L.a(null).longValue()) && !D().e()) {
            D().b(j10);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Context contextB2 = b();
            ComponentName componentName = new ComponentName(contextB2, "com.google.android.gms.measurement.AppMeasurementJobService");
            int iB = B();
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
            com.google.android.gms.internal.measurement.a2.c(contextB2, new JobInfo.Builder(iB, componentName).setMinimumLatency(j10).setOverrideDeadline(j10 << 1).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
            return;
        }
        AlarmManager alarmManager = this.f4155d;
        if (alarmManager != null) {
            alarmManager.setInexactRepeating(2, jB, Math.max(g0.G.a(null).longValue(), j10), C());
        }
    }
}
