package com.google.android.gms.common;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class o extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f2401b;

    o(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f2401b = bArr;
    }

    @Override // com.google.android.gms.common.n
    final byte[] W() {
        return this.f2401b;
    }
}
