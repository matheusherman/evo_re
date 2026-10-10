package z7;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tvc.lib.R$string;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class p {
    public static int a(int i10, Context context) {
        return (int) (i10 * context.getResources().getDisplayMetrics().density);
    }

    public static String b(int i10) {
        Activity activityJ = x1.f1.lb.util.c.f21341a.j();
        if (activityJ == null) {
            return "";
        }
        String string = activityJ.getString(i10);
        if (!string.contains("<font color=\"#28e193\">help@live.com</font>")) {
            return string;
        }
        String strV = t.v.c.i.a.f18646a.v();
        return TextUtils.isEmpty(strV) ? string.replace("<font color=\"#28e193\">help@live.com</font>", activityJ.getString(R$string.us)) : string.replace("help@live.com", strV);
    }
}
