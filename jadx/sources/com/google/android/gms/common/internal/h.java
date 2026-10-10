package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class h extends x1.a implements IInterface {
    h(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    public final u1.a X(u1.a aVar, zax zaxVar) {
        Parcel parcelA = a();
        x1.c.d(parcelA, aVar);
        x1.c.c(parcelA, zaxVar);
        Parcel parcelF = f(2, parcelA);
        u1.a aVarF = u1.a.AbstractBinderC0368a.f(parcelF.readStrongBinder());
        parcelF.recycle();
        return aVarF;
    }
}
