package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class TelemetryData extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<TelemetryData> CREATOR = new m1.o();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f2293b;

    public final int J() {
        return this.f2292a;
    }

    @Nullable
    public final List M() {
        return this.f2293b;
    }

    public final void P(@NonNull MethodInvocation methodInvocation) {
        if (this.f2293b == null) {
            this.f2293b = new ArrayList();
        }
        this.f2293b.add(methodInvocation);
    }

    public TelemetryData(int i10, List list) {
        this.f2292a = i10;
        this.f2293b = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, this.f2292a);
        n1.b.v(parcel, 2, this.f2293b, false);
        n1.b.b(parcel, iA);
    }
}
