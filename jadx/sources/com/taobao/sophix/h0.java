package com.taobao.sophix;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class h0 {
    public static int a(Context context, String str, int i10) {
        return context == null ? i10 : context.getSharedPreferences("sp_sophix", 0).getInt(str, i10);
    }

    public static void b(Context context, String str, int i10) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("sp_sophix", 0).edit();
        editorEdit.putInt(str, i10);
        if (editorEdit.commit()) {
            return;
        }
        s.e("SharedPrefUtils", "putInt fail", "key", str);
    }

    public static long a(Context context, String str, long j10) {
        return context == null ? j10 : context.getSharedPreferences("sp_sophix", 0).getLong(str, j10);
    }

    public static boolean a(Context context, String str, boolean z10) {
        return context == null ? z10 : context.getSharedPreferences("sp_sophix", 0).getBoolean(str, z10);
    }

    public static void b(Context context, String str, long j10) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("sp_sophix", 0).edit();
        editorEdit.putLong(str, j10);
        if (editorEdit.commit()) {
            return;
        }
        s.e("SharedPrefUtils", "putLong fail", "key", str);
    }

    public static String a(Context context, String str, String str2) {
        return context == null ? str2 : context.getSharedPreferences("sp_sophix", 0).getString(str, str2);
    }

    public static void a(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("sp_sophix", 0).edit();
        editorEdit.remove(str);
        if (editorEdit.commit()) {
            return;
        }
        s.e("SharedPrefUtils", "remove fail", "key", str);
    }

    public static void b(Context context, String str, boolean z10) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("sp_sophix", 0).edit();
        editorEdit.putBoolean(str, z10);
        if (editorEdit.commit()) {
            return;
        }
        s.e("SharedPrefUtils", "putBoolean fail", "key", str);
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("sp_sophix", 0).edit();
        editorEdit.clear();
        if (editorEdit.commit()) {
            return;
        }
        s.e("SharedPrefUtils", "clear fail", new Object[0]);
    }

    public static void b(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("sp_sophix", 0).edit();
        editorEdit.putString(str, str2);
        if (editorEdit.commit()) {
            return;
        }
        s.e("SharedPrefUtils", "putString fail", "key", str);
    }
}
