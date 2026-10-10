package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f2441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f2442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    final ArrayList f2443c;

    zal(int i10, String str, ArrayList arrayList) {
        this.f2441a = i10;
        this.f2442b = str;
        this.f2443c = arrayList;
    }

    zal(String str, Map map) {
        ArrayList arrayList;
        this.f2441a = 1;
        this.f2442b = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (String str2 : map.keySet()) {
                arrayList.add(new zam(str2, (FastJsonResponse.Field) map.get(str2)));
            }
        }
        this.f2443c = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f2441a;
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, i11);
        n1.b.r(parcel, 2, this.f2442b, false);
        n1.b.v(parcel, 3, this.f2443c, false);
        n1.b.b(parcel, iA);
    }
}
