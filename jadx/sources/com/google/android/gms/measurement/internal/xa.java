package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class xa implements ServiceConnection, com.google.android.gms.common.internal.b.a, com.google.android.gms.common.internal.b.InterfaceC0045b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f4207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile l5 f4208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ x9 f4209c;

    protected xa(x9 x9Var) {
        this.f4209c = x9Var;
    }

    @Override // com.google.android.gms.common.internal.b.a
    @MainThread
    public final void a(int i10) {
        m1.g.d("MeasurementServiceConnection.onConnectionSuspended");
        this.f4209c.l().G().a("Service connection suspended");
        this.f4209c.a().E(new bb(this));
    }

    @WorkerThread
    public final void b() {
        this.f4209c.n();
        Context contextB = this.f4209c.b();
        synchronized (this) {
            try {
                if (this.f4207a) {
                    this.f4209c.l().L().a("Connection attempt already in progress");
                    return;
                }
                if (this.f4208b != null && (this.f4208b.d() || this.f4208b.isConnected())) {
                    this.f4209c.l().L().a("Already awaiting connection attempt");
                    return;
                }
                this.f4208b = new l5(contextB, Looper.getMainLooper(), this, this);
                this.f4209c.l().L().a("Connecting to remote service");
                this.f4207a = true;
                m1.g.k(this.f4208b);
                this.f4208b.o();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @WorkerThread
    public final void c(Intent intent) {
        this.f4209c.n();
        Context contextB = this.f4209c.b();
        s1.b bVarB = s1.b.b();
        synchronized (this) {
            try {
                if (this.f4207a) {
                    this.f4209c.l().L().a("Connection attempt already in progress");
                    return;
                }
                this.f4209c.l().L().a("Using local app measurement service");
                this.f4207a = true;
                bVarB.a(contextB, intent, this.f4209c.f4200c, 129);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @WorkerThread
    public final void e() {
        if (this.f4208b != null && (this.f4208b.isConnected() || this.f4208b.d())) {
            this.f4208b.disconnect();
        }
        this.f4208b = null;
    }

    @Override // com.google.android.gms.common.internal.b.InterfaceC0045b
    @MainThread
    public final void f(@NonNull ConnectionResult connectionResult) {
        m1.g.d("MeasurementServiceConnection.onConnectionFailed");
        p5 p5VarG = this.f4209c.f3965a.G();
        if (p5VarG != null) {
            p5VarG.M().b("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.f4207a = false;
            this.f4208b = null;
        }
        this.f4209c.a().E(new ab(this, connectionResult));
    }

    @Override // com.google.android.gms.common.internal.b.a
    @MainThread
    public final void g(Bundle bundle) {
        m1.g.d("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                m1.g.k(this.f4208b);
                this.f4209c.a().E(new ya(this, this.f4208b.B()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f4208b = null;
                this.f4207a = false;
            }
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        m1.g.d("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.f4207a = false;
                this.f4209c.l().H().a("Service connected with null binder");
                return;
            }
            b2.g g5Var = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    g5Var = iInterfaceQueryLocalInterface instanceof b2.g ? (b2.g) iInterfaceQueryLocalInterface : new g5(iBinder);
                    this.f4209c.l().L().a("Bound to IMeasurementService interface");
                } else {
                    this.f4209c.l().H().b("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.f4209c.l().H().a("Service connect failed to get IMeasurementService");
            }
            if (g5Var == null) {
                this.f4207a = false;
                try {
                    s1.b.b().c(this.f4209c.b(), this.f4209c.f4200c);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.f4209c.a().E(new wa(this, g5Var));
            }
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        m1.g.d("MeasurementServiceConnection.onServiceDisconnected");
        this.f4209c.l().G().a("Service disconnected");
        this.f4209c.a().E(new za(this, componentName));
    }
}
