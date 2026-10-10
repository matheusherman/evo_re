package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class ff implements cf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final s7<Boolean> f2696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final s7<Long> f2697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final s7<Double> f2698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final s7<Long> f2699d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final s7<Long> f2700e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final s7<String> f2701f;

    static {
        b8 b8VarE = new b8(t7.a("com.google.android.gms.measurement")).f().e();
        f2696a = b8VarE.d("measurement.test.boolean_flag", false);
        f2697b = b8VarE.b("measurement.test.cached_long_flag", -1L);
        f2698c = b8VarE.a("measurement.test.double_flag", -3.0d);
        f2699d = b8VarE.b("measurement.test.int_flag", -2L);
        f2700e = b8VarE.b("measurement.test.long_flag", -1L);
        f2701f = b8VarE.c("measurement.test.string_flag", "---");
    }

    @Override // com.google.android.gms.internal.measurement.cf
    public final double b() {
        return f2698c.f().doubleValue();
    }

    @Override // com.google.android.gms.internal.measurement.cf
    public final long c() {
        return f2697b.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.cf
    public final long d() {
        return f2699d.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.cf
    public final long e() {
        return f2700e.f().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.cf
    public final boolean f() {
        return f2696a.f().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.cf
    public final String g() {
        return f2701f.f();
    }
}
