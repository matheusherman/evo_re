package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
abstract class p extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final WeakReference f2402c = new WeakReference(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference f2403b;

    @Override // com.google.android.gms.common.n
    final byte[] W() {
        byte[] bArrX;
        synchronized (this) {
            try {
                bArrX = (byte[]) this.f2403b.get();
                if (bArrX == null) {
                    bArrX = X();
                    this.f2403b = new WeakReference(bArrX);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrX;
    }

    protected abstract byte[] X();

    p(byte[] bArr) {
        super(bArr);
        this.f2403b = f2402c;
    }
}
