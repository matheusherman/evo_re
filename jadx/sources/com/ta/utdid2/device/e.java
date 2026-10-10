package com.ta.utdid2.device;

import m7.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e {
    public static boolean a(l7.a aVar) {
        String str;
        try {
            str = new String(aVar.f15221d, "UTF-8");
        } catch (Exception e10) {
            Object[] objArr = {e10};
            str = "";
            f.e("", objArr);
        }
        if (l7.a.a(str, aVar.f15220c)) {
            return b.a(b.a(str).f8383d);
        }
        return false;
    }
}
