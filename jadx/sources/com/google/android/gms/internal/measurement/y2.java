package com.google.android.gms.internal.measurement;

import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class y2 extends a1 implements v2 {
    @Override // com.google.android.gms.internal.measurement.a1
    protected final boolean a(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 != 2) {
            return false;
        }
        O();
        return true;
    }

    public y2() {
        super("com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
    }
}
