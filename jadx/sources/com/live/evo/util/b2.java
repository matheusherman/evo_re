package com.live.evo.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.live.evo.MyApplication;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SharedPreferences f7182a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f7183b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f7184c;

    public static void a(String str, String str2, long j10) {
        if (j10 < 0) {
            return;
        }
        f7183b = str + "," + str2 + "," + j10;
        f7182a.edit().putString("play_pos", f7183b).apply();
        j1.a().b(new b5.h(Integer.valueOf(str).intValue(), Integer.valueOf(str2).intValue(), (int) j10));
    }

    public static String b() {
        if (!TextUtils.isEmpty(f7183b)) {
            return f7183b;
        }
        String string = f7182a.getString("play_pos", "0,0,0");
        f7183b = string;
        if (!string.contains(",")) {
            f7183b = "0,0," + f7183b;
        }
        return f7183b;
    }

    public static Long c(Context context) {
        return Long.valueOf(context.getSharedPreferences("recharge", 0).getLong("last_recharge_remind_time", 0L));
    }

    public static Boolean d(Context context) {
        return Boolean.valueOf(context.getSharedPreferences("first_time_key", 0).getBoolean("first_time", true));
    }

    public static void e(Context context, Boolean bool) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("first_time_key", 0).edit();
        editorEdit.putBoolean("first_time", bool.booleanValue());
        editorEdit.commit();
    }

    static {
        SharedPreferences sharedPreferences = MyApplication.a().getSharedPreferences("vod_history", 0);
        f7182a = sharedPreferences;
        String string = sharedPreferences.getString("play_pos", "");
        f7183b = string;
        if (TextUtils.isEmpty(string)) {
            f7184c = false;
            f7183b = "0,0,0";
        } else {
            f7184c = true;
        }
        if (!f7183b.contains(",")) {
            f7183b = "0,0," + f7183b;
        }
    }
}
