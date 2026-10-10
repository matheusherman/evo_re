package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class aa {
    private static final Map<String, String> W = new HashMap();
    private static aa aq = null;
    public boolean D;
    public String E;
    public String F;
    public String G;
    public String H;
    public boolean J;
    public final SharedPreferences O;
    public final SharedPreferences P;
    private final Context X;
    private String Y;
    private String Z;

    /* JADX INFO: renamed from: aa, reason: collision with root package name */
    private String f8658aa;
    private String aj;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f8666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f8668e;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f8674k;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f8678o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f8679p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f8680q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f8681r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f8682s;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public List<String> f8685v;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8669f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f8670g = "com.tencent.bugly";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f8671h = "4.1.9.3";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f8672i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Deprecated
    public final String f8673j = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f8675l = "unknown";

    /* JADX INFO: renamed from: ab, reason: collision with root package name */
    private String f8659ab = "unknown";

    /* JADX INFO: renamed from: ac, reason: collision with root package name */
    private String f8660ac = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f8676m = 0;

    /* JADX INFO: renamed from: ad, reason: collision with root package name */
    private String f8661ad = null;

    /* JADX INFO: renamed from: ae, reason: collision with root package name */
    private long f8662ae = -1;

    /* JADX INFO: renamed from: af, reason: collision with root package name */
    private long f8663af = -1;

    /* JADX INFO: renamed from: ag, reason: collision with root package name */
    private long f8664ag = -1;
    private String ah = null;
    private String ai = null;
    private Map<String, PlugInBean> ak = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f8677n = false;
    private String al = null;
    private Boolean am = null;
    private String an = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f8683t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f8684u = null;
    private Map<String, PlugInBean> ao = null;
    private Map<String, PlugInBean> ap = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f8686w = -1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f8687x = -1;
    private final Map<String, String> ar = new HashMap();
    private final Map<String, String> as = new HashMap();
    private final Map<String, String> at = new HashMap();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f8688y = "unknown";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f8689z = 0;
    public long A = 0;
    public long B = 0;
    public long C = 0;
    public boolean I = false;
    public HashMap<String, String> K = new HashMap<>();
    public List<String> L = new ArrayList();
    public boolean M = false;
    public q N = null;
    public boolean Q = true;
    public boolean R = true;
    public boolean S = false;
    private final Object au = new Object();
    public final Object T = new Object();
    private final Object av = new Object();
    private final Object aw = new Object();
    public final Object U = new Object();
    public final Object V = new Object();
    private final Object ax = new Object();
    private final List<Integer> ay = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f8657a = System.currentTimeMillis();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f8665b = 1;

    @Deprecated
    public static boolean C() {
        al.a("Detect if the emulator is unavailable", new Object[0]);
        return false;
    }

    @Deprecated
    public static boolean D() {
        al.a("Detect if the device hook is unavailable", new Object[0]);
        return false;
    }

    public static synchronized aa b() {
        return aq;
    }

    public final synchronized Map<String, PlugInBean> A() {
        Map<String, PlugInBean> map;
        map = this.ao;
        Map<String, PlugInBean> map2 = this.ap;
        if (map2 != null) {
            map.putAll(map2);
        }
        return map;
    }

    public final boolean a() {
        boolean z10 = this.ay.size() > 0;
        al.c("isAppForeground:%s", Boolean.valueOf(z10));
        return z10;
    }

    public final void c() {
        synchronized (this.au) {
            this.Y = UUID.randomUUID().toString();
        }
    }

    public final String d() {
        String str;
        synchronized (this.au) {
            try {
                if (this.Y == null) {
                    c();
                }
                str = this.Y;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public final String e() {
        return !ap.b(this.f8668e) ? this.f8668e : this.f8681r;
    }

    public final String f() {
        String str;
        synchronized (this.V) {
            str = this.f8675l;
        }
        return str;
    }

    public final String g() {
        String str = this.f8658aa;
        if (str != null) {
            return str;
        }
        String strD = ap.d("deviceId", null);
        this.f8658aa = strD;
        if (strD != null) {
            return strD;
        }
        String strF = F();
        this.f8658aa = strF;
        if (TextUtils.isEmpty(strF)) {
            this.f8658aa = G();
        }
        String str2 = this.f8658aa;
        if (str2 == null) {
            return "";
        }
        ap.c("deviceId", str2);
        return this.f8658aa;
    }

    public final synchronized String h() {
        String str = this.Z;
        if (str != null) {
            return str;
        }
        String strD = ap.d("deviceModel", null);
        this.Z = strD;
        if (strD != null) {
            al.c("collect device model from sp:%s", strD);
            return this.Z;
        }
        if (!this.f8677n) {
            al.c("not allow collect device model", new Object[0]);
            return "fail";
        }
        String strA = ab.a();
        this.Z = strA;
        al.c("collect device model:%s", strA);
        ap.c("deviceModel", this.Z);
        return this.Z;
    }

    public final synchronized String i() {
        return this.f8660ac;
    }

    public final String o() {
        try {
            Map<String, ?> all = this.X.getSharedPreferences("BuglySdkInfos", 0).getAll();
            if (!all.isEmpty()) {
                synchronized (this.T) {
                    try {
                        for (Map.Entry<String, ?> entry : all.entrySet()) {
                            try {
                                this.K.put(entry.getKey(), entry.getValue().toString());
                            } catch (Throwable th) {
                                al.a(th);
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            al.a(th3);
        }
        if (this.K.isEmpty()) {
            al.c("SDK_INFO is empty", new Object[0]);
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry2 : this.K.entrySet()) {
            sb2.append("[");
            sb2.append(entry2.getKey());
            sb2.append(",");
            sb2.append(entry2.getValue());
            sb2.append("] ");
        }
        al.c("SDK_INFO = %s", sb2.toString());
        b("SDK_INFO", sb2.toString());
        return sb2.toString();
    }

    public final synchronized Map<String, PlugInBean> p() {
        Map<String, PlugInBean> map = this.ak;
        if (map != null && map.size() > 0) {
            HashMap map2 = new HashMap(this.ak.size());
            map2.putAll(this.ak);
            return map2;
        }
        return null;
    }

    private void E() {
        try {
            for (Map.Entry<String, ?> entry : this.P.getAll().entrySet()) {
                al.c("put reserved request data from sp, key:%s value:%s", entry.getKey(), entry.getValue());
                a(entry.getKey(), entry.getValue().toString(), false);
            }
            for (Map.Entry<String, String> entry2 : W.entrySet()) {
                al.c("put reserved request data from cache, key:%s value:%s", entry2.getKey(), entry2.getValue());
                a(entry2.getKey(), entry2.getValue(), true);
            }
            W.clear();
        } catch (Throwable th) {
            al.b(th);
        }
    }

    private String F() {
        if (TextUtils.isEmpty(this.f8661ad)) {
            this.f8661ad = ap.d("androidid", null);
        }
        return this.f8661ad;
    }

    @Deprecated
    public static String n() {
        return "";
    }

    public final void b(String str) {
        al.a("change deviceModel，old:%s new:%s", this.Z, str);
        this.Z = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ap.c("deviceModel", str);
    }

    public final long j() {
        if (this.f8662ae <= 0) {
            this.f8662ae = ab.e();
        }
        return this.f8662ae;
    }

    public final long k() {
        if (this.f8663af <= 0) {
            this.f8663af = ab.i();
        }
        return this.f8663af;
    }

    public final long l() {
        if (this.f8664ag <= 0) {
            this.f8664ag = ab.k();
        }
        return this.f8664ag;
    }

    public final String m() {
        if (!TextUtils.isEmpty(this.ai)) {
            al.c("get cpu type from so:%s", this.ai);
            return this.ai;
        }
        if (TextUtils.isEmpty(this.aj)) {
            return "unknown";
        }
        al.c("get cpu type from lib dir:%s", this.aj);
        return this.aj;
    }

    public final String q() {
        if (this.al == null) {
            this.al = ab.m();
        }
        return this.al;
    }

    public final Boolean r() {
        if (this.am == null) {
            this.am = Boolean.valueOf(ab.q());
        }
        return this.am;
    }

    public final String s() {
        if (this.an == null) {
            String str = ab.n();
            this.an = str;
            al.a("ROM ID: %s", str);
        }
        return this.an;
    }

    public final Map<String, String> t() {
        synchronized (this.av) {
            try {
                if (this.ar.size() <= 0) {
                    return null;
                }
                return new HashMap(this.ar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void u() {
        synchronized (this.av) {
            this.ar.clear();
        }
    }

    public final int v() {
        int size;
        synchronized (this.av) {
            size = this.ar.size();
        }
        return size;
    }

    public final Set<String> w() {
        Set<String> setKeySet;
        synchronized (this.av) {
            setKeySet = this.ar.keySet();
        }
        return setKeySet;
    }

    public final Map<String, String> x() {
        synchronized (this.ax) {
            try {
                if (this.as.size() <= 0) {
                    return null;
                }
                return new HashMap(this.as);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Map<String, String> y() {
        synchronized (this.aw) {
            try {
                if (this.at.size() <= 0) {
                    return null;
                }
                return new HashMap(this.at);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int z() {
        int i10;
        synchronized (this.U) {
            i10 = this.f8686w;
        }
        return i10;
    }

    private aa(Context context) {
        this.aj = null;
        this.f8678o = null;
        this.f8680q = null;
        this.f8681r = null;
        this.f8682s = null;
        this.f8685v = null;
        this.D = false;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = "";
        this.J = false;
        this.X = ap.a(context);
        PackageInfo packageInfoB = z.b(context);
        if (packageInfoB != null) {
            try {
                String str = packageInfoB.versionName;
                this.f8678o = str;
                this.E = str;
                this.F = Integer.toString(packageInfoB.versionCode);
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        this.f8666c = z.a(context);
        this.f8667d = z.a(Process.myPid());
        this.f8680q = z.c(context);
        this.f8674k = "Android " + ab.b() + ",level " + ab.c();
        Map<String, String> mapD = z.d(context);
        if (mapD != null) {
            try {
                this.f8685v = z.a(mapD);
                String str2 = mapD.get("BUGLY_APPID");
                if (str2 != null) {
                    this.f8681r = str2;
                    b("APP_ID", str2);
                }
                String str3 = mapD.get("BUGLY_APP_VERSION");
                if (str3 != null) {
                    this.f8678o = str3;
                }
                String str4 = mapD.get("BUGLY_APP_CHANNEL");
                if (str4 != null) {
                    this.f8682s = str4;
                }
                String str5 = mapD.get("BUGLY_ENABLE_DEBUG");
                if (str5 != null) {
                    this.D = str5.equalsIgnoreCase("true");
                }
                String str6 = mapD.get("com.tencent.rdm.uuid");
                if (str6 != null) {
                    this.G = str6;
                }
                String str7 = mapD.get("BUGLY_APP_BUILD_NO");
                if (!TextUtils.isEmpty(str7)) {
                    this.f8679p = Integer.parseInt(str7);
                }
                String str8 = mapD.get("BUGLY_AREA");
                if (str8 != null) {
                    this.H = str8;
                }
            } catch (Throwable th2) {
                if (!al.a(th2)) {
                    th2.printStackTrace();
                }
            }
        }
        try {
            if (!context.getDatabasePath("bugly_db_").exists()) {
                this.J = true;
                al.c("App is first time to be installed on the device.", new Object[0]);
            }
        } catch (Throwable th3) {
            if (p.f9101c) {
                th3.printStackTrace();
            }
        }
        this.O = ap.a("BUGLY_COMMON_VALUES", context);
        this.P = ap.a("BUGLY_RESERVED_VALUES", context);
        this.aj = ab.a(context);
        E();
        al.c("com info create end", new Object[0]);
    }

    public static int B() {
        return ab.c();
    }

    private static String G() {
        String string = UUID.randomUUID().toString();
        if (!ap.b(string)) {
            return string.replaceAll("-", "");
        }
        return string;
    }

    public final void a(int i10, boolean z10) {
        al.c("setActivityForeState, hash:%s isFore:%s", Integer.valueOf(i10), Boolean.valueOf(z10));
        if (z10) {
            this.ay.add(Integer.valueOf(i10));
        } else {
            this.ay.remove(Integer.valueOf(i10));
            this.ay.remove((Object) 0);
        }
        q qVar = this.N;
        if (qVar != null) {
            qVar.setNativeIsAppForeground(this.ay.size() > 0);
        }
    }

    public final synchronized void c(String str) {
        this.f8659ab = String.valueOf(str);
    }

    public final void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.ai = str.trim();
    }

    public final String f(String str) {
        String strRemove;
        if (ap.b(str)) {
            al.d("key should not be empty %s", String.valueOf(str));
            return null;
        }
        synchronized (this.av) {
            strRemove = this.ar.remove(str);
        }
        return strRemove;
    }

    public final void b(String str, String str2) {
        if (!ap.b(str) && !ap.b(str2)) {
            synchronized (this.aw) {
                this.at.put(str, str2);
            }
            return;
        }
        al.d("server key&value should not be empty %s %s", String.valueOf(str), String.valueOf(str2));
    }

    public final synchronized void d(String str) {
        this.f8660ac = String.valueOf(str);
    }

    public static synchronized aa a(Context context) {
        try {
            if (aq == null) {
                aq = new aa(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return aq;
    }

    public final String g(String str) {
        String str2;
        if (ap.b(str)) {
            al.d("key should not be empty %s", String.valueOf(str));
            return null;
        }
        synchronized (this.av) {
            str2 = this.ar.get(str);
        }
        return str2;
    }

    public final void a(String str) {
        this.f8658aa = str;
        if (!TextUtils.isEmpty(str)) {
            ap.c("deviceId", str);
        }
        synchronized (this.ax) {
            this.as.put("E8", str);
        }
    }

    public final void a(String str, String str2) {
        if (!ap.b(str) && !ap.b(str2)) {
            synchronized (this.av) {
                this.ar.put(str, str2);
            }
            return;
        }
        al.d("key&value should not be empty %s %s", String.valueOf(str), String.valueOf(str2));
    }

    private void a(String str, String str2, boolean z10) {
        if (ap.b(str)) {
            al.d("key should not be empty %s", str);
            return;
        }
        al.c("putExtraRequestData key:%s value:%s save:%s", str, str2, Boolean.valueOf(z10));
        synchronized (this.ax) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    this.as.remove(str);
                    this.P.edit().remove(str).apply();
                } else {
                    this.as.put(str, str2);
                    if (z10) {
                        this.P.edit().putString(str, str2).apply();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
