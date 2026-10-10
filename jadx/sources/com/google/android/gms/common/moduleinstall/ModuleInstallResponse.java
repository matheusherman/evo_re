package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import n1.b;
import p1.c;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class ModuleInstallResponse extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ModuleInstallResponse> CREATOR = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f2386b;

    public int J() {
        return this.f2385a;
    }

    public ModuleInstallResponse(int i10, boolean z10) {
        this.f2385a = i10;
        this.f2386b = z10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iA = b.a(parcel);
        b.k(parcel, 1, J());
        b.c(parcel, 2, this.f2386b);
        b.b(parcel, iA);
    }
}
