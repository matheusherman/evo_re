package com.google.android.gms.common.util;

import android.os.SystemClock;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class g implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final g f2466a = new g();

    @NonNull
    public static d d() {
        return f2466a;
    }

    private g() {
    }

    @Override // com.google.android.gms.common.util.d
    public final long a() {
        return System.currentTimeMillis();
    }

    @Override // com.google.android.gms.common.util.d
    public final long b() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.gms.common.util.d
    public final long c() {
        return System.nanoTime();
    }
}
