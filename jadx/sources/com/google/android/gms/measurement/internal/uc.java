package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class uc implements Parcelable.Creator<zzpy> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzpy createFromParcel(Parcel parcel) {
        int iJ = n1.a.J(parcel);
        String strP = null;
        Long lG = null;
        Float fB = null;
        String strP2 = null;
        String strP3 = null;
        Double dZ = null;
        long jF = 0;
        int iE = 0;
        while (parcel.dataPosition() < iJ) {
            int iC = n1.a.C(parcel);
            switch (n1.a.v(iC)) {
                case 1:
                    iE = n1.a.E(parcel, iC);
                    break;
                case 2:
                    strP = n1.a.p(parcel, iC);
                    break;
                case 3:
                    jF = n1.a.F(parcel, iC);
                    break;
                case 4:
                    lG = n1.a.G(parcel, iC);
                    break;
                case 5:
                    fB = n1.a.B(parcel, iC);
                    break;
                case 6:
                    strP2 = n1.a.p(parcel, iC);
                    break;
                case 7:
                    strP3 = n1.a.p(parcel, iC);
                    break;
                case 8:
                    dZ = n1.a.z(parcel, iC);
                    break;
                default:
                    n1.a.I(parcel, iC);
                    break;
            }
        }
        n1.a.u(parcel, iJ);
        return new zzpy(iE, strP, jF, lG, fB, strP2, strP3, dZ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzpy[] newArray(int i10) {
        return new zzpy[i10];
    }
}
