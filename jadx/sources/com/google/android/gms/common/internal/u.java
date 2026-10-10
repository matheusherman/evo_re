package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class u extends m {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ b f2355g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @BinderThread
    public u(b bVar, @Nullable int i10, Bundle bundle) {
        super(bVar, i10, bundle);
        this.f2355g = bVar;
    }

    @Override // com.google.android.gms.common.internal.m
    protected final void f(ConnectionResult connectionResult) {
        if (this.f2355g.r() && b.f0(this.f2355g)) {
            b.b0(this.f2355g, 16);
        } else {
            this.f2355g.f2317p.a(connectionResult);
            this.f2355g.J(connectionResult);
        }
    }

    @Override // com.google.android.gms.common.internal.m
    protected final boolean g() {
        this.f2355g.f2317p.a(ConnectionResult.f2120e);
        return true;
    }
}
