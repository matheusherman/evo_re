package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.signin.internal.zag;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zag[i10];
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iJ = n1.a.J(parcel);
        ArrayList<String> arrayListR = null;
        String strP = null;
        while (parcel.dataPosition() < iJ) {
            int iC = n1.a.C(parcel);
            int iV = n1.a.v(iC);
            if (iV != 1) {
                if (iV != 2) {
                    n1.a.I(parcel, iC);
                } else {
                    strP = n1.a.p(parcel, iC);
                }
            } else {
                arrayListR = n1.a.r(parcel, iC);
            }
        }
        n1.a.u(parcel, iJ);
        return new zag(arrayListR, strP);
    }
}
