package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.a<String, Integer> {

    @NonNull
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f2415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap f2416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SparseArray f2417c;

    public StringToIntConverter() {
        this.f2415a = 1;
        this.f2416b = new HashMap();
        this.f2417c = new SparseArray();
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.a
    @NonNull
    public final /* bridge */ /* synthetic */ Object f(@NonNull Object obj) {
        String str = (String) this.f2417c.get(((Integer) obj).intValue());
        return (str == null && this.f2416b.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int i11 = this.f2415a;
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, i11);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f2416b.keySet()) {
            arrayList.add(new zac(str, ((Integer) this.f2416b.get(str)).intValue()));
        }
        n1.b.v(parcel, 2, arrayList, false);
        n1.b.b(parcel, iA);
    }

    @NonNull
    public StringToIntConverter J(@NonNull String str, int i10) {
        this.f2416b.put(str, Integer.valueOf(i10));
        this.f2417c.put(i10, str);
        return this;
    }

    StringToIntConverter(int i10, ArrayList arrayList) {
        this.f2415a = i10;
        this.f2416b = new HashMap();
        this.f2417c = new SparseArray();
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            zac zacVar = (zac) arrayList.get(i11);
            J(zacVar.f2421b, zacVar.f2422c);
        }
    }
}
