package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.MainThread;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class h6 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ f6 f3684b;

    h6(f6 f6Var, String str) {
        this.f3684b = f6Var;
        this.f3683a = str;
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.f3684b.f3533a.l().M().a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            com.google.android.gms.internal.measurement.c1 c1VarF = com.google.android.gms.internal.measurement.b1.f(iBinder);
            if (c1VarF == null) {
                this.f3684b.f3533a.l().M().a("Install Referrer Service implementation was not found");
            } else {
                this.f3684b.f3533a.l().L().a("Install Referrer Service connected");
                this.f3684b.f3533a.a().E(new g6(this, c1VarF, this));
            }
        } catch (RuntimeException e10) {
            this.f3684b.f3533a.l().M().b("Exception occurred while calling Install Referrer API", e10);
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f3684b.f3533a.l().L().a("Install Referrer Service disconnected");
    }
}
