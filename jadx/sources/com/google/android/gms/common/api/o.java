package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class o implements Parcelable.Creator {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final o f2199b = new o(new p());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Parcelable.Creator f2200a;

    public static o a() {
        return f2199b;
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i10) {
        return new ApiMetadata[i10];
    }

    private o(Parcelable.Creator creator) {
        this.f2200a = creator;
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iDataPosition = parcel.dataPosition();
        if (parcel.readInt() == -204102970) {
            return p.a(parcel);
        }
        parcel.setDataPosition(iDataPosition - 4);
        return ApiMetadata.J();
    }
}
