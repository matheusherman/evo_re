package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class l9 extends i9 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f2829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2832f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2833g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f2834h;

    /* synthetic */ l9(byte[] bArr, int i10, int i11, boolean z10, k9 k9Var) {
        this(bArr, 0, i11, false);
    }

    private l9(byte[] bArr, int i10, int i11, boolean z10) {
        super(null);
        this.f2834h = Integer.MAX_VALUE;
        this.f2829c = bArr;
        this.f2830d = i11 + i10;
        this.f2832f = i10;
        this.f2833g = i10;
    }

    private final void f() {
        int i10 = this.f2830d + this.f2831e;
        this.f2830d = i10;
        int i11 = i10 - this.f2833g;
        int i12 = this.f2834h;
        if (i11 <= i12) {
            this.f2831e = 0;
            return;
        }
        int i13 = i11 - i12;
        this.f2831e = i13;
        this.f2830d = i10 - i13;
    }

    @Override // com.google.android.gms.internal.measurement.i9
    public final int d(int i10) throws ma {
        if (i10 < 0) {
            throw ma.d();
        }
        int iE = i10 + e();
        if (iE < 0) {
            throw ma.e();
        }
        int i11 = this.f2834h;
        if (iE > i11) {
            throw ma.g();
        }
        this.f2834h = iE;
        f();
        return i11;
    }

    @Override // com.google.android.gms.internal.measurement.i9
    public final int e() {
        return this.f2832f - this.f2833g;
    }
}
