package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zzag extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzag> CREATOR = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4285c;

    zzag(long j10, int i10, long j11) {
        this.f4283a = j10;
        this.f4284b = i10;
        this.f4285c = j11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.n(parcel, 1, this.f4283a);
        n1.b.k(parcel, 2, this.f4284b);
        n1.b.n(parcel, 3, this.f4285c);
        n1.b.b(parcel, iA);
    }
}
