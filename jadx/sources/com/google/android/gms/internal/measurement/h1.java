package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class h1 extends q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private t1 f2740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private s1 f2741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte f2742d;

    @Override // com.google.android.gms.internal.measurement.q1
    public final q1 a(s1 s1Var) {
        if (s1Var == null) {
            throw new NullPointerException("Null filePurpose");
        }
        this.f2741c = s1Var;
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.q1
    final q1 b(t1 t1Var) {
        if (t1Var == null) {
            throw new NullPointerException("Null fileChecks");
        }
        this.f2740b = t1Var;
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.q1
    public final q1 c(boolean z10) {
        this.f2742d = (byte) (this.f2742d | 1);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.q1
    public final r1 d() {
        if (this.f2742d == 1 && this.f2739a != null && this.f2740b != null && this.f2741c != null) {
            return new i1(this.f2739a, false, this.f2740b, null, null, this.f2741c, null);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f2739a == null) {
            sb2.append(" fileOwner");
        }
        if ((1 & this.f2742d) == 0) {
            sb2.append(" hasDifferentDmaOwner");
        }
        if (this.f2740b == null) {
            sb2.append(" fileChecks");
        }
        if (this.f2741c == null) {
            sb2.append(" filePurpose");
        }
        throw new IllegalStateException("Missing required properties:" + String.valueOf(sb2));
    }

    public final q1 e(String str) {
        this.f2739a = str;
        return this;
    }

    h1() {
    }
}
