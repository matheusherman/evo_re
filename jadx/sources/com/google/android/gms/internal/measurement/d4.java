package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class d4 extends f3.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ Bundle f2602e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Activity f2603f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ f3.b f2604g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    d4(f3.b bVar, Bundle bundle, Activity activity) {
        super(f3.this);
        this.f2602e = bundle;
        this.f2603f = activity;
        this.f2604g = bVar;
    }

    @Override // com.google.android.gms.internal.measurement.f3.a
    final void a() {
        Bundle bundle;
        if (this.f2602e != null) {
            bundle = new Bundle();
            if (this.f2602e.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = this.f2602e.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        ((p2) m1.g.k(f3.this.f2679i)).onActivityCreatedByScionActivityInfo(zzeb.J(this.f2603f), bundle, this.f2681b);
    }
}
