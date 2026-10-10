package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@VisibleForTesting
public final class r extends m1.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private b f2349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2350b;

    @Override // m1.d
    @BinderThread
    public final void G(int i10, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
        m1.g.l(this.f2349a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f2349a.L(i10, iBinder, bundle, this.f2350b);
        this.f2349a = null;
    }

    @Override // m1.d
    @BinderThread
    public final void S(int i10, @NonNull IBinder iBinder, @NonNull zzk zzkVar) {
        b bVar = this.f2349a;
        m1.g.l(bVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        m1.g.k(zzkVar);
        b.a0(bVar, zzkVar);
        G(i10, iBinder, zzkVar.f2378a);
    }

    @Override // m1.d
    @BinderThread
    public final void x(int i10, @Nullable Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    public r(@NonNull b bVar, int i10) {
        this.f2349a = bVar;
        this.f2350b = i10;
    }
}
