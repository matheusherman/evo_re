package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class xb implements Parcelable.Creator<zzq> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzq createFromParcel(Parcel parcel) {
        int iJ = n1.a.J(parcel);
        String strP = null;
        String strP2 = null;
        String strP3 = null;
        String strP4 = null;
        String strP5 = null;
        String strP6 = null;
        String strP7 = null;
        Boolean boolX = null;
        ArrayList<String> arrayListR = null;
        String strP8 = null;
        String strP9 = null;
        String strP10 = null;
        long jF = 0;
        long jF2 = 0;
        long jF3 = 0;
        long jF4 = 0;
        long jF5 = 0;
        long jF6 = 0;
        long jF7 = 0;
        long jF8 = -2147483648L;
        String strP11 = "";
        String strP12 = strP11;
        String strP13 = strP12;
        String strP14 = strP13;
        boolean zW = true;
        boolean zW2 = false;
        int iE = 0;
        boolean zW3 = true;
        boolean zW4 = false;
        boolean zW5 = false;
        int iE2 = 100;
        int iE3 = 0;
        int iE4 = 0;
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
                    strP3 = n1.a.p(parcel, iC);
                    break;
                case 5:
                    strP4 = n1.a.p(parcel, iC);
                    break;
                case 6:
                    jF = n1.a.F(parcel, iC);
                    break;
                case 7:
                    jF2 = n1.a.F(parcel, iC);
                    break;
                case 8:
                    strP5 = n1.a.p(parcel, iC);
                    break;
                case 9:
                    zW = n1.a.w(parcel, iC);
                    break;
                case 10:
                    zW2 = n1.a.w(parcel, iC);
                    break;
                case 11:
                    jF8 = n1.a.F(parcel, iC);
                    break;
                case 12:
                    strP6 = n1.a.p(parcel, iC);
                    break;
                case 13:
                case 17:
                case 20:
                case 33:
                default:
                    n1.a.I(parcel, iC);
                    break;
                case 14:
                    jF3 = n1.a.F(parcel, iC);
                    break;
                case 15:
                    iE = n1.a.E(parcel, iC);
                    break;
                case 16:
                    zW3 = n1.a.w(parcel, iC);
                    break;
                case 18:
                    zW4 = n1.a.w(parcel, iC);
                    break;
                case 19:
                    strP7 = n1.a.p(parcel, iC);
                    break;
                case 21:
                    boolX = n1.a.x(parcel, iC);
                    break;
                case 22:
                    jF4 = n1.a.F(parcel, iC);
                    break;
                case 23:
                    arrayListR = n1.a.r(parcel, iC);
                    break;
                case 24:
                    strP8 = n1.a.p(parcel, iC);
                    break;
                case 25:
                    strP11 = n1.a.p(parcel, iC);
                    break;
                case 26:
                    strP12 = n1.a.p(parcel, iC);
                    break;
                case 27:
                    strP9 = n1.a.p(parcel, iC);
                    break;
                case 28:
                    zW5 = n1.a.w(parcel, iC);
                    break;
                case 29:
                    jF5 = n1.a.F(parcel, iC);
                    break;
                case 30:
                    iE2 = n1.a.E(parcel, iC);
                    break;
                case 31:
                    strP13 = n1.a.p(parcel, iC);
                    break;
                case 32:
                    iE3 = n1.a.E(parcel, iC);
                    break;
                case 34:
                    jF6 = n1.a.F(parcel, iC);
                    break;
                case 35:
                    strP10 = n1.a.p(parcel, iC);
                    break;
                case 36:
                    strP14 = n1.a.p(parcel, iC);
                    break;
                case 37:
                    jF7 = n1.a.F(parcel, iC);
                    break;
                case 38:
                    iE4 = n1.a.E(parcel, iC);
                    break;
            }
        }
        n1.a.u(parcel, iJ);
        return new zzq(strP, strP2, strP3, strP4, jF, jF2, strP5, zW, zW2, jF8, strP6, jF3, iE, zW3, zW4, strP7, boolX, jF4, arrayListR, strP8, strP11, strP12, strP9, zW5, jF5, iE2, strP13, iE3, jF6, strP10, strP14, jF7, iE4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzq[] newArray(int i10) {
        return new zzq[i10];
    }
}
