package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zag extends AbstractSafeParcelable implements k {
    public static final Parcelable.Creator<zag> CREATOR = new d2.d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f4352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f4353b;

    @Override // com.google.android.gms.common.api.k
    public final Status B() {
        return this.f4353b != null ? Status.f2152f : Status.f2156j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        List list = this.f4352a;
        int iA = n1.b.a(parcel);
        n1.b.t(parcel, 1, list, false);
        n1.b.r(parcel, 2, this.f4353b, false);
        n1.b.b(parcel, iA);
    }

    public zag(List list, @Nullable String str) {
        this.f4352a = list;
        this.f4353b = str;
    }
}
