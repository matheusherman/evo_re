package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class e3 implements Parcelable.Creator<zzdz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdz createFromParcel(Parcel parcel) {
        int iJ = n1.a.J(parcel);
        long jF = 0;
        long jF2 = 0;
        String strP = null;
        String strP2 = null;
        String strP3 = null;
        Bundle bundleF = null;
        String strP4 = null;
        boolean zW = false;
        while (parcel.dataPosition() < iJ) {
            int iC = n1.a.C(parcel);
            switch (n1.a.v(iC)) {
                case 1:
                    jF = n1.a.F(parcel, iC);
                    break;
                case 2:
                    jF2 = n1.a.F(parcel, iC);
                    break;
                case 3:
                    zW = n1.a.w(parcel, iC);
                    break;
                case 4:
                    strP = n1.a.p(parcel, iC);
                    break;
                case 5:
                    strP2 = n1.a.p(parcel, iC);
                    break;
                case 6:
                    strP3 = n1.a.p(parcel, iC);
                    break;
                case 7:
                    bundleF = n1.a.f(parcel, iC);
                    break;
                case 8:
                    strP4 = n1.a.p(parcel, iC);
                    break;
                default:
                    n1.a.I(parcel, iC);
                    break;
            }
        }
        n1.a.u(parcel, iJ);
        return new zzdz(jF, jF2, zW, strP, strP2, strP3, bundleF, strP4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdz[] newArray(int i10) {
        return new zzdz[i10];
    }
}
