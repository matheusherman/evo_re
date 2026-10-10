package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class af implements bf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final s7<Boolean> f2545a;

    static {
        b8 b8VarE = new b8(t7.a("com.google.android.gms.measurement")).f().e();
        b8VarE.d("measurement.sdk.collection.enable_extend_user_property_size", true);
        f2545a = b8VarE.d("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        b8VarE.b("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.bf
    public final boolean b() {
        return f2545a.f().booleanValue();
    }
}
