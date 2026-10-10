package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class i8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f2772a;

    public final boolean a(String str) {
        com.google.common.base.m.j(str, "flagName must not be null");
        if (this.f2772a) {
            return k8.f2806a.get().b(str);
        }
        return true;
    }

    public i8(h8 h8Var) {
        com.google.common.base.m.j(h8Var, "BuildInfo must be non-null");
        this.f2772a = !h8Var.b();
    }
}
