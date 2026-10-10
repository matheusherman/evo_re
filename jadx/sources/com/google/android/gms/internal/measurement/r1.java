package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r1 f2976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final r1 f2977b;

    public abstract g1 a();

    public abstract f1 b();

    public abstract t1 c();

    public abstract s1 d();

    public abstract String e();

    public abstract boolean f();

    static {
        q1 q1VarB = new h1().e("").c(false).b(t1.ALL_CHECKS);
        s1 s1Var = s1.READ_AND_WRITE;
        f2976a = q1VarB.a(s1Var).d();
        f2977b = new h1().e("").c(false).b(t1.NO_CHECKS).a(s1Var).d();
        new h1().e("").c(false).b(t1.SKIP_COMPLIANCE_CHECK).a(s1Var).d();
    }
}
