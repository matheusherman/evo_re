package com.live.evo.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String[] f7377a = {"android.permission.WRITE_EXTERNAL_STORAGE"};

    public static boolean a(Context context, String[] strArr) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void b(Activity activity, String[] strArr, int i10) {
        ActivityCompat.requestPermissions(activity, strArr, i10);
    }
}
