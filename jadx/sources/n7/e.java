package n7;

import android.os.SystemProperties;
import m7.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e {
    public static String a(String str, String str2) {
        try {
            int i10 = SystemProperties.PROP_NAME_MAX;
            return (String) SystemProperties.class.getMethod("get", String.class, String.class).invoke(SystemProperties.class, str, str2);
        } catch (Exception e10) {
            f.g("", e10, new Object[0]);
            return str2;
        }
    }
}
