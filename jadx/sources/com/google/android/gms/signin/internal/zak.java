package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zav;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f4356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConnectionResult f4357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final zav f4358c;

    public final ConnectionResult J() {
        return this.f4357b;
    }

    @Nullable
    public final zav M() {
        return this.f4358c;
    }

    zak(int i10, ConnectionResult connectionResult, @Nullable zav zavVar) {
        this.f4356a = i10;
        this.f4357b = connectionResult;
        this.f4358c = zavVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, this.f4356a);
        n1.b.q(parcel, 2, this.f4357b, i10, false);
        n1.b.q(parcel, 3, this.f4358c, i10, false);
        n1.b.b(parcel, iA);
    }
}
