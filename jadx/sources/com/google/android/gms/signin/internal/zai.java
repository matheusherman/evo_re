package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zat;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zai> CREATOR = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f4354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final zat f4355b;

    zai(int i10, zat zatVar) {
        this.f4354a = i10;
        this.f4355b = zatVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, this.f4354a);
        n1.b.q(parcel, 2, this.f4355b, i10, false);
        n1.b.b(parcel, iA);
    }
}
