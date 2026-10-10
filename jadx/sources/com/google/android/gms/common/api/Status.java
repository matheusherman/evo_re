package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class Status extends AbstractSafeParcelable implements k, ReflectedParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f2160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final PendingIntent f2161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final ConnectionResult f2162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public static final Status f2151e = new Status(-1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public static final Status f2152f = new Status(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public static final Status f2153g = new Status(14);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public static final Status f2154h = new Status(8);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public static final Status f2155i = new Status(15);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public static final Status f2156j = new Status(16);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public static final Status f2158l = new Status(17);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public static final Status f2157k = new Status(18);

    @NonNull
    public static final Parcelable.Creator<Status> CREATOR = new s();

    Status(int i10, @Nullable String str, @Nullable PendingIntent pendingIntent, @Nullable ConnectionResult connectionResult) {
        this.f2159a = i10;
        this.f2160b = str;
        this.f2161c = pendingIntent;
        this.f2162d = connectionResult;
    }

    public Status(int i10) {
        this(i10, (String) null);
    }

    @Nullable
    public ConnectionResult J() {
        return this.f2162d;
    }

    public int M() {
        return this.f2159a;
    }

    @Nullable
    public String P() {
        return this.f2160b;
    }

    public boolean S() {
        return this.f2161c != null;
    }

    @NonNull
    public final String V() {
        String str = this.f2160b;
        return str != null ? str : d.a(this.f2159a);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f2159a == status.f2159a && m1.f.a(this.f2160b, status.f2160b) && m1.f.a(this.f2161c, status.f2161c) && m1.f.a(this.f2162d, status.f2162d);
    }

    public int hashCode() {
        return m1.f.b(Integer.valueOf(this.f2159a), this.f2160b, this.f2161c, this.f2162d);
    }

    public Status(@NonNull ConnectionResult connectionResult, @NonNull String str) {
        this(connectionResult, str, 17);
    }

    @NonNull
    public String toString() {
        m1.f.a aVarC = m1.f.c(this);
        aVarC.a("statusCode", V());
        aVarC.a("resolution", this.f2161c);
        return aVarC.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, M());
        n1.b.r(parcel, 2, P(), false);
        n1.b.q(parcel, 3, this.f2161c, i10, false);
        n1.b.q(parcel, 4, J(), i10, false);
        n1.b.b(parcel, iA);
    }

    public Status(int i10, @Nullable String str) {
        this(i10, str, (PendingIntent) null);
    }

    @Deprecated
    public Status(@NonNull ConnectionResult connectionResult, @NonNull String str, int i10) {
        this(i10, str, connectionResult.P(), connectionResult);
    }

    public Status(int i10, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        this(i10, str, pendingIntent, null);
    }

    @Override // com.google.android.gms.common.api.k
    @NonNull
    public Status B() {
        return this;
    }
}
