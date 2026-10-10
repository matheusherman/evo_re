package com.live.evo.util;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b0 {
    public static String a() {
        return null;
    }

    public static Map<String, String> b() {
        HashMap map = new HashMap();
        String strT = ac.g.t(a());
        if (strT != null) {
            for (String str : strT.split(",")) {
                if (ac.g.a(str, "=")) {
                    String[] strArrSplit = str.split("=");
                    map.put(strArrSplit[0], strArrSplit[1]);
                } else {
                    map.put(str, "true");
                }
            }
        }
        return map;
    }
}
