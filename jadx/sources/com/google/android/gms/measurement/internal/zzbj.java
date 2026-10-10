package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zzbj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbj> CREATOR = new b2.c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzbi f4300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f4302d;

    zzbj(zzbj zzbjVar, long j10) {
        m1.g.k(zzbjVar);
        this.f4299a = zzbjVar.f4299a;
        this.f4300b = zzbjVar.f4300b;
        this.f4301c = zzbjVar.f4301c;
        this.f4302d = j10;
    }

    public final String toString() {
        return "origin=" + this.f4301c + ",name=" + this.f4299a + ",params=" + String.valueOf(this.f4300b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.r(parcel, 2, this.f4299a, false);
        n1.b.q(parcel, 3, this.f4300b, i10, false);
        n1.b.r(parcel, 4, this.f4301c, false);
        n1.b.n(parcel, 5, this.f4302d);
        n1.b.b(parcel, iA);
    }

    public zzbj(String str, zzbi zzbiVar, String str2, long j10) {
        this.f4299a = str;
        this.f4300b = zzbiVar;
        this.f4301c = str2;
        this.f4302d = j10;
    }
}
