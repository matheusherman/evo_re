package com.google.android.gms.common.moduleinstall;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p1.b;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class ModuleInstallIntentResponse extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ModuleInstallIntentResponse> CREATOR = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final PendingIntent f2384a;

    @Nullable
    public PendingIntent J() {
        return this.f2384a;
    }

    public ModuleInstallIntentResponse(@Nullable PendingIntent pendingIntent) {
        this.f2384a = pendingIntent;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.q(parcel, 1, J(), i10, false);
        n1.b.b(parcel, iA);
    }
}
