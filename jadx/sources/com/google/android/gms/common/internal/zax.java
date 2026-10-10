package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zax extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zax> CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f2373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    @Deprecated
    private final Scope[] f2376d;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f2373a;
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, i11);
        n1.b.k(parcel, 2, this.f2374b);
        n1.b.k(parcel, 3, this.f2375c);
        n1.b.u(parcel, 4, this.f2376d, i10, false);
        n1.b.b(parcel, iA);
    }

    zax(int i10, int i11, int i12, @Nullable Scope[] scopeArr) {
        this.f2373a = i10;
        this.f2374b = i11;
        this.f2375c = i12;
        this.f2376d = scopeArr;
    }
}
