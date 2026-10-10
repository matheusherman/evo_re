package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.taobao.sophix.PatchStatus;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class y {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final y f4211f = new y(null, 100);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Boolean f4214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f4215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final EnumMap<v7.a, b2.g0> f4216e;

    y(Boolean bool, int i10) {
        this((Boolean) null, i10, (Boolean) null, (String) null);
    }

    public static y b(Bundle bundle, int i10) {
        if (bundle == null) {
            return new y(null, i10);
        }
        EnumMap enumMap = new EnumMap(v7.a.class);
        for (v7.a aVar : w7.DMA.a()) {
            enumMap.put(aVar, v7.e(bundle.getString(aVar.zze)));
        }
        return new y((EnumMap<v7.a, b2.g0>) enumMap, i10, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    public static Boolean e(Bundle bundle) {
        b2.g0 g0VarE;
        if (bundle == null || (g0VarE = v7.e(bundle.getString("ad_personalization"))) == null) {
            return null;
        }
        int i10 = b0.f3411a[g0VarE.ordinal()];
        if (i10 == 3) {
            return Boolean.FALSE;
        }
        if (i10 != 4) {
            return null;
        }
        return Boolean.TRUE;
    }

    y(Boolean bool, int i10, Boolean bool2, String str) {
        EnumMap<v7.a, b2.g0> enumMap = new EnumMap<>(v7.a.class);
        this.f4216e = enumMap;
        enumMap.put(v7.a.AD_USER_DATA, v7.d(bool));
        this.f4212a = i10;
        this.f4213b = l();
        this.f4214c = bool2;
        this.f4215d = str;
    }

    static y c(b2.g0 g0Var, int i10) {
        EnumMap enumMap = new EnumMap(v7.a.class);
        enumMap.put(v7.a.AD_USER_DATA, g0Var);
        return new y((EnumMap<v7.a, b2.g0>) enumMap, -10, (Boolean) null, (String) null);
    }

    public static y d(String str) {
        if (str == null || str.length() <= 0) {
            return f4211f;
        }
        String[] strArrSplit = str.split(":");
        int i10 = Integer.parseInt(strArrSplit[0]);
        EnumMap enumMap = new EnumMap(v7.a.class);
        v7.a[] aVarArrA = w7.DMA.a();
        int length = aVarArrA.length;
        int i11 = 1;
        int i12 = 0;
        while (i12 < length) {
            enumMap.put(aVarArrA[i12], v7.c(strArrSplit[i11].charAt(0)));
            i12++;
            i11++;
        }
        return new y((EnumMap<v7.a, b2.g0>) enumMap, i10, (Boolean) null, (String) null);
    }

    private final String l() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f4212a);
        for (v7.a aVar : w7.DMA.a()) {
            sb2.append(":");
            sb2.append(v7.a(this.f4216e.get(aVar)));
        }
        return sb2.toString();
    }

    public final int a() {
        return this.f4212a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        if (this.f4213b.equalsIgnoreCase(yVar.f4213b) && Objects.equals(this.f4214c, yVar.f4214c)) {
            return Objects.equals(this.f4215d, yVar.f4215d);
        }
        return false;
    }

    public final Bundle f() {
        Bundle bundle = new Bundle();
        Iterator it = this.f4216e.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String strQ = v7.q((b2.g0) entry.getValue());
            if (strQ != null) {
                bundle.putString(((v7.a) entry.getKey()).zze, strQ);
            }
        }
        Boolean bool = this.f4214c;
        if (bool != null) {
            bundle.putString("is_dma_region", bool.toString());
        }
        String str = this.f4215d;
        if (str != null) {
            bundle.putString("cps_display_str", str);
        }
        return bundle;
    }

    public final b2.g0 g() {
        b2.g0 g0Var = this.f4216e.get(v7.a.AD_USER_DATA);
        return g0Var == null ? b2.g0.UNINITIALIZED : g0Var;
    }

    public final Boolean h() {
        return this.f4214c;
    }

    public final int hashCode() {
        int i10;
        Boolean bool = this.f4214c;
        if (bool == null) {
            i10 = 3;
        } else {
            i10 = bool.booleanValue() ? 7 : 13;
        }
        String str = this.f4215d;
        return this.f4213b.hashCode() + (i10 * 29) + ((str == null ? 17 : str.hashCode()) * PatchStatus.CODE_LOAD_LIB_NS);
    }

    public final String i() {
        return this.f4215d;
    }

    public final String j() {
        return this.f4213b;
    }

    public final boolean k() {
        Iterator<b2.g0> it = this.f4216e.values().iterator();
        while (it.hasNext()) {
            if (it.next() != b2.g0.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("source=");
        sb2.append(v7.j(this.f4212a));
        for (v7.a aVar : w7.DMA.a()) {
            sb2.append(",");
            sb2.append(aVar.zze);
            sb2.append("=");
            b2.g0 g0Var = this.f4216e.get(aVar);
            if (g0Var == null) {
                sb2.append("uninitialized");
            } else {
                int i10 = b0.f3411a[g0Var.ordinal()];
                if (i10 == 1) {
                    sb2.append("uninitialized");
                } else if (i10 == 2) {
                    sb2.append("eu_consent_policy");
                } else if (i10 == 3) {
                    sb2.append("denied");
                } else if (i10 == 4) {
                    sb2.append("granted");
                }
            }
        }
        if (this.f4214c != null) {
            sb2.append(",isDmaRegion=");
            sb2.append(this.f4214c);
        }
        if (this.f4215d != null) {
            sb2.append(",cpsDisplayStr=");
            sb2.append(this.f4215d);
        }
        return sb2.toString();
    }

    private y(EnumMap<v7.a, b2.g0> enumMap, int i10, Boolean bool, String str) {
        EnumMap<v7.a, b2.g0> enumMap2 = new EnumMap<>(v7.a.class);
        this.f4216e = enumMap2;
        enumMap2.putAll(enumMap);
        this.f4212a = i10;
        this.f4213b = l();
        this.f4214c = bool;
        this.f4215d = str;
    }
}
