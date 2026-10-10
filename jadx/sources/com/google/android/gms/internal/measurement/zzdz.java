package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zzdz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdz> CREATOR = new e3();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f3340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f3341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final String f3342e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final String f3343f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final Bundle f3344g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final String f3345h;

    public zzdz(long j10, long j11, boolean z10, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Bundle bundle, @Nullable String str4) {
        this.f3338a = j10;
        this.f3339b = j11;
        this.f3340c = z10;
        this.f3341d = str;
        this.f3342e = str2;
        this.f3343f = str3;
        this.f3344g = bundle;
        this.f3345h = str4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.n(parcel, 1, this.f3338a);
        n1.b.n(parcel, 2, this.f3339b);
        n1.b.c(parcel, 3, this.f3340c);
        n1.b.r(parcel, 4, this.f3341d, false);
        n1.b.r(parcel, 5, this.f3342e, false);
        n1.b.r(parcel, 6, this.f3343f, false);
        n1.b.e(parcel, 7, this.f3344g, false);
        n1.b.r(parcel, 8, this.f3345h, false);
        n1.b.b(parcel, iA);
    }
}
