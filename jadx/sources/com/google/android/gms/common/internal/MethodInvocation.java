package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class MethodInvocation extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new m1.x();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f2281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f2282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final String f2283f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private final String f2284g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f2285h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f2286i;

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int i11 = this.f2278a;
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, i11);
        n1.b.k(parcel, 2, this.f2279b);
        n1.b.k(parcel, 3, this.f2280c);
        n1.b.n(parcel, 4, this.f2281d);
        n1.b.n(parcel, 5, this.f2282e);
        n1.b.r(parcel, 6, this.f2283f, false);
        n1.b.r(parcel, 7, this.f2284g, false);
        n1.b.k(parcel, 8, this.f2285h);
        n1.b.k(parcel, 9, this.f2286i);
        n1.b.b(parcel, iA);
    }

    public MethodInvocation(int i10, int i11, int i12, long j10, long j11, @Nullable String str, @Nullable String str2, int i13, int i14) {
        this.f2278a = i10;
        this.f2279b = i11;
        this.f2280c = i12;
        this.f2281d = j10;
        this.f2282e = j11;
        this.f2283f = str;
        this.f2284g = str2;
        this.f2285h = i13;
        this.f2286i = i14;
    }
}
