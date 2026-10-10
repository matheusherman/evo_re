package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iJ = n1.a.J(parcel);
        String strP = null;
        String strP2 = null;
        String strP3 = null;
        String strP4 = null;
        Uri uri = null;
        String strP5 = null;
        String strP6 = null;
        ArrayList arrayListT = null;
        String strP7 = null;
        String strP8 = null;
        long jF = 0;
        int iE = 0;
        while (parcel.dataPosition() < iJ) {
            int iC = n1.a.C(parcel);
            switch (n1.a.v(iC)) {
                case 1:
                    iE = n1.a.E(parcel, iC);
                    break;
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
                    uri = (Uri) n1.a.o(parcel, iC, Uri.CREATOR);
                    break;
                case 7:
                    strP5 = n1.a.p(parcel, iC);
                    break;
                case 8:
                    jF = n1.a.F(parcel, iC);
                    break;
                case 9:
                    strP6 = n1.a.p(parcel, iC);
                    break;
                case 10:
                    arrayListT = n1.a.t(parcel, iC, Scope.CREATOR);
                    break;
                case 11:
                    strP7 = n1.a.p(parcel, iC);
                    break;
                case 12:
                    strP8 = n1.a.p(parcel, iC);
                    break;
                default:
                    n1.a.I(parcel, iC);
                    break;
            }
        }
        n1.a.u(parcel, iJ);
        return new GoogleSignInAccount(iE, strP, strP2, strP3, strP4, uri, strP5, jF, strP6, arrayListT, strP7, strP8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new GoogleSignInAccount[i10];
    }
}
