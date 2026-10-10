package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.legacy.content.WakefulBroadcastReceiver;
import b2.n1;
import com.google.android.gms.measurement.internal.fb;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class AppMeasurementService extends Service implements n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private fb<AppMeasurementService> f3353a;

    private final fb<AppMeasurementService> d() {
        if (this.f3353a == null) {
            this.f3353a = new fb<>(this);
        }
        return this.f3353a;
    }

    @Override // b2.n1
    public final void c(@NonNull JobParameters jobParameters, boolean z10) {
        throw new UnsupportedOperationException();
    }

    @Override // b2.n1
    public final boolean a(int i10) {
        return stopSelfResult(i10);
    }

    @Override // b2.n1
    public final void b(@NonNull Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }

    @Override // android.app.Service
    @Nullable
    @MainThread
    public final IBinder onBind(@NonNull Intent intent) {
        return d().b(intent);
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

    @Override // android.app.Service
    @MainThread
    public final int onStartCommand(@NonNull Intent intent, int i10, int i11) {
        return d().a(intent, i10, i11);
    }

    @Override // android.app.Service
    @MainThread
    public final boolean onUnbind(@NonNull Intent intent) {
        return d().l(intent);
    }
}
