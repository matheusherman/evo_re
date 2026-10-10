package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import n1.b;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f2117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bundle f2119c;

    public int getType() {
        return this.f2118b;
    }

    GoogleSignInOptionsExtensionParcelable(int i10, int i11, Bundle bundle) {
        this.f2117a = i10;
        this.f2118b = i11;
        this.f2119c = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iA = b.a(parcel);
        b.k(parcel, 1, this.f2117a);
        b.k(parcel, 2, getType());
        b.e(parcel, 3, this.f2119c, false);
        b.b(parcel, iA);
    }
}
