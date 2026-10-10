package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class s implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzo[i10];
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iJ = n1.a.J(parcel);
        String strP = null;
        IBinder iBinderD = null;
        boolean zW = false;
        boolean zW2 = false;
        boolean zW3 = false;
        boolean zW4 = false;
        while (parcel.dataPosition() < iJ) {
            int iC = n1.a.C(parcel);
            switch (n1.a.v(iC)) {
                case 1:
                    strP = n1.a.p(parcel, iC);
                    break;
                case 2:
                    zW = n1.a.w(parcel, iC);
                    break;
                case 3:
                    zW2 = n1.a.w(parcel, iC);
                    break;
                case 4:
                    iBinderD = n1.a.D(parcel, iC);
                    break;
                case 5:
                    zW3 = n1.a.w(parcel, iC);
                    break;
                case 6:
                    zW4 = n1.a.w(parcel, iC);
                    break;
                default:
                    n1.a.I(parcel, iC);
                    break;
            }
        }
        n1.a.u(parcel, iJ);
        return new zzo(strP, zW, zW2, iBinderD, zW3, zW4);
    }
}
