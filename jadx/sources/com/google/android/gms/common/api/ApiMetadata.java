package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class ApiMetadata extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ApiMetadata> CREATOR = o.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ApiMetadata f2136b = M().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final ComplianceOptions f2137a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private ComplianceOptions f2138a;

        @NonNull
        public ApiMetadata a() {
            return new ApiMetadata(this.f2138a);
        }
    }

    @NonNull
    public static final ApiMetadata J() {
        return f2136b;
    }

    @NonNull
    public static a M() {
        return new a();
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof ApiMetadata) {
            return Objects.equals(this.f2137a, ((ApiMetadata) obj).f2137a);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f2137a);
    }

    @NonNull
    public final String toString() {
        return "ApiMetadata(complianceOptions=" + String.valueOf(this.f2137a) + ")";
    }

    ApiMetadata(@Nullable ComplianceOptions complianceOptions) {
        this.f2137a = complianceOptions;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        parcel.writeInt(-204102970);
        ComplianceOptions complianceOptions = this.f2137a;
        int iA = n1.b.a(parcel);
        n1.b.q(parcel, 1, complianceOptions, i10, false);
        n1.b.b(parcel, iA);
    }
}
