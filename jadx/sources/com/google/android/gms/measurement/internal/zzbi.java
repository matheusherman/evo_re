package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zzbi extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzbi> CREATOR = new f0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bundle f4298a;

    public final int J() {
        return this.f4298a.size();
    }

    final Double P(String str) {
        return Double.valueOf(this.f4298a.getDouble(str));
    }

    public final Bundle S() {
        return new Bundle(this.f4298a);
    }

    final Long V(String str) {
        return Long.valueOf(this.f4298a.getLong(str));
    }

    final Object i0(String str) {
        return this.f4298a.get(str);
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new e0(this);
    }

    final String j0(String str) {
        return this.f4298a.getString(str);
    }

    public final String toString() {
        return this.f4298a.toString();
    }

    zzbi(Bundle bundle) {
        this.f4298a = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.e(parcel, 2, S(), false);
        n1.b.b(parcel, iA);
    }
}
