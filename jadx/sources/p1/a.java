package p1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new ModuleAvailabilityResponse[i10];
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iJ = n1.a.J(parcel);
        boolean zW = false;
        int iE = 0;
        while (parcel.dataPosition() < iJ) {
            int iC = n1.a.C(parcel);
            int iV = n1.a.v(iC);
            if (iV != 1) {
                if (iV != 2) {
                    n1.a.I(parcel, iC);
                } else {
                    iE = n1.a.E(parcel, iC);
                }
            } else {
                zW = n1.a.w(parcel, iC);
            }
        }
        n1.a.u(parcel, iJ);
        return new ModuleAvailabilityResponse(zW, iE);
    }
}
