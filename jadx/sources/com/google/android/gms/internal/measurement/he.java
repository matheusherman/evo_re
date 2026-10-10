package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class he implements ie {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final s7<Boolean> f2755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final s7<Boolean> f2756b;

    @Override // com.google.android.gms.internal.measurement.ie
    public final boolean b() {
        return true;
    }

    static {
        b8 b8VarE = new b8(t7.a("com.google.android.gms.measurement")).f().e();
        b8VarE.d("measurement.collection.event_safelist", true);
        f2755a = b8VarE.d("measurement.service.store_null_safelist", true);
        f2756b = b8VarE.d("measurement.service.store_safelist", true);
    }

    @Override // com.google.android.gms.internal.measurement.ie
    public final boolean c() {
        return f2755a.f().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.ie
    public final boolean d() {
        return f2756b.f().booleanValue();
    }
}
