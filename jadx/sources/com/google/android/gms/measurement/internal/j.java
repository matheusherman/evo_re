package com.google.android.gms.measurement.internal;

import java.util.EnumMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EnumMap<v7.a, l> f3725a;

    j() {
        this.f3725a = new EnumMap<>(v7.a.class);
    }

    public static j a(String str) {
        EnumMap enumMap = new EnumMap(v7.a.class);
        if (str.length() >= v7.a.values().length) {
            int i10 = 0;
            if (str.charAt(0) == '1') {
                v7.a[] aVarArrValues = v7.a.values();
                int length = aVarArrValues.length;
                int i11 = 1;
                while (i10 < length) {
                    enumMap.put(aVarArrValues[i10], l.f(str.charAt(i11)));
                    i10++;
                    i11++;
                }
                return new j(enumMap);
            }
        }
        return new j();
    }

    public final l b(v7.a aVar) {
        l lVar = this.f3725a.get(aVar);
        return lVar == null ? l.UNSET : lVar;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x001b  */
    public final void c(v7.a aVar, int i10) {
        l lVar = l.UNSET;
        if (i10 == -30) {
            lVar = l.TCF;
        } else if (i10 == -20) {
            lVar = l.API;
        } else if (i10 == -10) {
            lVar = l.MANIFEST;
        } else if (i10 == 0) {
            lVar = l.API;
        } else if (i10 == 30) {
            lVar = l.INITIALIZATION;
        }
        this.f3725a.put(aVar, lVar);
    }

    public final void d(v7.a aVar, l lVar) {
        this.f3725a.put(aVar, lVar);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("1");
        for (v7.a aVar : v7.a.values()) {
            l lVar = this.f3725a.get(aVar);
            if (lVar == null) {
                lVar = l.UNSET;
            }
            sb2.append(lVar.zzl);
        }
        return sb2.toString();
    }

    private j(EnumMap<v7.a, l> enumMap) {
        EnumMap<v7.a, l> enumMap2 = new EnumMap<>(v7.a.class);
        this.f3725a = enumMap2;
        enumMap2.putAll(enumMap);
    }
}
