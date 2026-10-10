package com.google.android.gms.measurement.internal;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class dc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, String> f3496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b2.c1 f3497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.gms.internal.measurement.x5 f3498d;

    dc(String str, b2.c1 c1Var) {
        this(str, Collections.EMPTY_MAP, c1Var, null);
    }

    dc(String str, Map<String, String> map, b2.c1 c1Var) {
        this(str, map, c1Var, null);
    }

    public final b2.c1 a() {
        return this.f3497c;
    }

    public final com.google.android.gms.internal.measurement.x5 b() {
        return this.f3498d;
    }

    public final String c() {
        return this.f3495a;
    }

    public final Map<String, String> d() {
        Map<String, String> map = this.f3496b;
        return map == null ? Collections.EMPTY_MAP : map;
    }

    dc(String str, Map<String, String> map, b2.c1 c1Var, com.google.android.gms.internal.measurement.x5 x5Var) {
        this.f3495a = str;
        this.f3496b = map;
        this.f3497c = c1Var;
        this.f3498d = x5Var;
    }
}
