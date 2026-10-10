package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new GoogleSignInOptions[i10];
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iJ = n1.a.J(parcel);
        ArrayList arrayListT = null;
        Account account = null;
        String strP = null;
        String strP2 = null;
        ArrayList arrayListT2 = null;
        String strP3 = null;
        int iE = 0;
        boolean zW = false;
        boolean zW2 = false;
        boolean zW3 = false;
        while (parcel.dataPosition() < iJ) {
            int iC = n1.a.C(parcel);
            switch (n1.a.v(iC)) {
                case 1:
                    iE = n1.a.E(parcel, iC);
                    break;
                case 2:
                    arrayListT = n1.a.t(parcel, iC, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) n1.a.o(parcel, iC, Account.CREATOR);
                    break;
                case 4:
                    zW = n1.a.w(parcel, iC);
                    break;
                case 5:
                    zW2 = n1.a.w(parcel, iC);
                    break;
                case 6:
                    zW3 = n1.a.w(parcel, iC);
                    break;
                case 7:
                    strP = n1.a.p(parcel, iC);
                    break;
                case 8:
                    strP2 = n1.a.p(parcel, iC);
                    break;
                case 9:
                    arrayListT2 = n1.a.t(parcel, iC, GoogleSignInOptionsExtensionParcelable.CREATOR);
                    break;
                case 10:
                    strP3 = n1.a.p(parcel, iC);
                    break;
                default:
                    n1.a.I(parcel, iC);
                    break;
            }
        }
        n1.a.u(parcel, iJ);
        return new GoogleSignInOptions(iE, arrayListT, account, zW, zW2, zW3, strP, strP2, arrayListT2, strP3);
    }
}
