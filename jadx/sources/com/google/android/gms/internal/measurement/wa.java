package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class wa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Callable<? extends n>> f3184a = new HashMap();

    public final s a(String str) {
        if (!this.f3184a.containsKey(str)) {
            return s.f3010a0;
        }
        try {
            return this.f3184a.get(str).call();
        } catch (Exception unused) {
            throw new IllegalStateException("Failed to create API implementation: " + str);
        }
    }

    public final void b(String str, Callable<? extends n> callable) {
        this.f3184a.put(str, callable);
    }
}
