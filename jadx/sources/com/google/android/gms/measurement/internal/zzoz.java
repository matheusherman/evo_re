package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zzoz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzoz> CREATOR = new zb();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f4307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f4309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f4310e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f4311f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f4312g;

    zzoz(long j10, byte[] bArr, String str, Bundle bundle, int i10, long j11) {
        this(j10, bArr, str, bundle, i10, j11, "");
    }

    zzoz(long j10, byte[] bArr, String str, Bundle bundle, int i10, long j11, String str2) {
        this.f4306a = j10;
        this.f4307b = bArr;
        this.f4308c = str;
        this.f4309d = bundle;
        this.f4310e = i10;
        this.f4311f = j11;
        this.f4312g = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.n(parcel, 1, this.f4306a);
        n1.b.f(parcel, 2, this.f4307b, false);
        n1.b.r(parcel, 3, this.f4308c, false);
        n1.b.e(parcel, 4, this.f4309d, false);
        n1.b.k(parcel, 5, this.f4310e);
        n1.b.n(parcel, 6, this.f4311f);
        n1.b.r(parcel, 7, this.f4312g, false);
        n1.b.b(parcel, iA);
    }
}
