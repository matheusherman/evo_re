package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zaa extends AbstractSafeParcelable implements k {
    public static final Parcelable.Creator<zaa> CREATOR = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f4349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private Intent f4351c;

    public zaa() {
        this(2, 0, null);
    }

    zaa(int i10, int i11, @Nullable Intent intent) {
        this.f4349a = i10;
        this.f4350b = i11;
        this.f4351c = intent;
    }

    @Override // com.google.android.gms.common.api.k
    public final Status B() {
        return this.f4350b == 0 ? Status.f2152f : Status.f2156j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f4349a;
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, i11);
        n1.b.k(parcel, 2, this.f4350b);
        n1.b.q(parcel, 3, this.f4351c, i10, false);
        n1.b.b(parcel, iA);
    }
}
