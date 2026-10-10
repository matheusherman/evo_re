package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class ClientIdentity extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new m1.m();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f2253b;

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientIdentity)) {
            return false;
        }
        ClientIdentity clientIdentity = (ClientIdentity) obj;
        return clientIdentity.f2252a == this.f2252a && m1.f.a(clientIdentity.f2253b, this.f2253b);
    }

    public final int hashCode() {
        return this.f2252a;
    }

    @NonNull
    public final String toString() {
        return this.f2252a + ":" + this.f2253b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int i11 = this.f2252a;
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, i11);
        n1.b.r(parcel, 2, this.f2253b, false);
        n1.b.b(parcel, iA);
    }

    public ClientIdentity(int i10, @Nullable String str) {
        this.f2252a = i10;
        this.f2253b = str;
    }
}
