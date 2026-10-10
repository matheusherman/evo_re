package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class rg extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Callable<Object> f3009c;

    @Override // com.google.android.gms.internal.measurement.n
    public final s a(v6 v6Var, List<s> list) {
        try {
            return w8.b(this.f3009c.call());
        } catch (Exception unused) {
            return s.f3010a0;
        }
    }

    public rg(String str, Callable<Object> callable) {
        super(str);
        this.f3009c = callable;
    }
}
