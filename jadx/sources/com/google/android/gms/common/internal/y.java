package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import m1.f0;
import m1.j0;
import m1.l0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class y implements ServiceConnection, l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f2356a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2357b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private IBinder f2359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final j0 f2360e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ComponentName f2361f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ a0 f2362g;

    public y(a0 a0Var, j0 j0Var) {
        this.f2362g = a0Var;
        this.f2360e = j0Var;
    }

    static /* bridge */ /* synthetic */ ConnectionResult d(y yVar, String str, Executor executor) {
        try {
            Intent intentB = yVar.f2360e.b(yVar.f2362g.f2295h);
            yVar.f2357b = 3;
            StrictMode.VmPolicy vmPolicyA = com.google.android.gms.common.util.v.a();
            try {
                a0 a0Var = yVar.f2362g;
                boolean zD = a0Var.f2298k.d(a0Var.f2295h, str, intentB, yVar, 4225, executor);
                yVar.f2358c = zD;
                if (zD) {
                    yVar.f2362g.f2296i.sendMessageDelayed(yVar.f2362g.f2296i.obtainMessage(1, yVar.f2360e), yVar.f2362g.f2300m);
                    return ConnectionResult.f2120e;
                }
                yVar.f2357b = 2;
                try {
                    a0 a0Var2 = yVar.f2362g;
                    a0Var2.f2298k.c(a0Var2.f2295h, yVar);
                } catch (IllegalArgumentException unused) {
                }
                return new ConnectionResult(16);
            } finally {
                StrictMode.setVmPolicy(vmPolicyA);
            }
        } catch (f0 e10) {
            return e10.zza;
        }
    }

    public final int a() {
        return this.f2357b;
    }

    public final ComponentName b() {
        return this.f2361f;
    }

    @Nullable
    public final IBinder c() {
        return this.f2359d;
    }

    public final void e(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f2356a.put(serviceConnection, serviceConnection2);
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        this.f2356a.remove(serviceConnection);
    }

    public final void g(String str) {
        this.f2362g.f2296i.removeMessages(1, this.f2360e);
        a0 a0Var = this.f2362g;
        a0Var.f2298k.c(a0Var.f2295h, this);
        this.f2358c = false;
        this.f2357b = 2;
    }

    public final boolean h(ServiceConnection serviceConnection) {
        return this.f2356a.containsKey(serviceConnection);
    }

    public final boolean i() {
        return this.f2356a.isEmpty();
    }

    public final boolean j() {
        return this.f2358c;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f2362g.f2294g) {
            try {
                this.f2362g.f2296i.removeMessages(1, this.f2360e);
                this.f2359d = iBinder;
                this.f2361f = componentName;
                Iterator it = this.f2356a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f2357b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f2362g.f2294g) {
            try {
                this.f2362g.f2296i.removeMessages(1, this.f2360e);
                this.f2359d = null;
                this.f2361f = componentName;
                Iterator it = this.f2356a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f2357b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }
}
