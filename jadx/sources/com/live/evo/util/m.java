package com.live.evo.util;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class m {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static List<i5.u> f7277e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static List<Pair<String, Long>> f7279g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f7273a = System.currentTimeMillis();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f7274b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f7275c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f7276d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static List<i5.u> f7278f = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static List<Pair<String, Long>> f7280h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static List<String> f7281i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static long f7282j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static long f7283k = 0;

    public static void a(int i10, String str) {
        if (f7276d) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            f7276d = false;
            f7279g.add(new Pair<>("Total", Long.valueOf(jElapsedRealtime - f7274b)));
            if (TextUtils.equals(f7275c, "Debug Loading")) {
                f7280h = f7279g;
                f7278f = f7277e;
            }
            f7279g = null;
            f7277e = null;
        }
    }

    public static void b(String str) {
        if (f7276d && !f7281i.contains(str)) {
            f7281i.add(str);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            f7279g.add(new Pair<>(str, Long.valueOf(jElapsedRealtime)));
            f7273a = jElapsedRealtime;
        }
    }

    public static void c(String str, long j10) {
        if (f7276d) {
            f7279g.add(new Pair<>(str, Long.valueOf(j10)));
        }
    }
}
