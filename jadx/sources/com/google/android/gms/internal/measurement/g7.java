package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class g7 implements q7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SimpleArrayMap<String, SimpleArrayMap<String, String>> f2709a;

    /* JADX WARN: Code duplicated, block: B:11:0x0018 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:12:0x0019 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:13:0x001b  */
    /* JADX WARN: Code duplicated, block: B:8:0x000e  */
    /* JADX WARN: Instruction removed from duplicated block: B:13:0x001b, please report this as an issue */
    @Override // com.google.android.gms.internal.measurement.q7
    public final String a(Uri uri, String str, String str2, String str3) {
        SimpleArrayMap<String, String> simpleArrayMap;
        if (uri == null) {
            if (str == null) {
                simpleArrayMap = null;
            }
            if (simpleArrayMap == null) {
                return null;
            }
            if (str2 != null) {
                str3 = str2 + str3;
            }
            return simpleArrayMap.get(str3);
        }
        str = uri.toString();
        SimpleArrayMap<String, SimpleArrayMap<String, String>> simpleArrayMap2 = this.f2709a;
        if (simpleArrayMap2 == null) {
            simpleArrayMap = null;
        } else {
            simpleArrayMap = simpleArrayMap2.get(str);
        }
        if (simpleArrayMap == null) {
            return null;
        }
        if (str2 != null) {
            str3 = str2 + str3;
        }
        return simpleArrayMap.get(str3);
    }

    g7(SimpleArrayMap<String, SimpleArrayMap<String, String>> simpleArrayMap) {
        this.f2709a = simpleArrayMap;
    }
}
