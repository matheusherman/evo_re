package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zac> CREATOR = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f2420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f2421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f2422c;

    zac(int i10, String str, int i11) {
        this.f2420a = i10;
        this.f2421b = str;
        this.f2422c = i11;
    }

    zac(String str, int i10) {
        this.f2420a = 1;
        this.f2421b = str;
        this.f2422c = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f2420a;
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, i11);
        n1.b.r(parcel, 2, this.f2421b, false);
        n1.b.k(parcel, 3, this.f2422c);
        n1.b.b(parcel, iA);
    }
}
