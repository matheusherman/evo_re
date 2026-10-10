package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import n1.b;
import p1.a;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class ModuleAvailabilityResponse extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ModuleAvailabilityResponse> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f2382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2383b;

    public boolean J() {
        return this.f2382a;
    }

    public int M() {
        return this.f2383b;
    }

    public ModuleAvailabilityResponse(boolean z10, int i10) {
        this.f2382a = z10;
        this.f2383b = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iA = b.a(parcel);
        b.c(parcel, 1, J());
        b.k(parcel, 2, M());
        b.b(parcel, iA);
    }
}
