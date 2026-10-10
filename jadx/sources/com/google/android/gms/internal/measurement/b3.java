package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class b3 extends x0 implements z2 {
    b3(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.z2
    public final void J(String str, String str2, Bundle bundle, long j10) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        parcelA.writeString(str2);
        z0.d(parcelA, bundle);
        parcelA.writeLong(j10);
        g(1, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.z2
    public final int b() {
        Parcel parcelF = f(2, a());
        int i10 = parcelF.readInt();
        parcelF.recycle();
        return i10;
    }
}
