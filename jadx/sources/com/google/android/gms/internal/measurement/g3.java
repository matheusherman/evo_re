package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class g3 implements Parcelable.Creator<zzeb> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzeb[] newArray(int i10) {
        return new zzeb[i10];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzeb createFromParcel(Parcel parcel) {
        int iJ = n1.a.J(parcel);
        int iE = 0;
        String strP = null;
        Intent intent = null;
        while (parcel.dataPosition() < iJ) {
            int iC = n1.a.C(parcel);
            int iV = n1.a.v(iC);
            if (iV != 1) {
                if (iV != 2) {
                    if (iV != 3) {
                        n1.a.I(parcel, iC);
                    } else {
                        intent = (Intent) n1.a.o(parcel, iC, Intent.CREATOR);
                    }
                } else {
                    strP = n1.a.p(parcel, iC);
                }
            } else {
                iE = n1.a.E(parcel, iC);
            }
        }
        n1.a.u(parcel, iJ);
        return new zzeb(iE, strP, intent);
    }
}
