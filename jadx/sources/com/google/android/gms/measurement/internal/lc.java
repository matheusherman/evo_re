package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class lc implements vc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ gc f3790a;

    lc(gc gcVar) {
        this.f3790a = gcVar;
    }

    @Override // com.google.android.gms.measurement.internal.vc
    public final void o(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            if (this.f3790a.f3643l != null) {
                this.f3790a.f3643l.l().H().b("AppId not known when logging event", str2);
                return;
            }
            return;
        }
        this.f3790a.a().E(new oc(this, str, str2, bundle));
    }
}
