package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class n extends y1.a implements IInterface {
    n(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final u1.a W(u1.a aVar, String str, int i10, u1.a aVar2) {
        Parcel parcelF = f();
        y1.e.d(parcelF, aVar);
        parcelF.writeString(str);
        parcelF.writeInt(i10);
        y1.e.d(parcelF, aVar2);
        Parcel parcelA = a(3, parcelF);
        u1.a aVarF = u1.a.AbstractBinderC0368a.f(parcelA.readStrongBinder());
        parcelA.recycle();
        return aVarF;
    }

    public final u1.a g(u1.a aVar, String str, int i10, u1.a aVar2) {
        Parcel parcelF = f();
        y1.e.d(parcelF, aVar);
        parcelF.writeString(str);
        parcelF.writeInt(i10);
        y1.e.d(parcelF, aVar2);
        Parcel parcelA = a(2, parcelF);
        u1.a aVarF = u1.a.AbstractBinderC0368a.f(parcelA.readStrongBinder());
        parcelA.recycle();
        return aVarF;
    }
}
