package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new xb();
    public final String A;
    public final int B;
    public final long C;

    @Nullable
    public final String D;
    public final String E;
    public final long F;
    public final int G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f4322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f4323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f4324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f4325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f4326e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f4327f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final String f4328g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f4329h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f4330i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f4331j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final String f4332k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f4333l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f4334m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f4335n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f4336o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public final String f4337p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public final Boolean f4338q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final long f4339r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public final List<String> f4340s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private final String f4341t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f4342u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f4343v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    public final String f4344w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f4345x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f4346y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f4347z;

    zzq(@Nullable String str, @Nullable String str2, @Nullable String str3, long j10, @Nullable String str4, long j11, long j12, @Nullable String str5, boolean z10, boolean z11, @Nullable String str6, long j13, int i10, boolean z12, boolean z13, @Nullable String str7, @Nullable Boolean bool, long j14, @Nullable List<String> list, @Nullable String str8, String str9, String str10, @Nullable String str11, boolean z14, long j15, int i11, String str12, int i12, long j16, @Nullable String str13, String str14, long j17, int i13) {
        m1.g.e(str);
        this.f4322a = str;
        this.f4323b = TextUtils.isEmpty(str2) ? null : str2;
        this.f4324c = str3;
        this.f4331j = j10;
        this.f4325d = str4;
        this.f4326e = j11;
        this.f4327f = j12;
        this.f4328g = str5;
        this.f4329h = z10;
        this.f4330i = z11;
        this.f4332k = str6;
        this.f4333l = j13;
        this.f4334m = i10;
        this.f4335n = z12;
        this.f4336o = z13;
        this.f4337p = str7;
        this.f4338q = bool;
        this.f4339r = j14;
        this.f4340s = list;
        this.f4341t = null;
        this.f4342u = str9;
        this.f4343v = str10;
        this.f4344w = str11;
        this.f4345x = z14;
        this.f4346y = j15;
        this.f4347z = i11;
        this.A = str12;
        this.B = i12;
        this.C = j16;
        this.D = str13;
        this.E = str14;
        this.F = j17;
        this.G = i13;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.r(parcel, 2, this.f4322a, false);
        n1.b.r(parcel, 3, this.f4323b, false);
        n1.b.r(parcel, 4, this.f4324c, false);
        n1.b.r(parcel, 5, this.f4325d, false);
        n1.b.n(parcel, 6, this.f4326e);
        n1.b.n(parcel, 7, this.f4327f);
        n1.b.r(parcel, 8, this.f4328g, false);
        n1.b.c(parcel, 9, this.f4329h);
        n1.b.c(parcel, 10, this.f4330i);
        n1.b.n(parcel, 11, this.f4331j);
        n1.b.r(parcel, 12, this.f4332k, false);
        n1.b.n(parcel, 14, this.f4333l);
        n1.b.k(parcel, 15, this.f4334m);
        n1.b.c(parcel, 16, this.f4335n);
        n1.b.c(parcel, 18, this.f4336o);
        n1.b.r(parcel, 19, this.f4337p, false);
        n1.b.d(parcel, 21, this.f4338q, false);
        n1.b.n(parcel, 22, this.f4339r);
        n1.b.t(parcel, 23, this.f4340s, false);
        n1.b.r(parcel, 24, this.f4341t, false);
        n1.b.r(parcel, 25, this.f4342u, false);
        n1.b.r(parcel, 26, this.f4343v, false);
        n1.b.r(parcel, 27, this.f4344w, false);
        n1.b.c(parcel, 28, this.f4345x);
        n1.b.n(parcel, 29, this.f4346y);
        n1.b.k(parcel, 30, this.f4347z);
        n1.b.r(parcel, 31, this.A, false);
        n1.b.k(parcel, 32, this.B);
        n1.b.n(parcel, 34, this.C);
        n1.b.r(parcel, 35, this.D, false);
        n1.b.r(parcel, 36, this.E, false);
        n1.b.n(parcel, 37, this.F);
        n1.b.k(parcel, 38, this.G);
        n1.b.b(parcel, iA);
    }

    zzq(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, long j10, long j11, @Nullable String str5, boolean z10, boolean z11, long j12, @Nullable String str6, long j13, int i10, boolean z12, boolean z13, @Nullable String str7, @Nullable Boolean bool, long j14, @Nullable List<String> list, @Nullable String str8, String str9, String str10, String str11, boolean z14, long j15, int i11, String str12, int i12, long j16, @Nullable String str13, String str14, long j17, int i13) {
        this.f4322a = str;
        this.f4323b = str2;
        this.f4324c = str3;
        this.f4331j = j12;
        this.f4325d = str4;
        this.f4326e = j10;
        this.f4327f = j11;
        this.f4328g = str5;
        this.f4329h = z10;
        this.f4330i = z11;
        this.f4332k = str6;
        this.f4333l = j13;
        this.f4334m = i10;
        this.f4335n = z12;
        this.f4336o = z13;
        this.f4337p = str7;
        this.f4338q = bool;
        this.f4339r = j14;
        this.f4340s = list;
        this.f4341t = str8;
        this.f4342u = str9;
        this.f4343v = str10;
        this.f4344w = str11;
        this.f4345x = z14;
        this.f4346y = j15;
        this.f4347z = i11;
        this.A = str12;
        this.B = i12;
        this.C = j16;
        this.D = str13;
        this.E = str14;
        this.F = j17;
        this.G = i13;
    }
}
