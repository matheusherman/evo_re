package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import m1.g;
import n1.b;
import p1.d;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class ModuleInstallStatusUpdate extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ModuleInstallStatusUpdate> CREATOR = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final Long f2389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final Long f2390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f2391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final a f2392f;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f2393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f2394b;

        a(long j10, long j11) {
            g.n(j11);
            this.f2393a = j10;
            this.f2394b = j11;
        }
    }

    public int J() {
        return this.f2391e;
    }

    public int M() {
        return this.f2388b;
    }

    public int P() {
        return this.f2387a;
    }

    public ModuleInstallStatusUpdate(int i10, int i11, @Nullable Long l10, @Nullable Long l11, int i12) {
        a aVar;
        this.f2387a = i10;
        this.f2388b = i11;
        this.f2389c = l10;
        this.f2390d = l11;
        this.f2391e = i12;
        if (l10 != null && l11 != null && l11.longValue() != 0) {
            aVar = new a(l10.longValue(), l11.longValue());
        } else {
            aVar = null;
        }
        this.f2392f = aVar;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iA = b.a(parcel);
        b.k(parcel, 1, P());
        b.k(parcel, 2, M());
        b.o(parcel, 3, this.f2389c, false);
        b.o(parcel, 4, this.f2390d, false);
        b.k(parcel, 5, J());
        b.b(parcel, iA);
    }
}
