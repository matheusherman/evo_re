package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import m1.i0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new i0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RootTelemetryConfiguration f2254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f2255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f2256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final int[] f2257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f2258e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final int[] f2259f;

    public int J() {
        return this.f2258e;
    }

    @Nullable
    public int[] M() {
        return this.f2257d;
    }

    @Nullable
    public int[] P() {
        return this.f2259f;
    }

    public boolean S() {
        return this.f2255b;
    }

    public boolean V() {
        return this.f2256c;
    }

    @NonNull
    public final RootTelemetryConfiguration i0() {
        return this.f2254a;
    }

    public ConnectionTelemetryConfiguration(@NonNull RootTelemetryConfiguration rootTelemetryConfiguration, boolean z10, boolean z11, @Nullable int[] iArr, int i10, @Nullable int[] iArr2) {
        this.f2254a = rootTelemetryConfiguration;
        this.f2255b = z10;
        this.f2256c = z11;
        this.f2257d = iArr;
        this.f2258e = i10;
        this.f2259f = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.q(parcel, 1, this.f2254a, i10, false);
        n1.b.c(parcel, 2, S());
        n1.b.c(parcel, 3, V());
        n1.b.l(parcel, 4, M(), false);
        n1.b.k(parcel, 5, J());
        n1.b.l(parcel, 6, P(), false);
        n1.b.b(parcel, iA);
    }
}
