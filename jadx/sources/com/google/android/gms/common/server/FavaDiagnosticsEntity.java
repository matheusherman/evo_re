package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import n1.b;
import r1.a;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f2412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final String f2413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2414c;

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int i11 = this.f2412a;
        int iA = b.a(parcel);
        b.k(parcel, 1, i11);
        b.r(parcel, 2, this.f2413b, false);
        b.k(parcel, 3, this.f2414c);
        b.b(parcel, iA);
    }

    public FavaDiagnosticsEntity(int i10, @NonNull String str, int i11) {
        this.f2412a = i10;
        this.f2413b = str;
        this.f2414c = i11;
    }
}
