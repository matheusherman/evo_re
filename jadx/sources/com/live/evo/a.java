package com.live.evo;

import android.os.Build;
import android.os.Environment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f5181a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f5182b = Build.MODEL;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map<String, String> f5183c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Map<String, String> f5184d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f5185e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f5186f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f5187g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f5188h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f5189i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f5190j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f5191k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f5192l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f5193m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f5194n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f5195o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f5196p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f5197q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f5198r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static int f5199s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f5200t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long f5201u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static C0063a f5202v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f5203w;

    /* JADX INFO: renamed from: com.live.evo.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class C0063a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<String> f5204a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<String> f5205b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<String> f5206c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List<String> f5207d = new ArrayList();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List<String> f5208e = new ArrayList();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<String> f5209f = new ArrayList();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<String> f5210g = new ArrayList();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List<String> f5211h = new ArrayList();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public List<String> f5212i = new ArrayList();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public List<String> f5213j = new ArrayList();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public List<String> f5214k = new ArrayList();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public List<String> f5215l = new ArrayList();

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public List<String> f5216m = new ArrayList();

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public List<String> f5217n = new ArrayList();

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public List<String> f5218o = new ArrayList();

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public List<String> f5219p = new ArrayList();

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public List<String> f5220q = new ArrayList();
    }

    static {
        TimeUnit timeUnit = TimeUnit.HOURS;
        f5189i = timeUnit.toMillis(4L);
        f5190j = timeUnit.toMillis(1L) / 2;
        TimeUnit timeUnit2 = TimeUnit.MINUTES;
        f5191k = timeUnit2.toMillis(10L);
        f5192l = timeUnit.toMillis(24L);
        f5193m = timeUnit.toMillis(24L);
        f5194n = timeUnit.toMillis(24L);
        f5195o = timeUnit.toMillis(24L);
        f5196p = timeUnit.toMillis(72L);
        f5197q = timeUnit2.toMillis(5L);
        f5198r = R$mipmap.ic_launcher;
        f5199s = R$string.freetrial_app_name;
        f5200t = timeUnit.toMillis(12L);
        f5201u = timeUnit.toMillis(24L);
        f5202v = new C0063a();
        f5203w = "/data" + Environment.getDataDirectory().getAbsolutePath() + "/com.live.evo/";
    }
}
