package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class t2 extends a1 implements u2 {
    @Override // com.google.android.gms.internal.measurement.a1
    protected final boolean a(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 != 1) {
            return false;
        }
        Bundle bundle = (Bundle) z0.a(parcel, Bundle.CREATOR);
        z0.f(parcel);
        m(bundle);
        parcel2.writeNoException();
        return true;
    }

    public t2() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }
}
