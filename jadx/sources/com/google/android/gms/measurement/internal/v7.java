package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class v7 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v7 f4111c = new v7(null, null, 100);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EnumMap<a, b2.g0> f4112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4113b;

    private v7(EnumMap<a, b2.g0> enumMap, int i10) {
        EnumMap<a, b2.g0> enumMap2 = new EnumMap<>(a.class);
        this.f4112a = enumMap2;
        enumMap2.putAll(enumMap);
        this.f4113b = i10;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum a {
        AD_STORAGE("ad_storage"),
        ANALYTICS_STORAGE("analytics_storage"),
        AD_USER_DATA("ad_user_data"),
        AD_PERSONALIZATION("ad_personalization");

        public final String zze;

        a(String str) {
            this.zze = str;
        }
    }

    static char a(b2.g0 g0Var) {
        if (g0Var == null) {
            return '-';
        }
        int iOrdinal = g0Var.ordinal();
        if (iOrdinal == 1) {
            return '+';
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? '-' : '1';
        }
        return '0';
    }

    static b2.g0 c(char c10) {
        if (c10 == '+') {
            return b2.g0.POLICY;
        }
        if (c10 != '0') {
            return c10 != '1' ? b2.g0.UNINITIALIZED : b2.g0.GRANTED;
        }
        return b2.g0.DENIED;
    }

    static b2.g0 d(Boolean bool) {
        if (bool == null) {
            return b2.g0.UNINITIALIZED;
        }
        return bool.booleanValue() ? b2.g0.GRANTED : b2.g0.DENIED;
    }

    static b2.g0 e(String str) {
        if (str == null) {
            return b2.g0.UNINITIALIZED;
        }
        if (str.equals("granted")) {
            return b2.g0.GRANTED;
        }
        return str.equals("denied") ? b2.g0.DENIED : b2.g0.UNINITIALIZED;
    }

    public static v7 f(Bundle bundle, int i10) {
        if (bundle == null) {
            return new v7(null, null, i10);
        }
        EnumMap enumMap = new EnumMap(a.class);
        for (a aVar : w7.STORAGE.zzd) {
            enumMap.put(aVar, e(bundle.getString(aVar.zze)));
        }
        return new v7(enumMap, i10);
    }

    public static v7 g(b2.g0 g0Var, b2.g0 g0Var2, int i10) {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put(a.AD_STORAGE, g0Var);
        enumMap.put(a.ANALYTICS_STORAGE, g0Var2);
        return new v7(enumMap, -10);
    }

    public static v7 i(String str, int i10) {
        EnumMap enumMap = new EnumMap(a.class);
        if (str == null) {
            str = "";
        }
        a[] aVarArrA = w7.STORAGE.a();
        for (int i11 = 0; i11 < aVarArrA.length; i11++) {
            a aVar = aVarArrA[i11];
            int i12 = i11 + 2;
            if (i12 < str.length()) {
                enumMap.put(aVar, c(str.charAt(i12)));
            } else {
                enumMap.put(aVar, b2.g0.UNINITIALIZED);
            }
        }
        return new v7(enumMap, i10);
    }

    static String j(int i10) {
        if (i10 == -30) {
            return "TCF";
        }
        if (i10 == -20) {
            return "API";
        }
        if (i10 == -10) {
            return "MANIFEST";
        }
        if (i10 == 0) {
            return "1P_API";
        }
        if (i10 == 30) {
            return "1P_INIT";
        }
        if (i10 != 90) {
            return i10 != 100 ? "OTHER" : "UNKNOWN";
        }
        return "REMOTE_CONFIG";
    }

    public static String k(Bundle bundle) {
        String string;
        a[] aVarArr = w7.STORAGE.zzd;
        int length = aVarArr.length;
        int i10 = 0;
        while (true) {
            Boolean bool = null;
            if (i10 >= length) {
                return null;
            }
            a aVar = aVarArr[i10];
            if (bundle.containsKey(aVar.zze) && (string = bundle.getString(aVar.zze)) != null) {
                if (string.equals("granted")) {
                    bool = Boolean.TRUE;
                } else if (string.equals("denied")) {
                    bool = Boolean.FALSE;
                }
                if (bool == null) {
                    return string;
                }
            }
            i10++;
        }
    }

    public static boolean l(int i10, int i11) {
        if (i10 == -20 && i11 == -30) {
            return true;
        }
        return (i10 == -30 && i11 == -20) || i10 == i11 || i10 < i11;
    }

    public static v7 p(String str) {
        return i(str, 100);
    }

    public final int b() {
        return this.f4113b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof v7)) {
            return false;
        }
        v7 v7Var = (v7) obj;
        for (a aVar : w7.STORAGE.zzd) {
            if (this.f4112a.get(aVar) != v7Var.f4112a.get(aVar)) {
                return false;
            }
        }
        return this.f4113b == v7Var.f4113b;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0035  */
    public final v7 h(v7 v7Var) {
        EnumMap enumMap = new EnumMap(a.class);
        for (a aVar : w7.STORAGE.zzd) {
            b2.g0 g0Var = this.f4112a.get(aVar);
            b2.g0 g0Var2 = v7Var.f4112a.get(aVar);
            if (g0Var == null) {
                g0Var = g0Var2;
            } else if (g0Var2 != null) {
                b2.g0 g0Var3 = b2.g0.UNINITIALIZED;
                if (g0Var == g0Var3) {
                    g0Var = g0Var2;
                } else if (g0Var2 != g0Var3) {
                    b2.g0 g0Var4 = b2.g0.POLICY;
                    if (g0Var == g0Var4) {
                        g0Var = g0Var2;
                    } else if (g0Var2 != g0Var4) {
                        b2.g0 g0Var5 = b2.g0.DENIED;
                        g0Var = (g0Var == g0Var5 || g0Var2 == g0Var5) ? g0Var5 : b2.g0.GRANTED;
                    }
                }
            }
            if (g0Var != null) {
                enumMap.put(aVar, g0Var);
            }
        }
        return new v7(enumMap, 100);
    }

    public final int hashCode() {
        int iHashCode = this.f4113b * 17;
        Iterator<b2.g0> it = this.f4112a.values().iterator();
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + it.next().hashCode();
        }
        return iHashCode;
    }

    public final boolean m(a aVar) {
        return this.f4112a.get(aVar) != b2.g0.DENIED;
    }

    public final Bundle n() {
        Bundle bundle = new Bundle();
        Iterator it = this.f4112a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String strQ = q((b2.g0) entry.getValue());
            if (strQ != null) {
                bundle.putString(((a) entry.getKey()).zze, strQ);
            }
        }
        return bundle;
    }

    public final v7 o(v7 v7Var) {
        EnumMap enumMap = new EnumMap(a.class);
        for (a aVar : w7.STORAGE.zzd) {
            b2.g0 g0Var = this.f4112a.get(aVar);
            if (g0Var == b2.g0.UNINITIALIZED) {
                g0Var = v7Var.f4112a.get(aVar);
            }
            if (g0Var != null) {
                enumMap.put(aVar, g0Var);
            }
        }
        return new v7(enumMap, this.f4113b);
    }

    public final b2.g0 r() {
        b2.g0 g0Var = this.f4112a.get(a.AD_STORAGE);
        return g0Var == null ? b2.g0.UNINITIALIZED : g0Var;
    }

    public final boolean s(v7 v7Var) {
        for (a aVar : (a[]) this.f4112a.keySet().toArray(new a[0])) {
            b2.g0 g0Var = this.f4112a.get(aVar);
            b2.g0 g0Var2 = v7Var.f4112a.get(aVar);
            b2.g0 g0Var3 = b2.g0.DENIED;
            if (g0Var == g0Var3 && g0Var2 != g0Var3) {
                return true;
            }
        }
        return false;
    }

    public final b2.g0 t() {
        b2.g0 g0Var = this.f4112a.get(a.ANALYTICS_STORAGE);
        return g0Var == null ? b2.g0.UNINITIALIZED : g0Var;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("source=");
        sb2.append(j(this.f4113b));
        for (a aVar : w7.STORAGE.zzd) {
            sb2.append(",");
            sb2.append(aVar.zze);
            sb2.append("=");
            b2.g0 g0Var = this.f4112a.get(aVar);
            if (g0Var == null) {
                g0Var = b2.g0.UNINITIALIZED;
            }
            sb2.append(g0Var);
        }
        return sb2.toString();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0032  */
    public final String u() {
        int iOrdinal;
        StringBuilder sb2 = new StringBuilder("G1");
        for (a aVar : w7.STORAGE.a()) {
            b2.g0 g0Var = this.f4112a.get(aVar);
            char c10 = '-';
            if (g0Var != null && (iOrdinal = g0Var.ordinal()) != 0) {
                if (iOrdinal == 1) {
                    c10 = '1';
                } else if (iOrdinal == 2) {
                    c10 = '0';
                } else if (iOrdinal == 3) {
                    c10 = '1';
                }
            }
            sb2.append(c10);
        }
        return sb2.toString();
    }

    public final String v() {
        StringBuilder sb2 = new StringBuilder("G1");
        for (a aVar : w7.STORAGE.a()) {
            sb2.append(a(this.f4112a.get(aVar)));
        }
        return sb2.toString();
    }

    public final boolean w() {
        return m(a.AD_STORAGE);
    }

    public final boolean x() {
        return m(a.ANALYTICS_STORAGE);
    }

    public final boolean y() {
        Iterator<b2.g0> it = this.f4112a.values().iterator();
        while (it.hasNext()) {
            if (it.next() != b2.g0.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    static String q(b2.g0 g0Var) {
        int iOrdinal = g0Var.ordinal();
        if (iOrdinal != 2) {
            if (iOrdinal != 3) {
                return null;
            }
            return "granted";
        }
        return "denied";
    }

    public v7(Boolean bool, Boolean bool2, int i10) {
        EnumMap<a, b2.g0> enumMap = new EnumMap<>(a.class);
        this.f4112a = enumMap;
        enumMap.put(a.AD_STORAGE, d(null));
        enumMap.put(a.ANALYTICS_STORAGE, d(null));
        this.f4113b = i10;
    }
}
