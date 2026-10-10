package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class v3 extends f3.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ String f3161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f3162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ boolean f3163g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ q2 f3164h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ f3 f3165i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    v3(f3 f3Var, String str, String str2, boolean z10, q2 q2Var) {
        super(f3Var);
        this.f3161e = str;
        this.f3162f = str2;
        this.f3163g = z10;
        this.f3164h = q2Var;
        this.f3165i = f3Var;
    }

    @Override // com.google.android.gms.internal.measurement.f3.a
    final void a() {
        ((p2) m1.g.k(this.f3165i.f2679i)).getUserProperties(this.f3161e, this.f3162f, this.f3163g, this.f3164h);
    }

    @Override // com.google.android.gms.internal.measurement.f3.a
    protected final void b() {
        this.f3164h.m(null);
    }
}
