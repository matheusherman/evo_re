package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zzeb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzeb> CREATOR = new g3();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f3347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final Intent f3348c;

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzeb)) {
            return false;
        }
        zzeb zzebVar = (zzeb) obj;
        return this.f3346a == zzebVar.f3346a && Objects.equals(this.f3347b, zzebVar.f3347b) && Objects.equals(this.f3348c, zzebVar.f3348c);
    }

    public static zzeb J(Activity activity) {
        return new zzeb(activity.hashCode(), activity.getClass().getCanonicalName(), activity.getIntent());
    }

    public final int hashCode() {
        return this.f3346a;
    }

    public zzeb(int i10, @Nullable String str, @Nullable Intent intent) {
        this.f3346a = i10;
        this.f3347b = str;
        this.f3348c = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, this.f3346a);
        n1.b.r(parcel, 2, this.f3347b, false);
        n1.b.q(parcel, 3, this.f3348c, i10, false);
        n1.b.b(parcel, iA);
    }
}
