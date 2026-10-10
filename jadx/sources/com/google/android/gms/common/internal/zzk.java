package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new w();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Bundle f2378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Feature[] f2379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f2380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    ConnectionTelemetryConfiguration f2381d;

    public zzk() {
    }

    zzk(Bundle bundle, Feature[] featureArr, int i10, @Nullable ConnectionTelemetryConfiguration connectionTelemetryConfiguration) {
        this.f2378a = bundle;
        this.f2379b = featureArr;
        this.f2380c = i10;
        this.f2381d = connectionTelemetryConfiguration;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.e(parcel, 1, this.f2378a, false);
        n1.b.u(parcel, 2, this.f2379b, i10, false);
        n1.b.k(parcel, 3, this.f2380c);
        n1.b.q(parcel, 4, this.f2381d, i10, false);
        n1.b.b(parcel, iA);
    }
}
