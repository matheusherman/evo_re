package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.stub.StubApp;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@VisibleForTesting
public final class qc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f3955a;

    @VisibleForTesting
    public qc(Context context) {
        m1.g.k(context);
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        m1.g.k(origApplicationContext);
        this.f3955a = origApplicationContext;
    }
}
