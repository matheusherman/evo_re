package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zzpy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzpy> CREATOR = new uc();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final Long f4318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final String f4319e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f4320f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final Double f4321g;

    zzpy(tc tcVar) {
        this(tcVar.f4077c, tcVar.f4078d, tcVar.f4079e, tcVar.f4076b);
    }

    zzpy(String str, long j10, @Nullable Object obj, String str2) {
        m1.g.e(str);
        this.f4315a = 2;
        this.f4316b = str;
        this.f4317c = j10;
        this.f4320f = str2;
        if (obj == null) {
            this.f4318d = null;
            this.f4321g = null;
            this.f4319e = null;
            return;
        }
        if (obj instanceof Long) {
            this.f4318d = (Long) obj;
            this.f4321g = null;
            this.f4319e = null;
        } else if (obj instanceof String) {
            this.f4318d = null;
            this.f4321g = null;
            this.f4319e = (String) obj;
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("User attribute given of un-supported type");
            }
            this.f4318d = null;
            this.f4321g = (Double) obj;
            this.f4319e = null;
        }
    }

    @Nullable
    public final Object J() {
        Long l10 = this.f4318d;
        if (l10 != null) {
            return l10;
        }
        Double d10 = this.f4321g;
        if (d10 != null) {
            return d10;
        }
        String str = this.f4319e;
        if (str != null) {
            return str;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, this.f4315a);
        n1.b.r(parcel, 2, this.f4316b, false);
        n1.b.n(parcel, 3, this.f4317c);
        n1.b.o(parcel, 4, this.f4318d, false);
        n1.b.i(parcel, 5, null, false);
        n1.b.r(parcel, 6, this.f4319e, false);
        n1.b.r(parcel, 7, this.f4320f, false);
        n1.b.g(parcel, 8, this.f4321g, false);
        n1.b.b(parcel, iA);
    }

    zzpy(int i10, String str, long j10, @Nullable Long l10, Float f10, @Nullable String str2, String str3, @Nullable Double d10) {
        this.f4315a = i10;
        this.f4316b = str;
        this.f4317c = j10;
        this.f4318d = l10;
        if (i10 == 1) {
            this.f4321g = f10 != null ? Double.valueOf(f10.doubleValue()) : null;
        } else {
            this.f4321g = d10;
        }
        this.f4319e = str2;
        this.f4320f = str3;
    }
}
