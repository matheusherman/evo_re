package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zzpb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzpb> CREATOR = new ac();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Integer> f4313a;

    public static zzpb J(b2.c1... c1VarArr) {
        ArrayList arrayList = new ArrayList(c1VarArr.length);
        for (b2.c1 c1Var : c1VarArr) {
            arrayList.add(Integer.valueOf(c1Var.b()));
        }
        return new zzpb(arrayList);
    }

    zzpb(List<Integer> list) {
        this.f4313a = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.m(parcel, 1, this.f4313a, false);
        n1.b.b(parcel, iA);
    }
}
