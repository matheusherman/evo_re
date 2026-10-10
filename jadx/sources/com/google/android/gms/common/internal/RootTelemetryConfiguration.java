package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import m1.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class RootTelemetryConfiguration extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new g0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f2288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f2289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f2290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f2291e;

    public int J() {
        return this.f2290d;
    }

    public int M() {
        return this.f2291e;
    }

    public boolean P() {
        return this.f2288b;
    }

    public boolean S() {
        return this.f2289c;
    }

    public int getVersion() {
        return this.f2287a;
    }

    public RootTelemetryConfiguration(int i10, boolean z10, boolean z11, int i11, int i12) {
        this.f2287a = i10;
        this.f2288b = z10;
        this.f2289c = z11;
        this.f2290d = i11;
        this.f2291e = i12;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, getVersion());
        n1.b.c(parcel, 2, P());
        n1.b.c(parcel, 3, S());
        n1.b.k(parcel, 4, J());
        n1.b.k(parcel, 5, M());
        n1.b.b(parcel, iA);
    }
}
