package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zb implements Parcelable.Creator<zzoz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzoz createFromParcel(Parcel parcel) {
        int iJ = n1.a.J(parcel);
        long jF = 0;
        long jF2 = 0;
        byte[] bArrG = null;
        String strP = null;
        Bundle bundleF = null;
        String strP2 = null;
        int iE = 0;
        while (parcel.dataPosition() < iJ) {
            int iC = n1.a.C(parcel);
            switch (n1.a.v(iC)) {
                case 1:
                    jF = n1.a.F(parcel, iC);
                    break;
                case 2:
                    bArrG = n1.a.g(parcel, iC);
                    break;
                case 3:
                    strP = n1.a.p(parcel, iC);
                    break;
                case 4:
                    bundleF = n1.a.f(parcel, iC);
                    break;
                case 5:
                    iE = n1.a.E(parcel, iC);
                    break;
                case 6:
                    jF2 = n1.a.F(parcel, iC);
                    break;
                case 7:
                    strP2 = n1.a.p(parcel, iC);
                    break;
                default:
                    n1.a.I(parcel, iC);
                    break;
            }
        }
        n1.a.u(parcel, iJ);
        return new zzoz(jF, bArrG, strP, bundleF, iE, jF2, strP2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzoz[] newArray(int i10) {
        return new zzoz[i10];
    }
}
