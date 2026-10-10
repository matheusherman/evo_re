package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class ComplianceOptions extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ComplianceOptions> CREATOR;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public static final ComplianceOptions f2139e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f2143d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f2144a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2145b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f2146c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f2147d = true;

        @NonNull
        public ComplianceOptions a() {
            return new ComplianceOptions(this.f2144a, this.f2145b, this.f2146c, this.f2147d);
        }

        @NonNull
        public a b(int i10) {
            this.f2144a = i10;
            return this;
        }

        @NonNull
        public a c(int i10) {
            this.f2145b = i10;
            return this;
        }

        @NonNull
        public a d(boolean z10) {
            this.f2147d = z10;
            return this;
        }

        @NonNull
        public a e(int i10) {
            this.f2146c = i10;
            return this;
        }
    }

    @NonNull
    public static a J() {
        return new a();
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ComplianceOptions)) {
            return false;
        }
        ComplianceOptions complianceOptions = (ComplianceOptions) obj;
        return this.f2140a == complianceOptions.f2140a && this.f2141b == complianceOptions.f2141b && this.f2142c == complianceOptions.f2142c && this.f2143d == complianceOptions.f2143d;
    }

    public final int hashCode() {
        return m1.f.b(Integer.valueOf(this.f2140a), Integer.valueOf(this.f2141b), Integer.valueOf(this.f2142c), Boolean.valueOf(this.f2143d));
    }

    @NonNull
    public final String toString() {
        return "ComplianceOptions{callerProductId=" + this.f2140a + ", dataOwnerProductId=" + this.f2141b + ", processingReason=" + this.f2142c + ", isUserData=" + this.f2143d + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int i11 = this.f2140a;
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, i11);
        n1.b.k(parcel, 2, this.f2141b);
        n1.b.k(parcel, 3, this.f2142c);
        n1.b.c(parcel, 4, this.f2143d);
        n1.b.b(parcel, iA);
    }

    static {
        a aVarJ = J();
        aVarJ.b(-1);
        aVarJ.c(-1);
        aVarJ.e(0);
        aVarJ.d(true);
        f2139e = aVarJ.a();
        CREATOR = new q();
    }

    ComplianceOptions(int i10, int i11, int i12, boolean z10) {
        this.f2140a = i10;
        this.f2141b = i11;
        this.f2142c = i12;
        this.f2143d = z10;
    }
}
