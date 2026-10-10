package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class fa implements lb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final fa f2693a = new fa();

    public static fa c() {
        return f2693a;
    }

    @Override // com.google.android.gms.internal.measurement.lb
    public final mb a(Class<?> cls) {
        if (!ea.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (mb) ea.p(cls.asSubclass(ea.class)).s(ea.e.f2636c, null, null);
        } catch (Exception e10) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.lb
    public final boolean b(Class<?> cls) {
        return ea.class.isAssignableFrom(cls);
    }

    private fa() {
    }
}
