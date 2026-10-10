package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zat;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zai[i10];
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iJ = n1.a.J(parcel);
        zat zatVar = null;
        int iE = 0;
        while (parcel.dataPosition() < iJ) {
            int iC = n1.a.C(parcel);
            int iV = n1.a.v(iC);
            if (iV != 1) {
                if (iV != 2) {
                    n1.a.I(parcel, iC);
                } else {
                    zatVar = (zat) n1.a.o(parcel, iC, zat.CREATOR);
                }
            } else {
                iE = n1.a.E(parcel, iC);
            }
        }
        n1.a.u(parcel, iJ);
        return new zai(iE, zatVar);
    }
}
