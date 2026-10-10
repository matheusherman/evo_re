package com.live.evo.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class y1 extends k {
    private static List<Map<String, Set<String>>> f(Collection<String> collection, List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < collection.size(); i10++) {
            if (list.size() <= i10) {
                arrayList.add(null);
            } else {
                HashMap map = new HashMap();
                arrayList.add(map);
                HashSet hashSet = new HashSet();
                map.put("TYPE", hashSet);
                String str = list.get(i10);
                Integer numG = g(str);
                if (numG == null) {
                    hashSet.add(str);
                } else {
                    String strI = i(numG.intValue());
                    String strH = h(numG.intValue());
                    if (strI != null) {
                        hashSet.add(strI);
                    }
                    if (strH != null) {
                        hashSet.add(strH);
                    }
                }
            }
        }
        return arrayList;
    }

    private static String i(int i10) {
        if (i10 == 4 || i10 == 5) {
            return "fax";
        }
        if (i10 == 6) {
            return "pager";
        }
        if (i10 == 13) {
            return "fax";
        }
        if (i10 == 16) {
            return "textphone";
        }
        if (i10 == 18) {
            return "pager";
        }
        if (i10 != 20) {
            return null;
        }
        return "text";
    }

    private static String h(int i10) {
        if (i10 == 10 || i10 == 17 || i10 == 18) {
            return "work";
        }
        switch (i10) {
            case 1:
            case 2:
            case 5:
            case 6:
                return "home";
            case 3:
            case 4:
                return "work";
            default:
                return null;
        }
    }

    @Override // com.live.evo.util.k
    public String[] c(List<String> list, String str, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, String str2) {
        StringBuilder sb2 = new StringBuilder(100);
        sb2.append("BEGIN:VCARD");
        sb2.append('\n');
        sb2.append("VERSION:3.0");
        sb2.append('\n');
        StringBuilder sb3 = new StringBuilder(100);
        z1 z1Var = new z1();
        k.b(sb2, sb3, "N", list, 1, null, z1Var, '\n');
        k.a(sb2, sb3, "ORG", str, z1Var, '\n');
        k.b(sb2, sb3, "ADR", list2, 1, null, z1Var, '\n');
        List<Map<String, Set<String>>> listF = f(list3, list4);
        k.b(sb2, sb3, "TEL", list3, Integer.MAX_VALUE, new a2(listF), new z1(listF), '\n');
        k.b(sb2, sb3, "EMAIL", list5, Integer.MAX_VALUE, null, z1Var, '\n');
        k.b(sb2, sb3, "URL", list6, Integer.MAX_VALUE, null, z1Var, '\n');
        k.a(sb2, sb3, "NOTE", str2, z1Var, '\n');
        sb2.append("END:VCARD");
        sb2.append('\n');
        return new String[]{sb2.toString(), sb3.toString()};
    }

    y1() {
    }

    private static Integer g(String str) {
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
