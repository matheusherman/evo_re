package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class u implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzs[i10];
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iJ = n1.a.J(parcel);
        boolean zW = false;
        String strP = null;
        IBinder iBinderD = null;
        boolean zW2 = false;
        while (parcel.dataPosition() < iJ) {
            int iC = n1.a.C(parcel);
            int iV = n1.a.v(iC);
            if (iV != 1) {
                if (iV != 2) {
                    if (iV != 3) {
                        if (iV != 4) {
                            n1.a.I(parcel, iC);
                        } else {
                            zW2 = n1.a.w(parcel, iC);
                        }
                    } else {
                        zW = n1.a.w(parcel, iC);
                    }
                } else {
                    iBinderD = n1.a.D(parcel, iC);
                }
            } else {
                strP = n1.a.p(parcel, iC);
            }
        }
        n1.a.u(parcel, iJ);
        return new zzs(strP, iBinderD, zW, zW2);
    }
}
