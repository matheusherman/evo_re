package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<Scope> CREATOR = new r();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f2149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2150b;

    Scope(int i10, String str) {
        m1.g.f(str, "scopeUri must not be null or empty");
        this.f2149a = i10;
        this.f2150b = str;
    }

    public Scope(@NonNull String str) {
        this(1, str);
    }

    @NonNull
    public String J() {
        return this.f2150b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f2150b.equals(((Scope) obj).f2150b);
        }
        return false;
    }

    public int hashCode() {
        return this.f2150b.hashCode();
    }

    @NonNull
    public String toString() {
        return this.f2150b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int i11 = this.f2149a;
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, i11);
        n1.b.r(parcel, 2, J(), false);
        n1.b.b(parcel, iA);
    }
}
