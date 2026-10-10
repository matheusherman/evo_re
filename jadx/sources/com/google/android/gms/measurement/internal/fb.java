package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.MainThread;
import b2.n1;
import com.google.android.gms.measurement.internal.fb;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class fb<T extends Context & b2.n1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f3545a;

    @MainThread
    public final IBinder b(Intent intent) {
        if (intent == null) {
            k().H().a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new w6(gc.o(this.f3545a));
        }
        k().M().b("onBind received unknown action", action);
        return null;
    }

    @MainThread
    public final boolean l(Intent intent) {
        if (intent == null) {
            k().H().a("onUnbind called with null intent");
            return true;
        }
        k().L().b("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    public static /* synthetic */ void d(fb fbVar, int i10, p5 p5Var, Intent intent) {
        if (fbVar.f3545a.a(i10)) {
            p5Var.L().b("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i10));
            fbVar.k().L().a("Completed wakeful intent.");
            fbVar.f3545a.b(intent);
        }
    }

    public static /* synthetic */ void e(fb fbVar, JobParameters jobParameters) {
        Log.v("FA", "AppMeasurementJobService processed last Scion upload request.");
        fbVar.f3545a.c(jobParameters, false);
    }

    private final p5 k() {
        return s6.d(this.f3545a, null, null).l();
    }

    @MainThread
    public final int a(final Intent intent, int i10, final int i11) {
        final p5 p5VarL = s6.d(this.f3545a, null, null).l();
        if (intent == null) {
            p5VarL.M().a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        p5VarL.L().c("Local AppMeasurementService called. startId, action", Integer.valueOf(i11), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            g(gc.o(this.f3545a), new Runnable() { // from class: b2.m1
                @Override // java.lang.Runnable
                public final void run() {
                    fb.d(this.f711a, i11, p5VarL, intent);
                }
            });
        }
        return 2;
    }

    @MainThread
    public final void c() {
        s6.d(this.f3545a, null, null).l().L().a("Local AppMeasurementService is starting up");
    }

    @MainThread
    public final void i() {
        s6.d(this.f3545a, null, null).l().L().a("Local AppMeasurementService is shutting down");
    }

    @MainThread
    public final void j(Intent intent) {
        if (intent == null) {
            k().H().a("onRebind called with null intent");
        } else {
            k().L().b("onRebind called. action", intent.getAction());
        }
    }

    public fb(T t10) {
        m1.g.k(t10);
        this.f3545a = t10;
    }

    public static /* synthetic */ void f(fb fbVar, p5 p5Var, JobParameters jobParameters) {
        p5Var.L().a("AppMeasurementJobService processed last upload request.");
        fbVar.f3545a.c(jobParameters, false);
    }

    private final void g(gc gcVar, Runnable runnable) {
        gcVar.a().E(new gb(this, gcVar, runnable));
    }

    @TargetApi(24)
    @MainThread
    public final boolean h(final JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("action");
        if (Objects.equals(string, "com.google.android.gms.measurement.UPLOAD")) {
            String str = (String) m1.g.k(string);
            gc gcVarO = gc.o(this.f3545a);
            final p5 p5VarL = gcVarO.l();
            p5VarL.L().b("Local AppMeasurementJobService called. action", str);
            g(gcVarO, new Runnable() { // from class: b2.l1
                @Override // java.lang.Runnable
                public final void run() {
                    fb.f(this.f708a, p5VarL, jobParameters);
                }
            });
        }
        if (Objects.equals(string, "com.google.android.gms.measurement.SCION_UPLOAD")) {
            com.google.android.gms.internal.measurement.f3 f3VarE = com.google.android.gms.internal.measurement.f3.e(this.f3545a);
            if (g0.T0.a(null).booleanValue()) {
                f3VarE.r(new Runnable() { // from class: b2.k1
                    @Override // java.lang.Runnable
                    public final void run() {
                        fb.e(this.f704a, jobParameters);
                    }
                });
                return true;
            }
            return true;
        }
        return true;
    }
}
