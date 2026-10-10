package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zat> CREATOR = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f2364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Account f2365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final GoogleSignInAccount f2367d;

    zat(int i10, Account account, int i11, @Nullable GoogleSignInAccount googleSignInAccount) {
        this.f2364a = i10;
        this.f2365b = account;
        this.f2366c = i11;
        this.f2367d = googleSignInAccount;
    }

    public zat(Account account, int i10, @Nullable GoogleSignInAccount googleSignInAccount) {
        this(2, account, i10, googleSignInAccount);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f2364a;
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, i11);
        n1.b.q(parcel, 2, this.f2365b, i10, false);
        n1.b.k(parcel, 3, this.f2366c);
        n1.b.q(parcel, 4, this.f2367d, i10, false);
        n1.b.b(parcel, iA);
    }
}
