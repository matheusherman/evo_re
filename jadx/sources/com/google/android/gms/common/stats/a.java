package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iJ = n1.a.J(parcel);
        String strP = null;
        ArrayList<String> arrayListR = null;
        String strP2 = null;
        String strP3 = null;
        String strP4 = null;
        String strP5 = null;
        long jF = 0;
        long jF2 = 0;
        long jF3 = 0;
        int iE = 0;
        int iE2 = 0;
        int iE3 = 0;
        int iE4 = 0;
        float fA = 0.0f;
        boolean zW = false;
        while (parcel.dataPosition() < iJ) {
            int iC = n1.a.C(parcel);
            switch (n1.a.v(iC)) {
                case 1:
                    iE = n1.a.E(parcel, iC);
                    break;
                case 2:
                    jF = n1.a.F(parcel, iC);
                    break;
                case 3:
                case 7:
                case 9:
                default:
                    n1.a.I(parcel, iC);
                    break;
                case 4:
                    strP = n1.a.p(parcel, iC);
                    break;
                case 5:
                    iE3 = n1.a.E(parcel, iC);
                    break;
                case 6:
                    arrayListR = n1.a.r(parcel, iC);
                    break;
                case 8:
                    jF2 = n1.a.F(parcel, iC);
                    break;
                case 10:
                    strP3 = n1.a.p(parcel, iC);
                    break;
                case 11:
                    iE2 = n1.a.E(parcel, iC);
                    break;
                case 12:
                    strP2 = n1.a.p(parcel, iC);
                    break;
                case 13:
                    strP4 = n1.a.p(parcel, iC);
                    break;
                case 14:
                    iE4 = n1.a.E(parcel, iC);
                    break;
                case 15:
                    fA = n1.a.A(parcel, iC);
                    break;
                case 16:
                    jF3 = n1.a.F(parcel, iC);
                    break;
                case 17:
                    strP5 = n1.a.p(parcel, iC);
                    break;
                case 18:
                    zW = n1.a.w(parcel, iC);
                    break;
            }
        }
        n1.a.u(parcel, iJ);
        return new WakeLockEvent(iE, jF, iE2, strP, iE3, arrayListR, strP2, jF2, iE4, strP3, strP4, fA, jF3, strP5, zW);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new WakeLockEvent[i10];
    }
}
