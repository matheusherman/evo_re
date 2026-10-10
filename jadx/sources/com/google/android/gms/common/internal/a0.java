package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.p000lifecycle.CoroutineLiveDataKt;
import com.google.android.gms.common.ConnectionResult;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.concurrent.Executor;
import m1.j0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class a0 extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashMap f2294g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Context f2295h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile Handler f2296i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final z f2297j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final s1.b f2298k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f2299l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final long f2300m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private volatile Executor f2301n;

    @Override // com.google.android.gms.common.internal.d
    protected final ConnectionResult c(j0 j0Var, ServiceConnection serviceConnection, String str, @Nullable Executor executor) {
        ConnectionResult connectionResultD;
        m1.g.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f2294g) {
            try {
                y yVar = (y) this.f2294g.get(j0Var);
                if (executor == null) {
                    executor = this.f2301n;
                }
                if (yVar == null) {
                    yVar = new y(this, j0Var);
                    yVar.e(serviceConnection, serviceConnection, str);
                    connectionResultD = y.d(yVar, str, executor);
                    this.f2294g.put(j0Var, yVar);
                } else {
                    this.f2296i.removeMessages(0, j0Var);
                    if (yVar.h(serviceConnection)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + j0Var.toString());
                    }
                    yVar.e(serviceConnection, serviceConnection, str);
                    int iA = yVar.a();
                    if (iA == 1) {
                        serviceConnection.onServiceConnected(yVar.b(), yVar.c());
                    } else if (iA == 2) {
                        connectionResultD = y.d(yVar, str, executor);
                    }
                    connectionResultD = null;
                }
                if (yVar.j()) {
                    return ConnectionResult.f2120e;
                }
                if (connectionResultD == null) {
                    connectionResultD = new ConnectionResult(-1);
                }
                return connectionResultD;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.d
    protected final void d(j0 j0Var, ServiceConnection serviceConnection, String str) {
        m1.g.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f2294g) {
            try {
                y yVar = (y) this.f2294g.get(j0Var);
                if (yVar == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: " + j0Var.toString());
                }
                if (!yVar.h(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + j0Var.toString());
                }
                yVar.f(serviceConnection, str);
                if (yVar.i()) {
                    this.f2296i.sendMessageDelayed(this.f2296i.obtainMessage(0, j0Var), this.f2299l);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    a0(Context context, Looper looper, @Nullable Executor executor) {
        z zVar = new z(this, null);
        this.f2297j = zVar;
        this.f2295h = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f2296i = new y1.f(looper, zVar);
        this.f2298k = s1.b.b();
        this.f2299l = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
        this.f2300m = 300000L;
        this.f2301n = executor;
    }
}
