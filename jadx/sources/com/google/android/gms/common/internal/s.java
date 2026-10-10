package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@VisibleForTesting
public final class s implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ b f2352b;

    public s(b bVar, int i10) {
        this.f2352b = bVar;
        this.f2351a = i10;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        b bVar = this.f2352b;
        if (iBinder == null) {
            b.b0(bVar, 16);
            return;
        }
        synchronized (bVar.f2315n) {
            try {
                b bVar2 = this.f2352b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                bVar2.f2316o = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof m1.e)) ? new n(iBinder) : (m1.e) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f2352b.c0(0, null, this.f2351a);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f2352b.f2315n) {
            this.f2352b.f2316o = null;
        }
        b bVar = this.f2352b;
        int i10 = this.f2351a;
        Handler handler = bVar.f2313l;
        handler.sendMessage(handler.obtainMessage(6, i10, 1));
    }
}
