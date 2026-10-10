package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class l3 extends f3.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzeb f2818e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f2819f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f2820g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ f3 f2821h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    l3(f3 f3Var, zzeb zzebVar, String str, String str2) {
        super(f3Var);
        this.f2818e = zzebVar;
        this.f2819f = str;
        this.f2820g = str2;
        this.f2821h = f3Var;
    }

    @Override // com.google.android.gms.internal.measurement.f3.a
    final void a() {
        ((p2) m1.g.k(this.f2821h.f2679i)).setCurrentScreenByScionActivityInfo(this.f2818e, this.f2819f, this.f2820g, this.f2680a);
    }
}
