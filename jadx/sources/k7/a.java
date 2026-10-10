package k7;

import android.content.Context;
import java.util.HashMap;
import n7.d;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {
    private static String b(String str, String str2, String str3, String str4) {
        HashMap map = new HashMap();
        map.put("audid", str2);
        map.put("utdid", str);
        map.put("appkey", str3);
        map.put("appName", str4);
        return new JSONObject(d.b(map)).toString();
    }

    public static String a(String str) {
        Context contextF = j7.a.b().f();
        if (contextF == null) {
            return "";
        }
        return d.d(String.format("{\"type\":\"%s\",\"timestamp\":%s,\"data\":%s}", "audid", j7.a.b().c(), b(str, "", "", contextF.getPackageName())));
    }
}
