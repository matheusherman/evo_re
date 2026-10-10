package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zzai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzai> CREATOR = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public String f4286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zzpy f4288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f4289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f4290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public String f4291f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public zzbj f4292g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f4293h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public zzbj f4294i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f4295j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public zzbj f4296k;

    zzai(zzai zzaiVar) {
        m1.g.k(zzaiVar);
        this.f4286a = zzaiVar.f4286a;
        this.f4287b = zzaiVar.f4287b;
        this.f4288c = zzaiVar.f4288c;
        this.f4289d = zzaiVar.f4289d;
        this.f4290e = zzaiVar.f4290e;
        this.f4291f = zzaiVar.f4291f;
        this.f4292g = zzaiVar.f4292g;
        this.f4293h = zzaiVar.f4293h;
        this.f4294i = zzaiVar.f4294i;
        this.f4295j = zzaiVar.f4295j;
        this.f4296k = zzaiVar.f4296k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.r(parcel, 2, this.f4286a, false);
        n1.b.r(parcel, 3, this.f4287b, false);
        n1.b.q(parcel, 4, this.f4288c, i10, false);
        n1.b.n(parcel, 5, this.f4289d);
        n1.b.c(parcel, 6, this.f4290e);
        n1.b.r(parcel, 7, this.f4291f, false);
        n1.b.q(parcel, 8, this.f4292g, i10, false);
        n1.b.n(parcel, 9, this.f4293h);
        n1.b.q(parcel, 10, this.f4294i, i10, false);
        n1.b.n(parcel, 11, this.f4295j);
        n1.b.q(parcel, 12, this.f4296k, i10, false);
        n1.b.b(parcel, iA);
    }

    zzai(@Nullable String str, String str2, zzpy zzpyVar, long j10, boolean z10, @Nullable String str3, @Nullable zzbj zzbjVar, long j11, @Nullable zzbj zzbjVar2, long j12, @Nullable zzbj zzbjVar3) {
        this.f4286a = str;
        this.f4287b = str2;
        this.f4288c = zzpyVar;
        this.f4289d = j10;
        this.f4290e = z10;
        this.f4291f = str3;
        this.f4292g = zzbjVar;
        this.f4293h = j11;
        this.f4294i = zzbjVar2;
        this.f4295j = j12;
        this.f4296k = zzbjVar3;
    }
}
