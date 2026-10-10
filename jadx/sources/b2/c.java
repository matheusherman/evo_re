package b2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzbi;
import com.google.android.gms.measurement.internal.zzbj;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class c implements Parcelable.Creator<zzbj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbj[] newArray(int i10) {
        return new zzbj[i10];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbj createFromParcel(Parcel parcel) {
        int iJ = n1.a.J(parcel);
        String strP = null;
        zzbi zzbiVar = null;
        String strP2 = null;
        long jF = 0;
        while (parcel.dataPosition() < iJ) {
            int iC = n1.a.C(parcel);
            int iV = n1.a.v(iC);
            if (iV != 2) {
                if (iV != 3) {
                    if (iV != 4) {
                        if (iV != 5) {
                            n1.a.I(parcel, iC);
                        } else {
                            jF = n1.a.F(parcel, iC);
                        }
                    } else {
                        strP2 = n1.a.p(parcel, iC);
                    }
                } else {
                    zzbiVar = (zzbi) n1.a.o(parcel, iC, zzbi.CREATOR);
                }
            } else {
                strP = n1.a.p(parcel, iC);
            }
        }
        n1.a.u(parcel, iJ);
        return new zzbj(strP, zzbiVar, strP2, jF);
    }
}
