package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import java.util.Comparator;
import java.util.List;
import m1.f;
import m1.g;
import q1.b;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class ApiFeatureRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ApiFeatureRequest> CREATOR = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Comparator f2395e = new Comparator() { // from class: q1.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            Feature feature = (Feature) obj;
            Feature feature2 = (Feature) obj2;
            Parcelable.Creator<ApiFeatureRequest> creator = ApiFeatureRequest.CREATOR;
            return !feature.J().equals(feature2.J()) ? feature.J().compareTo(feature2.J()) : (feature.M() > feature2.M() ? 1 : (feature.M() == feature2.M() ? 0 : -1));
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f2396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f2397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final String f2398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final String f2399d;

    public final boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof ApiFeatureRequest)) {
            return false;
        }
        ApiFeatureRequest apiFeatureRequest = (ApiFeatureRequest) obj;
        return this.f2397b == apiFeatureRequest.f2397b && f.a(this.f2396a, apiFeatureRequest.f2396a) && f.a(this.f2398c, apiFeatureRequest.f2398c) && f.a(this.f2399d, apiFeatureRequest.f2399d);
    }

    @NonNull
    public List<Feature> J() {
        return this.f2396a;
    }

    public final int hashCode() {
        return f.b(Boolean.valueOf(this.f2397b), this.f2396a, this.f2398c, this.f2399d);
    }

    public ApiFeatureRequest(@NonNull List list, boolean z10, @Nullable String str, @Nullable String str2) {
        g.k(list);
        this.f2396a = list;
        this.f2397b = z10;
        this.f2398c = str;
        this.f2399d = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.v(parcel, 1, J(), false);
        n1.b.c(parcel, 2, this.f2397b);
        n1.b.r(parcel, 3, this.f2398c, false);
        n1.b.r(parcel, 4, this.f2399d, false);
        n1.b.b(parcel, iA);
    }
}
