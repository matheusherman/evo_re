package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class a9 extends h9 {
    private final int zzc;
    private final int zzd;

    @Override // com.google.android.gms.internal.measurement.h9, com.google.android.gms.internal.measurement.v8
    final byte q(int i10) {
        return this.zzb[this.zzc + i10];
    }

    @Override // com.google.android.gms.internal.measurement.h9, com.google.android.gms.internal.measurement.v8
    public final int r() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.h9
    protected final int v() {
        return this.zzc;
    }

    a9(byte[] bArr, int i10, int i11) {
        super(bArr);
        v8.h(i10, i10 + i11, bArr.length);
        this.zzc = i10;
        this.zzd = i11;
    }

    @Override // com.google.android.gms.internal.measurement.h9, com.google.android.gms.internal.measurement.v8
    public final byte e(int i10) {
        int iR = r();
        if (((iR - (i10 + 1)) | i10) < 0) {
            if (i10 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i10);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i10 + ", " + iR);
        }
        return this.zzb[this.zzc + i10];
    }
}
