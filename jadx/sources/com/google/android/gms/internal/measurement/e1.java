package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class e1 extends x0 implements c1 {
    e1(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // com.google.android.gms.internal.measurement.c1
    public final Bundle m(Bundle bundle) {
        Parcel parcelA = a();
        z0.d(parcelA, bundle);
        Parcel parcelF = f(1, parcelA);
        Bundle bundle2 = (Bundle) z0.a(parcelF, Bundle.CREATOR);
        parcelF.recycle();
        return bundle2;
    }
}
