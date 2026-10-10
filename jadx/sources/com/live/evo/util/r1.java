package com.live.evo.util;

import android.content.Context;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class r1 {
    public static void b(Context context, int i10, int i11) {
        try {
            if (i11 == 1) {
                x1.f1.lb.util.g1.f21390a.c(context.getString(i10));
            } else {
                x1.f1.lb.util.g1.f21390a.e(context.getString(i10));
            }
        } catch (Throwable unused) {
        }
    }

    public static void c(Context context, String str) {
        d(context, str, 0);
    }

    public static void d(Context context, String str, int i10) {
        try {
            if (i10 == 1) {
                x1.f1.lb.util.g1.f21390a.c(str);
            } else {
                x1.f1.lb.util.g1.f21390a.e(str);
            }
        } catch (Throwable unused) {
        }
    }

    public static void e(View view, Context context, int i10, int i11) {
        if (view == null) {
            return;
        }
        int i12 = n.c().y;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (iArr[1] + view.getHeight() > i12) {
            b(context, i10, i11);
        }
    }

    public static void f(View view, Context context, String str, int i10) {
        if (view == null) {
            return;
        }
        int i11 = n.c().y;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (iArr[1] + view.getHeight() > i11) {
            d(context, str, i10);
        }
    }

    public static void a(Context context, int i10) {
        try {
            d(context, context.getString(i10), 0);
        } catch (Exception unused) {
        }
    }
}
