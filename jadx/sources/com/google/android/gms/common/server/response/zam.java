package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f2444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f2445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final FastJsonResponse.Field f2446c;

    zam(int i10, String str, FastJsonResponse.Field field) {
        this.f2444a = i10;
        this.f2445b = str;
        this.f2446c = field;
    }

    zam(String str, FastJsonResponse.Field field) {
        this.f2444a = 1;
        this.f2445b = str;
        this.f2446c = field;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f2444a;
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, i11);
        n1.b.r(parcel, 2, this.f2445b, false);
        n1.b.q(parcel, 3, this.f2446c, i10, false);
        n1.b.b(parcel, iA);
    }
}
