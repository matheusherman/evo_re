package com.live.evo.util;

import android.telephony.PhoneNumberUtils;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
abstract class k {
    static String e(String str) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return null;
        }
        return strTrim;
    }

    abstract String[] c(List<String> list, String str, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, String str2);

    static void b(StringBuilder sb2, StringBuilder sb3, String str, List<String> list, int i10, u uVar, u uVar2, char c10) {
        if (list == null) {
            return;
        }
        HashSet hashSet = new HashSet(2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            String strE = e(list.get(i12));
            if (strE != null && !strE.isEmpty() && !hashSet.contains(strE)) {
                sb2.append(str);
                sb2.append(uVar2.a(strE, i12));
                sb2.append(c10);
                sb3.append(uVar == null ? strE : uVar.a(strE, i12));
                sb3.append('\n');
                i11++;
                if (i11 == i10) {
                    return;
                } else {
                    hashSet.add(strE);
                }
            }
        }
    }

    k() {
    }

    static void a(StringBuilder sb2, StringBuilder sb3, String str, String str2, u uVar, char c10) {
        String strE = e(str2);
        if (strE != null) {
            sb2.append(str);
            sb2.append(uVar.a(strE, 0));
            sb2.append(c10);
            sb3.append(strE);
            sb3.append('\n');
        }
    }

    static String d(String str) {
        return PhoneNumberUtils.formatNumber(str);
    }
}
