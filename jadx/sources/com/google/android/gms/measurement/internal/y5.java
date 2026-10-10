package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class y5 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gc f4217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4219c;

    @WorkerThread
    public final void b() {
        this.f4217a.Q0();
        this.f4217a.a().n();
        if (this.f4218b) {
            return;
        }
        this.f4217a.b().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f4219c = this.f4217a.E0().C();
        this.f4217a.l().L().b("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f4219c));
        this.f4218b = true;
    }

    @WorkerThread
    public final void c() {
        this.f4217a.Q0();
        this.f4217a.a().n();
        this.f4217a.a().n();
        if (this.f4218b) {
            this.f4217a.l().L().a("Unregistering connectivity change receiver");
            this.f4218b = false;
            this.f4219c = false;
            try {
                this.f4217a.b().unregisterReceiver(this);
            } catch (IllegalArgumentException e10) {
                this.f4217a.l().H().b("Failed to unregister the network broadcast receiver", e10);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    @MainThread
    public void onReceive(Context context, Intent intent) {
        this.f4217a.Q0();
        String action = intent.getAction();
        this.f4217a.l().L().b("NetworkBroadcastReceiver received action", action);
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            this.f4217a.l().M().b("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        boolean zC = this.f4217a.E0().C();
        if (this.f4219c != zC) {
            this.f4219c = zC;
            this.f4217a.a().E(new x5(this, zC));
        }
    }

    y5(gc gcVar) {
        m1.g.k(gcVar);
        this.f4217a = gcVar;
    }
}
