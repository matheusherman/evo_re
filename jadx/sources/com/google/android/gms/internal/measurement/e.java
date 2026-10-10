package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final com.google.common.collect.s<String> f2620d = com.google.common.collect.s.y("_syn", "_err", "_el");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f2622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, Object> f2623c;

    public static Object c(String str, Object obj, Object obj2) {
        if (f2620d.contains(str) && (obj2 instanceof Double)) {
            return Long.valueOf(Math.round(((Double) obj2).doubleValue()));
        }
        if (str.startsWith("_")) {
            if (!(obj instanceof String) && obj != null) {
                return obj;
            }
        } else {
            if (obj instanceof Double) {
                return obj2;
            }
            if (obj instanceof Long) {
                return Long.valueOf(Math.round(((Double) obj2).doubleValue()));
            }
            if (obj instanceof String) {
                return obj2.toString();
            }
        }
        return obj2;
    }

    public final long a() {
        return this.f2622b;
    }

    public final Object b(String str) {
        if (this.f2623c.containsKey(str)) {
            return this.f2623c.get(str);
        }
        return null;
    }

    public final /* synthetic */ Object clone() {
        return new e(this.f2621a, this.f2622b, new HashMap(this.f2623c));
    }

    public final void d(String str, Object obj) {
        if (obj == null) {
            this.f2623c.remove(str);
        } else {
            this.f2623c.put(str, c(str, this.f2623c.get(str), obj));
        }
    }

    public final String e() {
        return this.f2621a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f2622b == eVar.f2622b && this.f2621a.equals(eVar.f2621a)) {
            return this.f2623c.equals(eVar.f2623c);
        }
        return false;
    }

    public final void f(String str) {
        this.f2621a = str;
    }

    public final Map<String, Object> g() {
        return this.f2623c;
    }

    public final int hashCode() {
        int iHashCode = this.f2621a.hashCode() * 31;
        long j10 = this.f2622b;
        return ((iHashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31) + this.f2623c.hashCode();
    }

    public final String toString() {
        return "Event{name='" + this.f2621a + "', timestamp=" + this.f2622b + ", params=" + String.valueOf(this.f2623c) + "}";
    }

    public e(String str, long j10, Map<String, Object> map) {
        this.f2621a = str;
        this.f2622b = j10;
        HashMap map2 = new HashMap();
        this.f2623c = map2;
        if (map != null) {
            map2.putAll(map);
        }
    }
}
