package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class ac implements Parcelable.Creator<zzpb> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzpb[] newArray(int i10) {
        return new zzpb[i10];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzpb createFromParcel(Parcel parcel) {
        int iJ = n1.a.J(parcel);
        ArrayList<Integer> arrayListK = null;
        while (parcel.dataPosition() < iJ) {
            int iC = n1.a.C(parcel);
            if (n1.a.v(iC) != 1) {
                n1.a.I(parcel, iC);
            } else {
                arrayListK = n1.a.k(parcel, iC);
            }
        }
        n1.a.u(parcel, iJ);
        return new zzpb(arrayListK);
    }
}
