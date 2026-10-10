package k7;

import android.text.TextUtils;
import m7.e;
import m7.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(n7.a.a(e.c(str.getBytes()), 2), "UTF-8");
        } catch (Exception e10) {
            f.d("", e10, new Object[0]);
            return "";
        }
    }
}
