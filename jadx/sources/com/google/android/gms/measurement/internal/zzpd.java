package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zzpd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzpd> CREATOR = new cc();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<zzoz> f4314a;

    zzpd(List<zzoz> list) {
        this.f4314a = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.v(parcel, 1, this.f4314a, false);
        n1.b.b(parcel, iA);
    }
}
