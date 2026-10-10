package com.live.evo.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.live.evo.R$string;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<Activity> f7179a = new ArrayList();

    public static boolean a(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
            return runningTasks != null && runningTasks.size() > 0 && str.equals(runningTasks.get(0).topActivity.getClassName());
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean b(Context context) {
        return a(context, "com.live.evo.activity.LiveNewActivity");
    }

    public static void c(Activity activity, String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 8) {
            String strSubstring = str.substring(0, 7);
            String strSubstring2 = str.substring(0, 4);
            if ("http://,https://".contains(strSubstring)) {
                Uri uri = Uri.parse(str);
                Intent intent = new Intent("android.intent.action.VIEW", uri);
                try {
                    try {
                        intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
                        activity.startActivity(intent);
                        return;
                    } catch (Exception unused) {
                        activity.startActivity(new Intent("android.intent.action.VIEW", uri));
                        return;
                    }
                } catch (Exception unused2) {
                    x1.f1.lb.util.g1.f21390a.c(activity.getString(R$string.install_browser));
                    return;
                }
            }
            if (TextUtils.equals(strSubstring2, "apk:")) {
                d.a(activity, str.substring(4));
            }
        }
    }
}
