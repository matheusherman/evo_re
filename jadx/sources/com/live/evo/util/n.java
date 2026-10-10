package com.live.evo.util;

import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import com.live.evo.MyApplication;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class n {
    public static int a(int i10) {
        return (int) (i10 * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int b() {
        return ((WindowManager) MyApplication.a().getSystemService("window")).getDefaultDisplay().getHeight();
    }

    public static Point c() {
        WindowManager windowManager = (WindowManager) MyApplication.a().getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point;
    }

    public static int d() {
        return ((WindowManager) MyApplication.a().getSystemService("window")).getDefaultDisplay().getWidth();
    }
}
