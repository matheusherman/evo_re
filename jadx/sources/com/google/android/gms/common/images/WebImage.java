package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Locale;
import m1.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class WebImage extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<WebImage> CREATOR = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f2241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Uri f2242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f2244d;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof WebImage)) {
            WebImage webImage = (WebImage) obj;
            if (f.a(this.f2242b, webImage.f2242b) && this.f2243c == webImage.f2243c && this.f2244d == webImage.f2244d) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public Uri J() {
        return this.f2242b;
    }

    public int getHeight() {
        return this.f2244d;
    }

    public int getWidth() {
        return this.f2243c;
    }

    public int hashCode() {
        return f.b(this.f2242b, Integer.valueOf(this.f2243c), Integer.valueOf(this.f2244d));
    }

    @NonNull
    public String toString() {
        return String.format(Locale.US, "Image %dx%d %s", Integer.valueOf(this.f2243c), Integer.valueOf(this.f2244d), this.f2242b.toString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int i11 = this.f2241a;
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, i11);
        n1.b.q(parcel, 2, J(), i10, false);
        n1.b.k(parcel, 3, getWidth());
        n1.b.k(parcel, 4, getHeight());
        n1.b.b(parcel, iA);
    }

    WebImage(int i10, Uri uri, int i11, int i12) {
        this.f2241a = i10;
        this.f2242b = uri;
        this.f2243c = i11;
        this.f2244d = i12;
    }
}
