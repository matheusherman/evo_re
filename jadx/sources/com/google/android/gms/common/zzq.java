package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new t();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f2491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f2494d;

    public final String J() {
        return this.f2492b;
    }

    public final boolean M() {
        return this.f2491a;
    }

    public final int P() {
        return h.a(this.f2494d);
    }

    public final int S() {
        return x.a(this.f2493c);
    }

    zzq(boolean z10, String str, int i10, int i11) {
        this.f2491a = z10;
        this.f2492b = str;
        this.f2493c = x.a(i10) - 1;
        this.f2494d = h.a(i11) - 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.c(parcel, 1, this.f2491a);
        n1.b.r(parcel, 2, this.f2492b, false);
        n1.b.k(parcel, 3, this.f2493c);
        n1.b.k(parcel, 4, this.f2494d);
        n1.b.b(parcel, iA);
    }
}
