package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
abstract class m extends q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final Bundle f2342e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ b f2343f;

    protected abstract void f(ConnectionResult connectionResult);

    protected abstract boolean g();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @BinderThread
    protected m(b bVar, @Nullable int i10, Bundle bundle) {
        super(bVar, Boolean.TRUE);
        this.f2343f = bVar;
        this.f2341d = i10;
        this.f2342e = bundle;
    }

    @Override // com.google.android.gms.common.internal.q
    protected final /* bridge */ /* synthetic */ void a(Object obj) {
        if (this.f2341d != 0) {
            this.f2343f.g0(1, null);
            Bundle bundle = this.f2342e;
            f(new ConnectionResult(this.f2341d, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        } else {
            if (g()) {
                return;
            }
            this.f2343f.g0(1, null);
            f(new ConnectionResult(8, null));
        }
    }

    @Override // com.google.android.gms.common.internal.q
    protected final void b() {
    }
}
