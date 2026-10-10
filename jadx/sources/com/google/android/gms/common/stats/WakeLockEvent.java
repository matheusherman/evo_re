package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.List;
import n1.b;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Deprecated
public final class WakeLockEvent extends StatsEvent {

    @NonNull
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f2450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f2451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f2453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f2454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f2455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f2456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f2457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f2458i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f2459j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f2460k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f2461l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final float f2462m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final long f2463n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f2464o;

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int J() {
        return this.f2452c;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long M() {
        return this.f2451b;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    @NonNull
    public final String P() {
        List list = this.f2457h;
        String strJoin = list == null ? "" : TextUtils.join(",", list);
        int i10 = this.f2460k;
        String str = this.f2454e;
        String str2 = this.f2461l;
        float f10 = this.f2462m;
        String str3 = this.f2455f;
        int i11 = this.f2456g;
        String str4 = this.f2453d;
        boolean z10 = this.f2464o;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\t");
        sb2.append(str4);
        sb2.append("\t");
        sb2.append(i11);
        sb2.append("\t");
        sb2.append(strJoin);
        sb2.append("\t");
        sb2.append(i10);
        sb2.append("\t");
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        sb2.append("\t");
        if (str2 == null) {
            str2 = "";
        }
        sb2.append(str2);
        sb2.append("\t");
        sb2.append(f10);
        sb2.append("\t");
        sb2.append(str3 != null ? str3 : "");
        sb2.append("\t");
        sb2.append(z10);
        return sb2.toString();
    }

    WakeLockEvent(int i10, long j10, int i11, String str, int i12, List list, String str2, long j11, int i13, String str3, String str4, float f10, long j12, String str5, boolean z10) {
        this.f2450a = i10;
        this.f2451b = j10;
        this.f2452c = i11;
        this.f2453d = str;
        this.f2454e = str3;
        this.f2455f = str5;
        this.f2456g = i12;
        this.f2457h = list;
        this.f2458i = str2;
        this.f2459j = j11;
        this.f2460k = i13;
        this.f2461l = str4;
        this.f2462m = f10;
        this.f2463n = j12;
        this.f2464o = z10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iA = b.a(parcel);
        b.k(parcel, 1, this.f2450a);
        b.n(parcel, 2, this.f2451b);
        b.r(parcel, 4, this.f2453d, false);
        b.k(parcel, 5, this.f2456g);
        b.t(parcel, 6, this.f2457h, false);
        b.n(parcel, 8, this.f2459j);
        b.r(parcel, 10, this.f2454e, false);
        b.k(parcel, 11, this.f2452c);
        b.r(parcel, 12, this.f2458i, false);
        b.r(parcel, 13, this.f2461l, false);
        b.k(parcel, 14, this.f2460k);
        b.h(parcel, 15, this.f2462m);
        b.n(parcel, 16, this.f2463n);
        b.r(parcel, 17, this.f2455f, false);
        b.c(parcel, 18, this.f2464o);
        b.b(parcel, iA);
    }
}
