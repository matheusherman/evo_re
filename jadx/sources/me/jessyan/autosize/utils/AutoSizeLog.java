package me.jessyan.autosize.utils;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class AutoSizeLog {
    private static final String TAG = "AndroidAutoSize";
    private static boolean debug;

    public static void d(String str) {
        if (debug) {
            Log.d(TAG, str);
        }
    }

    public static void e(String str) {
        if (debug) {
            Log.e(TAG, str);
        }
    }

    public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean z10) {
        debug = z10;
    }

    public static void w(String str) {
        if (debug) {
            Log.w(TAG, str);
        }
    }

    private AutoSizeLog() {
        throw new IllegalStateException("you can't instantiate me!");
    }
}
