package com.live.evo.util;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SharedPreferences f7389a;

    public static void a(Context context) {
        f7389a = context.getSharedPreferences("tvcinema", 0);
    }

    public static void b(String str, String str2) {
        f7389a.edit().putString(str, str2).apply();
    }
}
