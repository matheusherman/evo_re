package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import b2.n1;
import com.google.android.gms.measurement.internal.fb;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private fb<AppMeasurementJobService> f3351a;

    @Override // b2.n1
    @TargetApi(24)
    public final void c(@NonNull JobParameters jobParameters, boolean z10) {
        jobFinished(jobParameters, false);
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(@NonNull JobParameters jobParameters) {
        return false;
    }

    private final fb<AppMeasurementJobService> d() {
        if (this.f3351a == null) {
            this.f3351a = new fb<>(this);
        }
        return this.f3351a;
    }

    @Override // b2.n1
    public final boolean a(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    @MainThread
    public final void onCreate() {
        super.onCreate();
        d().c();
    }

    @Override // android.app.Service
    @MainThread
    public final void onDestroy() {
        d().i();
        super.onDestroy();
    }

    @Override // android.app.Service
    @MainThread
    public final void onRebind(@NonNull Intent intent) {
        d().j(intent);
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(@NonNull JobParameters jobParameters) {
        return d().h(jobParameters);
    }

    @Override // android.app.Service
    @MainThread
    public final boolean onUnbind(@NonNull Intent intent) {
        return d().l(intent);
    }

    @Override // b2.n1
    public final void b(@NonNull Intent intent) {
    }
}
