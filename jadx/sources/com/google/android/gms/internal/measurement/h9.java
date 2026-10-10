package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class h9 extends e9 {
    protected final byte[] zzb;

    h9(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.v8
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v8) || r() != ((v8) obj).r()) {
            return false;
        }
        if (r() == 0) {
            return true;
        }
        if (!(obj instanceof h9)) {
            return obj.equals(this);
        }
        h9 h9Var = (h9) obj;
        int iF = f();
        int iF2 = h9Var.f();
        if (iF == 0 || iF2 == 0 || iF == iF2) {
            return u(h9Var, 0, r());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.v8
    public final v8 i(int i10, int i11) {
        int iH = v8.h(0, i11, r());
        return iH == 0 ? v8.f3170a : new a9(this.zzb, v(), iH);
    }

    protected int v() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.v8
    public byte e(int i10) {
        return this.zzb[i10];
    }

    @Override // com.google.android.gms.internal.measurement.v8
    final void o(x8 x8Var) {
        x8Var.a(this.zzb, v(), r());
    }

    @Override // com.google.android.gms.internal.measurement.v8
    byte q(int i10) {
        return this.zzb[i10];
    }

    @Override // com.google.android.gms.internal.measurement.v8
    public int r() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.measurement.v8
    protected final int s(int i10, int i11, int i12) {
        return ga.a(i10, this.zzb, v(), i12);
    }

    @Override // com.google.android.gms.internal.measurement.e9
    final boolean u(v8 v8Var, int i10, int i11) {
        if (i11 <= v8Var.r()) {
            if (i11 <= v8Var.r()) {
                if (v8Var instanceof h9) {
                    h9 h9Var = (h9) v8Var;
                    byte[] bArr = this.zzb;
                    byte[] bArr2 = h9Var.zzb;
                    int iV = v() + i11;
                    int iV2 = v();
                    int iV3 = h9Var.v();
                    while (iV2 < iV) {
                        if (bArr[iV2] != bArr2[iV3]) {
                            return false;
                        }
                        iV2++;
                        iV3++;
                    }
                    return true;
                }
                return v8Var.i(0, i11).equals(i(0, i11));
            }
            throw new IllegalArgumentException("Ran off end of other: 0, " + i11 + ", " + v8Var.r());
        }
        throw new IllegalArgumentException("Length too large: " + i11 + r());
    }
}
