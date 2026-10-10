package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new s();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f2486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f2487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f2488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f2489e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f2490f;

    /* JADX WARN: Type inference failed for: r5v5, types: [android.os.IBinder, u1.a] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        String str = this.f2485a;
        int iA = n1.b.a(parcel);
        n1.b.r(parcel, 1, str, false);
        n1.b.c(parcel, 2, this.f2486b);
        n1.b.c(parcel, 3, this.f2487c);
        n1.b.j(parcel, 4, u1.b.W(this.f2488d), false);
        n1.b.c(parcel, 5, this.f2489e);
        n1.b.c(parcel, 6, this.f2490f);
        n1.b.b(parcel, iA);
    }

    zzo(String str, boolean z10, boolean z11, IBinder iBinder, boolean z12, boolean z13) {
        this.f2485a = str;
        this.f2486b = z10;
        this.f2487c = z11;
        this.f2488d = (Context) u1.b.g(u1.a.AbstractBinderC0368a.f(iBinder));
        this.f2489e = z12;
        this.f2490f = z13;
    }
}
