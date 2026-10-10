package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import m1.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class zan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zan> CREATOR = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f2447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap f2448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f2449c;

    public final String J() {
        return this.f2449c;
    }

    @Nullable
    public final Map M(String str) {
        return (Map) this.f2448b.get(str);
    }

    public final void P() {
        Iterator it = this.f2448b.keySet().iterator();
        while (it.hasNext()) {
            Map map = (Map) this.f2448b.get((String) it.next());
            Iterator it2 = map.keySet().iterator();
            while (it2.hasNext()) {
                ((FastJsonResponse.Field) map.get((String) it2.next())).j0(this);
            }
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (String str : this.f2448b.keySet()) {
            sb2.append(str);
            sb2.append(":\n");
            Map map = (Map) this.f2448b.get(str);
            for (String str2 : map.keySet()) {
                sb2.append("  ");
                sb2.append(str2);
                sb2.append(": ");
                sb2.append(map.get(str2));
            }
        }
        return sb2.toString();
    }

    zan(int i10, ArrayList arrayList, String str) {
        this.f2447a = i10;
        HashMap map = new HashMap();
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            zal zalVar = (zal) arrayList.get(i11);
            String str2 = zalVar.f2442b;
            HashMap map2 = new HashMap();
            int size2 = ((ArrayList) g.k(zalVar.f2443c)).size();
            for (int i12 = 0; i12 < size2; i12++) {
                zam zamVar = (zam) zalVar.f2443c.get(i12);
                map2.put(zamVar.f2445b, zamVar.f2446c);
            }
            map.put(str2, map2);
        }
        this.f2448b = map;
        this.f2449c = (String) g.k(str);
        P();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, this.f2447a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f2448b.keySet()) {
            arrayList.add(new zal(str, (Map) this.f2448b.get(str)));
        }
        n1.b.v(parcel, 2, arrayList, false);
        n1.b.r(parcel, 3, this.f2449c, false);
        n1.b.b(parcel, iA);
    }
}
