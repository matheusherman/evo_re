package com.google.android.gms.internal.measurement;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class r6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    @GuardedBy("GservicesDelegateSupplier.class")
    private static q6 f2981a;

    public static synchronized q6 a() {
        try {
            if (f2981a == null) {
                b(new t6());
            }
        } catch (Throwable th) {
            throw th;
        }
        return f2981a;
    }

    private static synchronized void b(q6 q6Var) {
        if (f2981a != null) {
            throw new IllegalStateException("init() already called");
        }
        f2981a = q6Var;
    }
}
