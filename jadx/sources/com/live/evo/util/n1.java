package com.live.evo.util;

import android.os.Environment;
import androidx.core.content.ContextCompat;
import com.live.evo.MyApplication;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f7288a = "tv_cinema";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f7289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f7290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f7291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f7292e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f7293f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f7294g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f7295h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f7296i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static String f7297j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static String f7298k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static String f7299l;

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        String str = File.separator;
        sb2.append(str);
        f7289b = sb2.toString();
        f7290c = f7289b + f7288a + str;
        f7291d = f7289b + ".Rxst" + str;
        f7292e = f7289b + ".Rxst" + str + "com.live.evo" + str;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(f7292e);
        sb3.append("com.live.evo");
        f7293f = sb3.toString();
        f7294g = ContextCompat.getDataDir(MyApplication.a()).getAbsolutePath() + str + f7288a + str;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(f7294g);
        sb4.append("log");
        sb4.append(str);
        f7295h = sb4.toString();
        f7296i = f7294g + "plog" + str;
        f7297j = f7294g + "crash" + str;
        f7298k = f7294g + "debugly" + str;
        f7299l = f7294g + "rdns" + str;
    }

    public static void a() {
        File file = new File(f7296i);
        File file2 = new File(f7298k);
        try {
            yb.c.k(file);
            yb.c.k(file2);
        } catch (Exception unused) {
        }
    }

    public static File b() {
        return "mounted".equals(Environment.getExternalStorageState()) ? MyApplication.a().getExternalCacheDir() : MyApplication.a().getCacheDir();
    }
}
