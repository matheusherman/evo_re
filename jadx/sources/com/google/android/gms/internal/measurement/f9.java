package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class f9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m9 f2691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f2692b;

    /* synthetic */ f9(int i10, j9 j9Var) {
        this(i10);
    }

    private f9(int i10) {
        byte[] bArr = new byte[i10];
        this.f2692b = bArr;
        this.f2691a = m9.H(bArr);
    }

    public final v8 a() {
        this.f2691a.I();
        return new h9(this.f2692b);
    }

    public final m9 b() {
        return this.f2691a;
    }
}
