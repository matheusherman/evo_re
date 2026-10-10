package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.server.converter.zaa;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new FastJsonResponse.Field[i10];
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iJ = n1.a.J(parcel);
        String strP = null;
        String strP2 = null;
        zaa zaaVar = null;
        int iE = 0;
        int iE2 = 0;
        boolean zW = false;
        int iE3 = 0;
        boolean zW2 = false;
        int iE4 = 0;
        while (parcel.dataPosition() < iJ) {
            int iC = n1.a.C(parcel);
            switch (n1.a.v(iC)) {
                case 1:
                    iE = n1.a.E(parcel, iC);
                    break;
                case 2:
                    iE2 = n1.a.E(parcel, iC);
                    break;
                case 3:
                    zW = n1.a.w(parcel, iC);
                    break;
                case 4:
                    iE3 = n1.a.E(parcel, iC);
                    break;
                case 5:
                    zW2 = n1.a.w(parcel, iC);
                    break;
                case 6:
                    strP = n1.a.p(parcel, iC);
                    break;
                case 7:
                    iE4 = n1.a.E(parcel, iC);
                    break;
                case 8:
                    strP2 = n1.a.p(parcel, iC);
                    break;
                case 9:
                    zaaVar = (zaa) n1.a.o(parcel, iC, zaa.CREATOR);
                    break;
                default:
                    n1.a.I(parcel, iC);
                    break;
            }
        }
        n1.a.u(parcel, iJ);
        return new FastJsonResponse.Field(iE, iE2, zW, iE3, zW2, strP, iE4, strP2, zaaVar);
    }
}
