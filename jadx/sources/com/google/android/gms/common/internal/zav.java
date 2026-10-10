package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zav> CREATOR = new j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f2368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    final IBinder f2369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConnectionResult f2370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f2371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f2372e;

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zav)) {
            return false;
        }
        zav zavVar = (zav) obj;
        return this.f2370c.equals(zavVar.f2370c) && m1.f.a(M(), zavVar.M());
    }

    public final ConnectionResult J() {
        return this.f2370c;
    }

    @Nullable
    public final e M() {
        IBinder iBinder = this.f2369b;
        if (iBinder == null) {
            return null;
        }
        return e.a.f(iBinder);
    }

    zav(int i10, @Nullable IBinder iBinder, ConnectionResult connectionResult, boolean z10, boolean z11) {
        this.f2368a = i10;
        this.f2369b = iBinder;
        this.f2370c = connectionResult;
        this.f2371d = z10;
        this.f2372e = z11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, this.f2368a);
        n1.b.j(parcel, 2, this.f2369b, false);
        n1.b.q(parcel, 3, this.f2370c, i10, false);
        n1.b.c(parcel, 4, this.f2371d);
        n1.b.c(parcel, 5, this.f2372e);
        n1.b.b(parcel, iA);
    }
}
