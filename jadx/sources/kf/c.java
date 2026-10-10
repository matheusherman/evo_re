package kf;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c {
    private static int a(String str) {
        if (TextUtils.equals(str, "audio")) {
            return 0;
        }
        return TextUtils.equals(str, "video") ? 1 : -1;
    }

    private static String b(String str) {
        return (TextUtils.equals(str, "audio") || TextUtils.equals(str, "video")) ? "video/mp4" : "unknown";
    }

    private static boolean c(String str) {
        if (TextUtils.equals(str, "cenc")) {
            return true;
        }
        return TextUtils.equals(str, "cbcs") && Build.VERSION.SDK_INT >= 25;
    }

    public static List<b> e(String str) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.split(";")) {
            if (!TextUtils.isEmpty(str2)) {
                String[] strArrSplit = str2.split(",");
                String strB = b(strArrSplit[0]);
                String str3 = strArrSplit[1];
                String str4 = strArrSplit[2];
                String strSubstring = str4.substring(str4.lastIndexOf(":") + 1);
                String str5 = strArrSplit[3];
                int iA = a(strArrSplit[0]);
                if (!d(strB) && c(str3) && (iA == 0 || iA == 1)) {
                    arrayList.add(new b(strB, str3, d(strSubstring) ? null : UUID.fromString(strSubstring), d(str5) ? null : Base64.decode(str5, 0), iA));
                }
            }
        }
        return arrayList;
    }

    private static boolean d(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "unknown")) {
            return false;
        }
        return true;
    }
}
