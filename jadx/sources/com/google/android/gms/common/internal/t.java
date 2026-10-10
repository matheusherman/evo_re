package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class t extends m {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final IBinder f2353g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ b f2354h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @BinderThread
    public t(b bVar, @Nullable int i10, @Nullable IBinder iBinder, Bundle bundle) {
        super(bVar, i10, bundle);
        this.f2354h = bVar;
        this.f2353g = iBinder;
    }

    @Override // com.google.android.gms.common.internal.m
    protected final void f(ConnectionResult connectionResult) {
        if (this.f2354h.f2323v != null) {
            this.f2354h.f2323v.f(connectionResult);
        }
        this.f2354h.J(connectionResult);
    }

    @Override // com.google.android.gms.common.internal.m
    protected final boolean g() {
        try {
            IBinder iBinder = this.f2353g;
            m1.g.k(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.f2354h.C().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + this.f2354h.C() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface iInterfaceQ = this.f2354h.q(this.f2353g);
            if (iInterfaceQ == null || !(b.e0(this.f2354h, 2, 4, iInterfaceQ) || b.e0(this.f2354h, 3, 4, iInterfaceQ))) {
                return false;
            }
            this.f2354h.f2327z = null;
            b bVar = this.f2354h;
            Bundle bundleV = bVar.v();
            if (bVar.f2322u == null) {
                return true;
            }
            this.f2354h.f2322u.g(bundleV);
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
