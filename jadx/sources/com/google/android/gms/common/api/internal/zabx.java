package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.Nullable;
import k1.f0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zabx extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    Context f2197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f0 f2198b;

    public final synchronized void b() {
        try {
            Context context = this.f2197a;
            if (context != null) {
                context.unregisterReceiver(this);
            }
            this.f2197a = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void a(Context context) {
        this.f2197a = context;
    }

    public zabx(f0 f0Var) {
        this.f2198b = f0Var;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String schemeSpecificPart;
        Uri data = intent.getData();
        if (data != null) {
            schemeSpecificPart = data.getSchemeSpecificPart();
        } else {
            schemeSpecificPart = null;
        }
        if ("com.google.android.gms".equals(schemeSpecificPart)) {
            this.f2198b.a();
            b();
        }
    }
}
