package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class x implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iJ = n1.a.J(parcel);
        Scope[] scopeArr = GetServiceRequest.f2262o;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.f2263p;
        Feature[] featureArr2 = featureArr;
        String strP = null;
        IBinder iBinderD = null;
        Account account = null;
        String strP2 = null;
        int iE = 0;
        int iE2 = 0;
        int iE3 = 0;
        boolean zW = false;
        int iE4 = 0;
        boolean zW2 = false;
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
                    iE3 = n1.a.E(parcel, iC);
                    break;
                case 4:
                    strP = n1.a.p(parcel, iC);
                    break;
                case 5:
                    iBinderD = n1.a.D(parcel, iC);
                    break;
                case 6:
                    scopeArr = (Scope[]) n1.a.s(parcel, iC, Scope.CREATOR);
                    break;
                case 7:
                    bundle = n1.a.f(parcel, iC);
                    break;
                case 8:
                    account = (Account) n1.a.o(parcel, iC, Account.CREATOR);
                    break;
                case 9:
                default:
                    n1.a.I(parcel, iC);
                    break;
                case 10:
                    featureArr = (Feature[]) n1.a.s(parcel, iC, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) n1.a.s(parcel, iC, Feature.CREATOR);
                    break;
                case 12:
                    zW = n1.a.w(parcel, iC);
                    break;
                case 13:
                    iE4 = n1.a.E(parcel, iC);
                    break;
                case 14:
                    zW2 = n1.a.w(parcel, iC);
                    break;
                case 15:
                    strP2 = n1.a.p(parcel, iC);
                    break;
            }
        }
        n1.a.u(parcel, iJ);
        return new GetServiceRequest(iE, iE2, iE3, strP, iBinderD, scopeArr, bundle, account, featureArr, featureArr2, zW, iE4, zW2, strP2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new GetServiceRequest[i10];
    }

    static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, getServiceRequest.f2264a);
        n1.b.k(parcel, 2, getServiceRequest.f2265b);
        n1.b.k(parcel, 3, getServiceRequest.f2266c);
        n1.b.r(parcel, 4, getServiceRequest.f2267d, false);
        n1.b.j(parcel, 5, getServiceRequest.f2268e, false);
        n1.b.u(parcel, 6, getServiceRequest.f2269f, i10, false);
        n1.b.e(parcel, 7, getServiceRequest.f2270g, false);
        n1.b.q(parcel, 8, getServiceRequest.f2271h, i10, false);
        n1.b.u(parcel, 10, getServiceRequest.f2272i, i10, false);
        n1.b.u(parcel, 11, getServiceRequest.f2273j, i10, false);
        n1.b.c(parcel, 12, getServiceRequest.f2274k);
        n1.b.k(parcel, 13, getServiceRequest.f2275l);
        n1.b.c(parcel, 14, getServiceRequest.f2276m);
        n1.b.r(parcel, 15, getServiceRequest.J(), false);
        n1.b.b(parcel, iA);
    }
}
