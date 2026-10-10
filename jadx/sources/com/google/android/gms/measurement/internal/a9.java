package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class a9 implements vc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ z7 f3397a;

    a9(z7 z7Var) {
        this.f3397a = z7Var;
    }

    @Override // com.google.android.gms.measurement.internal.vc
    public final void o(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.f3397a.p0("auto", str2, bundle, str);
        } else {
            this.f3397a.b1("auto", str2, bundle);
        }
    }
}
