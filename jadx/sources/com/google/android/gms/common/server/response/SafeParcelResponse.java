package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.k;
import com.google.android.gms.common.util.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import m1.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {

    @NonNull
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Parcel f2435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2436c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zan f2437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final String f2438e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2440g;

    private final void j(StringBuilder sb2, Map map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry entry : map.entrySet()) {
            sparseArray.put(((FastJsonResponse.Field) entry.getValue()).J(), entry);
        }
        sb2.append('{');
        int iJ = n1.a.J(parcel);
        boolean z10 = false;
        while (parcel.dataPosition() < iJ) {
            int iC = n1.a.C(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(n1.a.v(iC));
            if (entry2 != null) {
                if (z10) {
                    sb2.append(",");
                }
                String str = (String) entry2.getKey();
                FastJsonResponse.Field field = (FastJsonResponse.Field) entry2.getValue();
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\":");
                if (field.k0()) {
                    int i10 = field.f2426d;
                    switch (i10) {
                        case 0:
                            p(sb2, field, FastJsonResponse.f(field, Integer.valueOf(n1.a.E(parcel, iC))));
                            break;
                        case 1:
                            p(sb2, field, FastJsonResponse.f(field, n1.a.c(parcel, iC)));
                            break;
                        case 2:
                            p(sb2, field, FastJsonResponse.f(field, Long.valueOf(n1.a.F(parcel, iC))));
                            break;
                        case 3:
                            p(sb2, field, FastJsonResponse.f(field, Float.valueOf(n1.a.A(parcel, iC))));
                            break;
                        case 4:
                            p(sb2, field, FastJsonResponse.f(field, Double.valueOf(n1.a.y(parcel, iC))));
                            break;
                        case 5:
                            p(sb2, field, FastJsonResponse.f(field, n1.a.a(parcel, iC)));
                            break;
                        case 6:
                            p(sb2, field, FastJsonResponse.f(field, Boolean.valueOf(n1.a.w(parcel, iC))));
                            break;
                        case 7:
                            p(sb2, field, FastJsonResponse.f(field, n1.a.p(parcel, iC)));
                            break;
                        case 8:
                        case 9:
                            p(sb2, field, FastJsonResponse.f(field, n1.a.g(parcel, iC)));
                            break;
                        case 10:
                            Bundle bundleF = n1.a.f(parcel, iC);
                            HashMap map2 = new HashMap();
                            for (String str2 : bundleF.keySet()) {
                                map2.put(str2, (String) g.k(bundleF.getString(str2)));
                            }
                            p(sb2, field, FastJsonResponse.f(field, map2));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            throw new IllegalArgumentException("Unknown field out type = " + i10);
                    }
                } else if (field.f2427e) {
                    sb2.append("[");
                    switch (field.f2426d) {
                        case 0:
                            com.google.android.gms.common.util.b.e(sb2, n1.a.j(parcel, iC));
                            break;
                        case 1:
                            com.google.android.gms.common.util.b.g(sb2, n1.a.d(parcel, iC));
                            break;
                        case 2:
                            com.google.android.gms.common.util.b.f(sb2, n1.a.l(parcel, iC));
                            break;
                        case 3:
                            com.google.android.gms.common.util.b.d(sb2, n1.a.i(parcel, iC));
                            break;
                        case 4:
                            com.google.android.gms.common.util.b.c(sb2, n1.a.h(parcel, iC));
                            break;
                        case 5:
                            com.google.android.gms.common.util.b.g(sb2, n1.a.b(parcel, iC));
                            break;
                        case 6:
                            com.google.android.gms.common.util.b.h(sb2, n1.a.e(parcel, iC));
                            break;
                        case 7:
                            com.google.android.gms.common.util.b.i(sb2, n1.a.q(parcel, iC));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            Parcel[] parcelArrN = n1.a.n(parcel, iC);
                            int length = parcelArrN.length;
                            for (int i11 = 0; i11 < length; i11++) {
                                if (i11 > 0) {
                                    sb2.append(",");
                                }
                                parcelArrN[i11].setDataPosition(0);
                                j(sb2, field.i0(), parcelArrN[i11]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    sb2.append("]");
                } else {
                    switch (field.f2426d) {
                        case 0:
                            sb2.append(n1.a.E(parcel, iC));
                            break;
                        case 1:
                            sb2.append(n1.a.c(parcel, iC));
                            break;
                        case 2:
                            sb2.append(n1.a.F(parcel, iC));
                            break;
                        case 3:
                            sb2.append(n1.a.A(parcel, iC));
                            break;
                        case 4:
                            sb2.append(n1.a.y(parcel, iC));
                            break;
                        case 5:
                            sb2.append(n1.a.a(parcel, iC));
                            break;
                        case 6:
                            sb2.append(n1.a.w(parcel, iC));
                            break;
                        case 7:
                            String strP = n1.a.p(parcel, iC);
                            sb2.append("\"");
                            sb2.append(k.a(strP));
                            sb2.append("\"");
                            break;
                        case 8:
                            byte[] bArrG = n1.a.g(parcel, iC);
                            sb2.append("\"");
                            sb2.append(com.google.android.gms.common.util.c.a(bArrG));
                            sb2.append("\"");
                            break;
                        case 9:
                            byte[] bArrG2 = n1.a.g(parcel, iC);
                            sb2.append("\"");
                            sb2.append(com.google.android.gms.common.util.c.b(bArrG2));
                            sb2.append("\"");
                            break;
                        case 10:
                            Bundle bundleF2 = n1.a.f(parcel, iC);
                            Set<String> setKeySet = bundleF2.keySet();
                            sb2.append("{");
                            boolean z11 = true;
                            for (String str3 : setKeySet) {
                                if (!z11) {
                                    sb2.append(",");
                                }
                                sb2.append("\"");
                                sb2.append(str3);
                                sb2.append("\":\"");
                                sb2.append(k.a(bundleF2.getString(str3)));
                                sb2.append("\"");
                                z11 = false;
                            }
                            sb2.append("}");
                            break;
                        case 11:
                            Parcel parcelM = n1.a.m(parcel, iC);
                            parcelM.setDataPosition(0);
                            j(sb2, field.i0(), parcelM);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                z10 = true;
            }
        }
        if (parcel.dataPosition() == iJ) {
            sb2.append('}');
            return;
        }
        throw new n1.a.C0307a("Overread allowed size end=" + iJ, parcel);
    }

    private static final void l(StringBuilder sb2, int i10, @Nullable Object obj) {
        switch (i10) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb2.append(obj);
                return;
            case 7:
                sb2.append("\"");
                sb2.append(k.a(g.k(obj).toString()));
                sb2.append("\"");
                return;
            case 8:
                sb2.append("\"");
                sb2.append(com.google.android.gms.common.util.c.a((byte[]) obj));
                sb2.append("\"");
                return;
            case 9:
                sb2.append("\"");
                sb2.append(com.google.android.gms.common.util.c.b((byte[]) obj));
                sb2.append("\"");
                return;
            case 10:
                l.a(sb2, (HashMap) g.k(obj));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i10);
        }
    }

    private static final void p(StringBuilder sb2, FastJsonResponse.Field field, Object obj) {
        if (!field.f2425c) {
            l(sb2, field.f2424b, obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        sb2.append("[");
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 != 0) {
                sb2.append(",");
            }
            l(sb2, field.f2424b, arrayList.get(i10));
        }
        sb2.append("]");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    @Nullable
    public final Map<String, FastJsonResponse.Field<?, ?>> a() {
        zan zanVar = this.f2437d;
        if (zanVar == null) {
            return null;
        }
        return zanVar.M((String) g.k(this.f2438e));
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    @NonNull
    public final Object c(@NonNull String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean e(@NonNull String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @NonNull
    public final Parcel h() {
        int i10 = this.f2439f;
        if (i10 == 0) {
            int iA = n1.b.a(this.f2435b);
            this.f2440g = iA;
            n1.b.b(this.f2435b, iA);
            this.f2439f = 2;
        } else if (i10 == 1) {
            n1.b.b(this.f2435b, this.f2440g);
            this.f2439f = 2;
        }
        return this.f2435b;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    @NonNull
    public final String toString() {
        g.l(this.f2437d, "Cannot convert to JSON on client side.");
        Parcel parcelH = h();
        parcelH.setDataPosition(0);
        StringBuilder sb2 = new StringBuilder(100);
        j(sb2, (Map) g.k(this.f2437d.M((String) g.k(this.f2438e))), parcelH);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        zan zanVar;
        int i11 = this.f2434a;
        int iA = n1.b.a(parcel);
        n1.b.k(parcel, 1, i11);
        n1.b.p(parcel, 2, h(), false);
        int i12 = this.f2436c;
        if (i12 != 0) {
            zanVar = i12 != 1 ? this.f2437d : this.f2437d;
        } else {
            zanVar = null;
        }
        n1.b.q(parcel, 3, zanVar, i10, false);
        n1.b.b(parcel, iA);
    }

    SafeParcelResponse(int i10, Parcel parcel, zan zanVar) {
        String strJ;
        this.f2434a = i10;
        this.f2435b = (Parcel) g.k(parcel);
        this.f2437d = zanVar;
        if (zanVar == null) {
            strJ = null;
        } else {
            strJ = zanVar.J();
        }
        this.f2438e = strJ;
        this.f2439f = 2;
    }
}
