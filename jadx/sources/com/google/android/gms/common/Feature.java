package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class Feature extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<Feature> CREATOR = new j1.h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    private final int f2126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f2127c;

    public Feature(@NonNull String str, int i10, long j10) {
        this.f2125a = str;
        this.f2126b = i10;
        this.f2127c = j10;
    }

    public Feature(@NonNull String str, long j10) {
        this.f2125a = str;
        this.f2127c = j10;
        this.f2126b = -1;
    }

    @NonNull
    public String J() {
        return this.f2125a;
    }

    public long M() {
        long j10 = this.f2127c;
        return j10 == -1 ? this.f2126b : j10;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (((J() != null && J().equals(feature.J())) || (J() == null && feature.J() == null)) && M() == feature.M()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return m1.f.b(J(), Long.valueOf(M()));
    }

    @NonNull
    public final String toString() {
        m1.f.a aVarC = m1.f.c(this);
        aVarC.a("name", J());
        aVarC.a("version", Long.valueOf(M()));
        return aVarC.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.r(parcel, 1, J(), false);
        n1.b.k(parcel, 2, this.f2126b);
        n1.b.n(parcel, 3, M());
        n1.b.b(parcel, iA);
    }
}
