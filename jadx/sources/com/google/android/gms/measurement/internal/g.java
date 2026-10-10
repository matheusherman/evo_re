package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class g implements Parcelable.Creator<zzai> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzai createFromParcel(Parcel parcel) {
        int iJ = n1.a.J(parcel);
        String strP = null;
        String strP2 = null;
        zzpy zzpyVar = null;
        String strP3 = null;
        zzbj zzbjVar = null;
        zzbj zzbjVar2 = null;
        zzbj zzbjVar3 = null;
        long jF = 0;
        long jF2 = 0;
        long jF3 = 0;
        boolean zW = false;
        while (parcel.dataPosition() < iJ) {
            int iC = n1.a.C(parcel);
            switch (n1.a.v(iC)) {
                case 2:
                    strP = n1.a.p(parcel, iC);
                    break;
                case 3:
                    strP2 = n1.a.p(parcel, iC);
                    break;
                case 4:
                    zzpyVar = (zzpy) n1.a.o(parcel, iC, zzpy.CREATOR);
                    break;
                case 5:
                    jF = n1.a.F(parcel, iC);
                    break;
                case 6:
                    zW = n1.a.w(parcel, iC);
                    break;
                case 7:
                    strP3 = n1.a.p(parcel, iC);
                    break;
                case 8:
                    zzbjVar = (zzbj) n1.a.o(parcel, iC, zzbj.CREATOR);
                    break;
                case 9:
                    jF2 = n1.a.F(parcel, iC);
                    break;
                case 10:
                    zzbjVar2 = (zzbj) n1.a.o(parcel, iC, zzbj.CREATOR);
                    break;
                case 11:
                    jF3 = n1.a.F(parcel, iC);
                    break;
                case 12:
                    zzbjVar3 = (zzbj) n1.a.o(parcel, iC, zzbj.CREATOR);
                    break;
                default:
                    n1.a.I(parcel, iC);
                    break;
            }
        }
        n1.a.u(parcel, iJ);
        return new zzai(strP, strP2, zzpyVar, jF, zW, strP3, zzbjVar, jF2, zzbjVar2, jF3, zzbjVar3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzai[] newArray(int i10) {
        return new zzai[i10];
    }
}
